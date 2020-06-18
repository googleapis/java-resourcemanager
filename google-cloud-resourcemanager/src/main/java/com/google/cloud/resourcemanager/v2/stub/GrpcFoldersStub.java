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
package com.google.cloud.resourcemanager.v2.stub;

import static com.google.cloud.resourcemanager.v2.FoldersClient.ListFoldersPagedResponse;
import static com.google.cloud.resourcemanager.v2.FoldersClient.SearchFoldersPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.resourcemanager.v2.CreateFolderRequest;
import com.google.cloud.resourcemanager.v2.DeleteFolderRequest;
import com.google.cloud.resourcemanager.v2.Folder;
import com.google.cloud.resourcemanager.v2.GetFolderRequest;
import com.google.cloud.resourcemanager.v2.ListFoldersRequest;
import com.google.cloud.resourcemanager.v2.ListFoldersResponse;
import com.google.cloud.resourcemanager.v2.MoveFolderRequest;
import com.google.cloud.resourcemanager.v2.SearchFoldersRequest;
import com.google.cloud.resourcemanager.v2.SearchFoldersResponse;
import com.google.cloud.resourcemanager.v2.UndeleteFolderRequest;
import com.google.cloud.resourcemanager.v2.UpdateFolderRequest;
import com.google.common.collect.ImmutableMap;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * gRPC stub implementation for Cloud Resource Manager API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public class GrpcFoldersStub extends FoldersStub {

  private static final MethodDescriptor<ListFoldersRequest, ListFoldersResponse>
      listFoldersMethodDescriptor =
          MethodDescriptor.<ListFoldersRequest, ListFoldersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.resourcemanager.v2.Folders/ListFolders")
              .setRequestMarshaller(ProtoUtils.marshaller(ListFoldersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListFoldersResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<SearchFoldersRequest, SearchFoldersResponse>
      searchFoldersMethodDescriptor =
          MethodDescriptor.<SearchFoldersRequest, SearchFoldersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.resourcemanager.v2.Folders/SearchFolders")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SearchFoldersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SearchFoldersResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<GetFolderRequest, Folder> getFolderMethodDescriptor =
      MethodDescriptor.<GetFolderRequest, Folder>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.resourcemanager.v2.Folders/GetFolder")
          .setRequestMarshaller(ProtoUtils.marshaller(GetFolderRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Folder.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<CreateFolderRequest, Operation>
      createFolderMethodDescriptor =
          MethodDescriptor.<CreateFolderRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.resourcemanager.v2.Folders/CreateFolder")
              .setRequestMarshaller(ProtoUtils.marshaller(CreateFolderRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<UpdateFolderRequest, Folder> updateFolderMethodDescriptor =
      MethodDescriptor.<UpdateFolderRequest, Folder>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.resourcemanager.v2.Folders/UpdateFolder")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateFolderRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Folder.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<MoveFolderRequest, Operation> moveFolderMethodDescriptor =
      MethodDescriptor.<MoveFolderRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.resourcemanager.v2.Folders/MoveFolder")
          .setRequestMarshaller(ProtoUtils.marshaller(MoveFolderRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<DeleteFolderRequest, Folder> deleteFolderMethodDescriptor =
      MethodDescriptor.<DeleteFolderRequest, Folder>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.resourcemanager.v2.Folders/DeleteFolder")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteFolderRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Folder.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<UndeleteFolderRequest, Folder>
      undeleteFolderMethodDescriptor =
          MethodDescriptor.<UndeleteFolderRequest, Folder>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.resourcemanager.v2.Folders/UndeleteFolder")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UndeleteFolderRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Folder.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.resourcemanager.v2.Folders/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.resourcemanager.v2.Folders/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          MethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.resourcemanager.v2.Folders/TestIamPermissions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsResponse.getDefaultInstance()))
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<ListFoldersRequest, ListFoldersResponse> listFoldersCallable;
  private final UnaryCallable<ListFoldersRequest, ListFoldersPagedResponse>
      listFoldersPagedCallable;
  private final UnaryCallable<SearchFoldersRequest, SearchFoldersResponse> searchFoldersCallable;
  private final UnaryCallable<SearchFoldersRequest, SearchFoldersPagedResponse>
      searchFoldersPagedCallable;
  private final UnaryCallable<GetFolderRequest, Folder> getFolderCallable;
  private final UnaryCallable<CreateFolderRequest, Operation> createFolderCallable;
  private final UnaryCallable<UpdateFolderRequest, Folder> updateFolderCallable;
  private final UnaryCallable<MoveFolderRequest, Operation> moveFolderCallable;
  private final UnaryCallable<DeleteFolderRequest, Folder> deleteFolderCallable;
  private final UnaryCallable<UndeleteFolderRequest, Folder> undeleteFolderCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcFoldersStub create(FoldersStubSettings settings) throws IOException {
    return new GrpcFoldersStub(settings, ClientContext.create(settings));
  }

  public static final GrpcFoldersStub create(ClientContext clientContext) throws IOException {
    return new GrpcFoldersStub(FoldersStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcFoldersStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcFoldersStub(
        FoldersStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcFoldersStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcFoldersStub(FoldersStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcFoldersCallableFactory());
  }

  /**
   * Constructs an instance of GrpcFoldersStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcFoldersStub(
      FoldersStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    GrpcCallSettings<ListFoldersRequest, ListFoldersResponse> listFoldersTransportSettings =
        GrpcCallSettings.<ListFoldersRequest, ListFoldersResponse>newBuilder()
            .setMethodDescriptor(listFoldersMethodDescriptor)
            .build();
    GrpcCallSettings<SearchFoldersRequest, SearchFoldersResponse> searchFoldersTransportSettings =
        GrpcCallSettings.<SearchFoldersRequest, SearchFoldersResponse>newBuilder()
            .setMethodDescriptor(searchFoldersMethodDescriptor)
            .build();
    GrpcCallSettings<GetFolderRequest, Folder> getFolderTransportSettings =
        GrpcCallSettings.<GetFolderRequest, Folder>newBuilder()
            .setMethodDescriptor(getFolderMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetFolderRequest>() {
                  @Override
                  public Map<String, String> extract(GetFolderRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<CreateFolderRequest, Operation> createFolderTransportSettings =
        GrpcCallSettings.<CreateFolderRequest, Operation>newBuilder()
            .setMethodDescriptor(createFolderMethodDescriptor)
            .build();
    GrpcCallSettings<UpdateFolderRequest, Folder> updateFolderTransportSettings =
        GrpcCallSettings.<UpdateFolderRequest, Folder>newBuilder()
            .setMethodDescriptor(updateFolderMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpdateFolderRequest>() {
                  @Override
                  public Map<String, String> extract(UpdateFolderRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("folder.name", String.valueOf(request.getFolder().getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<MoveFolderRequest, Operation> moveFolderTransportSettings =
        GrpcCallSettings.<MoveFolderRequest, Operation>newBuilder()
            .setMethodDescriptor(moveFolderMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<MoveFolderRequest>() {
                  @Override
                  public Map<String, String> extract(MoveFolderRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeleteFolderRequest, Folder> deleteFolderTransportSettings =
        GrpcCallSettings.<DeleteFolderRequest, Folder>newBuilder()
            .setMethodDescriptor(deleteFolderMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteFolderRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteFolderRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<UndeleteFolderRequest, Folder> undeleteFolderTransportSettings =
        GrpcCallSettings.<UndeleteFolderRequest, Folder>newBuilder()
            .setMethodDescriptor(undeleteFolderMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UndeleteFolderRequest>() {
                  @Override
                  public Map<String, String> extract(UndeleteFolderRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        GrpcCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetIamPolicyRequest>() {
                  @Override
                  public Map<String, String> extract(GetIamPolicyRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("resource", String.valueOf(request.getResource()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        GrpcCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<SetIamPolicyRequest>() {
                  @Override
                  public Map<String, String> extract(SetIamPolicyRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("resource", String.valueOf(request.getResource()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            GrpcCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<TestIamPermissionsRequest>() {
                      @Override
                      public Map<String, String> extract(TestIamPermissionsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("resource", String.valueOf(request.getResource()));
                        return params.build();
                      }
                    })
                .build();

    this.listFoldersCallable =
        callableFactory.createUnaryCallable(
            listFoldersTransportSettings, settings.listFoldersSettings(), clientContext);
    this.listFoldersPagedCallable =
        callableFactory.createPagedCallable(
            listFoldersTransportSettings, settings.listFoldersSettings(), clientContext);
    this.searchFoldersCallable =
        callableFactory.createUnaryCallable(
            searchFoldersTransportSettings, settings.searchFoldersSettings(), clientContext);
    this.searchFoldersPagedCallable =
        callableFactory.createPagedCallable(
            searchFoldersTransportSettings, settings.searchFoldersSettings(), clientContext);
    this.getFolderCallable =
        callableFactory.createUnaryCallable(
            getFolderTransportSettings, settings.getFolderSettings(), clientContext);
    this.createFolderCallable =
        callableFactory.createUnaryCallable(
            createFolderTransportSettings, settings.createFolderSettings(), clientContext);
    this.updateFolderCallable =
        callableFactory.createUnaryCallable(
            updateFolderTransportSettings, settings.updateFolderSettings(), clientContext);
    this.moveFolderCallable =
        callableFactory.createUnaryCallable(
            moveFolderTransportSettings, settings.moveFolderSettings(), clientContext);
    this.deleteFolderCallable =
        callableFactory.createUnaryCallable(
            deleteFolderTransportSettings, settings.deleteFolderSettings(), clientContext);
    this.undeleteFolderCallable =
        callableFactory.createUnaryCallable(
            undeleteFolderTransportSettings, settings.undeleteFolderSettings(), clientContext);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
    this.testIamPermissionsCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsTransportSettings,
            settings.testIamPermissionsSettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public UnaryCallable<ListFoldersRequest, ListFoldersPagedResponse> listFoldersPagedCallable() {
    return listFoldersPagedCallable;
  }

  public UnaryCallable<ListFoldersRequest, ListFoldersResponse> listFoldersCallable() {
    return listFoldersCallable;
  }

  public UnaryCallable<SearchFoldersRequest, SearchFoldersPagedResponse>
      searchFoldersPagedCallable() {
    return searchFoldersPagedCallable;
  }

  public UnaryCallable<SearchFoldersRequest, SearchFoldersResponse> searchFoldersCallable() {
    return searchFoldersCallable;
  }

  public UnaryCallable<GetFolderRequest, Folder> getFolderCallable() {
    return getFolderCallable;
  }

  public UnaryCallable<CreateFolderRequest, Operation> createFolderCallable() {
    return createFolderCallable;
  }

  public UnaryCallable<UpdateFolderRequest, Folder> updateFolderCallable() {
    return updateFolderCallable;
  }

  public UnaryCallable<MoveFolderRequest, Operation> moveFolderCallable() {
    return moveFolderCallable;
  }

  public UnaryCallable<DeleteFolderRequest, Folder> deleteFolderCallable() {
    return deleteFolderCallable;
  }

  public UnaryCallable<UndeleteFolderRequest, Folder> undeleteFolderCallable() {
    return undeleteFolderCallable;
  }

  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
  }

  @Override
  public final void close() {
    shutdown();
  }

  @Override
  public void shutdown() {
    backgroundResources.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return backgroundResources.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return backgroundResources.isTerminated();
  }

  @Override
  public void shutdownNow() {
    backgroundResources.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return backgroundResources.awaitTermination(duration, unit);
  }
}
