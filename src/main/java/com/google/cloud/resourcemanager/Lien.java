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

import com.google.api.gax.paging.Page;
import com.google.cloud.resourcemanager.ResourceManager.LienListOption;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.Objects;

public class Lien extends LienInfo {
  private static final long serialVersionUID = 6767630161335155133L;

  private final ResourceManagerOptions options;
  private transient ResourceManager resourceManager;

  /** Builder for {@code Lien}. */
  public static class Builder extends LienInfo.Builder {
    private final ResourceManager resourceManager;
    private final LienInfo.BuilderImpl infoBuilder;

    Builder(Lien lien) {
      this.resourceManager = lien.resourceManager;
      this.infoBuilder = new LienInfo.BuilderImpl(lien);
    }

    @Override
    public Builder setCreateTime(String createTime) {
      infoBuilder.setCreateTime(createTime);
      return this;
    }

    @Override
    public Builder setName(String name) {
      infoBuilder.setName(name);
      return this;
    }

    @Override
    public Builder setOrigin(String origin) {
      infoBuilder.setOrigin(origin);
      return this;
    }

    @Override
    public Builder setParent(String parent) {
      infoBuilder.setParent(parent);
      return this;
    }

    @Override
    public Builder setReason(String reason) {
      infoBuilder.setReason(reason);
      return this;
    }

    @Override
    public Builder setRestrictions(List<String> restrictions) {
      infoBuilder.setRestrictions(restrictions);
      return this;
    }

    @Override
    public Lien build() {
      return new Lien(resourceManager, infoBuilder);
    }
  }

  Lien(ResourceManager resourceManager, LienInfo.BuilderImpl infoBuilder) {
    super(infoBuilder);
    this.resourceManager = checkNotNull(resourceManager);
    this.options = resourceManager.getOptions();
  }

  /** Returns the {@link ResourceManager} service object associated with this Lien. */
  public ResourceManager getResourceManager() {
    return resourceManager;
  }

  /**
   * Create a Lien which applies to the resource denoted by the parent field.
   *
   * <p>Callers of this method will require permission on the parent resource. For example, applying
   * to projects/1234 requires permission resourcemanager.projects.updateLiens.
   *
   * <p>NOTE: Some resources may limit the number of Liens which may be applied.
   *
   * @param lienInfo
   * @throws ResourceManagerException upon fuiler.
   * @see <a href= "https://cloud.google.com/resource-manager/reference/rest/v1/liens/create">Cloud
   *     Resource Manager create</a>
   */
  public Lien create(LienInfo lienInfo) {
    return resourceManager.createLien(lienInfo);
  }

  /**
   * Delete a Lien by name.
   *
   * <p>Callers of this method will require permission on the parent resource. For example, a Lien
   * with a parent of projects/1234 requires permission resourcemanager.projects.updateLiens.
   *
   * @throws ResourceManagerException upon failre.
   * @see <a href= "https://cloud.google.com/resource-manager/reference/rest/v1/liens/delete">Cloud
   *     Resource Manager delete</a>
   */
  public void delete() {
    resourceManager.deleteLien(getName());
  }

  /**
   * Retrieve a Lien by name.
   *
   * <p>Callers of this method will require permission on the parent resource. For example, a Lien
   * with a parent of projects/1234 requires permission requires permission
   * resourcemanager.projects.get or resourcemanager.projects.updateLiens.
   *
   * @throws ResourceManagerException upon failre.
   * @see <a href= "https://cloud.google.com/resource-manager/reference/rest/v1/liens/list">Cloud
   *     Resource Manager get</a>
   */
  public Lien get() {
    return resourceManager.getLien(getName());
  }

  /**
   * List all Liens applied to the parent resource.
   *
   * <p>Callers of this method will require permission on the parent resource. For example, a Lien
   * with a parent of projects/1234 requires permission resourcemanager.projects.get.
   *
   * @param options
   * @throws ResourceManagerException upon failre.
   * @see <a href= "https://cloud.google.com/resource-manager/reference/rest/v1/liens/list">Cloud
   *     Resource Manager list</a>
   */
  public Page<Lien> list(LienListOption... options) {
    return resourceManager.listLiens(getParent(), options);
  }

  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public final boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj == null || !obj.getClass().equals(Lien.class)) {
      return false;
    }
    Lien other = (Lien) obj;
    return Objects.equals(toPb(), other.toPb()) && Objects.equals(options, other.options);
  }

  @Override
  public final int hashCode() {
    return Objects.hash(super.hashCode(), options);
  }

  private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
    in.defaultReadObject();
    this.resourceManager = options.getService();
  }

  static Lien fromPb(
      ResourceManager resourceManager,
      com.google.api.services.cloudresourcemanager.model.Lien answer) {
    LienInfo info = LienInfo.fromPb(answer);
    return new Lien(resourceManager, new LienInfo.BuilderImpl(info));
  }
}
