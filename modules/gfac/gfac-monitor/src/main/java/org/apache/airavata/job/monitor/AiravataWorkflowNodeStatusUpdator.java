/*
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
*/
package org.apache.airavata.job.monitor;

import java.util.Calendar;

import org.apache.airavata.job.monitor.event.MonitorPublisher;
import org.apache.airavata.job.monitor.state.ExperimentStatusChangeRequest;
import org.apache.airavata.job.monitor.state.WorkflowNodeStatusChangeRequest;
import org.apache.airavata.model.workspace.experiment.ExperimentState;
import org.apache.airavata.model.workspace.experiment.WorkflowNodeDetails;
import org.apache.airavata.model.workspace.experiment.WorkflowNodeState;
import org.apache.airavata.model.workspace.experiment.WorkflowNodeStatus;
import org.apache.airavata.registry.cpi.DataType;
import org.apache.airavata.registry.cpi.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.eventbus.Subscribe;

public class AiravataWorkflowNodeStatusUpdator implements AbstractActivityListener{
    private final static Logger logger = LoggerFactory.getLogger(AiravataWorkflowNodeStatusUpdator.class);

    private Registry airavataRegistry;
    
    private MonitorPublisher monitorPublisher;

    public Registry getAiravataRegistry() {
        return airavataRegistry;
    }

    public void setAiravataRegistry(Registry airavataRegistry) {
        this.airavataRegistry = airavataRegistry;
    }

    @Subscribe
    public void updateRegistry(WorkflowNodeStatusChangeRequest workflowNodeStatus) {
        WorkflowNodeState state = workflowNodeStatus.getState();
        if (state != null) {
            try {
                String workflowNodeID = workflowNodeStatus.getIdentity().getWorkflowNodeID();
                updateWorkflowNodeStatus(workflowNodeID, state);
                logger.debug("Workflow node " + workflowNodeStatus.getIdentity().getWorkflowNodeID() + " status updated to "+state.toString());
            } catch (Exception e) {
                logger.error("Error persisting data" + e.getLocalizedMessage(), e);
            }
        }
    }
    
    @Subscribe
    public void setupExperimentStatus(WorkflowNodeStatusChangeRequest nodeStatus){
    	ExperimentState state=ExperimentState.UNKNOWN;
    	switch(nodeStatus.getState()){
    	case CANCELED:
    		state=ExperimentState.CANCELED; break;
    	case COMPLETED:
    		state=ExperimentState.COMPLETED; break;
    	case INVOKED:
    		state=ExperimentState.LAUNCHED; break;
    	case FAILED:
    		state=ExperimentState.FAILED; break;
    	case EXECUTING:
    		state=ExperimentState.EXECUTING; break;
    	case CANCELING:
    		state=ExperimentState.CANCELING; break;
		default:
			break;
    	}
    	monitorPublisher.publish(new ExperimentStatusChangeRequest(nodeStatus.getIdentity(),state));
    }
    
    public  void updateWorkflowNodeStatus(String workflowNodeId, WorkflowNodeState state) throws Exception {
    	WorkflowNodeDetails details = (WorkflowNodeDetails)airavataRegistry.get(DataType.WORKFLOW_NODE_DETAIL, workflowNodeId);
        if(details == null) {
            details = new WorkflowNodeDetails();
            details.setNodeInstanceId(workflowNodeId);
        }
        WorkflowNodeStatus status = new WorkflowNodeStatus();
        status.setWorkflowNodeState(state);
        status.setTimeOfStateChange(Calendar.getInstance().getTimeInMillis());
        details.setWorkflowNodeStatus(status);
        airavataRegistry.update(org.apache.airavata.registry.cpi.DataType.WORKFLOW_NODE_DETAIL, details, workflowNodeId);
    }

	@Override
	public void setup(Object... configurations) {
		for (Object configuration : configurations) {
			if (configuration instanceof Registry){
				this.airavataRegistry=(Registry)configuration;
			} else if (configuration instanceof MonitorPublisher){
				this.monitorPublisher=(MonitorPublisher) configuration;
			} 
		}
	}
}