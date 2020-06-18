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

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link FoldersStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (cloudresourcemanager.googleapis.com) and default port (443)
 *       are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getFolder to 30 seconds:
 *
 * <pre>
 * <code>
 * FoldersStubSettings.Builder foldersSettingsBuilder =
 *     FoldersStubSettings.newBuilder();
 * foldersSettingsBuilder
 *     .getFolderSettings()
 *     .setRetrySettings(
 *         foldersSettingsBuilder.getFolderSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * FoldersStubSettings foldersSettings = foldersSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class FoldersStubSettings extends StubSettings<FoldersStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/cloud-platform.read-only")
          .build();

  private final PagedCallSettings<ListFoldersRequest, ListFoldersResponse, ListFoldersPagedResponse>
      listFoldersSettings;
  private final PagedCallSettings<
          SearchFoldersRequest, SearchFoldersResponse, SearchFoldersPagedResponse>
      searchFoldersSettings;
  private final UnaryCallSettings<GetFolderRequest, Folder> getFolderSettings;
  private final UnaryCallSettings<CreateFolderRequest, Operation> createFolderSettings;
  private final UnaryCallSettings<UpdateFolderRequest, Folder> updateFolderSettings;
  private final UnaryCallSettings<MoveFolderRequest, Operation> moveFolderSettings;
  private final UnaryCallSettings<DeleteFolderRequest, Folder> deleteFolderSettings;
  private final UnaryCallSettings<UndeleteFolderRequest, Folder> undeleteFolderSettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  /** Returns the object with the settings used for calls to listFolders. */
  public PagedCallSettings<ListFoldersRequest, ListFoldersResponse, ListFoldersPagedResponse>
      listFoldersSettings() {
    return listFoldersSettings;
  }

  /** Returns the object with the settings used for calls to searchFolders. */
  public PagedCallSettings<SearchFoldersRequest, SearchFoldersResponse, SearchFoldersPagedResponse>
      searchFoldersSettings() {
    return searchFoldersSettings;
  }

  /** Returns the object with the settings used for calls to getFolder. */
  public UnaryCallSettings<GetFolderRequest, Folder> getFolderSettings() {
    return getFolderSettings;
  }

  /** Returns the object with the settings used for calls to createFolder. */
  public UnaryCallSettings<CreateFolderRequest, Operation> createFolderSettings() {
    return createFolderSettings;
  }

  /** Returns the object with the settings used for calls to updateFolder. */
  public UnaryCallSettings<UpdateFolderRequest, Folder> updateFolderSettings() {
    return updateFolderSettings;
  }

  /** Returns the object with the settings used for calls to moveFolder. */
  public UnaryCallSettings<MoveFolderRequest, Operation> moveFolderSettings() {
    return moveFolderSettings;
  }

  /** Returns the object with the settings used for calls to deleteFolder. */
  public UnaryCallSettings<DeleteFolderRequest, Folder> deleteFolderSettings() {
    return deleteFolderSettings;
  }

  /** Returns the object with the settings used for calls to undeleteFolder. */
  public UnaryCallSettings<UndeleteFolderRequest, Folder> undeleteFolderSettings() {
    return undeleteFolderSettings;
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return getIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return setIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return testIamPermissionsSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public FoldersStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcFoldersStub.create(this);
    } else {
      throw new UnsupportedOperationException(
          "Transport not supported: " + getTransportChannelProvider().getTransportName());
    }
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "cloudresourcemanager.googleapis.com:443";
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder().setScopesToApply(DEFAULT_SERVICE_SCOPES);
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(FoldersStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected FoldersStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listFoldersSettings = settingsBuilder.listFoldersSettings().build();
    searchFoldersSettings = settingsBuilder.searchFoldersSettings().build();
    getFolderSettings = settingsBuilder.getFolderSettings().build();
    createFolderSettings = settingsBuilder.createFolderSettings().build();
    updateFolderSettings = settingsBuilder.updateFolderSettings().build();
    moveFolderSettings = settingsBuilder.moveFolderSettings().build();
    deleteFolderSettings = settingsBuilder.deleteFolderSettings().build();
    undeleteFolderSettings = settingsBuilder.undeleteFolderSettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  private static final PagedListDescriptor<ListFoldersRequest, ListFoldersResponse, Folder>
      LIST_FOLDERS_PAGE_STR_DESC =
          new PagedListDescriptor<ListFoldersRequest, ListFoldersResponse, Folder>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListFoldersRequest injectToken(ListFoldersRequest payload, String token) {
              return ListFoldersRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListFoldersRequest injectPageSize(ListFoldersRequest payload, int pageSize) {
              return ListFoldersRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListFoldersRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListFoldersResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Folder> extractResources(ListFoldersResponse payload) {
              return payload.getFoldersList() != null
                  ? payload.getFoldersList()
                  : ImmutableList.<Folder>of();
            }
          };

  private static final PagedListDescriptor<SearchFoldersRequest, SearchFoldersResponse, Folder>
      SEARCH_FOLDERS_PAGE_STR_DESC =
          new PagedListDescriptor<SearchFoldersRequest, SearchFoldersResponse, Folder>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public SearchFoldersRequest injectToken(SearchFoldersRequest payload, String token) {
              return SearchFoldersRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public SearchFoldersRequest injectPageSize(SearchFoldersRequest payload, int pageSize) {
              return SearchFoldersRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(SearchFoldersRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(SearchFoldersResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Folder> extractResources(SearchFoldersResponse payload) {
              return payload.getFoldersList() != null
                  ? payload.getFoldersList()
                  : ImmutableList.<Folder>of();
            }
          };

  private static final PagedListResponseFactory<
          ListFoldersRequest, ListFoldersResponse, ListFoldersPagedResponse>
      LIST_FOLDERS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListFoldersRequest, ListFoldersResponse, ListFoldersPagedResponse>() {
            @Override
            public ApiFuture<ListFoldersPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListFoldersRequest, ListFoldersResponse> callable,
                ListFoldersRequest request,
                ApiCallContext context,
                ApiFuture<ListFoldersResponse> futureResponse) {
              PageContext<ListFoldersRequest, ListFoldersResponse, Folder> pageContext =
                  PageContext.create(callable, LIST_FOLDERS_PAGE_STR_DESC, request, context);
              return ListFoldersPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          SearchFoldersRequest, SearchFoldersResponse, SearchFoldersPagedResponse>
      SEARCH_FOLDERS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              SearchFoldersRequest, SearchFoldersResponse, SearchFoldersPagedResponse>() {
            @Override
            public ApiFuture<SearchFoldersPagedResponse> getFuturePagedResponse(
                UnaryCallable<SearchFoldersRequest, SearchFoldersResponse> callable,
                SearchFoldersRequest request,
                ApiCallContext context,
                ApiFuture<SearchFoldersResponse> futureResponse) {
              PageContext<SearchFoldersRequest, SearchFoldersResponse, Folder> pageContext =
                  PageContext.create(callable, SEARCH_FOLDERS_PAGE_STR_DESC, request, context);
              return SearchFoldersPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Builder for FoldersStubSettings. */
  public static class Builder extends StubSettings.Builder<FoldersStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;

    private final PagedCallSettings.Builder<
            ListFoldersRequest, ListFoldersResponse, ListFoldersPagedResponse>
        listFoldersSettings;
    private final PagedCallSettings.Builder<
            SearchFoldersRequest, SearchFoldersResponse, SearchFoldersPagedResponse>
        searchFoldersSettings;
    private final UnaryCallSettings.Builder<GetFolderRequest, Folder> getFolderSettings;
    private final UnaryCallSettings.Builder<CreateFolderRequest, Operation> createFolderSettings;
    private final UnaryCallSettings.Builder<UpdateFolderRequest, Folder> updateFolderSettings;
    private final UnaryCallSettings.Builder<MoveFolderRequest, Operation> moveFolderSettings;
    private final UnaryCallSettings.Builder<DeleteFolderRequest, Folder> deleteFolderSettings;
    private final UnaryCallSettings.Builder<UndeleteFolderRequest, Folder> undeleteFolderSettings;
    private final UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings;
    private final UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings;
    private final UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings;

    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "idempotent",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
      definitions.put("non_idempotent", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(30000L))
              .setInitialRpcTimeout(Duration.ofMillis(20000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(20000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("default", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listFoldersSettings = PagedCallSettings.newBuilder(LIST_FOLDERS_PAGE_STR_FACT);

      searchFoldersSettings = PagedCallSettings.newBuilder(SEARCH_FOLDERS_PAGE_STR_FACT);

      getFolderSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      createFolderSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      updateFolderSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      moveFolderSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      deleteFolderSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      undeleteFolderSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listFoldersSettings,
              searchFoldersSettings,
              getFolderSettings,
              createFolderSettings,
              updateFolderSettings,
              moveFolderSettings,
              deleteFolderSettings,
              undeleteFolderSettings,
              getIamPolicySettings,
              setIamPolicySettings,
              testIamPermissionsSettings);

      initDefaults(this);
    }

    private static Builder createDefault() {
      Builder builder = new Builder((ClientContext) null);
      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {

      builder
          .listFoldersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .searchFoldersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getFolderSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .createFolderSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .updateFolderSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .moveFolderSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .deleteFolderSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .undeleteFolderSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .setIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .testIamPermissionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    protected Builder(FoldersStubSettings settings) {
      super(settings);

      listFoldersSettings = settings.listFoldersSettings.toBuilder();
      searchFoldersSettings = settings.searchFoldersSettings.toBuilder();
      getFolderSettings = settings.getFolderSettings.toBuilder();
      createFolderSettings = settings.createFolderSettings.toBuilder();
      updateFolderSettings = settings.updateFolderSettings.toBuilder();
      moveFolderSettings = settings.moveFolderSettings.toBuilder();
      deleteFolderSettings = settings.deleteFolderSettings.toBuilder();
      undeleteFolderSettings = settings.undeleteFolderSettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listFoldersSettings,
              searchFoldersSettings,
              getFolderSettings,
              createFolderSettings,
              updateFolderSettings,
              moveFolderSettings,
              deleteFolderSettings,
              undeleteFolderSettings,
              getIamPolicySettings,
              setIamPolicySettings,
              testIamPermissionsSettings);
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'
    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) throws Exception {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
    }

    public ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders() {
      return unaryMethodSettingsBuilders;
    }

    /** Returns the builder for the settings used for calls to listFolders. */
    public PagedCallSettings.Builder<
            ListFoldersRequest, ListFoldersResponse, ListFoldersPagedResponse>
        listFoldersSettings() {
      return listFoldersSettings;
    }

    /** Returns the builder for the settings used for calls to searchFolders. */
    public PagedCallSettings.Builder<
            SearchFoldersRequest, SearchFoldersResponse, SearchFoldersPagedResponse>
        searchFoldersSettings() {
      return searchFoldersSettings;
    }

    /** Returns the builder for the settings used for calls to getFolder. */
    public UnaryCallSettings.Builder<GetFolderRequest, Folder> getFolderSettings() {
      return getFolderSettings;
    }

    /** Returns the builder for the settings used for calls to createFolder. */
    public UnaryCallSettings.Builder<CreateFolderRequest, Operation> createFolderSettings() {
      return createFolderSettings;
    }

    /** Returns the builder for the settings used for calls to updateFolder. */
    public UnaryCallSettings.Builder<UpdateFolderRequest, Folder> updateFolderSettings() {
      return updateFolderSettings;
    }

    /** Returns the builder for the settings used for calls to moveFolder. */
    public UnaryCallSettings.Builder<MoveFolderRequest, Operation> moveFolderSettings() {
      return moveFolderSettings;
    }

    /** Returns the builder for the settings used for calls to deleteFolder. */
    public UnaryCallSettings.Builder<DeleteFolderRequest, Folder> deleteFolderSettings() {
      return deleteFolderSettings;
    }

    /** Returns the builder for the settings used for calls to undeleteFolder. */
    public UnaryCallSettings.Builder<UndeleteFolderRequest, Folder> undeleteFolderSettings() {
      return undeleteFolderSettings;
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return setIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return testIamPermissionsSettings;
    }

    @Override
    public FoldersStubSettings build() throws IOException {
      return new FoldersStubSettings(this);
    }
  }
}
