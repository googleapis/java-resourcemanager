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

import com.google.api.services.cloudresourcemanager.model.BooleanConstraint;
import java.util.Objects;

/**
 * A Google Cloud Resource Manager constraint object.
 *
 * <p>A Constraint describes a way in which a resource's configuration can be restricted. For
 * example, it controls which cloud services can be activated across an organization, or whether a
 * Compute Engine instance can have serial port connections established. Constraints can be
 * configured by the organization's policy administrator to fit the needs of the organization by
 * setting Policies for Constraints at different locations in the organization's resource hierarchy.
 * Policies are inherited down the resource hierarchy from higher levels, but can also be
 * overridden. For details about the inheritance rules please read about
 * [Policies][google.cloud.OrgPolicy.v1.Policy].
 */
public class Constraint extends ConstraintInfo {
  private static final long serialVersionUID = 6767630161335155133L;

  private final ResourceManagerOptions options;
  private transient ResourceManager resourceManager;

  /** Builder for {@code Constraint}. */
  public static class Builder extends ConstraintInfo.Builder {
    private ResourceManager resourceManager;
    private ConstraintInfo.BuilderImpl infoBuilder;

    Builder(Constraint constraint) {
      this.resourceManager = constraint.resourceManager;
      this.infoBuilder = new ConstraintInfo.BuilderImpl(constraint);
    }

    @Override
    public Builder setBooleanConstraint(BooleanConstraint booleanConstraint) {
      infoBuilder.setBooleanConstraint(booleanConstraint);
      return this;
    }

    @Override
    public Builder setConstraintDefault(String constraintDefault) {
      infoBuilder.setConstraintDefault(constraintDefault);
      return this;
    }

    @Override
    public Builder setDescription(String description) {
      infoBuilder.setDescription(description);
      return this;
    }

    @Override
    public Builder setDisplayName(String displayName) {
      infoBuilder.setDisplayName(displayName);
      return this;
    }

    @Override
    public Builder setListConstraint(ListConstraint listConstraint) {
      infoBuilder.setListConstraint(listConstraint);
      return this;
    }

    @Override
    public Builder setName(String name) {
      infoBuilder.setName(name);
      return this;
    }

    @Override
    public Builder setVersion(Integer version) {
      infoBuilder.setVersion(version);
      return this;
    }

    @Override
    public Constraint build() {
      return new Constraint(resourceManager, infoBuilder);
    }
  }

  Constraint(ResourceManager resourceManager, ConstraintInfo.BuilderImpl infoBuilder) {
    super(infoBuilder);
    this.resourceManager = checkNotNull(resourceManager);
    this.options = resourceManager.getOptions();
  }

  /** Returns the {@link ResourceManager} service object associated with this Constraint. */
  public ResourceManager getResourceManager() {
    return resourceManager;
  }

  @Override
  public Constraint.Builder toBuilder() {
    return new Constraint.Builder(this);
  }

  @Override
  public final boolean equals(Object obj) {
    return obj == this
        || obj != null
            && obj.getClass().equals(Constraint.class)
            && Objects.equals(toPb(), ((Constraint) obj).toPb());
  }

  @Override
  public final int hashCode() {
    return Objects.hash(super.hashCode(), options);
  }

  static Constraint fromPb(
      ResourceManager resourceManager,
      com.google.api.services.cloudresourcemanager.model.Constraint answer) {
    ConstraintInfo info = ConstraintInfo.fromPb(answer);
    return new Constraint(resourceManager, new ConstraintInfo.BuilderImpl(info));
  }
}
