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
import com.google.cloud.StringEnumType;
import com.google.cloud.StringEnumValue;
import com.google.common.base.MoreObjects;
import java.io.Serializable;
import java.util.Objects;
import org.threeten.bp.Instant;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.format.DateTimeFormatter;

/** A Google Cloud Resource Manager organization metadata object. */
public class OrganizationInfo implements Serializable {

  public static final DateTimeFormatter DATE_TIME_FORMATTER =
      DateTimeFormatter.ISO_DATE_TIME.withZone(ZoneOffset.UTC);
  private Long creationTime;
  private String displayName;
  private State lifecycleState;
  private String name;
  private OrganizationOwner owner;

  public static final class State extends StringEnumValue {

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
     * Represents the state of organization that has been marked for deletion from GCP by the user
     * or by the system (Google Cloud Platform).
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

  public static final class OrganizationOwner implements Serializable {

    private static final long serialVersionUID = -325199985993344727L;
    private final String directoryCustomerId;

    OrganizationOwner(String directoryCustomerId) {
      this.directoryCustomerId = checkNotNull(directoryCustomerId);
    }

    public static OrganizationOwner of(String directoryCustomerId) {
      return new OrganizationOwner(checkNotNull(directoryCustomerId));
    }

    public String getDirectoryCustomerId() {
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
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      OrganizationOwner that = (OrganizationOwner) o;
      return Objects.equals(directoryCustomerId, that.directoryCustomerId);
    }

    @Override
    public int hashCode() {
      return Objects.hash(directoryCustomerId);
    }

    com.google.api.services.cloudresourcemanager.model.OrganizationOwner toPb() {
      com.google.api.services.cloudresourcemanager.model.OrganizationOwner organizationOwnerPb =
          new com.google.api.services.cloudresourcemanager.model.OrganizationOwner();
      organizationOwnerPb.setDirectoryCustomerId(directoryCustomerId);
      return organizationOwnerPb;
    }

    static OrganizationOwner fromPb(
        com.google.api.services.cloudresourcemanager.model.OrganizationOwner organizationOwnerPb) {
      return new OrganizationOwner(organizationOwnerPb.getDirectoryCustomerId());
    }
  }

  public static final class Builder {
    private Long creationTime;
    private String displayName;
    private State lifecycleState;
    private String name;
    private OrganizationOwner owner;

    private Builder() {}

    private Builder(OrganizationInfo info) {
      this.creationTime = info.creationTime;
      this.displayName = info.displayName;
      this.name = info.name;
      this.lifecycleState = info.lifecycleState;
      this.owner = info.owner;
    }

    public Builder setCreationTime(Long creationTime) {
      this.creationTime = creationTime;
      return this;
    }

    public Builder setDisplayName(String displayName) {
      this.displayName = displayName;
      return this;
    }

    public Builder setLifecycleState(State lifecycleState) {
      this.lifecycleState = lifecycleState;
      return this;
    }

    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    public Builder setOwner(OrganizationOwner owner) {
      this.owner = owner;
      return this;
    }

    /** Creates a {@link OrganizationInfo} object. */
    public OrganizationInfo build() {
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
  public OrganizationOwner getOwner() {
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
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    OrganizationInfo that = (OrganizationInfo) o;
    return Objects.equals(creationTime, that.creationTime)
        && Objects.equals(displayName, that.displayName)
        && Objects.equals(lifecycleState, that.lifecycleState)
        && Objects.equals(name, that.name)
        && Objects.equals(owner, that.owner);
  }

  @Override
  public int hashCode() {
    return Objects.hash(creationTime, displayName, lifecycleState, name, owner);
  }

  Organization toPb() {
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
      organization.setOwner(owner.toPb());
    }
    return organization;
  }

  static OrganizationInfo fromPb(Organization organization) {
    Builder builder = newBuilder();
    if (organization.getCreationTime() != null) {
      builder.setCreationTime(
          DATE_TIME_FORMATTER.parse(organization.getCreationTime(), Instant.FROM).toEpochMilli());
    }
    if (organization.getDisplayName() != null) {
      builder.setDisplayName(organization.getDisplayName());
    }
    if (organization.getLifecycleState() != null) {
      builder.setLifecycleState(State.valueOf(organization.getLifecycleState()));
    }
    if (organization.getName() != null && !organization.getName().equals("Unnamed")) {
      builder.setName(organization.getName());
    }
    if (organization.getOwner() != null) {
      builder.setOwner(OrganizationOwner.fromPb(organization.getOwner()));
    }
    return builder.build();
  }
}
