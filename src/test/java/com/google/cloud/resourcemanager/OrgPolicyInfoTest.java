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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class OrgPolicyInfoTest {

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
  private static final OrgPolicyInfo ORG_POLICY_INFO =
      OrgPolicy.newBuilder()
          .setBooleanPolicy(BOOLEAN_POLICY)
          .setConstraint(CONSTRAINTS_NAME)
          .setListPolicy(LIST_POLICY)
          .setEtag(ETAG)
          .setUpdateTime(UPDATE_TIME)
          .setVersion(VERSION)
          .build();

  @Test
  public void testBuilder() {
    assertEquals(CONSTRAINTS_NAME, ORG_POLICY_INFO.getConstraint());
    assertEquals(BOOLEAN_POLICY, ORG_POLICY_INFO.getBooleanPolicy());
    assertEquals(LIST_POLICY, ORG_POLICY_INFO.getListPolicy());
    assertEquals(UPDATE_TIME, ORG_POLICY_INFO.getUpdateTime());
    assertEquals(VERSION, ORG_POLICY_INFO.getVersion());
  }

  @Test
  public void testToBuilder() {
    compareLiens(ORG_POLICY_INFO, ORG_POLICY_INFO.toBuilder().build());
  }

  @Test
  public void testToAndFromPb() {
    assertTrue(ORG_POLICY_INFO.toPb().getUpdateTime().endsWith("Z"));
    compareLiens(ORG_POLICY_INFO, ORG_POLICY_INFO.fromPb(ORG_POLICY_INFO.toPb()));
  }

  @Test
  public void testEquals() {
    compareLiens(
        ORG_POLICY_INFO,
        OrgPolicyInfo.newBuilder()
            .setBooleanPolicy(BOOLEAN_POLICY)
            .setConstraint(CONSTRAINTS_NAME)
            .setListPolicy(LIST_POLICY)
            .setEtag(ETAG)
            .setUpdateTime(UPDATE_TIME)
            .setVersion(VERSION)
            .build());
    compareLiens(ORG_POLICY_INFO, new OrgPolicyInfo.BuilderImpl(ORG_POLICY_INFO).build());
  }

  private void compareLiens(OrgPolicyInfo expected, OrgPolicyInfo value) {
    assertEquals(expected.getConstraint(), value.getConstraint());
    assertEquals(expected.getBooleanPolicy(), value.getBooleanPolicy());
    assertEquals(expected.getListPolicy(), value.getListPolicy());
    assertEquals(expected.getUpdateTime(), value.getUpdateTime());
    assertEquals(expected.getVersion(), value.getVersion());
  }
}
