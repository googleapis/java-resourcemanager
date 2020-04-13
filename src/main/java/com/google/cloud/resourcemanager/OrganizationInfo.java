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

import com.google.api.core.ApiFunction;
import com.google.api.services.cloudresourcemanager.model.Organization;
import com.google.api.services.cloudresourcemanager.model.OrganizationOwner;
import com.google.cloud.StringEnumType;
import com.google.cloud.StringEnumValue;
import com.google.common.base.MoreObjects;
import java.io.Serializable;
import java.util.Objects;
import org.threeten.bp.Instant;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.format.DateTimeFormatter;

/**
 * A Google Cloud Resource Manager organization metadata object.
 *
 * @see <a
 *     href="https://cloud.google.com/resource-manager/reference/rest/v1/organizations#organization">organization</a>
 */
public class OrganizationInfo {

  public static final DateTimeFormatter DATE_TIME_FORMATTER =
      DateTimeFormatter.ISO_DATE_TIME.withZone(ZoneOffset.UTC);
  private Long creationTime;
  private String displayName;
  private State lifecycleState;
  private String name;
  private OrgOwner owner;

  static final class State extends StringEnumValue {

    private static final ApiFunction<String, State> CONSTRUCTOR =
        new ApiFunction<String, State>() {
          @Override
          public State apply(String constant) {
            return new State(constant);
          }
        };
    private static final StringEnumType<State> type = new StringEnumType(State.class, CONSTRUCTOR);

    /** Useful for distinguishing unset values. */
    public static final State LIFECYCLE_STATE_UNSPECIFIED =
        type.createAndRegister("LIFECYCLE_STATE_UNSPECIFIED");

    public static final State ACTIVE = type.createAndRegister("ACTIVE");

    /**
     * Represents the state of an organization that has been marked for deletion from GCP by the
     * user or by the system (Google Cloud Platform).
     */
    public static final State DELETE_REQUESTED = type.createAndRegister("DELETE_REQUESTED");

    private State(String constant) {
      super(constant);
    }

    /**
     * Returns the State for the given String constant, and throw an exception if the constant is
     * not recognized.
     */
    public static State valueOfStrict(String constant) {
      return type.valueOfStrict(constant);
    }

    /** Returns the State for the given String constant, and allow unrecognized values. */
    public static State valueOf(String constant) {
      return type.valueOf(constant);
    }

    /** Returns the known values for State. */
    public static State[] values() {
      return type.values();
    }
  }

  static class OrgOwner {

    private final String directoryCustomerId;

    OrgOwner(String directoryCustomerId) {
      this.directoryCustomerId = checkNotNull(directoryCustomerId);
    }

    static OrgOwner of(String directoryCustomerId) {
      return new OrgOwner(checkNotNull(directoryCustomerId));
    }

    String getDirectoryCustomerId() {
      return directoryCustomerId;
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("directoryCustomerId", directoryCustomerId)
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
      OrgOwner orgOwner = (OrgOwner) o;
      return Objects.equals(directoryCustomerId, orgOwner.directoryCustomerId);
    }

    @Override
    public int hashCode() {
      return Objects.hash(directoryCustomerId);
    }

    OrganizationOwner toProtobuf() {
      OrganizationOwner organizationOwnerProto = new OrganizationOwner();
      organizationOwnerProto.setDirectoryCustomerId(directoryCustomerId);
      return organizationOwnerProto;
    }

    static OrgOwner fromProtobuf(OrganizationOwner organizationOwnerPb) {
      return new OrgOwner(organizationOwnerPb.getDirectoryCustomerId());
    }
  }

  /** Builder for {@code OrganizationInfo}. */
  static class Builder {
    private Long creationTime;
    private String displayName;
    private State lifecycleState;
    private String name;
    private OrgOwner owner;

    private Builder() {}

    private Builder(OrganizationInfo info) {
      this.creationTime = info.creationTime;
      this.displayName = info.displayName;
      this.name = info.name;
      this.lifecycleState = info.lifecycleState;
      this.owner = info.owner;
    }

    Builder setCreationTime(Long creationTime) {
      this.creationTime = creationTime;
      return this;
    }

    Builder setDisplayName(String displayName) {
      this.displayName = displayName;
      return this;
    }

    Builder setLifecycleState(State lifecycleState) {
      this.lifecycleState = lifecycleState;
      return this;
    }

    Builder setName(String name) {
      this.name = name;
      return this;
    }

    Builder setOwner(OrgOwner owner) {
      this.owner = owner;
      return this;
    }

    /** Creates an {@link OrganizationInfo} object. */
    OrganizationInfo build() {
      return new OrganizationInfo(this);
    }
  }

  private OrganizationInfo(Builder builder) {
    this.creationTime = builder.creationTime;
    this.displayName = builder.displayName;
    this.lifecycleState = builder.lifecycleState;
    this.name = builder.name;
    this.owner = builder.owner;
  }

  /**
   * Returns the organization's creation time (in milliseconds).
   *
   * <p>This field is set by the server.
   */
  public Long getCreationTime() {
    return creationTime;
  }

  /**
   * Returns the organization's display name.
   *
   * <p>This field is set by the server and is read-only.
   */
  public String getDisplayName() {
    return displayName;
  }

  /**
   * Returns the organization's lifecycle state.
   *
   * <p>This field is set by the server.
   */
  public State getLifecycleState() {
    return lifecycleState;
  }

  /** Get the organization's name. */
  public String getName() {
    return name;
  }

  /**
   * Returns the owner of organization.
   *
   * <p>This field is specified on creation time. Once set, it cannot be changed.
   */
  public OrgOwner getOwner() {
    return owner;
  }

  /** Returns a builder for the {@link OrganizationInfo} object. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  /** Returns a builder for the {@link OrganizationInfo} object. */
  public static Builder newBuilder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("creationTime", creationTime)
        .add("displayName", displayName)
        .add("lifecycleState", lifecycleState)
        .add("name", name)
        .add("owner", owner)
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
    OrganizationInfo info = (OrganizationInfo) o;
    return Objects.equals(creationTime, info.creationTime)
        && Objects.equals(displayName, info.displayName)
        && Objects.equals(lifecycleState, info.lifecycleState)
        && Objects.equals(name, info.name)
        && Objects.equals(owner, info.owner);
  }

  @Override
  public int hashCode() {
    return Objects.hash(creationTime, displayName, lifecycleState, name, owner);
  }

  Organization toProtobuf() {
    Organization organization = new Organization();
    if (creationTime != null) {
      organization.setCreationTime(
          DateTimeFormatter.ISO_DATE_TIME
              .withZone(ZoneOffset.UTC)
              .format(Instant.ofEpochMilli(creationTime)));
    }
    organization.setDisplayName(displayName);
    if (lifecycleState != null) {
      organization.setLifecycleState(lifecycleState.toString());
    }
    organization.setName(name);
    if (owner != null) {
      organization.setOwner(owner.toProtobuf());
    }
    return organization;
  }

  static OrganizationInfo fromProtobuf(Organization organization) {
    Builder builder = newBuilder();
    if (organization.getCreationTime() != null) {
      builder.setCreationTime(
          DATE_TIME_FORMATTER.parse(organization.getCreationTime(), Instant.FROM).toEpochMilli());
    }
    builder.setDisplayName(organization.getDisplayName());
    if (organization.getLifecycleState() != null) {
      builder.setLifecycleState(State.valueOf(organization.getLifecycleState()));
    }
    builder.setName(organization.getName());
    if (organization.getOwner() != null) {
      builder.setOwner(OrgOwner.fromProtobuf(organization.getOwner()));
    }
    return builder.build();
  }
}
