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
package org.apache.airavata.service.profile.gateway.core.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;

/**
 * Created by goshenoy on 3/7/17.
 */
public class GatewayResource {

    private final static Logger logger = LoggerFactory.getLogger(GatewayResource.class);

    private String gatewayId;
    private String gatewayName;
    private String domain;
    private String emailAddress;
    private String gatewayApprovalStatus;
    private String gatewayAcronym;
    private String gatewayUrl;
    private String gatewayPublicAbstract;
    private String reviewProposalDescription;
    private String gatewayAdminFirstName;
    private String getGatewayAdminLastName;
    private String gatewayAdminEmail;
    private String identityServerUserName;
    private String identityServerPasswordToken;
    private String declinedReason;
    private String oauthClientId;
    private String oauthClientSecret;
    private Timestamp requestCreationTime;
    private String requesterUsername;

    public String getGatewayId() {
        return gatewayId;
    }

    public void setGatewayId(String gatewayId) {
        this.gatewayId = gatewayId;
    }

    public String getGatewayName() {
        return gatewayName;
    }

    public void setGatewayName(String gatewayName) {
        this.gatewayName = gatewayName;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getGatewayApprovalStatus() {
        return gatewayApprovalStatus;
    }

    public void setGatewayApprovalStatus(String gatewayApprovalStatus) {
        this.gatewayApprovalStatus = gatewayApprovalStatus;
    }

    public String getGatewayAcronym() {
        return gatewayAcronym;
    }

    public void setGatewayAcronym(String gatewayAcronym) {
        this.gatewayAcronym = gatewayAcronym;
    }

    public String getGatewayUrl() {
        return gatewayUrl;
    }

    public void setGatewayUrl(String gatewayUrl) {
        this.gatewayUrl = gatewayUrl;
    }

    public String getGatewayPublicAbstract() {
        return gatewayPublicAbstract;
    }

    public void setGatewayPublicAbstract(String gatewayPublicAbstract) {
        this.gatewayPublicAbstract = gatewayPublicAbstract;
    }

    public String getReviewProposalDescription() {
        return reviewProposalDescription;
    }

    public void setReviewProposalDescription(String reviewProposalDescription) {
        this.reviewProposalDescription = reviewProposalDescription;
    }

    public String getGatewayAdminFirstName() {
        return gatewayAdminFirstName;
    }

    public void setGatewayAdminFirstName(String gatewayAdminFirstName) {
        this.gatewayAdminFirstName = gatewayAdminFirstName;
    }

    public String getGetGatewayAdminLastName() {
        return getGatewayAdminLastName;
    }

    public void setGetGatewayAdminLastName(String getGatewayAdminLastName) {
        this.getGatewayAdminLastName = getGatewayAdminLastName;
    }

    public String getGatewayAdminEmail() {
        return gatewayAdminEmail;
    }

    public void setGatewayAdminEmail(String gatewayAdminEmail) {
        this.gatewayAdminEmail = gatewayAdminEmail;
    }

    public String getIdentityServerUserName() {
        return identityServerUserName;
    }

    public void setIdentityServerUserName(String identityServerUserName) {
        this.identityServerUserName = identityServerUserName;
    }

    public String getIdentityServerPasswordToken() {
        return identityServerPasswordToken;
    }

    public void setIdentityServerPasswordToken(String identityServerPasswordToken) {
        this.identityServerPasswordToken = identityServerPasswordToken;
    }

    public String getDeclinedReason() {
        return declinedReason;
    }

    public void setDeclinedReason(String declinedReason) {
        this.declinedReason = declinedReason;
    }

    public String getOauthClientId() {
        return oauthClientId;
    }

    public void setOauthClientId(String oauthClientId) {
        this.oauthClientId = oauthClientId;
    }

    public String getOauthClientSecret() {
        return oauthClientSecret;
    }

    public void setOauthClientSecret(String oauthClientSecret) {
        this.oauthClientSecret = oauthClientSecret;
    }

    public Timestamp getRequestCreationTime() {
        return requestCreationTime;
    }

    public void setRequestCreationTime(Timestamp requestCreationTime) {
        this.requestCreationTime = requestCreationTime;
    }

    public String getRequesterUsername() {
        return requesterUsername;
    }

    public void setRequesterUsername(String requesterUsername) {
        this.requesterUsername = requesterUsername;
    }
}