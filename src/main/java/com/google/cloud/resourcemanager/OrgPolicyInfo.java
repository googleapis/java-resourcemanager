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

import com.google.api.services.cloudresourcemanager.model.OrgPolicy;
import com.google.api.services.cloudresourcemanager.model.RestoreDefault;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/** A Google Cloud Resource Manager organization policy metadata object. */
public class OrgPolicyInfo implements Serializable {
  static final Function<OrgPolicy, OrgPolicyInfo> FROM_PB_FUNCTION =
      new Function<com.google.api.services.cloudresourcemanager.model.OrgPolicy, OrgPolicyInfo>() {
        @Override
        public OrgPolicyInfo apply(
            com.google.api.services.cloudresourcemanager.model.OrgPolicy pb) {
          return OrgPolicyInfo.fromPb(pb);
        }
      };
  static final Function<OrgPolicyInfo, com.google.api.services.cloudresourcemanager.model.OrgPolicy>
      TO_PB_FUNCTION =
          new Function<
              OrgPolicyInfo, com.google.api.services.cloudresourcemanager.model.OrgPolicy>() {
            @Override
            public com.google.api.services.cloudresourcemanager.model.OrgPolicy apply(
                OrgPolicyInfo orgPolicyInfo) {
              return orgPolicyInfo.toPb();
            }
          };
  private static final long serialVersionUID = 9148970963697734236L;

  private BooleanPolicy booleanPolicy;
  private String constraint;
  private String etag;
  private ListPolicy listPolicy;
  private RestoreDefault restoreDefault;
  private String updateTime;
  private Integer version;

  /** Used in policy_type to specify how booleanPolicy will behave at this resource. */
  public static class BooleanPolicy implements Serializable {
    private static final long serialVersionUID = -2133042982786959351L;
    private final Boolean enforce;

    BooleanPolicy(Boolean enforce) {
      this.enforce = enforce;
    }

    public boolean getEnforce() {
      return enforce;
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this).add("enforce", getEnforce()).toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(getEnforce());
    }

    @Override
    public final boolean equals(Object obj) {
      return obj == this
          || obj != null
              && obj.getClass().equals(BooleanPolicy.class)
              && Objects.equals(toPb(), ((BooleanPolicy) obj).toPb());
    }

    com.google.api.services.cloudresourcemanager.model.BooleanPolicy toPb() {
      return new com.google.api.services.cloudresourcemanager.model.BooleanPolicy()
          .setEnforced(enforce);
    }

    static BooleanPolicy fromPb(
        com.google.api.services.cloudresourcemanager.model.BooleanPolicy booleanPolicy) {
      return new BooleanPolicy(booleanPolicy.getEnforced());
    }
  }

  /**
   * Used in policy_type to specify how listPolicy behaves at this resource.
   *
   * <p>ListPolicy can define specific values and subtrees of Cloud Resource Manager resource
   * hierarchy (Organizations, Folders, Projects) that are allowed or denied by setting the
   * allowedValues and deniedValues fields. This is achieved by using the under: and optional is:
   * prefixes. The under: prefix is used to denote resource subtree values. The is: prefix is used
   * to denote specific values, and is required only if the value contains a ":". Values prefixed
   * with "is:" are treated the same as values with no prefix. Ancestry subtrees must be in one of
   * the following formats: - "projects/", e.g. "projects/tokyo-rain-123" - "folders/", e.g.
   * "folders/1234" - "organizations/", e.g. "organizations/1234" The supportsUnder field of the
   * associated Constraint defines whether ancestry prefixes can be used. You can set allowedValues
   * and deniedValues in the same Policy if allValues is ALL_VALUES_UNSPECIFIED. ALLOW or DENY are
   * used to allow or deny all values. If allValues is set to either ALLOW or DENY, allowedValues
   * and deniedValues must be unset.
   */
  public static class ListPolicy implements Serializable {
    private static final long serialVersionUID = -2133042982786959352L;

    private final String allValues;
    private final List<String> allowedValues;
    private final List<java.lang.String> deniedValues;
    private final Boolean inheritFromParent;
    private final String suggestedValue;

    public ListPolicy(
        String allValues,
        List<String> allowedValues,
        List<String> deniedValues,
        Boolean inheritFromParent,
        String suggestedValue) {
      this.allValues = allValues;
      this.allowedValues = allowedValues;
      this.deniedValues = deniedValues;
      this.inheritFromParent = inheritFromParent;
      this.suggestedValue = suggestedValue;
    }

    public String getAllValues() {
      return allValues;
    }

    public List<String> getAllowedValues() {
      return allowedValues;
    }

    public List<String> getDeniedValues() {
      return deniedValues;
    }

    public Boolean getInheritFromParent() {
      return inheritFromParent;
    }

    public String getSuggestedValue() {
      return suggestedValue;
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("allValues", getAllValues())
          .add("allowedValues", getAllowedValues())
          .add("deniedValues", getDeniedValues())
          .add("inheritFromParent", getInheritFromParent())
          .add("suggestedValue", getSuggestedValue())
          .toString();
    }

    @Override
    public final boolean equals(Object obj) {
      return obj == this
          || obj != null
              && obj.getClass().equals(ListPolicy.class)
              && Objects.equals(toPb(), ((ListPolicy) obj).toPb());
    }

    @Override
    public int hashCode() {
      return Objects.hash(
          allowedValues, allowedValues, deniedValues, inheritFromParent, suggestedValue);
    }

    com.google.api.services.cloudresourcemanager.model.ListPolicy toPb() {
      return new com.google.api.services.cloudresourcemanager.model.ListPolicy()
          .setAllValues(allValues)
          .setAllowedValues(allowedValues)
          .setDeniedValues(deniedValues)
          .setInheritFromParent(inheritFromParent)
          .setSuggestedValue(suggestedValue);
    }

    static ListPolicy fromPb(
        com.google.api.services.cloudresourcemanager.model.ListPolicy listPolicy) {
      return new ListPolicy(
          listPolicy.getAllValues(),
          listPolicy.getAllowedValues(),
          listPolicy.getDeniedValues(),
          listPolicy.getInheritFromParent(),
          listPolicy.getSuggestedValue());
    }
  }

  public abstract static class Builder {
    public abstract Builder setBooleanPolicy(BooleanPolicy booleanPolicy);

    public abstract Builder setConstraint(String constraint);

    public abstract Builder setEtag(String etag);

    public abstract Builder setListPolicy(ListPolicy listPolicy);

    public abstract Builder setRestoreDefault(RestoreDefault restoreDefault);

    public abstract Builder setUpdateTime(String updateTime);

    public abstract Builder setVersion(Integer version);

    public abstract OrgPolicyInfo build();
  }

  static class BuilderImpl extends Builder {
    private BooleanPolicy booleanPolicy;
    private String constraint;
    private String etag;
    private ListPolicy listPolicy;
    private RestoreDefault restoreDefault;
    private String updateTime;
    private Integer version;

    BuilderImpl() {}

    BuilderImpl(OrgPolicyInfo info) {
      this.booleanPolicy = info.booleanPolicy;
      this.constraint = info.constraint;
      this.etag = info.etag;
      this.listPolicy = info.listPolicy;
      this.restoreDefault = info.restoreDefault;
      this.updateTime = info.updateTime;
      this.version = info.version;
    }

    @Override
    public Builder setBooleanPolicy(BooleanPolicy booleanPolicy) {
      this.booleanPolicy = booleanPolicy;
      return this;
    }

    @Override
    public Builder setConstraint(String constraint) {
      this.constraint = constraint;
      return this;
    }

    @Override
    public Builder setEtag(String etag) {
      this.etag = etag;
      return this;
    }

    @Override
    public Builder setListPolicy(ListPolicy listPolicy) {
      this.listPolicy = listPolicy;
      return this;
    }

    @Override
    public Builder setRestoreDefault(RestoreDefault restoreDefault) {
      this.restoreDefault = restoreDefault;
      return this;
    }

    @Override
    public Builder setUpdateTime(String updateTime) {
      this.updateTime = updateTime;
      return this;
    }

    @Override
    public Builder setVersion(Integer version) {
      this.version = version;
      return this;
    }

    @Override
    public OrgPolicyInfo build() {
      return new OrgPolicyInfo(this);
    }
  }

  OrgPolicyInfo(BuilderImpl builder) {
    this.booleanPolicy = builder.booleanPolicy;
    this.constraint = builder.constraint;
    this.etag = builder.etag;
    this.listPolicy = builder.listPolicy;
    this.restoreDefault = builder.restoreDefault;
    this.updateTime = builder.updateTime;
    this.version = builder.version;
  }

  public BooleanPolicy getBooleanPolicy() {
    return booleanPolicy;
  }

  public String getConstraint() {
    return constraint;
  }

  public String getEtag() {
    return etag;
  }

  public ListPolicy getListPolicy() {
    return listPolicy;
  }

  public RestoreDefault getRestoreDefault() {
    return restoreDefault;
  }

  public String getUpdateTime() {
    return updateTime;
  }

  public Integer getVersion() {
    return version;
  }

  @Override
  public boolean equals(Object obj) {
    return obj == this
        || obj != null
            && obj.getClass().equals(OrgPolicyInfo.class)
            && Objects.equals(toPb(), ((OrgPolicyInfo) obj).toPb());
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        getBooleanPolicy(),
        getConstraint(),
        getEtag(),
        getListPolicy(),
        getRestoreDefault(),
        getUpdateTime(),
        getVersion());
  }

  public static Builder newBuilder() {
    return new BuilderImpl();
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  com.google.api.services.cloudresourcemanager.model.OrgPolicy toPb() {
    com.google.api.services.cloudresourcemanager.model.OrgPolicy orgPolicyPb =
        new com.google.api.services.cloudresourcemanager.model.OrgPolicy();
    if (booleanPolicy != null) {
      orgPolicyPb.setBooleanPolicy(booleanPolicy.toPb());
    }
    orgPolicyPb.setConstraint(constraint);
    if (listPolicy != null) {
      orgPolicyPb.setListPolicy(listPolicy.toPb());
    }
    orgPolicyPb.setRestoreDefault(restoreDefault);
    orgPolicyPb.setEtag(etag);
    orgPolicyPb.setUpdateTime(updateTime);
    orgPolicyPb.setVersion(version);
    return orgPolicyPb;
  }

  static OrgPolicyInfo fromPb(
      com.google.api.services.cloudresourcemanager.model.OrgPolicy orgPolicyPb) {
    Builder builder = newBuilder();
    if (orgPolicyPb.getBooleanPolicy() != null) {
      builder.setBooleanPolicy(BooleanPolicy.fromPb(orgPolicyPb.getBooleanPolicy()));
    }
    if (orgPolicyPb.getConstraint() != null) {
      builder.setConstraint(orgPolicyPb.getConstraint());
    }
    if (orgPolicyPb.getListPolicy() != null) {
      builder.setListPolicy(ListPolicy.fromPb(orgPolicyPb.getListPolicy()));
    }
    if (orgPolicyPb.getRestoreDefault() != null) {
      builder.setRestoreDefault(orgPolicyPb.getRestoreDefault());
    }
    if (orgPolicyPb.getEtag() != null) {
      builder.setEtag(orgPolicyPb.getEtag());
    }
    if (orgPolicyPb.getUpdateTime() != null) {
      builder.setUpdateTime(orgPolicyPb.getUpdateTime());
    }
    if (orgPolicyPb.getVersion() != null) {
      builder.setVersion(orgPolicyPb.getVersion());
    }
    return builder.build();
  }
}
