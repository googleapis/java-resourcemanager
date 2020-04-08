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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class OperationInfoTest {

  private static final Integer ID = 1234;
  private static final Integer CODE = 400;
  private static final String NAME = "operations/{unique_id}";
  private static final String TYPE = "types.example.com/standard/id";
  private static final String MESSAGE = "INVALID_ARGUMENT";
  private static final OperationInfo INCOMPLETE_OPERATION_INFO =
      OperationInfo.newBuilder(NAME).build();

  private Map<String, Object> operationMap;
  private List<Map<String, Object>> details;
  private OperationInfo.Status status;
  private OperationInfo operationInfoWithResponse;
  private OperationInfo operationInfoWithError;

  @Before
  public void setUp() {
    operationMap = new HashMap<>();
    operationMap.put("id", ID);
    operationMap.put("@type", TYPE);
    details = Arrays.asList(operationMap);
    status = new OperationInfo.Status(CODE, MESSAGE, details);
    operationInfoWithResponse =
        OperationInfo.newBuilder(NAME)
            .setDone(Boolean.TRUE)
            .setMetadata(operationMap)
            .setResponse(operationMap)
            .build();
    operationInfoWithError =
        OperationInfo.newBuilder(NAME)
            .setDone(Boolean.TRUE)
            .setMetadata(operationMap)
            .setError(status)
            .build();
  }

  @Test
  public void testToBuilder() {
    compareOperations(operationInfoWithResponse, operationInfoWithResponse.toBuilder().build());
    OperationInfo operationInfo = operationInfoWithResponse.toBuilder().setName(NAME).build();
    assertEquals(NAME, operationInfo.getName());
    assertEquals(Boolean.TRUE, operationInfo.getDone());
    compareOperations(operationInfoWithResponse, operationInfo);
  }

  @Test
  public void testToBuilderIncomplete() {
    compareOperations(INCOMPLETE_OPERATION_INFO, INCOMPLETE_OPERATION_INFO.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    assertEquals(NAME, operationInfoWithResponse.getName());
    assertEquals(Boolean.TRUE, operationInfoWithResponse.getDone());
    assertEquals(operationMap, operationInfoWithResponse.getMetadata());
    assertEquals(operationMap, operationInfoWithResponse.getResponse());
    assertEquals(status, operationInfoWithError.getError());
  }

  @Test
  public void testToProtobufAndFromProtbuf() {
    compareOperations(
        operationInfoWithResponse,
        OperationInfo.fromProtobuf(operationInfoWithResponse.toProtobuf()));
    OperationInfo operationInfoWithResponse =
        OperationInfo.of(NAME).toBuilder().setResponse(operationMap).build();
    compareOperations(
        operationInfoWithResponse,
        OperationInfo.fromProtobuf(operationInfoWithResponse.toProtobuf()));
    compareOperations(
        operationInfoWithError, OperationInfo.fromProtobuf(operationInfoWithError.toProtobuf()));
    OperationInfo operationInfoWithError =
        OperationInfo.of(NAME).toBuilder().setError(status).build();
    compareOperations(
        operationInfoWithError, OperationInfo.fromProtobuf(operationInfoWithError.toProtobuf()));
  }

  @Test
  public void testToString() {
    assertTrue(operationInfoWithResponse.toString().contains("name=" + NAME));
    assertTrue(operationInfoWithResponse.toString().contains("done=" + Boolean.TRUE));
    assertTrue(operationInfoWithResponse.toString().contains("metadata=" + operationMap));
    assertTrue(operationInfoWithResponse.toString().contains("response=" + operationMap));
    assertTrue(operationInfoWithError.toString().contains("error=" + status));
  }

  @Test
  public void testStatus() {
    OperationInfo.Status expected = new OperationInfo.Status(CODE, MESSAGE, details);
    compareStatus(expected, status);
  }

  @Test
  public void testStatusToProtobufAndFromProtobuf() {
    OperationInfo.Status expected = new OperationInfo.Status(CODE, MESSAGE, details);
    assertEquals(expected, OperationInfo.Status.fromProtobuf(expected.toProtobuf()));
    compareStatus(expected, status);
  }

  @Test
  public void testStatusToString() {
    assertTrue(status.toString().contains("code=" + CODE));
    assertTrue(status.toString().contains("message=" + MESSAGE));
    assertTrue(status.toString().contains("details=" + details));
  }

  private void compareOperations(OperationInfo expected, OperationInfo actual) {
    assertEquals(expected, actual);
    assertEquals(expected.hashCode(), actual.hashCode());
    assertEquals(expected.getName(), actual.getName());
    assertEquals(expected.getDone(), actual.getDone());
    assertEquals(expected.getMetadata(), actual.getMetadata());
    assertEquals(expected.getResponse(), actual.getResponse());
    assertEquals(expected.getError(), actual.getError());
  }

  private void compareStatus(OperationInfo.Status expected, OperationInfo.Status actual) {
    assertEquals(expected, actual);
    assertEquals(expected.toString(), actual.toString());
    assertEquals(expected.hashCode(), actual.hashCode());
    assertEquals(expected.getCode(), actual.getCode());
    assertEquals(expected.getMessage(), actual.getMessage());
    assertEquals(expected.getDetails(), actual.getDetails());
  }
}
