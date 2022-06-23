/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.resourcemanager.v3.samples;

// [START resourcemanager_v3_generated_tagbindingsclient_createtagbinding_tagbinding_sync]
import com.google.cloud.resourcemanager.v3.TagBinding;
import com.google.cloud.resourcemanager.v3.TagBindingsClient;

public class SyncCreateTagBindingTagbinding {

  public static void main(String[] args) throws Exception {
    syncCreateTagBindingTagbinding();
  }

  public static void syncCreateTagBindingTagbinding() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (TagBindingsClient tagBindingsClient = TagBindingsClient.create()) {
      TagBinding tagBinding = TagBinding.newBuilder().build();
      TagBinding response = tagBindingsClient.createTagBindingAsync(tagBinding).get();
    }
  }
}
// [END resourcemanager_v3_generated_tagbindingsclient_createtagbinding_tagbinding_sync]
