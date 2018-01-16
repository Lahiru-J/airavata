package org.apache.airavata.registry.core.repositories.appcatalog;

import org.apache.airavata.model.appcatalog.computeresource.ComputeResourceDescription;
import org.apache.airavata.model.appcatalog.computeresource.JobSubmissionProtocol;
import org.apache.airavata.model.appcatalog.gatewayprofile.ComputeResourcePreference;
import org.apache.airavata.model.appcatalog.gatewayprofile.GatewayResourceProfile;
import org.apache.airavata.model.data.movement.DataMovementProtocol;
import org.apache.airavata.registry.core.repositories.util.Initialize;
import org.apache.airavata.registry.cpi.AppCatalogException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class GatewayProfileRepositoryTest {

    private static Initialize initialize;
    private GwyResourceProfileRepository gwyResourceProfileRepository;
    private static final Logger logger = LoggerFactory.getLogger(GatewayProfileRepositoryTest.class);

    @Before
    public void setUp() {
        try {
            initialize = new Initialize("appcatalog-derby.sql");
            initialize.initializeDB();
            gwyResourceProfileRepository = new GwyResourceProfileRepository();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("********** TEAR DOWN ************");
        initialize.stopDerbyServer();
    }

    @Test
    public void gatewayProfileRepositorytest() throws AppCatalogException {
        GatewayResourceProfile gf = new GatewayResourceProfile();
        ComputeResourceRepository computeResourceRepository = new ComputeResourceRepository();
        ComputeResourceDescription cm1 = new ComputeResourceDescription();
        cm1.setHostName("localhost");
        cm1.setResourceDescription("test compute host");
        String hostId1 = computeResourceRepository.addComputeResource(cm1);

        ComputeResourceDescription cm2 = new ComputeResourceDescription();
        cm2.setHostName("localhost");
        cm2.setResourceDescription("test compute host");
        String hostId2 = computeResourceRepository.addComputeResource(cm2);

        ComputeResourcePreference preference1 = new ComputeResourcePreference();
        preference1.setComputeResourceId(hostId1);
        preference1.setOverridebyAiravata(true);
        preference1.setPreferredJobSubmissionProtocol(JobSubmissionProtocol.SSH);
        preference1.setPreferredDataMovementProtocol(DataMovementProtocol.SCP);
        preference1.setPreferredBatchQueue("queue1");
        preference1.setScratchLocation("/tmp");
        preference1.setAllocationProjectNumber("project1");

        Map<String,String> sshConfig = new HashMap<>();
        sshConfig.put("ANYTEST", "check");
        preference1.setSshAccountProvisionerConfig(sshConfig);

        ComputeResourcePreference preference2 = new ComputeResourcePreference();
        preference2.setComputeResourceId(hostId2);
        preference2.setOverridebyAiravata(true);
        preference2.setPreferredJobSubmissionProtocol(JobSubmissionProtocol.LOCAL);
        preference2.setPreferredDataMovementProtocol(DataMovementProtocol.GridFTP);
        preference2.setPreferredBatchQueue("queue2");
        preference2.setScratchLocation("/tmp");
        preference2.setAllocationProjectNumber("project2");

        List<ComputeResourcePreference> list = new ArrayList<ComputeResourcePreference>();
        list.add(preference1);
        list.add(preference2);

        gf.setGatewayID("testGateway");
        gf.setCredentialStoreToken("testCredential");
        gf.setIdentityServerPwdCredToken("pwdCredential");
        gf.setIdentityServerTenant("testTenant");
        gf.setComputeResourcePreferences(list);

        GatewayResourceProfile gf1 = new GatewayResourceProfile();
        gf1.setGatewayID("testGateway1");
        gf1.setCredentialStoreToken("testCredential");
        gf1.setIdentityServerPwdCredToken("pwdCredential");
        gf1.setIdentityServerTenant("testTenant");

        String gwId = gwyResourceProfileRepository.addGatewayResourceProfile(gf);
        GatewayResourceProfile retrievedProfile = null;
        if (gwyResourceProfileRepository.isExists(gwId)){
            retrievedProfile = gwyResourceProfileRepository.getGatewayProfile(gwId);
            System.out.println("************ gateway id ************** :" + retrievedProfile.getGatewayID());
            assertTrue("Retrieved gateway id matched", retrievedProfile.getGatewayID().equals("testGateway"));
            assertTrue(retrievedProfile.getCredentialStoreToken().equals("testCredential"));
            assertTrue(retrievedProfile.getIdentityServerPwdCredToken().equals("pwdCredential"));
            assertTrue(retrievedProfile.getIdentityServerTenant().equals("testTenant"));
        }

        gwyResourceProfileRepository.addGatewayResourceProfile(gf1);
        List<GatewayResourceProfile> getGatewayResourceList = gwyResourceProfileRepository.getAllGatewayProfiles();
        assertTrue(getGatewayResourceList.size() == 2);

        List<ComputeResourcePreference> preferences = gwyResourceProfileRepository.getAllComputeResourcePreferences(gwId);
        System.out.println("compute preferences size : " + preferences.size());
        assertTrue(preferences.size() == 2);
        if (preferences != null && !preferences.isEmpty()){
            for (ComputeResourcePreference cm : preferences){
                System.out.println("******** host id ********* : " + cm.getComputeResourceId());
                System.out.println(cm.getPreferredBatchQueue());
                System.out.println(cm.getPreferredDataMovementProtocol());
                System.out.println(cm.getPreferredJobSubmissionProtocol());
            }
        }
        computeResourceRepository.removeComputeResource(hostId1);
        computeResourceRepository.removeComputeResource(hostId2);
        gwyResourceProfileRepository.delete("testGateway");
        gwyResourceProfileRepository.delete("testGateway1");
    }

}
