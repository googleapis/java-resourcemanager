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

import com.google.common.collect.ImmutableList;

/** A Google Cloud Resource Manager ListResult object. */
public class ListResult<T> {

  private final Iterable<T> results;
  private final String pageToken;

  public ListResult(String pageToken, Iterable<T> results) {
    this.results = ImmutableList.copyOf(results);
    this.pageToken = pageToken;
  }

  /** Creates a {@code ListResult} object for the provided pageToken and list. */
  public static <T> ListResult<T> of(String pageToken, Iterable<T> list) {
    return new ListResult<>(pageToken, list);
  }

  /** Returns the results of list. */
  public Iterable<T> results() {
    return results;
  }

  /**
   * Returns the token to retrieves the next page of results, or empty string if there are no more
   * results in the list.
   */
  public String pageToken() {
    return pageToken;
  }
}
