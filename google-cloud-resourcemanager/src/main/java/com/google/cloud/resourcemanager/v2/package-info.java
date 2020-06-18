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

/**
 * A client to Cloud Resource Manager API.
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>============= FoldersClient =============
 *
 * <p>Service Description: Manages Cloud Resource Folders. Cloud Resource Folders can be used to
 * organize the resources under an organization and to control the IAM policies applied to groups of
 * resources.
 *
 * <p>Sample for FoldersClient:
 *
 * <pre>
 * <code>
 * try (FoldersClient foldersClient = FoldersClient.create()) {
 *   FolderName name = FolderName.of("[FOLDER]");
 *   Folder response = foldersClient.getFolder(name);
 * }
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
package com.google.cloud.resourcemanager.v2;

import javax.annotation.Generated;
