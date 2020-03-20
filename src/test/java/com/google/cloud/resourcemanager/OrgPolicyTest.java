/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.resourcemanager;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;

import com.google.api.services.cloudresourcemanager.model.RestoreDefault;
import java.util.Arrays;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class OrgPolicyTest {
  private static final String CONSTRAINTS_NAME = "constraints/serviceuser.services";
  private static final String ETAG = "abcd12";
  private static final String UPDATE_TIME = "014-10-02T15:01:23.045123456Z";
  private static final Integer VERSION = 1;
  private static final OrgPolicyInfo.BooleanPolicy BOOLEAN_POLICY =
      new OrgPolicyInfo.BooleanPolicy(true);
  private static final OrgPolicyInfo.ListPolicy LIST_POLICY =
      new OrgPolicyInfo.ListPolicy(
          "allvaluse",
          Arrays.asList("allowedValue-1", "allowedValue-2"),
          Arrays.asList("deniedValue-1", "deniedValue-2"),
          true,
          "suggestedValue");

  private ResourceManager serviceMockReturnsOptions = createStrictMock(ResourceManager.class);
  private ResourceManagerOptions mockOptions = createMock(ResourceManagerOptions.class);
  private ResourceManager resourceManager;
  private OrgPolicy expectedOrgPolicy;
  private RestoreDefault restoreDefault;
  private OrgPolicyInfo orgPolicyInfo;

  @Before
  public void setUp() {
    resourceManager = createStrictMock(ResourceManager.class);
    restoreDefault = new RestoreDefault();
    restoreDefault.set("fields", String.class);
    orgPolicyInfo =
        OrgPolicyInfo.newBuilder()
            .setBooleanPolicy(BOOLEAN_POLICY)
            .setConstraint(CONSTRAINTS_NAME)
            .setListPolicy(LIST_POLICY)
            .setRestoreDefault(restoreDefault)
            .setEtag(ETAG)
            .setUpdateTime(UPDATE_TIME)
            .setVersion(VERSION)
            .build();
  }

  @After
  public void tearDown() {
    verify(resourceManager);
  }

  private void initializeExpectedOrgPolicy(int optionsCalls) {
    expect(serviceMockReturnsOptions.getOptions()).andReturn(mockOptions).times(optionsCalls);
    replay(serviceMockReturnsOptions);
    expectedOrgPolicy =
        new OrgPolicy(serviceMockReturnsOptions, new OrgPolicyInfo.BuilderImpl(orgPolicyInfo));
  }

  @Test
  public void testToBuilder() {
    initializeExpectedOrgPolicy(4);
    replay(resourceManager);
    compareOrgPolicy(expectedOrgPolicy, expectedOrgPolicy.toBuilder().build());
  }

  @Test
  public void testFromPb() {
    initializeExpectedOrgPolicy(2);
    expect(resourceManager.getOptions()).andReturn(mockOptions).times(2);
    replay(resourceManager);
    compareOrgPolicy(
        expectedOrgPolicy, OrgPolicy.fromPb(resourceManager, expectedOrgPolicy.toPb()));
  }

  @Test
  public void testBuilder() {
    expect(resourceManager.getOptions()).andReturn(mockOptions).times(4);
    replay(resourceManager);
    OrgPolicy.Builder builder =
        new OrgPolicy.Builder(
            new OrgPolicy(resourceManager, new OrgPolicyInfo.BuilderImpl(orgPolicyInfo)));
    OrgPolicy orgPolicy =
        builder
            .setBooleanPolicy(BOOLEAN_POLICY)
            .setConstraint(CONSTRAINTS_NAME)
            .setListPolicy(LIST_POLICY)
            .setRestoreDefault(restoreDefault)
            .setEtag(ETAG)
            .setUpdateTime(UPDATE_TIME)
            .setVersion(VERSION)
            .build();
    assertEquals(CONSTRAINTS_NAME, orgPolicy.getConstraint());
    assertEquals(BOOLEAN_POLICY, orgPolicy.getBooleanPolicy());
    assertEquals(LIST_POLICY, orgPolicy.getListPolicy());
    assertEquals(restoreDefault, orgPolicy.getRestoreDefault());
    assertEquals(UPDATE_TIME, orgPolicy.getUpdateTime());
    assertEquals(VERSION, orgPolicy.getVersion());
    assertEquals(resourceManager.getOptions(), orgPolicy.getResourceManager().getOptions());
  }

  @Test
  public void testResourceManager() {
    initializeExpectedOrgPolicy(1);
    replay(resourceManager);
    assertEquals(serviceMockReturnsOptions, expectedOrgPolicy.getResourceManager());
  }

  private void compareOrgPolicy(OrgPolicy expected, OrgPolicy value) {
    assertEquals(expected, value);
    compareOrgPolicyInfo(expected, value);
    assertEquals(
        expected.getResourceManager().getOptions(), value.getResourceManager().getOptions());
  }

  private void compareOrgPolicyInfo(OrgPolicyInfo expected, OrgPolicyInfo value) {
    assertEquals(expected, value);
    assertEquals(expected.hashCode(), value.hashCode());
    assertEquals(expected.getConstraint(), value.getConstraint());
    assertEquals(expected.getBooleanPolicy(), value.getBooleanPolicy());
    assertEquals(expected.getBooleanPolicy().toString(), value.getBooleanPolicy().toString());
    assertEquals(expected.getListPolicy(), value.getListPolicy());
    assertEquals(expected.getRestoreDefault(), value.getRestoreDefault());
    assertEquals(expected.getUpdateTime(), value.getUpdateTime());
    assertEquals(expected.getVersion(), value.getVersion());
  }
}
