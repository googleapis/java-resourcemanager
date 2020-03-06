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
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import com.google.api.gax.paging.Page;
import com.google.cloud.PageImpl;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LienTest {

  private static final String LIEN_NAME = "liens/1234abcd";
  private static final String LIEN_PARENT = " projects/1234";
  private static final List<String> LIEN_RESTRICTIONS =
      Arrays.asList("resourcemanager.projects.get", "resourcemanager.projects.delete");
  private static final String LIEN_REASON = "Holds production API key";
  private static final String LIEN_ORIGIN = "compute.googleapis.com";
  private static final String LIEN_CREATE_TIME = "2014-10-02T15:01:23.045123456Z";
  private static final LienInfo LIEN_INFO =
      LienInfo.newBuilder(LIEN_PARENT)
          .setName(LIEN_NAME)
          .setCreateTime(LIEN_CREATE_TIME)
          .setOrigin(LIEN_ORIGIN)
          .setReason(LIEN_REASON)
          .setRestrictions(LIEN_RESTRICTIONS)
          .build();
  private static final LienInfo LIEN_INFO1 = new LienInfo.BuilderImpl(LIEN_INFO).build();
  private static final LienInfo LIEN_INFO2 = new LienInfo.BuilderImpl(LIEN_INFO).build();

  private ResourceManager serviceMockReturnsOptions = createStrictMock(ResourceManager.class);
  private ResourceManagerOptions mockOptions = createMock(ResourceManagerOptions.class);
  private ResourceManager resourceManager;
  private Lien expectedLien;
  private Lien lien;

  @Before
  public void setUp() {
    resourceManager = createStrictMock(ResourceManager.class);
  }

  @After
  public void tearDown() {
    verify(resourceManager);
  }

  private void initializeExpectedLien(int optionsCalls) {
    expect(serviceMockReturnsOptions.getOptions()).andReturn(mockOptions).times(optionsCalls);
    replay(serviceMockReturnsOptions);
    expectedLien = new Lien(serviceMockReturnsOptions, new LienInfo.BuilderImpl(LIEN_INFO));
  }

  private void initializeLien() {
    lien = new Lien(resourceManager, new LienInfo.BuilderImpl(LIEN_INFO));
  }

  @Test
  public void testToBuilder() {
    initializeExpectedLien(4);
    replay(resourceManager);
    compareLiens(expectedLien, expectedLien.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    expect(resourceManager.getOptions()).andReturn(mockOptions).times(4);
    replay(resourceManager);
    Lien.Builder builder =
        new Lien.Builder(new Lien(resourceManager, new LienInfo.BuilderImpl(LIEN_PARENT)));
    Lien lien =
        builder
            .setName(LIEN_NAME)
            .setCreateTime(LIEN_CREATE_TIME)
            .setParent(LIEN_PARENT)
            .setOrigin(LIEN_ORIGIN)
            .setReason(LIEN_REASON)
            .setRestrictions(LIEN_RESTRICTIONS)
            .build();
    assertEquals(LIEN_NAME, lien.getName());
    assertEquals(LIEN_CREATE_TIME, lien.getCreateTime());
    assertEquals(LIEN_ORIGIN, lien.getOrigin());
    assertEquals(LIEN_REASON, lien.getReason());
    assertEquals(LIEN_RESTRICTIONS, lien.getRestrictions());
    assertEquals(LIEN_PARENT, lien.getParent());
    assertEquals(resourceManager.getOptions(), lien.getResourceManager().getOptions());
  }

  @Test
  public void testCreate() {
    initializeExpectedLien(1);
    expect(resourceManager.getOptions()).andReturn(mockOptions);
    expect(resourceManager.createLien(LIEN_INFO)).andReturn(expectedLien);
    replay(resourceManager);
    initializeLien();
    Lien actualLien = lien.create(LIEN_INFO);
    compareLiens(LIEN_INFO, actualLien);
    assertEquals(LIEN_NAME, actualLien.getName());
    assertEquals(LIEN_CREATE_TIME, actualLien.getCreateTime());
    assertEquals(LIEN_ORIGIN, actualLien.getOrigin());
    assertEquals(LIEN_REASON, actualLien.getReason());
    assertEquals(LIEN_RESTRICTIONS, actualLien.getRestrictions());
    assertEquals(LIEN_PARENT, actualLien.getParent());
  }

  @Test
  public void testGet() {
    expect(resourceManager.getOptions()).andReturn(mockOptions);
    expect(resourceManager.getLien(LIEN_NAME)).andReturn(expectedLien).times(1);
    replay(resourceManager);
    initializeLien();
    Lien actualLien = lien.get();
    assertEquals(expectedLien, actualLien);
  }

  @Test
  public void testList() {
    initializeExpectedLien(4);
    List<Lien> results =
        ImmutableList.of(
            new Lien(serviceMockReturnsOptions, new Lien.BuilderImpl(LIEN_INFO)),
            new Lien(serviceMockReturnsOptions, new Lien.BuilderImpl(LIEN_INFO1)),
            new Lien(serviceMockReturnsOptions, new Lien.BuilderImpl(LIEN_INFO2)));
    PageImpl<Lien> expectedPage = new PageImpl<>(null, "c", results);
    expect(resourceManager.getOptions()).andReturn(mockOptions);
    expect(resourceManager.listLiens(LIEN_PARENT)).andReturn(expectedPage);
    replay(resourceManager);
    initializeLien();
    Page<Lien> tablePage = lien.list();
    assertArrayEquals(results.toArray(), Iterables.toArray(tablePage.getValues(), Lien.class));
    assertEquals(expectedPage.getNextPageToken(), tablePage.getNextPageToken());
  }

  @Test
  public void testDelete() {
    expect(resourceManager.getOptions()).andReturn(mockOptions);
    resourceManager.deleteLien(LIEN_NAME);
    replay(resourceManager);
    initializeLien();
    lien.delete();
  }

  private void compareLiens(LienInfo expected, LienInfo value) {
    assertEquals(expected.getName(), value.getName());
    assertEquals(expected.getParent(), value.getParent());
    assertEquals(expected.getRestrictions(), value.getRestrictions());
    assertEquals(expected.getReason(), value.getReason());
    assertEquals(expected.getOrigin(), value.getOrigin());
    assertEquals(expected.getCreateTime(), value.getCreateTime());
  }
}
