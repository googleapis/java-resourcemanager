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

import com.google.api.services.cloudresourcemanager.model.RestoreDefault;
import java.util.Objects;

/**
 * A Google Cloud Resource Manager organization policy object.
 *
 * <p>Defines a Cloud Organization Policy which is used to specify constraints for configurations of
 * Cloud Platform resources.
 */
public class OrgPolicy extends OrgPolicyInfo {

  private static final long serialVersionUID = 6767630161335155133L;

  private final ResourceManagerOptions options;
  private transient ResourceManager resourceManager;

  /** Builder for {@code OrgPolicy}. */
  public static class Builder extends OrgPolicyInfo.Builder {
    private final ResourceManager resourceManager;
    private final OrgPolicyInfo.BuilderImpl infoBuilder;

    Builder(OrgPolicy orgPolicy) {
      this.resourceManager = orgPolicy.resourceManager;
      this.infoBuilder = new OrgPolicyInfo.BuilderImpl(orgPolicy);
    }

    @Override
    public Builder setBooleanPolicy(BooleanPolicy booleanPolicy) {
      infoBuilder.setBooleanPolicy(booleanPolicy);
      return this;
    }

    @Override
    public Builder setConstraint(String constraint) {
      infoBuilder.setConstraint(constraint);
      return this;
    }

    @Override
    public Builder setEtag(String etag) {
      infoBuilder.setEtag(etag);
      return this;
    }

    @Override
    public Builder setListPolicy(ListPolicy listPolicy) {
      infoBuilder.setListPolicy(listPolicy);
      return this;
    }

    @Override
    public Builder setRestoreDefault(RestoreDefault restoreDefault) {
      infoBuilder.setRestoreDefault(restoreDefault);
      return this;
    }

    @Override
    public Builder setUpdateTime(String updateTime) {
      infoBuilder.setUpdateTime(updateTime);
      return this;
    }

    @Override
    public Builder setVersion(Integer version) {
      infoBuilder.setVersion(version);
      return this;
    }

    @Override
    public OrgPolicy build() {
      return new OrgPolicy(resourceManager, infoBuilder);
    }
  }

  OrgPolicy(ResourceManager resourceManager, OrgPolicyInfo.BuilderImpl infoBuilder) {
    super(infoBuilder);
    this.resourceManager = checkNotNull(resourceManager);
    this.options = resourceManager.getOptions();
  }

  /** Returns the {@link ResourceManager} service object associated with this OrgPolicy. */
  public ResourceManager getResourceManager() {
    return resourceManager;
  }

  @Override
  public Builder toBuilder() {
    return new OrgPolicy.Builder(this);
  }

  @Override
  public final boolean equals(Object obj) {
    return obj == this
        || obj != null
            && obj.getClass().equals(OrgPolicy.class)
            && Objects.equals(toPb(), ((OrgPolicy) obj).toPb());
  }

  @Override
  public final int hashCode() {
    return Objects.hash(super.hashCode(), options);
  }

  static OrgPolicy fromPb(
      ResourceManager resourceManager,
      com.google.api.services.cloudresourcemanager.model.OrgPolicy answer) {
    OrgPolicyInfo info = OrgPolicyInfo.fromPb(answer);
    return new OrgPolicy(resourceManager, new OrgPolicyInfo.BuilderImpl(info));
  }
}
