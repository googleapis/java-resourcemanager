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

import com.google.api.services.cloudresourcemanager.model.BooleanConstraint;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ConstraintTest {
  private static final String NAME = "constraints/serviceuser.services";
  private static final String CONSTRAINT_DEFAULT = "ALLOW";
  private static final String DISPLAY_NAME = "constraints-display-name";
  private static final String DESCRIPTION =
      "Detailed description of what this Constraint controls as well as how and where it is enforced";
  private static final Integer VERSION = 1;

  private static final ConstraintInfo.ListConstraint LIST_CONSTRAINT =
      new ConstraintInfo.ListConstraint("suggested-value", true);
  private static ConstraintInfo constraintInfo;
  private static BooleanConstraint booleanConstraint;

  private ResourceManager serviceMockReturnsOptions = createStrictMock(ResourceManager.class);
  private ResourceManagerOptions mockOptions = createMock(ResourceManagerOptions.class);
  private ResourceManager resourceManager;
  private Constraint expectedConstraint;

  @Before
  public void setUp() {
    resourceManager = createStrictMock(ResourceManager.class);
    booleanConstraint = new BooleanConstraint();
    booleanConstraint.set("booleanField", Boolean.class);
    constraintInfo =
        ConstraintInfo.newBuilder(NAME)
            .setConstraintDefault(CONSTRAINT_DEFAULT)
            .setDisplayName(DISPLAY_NAME)
            .setDescription(DESCRIPTION)
            .setListConstraint(LIST_CONSTRAINT)
            .setBooleanConstraint(booleanConstraint)
            .setVersion(VERSION)
            .build();
  }

  @After
  public void tearDown() {
    verify(resourceManager);
  }

  private void initializeExpectedConstraint(int optionsCalls) {
    expect(serviceMockReturnsOptions.getOptions()).andReturn(mockOptions).times(optionsCalls);
    replay(serviceMockReturnsOptions);
    expectedConstraint =
        new Constraint(serviceMockReturnsOptions, new ConstraintInfo.BuilderImpl(constraintInfo));
  }

  @Test
  public void testToBuilder() {
    initializeExpectedConstraint(4);
    replay(resourceManager);
    compareConstraint(expectedConstraint, expectedConstraint.toBuilder().build());
  }

  @Test
  public void testFromPb() {
    initializeExpectedConstraint(2);
    expect(resourceManager.getOptions()).andReturn(mockOptions).times(2);
    replay(resourceManager);
    compareConstraint(
        expectedConstraint, Constraint.fromPb(resourceManager, expectedConstraint.toPb()));
  }

  @Test
  public void testBuilder() {
    expect(resourceManager.getOptions()).andReturn(mockOptions).times(4);
    replay(resourceManager);
    Constraint.Builder builder =
        new Constraint.Builder(
            new Constraint(resourceManager, new ConstraintInfo.BuilderImpl(NAME)));
    Constraint constraint =
        builder
            .setConstraintDefault(CONSTRAINT_DEFAULT)
            .setName(NAME)
            .setDisplayName(DISPLAY_NAME)
            .setDescription(DESCRIPTION)
            .setListConstraint(LIST_CONSTRAINT)
            .setBooleanConstraint(booleanConstraint)
            .setVersion(VERSION)
            .build();
    assertEquals(NAME, constraint.getName());
    assertEquals(CONSTRAINT_DEFAULT, constraint.getConstraintDefault());
    assertEquals(DISPLAY_NAME, constraint.getDisplayName());
    assertEquals(DESCRIPTION, constraint.getDescription());
    assertEquals(LIST_CONSTRAINT, constraint.getListConstraint());
    assertEquals(booleanConstraint, constraint.getBooleanConstraint());
    assertEquals(VERSION, constraint.getVersion());
    assertEquals(resourceManager.getOptions(), constraint.getResourceManager().getOptions());
  }

  @Test
  public void testResourceManager() {
    initializeExpectedConstraint(1);
    replay(resourceManager);
    assertEquals(serviceMockReturnsOptions, expectedConstraint.getResourceManager());
  }

  private void compareConstraint(Constraint expected, Constraint value) {
    assertEquals(expected, value);
    compareConstraintInfo(expected, value);
    assertEquals(
        expected.getResourceManager().getOptions(), value.getResourceManager().getOptions());
  }

  private void compareConstraintInfo(ConstraintInfo expected, ConstraintInfo value) {
    assertEquals(expected, value);
    assertEquals(expected.hashCode(), value.hashCode());
    assertEquals(expected.toString(), value.toString());
    assertEquals(expected.getName(), value.getName());
    assertEquals(expected.getConstraintDefault(), value.getConstraintDefault());
    assertEquals(expected.getDisplayName(), value.getDisplayName());
    assertEquals(expected.getDescription(), value.getDescription());
    assertEquals(expected.getListConstraint(), value.getListConstraint());
    assertEquals(expected.getVersion(), value.getVersion());
  }
}
