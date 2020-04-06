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

import com.google.api.services.cloudresourcemanager.model.Lien;
import com.google.common.base.Function;
import java.util.List;
import java.util.Objects;

/**
 * A Google Cloud Resource Manager lien metadata object.
 *
 * <p>A Lien represents an encumbrance on the actions that can be performed on a resource.
 */
public class LienInfo {

  static final Function<Lien, LienInfo> FROM_PROTOBUF_FUNCTION =
      new Function<Lien, LienInfo>() {
        @Override
        public LienInfo apply(Lien lienProtobuf) {
          return LienInfo.fromProtobuf(lienProtobuf);
        }
      };
  static final Function<LienInfo, Lien> TO_PROTOBUF_FUNCTION =
      new Function<LienInfo, Lien>() {
        @Override
        public Lien apply(LienInfo lienInfo) {
          return lienInfo.toProtobuf();
        }
      };

  private String createTime;
  private String name;
  private String origin;
  private String parent;
  private String reason;
  private List<String> restrictions;

  /** Builder for {@code LienInfo}. */
  static class Builder {

    private String createTime;
    private String name;
    private String origin;
    private String parent;
    private String reason;
    private List<String> restrictions;

    Builder(String parent) {
      this.parent = parent;
    }

    Builder(LienInfo info) {
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

    public Builder setParent(String parent) {
      this.parent = checkNotNull(parent);
      return this;
    }

    public LienInfo build() {
      return new LienInfo(this);
    }
  }

  LienInfo(Builder builder) {
    this.createTime = builder.createTime;
    this.name = builder.name;
    this.origin = builder.origin;
    this.parent = builder.parent;
    this.reason = builder.reason;
    this.restrictions = builder.restrictions;
  }

  /** Returns the creation time of the lien. */
  public String getCreateTime() {
    return createTime;
  }
  /** Returns the name of the lien. */
  public String getName() {
    return name;
  }
  /** Returns the origin of the lien */
  public String getOrigin() {
    return origin;
  }
  /** Returns the parent of the lien. */
  public String getParent() {
    return parent;
  }
  /** Returns the reason of the lien. */
  public String getReason() {
    return reason;
  }
  /** Returns the restrictions of the lien. */
  public List<String> getRestrictions() {
    return restrictions;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LienInfo lienInfo = (LienInfo) o;
    return Objects.equals(createTime, lienInfo.createTime)
        && Objects.equals(name, lienInfo.name)
        && Objects.equals(origin, lienInfo.origin)
        && Objects.equals(parent, lienInfo.parent)
        && Objects.equals(reason, lienInfo.reason)
        && Objects.equals(restrictions, lienInfo.restrictions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(createTime, name, origin, parent, reason, restrictions);
  }

  /** Returns a builder for the {@link LienInfo} object. */
  public static Builder newBuilder(String parent) {
    return new Builder(parent);
  }
  /** Returns a builder for the {@link LienInfo} object. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  Lien toProtobuf() {
    Lien lien = new Lien();
    lien.setCreateTime(createTime);
    lien.setName(name);
    lien.setParent(parent);
    lien.setOrigin(origin);
    lien.setReason(reason);
    lien.setRestrictions(restrictions);
    return lien;
  }

  static LienInfo fromProtobuf(Lien lien) {
    Builder builder = newBuilder(lien.getParent());
    if (lien.getCreateTime() != null) {
      builder.setCreateTime(lien.getCreateTime());
    }
    if (lien.getName() != null && !lien.getName().equals("Unnamed")) {
      builder.setName(lien.getName());
    }
    if (lien.getParent() != null) {
      builder.setParent(lien.getParent());
    }
    if (lien.getOrigin() != null) {
      builder.setOrigin(lien.getOrigin());
    }
    if (lien.getReason() != null) {
      builder.setReason(lien.getReason());
    }
    if (lien.getRestrictions() != null) {
      builder.setRestrictions(lien.getRestrictions());
    }
    return builder.build();
  }
}
