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

import com.google.api.services.cloudresourcemanager.model.BooleanConstraint;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.base.Optional;
import java.io.Serializable;
import java.util.Objects;

/** A Google Cloud Resource Manager constraint metadata object. */
public class ConstraintInfo implements Serializable {

  private static final long serialVersionUID = 9148970963697734236L;

  static final Function<
          com.google.api.services.cloudresourcemanager.model.Constraint, ConstraintInfo>
      FROM_PB_FUNCTION =
          new Function<
              com.google.api.services.cloudresourcemanager.model.Constraint, ConstraintInfo>() {
            @Override
            public ConstraintInfo apply(
                com.google.api.services.cloudresourcemanager.model.Constraint pb) {
              return ConstraintInfo.fromPb(pb);
            }
          };
  static final Function<
          ConstraintInfo, com.google.api.services.cloudresourcemanager.model.Constraint>
      TO_PB_FUNCTION =
          new Function<
              ConstraintInfo, com.google.api.services.cloudresourcemanager.model.Constraint>() {
            @Override
            public com.google.api.services.cloudresourcemanager.model.Constraint apply(
                ConstraintInfo constraintInfo) {
              return constraintInfo.toPb();
            }
          };

  private BooleanConstraint booleanConstraint;
  private String constraintDefault;
  private String description;
  private String displayName;
  private ListConstraint listConstraint;
  private String name;
  private Integer version;

  /**
   * A Constraint that allows or disallows a list of string values, which are configured by an
   * Organization's policy administrator with a Policy.
   */
  public static class ListConstraint implements Serializable {

    private static final long serialVersionUID = -2133042982786959352L;

    private final Optional<String> suggestedValue;
    private final Boolean supportsUnder;

    ListConstraint(String suggestedValue, Boolean supportsUnder) {
      this.suggestedValue = Optional.fromNullable(suggestedValue);
      this.supportsUnder = supportsUnder;
    }

    public Optional<String> getSuggestedValue() {
      return suggestedValue;
    }

    public Boolean getSupportsUnder() {
      return supportsUnder;
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("suggestedValue", getSuggestedValue())
          .add("supportsUnder", getSupportsUnder())
          .toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(getSuggestedValue(), getSupportsUnder());
    }

    @Override
    public final boolean equals(Object obj) {
      return obj == this
          || obj != null
              && obj.getClass().equals(ListConstraint.class)
              && Objects.equals(toPb(), ((ListConstraint) obj).toPb());
    }

    com.google.api.services.cloudresourcemanager.model.ListConstraint toPb() {
      return new com.google.api.services.cloudresourcemanager.model.ListConstraint()
          .setSuggestedValue(String.valueOf(Optional.fromNullable(suggestedValue)))
          .setSupportsUnder(supportsUnder);
    }

    static ListConstraint fromPb(
        com.google.api.services.cloudresourcemanager.model.ListConstraint listConstraint) {
      return new ListConstraint(
          listConstraint.getSuggestedValue(), listConstraint.getSupportsUnder());
    }
  }

  public abstract static class Builder {
    public abstract Builder setBooleanConstraint(BooleanConstraint booleanConstraint);

    public abstract Builder setConstraintDefault(String constraintDefault);

    public abstract Builder setDescription(String description);

    public abstract Builder setDisplayName(String displayName);

    public abstract Builder setListConstraint(ListConstraint listConstraint);

    public abstract Builder setName(String name);

    public abstract Builder setVersion(Integer version);

    public abstract ConstraintInfo build();
  }

  static class BuilderImpl extends Builder {
    private BooleanConstraint booleanConstraint;
    private String constraintDefault;
    private String description;
    private String displayName;
    private ListConstraint listConstraint;
    private String name;
    private Integer version;

    BuilderImpl(String name) {
      this.name = name;
    }

    BuilderImpl(ConstraintInfo info) {
      this.booleanConstraint = info.booleanConstraint;
      this.constraintDefault = info.constraintDefault;
      this.description = info.description;
      this.displayName = info.displayName;
      this.listConstraint = info.listConstraint;
      this.name = info.name;
      this.version = info.version;
    }

    @Override
    public Builder setBooleanConstraint(BooleanConstraint booleanConstraint) {
      this.booleanConstraint = booleanConstraint;
      return this;
    }

    @Override
    public Builder setConstraintDefault(String constraintDefault) {
      this.constraintDefault = constraintDefault;
      return this;
    }

    @Override
    public Builder setDescription(String description) {
      this.description = description;
      return this;
    }

    @Override
    public Builder setDisplayName(String displayName) {
      this.displayName = displayName;
      return this;
    }

    @Override
    public Builder setListConstraint(ListConstraint listConstraint) {
      this.listConstraint = listConstraint;
      return this;
    }

    @Override
    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    @Override
    public Builder setVersion(Integer version) {
      this.version = version;
      return this;
    }

    @Override
    public ConstraintInfo build() {
      return new ConstraintInfo(this);
    }
  }

  ConstraintInfo(BuilderImpl builder) {
    this.booleanConstraint = builder.booleanConstraint;
    this.constraintDefault = builder.constraintDefault;
    this.description = builder.description;
    this.displayName = builder.displayName;
    this.listConstraint = builder.listConstraint;
    this.name = builder.name;
    this.version = builder.version;
  }

  public BooleanConstraint getBooleanConstraint() {
    return booleanConstraint;
  }

  public String getConstraintDefault() {
    return constraintDefault;
  }

  public String getDescription() {
    return description;
  }

  public String getDisplayName() {
    return displayName;
  }

  public ListConstraint getListConstraint() {
    return listConstraint;
  }

  public String getName() {
    return name;
  }

  public Integer getVersion() {
    return version;
  }

  @Override
  public boolean equals(Object obj) {
    return obj == this
        || obj != null
            && obj.getClass().equals(ConstraintInfo.class)
            && Objects.equals(toPb(), ((ConstraintInfo) obj).toPb());
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        booleanConstraint,
        constraintDefault,
        description,
        displayName,
        listConstraint,
        name,
        version);
  }

  public static Builder newBuilder(String name) {
    return new BuilderImpl(name);
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  com.google.api.services.cloudresourcemanager.model.Constraint toPb() {
    com.google.api.services.cloudresourcemanager.model.Constraint constraintPb =
        new com.google.api.services.cloudresourcemanager.model.Constraint();
    constraintPb.setBooleanConstraint(booleanConstraint);
    constraintPb.setConstraintDefault(constraintDefault);
    constraintPb.setDescription(description);
    constraintPb.setDisplayName(displayName);
    if (listConstraint != null) {
      constraintPb.setListConstraint(listConstraint.toPb());
    }
    constraintPb.setName(name);
    constraintPb.setVersion(version);
    return constraintPb;
  }

  static ConstraintInfo fromPb(
      com.google.api.services.cloudresourcemanager.model.Constraint constraintPb) {
    Builder builder = newBuilder(constraintPb.getName());
    if (constraintPb.getBooleanConstraint() != null) {
      builder.setBooleanConstraint(constraintPb.getBooleanConstraint());
    }
    if (constraintPb.getConstraintDefault() != null) {
      constraintPb.setConstraintDefault(constraintPb.getConstraintDefault());
    }
    if (constraintPb.getDescription() != null) {
      constraintPb.setDescription(constraintPb.getDescription());
    }
    if (constraintPb.getDisplayName() != null) {
      constraintPb.setDisplayName(constraintPb.getDisplayName());
    }
    if (constraintPb.getListConstraint() != null) {
      constraintPb.setListConstraint(constraintPb.getListConstraint());
    }
    if (constraintPb.getName() != null && !constraintPb.getName().equals("Unnamed")) {
      builder.setName(constraintPb.getName());
    }
    if (constraintPb.getVersion() != null) {
      builder.setVersion(constraintPb.getVersion());
    }
    return builder.build();
  }
}
