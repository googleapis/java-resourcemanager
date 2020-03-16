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

import com.google.common.base.Function;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * A Google Cloud Resource Manager lien metadata object.A Lien represents an encumbrance on the
 * actions that can be performed on a resource.
 */
public class LienInfo implements Serializable {

  static final Function<com.google.api.services.cloudresourcemanager.model.Lien, LienInfo>
      FROM_PB_FUNCTION =
          new Function<com.google.api.services.cloudresourcemanager.model.Lien, LienInfo>() {
            @Override
            public LienInfo apply(com.google.api.services.cloudresourcemanager.model.Lien pb) {
              return LienInfo.fromPb(pb);
            }
          };
  static final Function<LienInfo, com.google.api.services.cloudresourcemanager.model.Lien>
      TO_PB_FUNCTION =
          new Function<LienInfo, com.google.api.services.cloudresourcemanager.model.Lien>() {
            @Override
            public com.google.api.services.cloudresourcemanager.model.Lien apply(
                LienInfo lienInfo) {
              return lienInfo.toPb();
            }
          };

  private static final long serialVersionUID = 9148970963697734236L;

  private String createTime;
  private String name;
  private String origin;
  private String parent;
  private String reason;
  private List<String> restrictions;

  /** Builder for {@code LienInfo}. */
  public abstract static class Builder {
    public abstract Builder setCreateTime(String createTime);

    public abstract Builder setName(String name);

    public abstract Builder setOrigin(String origin);

    public abstract Builder setParent(String parent);

    public abstract Builder setReason(String reason);

    public abstract Builder setRestrictions(List<String> restrictions);

    public abstract LienInfo build();
  }

  static class BuilderImpl extends Builder {

    private String createTime;
    private String name;
    private String origin;
    private String parent;
    private String reason;
    private List<String> restrictions;

    BuilderImpl(String parent) {
      this.parent = parent;
    }

    BuilderImpl(LienInfo info) {
      this.createTime = info.createTime;
      this.name = info.name;
      this.origin = info.origin;
      this.parent = info.parent;
      this.reason = info.reason;
      this.restrictions = info.restrictions;
    }

    public Builder setCreateTime(String createTime) {
      this.createTime = createTime;
      return this;
    }

    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    public Builder setOrigin(String origin) {
      this.origin = origin;
      return this;
    }

    public Builder setReason(String reason) {
      this.reason = reason;
      return this;
    }

    public Builder setRestrictions(List<String> restrictions) {
      this.restrictions = restrictions;
      return this;
    }

    @Override
    public Builder setParent(String parent) {
      this.parent = checkNotNull(parent);
      return this;
    }

    @Override
    public LienInfo build() {
      return new LienInfo(this);
    }
  }

  LienInfo(BuilderImpl builder) {
    this.createTime = builder.createTime;
    this.name = builder.name;
    this.origin = builder.origin;
    this.parent = builder.parent;
    this.reason = builder.reason;
    this.restrictions = builder.restrictions;
  }

  public String getCreateTime() {
    return createTime;
  }

  public String getName() {
    return name;
  }

  public String getOrigin() {
    return origin;
  }

  public String getParent() {
    return parent;
  }

  public String getReason() {
    return reason;
  }

  public List<String> getRestrictions() {
    return restrictions;
  }

  @Override
  public boolean equals(Object obj) {
    return obj == this
        || obj != null
            && obj.getClass().equals(LienInfo.class)
            && Objects.equals(toPb(), ((LienInfo) obj).toPb());
  }

  @Override
  public int hashCode() {
    return Objects.hash(createTime, name, origin, parent, reason, restrictions);
  }

  public static Builder newBuilder(String parent) {
    return new BuilderImpl(parent);
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  com.google.api.services.cloudresourcemanager.model.Lien toPb() {
    com.google.api.services.cloudresourcemanager.model.Lien lienPb =
        new com.google.api.services.cloudresourcemanager.model.Lien();
    lienPb.setCreateTime(createTime);
    lienPb.setName(name);
    lienPb.setParent(parent);
    lienPb.setOrigin(origin);
    lienPb.setReason(reason);
    lienPb.setRestrictions(restrictions);
    return lienPb;
  }

  static LienInfo fromPb(com.google.api.services.cloudresourcemanager.model.Lien lienPb) {
    Builder builder = newBuilder(lienPb.getParent());
    if (lienPb.getCreateTime() != null) {
      builder.setCreateTime(lienPb.getCreateTime());
    }
    if (lienPb.getName() != null && !lienPb.getName().equals("Unnamed")) {
      builder.setName(lienPb.getName());
    }
    if (lienPb.getParent() != null) {
      builder.setParent(lienPb.getParent());
    }
    if (lienPb.getOrigin() != null) {
      builder.setOrigin(lienPb.getOrigin());
    }
    if (lienPb.getReason() != null) {
      builder.setReason(lienPb.getReason());
    }
    if (lienPb.getRestrictions() != null) {
      builder.setRestrictions(lienPb.getRestrictions());
    }
    return builder.build();
  }
}
