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

package org.apache.airavata.rest.client;

import org.apache.airavata.common.utils.Version;
import org.apache.airavata.commons.gfac.type.ApplicationDeploymentDescription;
import org.apache.airavata.commons.gfac.type.HostDescription;
import org.apache.airavata.commons.gfac.type.ServiceDescription;
import org.apache.airavata.registry.api.*;
import org.apache.airavata.registry.api.exception.RegistryException;
import org.apache.airavata.registry.api.exception.gateway.*;
import org.apache.airavata.registry.api.exception.worker.*;
import org.apache.airavata.registry.api.workflow.*;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class RegistryClient extends AiravataRegistry2 {

    private PasswordCallback callback;
    private URI connectionURI;
    
    private BasicRegistryResourceClient basicRegistryResourceClient;
    private ConfigurationResourceClient configurationResourceClient;
    private DescriptorResourceClient descriptorResourceClient;
    private ExperimentResourceClient experimentResourceClient;
    private ProjectResourceClient projectResourceClient;
    private ProvenanceResourceClient provenanceResourceClient;
    private PublishedWorkflowResourceClient publishedWorkflowResourceClient;
    private UserWorkflowResourceClient userWorkflowResourceClient;


    public RegistryClient() {
    }

    public BasicRegistryResourceClient getBasicRegistryResourceClient() {
        return basicRegistryResourceClient;
    }

    public ConfigurationResourceClient getConfigurationResourceClient() {
        return configurationResourceClient;
    }

    public DescriptorResourceClient getDescriptorResourceClient() {
        return descriptorResourceClient;
    }

    public ExperimentResourceClient getExperimentResourceClient() {
        return experimentResourceClient;
    }

    public ProjectResourceClient getProjectResourceClient() {
        return projectResourceClient;
    }

    public ProvenanceResourceClient getProvenanceResourceClient() {
        return provenanceResourceClient;
    }

    public PublishedWorkflowResourceClient getPublishedWorkflowResourceClient() {
        return publishedWorkflowResourceClient;
    }

    public UserWorkflowResourceClient getUserWorkflowResourceClient() {
        return userWorkflowResourceClient;
    }

    public void setBasicRegistryResourceClient(BasicRegistryResourceClient basicRegistryResourceClient) {
        this.basicRegistryResourceClient = basicRegistryResourceClient;
    }

    public void setConfigurationResourceClient(ConfigurationResourceClient configurationResourceClient) {
        this.configurationResourceClient = configurationResourceClient;
    }

    public void setDescriptorResourceClient(DescriptorResourceClient descriptorResourceClient) {
        this.descriptorResourceClient = descriptorResourceClient;
    }

    public void setExperimentResourceClient(ExperimentResourceClient experimentResourceClient) {
        this.experimentResourceClient = experimentResourceClient;
    }

    public void setProjectResourceClient(ProjectResourceClient projectResourceClient) {
        this.projectResourceClient = projectResourceClient;
    }

    public void setProvenanceResourceClient(ProvenanceResourceClient provenanceResourceClient) {
        this.provenanceResourceClient = provenanceResourceClient;
    }

    public void setPublishedWorkflowResourceClient(PublishedWorkflowResourceClient publishedWorkflowResourceClient) {
        this.publishedWorkflowResourceClient = publishedWorkflowResourceClient;
    }

    public void setUserWorkflowResourceClient(UserWorkflowResourceClient userWorkflowResourceClient) {
        this.userWorkflowResourceClient = userWorkflowResourceClient;
    }

    @Override
    protected void initialize() {
        String userName = getUser().getUserName();
        callback = getCallback();
        String serviceURI = getConnectionURI().toString();
        basicRegistryResourceClient = new BasicRegistryResourceClient(userName, serviceURI, callback);
        configurationResourceClient = new ConfigurationResourceClient(userName, serviceURI,  callback);
        descriptorResourceClient = new DescriptorResourceClient(userName, serviceURI, callback);
        experimentResourceClient = new ExperimentResourceClient(userName, serviceURI, callback);
        projectResourceClient = new ProjectResourceClient(userName, serviceURI, callback);
        provenanceResourceClient = new ProvenanceResourceClient(userName, serviceURI, callback);
        publishedWorkflowResourceClient = new PublishedWorkflowResourceClient(userName, serviceURI, callback);
        userWorkflowResourceClient = new UserWorkflowResourceClient(userName,serviceURI,callback);
    }

    public Object getConfiguration(String key) {
       return getConfigurationResourceClient().getConfiguration(key);
    }

    public List<Object> getConfigurationList(String key) {
        return getConfigurationResourceClient().getConfigurationList(key);
    }

    public void setConfiguration(String key, String value, Date expire) {
        getConfigurationResourceClient().setConfiguration(key, value, expire);
    }

    public void addConfiguration(String key, String value, Date expire) {
        getConfigurationResourceClient().addConfiguration(key, value, expire);
    }

    public void removeAllConfiguration(String key) {
        getConfigurationResourceClient().removeAllConfiguration(key);
    }

    public void removeConfiguration(String key, String value) {
        getConfigurationResourceClient().removeConfiguration(key, value);
    }

    public List<URI> getGFacURIs() {
        return getConfigurationResourceClient().getGFacURIs();
    }

    public List<URI> getWorkflowInterpreterURIs() {
        return getConfigurationResourceClient().getWorkflowInterpreterURIs();
    }


    public URI getEventingServiceURI() {
        return getConfigurationResourceClient().getEventingURI();
    }


    public URI getMessageBoxURI() {
        return getConfigurationResourceClient().getMsgBoxURI();
    }


    public void addGFacURI(URI uri) {
        getConfigurationResourceClient().addGFacURI(uri);
    }


    public void addWorkflowInterpreterURI(URI uri) {
        getConfigurationResourceClient().addWFInterpreterURI(uri);
    }


    public void setEventingURI(URI uri) {
        getConfigurationResourceClient().setEventingURI(uri);
    }


    public void setMessageBoxURI(URI uri) {
        getConfigurationResourceClient().setMessageBoxURI(uri);
    }


    public void addGFacURI(URI uri, Date expire) {
        getConfigurationResourceClient().addGFacURIByDate(uri, expire);
    }


    public void addWorkflowInterpreterURI(URI uri, Date expire) {
        getConfigurationResourceClient().addWorkflowInterpreterURI(uri, expire);
    }


    public void setEventingURI(URI uri, Date expire) {
        getConfigurationResourceClient().setEventingURIByDate(uri, expire);
    }


    public void setMessageBoxURI(URI uri, Date expire) {
        getConfigurationResourceClient().setMessageBoxURIByDate(uri, expire);
    }


    public void removeGFacURI(URI uri) {
        getConfigurationResourceClient().removeGFacURI(uri);
    }


    public void removeAllGFacURI() {
        getConfigurationResourceClient().removeAllGFacURI();
    }


    public void removeWorkflowInterpreterURI(URI uri) {
        getConfigurationResourceClient().removeWorkflowInterpreterURI(uri);
    }


    public void removeAllWorkflowInterpreterURI() {
        getConfigurationResourceClient().removeAllWorkflowInterpreterURI();
    }


    public void unsetEventingURI() {
        getConfigurationResourceClient().unsetEventingURI();
    }


    public void unsetMessageBoxURI() {
        getConfigurationResourceClient().unsetMessageBoxURI();
    }


    public boolean isHostDescriptorExists(String descriptorName) throws RegistryException {
        return getDescriptorResourceClient().isHostDescriptorExists(descriptorName);
    }


    public void addHostDescriptor(HostDescription descriptor) throws DescriptorAlreadyExistsException, RegistryException {
        getDescriptorResourceClient().addHostDescriptor(descriptor);
    }


    public void updateHostDescriptor(HostDescription descriptor) throws DescriptorDoesNotExistsException, RegistryException {
        getDescriptorResourceClient().updateHostDescriptor(descriptor);
    }


    public HostDescription getHostDescriptor(String hostName) throws DescriptorDoesNotExistsException, MalformedDescriptorException, RegistryException {
        return getDescriptorResourceClient().getHostDescriptor(hostName);
    }


    public void removeHostDescriptor(String hostName) throws DescriptorDoesNotExistsException, RegistryException {
        getDescriptorResourceClient().removeHostDescriptor(hostName);
    }


    public List<HostDescription> getHostDescriptors() throws MalformedDescriptorException, RegistryException {
        return getDescriptorResourceClient().getHostDescriptors();
    }


    public ResourceMetadata getHostDescriptorMetadata(String hostName) throws DescriptorDoesNotExistsException, RegistryException {
        return null;
    }


    public boolean isServiceDescriptorExists(String descriptorName) throws RegistryException {
        return getDescriptorResourceClient().isServiceDescriptorExists(descriptorName);
    }


    public void addServiceDescriptor(ServiceDescription descriptor) throws DescriptorAlreadyExistsException, RegistryException {
       getDescriptorResourceClient().addServiceDescriptor(descriptor);
    }


    public void updateServiceDescriptor(ServiceDescription descriptor) throws DescriptorDoesNotExistsException, RegistryException {
        getDescriptorResourceClient().updateServiceDescriptor(descriptor);
    }


    public ServiceDescription getServiceDescriptor(String serviceName) throws DescriptorDoesNotExistsException, MalformedDescriptorException, RegistryException {
        return getDescriptorResourceClient().getServiceDescriptor(serviceName);
    }


    public void removeServiceDescriptor(String serviceName) throws DescriptorDoesNotExistsException, RegistryException {
        getDescriptorResourceClient().removeServiceDescriptor(serviceName);
    }


    public List<ServiceDescription> getServiceDescriptors() throws MalformedDescriptorException, RegistryException {
        return getDescriptorResourceClient().getServiceDescriptors();
    }


    public ResourceMetadata getServiceDescriptorMetadata(String serviceName) throws DescriptorDoesNotExistsException, RegistryException {
        return null;
    }


    public boolean isApplicationDescriptorExists(String serviceName, String hostName, String descriptorName) throws RegistryException {
        return getDescriptorResourceClient().isApplicationDescriptorExists(serviceName, hostName, descriptorName);
    }


    public void addApplicationDescriptor(ServiceDescription serviceDescription, HostDescription hostDescriptor, ApplicationDeploymentDescription descriptor) throws DescriptorAlreadyExistsException, RegistryException {
        getDescriptorResourceClient().addApplicationDescriptor(serviceDescription, hostDescriptor, descriptor);
    }


    public void addApplicationDescriptor(String serviceName, String hostName, ApplicationDeploymentDescription descriptor) throws DescriptorAlreadyExistsException, RegistryException {
        getDescriptorResourceClient().addApplicationDescriptor(serviceName, hostName, descriptor);
    }


    public void udpateApplicationDescriptor(ServiceDescription serviceDescription, HostDescription hostDescriptor, ApplicationDeploymentDescription descriptor) throws DescriptorDoesNotExistsException, RegistryException {
        getDescriptorResourceClient().udpateApplicationDescriptor(serviceDescription, hostDescriptor, descriptor);
    }


    public void updateApplicationDescriptor(String serviceName, String hostName, ApplicationDeploymentDescription descriptor) throws DescriptorDoesNotExistsException, RegistryException {
        getDescriptorResourceClient().updateApplicationDescriptor(serviceName, hostName, descriptor);
    }


    public ApplicationDeploymentDescription getApplicationDescriptor(String serviceName, String hostname, String applicationName) throws DescriptorDoesNotExistsException, MalformedDescriptorException, RegistryException {
        return getDescriptorResourceClient().getApplicationDescriptor(serviceName, hostname, applicationName);
    }


    public ApplicationDeploymentDescription getApplicationDescriptors(String serviceName, String hostname) throws MalformedDescriptorException, RegistryException {
        return getDescriptorResourceClient().getApplicationDescriptors(serviceName, hostname);
    }


    public Map<String, ApplicationDeploymentDescription> getApplicationDescriptors(String serviceName) throws MalformedDescriptorException, RegistryException {
        return getDescriptorResourceClient().getApplicationDescriptors(serviceName);
    }


    public Map<String[], ApplicationDeploymentDescription> getApplicationDescriptors() throws MalformedDescriptorException, RegistryException {
        return getDescriptorResourceClient().getApplicationDescriptors();
    }


    public void removeApplicationDescriptor(String serviceName, String hostName, String applicationName) throws DescriptorDoesNotExistsException, RegistryException {
        getDescriptorResourceClient().removeApplicationDescriptor(serviceName, hostName, applicationName);
    }


    public ResourceMetadata getApplicationDescriptorMetadata(String serviceName, String hostName, String applicationName) throws DescriptorDoesNotExistsException, RegistryException {
        return null;
    }


    public boolean isWorkspaceProjectExists(String projectName) throws RegistryException {
        return getProjectResourceClient().isWorkspaceProjectExists(projectName);
    }


    public boolean isWorkspaceProjectExists(String projectName, boolean createIfNotExists) throws RegistryException {
        return getProjectResourceClient().isWorkspaceProjectExists(projectName, createIfNotExists);
    }


    public void addWorkspaceProject(WorkspaceProject project) throws WorkspaceProjectAlreadyExistsException, RegistryException {
        getProjectResourceClient().addWorkspaceProject(project);
    }


    public void updateWorkspaceProject(WorkspaceProject project) throws WorkspaceProjectDoesNotExistsException, RegistryException {
        getProjectResourceClient().updateWorkspaceProject(project);
    }


    public void deleteWorkspaceProject(String projectName) throws WorkspaceProjectDoesNotExistsException, RegistryException {
        getProjectResourceClient().deleteWorkspaceProject(projectName);
    }


    public WorkspaceProject getWorkspaceProject(String projectName) throws WorkspaceProjectDoesNotExistsException, RegistryException {
        return getProjectResourceClient().getWorkspaceProject(projectName);
    }


    public List<WorkspaceProject> getWorkspaceProjects() throws RegistryException {
        return getProjectResourceClient().getWorkspaceProjects();
    }


    public void addExperiment(String projectName, AiravataExperiment experiment) throws WorkspaceProjectDoesNotExistsException, ExperimentDoesNotExistsException, RegistryException {
        getExperimentResourceClient().addExperiment(projectName, experiment);
    }


    public void removeExperiment(String experimentId) throws ExperimentDoesNotExistsException {
        getExperimentResourceClient().removeExperiment(experimentId);
    }


    public List<AiravataExperiment> getExperiments() throws RegistryException {
        return getExperimentResourceClient().getExperiments();
    }


    public List<AiravataExperiment> getExperiments(String projectName) throws RegistryException {
        return getExperimentResourceClient().getExperiments(projectName);
    }


    public List<AiravataExperiment> getExperiments(Date from, Date to) throws RegistryException {
        return getExperimentResourceClient().getExperiments(from, to);
    }


    public List<AiravataExperiment> getExperiments(String projectName, Date from, Date to) throws RegistryException {
        return getExperimentResourceClient().getExperiments(projectName, from, to);
    }


    public boolean isExperimentExists(String experimentId) throws RegistryException {
        return getExperimentResourceClient().isExperimentExists(experimentId);
    }


    public boolean isExperimentExists(String experimentId, boolean createIfNotPresent) throws RegistryException {
        return getExperimentResourceClient().isExperimentExists(experimentId, createIfNotPresent);
    }


    public void updateExperimentExecutionUser(String experimentId, String user) throws RegistryException {
        getProvenanceResourceClient().updateExperimentExecutionUser(experimentId, user);
    }


    public String getExperimentExecutionUser(String experimentId) throws RegistryException {
        return getProvenanceResourceClient().getExperimentExecutionUser(experimentId);
    }


    public boolean isExperimentNameExist(String experimentName) throws RegistryException {
        return getProvenanceResourceClient().isExperimentNameExist(experimentName);
    }


    public String getExperimentName(String experimentId) throws RegistryException {
        return getProvenanceResourceClient().getExperimentName(experimentId);
    }


    public void updateExperimentName(String experimentId, String experimentName) throws RegistryException {
        getProvenanceResourceClient().updateExperimentName(experimentId, experimentName);
    }


    public String getExperimentMetadata(String experimentId) throws RegistryException {
        return getProvenanceResourceClient().getExperimentMetadata(experimentId);
    }


    public void updateExperimentMetadata(String experimentId, String metadata) throws RegistryException {
        getProvenanceResourceClient().updateExperimentMetadata(experimentId, metadata);
    }


    public String getWorkflowExecutionTemplateName(String workflowInstanceId) throws RegistryException {
        return getProvenanceResourceClient().getWorkflowExecutionTemplateName(workflowInstanceId);
    }


    public void setWorkflowInstanceTemplateName(String workflowInstanceId, String templateName) throws RegistryException {
        getProvenanceResourceClient().setWorkflowInstanceTemplateName(workflowInstanceId, templateName);
    }


    public List<WorkflowInstance> getExperimentWorkflowInstances(String experimentId) throws RegistryException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }


    public boolean isWorkflowInstanceExists(String instanceId) throws RegistryException {
        return getProvenanceResourceClient().isWorkflowInstanceExists(instanceId);
    }


    public boolean isWorkflowInstanceExists(String instanceId, boolean createIfNotPresent) throws RegistryException {
        return getProvenanceResourceClient().isWorkflowInstanceExists(instanceId, createIfNotPresent);
    }


    public void updateWorkflowInstanceStatus(String instanceId, WorkflowInstanceStatus.ExecutionStatus status) throws RegistryException {
        getProvenanceResourceClient().updateWorkflowInstanceStatus(instanceId, status);
    }


    public void updateWorkflowInstanceStatus(WorkflowInstanceStatus status) throws RegistryException {
        getProvenanceResourceClient().updateWorkflowInstanceStatus(status);
    }


    public WorkflowInstanceStatus getWorkflowInstanceStatus(String instanceId) throws RegistryException {
        return getProvenanceResourceClient().getWorkflowInstanceStatus(instanceId);
    }


    public void updateWorkflowNodeInput(WorkflowInstanceNode node, String data) throws RegistryException {
        getProvenanceResourceClient().updateWorkflowNodeInput(node, data);
    }


    public void updateWorkflowNodeOutput(WorkflowInstanceNode node, String data) throws RegistryException {
        getProvenanceResourceClient().updateWorkflowNodeOutput(node, data);
    }


    public List<WorkflowNodeIOData> searchWorkflowInstanceNodeInput(String experimentIdRegEx, String workflowNameRegEx, String nodeNameRegEx) throws RegistryException {
        return getProvenanceResourceClient().searchWorkflowInstanceNodeInput(experimentIdRegEx, workflowNameRegEx, nodeNameRegEx);
    }


    public List<WorkflowNodeIOData> searchWorkflowInstanceNodeOutput(String experimentIdRegEx, String workflowNameRegEx, String nodeNameRegEx) throws RegistryException {
        return getProvenanceResourceClient().searchWorkflowInstanceNodeOutput(experimentIdRegEx, workflowNameRegEx, nodeNameRegEx);
    }


    public List<WorkflowNodeIOData> getWorkflowInstanceNodeInput(String workflowInstanceId, String nodeType) throws RegistryException {
        return getProvenanceResourceClient().getWorkflowInstanceNodeInput(workflowInstanceId, nodeType);
    }


    public List<WorkflowNodeIOData> getWorkflowInstanceNodeOutput(String workflowInstanceId, String nodeType) throws RegistryException {
        return getProvenanceResourceClient().getWorkflowInstanceNodeOutput(workflowInstanceId, nodeType);
    }


    public void saveWorkflowExecutionOutput(String experimentId, String outputNodeName, String output) throws RegistryException {
        getProvenanceResourceClient().saveWorkflowExecutionOutput(experimentId, outputNodeName, output);
    }


    public void saveWorkflowExecutionOutput(String experimentId, WorkflowIOData data) throws RegistryException {
        getProvenanceResourceClient().saveWorkflowExecutionOutput(experimentId, data);
    }


    public WorkflowIOData getWorkflowExecutionOutput(String experimentId, String outputNodeName) throws RegistryException {
        return getProvenanceResourceClient().getWorkflowExecutionOutput(experimentId, outputNodeName);
    }


    public List<WorkflowIOData> getWorkflowExecutionOutput(String experimentId) throws RegistryException {
        return getProvenanceResourceClient().getWorkflowExecutionOutput(experimentId);
    }


    public String[] getWorkflowExecutionOutputNames(String exeperimentId) throws RegistryException {
        return getProvenanceResourceClient().getWorkflowExecutionOutputNames(exeperimentId);
    }


    public ExperimentData getExperiment(String experimentId) throws RegistryException {
        return getProvenanceResourceClient().getExperiment(experimentId);
    }


    public ExperimentData getExperimentMetaInformation(String experimentId) throws RegistryException {
        return getProvenanceResourceClient().getExperimentMetaInformation(experimentId);
    }


    public List<ExperimentData> getAllExperimentMetaInformation(String user) throws RegistryException {
        return getProvenanceResourceClient().getAllExperimentMetaInformation(user);
    }


    public List<ExperimentData> searchExperiments(String user, String experimentNameRegex) throws RegistryException {
        return getProvenanceResourceClient().searchExperiments(user, experimentNameRegex);
    }


    public List<String> getExperimentIdByUser(String user) throws RegistryException {
        return getProvenanceResourceClient().getExperimentIdByUser(user);
    }


    public List<ExperimentData> getExperimentByUser(String user) throws RegistryException {
        return getProvenanceResourceClient().getExperimentByUser(user);
    }


    public List<ExperimentData> getExperimentByUser(String user, int pageSize, int pageNo) throws RegistryException {
        return getProvenanceResourceClient().getExperimentByUser(user, pageSize, pageNo);
    }


    public void updateWorkflowNodeStatus(WorkflowInstanceNodeStatus workflowStatusNode) throws RegistryException {
        getProvenanceResourceClient().updateWorkflowNodeStatus(workflowStatusNode);
    }


    public void updateWorkflowNodeStatus(String workflowInstanceId, String nodeId, WorkflowInstanceStatus.ExecutionStatus status) throws RegistryException {
        getProvenanceResourceClient().updateWorkflowNodeStatus(workflowInstanceId, nodeId, status);
    }


    public void updateWorkflowNodeStatus(WorkflowInstanceNode workflowNode, WorkflowInstanceStatus.ExecutionStatus status) throws RegistryException {
        getProvenanceResourceClient().updateWorkflowNodeStatus(workflowNode, status);
    }


    public WorkflowInstanceNodeStatus getWorkflowNodeStatus(WorkflowInstanceNode workflowNode) throws RegistryException {
        return getProvenanceResourceClient().getWorkflowNodeStatus(workflowNode);
    }


    public Date getWorkflowNodeStartTime(WorkflowInstanceNode workflowNode) throws RegistryException {
        return getProvenanceResourceClient().getWorkflowNodeStartTime(workflowNode);
    }


    public Date getWorkflowStartTime(WorkflowInstance workflowInstance) throws RegistryException {
        return getProvenanceResourceClient().getWorkflowStartTime(workflowInstance);
    }


    public void updateWorkflowNodeGramData(WorkflowNodeGramData workflowNodeGramData) throws RegistryException {
        getProvenanceResourceClient().updateWorkflowNodeGramData(workflowNodeGramData);
    }


    public WorkflowInstanceData getWorkflowInstanceData(String workflowInstanceId) throws RegistryException {
        return getProvenanceResourceClient().getWorkflowInstanceData(workflowInstanceId);
    }


    public boolean isWorkflowInstanceNodePresent(String workflowInstanceId, String nodeId) throws RegistryException {
        return getProvenanceResourceClient().isWorkflowInstanceNodePresent(workflowInstanceId, nodeId);
    }


    public boolean isWorkflowInstanceNodePresent(String workflowInstanceId, String nodeId, boolean createIfNotPresent) throws RegistryException {
        return getProvenanceResourceClient().isWorkflowInstanceNodePresent(workflowInstanceId, nodeId, createIfNotPresent);
    }


    public WorkflowInstanceNodeData getWorkflowInstanceNodeData(String workflowInstanceId, String nodeId) throws RegistryException {
        return getProvenanceResourceClient().getWorkflowInstanceNodeData(workflowInstanceId, nodeId);
    }


    public void addWorkflowInstance(String experimentId, String workflowInstanceId, String templateName) throws RegistryException {
        getProvenanceResourceClient().addWorkflowInstance(experimentId, workflowInstanceId, templateName);
    }


    public void updateWorkflowNodeType(WorkflowInstanceNode node, WorkflowNodeType type) throws RegistryException {
        getProvenanceResourceClient().updateWorkflowNodeType(node, type);
    }


    public void addWorkflowInstanceNode(String workflowInstance, String nodeId) throws RegistryException {
        getProvenanceResourceClient().addWorkflowInstanceNode(workflowInstance, nodeId);
    }


    public boolean isPublishedWorkflowExists(String workflowName) throws RegistryException {
        return getPublishedWorkflowResourceClient().isPublishedWorkflowExists(workflowName);
    }


    public void publishWorkflow(String workflowName, String publishWorkflowName) throws PublishedWorkflowAlreadyExistsException, UserWorkflowDoesNotExistsException, RegistryException {
        getPublishedWorkflowResourceClient().publishWorkflow(workflowName, publishWorkflowName);
    }


    public void publishWorkflow(String workflowName) throws PublishedWorkflowAlreadyExistsException, UserWorkflowDoesNotExistsException, RegistryException {
        getPublishedWorkflowResourceClient().publishWorkflow(workflowName);
    }


    public String getPublishedWorkflowGraphXML(String workflowName) throws PublishedWorkflowDoesNotExistsException, RegistryException {
        return getPublishedWorkflowResourceClient().getPublishedWorkflowGraphXML(workflowName);
    }


    public List<String> getPublishedWorkflowNames() throws RegistryException {
        return getPublishedWorkflowResourceClient().getPublishedWorkflowNames();
    }


    public Map<String, String> getPublishedWorkflows() throws RegistryException {
        return getPublishedWorkflowResourceClient().getPublishedWorkflows();
    }


    public ResourceMetadata getPublishedWorkflowMetadata(String workflowName) throws RegistryException {
        return getPublishedWorkflowResourceClient().getPublishedWorkflowMetadata(workflowName);
    }


    public void removePublishedWorkflow(String workflowName) throws PublishedWorkflowDoesNotExistsException, RegistryException {
        getUserWorkflowResourceClient().removeWorkflow(workflowName);
    }


    public boolean isWorkflowExists(String workflowName) throws RegistryException {
        return getUserWorkflowResourceClient().isWorkflowExists(workflowName);
    }


    public void addWorkflow(String workflowName, String workflowGraphXml) throws UserWorkflowAlreadyExistsException, RegistryException {
        getUserWorkflowResourceClient().addWorkflow(workflowName, workflowGraphXml);
    }


    public void updateWorkflow(String workflowName, String workflowGraphXml) throws UserWorkflowDoesNotExistsException, RegistryException {
        getUserWorkflowResourceClient().updateWorkflow(workflowName, workflowGraphXml);
    }


    public String getWorkflowGraphXML(String workflowName) throws UserWorkflowDoesNotExistsException, RegistryException {
        return getUserWorkflowResourceClient().getWorkflowGraphXML(workflowName);
    }


    public Map<String, String> getWorkflows() throws RegistryException {
        return getUserWorkflowResourceClient().getWorkflows();
    }


    public ResourceMetadata getWorkflowMetadata(String workflowName) throws RegistryException {
        return getUserWorkflowResourceClient().getWorkflowMetadata(workflowName);
    }


    public void removeWorkflow(String workflowName) throws UserWorkflowDoesNotExistsException, RegistryException {
        getUserWorkflowResourceClient().removeWorkflow(workflowName);
    }


    public void setAiravataRegistry(AiravataRegistry2 registry) {
    }


    public void setAiravataUser(AiravataUser user) {
        getBasicRegistryResourceClient().setUser(user);
    }


    public AiravataUser getAiravataUser() {
        return getBasicRegistryResourceClient().getUser();
    }


    public boolean isActive() {
        return false;
    }


    public Version getVersion() {
        return getBasicRegistryResourceClient().getVersion();
    }

    public void setConnectionURI(URI connectionURI) {
        this.connectionURI = connectionURI;
    }

    public URI getConnectionURI() {
		return connectionURI;
	}


	public void setCallback(PasswordCallback callback) {
		this.callback=callback;
	}


	public PasswordCallback getCallback() {
		return callback;
	}
}
