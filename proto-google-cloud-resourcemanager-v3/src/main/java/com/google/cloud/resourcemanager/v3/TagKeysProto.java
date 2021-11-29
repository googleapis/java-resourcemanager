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
// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/cloud/resourcemanager/v3/tag_keys.proto

package com.google.cloud.resourcemanager.v3;

public final class TagKeysProto {
  private TagKeysProto() {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistryLite registry) {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions((com.google.protobuf.ExtensionRegistryLite) registry);
  }

  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_resourcemanager_v3_TagKey_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_resourcemanager_v3_TagKey_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_resourcemanager_v3_ListTagKeysRequest_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_resourcemanager_v3_ListTagKeysRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_resourcemanager_v3_ListTagKeysResponse_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_resourcemanager_v3_ListTagKeysResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_resourcemanager_v3_GetTagKeyRequest_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_resourcemanager_v3_GetTagKeyRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_resourcemanager_v3_CreateTagKeyRequest_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_resourcemanager_v3_CreateTagKeyRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_resourcemanager_v3_CreateTagKeyMetadata_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_resourcemanager_v3_CreateTagKeyMetadata_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_resourcemanager_v3_UpdateTagKeyRequest_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_resourcemanager_v3_UpdateTagKeyRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_resourcemanager_v3_UpdateTagKeyMetadata_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_resourcemanager_v3_UpdateTagKeyMetadata_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_resourcemanager_v3_DeleteTagKeyRequest_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_resourcemanager_v3_DeleteTagKeyRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_resourcemanager_v3_DeleteTagKeyMetadata_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_resourcemanager_v3_DeleteTagKeyMetadata_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }

  private static com.google.protobuf.Descriptors.FileDescriptor descriptor;

  static {
    java.lang.String[] descriptorData = {
      "\n"
          + ".google/cloud/resourcemanager/v3/tag_keys.proto\022\037google.cloud.resourcemanager.v"
          + "3\032\034google/api/annotations.proto\032\027google/"
          + "api/client.proto\032\037google/api/field_behav"
          + "ior.proto\032\031google/api/resource.proto\032\036go"
          + "ogle/iam/v1/iam_policy.proto\032\032google/iam/v1/policy.proto\032#google/longrunning/operations.proto\032"
          + " google/protobuf/field_mask.proto\032\037google/protobuf/timestamp.proto\"\315\002\n"
          + "\006TagKey\022\021\n"
          + "\004name\030\001 \001(\tB\003\340A\005\022\023\n"
          + "\006parent\030\002 \001(\tB\003\340A\005\022\032\n\n"
          + "short_name\030\003 \001(\tB\006\340A\002\340A\005\022\037\n"
          + "\017namespaced_name\030\004 \001(\tB\006\340A\003\340A\005\022\030\n"
          + "\013description\030\005 \001(\tB\003\340A\001\0224\n"
          + "\013create_time\030\006 \001(\0132\032.google.protobuf.TimestampB\003\340A\003\0224\n"
          + "\013update_time\030\007"
          + " \001(\0132\032.google.protobuf.TimestampB\003\340A\003\022\021\n"
          + "\004etag\030\010 \001(\tB\003\340A\001:E\352AB\n"
          + "*cloudresourcemanager.googleapis.com/TagKey\022\021tagKeys/{tag_key}R\001\001\"`\n"
          + "\022ListTagKeysRequest\022\031\n"
          + "\006parent\030\001 \001(\tB\t\340A\002\372A\003\022\001*\022\026\n"
          + "\tpage_size\030\002 \001(\005B\003\340A\001\022\027\n\n"
          + "page_token\030\003 \001(\tB\003\340A\001\"i\n"
          + "\023ListTagKeysResponse\0229\n"
          + "\010tag_keys\030\001 \003(\0132\'.google.cloud.resourcemanager.v3.TagKey\022\027\n"
          + "\017next_page_token\030\002 \001(\t\"T\n"
          + "\020GetTagKeyRequest\022@\n"
          + "\004name\030\001 \001(\tB2\340A\002\372A,\n"
          + "*cloudresourcemanager.googleapis.com/TagKey\"p\n"
          + "\023CreateTagKeyRequest\022=\n"
          + "\007tag_key\030\001"
          + " \001(\0132\'.google.cloud.resourcemanager.v3.TagKeyB\003\340A\002\022\032\n\r"
          + "validate_only\030\002 \001(\010B\003\340A\001\"\026\n"
          + "\024CreateTagKeyMetadata\"\234\001\n"
          + "\023UpdateTagKeyRequest\022=\n"
          + "\007tag_key\030\001"
          + " \001(\0132\'.google.cloud.resourcemanager.v3.TagKeyB\003\340A\002\022/\n"
          + "\013update_mask\030\002 \001(\0132\032.google.protobuf.FieldMask\022\025\n\r"
          + "validate_only\030\003 \001(\010\"\026\n"
          + "\024UpdateTagKeyMetadata\"\206\001\n"
          + "\023DeleteTagKeyRequest\022@\n"
          + "\004name\030\001 \001(\tB2\340A\002\372A,\n"
          + "*cloudresourcemanager.googleapis.com/TagKey\022\032\n\r"
          + "validate_only\030\002 \001(\010B\003\340A\001\022\021\n"
          + "\004etag\030\003 \001(\tB\003\340A\001\"\026\n"
          + "\024DeleteTagKeyMetadata2\277\013\n"
          + "\007TagKeys\022\226\001\n"
          + "\013ListTagKeys\0223.google.cloud.resourcemanager.v3.ListTagKeysRequest\0324.google.cloud.resourcemanager.v3.ListTagKeysResponse\"\034\202\323\344\223\002\r"
          + "\022\013/v3/tagKeys\332A\006parent\022\214\001\n"
          + "\tGetTagKey\0221.google.cloud.resourcemanager.v3.GetTagKeyRequest\032\'.google.cloud.resourcemanager.v3.TagKey\"#\202\323\344\223\002\026\022\024/v3/{name=tagKeys/*}\332A\004name\022\254\001\n"
          + "\014CreateTagKey\0224.google.cloud.resourcemanager.v3.CreateTagKeyRequest\032\035.google.longrunning.Operation\"G\202\323\344\223\002\026\"\013/v3/tagKeys:\007tag_key\332A\007tag_key\312A\036\n"
          + "\006TagKey\022\024CreateTagKeyMetadata\022\311\001\n"
          + "\014UpdateTagKey\0224.google.cloud.resourcemanager.v3.UpdateTagKeyRequest\032\035.google.longrunning.Operation\"d\202\323\344\223\002\'2\034/v3/{tag_key.name=tagKeys/*}:\007tag_key\332A\023tag_key,update_mask\312A\036\n"
          + "\006TagKey\022\024UpdateTagKeyMetadata\022\251\001\n"
          + "\014DeleteTagKey\0224.google.cloud.resourcemanager.v3.DeleteTagKeyRequest\032\035.google.longrunning.Operation\"D\202\323\344\223\002\026*\024/v3/{name=tagKeys/*}\332A\004name\312A\036\n"
          + "\006TagKey\022\024DeleteTagKeyMetadata\022\206\001\n"
          + "\014GetIamPolicy\022\".google.iam.v1.GetIamPolicyRequest\032\025.google.iam.v1.Policy\";\202\323\344\223\002*\"%/v3/{resource=tagKeys/*}:getIamPolicy:\001*\332A\010resource\022\215\001\n"
          + "\014SetIamPolicy\022\".google.iam.v1.SetIamPolicyRequest\032\025.google.iam.v1.Policy\"B\202\323\344\223\002*\"%/v3/{resource=tagKeys/*}:setIamPolicy:\001*\332A\017resource,policy\022\270\001\n"
          + "\022TestIamPermissions\022(.google.iam.v1.TestIamPermissionsRequest\032).goo"
          + "gle.iam.v1.TestIamPermissionsResponse\"M\202"
          + "\323\344\223\0020\"+/v3/{resource=tagKeys/*}:testIamPermissions:\001*\332A\024resource,permissions\032\220\001\312A#cloudresourcemanager.googleapis.com\322Aghttps://www.googleapis.com/auth/cloud-platform,https://www.googleapis.com/auth/cloud-platform.read-onlyB\356\001\n"
          + "#com.google.cloud.resourcemanager.v3B\014TagKeysProtoP\001Z"
          + "Ngoogle.golang.org/genproto/googleapis/cloud/resourcemanager/v3;resourcemanager\252"
          + "\002\037Google.Cloud.ResourceManager.V3\312\002\037Goog"
          + "le\\Cloud\\ResourceManager\\V3\352\002\"Google::Cloud::ResourceManager::V3b\006proto3"
    };
    descriptor =
        com.google.protobuf.Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(
            descriptorData,
            new com.google.protobuf.Descriptors.FileDescriptor[] {
              com.google.api.AnnotationsProto.getDescriptor(),
              com.google.api.ClientProto.getDescriptor(),
              com.google.api.FieldBehaviorProto.getDescriptor(),
              com.google.api.ResourceProto.getDescriptor(),
              com.google.iam.v1.IamPolicyProto.getDescriptor(),
              com.google.iam.v1.PolicyProto.getDescriptor(),
              com.google.longrunning.OperationsProto.getDescriptor(),
              com.google.protobuf.FieldMaskProto.getDescriptor(),
              com.google.protobuf.TimestampProto.getDescriptor(),
            });
    internal_static_google_cloud_resourcemanager_v3_TagKey_descriptor =
        getDescriptor().getMessageTypes().get(0);
    internal_static_google_cloud_resourcemanager_v3_TagKey_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_resourcemanager_v3_TagKey_descriptor,
            new java.lang.String[] {
              "Name",
              "Parent",
              "ShortName",
              "NamespacedName",
              "Description",
              "CreateTime",
              "UpdateTime",
              "Etag",
            });
    internal_static_google_cloud_resourcemanager_v3_ListTagKeysRequest_descriptor =
        getDescriptor().getMessageTypes().get(1);
    internal_static_google_cloud_resourcemanager_v3_ListTagKeysRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_resourcemanager_v3_ListTagKeysRequest_descriptor,
            new java.lang.String[] {
              "Parent", "PageSize", "PageToken",
            });
    internal_static_google_cloud_resourcemanager_v3_ListTagKeysResponse_descriptor =
        getDescriptor().getMessageTypes().get(2);
    internal_static_google_cloud_resourcemanager_v3_ListTagKeysResponse_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_resourcemanager_v3_ListTagKeysResponse_descriptor,
            new java.lang.String[] {
              "TagKeys", "NextPageToken",
            });
    internal_static_google_cloud_resourcemanager_v3_GetTagKeyRequest_descriptor =
        getDescriptor().getMessageTypes().get(3);
    internal_static_google_cloud_resourcemanager_v3_GetTagKeyRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_resourcemanager_v3_GetTagKeyRequest_descriptor,
            new java.lang.String[] {
              "Name",
            });
    internal_static_google_cloud_resourcemanager_v3_CreateTagKeyRequest_descriptor =
        getDescriptor().getMessageTypes().get(4);
    internal_static_google_cloud_resourcemanager_v3_CreateTagKeyRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_resourcemanager_v3_CreateTagKeyRequest_descriptor,
            new java.lang.String[] {
              "TagKey", "ValidateOnly",
            });
    internal_static_google_cloud_resourcemanager_v3_CreateTagKeyMetadata_descriptor =
        getDescriptor().getMessageTypes().get(5);
    internal_static_google_cloud_resourcemanager_v3_CreateTagKeyMetadata_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_resourcemanager_v3_CreateTagKeyMetadata_descriptor,
            new java.lang.String[] {});
    internal_static_google_cloud_resourcemanager_v3_UpdateTagKeyRequest_descriptor =
        getDescriptor().getMessageTypes().get(6);
    internal_static_google_cloud_resourcemanager_v3_UpdateTagKeyRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_resourcemanager_v3_UpdateTagKeyRequest_descriptor,
            new java.lang.String[] {
              "TagKey", "UpdateMask", "ValidateOnly",
            });
    internal_static_google_cloud_resourcemanager_v3_UpdateTagKeyMetadata_descriptor =
        getDescriptor().getMessageTypes().get(7);
    internal_static_google_cloud_resourcemanager_v3_UpdateTagKeyMetadata_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_resourcemanager_v3_UpdateTagKeyMetadata_descriptor,
            new java.lang.String[] {});
    internal_static_google_cloud_resourcemanager_v3_DeleteTagKeyRequest_descriptor =
        getDescriptor().getMessageTypes().get(8);
    internal_static_google_cloud_resourcemanager_v3_DeleteTagKeyRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_resourcemanager_v3_DeleteTagKeyRequest_descriptor,
            new java.lang.String[] {
              "Name", "ValidateOnly", "Etag",
            });
    internal_static_google_cloud_resourcemanager_v3_DeleteTagKeyMetadata_descriptor =
        getDescriptor().getMessageTypes().get(9);
    internal_static_google_cloud_resourcemanager_v3_DeleteTagKeyMetadata_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_resourcemanager_v3_DeleteTagKeyMetadata_descriptor,
            new java.lang.String[] {});
    com.google.protobuf.ExtensionRegistry registry =
        com.google.protobuf.ExtensionRegistry.newInstance();
    registry.add(com.google.api.ClientProto.defaultHost);
    registry.add(com.google.api.FieldBehaviorProto.fieldBehavior);
    registry.add(com.google.api.AnnotationsProto.http);
    registry.add(com.google.api.ClientProto.methodSignature);
    registry.add(com.google.api.ClientProto.oauthScopes);
    registry.add(com.google.api.ResourceProto.resource);
    registry.add(com.google.api.ResourceProto.resourceReference);
    registry.add(com.google.longrunning.OperationsProto.operationInfo);
    com.google.protobuf.Descriptors.FileDescriptor.internalUpdateFileDescriptor(
        descriptor, registry);
    com.google.api.AnnotationsProto.getDescriptor();
    com.google.api.ClientProto.getDescriptor();
    com.google.api.FieldBehaviorProto.getDescriptor();
    com.google.api.ResourceProto.getDescriptor();
    com.google.iam.v1.IamPolicyProto.getDescriptor();
    com.google.iam.v1.PolicyProto.getDescriptor();
    com.google.longrunning.OperationsProto.getDescriptor();
    com.google.protobuf.FieldMaskProto.getDescriptor();
    com.google.protobuf.TimestampProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
