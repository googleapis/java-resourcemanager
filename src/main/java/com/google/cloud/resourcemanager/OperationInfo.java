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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.services.cloudresourcemanager.model.Operation;
import com.google.common.base.MoreObjects;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/** Google Resource Manager Operation metadata. */
public class OperationInfo {

  private final Boolean done;
  private final Status error;
  private final Map<String, Object> metadata;
  private final String name;
  private final Map<String, Object> response;

  /**
   * The Status type defines a logical error model that is suitable for different programming
   * environments, including REST APIs and RPC APIs. It is used by gRPC. Each Status message
   * contains three pieces of data: error code, error message, and error details.
   */
  static class Status {

    private Integer code;
    private List<Map<String, Object>> details;
    private String message;

    Status(Integer code, String message, List<Map<String, Object>> details) {
      this.code = code;
      this.message = message;
      this.details = details;
    }

    /** Returns the status code. */
    public Integer getCode() {
      return code;
    }

    /** Returns the error message. */
    public String getMessage() {
      return message;
    }

    /** Return the list of messages that carry the error details. */
    public List<Map<String, Object>> getDetails() {
      return details;
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("code", code)
          .add("message", message)
          .add("details", details)
          .toString();
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Status status = (Status) o;
      return Objects.equals(code, status.code)
          && Objects.equals(details, status.details)
          && Objects.equals(message, status.message);
    }

    @Override
    public int hashCode() {
      return Objects.hash(code, details, message);
    }

    com.google.api.services.cloudresourcemanager.model.Status toProtobuf() {
      return new com.google.api.services.cloudresourcemanager.model.Status()
          .setCode(code)
          .setMessage(message)
          .setDetails(details);
    }

    static Status fromProtobuf(com.google.api.services.cloudresourcemanager.model.Status status) {
      return new Status(status.getCode(), status.getMessage(), status.getDetails());
    }
  }

  static class Builder {

    private Boolean done;
    private Status error;
    private Map<String, Object> metadata;
    private String name;
    private Map<String, Object> response;

    Builder(String name) {
      this.name = name;
    }

    Builder(OperationInfo info) {
      name = info.name;
      done = info.done;
      metadata = info.metadata;
      response = info.response;
      error = info.error;
    }

    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    public Builder setDone(Boolean done) {
      this.done = done;
      return this;
    }

    public Builder setMetadata(Map<String, Object> metadata) {
      this.metadata = metadata;
      return this;
    }

    public Builder setResponse(Map<String, Object> response) {
      this.response = response;
      return this;
    }

    public Builder setError(Status error) {
      this.error = error;
      return this;
    }

    public OperationInfo build() {
      checkNotNull(name);
      return new OperationInfo(this);
    }
  }

  OperationInfo(Builder builder) {
    name = builder.name;
    done = builder.done;
    metadata = builder.metadata;
    response = builder.response;
    error = builder.error;
  }
  /**
   * If the value is false, it means the operation is still in progress. If true, the operation is
   * completed, and either error or response is available.
   */
  public Boolean getDone() {
    return done;
  }

  /** Returns the error result of the operation in case of failure or cancellation. */
  public Status getError() {
    return error;
  }

  /**
   * Returns the service-specific metadata associated with the operation. It typically contains
   * progress information and common metadata such as create time.
   */
  public Map<String, Object> getMetadata() {
    return metadata;
  }

  /**
   * Returns the server-assigned name, which is only unique within the same service that originally
   * returns it.
   */
  public String getName() {
    return name;
  }

  /** Returns the normal response of the operation in case of success. */
  public Map<String, Object> getResponse() {
    return response;
  }

  /** Returns a builder for the current operation. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OperationInfo that = (OperationInfo) o;
    return Objects.equals(done, that.done)
        && Objects.equals(error, that.error)
        && Objects.equals(metadata, that.metadata)
        && Objects.equals(name, that.name)
        && Objects.equals(response, that.response);
  }

  @Override
  public int hashCode() {
    return Objects.hash(done, error, metadata, name, response);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("name", getName())
        .add("done", getDone())
        .add("metadata", getMetadata())
        .add("response", getResponse())
        .add("error", getError())
        .toString();
  }

  Operation toProtobuf() {
    Operation operation = new Operation();
    operation.setName(name);
    operation.setDone(done);
    operation.setMetadata(metadata);
    if (response != null) {
      operation.setResponse(response);
    }
    if (error != null) {
      operation.setError(error.toProtobuf());
    }
    return operation;
  }

  /** Creates a {@code OperationInfo} object for the provided operation name. */
  public static OperationInfo of(String name) {
    return newBuilder(name).build();
  }

  /**
   * Returns a {@code OperationInfo} builder where the operation's name is set to the provided name.
   */
  public static Builder newBuilder(String name) {
    return new Builder(name);
  }

  static OperationInfo fromProtobuf(Operation operation) {
    Builder builder = newBuilder(operation.getName());
    if (operation.getName() != null) {
      builder.setName(operation.getName());
    }
    if (operation.getDone() != null) {
      builder.setDone(operation.getDone());
    }
    if (operation.getMetadata() != null) {
      builder.setMetadata(operation.getMetadata());
    }
    if (operation.getResponse() != null) {
      builder.setResponse(operation.getResponse());
    }
    if (operation.getError() != null) {
      builder.setError(Status.fromProtobuf(operation.getError()));
    }
    return builder.build();
  }
}
