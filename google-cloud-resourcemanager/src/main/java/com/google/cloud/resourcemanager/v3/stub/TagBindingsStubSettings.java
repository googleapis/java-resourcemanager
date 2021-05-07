/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.resourcemanager.v3.stub;

import static com.google.cloud.resourcemanager.v3.TagBindingsClient.ListTagBindingsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.grpc.ProtoOperationTransformers;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.longrunning.OperationTimedPollAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.resourcemanager.v3.CreateTagBindingMetadata;
import com.google.cloud.resourcemanager.v3.CreateTagBindingRequest;
import com.google.cloud.resourcemanager.v3.DeleteTagBindingMetadata;
import com.google.cloud.resourcemanager.v3.DeleteTagBindingRequest;
import com.google.cloud.resourcemanager.v3.ListTagBindingsRequest;
import com.google.cloud.resourcemanager.v3.ListTagBindingsResponse;
import com.google.cloud.resourcemanager.v3.TagBinding;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link TagBindingsStub}.
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
 * <p>For example, to set the total timeout of listTagBindings to 30 seconds:
 *
 * <pre>{@code
 * TagBindingsStubSettings.Builder tagBindingsSettingsBuilder =
 *     TagBindingsStubSettings.newBuilder();
 * tagBindingsSettingsBuilder
 *     .listTagBindingsSettings()
 *     .setRetrySettings(
 *         tagBindingsSettingsBuilder
 *             .listTagBindingsSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * TagBindingsStubSettings tagBindingsSettings = tagBindingsSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class TagBindingsStubSettings extends StubSettings<TagBindingsStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/cloud-platform.read-only")
          .build();

  private final PagedCallSettings<
          ListTagBindingsRequest, ListTagBindingsResponse, ListTagBindingsPagedResponse>
      listTagBindingsSettings;
  private final UnaryCallSettings<CreateTagBindingRequest, Operation> createTagBindingSettings;
  private final OperationCallSettings<CreateTagBindingRequest, TagBinding, CreateTagBindingMetadata>
      createTagBindingOperationSettings;
  private final UnaryCallSettings<DeleteTagBindingRequest, Operation> deleteTagBindingSettings;
  private final OperationCallSettings<DeleteTagBindingRequest, Empty, DeleteTagBindingMetadata>
      deleteTagBindingOperationSettings;

  private static final PagedListDescriptor<
          ListTagBindingsRequest, ListTagBindingsResponse, TagBinding>
      LIST_TAG_BINDINGS_PAGE_STR_DESC =
          new PagedListDescriptor<ListTagBindingsRequest, ListTagBindingsResponse, TagBinding>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListTagBindingsRequest injectToken(
                ListTagBindingsRequest payload, String token) {
              return ListTagBindingsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListTagBindingsRequest injectPageSize(
                ListTagBindingsRequest payload, int pageSize) {
              return ListTagBindingsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListTagBindingsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListTagBindingsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<TagBinding> extractResources(ListTagBindingsResponse payload) {
              return payload.getTagBindingsList() == null
                  ? ImmutableList.<TagBinding>of()
                  : payload.getTagBindingsList();
            }
          };

  private static final PagedListResponseFactory<
          ListTagBindingsRequest, ListTagBindingsResponse, ListTagBindingsPagedResponse>
      LIST_TAG_BINDINGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListTagBindingsRequest, ListTagBindingsResponse, ListTagBindingsPagedResponse>() {
            @Override
            public ApiFuture<ListTagBindingsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListTagBindingsRequest, ListTagBindingsResponse> callable,
                ListTagBindingsRequest request,
                ApiCallContext context,
                ApiFuture<ListTagBindingsResponse> futureResponse) {
              PageContext<ListTagBindingsRequest, ListTagBindingsResponse, TagBinding> pageContext =
                  PageContext.create(callable, LIST_TAG_BINDINGS_PAGE_STR_DESC, request, context);
              return ListTagBindingsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listTagBindings. */
  public PagedCallSettings<
          ListTagBindingsRequest, ListTagBindingsResponse, ListTagBindingsPagedResponse>
      listTagBindingsSettings() {
    return listTagBindingsSettings;
  }

  /** Returns the object with the settings used for calls to createTagBinding. */
  public UnaryCallSettings<CreateTagBindingRequest, Operation> createTagBindingSettings() {
    return createTagBindingSettings;
  }

  /** Returns the object with the settings used for calls to createTagBinding. */
  public OperationCallSettings<CreateTagBindingRequest, TagBinding, CreateTagBindingMetadata>
      createTagBindingOperationSettings() {
    return createTagBindingOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteTagBinding. */
  public UnaryCallSettings<DeleteTagBindingRequest, Operation> deleteTagBindingSettings() {
    return deleteTagBindingSettings;
  }

  /** Returns the object with the settings used for calls to deleteTagBinding. */
  public OperationCallSettings<DeleteTagBindingRequest, Empty, DeleteTagBindingMetadata>
      deleteTagBindingOperationSettings() {
    return deleteTagBindingOperationSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public TagBindingsStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcTagBindingsStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
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
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(TagBindingsStubSettings.class))
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

  protected TagBindingsStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listTagBindingsSettings = settingsBuilder.listTagBindingsSettings().build();
    createTagBindingSettings = settingsBuilder.createTagBindingSettings().build();
    createTagBindingOperationSettings = settingsBuilder.createTagBindingOperationSettings().build();
    deleteTagBindingSettings = settingsBuilder.deleteTagBindingSettings().build();
    deleteTagBindingOperationSettings = settingsBuilder.deleteTagBindingOperationSettings().build();
  }

  /** Builder for TagBindingsStubSettings. */
  public static class Builder extends StubSettings.Builder<TagBindingsStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListTagBindingsRequest, ListTagBindingsResponse, ListTagBindingsPagedResponse>
        listTagBindingsSettings;
    private final UnaryCallSettings.Builder<CreateTagBindingRequest, Operation>
        createTagBindingSettings;
    private final OperationCallSettings.Builder<
            CreateTagBindingRequest, TagBinding, CreateTagBindingMetadata>
        createTagBindingOperationSettings;
    private final UnaryCallSettings.Builder<DeleteTagBindingRequest, Operation>
        deleteTagBindingSettings;
    private final OperationCallSettings.Builder<
            DeleteTagBindingRequest, Empty, DeleteTagBindingMetadata>
        deleteTagBindingOperationSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      definitions.put(
          "no_retry_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
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
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_1_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listTagBindingsSettings = PagedCallSettings.newBuilder(LIST_TAG_BINDINGS_PAGE_STR_FACT);
      createTagBindingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createTagBindingOperationSettings = OperationCallSettings.newBuilder();
      deleteTagBindingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteTagBindingOperationSettings = OperationCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listTagBindingsSettings, createTagBindingSettings, deleteTagBindingSettings);
      initDefaults(this);
    }

    protected Builder(TagBindingsStubSettings settings) {
      super(settings);

      listTagBindingsSettings = settings.listTagBindingsSettings.toBuilder();
      createTagBindingSettings = settings.createTagBindingSettings.toBuilder();
      createTagBindingOperationSettings = settings.createTagBindingOperationSettings.toBuilder();
      deleteTagBindingSettings = settings.deleteTagBindingSettings.toBuilder();
      deleteTagBindingOperationSettings = settings.deleteTagBindingOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listTagBindingsSettings, createTagBindingSettings, deleteTagBindingSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .listTagBindingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createTagBindingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteTagBindingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .createTagBindingOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateTagBindingRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(TagBinding.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(CreateTagBindingMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteTagBindingOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteTagBindingRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(DeleteTagBindingMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      return builder;
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'.
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

    /** Returns the builder for the settings used for calls to listTagBindings. */
    public PagedCallSettings.Builder<
            ListTagBindingsRequest, ListTagBindingsResponse, ListTagBindingsPagedResponse>
        listTagBindingsSettings() {
      return listTagBindingsSettings;
    }

    /** Returns the builder for the settings used for calls to createTagBinding. */
    public UnaryCallSettings.Builder<CreateTagBindingRequest, Operation>
        createTagBindingSettings() {
      return createTagBindingSettings;
    }

    /** Returns the builder for the settings used for calls to createTagBinding. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            CreateTagBindingRequest, TagBinding, CreateTagBindingMetadata>
        createTagBindingOperationSettings() {
      return createTagBindingOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteTagBinding. */
    public UnaryCallSettings.Builder<DeleteTagBindingRequest, Operation>
        deleteTagBindingSettings() {
      return deleteTagBindingSettings;
    }

    /** Returns the builder for the settings used for calls to deleteTagBinding. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteTagBindingRequest, Empty, DeleteTagBindingMetadata>
        deleteTagBindingOperationSettings() {
      return deleteTagBindingOperationSettings;
    }

    @Override
    public TagBindingsStubSettings build() throws IOException {
      return new TagBindingsStubSettings(this);
    }
  }
}
