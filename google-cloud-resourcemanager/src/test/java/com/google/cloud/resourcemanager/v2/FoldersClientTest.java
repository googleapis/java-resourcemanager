/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.resourcemanager.v2;

import static com.google.cloud.resourcemanager.v2.FoldersClient.ListFoldersPagedResponse;
import static com.google.cloud.resourcemanager.v2.FoldersClient.SearchFoldersPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.ByteString;
import com.google.protobuf.FieldMask;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class FoldersClientTest {
  private static MockFolders mockFolders;
  private static MockServiceHelper serviceHelper;
  private FoldersClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockFolders = new MockFolders();
    serviceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockFolders));
    serviceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    serviceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    serviceHelper.reset();
    channelProvider = serviceHelper.createChannelProvider();
    FoldersSettings settings =
        FoldersSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = FoldersClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void listFoldersTest() {
    String nextPageToken = "";
    Folder foldersElement = Folder.newBuilder().build();
    List<Folder> folders = Arrays.asList(foldersElement);
    ListFoldersResponse expectedResponse =
        ListFoldersResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllFolders(folders)
            .build();
    mockFolders.addResponse(expectedResponse);

    ParentName parent = OrganizationName.of("[ORG_ID]");
    boolean showDeleted = false;

    ListFoldersPagedResponse pagedListResponse = client.listFolders(parent, showDeleted);

    List<Folder> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFoldersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockFolders.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFoldersRequest actualRequest = (ListFoldersRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ParentNames.parse(actualRequest.getParent()));
    Assert.assertEquals(showDeleted, actualRequest.getShowDeleted());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listFoldersExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockFolders.addException(exception);

    try {
      ParentName parent = OrganizationName.of("[ORG_ID]");
      boolean showDeleted = false;

      client.listFolders(parent, showDeleted);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listFoldersTest2() {
    String nextPageToken = "";
    Folder foldersElement = Folder.newBuilder().build();
    List<Folder> folders = Arrays.asList(foldersElement);
    ListFoldersResponse expectedResponse =
        ListFoldersResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllFolders(folders)
            .build();
    mockFolders.addResponse(expectedResponse);

    ParentName parent = OrganizationName.of("[ORG_ID]");

    ListFoldersPagedResponse pagedListResponse = client.listFolders(parent);

    List<Folder> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFoldersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockFolders.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFoldersRequest actualRequest = (ListFoldersRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ParentNames.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listFoldersExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockFolders.addException(exception);

    try {
      ParentName parent = OrganizationName.of("[ORG_ID]");

      client.listFolders(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void searchFoldersTest() {
    String nextPageToken = "";
    Folder foldersElement = Folder.newBuilder().build();
    List<Folder> folders = Arrays.asList(foldersElement);
    SearchFoldersResponse expectedResponse =
        SearchFoldersResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllFolders(folders)
            .build();
    mockFolders.addResponse(expectedResponse);

    String query = "query107944136";

    SearchFoldersPagedResponse pagedListResponse = client.searchFolders(query);

    List<Folder> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFoldersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockFolders.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchFoldersRequest actualRequest = (SearchFoldersRequest) actualRequests.get(0);

    Assert.assertEquals(query, actualRequest.getQuery());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void searchFoldersExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockFolders.addException(exception);

    try {
      String query = "query107944136";

      client.searchFolders(query);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getFolderTest() {
    FolderName name2 = FolderName.of("[FOLDER]");
    ParentName parent = OrganizationName.of("[ORG_ID]");
    String displayName = "displayName1615086568";
    Folder expectedResponse =
        Folder.newBuilder()
            .setName(name2.toString())
            .setParent(parent.toString())
            .setDisplayName(displayName)
            .build();
    mockFolders.addResponse(expectedResponse);

    FolderName name = FolderName.of("[FOLDER]");

    Folder actualResponse = client.getFolder(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFolders.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetFolderRequest actualRequest = (GetFolderRequest) actualRequests.get(0);

    Assert.assertEquals(name, FolderName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getFolderExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockFolders.addException(exception);

    try {
      FolderName name = FolderName.of("[FOLDER]");

      client.getFolder(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createFolderTest() {
    String name = "name3373707";
    boolean done = true;
    Operation expectedResponse = Operation.newBuilder().setName(name).setDone(done).build();
    mockFolders.addResponse(expectedResponse);

    ParentName parent = OrganizationName.of("[ORG_ID]");
    Folder folder = Folder.newBuilder().build();

    Operation actualResponse = client.createFolder(parent, folder);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFolders.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateFolderRequest actualRequest = (CreateFolderRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ParentNames.parse(actualRequest.getParent()));
    Assert.assertEquals(folder, actualRequest.getFolder());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createFolderExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockFolders.addException(exception);

    try {
      ParentName parent = OrganizationName.of("[ORG_ID]");
      Folder folder = Folder.newBuilder().build();

      client.createFolder(parent, folder);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateFolderTest() {
    FolderName name = FolderName.of("[FOLDER]");
    ParentName parent = OrganizationName.of("[ORG_ID]");
    String displayName = "displayName1615086568";
    Folder expectedResponse =
        Folder.newBuilder()
            .setName(name.toString())
            .setParent(parent.toString())
            .setDisplayName(displayName)
            .build();
    mockFolders.addResponse(expectedResponse);

    Folder folder = Folder.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Folder actualResponse = client.updateFolder(folder, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFolders.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateFolderRequest actualRequest = (UpdateFolderRequest) actualRequests.get(0);

    Assert.assertEquals(folder, actualRequest.getFolder());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateFolderExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockFolders.addException(exception);

    try {
      Folder folder = Folder.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();

      client.updateFolder(folder, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void moveFolderTest() {
    String name2 = "name2-1052831874";
    boolean done = true;
    Operation expectedResponse = Operation.newBuilder().setName(name2).setDone(done).build();
    mockFolders.addResponse(expectedResponse);

    FolderName name = FolderName.of("[FOLDER]");
    ParentName destinationParent = OrganizationName.of("[ORG_ID]");

    Operation actualResponse = client.moveFolder(name, destinationParent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFolders.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    MoveFolderRequest actualRequest = (MoveFolderRequest) actualRequests.get(0);

    Assert.assertEquals(name, FolderName.parse(actualRequest.getName()));
    Assert.assertEquals(destinationParent, ParentNames.parse(actualRequest.getDestinationParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void moveFolderExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockFolders.addException(exception);

    try {
      FolderName name = FolderName.of("[FOLDER]");
      ParentName destinationParent = OrganizationName.of("[ORG_ID]");

      client.moveFolder(name, destinationParent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteFolderTest() {
    FolderName name2 = FolderName.of("[FOLDER]");
    ParentName parent = OrganizationName.of("[ORG_ID]");
    String displayName = "displayName1615086568";
    Folder expectedResponse =
        Folder.newBuilder()
            .setName(name2.toString())
            .setParent(parent.toString())
            .setDisplayName(displayName)
            .build();
    mockFolders.addResponse(expectedResponse);

    FolderName name = FolderName.of("[FOLDER]");

    Folder actualResponse = client.deleteFolder(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFolders.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteFolderRequest actualRequest = (DeleteFolderRequest) actualRequests.get(0);

    Assert.assertEquals(name, FolderName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteFolderExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockFolders.addException(exception);

    try {
      FolderName name = FolderName.of("[FOLDER]");

      client.deleteFolder(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteFolderTest2() {
    FolderName name2 = FolderName.of("[FOLDER]");
    ParentName parent = OrganizationName.of("[ORG_ID]");
    String displayName = "displayName1615086568";
    Folder expectedResponse =
        Folder.newBuilder()
            .setName(name2.toString())
            .setParent(parent.toString())
            .setDisplayName(displayName)
            .build();
    mockFolders.addResponse(expectedResponse);

    FolderName name = FolderName.of("[FOLDER]");
    boolean recursiveDelete = true;

    Folder actualResponse = client.deleteFolder(name, recursiveDelete);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFolders.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteFolderRequest actualRequest = (DeleteFolderRequest) actualRequests.get(0);

    Assert.assertEquals(name, FolderName.parse(actualRequest.getName()));
    Assert.assertEquals(recursiveDelete, actualRequest.getRecursiveDelete());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteFolderExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockFolders.addException(exception);

    try {
      FolderName name = FolderName.of("[FOLDER]");
      boolean recursiveDelete = true;

      client.deleteFolder(name, recursiveDelete);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void undeleteFolderTest() {
    FolderName name2 = FolderName.of("[FOLDER]");
    ParentName parent = OrganizationName.of("[ORG_ID]");
    String displayName = "displayName1615086568";
    Folder expectedResponse =
        Folder.newBuilder()
            .setName(name2.toString())
            .setParent(parent.toString())
            .setDisplayName(displayName)
            .build();
    mockFolders.addResponse(expectedResponse);

    FolderName name = FolderName.of("[FOLDER]");

    Folder actualResponse = client.undeleteFolder(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFolders.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UndeleteFolderRequest actualRequest = (UndeleteFolderRequest) actualRequests.get(0);

    Assert.assertEquals(name, FolderName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void undeleteFolderExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockFolders.addException(exception);

    try {
      FolderName name = FolderName.of("[FOLDER]");

      client.undeleteFolder(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getIamPolicyTest() {
    int version = 351608024;
    ByteString etag = ByteString.copyFromUtf8("21");
    Policy expectedResponse = Policy.newBuilder().setVersion(version).setEtag(etag).build();
    mockFolders.addResponse(expectedResponse);

    String formattedResource = FolderName.format("[FOLDER]");

    Policy actualResponse = client.getIamPolicy(formattedResource);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFolders.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIamPolicyRequest actualRequest = (GetIamPolicyRequest) actualRequests.get(0);

    Assert.assertEquals(formattedResource, actualRequest.getResource());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockFolders.addException(exception);

    try {
      String formattedResource = FolderName.format("[FOLDER]");

      client.getIamPolicy(formattedResource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void setIamPolicyTest() {
    int version = 351608024;
    ByteString etag = ByteString.copyFromUtf8("21");
    Policy expectedResponse = Policy.newBuilder().setVersion(version).setEtag(etag).build();
    mockFolders.addResponse(expectedResponse);

    String formattedResource = FolderName.format("[FOLDER]");
    Policy policy = Policy.newBuilder().build();

    Policy actualResponse = client.setIamPolicy(formattedResource, policy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFolders.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetIamPolicyRequest actualRequest = (SetIamPolicyRequest) actualRequests.get(0);

    Assert.assertEquals(formattedResource, actualRequest.getResource());
    Assert.assertEquals(policy, actualRequest.getPolicy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void setIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockFolders.addException(exception);

    try {
      String formattedResource = FolderName.format("[FOLDER]");
      Policy policy = Policy.newBuilder().build();

      client.setIamPolicy(formattedResource, policy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void testIamPermissionsTest() {
    TestIamPermissionsResponse expectedResponse = TestIamPermissionsResponse.newBuilder().build();
    mockFolders.addResponse(expectedResponse);

    String formattedResource = FolderName.format("[FOLDER]");
    List<String> permissions = new ArrayList<>();

    TestIamPermissionsResponse actualResponse =
        client.testIamPermissions(formattedResource, permissions);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFolders.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TestIamPermissionsRequest actualRequest = (TestIamPermissionsRequest) actualRequests.get(0);

    Assert.assertEquals(formattedResource, actualRequest.getResource());
    Assert.assertEquals(permissions, actualRequest.getPermissionsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void testIamPermissionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockFolders.addException(exception);

    try {
      String formattedResource = FolderName.format("[FOLDER]");
      List<String> permissions = new ArrayList<>();

      client.testIamPermissions(formattedResource, permissions);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
