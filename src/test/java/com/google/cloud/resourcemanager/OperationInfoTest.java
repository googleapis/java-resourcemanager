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

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
  public static Map<String, Object> operationMap;

  static {
    operationMap = new HashMap<>();
    operationMap.put("id", ID);
    operationMap.put("@type", TYPE);
  }

  private static final List<Map<String, Object>> DETAILS = Arrays.asList(operationMap);
  private static final OperationInfo.Status STATUS =
      new OperationInfo.Status(CODE, MESSAGE, DETAILS);
  private static final OperationInfo OPERATION_INFO_WITH_RESPONSE =
      OperationInfo.newBuilder(NAME)
          .setDone(Boolean.TRUE)
          .setMetadata(operationMap)
          .setResponse(operationMap)
          .build();
  private static final OperationInfo OPERATION_INFO_WITH_ERROR =
      OperationInfo.newBuilder(NAME)
          .setDone(Boolean.TRUE)
          .setMetadata(operationMap)
          .setError(STATUS)
          .build();
  private static final OperationInfo INCOMPLETE_OPERATION_INFO =
      OperationInfo.newBuilder(NAME).build();

  @Test
  public void testToBuilder() {
    compareOperations(
        OPERATION_INFO_WITH_RESPONSE, OPERATION_INFO_WITH_RESPONSE.toBuilder().build());
    OperationInfo operationInfo = OPERATION_INFO_WITH_RESPONSE.toBuilder().setName(NAME).build();
    assertEquals(NAME, operationInfo.getName());
    assertEquals(Boolean.TRUE, operationInfo.getDone());
    compareOperations(OPERATION_INFO_WITH_RESPONSE, operationInfo);
  }

  @Test
  public void testToBuilderIncomplete() {
    compareOperations(INCOMPLETE_OPERATION_INFO, INCOMPLETE_OPERATION_INFO.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    assertEquals(NAME, OPERATION_INFO_WITH_RESPONSE.getName());
    assertEquals(Boolean.TRUE, OPERATION_INFO_WITH_RESPONSE.getDone());
    assertEquals(operationMap, OPERATION_INFO_WITH_RESPONSE.getMetadata());
    assertEquals(operationMap, OPERATION_INFO_WITH_RESPONSE.getResponse());
    assertEquals(STATUS, OPERATION_INFO_WITH_ERROR.getError());
  }

  @Test
  public void testToPbAndFromPb() {
    compareOperations(
        OPERATION_INFO_WITH_RESPONSE, OperationInfo.fromPb(OPERATION_INFO_WITH_RESPONSE.toPb()));
    OperationInfo operationInfoWithResponse =
        OperationInfo.of(NAME).toBuilder().setResponse(operationMap).build();
    compareOperations(
        operationInfoWithResponse, OperationInfo.fromPb(operationInfoWithResponse.toPb()));
    compareOperations(
        OPERATION_INFO_WITH_ERROR, OperationInfo.fromPb(OPERATION_INFO_WITH_ERROR.toPb()));
    OperationInfo operationInfoWithError =
        OperationInfo.of(NAME).toBuilder().setError(STATUS).build();
    compareOperations(operationInfoWithError, OperationInfo.fromPb(operationInfoWithError.toPb()));
  }

  @Test
  public void testStatus() {
    assertEquals(CODE, STATUS.getCode());
    assertEquals(MESSAGE, STATUS.getMessage());
    assertEquals(DETAILS, STATUS.getDetails());
  }

  @Test
  public void testStatusToPbAndFromPb() {
    OperationInfo.Status status = new OperationInfo.Status(CODE, MESSAGE, DETAILS);
    assertEquals(status, OperationInfo.Status.fromPb(status.toPb()));
  }

  private void compareOperations(OperationInfo expected, OperationInfo value) {
    assertEquals(expected.getName(), value.getName());
    assertEquals(expected.getDone(), value.getDone());
    assertEquals(expected.getMetadata(), value.getMetadata());
    assertEquals(expected.getResponse(), value.getResponse());
    assertEquals(expected.getError(), value.getError());
  }
}
