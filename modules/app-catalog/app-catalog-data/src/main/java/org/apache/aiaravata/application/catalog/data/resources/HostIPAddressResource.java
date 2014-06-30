package org.apache.aiaravata.application.catalog.data.resources;

import org.airavata.appcatalog.cpi.AppCatalogException;
import org.apache.aiaravata.application.catalog.data.model.ComputeResource;
import org.apache.aiaravata.application.catalog.data.model.HostIPAddress;
import org.apache.aiaravata.application.catalog.data.model.HostIPAddressPK;
import org.apache.aiaravata.application.catalog.data.util.AppCatalogJPAUtils;
import org.apache.aiaravata.application.catalog.data.util.AppCatalogQueryGenerator;
import org.apache.aiaravata.application.catalog.data.util.AppCatalogResourceType;
import org.apache.airavata.common.exception.ApplicationSettingsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HostIPAddressResource extends AbstractResource{

    private final static Logger logger = LoggerFactory.getLogger(HostIPAddressResource.class);

    private String resourceID;
    private String ipaddress;
    private ComputeHostResource computeHostResource;

    public void remove(Object identifier) throws AppCatalogException {
        HashMap<String, String> ids;
        if (identifier instanceof Map){
            ids = (HashMap)identifier;
        }else {
            logger.error("Identifier should be a map with the field name and it's value");
            throw new AppCatalogException("Identifier should be a map with the field name and it's value");
        }

        EntityManager em = null;
        try {
            em = AppCatalogJPAUtils.getEntityManager();
            em.getTransaction().begin();
            AppCatalogQueryGenerator generator= new AppCatalogQueryGenerator(HOST_IPADDRESS);
            generator.setParameter(HostIPAddressConstants.RESOURCE_ID, ids.get(HostIPAddressConstants.RESOURCE_ID));
            generator.setParameter(HostIPAddressConstants.IP_ADDRESS, ids.get(HostIPAddressConstants.IP_ADDRESS));
            Query q = generator.deleteQuery(em);
            q.executeUpdate();
            em.getTransaction().commit();
            em.close();
        } catch (ApplicationSettingsException e) {
            logger.error(e.getMessage(), e);
            throw new AppCatalogException(e);
        } finally {
            if (em != null && em.isOpen()) {
                if (em.getTransaction().isActive()){
                    em.getTransaction().rollback();
                }
                em.close();
            }
        }

    }

    public Resource get(Object identifier) throws AppCatalogException {
        HashMap<String, String> ids;
        if (identifier instanceof Map){
            ids = (HashMap)identifier;
        }else {
            logger.error("Identifier should be a map with the field name and it's value");
            throw new AppCatalogException("Identifier should be a map with the field name and it's value");
        }

        EntityManager em = null;
        try {
            em = AppCatalogJPAUtils.getEntityManager();
            em.getTransaction().begin();
            AppCatalogQueryGenerator generator = new AppCatalogQueryGenerator(HOST_IPADDRESS);
            generator.setParameter(HostIPAddressConstants.RESOURCE_ID, ids.get(HostIPAddressConstants.RESOURCE_ID));
            generator.setParameter(HostIPAddressConstants.IP_ADDRESS, ids.get(HostIPAddressConstants.IP_ADDRESS));
            Query q = generator.selectQuery(em);
            HostIPAddress hostIPAddress = (HostIPAddress) q.getSingleResult();
            HostIPAddressResource hostIPAddressResource =
                    (HostIPAddressResource) AppCatalogJPAUtils.getResource(AppCatalogResourceType.HOST_IPADDRESS, hostIPAddress);
            em.getTransaction().commit();
            em.close();
            return hostIPAddressResource;
        } catch (ApplicationSettingsException e) {
            logger.error(e.getMessage(), e);
            throw new AppCatalogException(e);
        } finally {
            if (em != null && em.isOpen()) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
                em.close();
            }
        }
    }

    public List<Resource> get(String fieldName, Object value) throws AppCatalogException {

        List<Resource> hostIPAddressResources = new ArrayList<Resource>();
        EntityManager em = null;
        try {
            em = AppCatalogJPAUtils.getEntityManager();
            em.getTransaction().begin();
            Query q;
            AppCatalogQueryGenerator generator = new AppCatalogQueryGenerator(HOST_IPADDRESS);
            List results;
            if (fieldName.equals(HostIPAddressConstants.IP_ADDRESS)) {
                generator.setParameter(HostIPAddressConstants.IP_ADDRESS, value);
                q = generator.selectQuery(em);
                results = q.getResultList();
                if (results.size() != 0) {
                    for (Object result : results) {
                        HostIPAddress hostIPAddress = (HostIPAddress) result;
                        HostIPAddressResource hostIPAddressResource =
                                (HostIPAddressResource) AppCatalogJPAUtils.getResource(AppCatalogResourceType.HOST_IPADDRESS, hostIPAddress);
                        hostIPAddressResources.add(hostIPAddressResource);
                    }
                }
            } else if (fieldName.equals(HostIPAddressConstants.RESOURCE_ID)) {
                generator.setParameter(HostIPAddressConstants.RESOURCE_ID, value);
                q = generator.selectQuery(em);
                results = q.getResultList();
                if (results.size() != 0) {
                    for (Object result : results) {
                        HostIPAddress hostIPAddress = (HostIPAddress) result;
                        HostIPAddressResource hostIPAddressResource =
                                (HostIPAddressResource) AppCatalogJPAUtils.getResource(AppCatalogResourceType.HOST_IPADDRESS, hostIPAddress);
                        hostIPAddressResources.add(hostIPAddressResource);
                    }
                }
            } else {
                em.getTransaction().commit();
                em.close();
                logger.error("Unsupported field name for Host IPAddress Resource.", new IllegalArgumentException());
                throw new IllegalArgumentException("Unsupported field name for Host IPAddress Resource.");
            }
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new AppCatalogException(e);
        } finally {
            if (em != null && em.isOpen()) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
                em.close();
            }
        }
        return hostIPAddressResources;
    }

    public List<String> getIds(String fieldName, Object value) throws AppCatalogException {

        List<String> hostIPAddressResourceIDs = new ArrayList<String>();
        EntityManager em = null;
        try {
            em = AppCatalogJPAUtils.getEntityManager();
            em.getTransaction().begin();
            Query q;
            AppCatalogQueryGenerator generator = new AppCatalogQueryGenerator(HOST_IPADDRESS);
            List results;
            if (fieldName.equals(HostIPAddressConstants.IP_ADDRESS)) {
                generator.setParameter(HostIPAddressConstants.IP_ADDRESS, value);
                q = generator.selectQuery(em);
                results = q.getResultList();
                if (results.size() != 0) {
                    for (Object result : results) {
                        HostIPAddress hostIPAddress = (HostIPAddress) result;
                        hostIPAddressResourceIDs.add(hostIPAddress.getResourceID());
                    }
                }
            } else if (fieldName.equals(HostIPAddressConstants.RESOURCE_ID)) {
                generator.setParameter(HostIPAddressConstants.RESOURCE_ID, value);
                q = generator.selectQuery(em);
                results = q.getResultList();
                if (results.size() != 0) {
                    for (Object result : results) {
                        HostIPAddress hostIPAddress = (HostIPAddress) result;
                        hostIPAddressResourceIDs.add(hostIPAddress.getResourceID());
                    }
                }
            } else {
                em.getTransaction().commit();
                em.close();
                logger.error("Unsupported field name for Host IP Address resource.", new IllegalArgumentException());
                throw new IllegalArgumentException("Unsupported field name for Host IPAddress Resource.");
            }
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new AppCatalogException(e);
        } finally {
            if (em != null && em.isOpen()) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
                em.close();
            }
        }
        return hostIPAddressResourceIDs;
    }

    public void save() throws AppCatalogException {
        EntityManager em = null;
        try {
            em = AppCatalogJPAUtils.getEntityManager();
            HostIPAddress existingHostIP = em.find(HostIPAddress.class, new HostIPAddressPK(resourceID,ipaddress));
            em.close();

            em = AppCatalogJPAUtils.getEntityManager();
            em.getTransaction().begin();
            ComputeResource computeResource = em.find(ComputeResource.class, resourceID);
            if (existingHostIP !=  null){
                existingHostIP.setIpaddress(ipaddress);
                existingHostIP.setResourceID(resourceID);
                existingHostIP.setComputeResource(computeResource);
                em.merge(existingHostIP);
            }else {
                HostIPAddress hostIPAddress = new HostIPAddress();
                hostIPAddress.setIpaddress(ipaddress);
                hostIPAddress.setResourceID(resourceID);
                hostIPAddress.setComputeResource(computeResource);
                em.persist(hostIPAddress);
            }
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new AppCatalogException(e);
        } finally {
            if (em != null && em.isOpen()) {
                if (em.getTransaction().isActive()){
                    em.getTransaction().rollback();
                }
                em.close();
            }
        }

    }

    public boolean isExists(Object identifier) throws AppCatalogException {
        HashMap<String, String> ids;
        if (identifier instanceof Map){
            ids = (HashMap)identifier;
        }else {
            logger.error("Identifier should be a map with the field name and it's value");
            throw new AppCatalogException("Identifier should be a map with the field name and it's value");
        }

        EntityManager em = null;
        try {
            em = AppCatalogJPAUtils.getEntityManager();
            HostIPAddress hostIPAddress = em.find(HostIPAddress.class, new HostIPAddressPK(ids.get(HostIPAddressConstants.RESOURCE_ID),
                    ids.get(HostIPAddressConstants.IP_ADDRESS)));

            em.close();
            return hostIPAddress != null;
        } catch (ApplicationSettingsException e) {
            logger.error(e.getMessage(), e);
            throw new AppCatalogException(e);
        } finally {
            if (em != null && em.isOpen()) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
                em.close();
            }
        }
    }

    public String getResourceID() {
        return resourceID;
    }

    public void setResourceID(String resourceID) {
        this.resourceID = resourceID;
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    public ComputeHostResource getComputeHostResource() {
        return computeHostResource;
    }

    public void setComputeHostResource(ComputeHostResource computeHostResource) {
        this.computeHostResource = computeHostResource;
    }
}
