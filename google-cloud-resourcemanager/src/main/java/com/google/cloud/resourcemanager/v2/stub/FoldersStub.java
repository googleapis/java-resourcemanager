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
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for Cloud Resource Manager API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class FoldersStub implements BackgroundResource {

  public UnaryCallable<ListFoldersRequest, ListFoldersPagedResponse> listFoldersPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listFoldersPagedCallable()");
  }

  public UnaryCallable<ListFoldersRequest, ListFoldersResponse> listFoldersCallable() {
    throw new UnsupportedOperationException("Not implemented: listFoldersCallable()");
  }

  public UnaryCallable<SearchFoldersRequest, SearchFoldersPagedResponse>
      searchFoldersPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: searchFoldersPagedCallable()");
  }

  public UnaryCallable<SearchFoldersRequest, SearchFoldersResponse> searchFoldersCallable() {
    throw new UnsupportedOperationException("Not implemented: searchFoldersCallable()");
  }

  public UnaryCallable<GetFolderRequest, Folder> getFolderCallable() {
    throw new UnsupportedOperationException("Not implemented: getFolderCallable()");
  }

  public UnaryCallable<CreateFolderRequest, Operation> createFolderCallable() {
    throw new UnsupportedOperationException("Not implemented: createFolderCallable()");
  }

  public UnaryCallable<UpdateFolderRequest, Folder> updateFolderCallable() {
    throw new UnsupportedOperationException("Not implemented: updateFolderCallable()");
  }

  public UnaryCallable<MoveFolderRequest, Operation> moveFolderCallable() {
    throw new UnsupportedOperationException("Not implemented: moveFolderCallable()");
  }

  public UnaryCallable<DeleteFolderRequest, Folder> deleteFolderCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteFolderCallable()");
  }

  public UnaryCallable<UndeleteFolderRequest, Folder> undeleteFolderCallable() {
    throw new UnsupportedOperationException("Not implemented: undeleteFolderCallable()");
  }

  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getIamPolicyCallable()");
  }

  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: setIamPolicyCallable()");
  }

  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    throw new UnsupportedOperationException("Not implemented: testIamPermissionsCallable()");
  }

  @Override
  public abstract void close();
}
