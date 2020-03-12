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

import com.google.cloud.resourcemanager.ConstraintInfo.ListConstraint;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ConstraintInfoTest {
  private static final String NAME = "constraints/serviceuser.services";
  private static final String CONSTRAINT_DEFAULT = "ALLOW";
  private static final String DISPLAY_NAME = "constraints-display-name";
  private static final String DESCRIPTION =
      "Detailed description of what this Constraint controls as well as how and where it is enforced";
  private static final Integer VERSION = 1;

  private static final ListConstraint LIST_CONSTRAINT = new ListConstraint("suggested-value", true);
  private static final ConstraintInfo CONSTRAINT_INFO =
      ConstraintInfo.newBuilder(NAME)
          .setConstraintDefault(CONSTRAINT_DEFAULT)
          .setDisplayName(DISPLAY_NAME)
          .setDescription(DESCRIPTION)
          .setListConstraint(LIST_CONSTRAINT)
          .setVersion(VERSION)
          .build();

  @Test
  public void testBuilder() {
    assertEquals(NAME, CONSTRAINT_INFO.getName());
    assertEquals(CONSTRAINT_DEFAULT, CONSTRAINT_INFO.getConstraintDefault());
    assertEquals(DISPLAY_NAME, CONSTRAINT_INFO.getDisplayName());
    assertEquals(DESCRIPTION, CONSTRAINT_INFO.getDescription());
    assertEquals(LIST_CONSTRAINT, CONSTRAINT_INFO.getListConstraint());
    assertEquals(VERSION, CONSTRAINT_INFO.getVersion());
  }

  @Test
  public void testToBuilder() {
    compareConstraints(CONSTRAINT_INFO, CONSTRAINT_INFO.toBuilder().build());
  }

  @Test
  public void testToAndFromPb() {
    compareConstraints(CONSTRAINT_INFO, CONSTRAINT_INFO.toBuilder().build());
  }

  @Test
  public void testEquals() {
    compareConstraints(
        CONSTRAINT_INFO,
        ConstraintInfo.newBuilder(NAME)
            .setConstraintDefault(CONSTRAINT_DEFAULT)
            .setDisplayName(DISPLAY_NAME)
            .setDescription(DESCRIPTION)
            .setListConstraint(LIST_CONSTRAINT)
            .setVersion(VERSION)
            .build());
    compareConstraints(CONSTRAINT_INFO, new ConstraintInfo.BuilderImpl(CONSTRAINT_INFO).build());
  }

  private void compareConstraints(ConstraintInfo expected, ConstraintInfo value) {
    assertEquals(expected.getName(), value.getName());
    assertEquals(expected.getConstraintDefault(), value.getConstraintDefault());
    assertEquals(expected.getDisplayName(), value.getDisplayName());
    assertEquals(expected.getDescription(), value.getDescription());
    assertEquals(expected.getListConstraint(), value.getListConstraint());
    assertEquals(expected.getVersion(), value.getVersion());
  }
}
