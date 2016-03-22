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

package org.apache.airavata.registry.core.data.catalog.impl;

import org.apache.airavata.model.data.product.DataProductModel;
import org.apache.airavata.model.data.product.DataReplicaLocationModel;
import org.apache.airavata.registry.core.data.catalog.model.DataProduct;
import org.apache.airavata.registry.core.data.catalog.model.DataReplicaLocation;
import org.apache.airavata.registry.core.data.catalog.utils.DataCatalogJPAUtils;
import org.apache.airavata.registry.core.data.catalog.utils.ThriftDataModelConversion;
import org.apache.airavata.registry.cpi.DataCatalog;
import org.apache.airavata.registry.cpi.DataCatalogException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DataCatalogImpl implements DataCatalog {

    private final static Logger logger = LoggerFactory.getLogger(DataCatalogImpl.class);

    @Override
    public String registerDataProduct(DataProductModel productModel) throws DataCatalogException {
        String productUri = UUID.randomUUID().toString();
        productModel.setProductUri(productUri);
        long currentTime = System.currentTimeMillis();
        productModel.setCreationTime(currentTime);
        productModel.setLastModifiedTime(currentTime);
        if(productModel.getReplicaLocations() != null){
            productModel.getReplicaLocations().stream().forEach(r-> {
                r.setProductUri(productUri);
                r.setReplicaId(UUID.randomUUID().toString());
                r.setCreationTime(currentTime);
                r.setLastModifiedTime(currentTime);
            });
        }
        productModel.setCreationTime(System.currentTimeMillis());
        productModel.setLastModifiedTime(System.currentTimeMillis());
        DataProduct dataProduct = ThriftDataModelConversion.getDataProduct(productModel);
        EntityManager em = null;
        try {
            em = DataCatalogJPAUtils.getEntityManager();
            em.getTransaction().begin();
            em.persist(dataProduct);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new DataCatalogException(e);
        } finally {
            if (em != null && em.isOpen()) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
                em.close();
            }
        }
        return productUri;
    }

    @Override
    public boolean removeDataProduct(String productUri) throws DataCatalogException {
        EntityManager em = null;
        try {
            em = DataCatalogJPAUtils.getEntityManager();
            DataProduct dataProduct = em.find(DataProduct.class, productUri);
            if(dataProduct == null)
                return false;
            em.getTransaction().begin();
            em.remove(dataProduct);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new DataCatalogException(e);
        } finally {
            if (em != null && em.isOpen()) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
                em.close();
            }
        }
        return true;
    }

    @Override
    public boolean updateDataProduct(DataProductModel productModel) throws DataCatalogException {
        EntityManager em = null;
        try {
            em = DataCatalogJPAUtils.getEntityManager();
            DataProduct dataProduct = em.find(DataProduct.class, productModel.getProductUri());
            if(dataProduct == null)
                return false;
            em.getTransaction().begin();
            productModel.setCreationTime(dataProduct.getCreationTime().getTime());
            productModel.setLastModifiedTime(System.currentTimeMillis());
            em.merge(ThriftDataModelConversion.getUpdatedDataProduct(productModel, dataProduct));
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new DataCatalogException(e);
        } finally {
            if (em != null && em.isOpen()) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
                em.close();
            }
        }
        return true;
    }

    @Override
    public DataProductModel getDataProduct(String productUri) throws DataCatalogException {
        EntityManager em = null;
        try {
            em = DataCatalogJPAUtils.getEntityManager();
            DataProduct dataProduct = em.find(DataProduct.class, productUri);
            return ThriftDataModelConversion.getDataProductModel(dataProduct);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new DataCatalogException(e);
        } finally {
            if (em != null && em.isOpen()) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
                em.close();
            }
        }
    }

    @Override
    public String registerReplicaLocation(DataReplicaLocationModel dataReplicaLocationModel) throws DataCatalogException {
        String replicaId = UUID.randomUUID().toString();
        dataReplicaLocationModel.setReplicaId(replicaId);
        long currentTime = System.currentTimeMillis();
        dataReplicaLocationModel.setCreationTime(currentTime);
        dataReplicaLocationModel.setLastModifiedTime(currentTime);
        dataReplicaLocationModel.setCreationTime(System.currentTimeMillis());
        dataReplicaLocationModel.setLastModifiedTime(System.currentTimeMillis());
        DataReplicaLocation replicaLocation = ThriftDataModelConversion.getDataReplicaLocation(dataReplicaLocationModel);
        EntityManager em = null;
        try {
            em = DataCatalogJPAUtils.getEntityManager();
            em.getTransaction().begin();
            em.persist(replicaLocation);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new DataCatalogException(e);
        } finally {
            if (em != null && em.isOpen()) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
                em.close();
            }
        }
        return replicaId;
    }

    @Override
    public boolean removeReplicaLocation(String replicaId) throws DataCatalogException {
        EntityManager em = null;
        try {
            em = DataCatalogJPAUtils.getEntityManager();
            DataReplicaLocation replicaLocation = em.find(DataReplicaLocation.class, replicaId);
            if(replicaLocation == null)
                return false;
            em.getTransaction().begin();
            em.remove(replicaLocation);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new DataCatalogException(e);
        } finally {
            if (em != null && em.isOpen()) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
                em.close();
            }
        }
        return true;
    }

    @Override
    public boolean updateReplicaLocation(DataReplicaLocationModel dataReplicaLocationModel) throws DataCatalogException {
        EntityManager em = null;
        try {
            em = DataCatalogJPAUtils.getEntityManager();
            DataReplicaLocation dataReplicaLocation = em.find(DataReplicaLocation.class, dataReplicaLocationModel.getReplicaId());
            if(dataReplicaLocation == null)
                return false;
            em.getTransaction().begin();
            dataReplicaLocationModel.setCreationTime(dataReplicaLocation.getCreationTime().getTime());
            dataReplicaLocationModel.setLastModifiedTime(System.currentTimeMillis());
            em.merge(ThriftDataModelConversion.getUpdatedDataReplicaLocation(dataReplicaLocationModel, dataReplicaLocation));
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new DataCatalogException(e);
        } finally {
            if (em != null && em.isOpen()) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
                em.close();
            }
        }
        return true;
    }

    @Override
    public DataReplicaLocationModel getReplicaLocation(String replicaId) throws DataCatalogException {
        EntityManager em = null;
        try {
            em = DataCatalogJPAUtils.getEntityManager();
            DataReplicaLocation replicaLocation = em.find(DataReplicaLocation.class, replicaId);
            return ThriftDataModelConversion.getDataReplicaLocationModel(replicaLocation);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new DataCatalogException(e);
        } finally {
            if (em != null && em.isOpen()) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
                em.close();
            }
        }
    }

    @Override
    public List<DataReplicaLocationModel> getAllReplicaLocations(String
                                                                             productUri) throws DataCatalogException {
        EntityManager em = null;
        try {
            em = DataCatalogJPAUtils.getEntityManager();
            DataProduct dataProduct = em.find(DataProduct.class, productUri);
            if(dataProduct == null)
                return null;
            ArrayList<DataReplicaLocationModel> dataReplicaLocationModels = new ArrayList<>();
            dataProduct.getDataReplicaLocations().stream().forEach(rl->dataReplicaLocationModels
                    .add(ThriftDataModelConversion.getDataReplicaLocationModel(rl)));
            return dataReplicaLocationModels;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new DataCatalogException(e);
        } finally {
            if (em != null && em.isOpen()) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
                em.close();
            }
        }
    }
}
