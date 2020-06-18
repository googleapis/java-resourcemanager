/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.resourcemanager.v2;

import com.google.api.pathtemplate.PathTemplate;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/** AUTO-GENERATED DOCUMENTATION AND CLASS */
@javax.annotation.Generated("by GAPIC protoc plugin")
public class OrganizationName extends ParentName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("organizations/{org_id}");

  private volatile Map<String, String> fieldValuesMap;

  private final String orgId;

  public String getOrgId() {
    return orgId;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private OrganizationName(Builder builder) {
    orgId = Preconditions.checkNotNull(builder.getOrgId());
  }

  public static OrganizationName of(String orgId) {
    return newBuilder().setOrgId(orgId).build();
  }

  public static String format(String orgId) {
    return newBuilder().setOrgId(orgId).build().toString();
  }

  public static OrganizationName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            formattedString, "OrganizationName.parse: formattedString not in valid format");
    return of(matchMap.get("org_id"));
  }

  public static List<OrganizationName> parseList(List<String> formattedStrings) {
    List<OrganizationName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<OrganizationName> values) {
    List<String> list = new ArrayList<String>(values.size());
    for (OrganizationName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PATH_TEMPLATE.matches(formattedString);
  }

  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          fieldMapBuilder.put("orgId", orgId);
          fieldValuesMap = fieldMapBuilder.build();
        }
      }
    }
    return fieldValuesMap;
  }

  public String getFieldValue(String fieldName) {
    return getFieldValuesMap().get(fieldName);
  }

  @Override
  public String toString() {
    return PATH_TEMPLATE.instantiate("org_id", orgId);
  }

  /** Builder for OrganizationName. */
  public static class Builder {

    private String orgId;

    public String getOrgId() {
      return orgId;
    }

    public Builder setOrgId(String orgId) {
      this.orgId = orgId;
      return this;
    }

    private Builder() {}

    private Builder(OrganizationName organizationName) {
      orgId = organizationName.orgId;
    }

    public OrganizationName build() {
      return new OrganizationName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof OrganizationName) {
      OrganizationName that = (OrganizationName) o;
      return (this.orgId.equals(that.orgId));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= orgId.hashCode();
    return h;
  }
}
