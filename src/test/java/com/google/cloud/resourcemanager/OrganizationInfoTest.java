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

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class OrganizationInfoTest {

  private static final Long ORGANIZATION_CREATE_TIME = 123456789L;
  private static final String ORGANIZATION_NAME = "organizations/1234";
  private static final String ORGANIZATION_DISPLAY_NAME = "google.com";
  private static final String ORGANIZATION_DIRECTORY_CUSTOMER_ID = "customer-id-123";
  private static final OrganizationInfo.OrgOwner ORGANIZATION_OWNER =
      OrganizationInfo.OrgOwner.of(ORGANIZATION_DIRECTORY_CUSTOMER_ID);
  private static final OrganizationInfo.State ORGANIZATION_LIFECYCLE_STATE =
      OrganizationInfo.State.LIFECYCLE_STATE_UNSPECIFIED;
  private static final OrganizationInfo ORGANIZATION_INFO =
      OrganizationInfo.newBuilder()
          .setName(ORGANIZATION_NAME)
          .setCreationTime(ORGANIZATION_CREATE_TIME)
          .setDisplayName(ORGANIZATION_DISPLAY_NAME)
          .setOwner(ORGANIZATION_OWNER)
          .setLifecycleState(ORGANIZATION_LIFECYCLE_STATE)
          .build();

  @Test
  public void testToBuilder() {
    compareOrganizationInfo(ORGANIZATION_INFO, ORGANIZATION_INFO.toBuilder().build());
    OrganizationInfo organizationInfo =
        ORGANIZATION_INFO
            .toBuilder()
            .setName(ORGANIZATION_NAME)
            .setCreationTime(ORGANIZATION_CREATE_TIME)
            .setDisplayName(ORGANIZATION_DISPLAY_NAME)
            .setOwner(ORGANIZATION_OWNER)
            .setLifecycleState(ORGANIZATION_LIFECYCLE_STATE)
            .build();
    compareOrganizationInfo(ORGANIZATION_INFO, organizationInfo);
  }

  @Test
  public void testBuilder() {
    assertEquals(ORGANIZATION_NAME, ORGANIZATION_INFO.getName());
    assertEquals(ORGANIZATION_CREATE_TIME, ORGANIZATION_INFO.getCreationTime());
    assertEquals(ORGANIZATION_DISPLAY_NAME, ORGANIZATION_INFO.getDisplayName());
    assertEquals(
        ORGANIZATION_DIRECTORY_CUSTOMER_ID, ORGANIZATION_INFO.getOwner().getDirectoryCustomerId());
    assertEquals(ORGANIZATION_LIFECYCLE_STATE, ORGANIZATION_INFO.getLifecycleState());
  }

  @Test
  public void testToAndFromPb() {
    compareOrganizationInfo(
        ORGANIZATION_INFO, OrganizationInfo.fromProtobuf(ORGANIZATION_INFO.toProtobuf()));
  }

  private void compareOrganizationInfo(OrganizationInfo expected, OrganizationInfo value) {
    assertEquals(expected.toString(), value.toString());
    assertEquals(expected.hashCode(), value.hashCode());
    assertEquals(expected.getName(), value.getName());
    assertEquals(expected.getCreationTime(), value.getCreationTime());
    assertEquals(expected.getDisplayName(), value.getDisplayName());
    assertEquals(expected.getOwner().toString().trim(), value.getOwner().toString().trim());
    assertEquals(expected.getLifecycleState(), value.getLifecycleState());
  }
}
