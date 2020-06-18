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

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.resourcemanager.v2.stub.FoldersStub;
import com.google.cloud.resourcemanager.v2.stub.FoldersStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: Manages Cloud Resource Folders. Cloud Resource Folders can be used to
 * organize the resources under an organization and to control the IAM policies applied to groups of
 * resources.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (FoldersClient foldersClient = FoldersClient.create()) {
 *   FolderName name = FolderName.of("[FOLDER]");
 *   Folder response = foldersClient.getFolder(name);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the foldersClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li>A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li>A "request object" method. This type of method only takes one parameter, a request object,
 *       which must be constructed before the call. Not every API method will have a request object
 *       method.
 *   <li>A "callable" method. This type of method takes no parameters and returns an immutable API
 *       callable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of FoldersSettings to create().
 * For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * FoldersSettings foldersSettings =
 *     FoldersSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * FoldersClient foldersClient =
 *     FoldersClient.create(foldersSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * FoldersSettings foldersSettings =
 *     FoldersSettings.newBuilder().setEndpoint(myEndpoint).build();
 * FoldersClient foldersClient =
 *     FoldersClient.create(foldersSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class FoldersClient implements BackgroundResource {
  private final FoldersSettings settings;
  private final FoldersStub stub;

  /** Constructs an instance of FoldersClient with default settings. */
  public static final FoldersClient create() throws IOException {
    return create(FoldersSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of FoldersClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final FoldersClient create(FoldersSettings settings) throws IOException {
    return new FoldersClient(settings);
  }

  /**
   * Constructs an instance of FoldersClient, using the given stub for making calls. This is for
   * advanced usage - prefer to use FoldersSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final FoldersClient create(FoldersStub stub) {
    return new FoldersClient(stub);
  }

  /**
   * Constructs an instance of FoldersClient, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected FoldersClient(FoldersSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((FoldersStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected FoldersClient(FoldersStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final FoldersSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public FoldersStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the Folders that are direct descendants of supplied parent resource. List provides a
   * strongly consistent view of the Folders underneath the specified parent resource. List returns
   * Folders sorted based upon the (ascending) lexical ordering of their display_name. The caller
   * must have `resourcemanager.folders.list` permission on the identified parent.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   ParentName parent = OrganizationName.of("[ORG_ID]");
   *   boolean showDeleted = false;
   *   for (Folder element : foldersClient.listFolders(parent, showDeleted).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent Required. The resource name of the Organization or Folder whose Folders are being
   *     listed. Must be of the form `folders/{folder_id}` or `organizations/{org_id}`. Access to
   *     this method is controlled by checking the `resourcemanager.folders.list` permission on the
   *     `parent`.
   * @param showDeleted Optional. Controls whether Folders in the
   *     [DELETE_REQUESTED][google.cloud.resourcemanager.v2.Folder.LifecycleState.DELETE_REQUESTED]
   *     state should be returned. Defaults to false.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFoldersPagedResponse listFolders(ParentName parent, boolean showDeleted) {
    ListFoldersRequest request =
        ListFoldersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setShowDeleted(showDeleted)
            .build();
    return listFolders(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the Folders that are direct descendants of supplied parent resource. List provides a
   * strongly consistent view of the Folders underneath the specified parent resource. List returns
   * Folders sorted based upon the (ascending) lexical ordering of their display_name. The caller
   * must have `resourcemanager.folders.list` permission on the identified parent.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   ParentName parent = OrganizationName.of("[ORG_ID]");
   *   boolean showDeleted = false;
   *   for (Folder element : foldersClient.listFolders(parent.toString(), showDeleted).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent Required. The resource name of the Organization or Folder whose Folders are being
   *     listed. Must be of the form `folders/{folder_id}` or `organizations/{org_id}`. Access to
   *     this method is controlled by checking the `resourcemanager.folders.list` permission on the
   *     `parent`.
   * @param showDeleted Optional. Controls whether Folders in the
   *     [DELETE_REQUESTED][google.cloud.resourcemanager.v2.Folder.LifecycleState.DELETE_REQUESTED]
   *     state should be returned. Defaults to false.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFoldersPagedResponse listFolders(String parent, boolean showDeleted) {
    ListFoldersRequest request =
        ListFoldersRequest.newBuilder().setParent(parent).setShowDeleted(showDeleted).build();
    return listFolders(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the Folders that are direct descendants of supplied parent resource. List provides a
   * strongly consistent view of the Folders underneath the specified parent resource. List returns
   * Folders sorted based upon the (ascending) lexical ordering of their display_name. The caller
   * must have `resourcemanager.folders.list` permission on the identified parent.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   ParentName parent = OrganizationName.of("[ORG_ID]");
   *   for (Folder element : foldersClient.listFolders(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent Required. The resource name of the Organization or Folder whose Folders are being
   *     listed. Must be of the form `folders/{folder_id}` or `organizations/{org_id}`. Access to
   *     this method is controlled by checking the `resourcemanager.folders.list` permission on the
   *     `parent`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFoldersPagedResponse listFolders(ParentName parent) {
    ListFoldersRequest request =
        ListFoldersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listFolders(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the Folders that are direct descendants of supplied parent resource. List provides a
   * strongly consistent view of the Folders underneath the specified parent resource. List returns
   * Folders sorted based upon the (ascending) lexical ordering of their display_name. The caller
   * must have `resourcemanager.folders.list` permission on the identified parent.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   ParentName parent = OrganizationName.of("[ORG_ID]");
   *   for (Folder element : foldersClient.listFolders(parent.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent Required. The resource name of the Organization or Folder whose Folders are being
   *     listed. Must be of the form `folders/{folder_id}` or `organizations/{org_id}`. Access to
   *     this method is controlled by checking the `resourcemanager.folders.list` permission on the
   *     `parent`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFoldersPagedResponse listFolders(String parent) {
    ListFoldersRequest request = ListFoldersRequest.newBuilder().setParent(parent).build();
    return listFolders(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the Folders that are direct descendants of supplied parent resource. List provides a
   * strongly consistent view of the Folders underneath the specified parent resource. List returns
   * Folders sorted based upon the (ascending) lexical ordering of their display_name. The caller
   * must have `resourcemanager.folders.list` permission on the identified parent.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   ParentName parent = OrganizationName.of("[ORG_ID]");
   *   ListFoldersRequest request = ListFoldersRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   for (Folder element : foldersClient.listFolders(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFoldersPagedResponse listFolders(ListFoldersRequest request) {
    return listFoldersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the Folders that are direct descendants of supplied parent resource. List provides a
   * strongly consistent view of the Folders underneath the specified parent resource. List returns
   * Folders sorted based upon the (ascending) lexical ordering of their display_name. The caller
   * must have `resourcemanager.folders.list` permission on the identified parent.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   ParentName parent = OrganizationName.of("[ORG_ID]");
   *   ListFoldersRequest request = ListFoldersRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   ApiFuture&lt;ListFoldersPagedResponse&gt; future = foldersClient.listFoldersPagedCallable().futureCall(request);
   *   // Do something
   *   for (Folder element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListFoldersRequest, ListFoldersPagedResponse>
      listFoldersPagedCallable() {
    return stub.listFoldersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the Folders that are direct descendants of supplied parent resource. List provides a
   * strongly consistent view of the Folders underneath the specified parent resource. List returns
   * Folders sorted based upon the (ascending) lexical ordering of their display_name. The caller
   * must have `resourcemanager.folders.list` permission on the identified parent.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   ParentName parent = OrganizationName.of("[ORG_ID]");
   *   ListFoldersRequest request = ListFoldersRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   while (true) {
   *     ListFoldersResponse response = foldersClient.listFoldersCallable().call(request);
   *     for (Folder element : response.getFoldersList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListFoldersRequest, ListFoldersResponse> listFoldersCallable() {
    return stub.listFoldersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Search for folders that match specific filter criteria. Search provides an eventually
   * consistent view of the folders a user has access to which meet the specified filter criteria.
   *
   * <p>This will only return folders on which the caller has the permission
   * `resourcemanager.folders.get`.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   String query = "";
   *   for (Folder element : foldersClient.searchFolders(query).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param query Search criteria used to select the Folders to return. If no search criteria is
   *     specified then all accessible folders will be returned.
   *     <p>Query expressions can be used to restrict results based upon displayName, lifecycleState
   *     and parent, where the operators `=`, `NOT`, `AND` and `OR` can be used along with the
   *     suffix wildcard symbol `&#42;`.
   *     <p>The displayName field in a query expression should use escaped quotes for values that
   *     include whitespace to prevent unexpected behavior.
   *     <p>Some example queries are:
   *     <p>&#42; Query `displayName=Test&#42;` returns Folder resources whose display name starts
   *     with "Test". &#42; Query `lifecycleState=ACTIVE` returns Folder resources with
   *     `lifecycleState` set to `ACTIVE`. &#42; Query `parent=folders/123` returns Folder resources
   *     that have `folders/123` as a parent resource. &#42; Query `parent=folders/123 AND
   *     lifecycleState=ACTIVE` returns active Folder resources that have `folders/123` as a parent
   *     resource. &#42; Query `displayName=\\"Test String\\"` returns Folder resources with display
   *     names that include both "Test" and "String".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchFoldersPagedResponse searchFolders(String query) {
    SearchFoldersRequest request = SearchFoldersRequest.newBuilder().setQuery(query).build();
    return searchFolders(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Search for folders that match specific filter criteria. Search provides an eventually
   * consistent view of the folders a user has access to which meet the specified filter criteria.
   *
   * <p>This will only return folders on which the caller has the permission
   * `resourcemanager.folders.get`.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   SearchFoldersRequest request = SearchFoldersRequest.newBuilder().build();
   *   for (Folder element : foldersClient.searchFolders(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchFoldersPagedResponse searchFolders(SearchFoldersRequest request) {
    return searchFoldersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Search for folders that match specific filter criteria. Search provides an eventually
   * consistent view of the folders a user has access to which meet the specified filter criteria.
   *
   * <p>This will only return folders on which the caller has the permission
   * `resourcemanager.folders.get`.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   SearchFoldersRequest request = SearchFoldersRequest.newBuilder().build();
   *   ApiFuture&lt;SearchFoldersPagedResponse&gt; future = foldersClient.searchFoldersPagedCallable().futureCall(request);
   *   // Do something
   *   for (Folder element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<SearchFoldersRequest, SearchFoldersPagedResponse>
      searchFoldersPagedCallable() {
    return stub.searchFoldersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Search for folders that match specific filter criteria. Search provides an eventually
   * consistent view of the folders a user has access to which meet the specified filter criteria.
   *
   * <p>This will only return folders on which the caller has the permission
   * `resourcemanager.folders.get`.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   SearchFoldersRequest request = SearchFoldersRequest.newBuilder().build();
   *   while (true) {
   *     SearchFoldersResponse response = foldersClient.searchFoldersCallable().call(request);
   *     for (Folder element : response.getFoldersList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<SearchFoldersRequest, SearchFoldersResponse> searchFoldersCallable() {
    return stub.searchFoldersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a Folder identified by the supplied resource name. Valid Folder resource names have
   * the format `folders/{folder_id}` (for example, `folders/1234`). The caller must have
   * `resourcemanager.folders.get` permission on the identified folder.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   FolderName name = FolderName.of("[FOLDER]");
   *   Folder response = foldersClient.getFolder(name);
   * }
   * </code></pre>
   *
   * @param name Required. The resource name of the Folder to retrieve. Must be of the form
   *     `folders/{folder_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Folder getFolder(FolderName name) {
    GetFolderRequest request =
        GetFolderRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getFolder(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a Folder identified by the supplied resource name. Valid Folder resource names have
   * the format `folders/{folder_id}` (for example, `folders/1234`). The caller must have
   * `resourcemanager.folders.get` permission on the identified folder.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   FolderName name = FolderName.of("[FOLDER]");
   *   Folder response = foldersClient.getFolder(name.toString());
   * }
   * </code></pre>
   *
   * @param name Required. The resource name of the Folder to retrieve. Must be of the form
   *     `folders/{folder_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Folder getFolder(String name) {
    GetFolderRequest request = GetFolderRequest.newBuilder().setName(name).build();
    return getFolder(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a Folder identified by the supplied resource name. Valid Folder resource names have
   * the format `folders/{folder_id}` (for example, `folders/1234`). The caller must have
   * `resourcemanager.folders.get` permission on the identified folder.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   FolderName name = FolderName.of("[FOLDER]");
   *   GetFolderRequest request = GetFolderRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   Folder response = foldersClient.getFolder(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Folder getFolder(GetFolderRequest request) {
    return getFolderCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a Folder identified by the supplied resource name. Valid Folder resource names have
   * the format `folders/{folder_id}` (for example, `folders/1234`). The caller must have
   * `resourcemanager.folders.get` permission on the identified folder.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   FolderName name = FolderName.of("[FOLDER]");
   *   GetFolderRequest request = GetFolderRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;Folder&gt; future = foldersClient.getFolderCallable().futureCall(request);
   *   // Do something
   *   Folder response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetFolderRequest, Folder> getFolderCallable() {
    return stub.getFolderCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a Folder in the resource hierarchy. Returns an Operation which can be used to track the
   * progress of the folder creation workflow. Upon success the Operation.response field will be
   * populated with the created Folder.
   *
   * <p>In order to succeed, the addition of this new Folder must not violate the Folder naming,
   * height or fanout constraints.
   *
   * <p>+ The Folder's display_name must be distinct from all other Folder's that share its parent.
   * + The addition of the Folder must not cause the active Folder hierarchy to exceed a height of
   * 4. Note, the full active + deleted Folder hierarchy is allowed to reach a height of 8; this
   * provides additional headroom when moving folders that contain deleted folders. + The addition
   * of the Folder must not cause the total number of Folders under its parent to exceed 100.
   *
   * <p>If the operation fails due to a folder constraint violation, some errors may be returned by
   * the CreateFolder request, with status code FAILED_PRECONDITION and an error description. Other
   * folder constraint violations will be communicated in the Operation, with the specific
   * PreconditionFailure returned via the details list in the Operation.error field.
   *
   * <p>The caller must have `resourcemanager.folders.create` permission on the identified parent.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   ParentName parent = OrganizationName.of("[ORG_ID]");
   *   Folder folder = Folder.newBuilder().build();
   *   Operation response = foldersClient.createFolder(parent, folder);
   * }
   * </code></pre>
   *
   * @param parent Required. The resource name of the new Folder's parent. Must be of the form
   *     `folders/{folder_id}` or `organizations/{org_id}`.
   * @param folder Required. The Folder being created, only the display name will be consulted. All
   *     other fields will be ignored.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation createFolder(ParentName parent, Folder folder) {
    CreateFolderRequest request =
        CreateFolderRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setFolder(folder)
            .build();
    return createFolder(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a Folder in the resource hierarchy. Returns an Operation which can be used to track the
   * progress of the folder creation workflow. Upon success the Operation.response field will be
   * populated with the created Folder.
   *
   * <p>In order to succeed, the addition of this new Folder must not violate the Folder naming,
   * height or fanout constraints.
   *
   * <p>+ The Folder's display_name must be distinct from all other Folder's that share its parent.
   * + The addition of the Folder must not cause the active Folder hierarchy to exceed a height of
   * 4. Note, the full active + deleted Folder hierarchy is allowed to reach a height of 8; this
   * provides additional headroom when moving folders that contain deleted folders. + The addition
   * of the Folder must not cause the total number of Folders under its parent to exceed 100.
   *
   * <p>If the operation fails due to a folder constraint violation, some errors may be returned by
   * the CreateFolder request, with status code FAILED_PRECONDITION and an error description. Other
   * folder constraint violations will be communicated in the Operation, with the specific
   * PreconditionFailure returned via the details list in the Operation.error field.
   *
   * <p>The caller must have `resourcemanager.folders.create` permission on the identified parent.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   ParentName parent = OrganizationName.of("[ORG_ID]");
   *   Folder folder = Folder.newBuilder().build();
   *   Operation response = foldersClient.createFolder(parent.toString(), folder);
   * }
   * </code></pre>
   *
   * @param parent Required. The resource name of the new Folder's parent. Must be of the form
   *     `folders/{folder_id}` or `organizations/{org_id}`.
   * @param folder Required. The Folder being created, only the display name will be consulted. All
   *     other fields will be ignored.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation createFolder(String parent, Folder folder) {
    CreateFolderRequest request =
        CreateFolderRequest.newBuilder().setParent(parent).setFolder(folder).build();
    return createFolder(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a Folder in the resource hierarchy. Returns an Operation which can be used to track the
   * progress of the folder creation workflow. Upon success the Operation.response field will be
   * populated with the created Folder.
   *
   * <p>In order to succeed, the addition of this new Folder must not violate the Folder naming,
   * height or fanout constraints.
   *
   * <p>+ The Folder's display_name must be distinct from all other Folder's that share its parent.
   * + The addition of the Folder must not cause the active Folder hierarchy to exceed a height of
   * 4. Note, the full active + deleted Folder hierarchy is allowed to reach a height of 8; this
   * provides additional headroom when moving folders that contain deleted folders. + The addition
   * of the Folder must not cause the total number of Folders under its parent to exceed 100.
   *
   * <p>If the operation fails due to a folder constraint violation, some errors may be returned by
   * the CreateFolder request, with status code FAILED_PRECONDITION and an error description. Other
   * folder constraint violations will be communicated in the Operation, with the specific
   * PreconditionFailure returned via the details list in the Operation.error field.
   *
   * <p>The caller must have `resourcemanager.folders.create` permission on the identified parent.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   ParentName parent = OrganizationName.of("[ORG_ID]");
   *   Folder folder = Folder.newBuilder().build();
   *   CreateFolderRequest request = CreateFolderRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setFolder(folder)
   *     .build();
   *   Operation response = foldersClient.createFolder(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation createFolder(CreateFolderRequest request) {
    return createFolderCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a Folder in the resource hierarchy. Returns an Operation which can be used to track the
   * progress of the folder creation workflow. Upon success the Operation.response field will be
   * populated with the created Folder.
   *
   * <p>In order to succeed, the addition of this new Folder must not violate the Folder naming,
   * height or fanout constraints.
   *
   * <p>+ The Folder's display_name must be distinct from all other Folder's that share its parent.
   * + The addition of the Folder must not cause the active Folder hierarchy to exceed a height of
   * 4. Note, the full active + deleted Folder hierarchy is allowed to reach a height of 8; this
   * provides additional headroom when moving folders that contain deleted folders. + The addition
   * of the Folder must not cause the total number of Folders under its parent to exceed 100.
   *
   * <p>If the operation fails due to a folder constraint violation, some errors may be returned by
   * the CreateFolder request, with status code FAILED_PRECONDITION and an error description. Other
   * folder constraint violations will be communicated in the Operation, with the specific
   * PreconditionFailure returned via the details list in the Operation.error field.
   *
   * <p>The caller must have `resourcemanager.folders.create` permission on the identified parent.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   ParentName parent = OrganizationName.of("[ORG_ID]");
   *   Folder folder = Folder.newBuilder().build();
   *   CreateFolderRequest request = CreateFolderRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setFolder(folder)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = foldersClient.createFolderCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CreateFolderRequest, Operation> createFolderCallable() {
    return stub.createFolderCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a Folder, changing its display_name. Changes to the folder display_name will be
   * rejected if they violate either the display_name formatting rules or naming constraints
   * described in the [CreateFolder][google.cloud.resourcemanager.v2.Folders.CreateFolder]
   * documentation.
   *
   * <p>The Folder's display name must start and end with a letter or digit, may contain letters,
   * digits, spaces, hyphens and underscores and can be no longer than 30 characters. This is
   * captured by the regular expression: [\p{L}\p{N}]([\p{L}\p{N}_- ]{0,28}[\p{L}\p{N}])?. The
   * caller must have `resourcemanager.folders.update` permission on the identified folder.
   *
   * <p>If the update fails due to the unique name constraint then a PreconditionFailure explaining
   * this violation will be returned in the Status.details field.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   Folder folder = Folder.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Folder response = foldersClient.updateFolder(folder, updateMask);
   * }
   * </code></pre>
   *
   * @param folder Required. The new definition of the Folder. It must include a a `name` and
   *     `display_name` field. The other fields will be ignored.
   * @param updateMask Required. Fields to be updated. Only the `display_name` can be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Folder updateFolder(Folder folder, FieldMask updateMask) {
    UpdateFolderRequest request =
        UpdateFolderRequest.newBuilder().setFolder(folder).setUpdateMask(updateMask).build();
    return updateFolder(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a Folder, changing its display_name. Changes to the folder display_name will be
   * rejected if they violate either the display_name formatting rules or naming constraints
   * described in the [CreateFolder][google.cloud.resourcemanager.v2.Folders.CreateFolder]
   * documentation.
   *
   * <p>The Folder's display name must start and end with a letter or digit, may contain letters,
   * digits, spaces, hyphens and underscores and can be no longer than 30 characters. This is
   * captured by the regular expression: [\p{L}\p{N}]([\p{L}\p{N}_- ]{0,28}[\p{L}\p{N}])?. The
   * caller must have `resourcemanager.folders.update` permission on the identified folder.
   *
   * <p>If the update fails due to the unique name constraint then a PreconditionFailure explaining
   * this violation will be returned in the Status.details field.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   Folder folder = Folder.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   UpdateFolderRequest request = UpdateFolderRequest.newBuilder()
   *     .setFolder(folder)
   *     .setUpdateMask(updateMask)
   *     .build();
   *   Folder response = foldersClient.updateFolder(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Folder updateFolder(UpdateFolderRequest request) {
    return updateFolderCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a Folder, changing its display_name. Changes to the folder display_name will be
   * rejected if they violate either the display_name formatting rules or naming constraints
   * described in the [CreateFolder][google.cloud.resourcemanager.v2.Folders.CreateFolder]
   * documentation.
   *
   * <p>The Folder's display name must start and end with a letter or digit, may contain letters,
   * digits, spaces, hyphens and underscores and can be no longer than 30 characters. This is
   * captured by the regular expression: [\p{L}\p{N}]([\p{L}\p{N}_- ]{0,28}[\p{L}\p{N}])?. The
   * caller must have `resourcemanager.folders.update` permission on the identified folder.
   *
   * <p>If the update fails due to the unique name constraint then a PreconditionFailure explaining
   * this violation will be returned in the Status.details field.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   Folder folder = Folder.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   UpdateFolderRequest request = UpdateFolderRequest.newBuilder()
   *     .setFolder(folder)
   *     .setUpdateMask(updateMask)
   *     .build();
   *   ApiFuture&lt;Folder&gt; future = foldersClient.updateFolderCallable().futureCall(request);
   *   // Do something
   *   Folder response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UpdateFolderRequest, Folder> updateFolderCallable() {
    return stub.updateFolderCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Moves a Folder under a new resource parent. Returns an Operation which can be used to track the
   * progress of the folder move workflow. Upon success the Operation.response field will be
   * populated with the moved Folder. Upon failure, a FolderOperationError categorizing the failure
   * cause will be returned - if the failure occurs synchronously then the FolderOperationError will
   * be returned via the Status.details field and if it occurs asynchronously then the
   * FolderOperation will be returned via the Operation.error field. In addition, the
   * Operation.metadata field will be populated with a FolderOperation message as an aid to
   * stateless clients. Folder moves will be rejected if they violate either the naming, height or
   * fanout constraints described in the
   * [CreateFolder][google.cloud.resourcemanager.v2.Folders.CreateFolder] documentation. The caller
   * must have `resourcemanager.folders.move` permission on the folder's current and proposed new
   * parent.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   FolderName name = FolderName.of("[FOLDER]");
   *   ParentName destinationParent = OrganizationName.of("[ORG_ID]");
   *   Operation response = foldersClient.moveFolder(name, destinationParent);
   * }
   * </code></pre>
   *
   * @param name Required. The resource name of the Folder to move. Must be of the form
   *     folders/{folder_id}
   * @param destinationParent Required. The resource name of the Folder or Organization to reparent
   *     the folder under. Must be of the form `folders/{folder_id}` or `organizations/{org_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation moveFolder(FolderName name, ParentName destinationParent) {
    MoveFolderRequest request =
        MoveFolderRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setDestinationParent(destinationParent == null ? null : destinationParent.toString())
            .build();
    return moveFolder(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Moves a Folder under a new resource parent. Returns an Operation which can be used to track the
   * progress of the folder move workflow. Upon success the Operation.response field will be
   * populated with the moved Folder. Upon failure, a FolderOperationError categorizing the failure
   * cause will be returned - if the failure occurs synchronously then the FolderOperationError will
   * be returned via the Status.details field and if it occurs asynchronously then the
   * FolderOperation will be returned via the Operation.error field. In addition, the
   * Operation.metadata field will be populated with a FolderOperation message as an aid to
   * stateless clients. Folder moves will be rejected if they violate either the naming, height or
   * fanout constraints described in the
   * [CreateFolder][google.cloud.resourcemanager.v2.Folders.CreateFolder] documentation. The caller
   * must have `resourcemanager.folders.move` permission on the folder's current and proposed new
   * parent.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   FolderName name = FolderName.of("[FOLDER]");
   *   ParentName destinationParent = OrganizationName.of("[ORG_ID]");
   *   Operation response = foldersClient.moveFolder(name.toString(), destinationParent.toString());
   * }
   * </code></pre>
   *
   * @param name Required. The resource name of the Folder to move. Must be of the form
   *     folders/{folder_id}
   * @param destinationParent Required. The resource name of the Folder or Organization to reparent
   *     the folder under. Must be of the form `folders/{folder_id}` or `organizations/{org_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation moveFolder(String name, String destinationParent) {
    MoveFolderRequest request =
        MoveFolderRequest.newBuilder()
            .setName(name)
            .setDestinationParent(destinationParent)
            .build();
    return moveFolder(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Moves a Folder under a new resource parent. Returns an Operation which can be used to track the
   * progress of the folder move workflow. Upon success the Operation.response field will be
   * populated with the moved Folder. Upon failure, a FolderOperationError categorizing the failure
   * cause will be returned - if the failure occurs synchronously then the FolderOperationError will
   * be returned via the Status.details field and if it occurs asynchronously then the
   * FolderOperation will be returned via the Operation.error field. In addition, the
   * Operation.metadata field will be populated with a FolderOperation message as an aid to
   * stateless clients. Folder moves will be rejected if they violate either the naming, height or
   * fanout constraints described in the
   * [CreateFolder][google.cloud.resourcemanager.v2.Folders.CreateFolder] documentation. The caller
   * must have `resourcemanager.folders.move` permission on the folder's current and proposed new
   * parent.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   FolderName name = FolderName.of("[FOLDER]");
   *   ParentName destinationParent = OrganizationName.of("[ORG_ID]");
   *   MoveFolderRequest request = MoveFolderRequest.newBuilder()
   *     .setName(name.toString())
   *     .setDestinationParent(destinationParent.toString())
   *     .build();
   *   Operation response = foldersClient.moveFolder(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation moveFolder(MoveFolderRequest request) {
    return moveFolderCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Moves a Folder under a new resource parent. Returns an Operation which can be used to track the
   * progress of the folder move workflow. Upon success the Operation.response field will be
   * populated with the moved Folder. Upon failure, a FolderOperationError categorizing the failure
   * cause will be returned - if the failure occurs synchronously then the FolderOperationError will
   * be returned via the Status.details field and if it occurs asynchronously then the
   * FolderOperation will be returned via the Operation.error field. In addition, the
   * Operation.metadata field will be populated with a FolderOperation message as an aid to
   * stateless clients. Folder moves will be rejected if they violate either the naming, height or
   * fanout constraints described in the
   * [CreateFolder][google.cloud.resourcemanager.v2.Folders.CreateFolder] documentation. The caller
   * must have `resourcemanager.folders.move` permission on the folder's current and proposed new
   * parent.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   FolderName name = FolderName.of("[FOLDER]");
   *   ParentName destinationParent = OrganizationName.of("[ORG_ID]");
   *   MoveFolderRequest request = MoveFolderRequest.newBuilder()
   *     .setName(name.toString())
   *     .setDestinationParent(destinationParent.toString())
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = foldersClient.moveFolderCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<MoveFolderRequest, Operation> moveFolderCallable() {
    return stub.moveFolderCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Requests deletion of a Folder. The Folder is moved into the
   * [DELETE_REQUESTED][google.cloud.resourcemanager.v2.Folder.LifecycleState.DELETE_REQUESTED]
   * state immediately, and is deleted approximately 30 days later. This method may only be called
   * on an empty Folder in the
   * [ACTIVE][google.cloud.resourcemanager.v2.Folder.LifecycleState.ACTIVE] state, where a Folder is
   * empty if it doesn't contain any Folders or Projects in the
   * [ACTIVE][google.cloud.resourcemanager.v2.Folder.LifecycleState.ACTIVE] state. The caller must
   * have `resourcemanager.folders.delete` permission on the identified folder.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   FolderName name = FolderName.of("[FOLDER]");
   *   Folder response = foldersClient.deleteFolder(name);
   * }
   * </code></pre>
   *
   * @param name Required. The resource name of the Folder to be deleted. Must be of the form
   *     `folders/{folder_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Folder deleteFolder(FolderName name) {
    DeleteFolderRequest request =
        DeleteFolderRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteFolder(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Requests deletion of a Folder. The Folder is moved into the
   * [DELETE_REQUESTED][google.cloud.resourcemanager.v2.Folder.LifecycleState.DELETE_REQUESTED]
   * state immediately, and is deleted approximately 30 days later. This method may only be called
   * on an empty Folder in the
   * [ACTIVE][google.cloud.resourcemanager.v2.Folder.LifecycleState.ACTIVE] state, where a Folder is
   * empty if it doesn't contain any Folders or Projects in the
   * [ACTIVE][google.cloud.resourcemanager.v2.Folder.LifecycleState.ACTIVE] state. The caller must
   * have `resourcemanager.folders.delete` permission on the identified folder.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   FolderName name = FolderName.of("[FOLDER]");
   *   Folder response = foldersClient.deleteFolder(name.toString());
   * }
   * </code></pre>
   *
   * @param name Required. The resource name of the Folder to be deleted. Must be of the form
   *     `folders/{folder_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Folder deleteFolder(String name) {
    DeleteFolderRequest request = DeleteFolderRequest.newBuilder().setName(name).build();
    return deleteFolder(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Requests deletion of a Folder. The Folder is moved into the
   * [DELETE_REQUESTED][google.cloud.resourcemanager.v2.Folder.LifecycleState.DELETE_REQUESTED]
   * state immediately, and is deleted approximately 30 days later. This method may only be called
   * on an empty Folder in the
   * [ACTIVE][google.cloud.resourcemanager.v2.Folder.LifecycleState.ACTIVE] state, where a Folder is
   * empty if it doesn't contain any Folders or Projects in the
   * [ACTIVE][google.cloud.resourcemanager.v2.Folder.LifecycleState.ACTIVE] state. The caller must
   * have `resourcemanager.folders.delete` permission on the identified folder.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   FolderName name = FolderName.of("[FOLDER]");
   *   boolean recursiveDelete = false;
   *   Folder response = foldersClient.deleteFolder(name, recursiveDelete);
   * }
   * </code></pre>
   *
   * @param name Required. The resource name of the Folder to be deleted. Must be of the form
   *     `folders/{folder_id}`.
   * @param recursiveDelete Instructs DeleteFolderAction to delete a folder even when the folder is
   *     not empty.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Folder deleteFolder(FolderName name, boolean recursiveDelete) {
    DeleteFolderRequest request =
        DeleteFolderRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setRecursiveDelete(recursiveDelete)
            .build();
    return deleteFolder(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Requests deletion of a Folder. The Folder is moved into the
   * [DELETE_REQUESTED][google.cloud.resourcemanager.v2.Folder.LifecycleState.DELETE_REQUESTED]
   * state immediately, and is deleted approximately 30 days later. This method may only be called
   * on an empty Folder in the
   * [ACTIVE][google.cloud.resourcemanager.v2.Folder.LifecycleState.ACTIVE] state, where a Folder is
   * empty if it doesn't contain any Folders or Projects in the
   * [ACTIVE][google.cloud.resourcemanager.v2.Folder.LifecycleState.ACTIVE] state. The caller must
   * have `resourcemanager.folders.delete` permission on the identified folder.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   FolderName name = FolderName.of("[FOLDER]");
   *   boolean recursiveDelete = false;
   *   Folder response = foldersClient.deleteFolder(name.toString(), recursiveDelete);
   * }
   * </code></pre>
   *
   * @param name Required. The resource name of the Folder to be deleted. Must be of the form
   *     `folders/{folder_id}`.
   * @param recursiveDelete Instructs DeleteFolderAction to delete a folder even when the folder is
   *     not empty.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Folder deleteFolder(String name, boolean recursiveDelete) {
    DeleteFolderRequest request =
        DeleteFolderRequest.newBuilder().setName(name).setRecursiveDelete(recursiveDelete).build();
    return deleteFolder(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Requests deletion of a Folder. The Folder is moved into the
   * [DELETE_REQUESTED][google.cloud.resourcemanager.v2.Folder.LifecycleState.DELETE_REQUESTED]
   * state immediately, and is deleted approximately 30 days later. This method may only be called
   * on an empty Folder in the
   * [ACTIVE][google.cloud.resourcemanager.v2.Folder.LifecycleState.ACTIVE] state, where a Folder is
   * empty if it doesn't contain any Folders or Projects in the
   * [ACTIVE][google.cloud.resourcemanager.v2.Folder.LifecycleState.ACTIVE] state. The caller must
   * have `resourcemanager.folders.delete` permission on the identified folder.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   FolderName name = FolderName.of("[FOLDER]");
   *   DeleteFolderRequest request = DeleteFolderRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   Folder response = foldersClient.deleteFolder(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Folder deleteFolder(DeleteFolderRequest request) {
    return deleteFolderCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Requests deletion of a Folder. The Folder is moved into the
   * [DELETE_REQUESTED][google.cloud.resourcemanager.v2.Folder.LifecycleState.DELETE_REQUESTED]
   * state immediately, and is deleted approximately 30 days later. This method may only be called
   * on an empty Folder in the
   * [ACTIVE][google.cloud.resourcemanager.v2.Folder.LifecycleState.ACTIVE] state, where a Folder is
   * empty if it doesn't contain any Folders or Projects in the
   * [ACTIVE][google.cloud.resourcemanager.v2.Folder.LifecycleState.ACTIVE] state. The caller must
   * have `resourcemanager.folders.delete` permission on the identified folder.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   FolderName name = FolderName.of("[FOLDER]");
   *   DeleteFolderRequest request = DeleteFolderRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;Folder&gt; future = foldersClient.deleteFolderCallable().futureCall(request);
   *   // Do something
   *   Folder response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteFolderRequest, Folder> deleteFolderCallable() {
    return stub.deleteFolderCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Cancels the deletion request for a Folder. This method may only be called on a Folder in the
   * [DELETE_REQUESTED][google.cloud.resourcemanager.v2.Folder.LifecycleState.DELETE_REQUESTED]
   * state. In order to succeed, the Folder's parent must be in the
   * [ACTIVE][google.cloud.resourcemanager.v2.Folder.LifecycleState.ACTIVE] state. In addition,
   * reintroducing the folder into the tree must not violate folder naming, height and fanout
   * constraints described in the
   * [CreateFolder][google.cloud.resourcemanager.v2.Folders.CreateFolder] documentation. The caller
   * must have `resourcemanager.folders.undelete` permission on the identified folder.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   FolderName name = FolderName.of("[FOLDER]");
   *   Folder response = foldersClient.undeleteFolder(name);
   * }
   * </code></pre>
   *
   * @param name Required. The resource name of the Folder to undelete. Must be of the form
   *     `folders/{folder_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Folder undeleteFolder(FolderName name) {
    UndeleteFolderRequest request =
        UndeleteFolderRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return undeleteFolder(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Cancels the deletion request for a Folder. This method may only be called on a Folder in the
   * [DELETE_REQUESTED][google.cloud.resourcemanager.v2.Folder.LifecycleState.DELETE_REQUESTED]
   * state. In order to succeed, the Folder's parent must be in the
   * [ACTIVE][google.cloud.resourcemanager.v2.Folder.LifecycleState.ACTIVE] state. In addition,
   * reintroducing the folder into the tree must not violate folder naming, height and fanout
   * constraints described in the
   * [CreateFolder][google.cloud.resourcemanager.v2.Folders.CreateFolder] documentation. The caller
   * must have `resourcemanager.folders.undelete` permission on the identified folder.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   FolderName name = FolderName.of("[FOLDER]");
   *   Folder response = foldersClient.undeleteFolder(name.toString());
   * }
   * </code></pre>
   *
   * @param name Required. The resource name of the Folder to undelete. Must be of the form
   *     `folders/{folder_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Folder undeleteFolder(String name) {
    UndeleteFolderRequest request = UndeleteFolderRequest.newBuilder().setName(name).build();
    return undeleteFolder(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Cancels the deletion request for a Folder. This method may only be called on a Folder in the
   * [DELETE_REQUESTED][google.cloud.resourcemanager.v2.Folder.LifecycleState.DELETE_REQUESTED]
   * state. In order to succeed, the Folder's parent must be in the
   * [ACTIVE][google.cloud.resourcemanager.v2.Folder.LifecycleState.ACTIVE] state. In addition,
   * reintroducing the folder into the tree must not violate folder naming, height and fanout
   * constraints described in the
   * [CreateFolder][google.cloud.resourcemanager.v2.Folders.CreateFolder] documentation. The caller
   * must have `resourcemanager.folders.undelete` permission on the identified folder.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   FolderName name = FolderName.of("[FOLDER]");
   *   UndeleteFolderRequest request = UndeleteFolderRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   Folder response = foldersClient.undeleteFolder(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Folder undeleteFolder(UndeleteFolderRequest request) {
    return undeleteFolderCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Cancels the deletion request for a Folder. This method may only be called on a Folder in the
   * [DELETE_REQUESTED][google.cloud.resourcemanager.v2.Folder.LifecycleState.DELETE_REQUESTED]
   * state. In order to succeed, the Folder's parent must be in the
   * [ACTIVE][google.cloud.resourcemanager.v2.Folder.LifecycleState.ACTIVE] state. In addition,
   * reintroducing the folder into the tree must not violate folder naming, height and fanout
   * constraints described in the
   * [CreateFolder][google.cloud.resourcemanager.v2.Folders.CreateFolder] documentation. The caller
   * must have `resourcemanager.folders.undelete` permission on the identified folder.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   FolderName name = FolderName.of("[FOLDER]");
   *   UndeleteFolderRequest request = UndeleteFolderRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;Folder&gt; future = foldersClient.undeleteFolderCallable().futureCall(request);
   *   // Do something
   *   Folder response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UndeleteFolderRequest, Folder> undeleteFolderCallable() {
    return stub.undeleteFolderCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the access control policy for a Folder. The returned policy may be empty if no such policy
   * or resource exists. The `resource` field should be the Folder's resource name, e.g.
   * "folders/1234". The caller must have `resourcemanager.folders.getIamPolicy` permission on the
   * identified folder.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   String formattedResource = FolderName.format("[FOLDER]");
   *   Policy response = foldersClient.getIamPolicy(formattedResource);
   * }
   * </code></pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(String resource) {
    GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder().setResource(resource).build();
    return getIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the access control policy for a Folder. The returned policy may be empty if no such policy
   * or resource exists. The `resource` field should be the Folder's resource name, e.g.
   * "folders/1234". The caller must have `resourcemanager.folders.getIamPolicy` permission on the
   * identified folder.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   String formattedResource = FolderName.format("[FOLDER]");
   *   GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .build();
   *   Policy response = foldersClient.getIamPolicy(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(GetIamPolicyRequest request) {
    return getIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the access control policy for a Folder. The returned policy may be empty if no such policy
   * or resource exists. The `resource` field should be the Folder's resource name, e.g.
   * "folders/1234". The caller must have `resourcemanager.folders.getIamPolicy` permission on the
   * identified folder.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   String formattedResource = FolderName.format("[FOLDER]");
   *   GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .build();
   *   ApiFuture&lt;Policy&gt; future = foldersClient.getIamPolicyCallable().futureCall(request);
   *   // Do something
   *   Policy response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return stub.getIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on a Folder, replacing any existing policy. The `resource` field
   * should be the Folder's resource name, e.g. "folders/1234". The caller must have
   * `resourcemanager.folders.setIamPolicy` permission on the identified folder.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   String formattedResource = FolderName.format("[FOLDER]");
   *   Policy policy = Policy.newBuilder().build();
   *   Policy response = foldersClient.setIamPolicy(formattedResource, policy);
   * }
   * </code></pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being specified. See the
   *     operation documentation for the appropriate value for this field.
   * @param policy REQUIRED: The complete policy to be applied to the `resource`. The size of the
   *     policy is limited to a few 10s of KB. An empty policy is a valid policy but certain Cloud
   *     Platform services (such as Projects) might reject them.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(String resource, Policy policy) {
    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder().setResource(resource).setPolicy(policy).build();
    return setIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on a Folder, replacing any existing policy. The `resource` field
   * should be the Folder's resource name, e.g. "folders/1234". The caller must have
   * `resourcemanager.folders.setIamPolicy` permission on the identified folder.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   String formattedResource = FolderName.format("[FOLDER]");
   *   Policy policy = Policy.newBuilder().build();
   *   SetIamPolicyRequest request = SetIamPolicyRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .setPolicy(policy)
   *     .build();
   *   Policy response = foldersClient.setIamPolicy(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(SetIamPolicyRequest request) {
    return setIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on a Folder, replacing any existing policy. The `resource` field
   * should be the Folder's resource name, e.g. "folders/1234". The caller must have
   * `resourcemanager.folders.setIamPolicy` permission on the identified folder.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   String formattedResource = FolderName.format("[FOLDER]");
   *   Policy policy = Policy.newBuilder().build();
   *   SetIamPolicyRequest request = SetIamPolicyRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .setPolicy(policy)
   *     .build();
   *   ApiFuture&lt;Policy&gt; future = foldersClient.setIamPolicyCallable().futureCall(request);
   *   // Do something
   *   Policy response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return stub.setIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified Folder. The `resource` field should be
   * the Folder's resource name, e.g. "folders/1234".
   *
   * <p>There are no permissions required for making this API call.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   String formattedResource = FolderName.format("[FOLDER]");
   *   List&lt;String&gt; permissions = new ArrayList&lt;&gt;();
   *   TestIamPermissionsResponse response = foldersClient.testIamPermissions(formattedResource, permissions);
   * }
   * </code></pre>
   *
   * @param resource REQUIRED: The resource for which the policy detail is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @param permissions The set of permissions to check for the `resource`. Permissions with
   *     wildcards (such as '&#42;' or 'storage.&#42;') are not allowed. For more information see
   *     [IAM Overview](https://cloud.google.com/iam/docs/overview#permissions).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(
      String resource, List<String> permissions) {
    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(resource)
            .addAllPermissions(permissions)
            .build();
    return testIamPermissions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified Folder. The `resource` field should be
   * the Folder's resource name, e.g. "folders/1234".
   *
   * <p>There are no permissions required for making this API call.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   String formattedResource = FolderName.format("[FOLDER]");
   *   List&lt;String&gt; permissions = new ArrayList&lt;&gt;();
   *   TestIamPermissionsRequest request = TestIamPermissionsRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .addAllPermissions(permissions)
   *     .build();
   *   TestIamPermissionsResponse response = foldersClient.testIamPermissions(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(TestIamPermissionsRequest request) {
    return testIamPermissionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified Folder. The `resource` field should be
   * the Folder's resource name, e.g. "folders/1234".
   *
   * <p>There are no permissions required for making this API call.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   String formattedResource = FolderName.format("[FOLDER]");
   *   List&lt;String&gt; permissions = new ArrayList&lt;&gt;();
   *   TestIamPermissionsRequest request = TestIamPermissionsRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .addAllPermissions(permissions)
   *     .build();
   *   ApiFuture&lt;TestIamPermissionsResponse&gt; future = foldersClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something
   *   TestIamPermissionsResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return stub.testIamPermissionsCallable();
  }

  @Override
  public final void close() {
    stub.close();
  }

  @Override
  public void shutdown() {
    stub.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return stub.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return stub.isTerminated();
  }

  @Override
  public void shutdownNow() {
    stub.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return stub.awaitTermination(duration, unit);
  }

  public static class ListFoldersPagedResponse
      extends AbstractPagedListResponse<
          ListFoldersRequest,
          ListFoldersResponse,
          Folder,
          ListFoldersPage,
          ListFoldersFixedSizeCollection> {

    public static ApiFuture<ListFoldersPagedResponse> createAsync(
        PageContext<ListFoldersRequest, ListFoldersResponse, Folder> context,
        ApiFuture<ListFoldersResponse> futureResponse) {
      ApiFuture<ListFoldersPage> futurePage =
          ListFoldersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListFoldersPage, ListFoldersPagedResponse>() {
            @Override
            public ListFoldersPagedResponse apply(ListFoldersPage input) {
              return new ListFoldersPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListFoldersPagedResponse(ListFoldersPage page) {
      super(page, ListFoldersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListFoldersPage
      extends AbstractPage<ListFoldersRequest, ListFoldersResponse, Folder, ListFoldersPage> {

    private ListFoldersPage(
        PageContext<ListFoldersRequest, ListFoldersResponse, Folder> context,
        ListFoldersResponse response) {
      super(context, response);
    }

    private static ListFoldersPage createEmptyPage() {
      return new ListFoldersPage(null, null);
    }

    @Override
    protected ListFoldersPage createPage(
        PageContext<ListFoldersRequest, ListFoldersResponse, Folder> context,
        ListFoldersResponse response) {
      return new ListFoldersPage(context, response);
    }

    @Override
    public ApiFuture<ListFoldersPage> createPageAsync(
        PageContext<ListFoldersRequest, ListFoldersResponse, Folder> context,
        ApiFuture<ListFoldersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFoldersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListFoldersRequest,
          ListFoldersResponse,
          Folder,
          ListFoldersPage,
          ListFoldersFixedSizeCollection> {

    private ListFoldersFixedSizeCollection(List<ListFoldersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListFoldersFixedSizeCollection createEmptyCollection() {
      return new ListFoldersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListFoldersFixedSizeCollection createCollection(
        List<ListFoldersPage> pages, int collectionSize) {
      return new ListFoldersFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class SearchFoldersPagedResponse
      extends AbstractPagedListResponse<
          SearchFoldersRequest,
          SearchFoldersResponse,
          Folder,
          SearchFoldersPage,
          SearchFoldersFixedSizeCollection> {

    public static ApiFuture<SearchFoldersPagedResponse> createAsync(
        PageContext<SearchFoldersRequest, SearchFoldersResponse, Folder> context,
        ApiFuture<SearchFoldersResponse> futureResponse) {
      ApiFuture<SearchFoldersPage> futurePage =
          SearchFoldersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<SearchFoldersPage, SearchFoldersPagedResponse>() {
            @Override
            public SearchFoldersPagedResponse apply(SearchFoldersPage input) {
              return new SearchFoldersPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private SearchFoldersPagedResponse(SearchFoldersPage page) {
      super(page, SearchFoldersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class SearchFoldersPage
      extends AbstractPage<SearchFoldersRequest, SearchFoldersResponse, Folder, SearchFoldersPage> {

    private SearchFoldersPage(
        PageContext<SearchFoldersRequest, SearchFoldersResponse, Folder> context,
        SearchFoldersResponse response) {
      super(context, response);
    }

    private static SearchFoldersPage createEmptyPage() {
      return new SearchFoldersPage(null, null);
    }

    @Override
    protected SearchFoldersPage createPage(
        PageContext<SearchFoldersRequest, SearchFoldersResponse, Folder> context,
        SearchFoldersResponse response) {
      return new SearchFoldersPage(context, response);
    }

    @Override
    public ApiFuture<SearchFoldersPage> createPageAsync(
        PageContext<SearchFoldersRequest, SearchFoldersResponse, Folder> context,
        ApiFuture<SearchFoldersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class SearchFoldersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          SearchFoldersRequest,
          SearchFoldersResponse,
          Folder,
          SearchFoldersPage,
          SearchFoldersFixedSizeCollection> {

    private SearchFoldersFixedSizeCollection(List<SearchFoldersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static SearchFoldersFixedSizeCollection createEmptyCollection() {
      return new SearchFoldersFixedSizeCollection(null, 0);
    }

    @Override
    protected SearchFoldersFixedSizeCollection createCollection(
        List<SearchFoldersPage> pages, int collectionSize) {
      return new SearchFoldersFixedSizeCollection(pages, collectionSize);
    }
  }
}
