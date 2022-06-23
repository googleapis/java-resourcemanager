// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/cloud/resourcemanager/v3/organizations.proto

package com.google.cloud.resourcemanager.v3;

public final class OrganizationsProto {
  private OrganizationsProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_cloud_resourcemanager_v3_Organization_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_resourcemanager_v3_Organization_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_cloud_resourcemanager_v3_GetOrganizationRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_resourcemanager_v3_GetOrganizationRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_cloud_resourcemanager_v3_SearchOrganizationsRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_resourcemanager_v3_SearchOrganizationsRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_cloud_resourcemanager_v3_SearchOrganizationsResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_resourcemanager_v3_SearchOrganizationsResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_cloud_resourcemanager_v3_DeleteOrganizationMetadata_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_resourcemanager_v3_DeleteOrganizationMetadata_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_cloud_resourcemanager_v3_UndeleteOrganizationMetadata_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_resourcemanager_v3_UndeleteOrganizationMetadata_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n3google/cloud/resourcemanager/v3/organi" +
      "zations.proto\022\037google.cloud.resourcemana" +
      "ger.v3\032\034google/api/annotations.proto\032\027go" +
      "ogle/api/client.proto\032\037google/api/field_" +
      "behavior.proto\032\031google/api/resource.prot" +
      "o\032\036google/iam/v1/iam_policy.proto\032\032googl" +
      "e/iam/v1/policy.proto\032#google/longrunnin" +
      "g/operations.proto\032\037google/protobuf/time" +
      "stamp.proto\"\203\004\n\014Organization\022\021\n\004name\030\001 \001" +
      "(\tB\003\340A\003\022\031\n\014display_name\030\002 \001(\tB\003\340A\003\022$\n\025di" +
      "rectory_customer_id\030\003 \001(\tB\003\340A\005H\000\022G\n\005stat" +
      "e\030\004 \001(\01623.google.cloud.resourcemanager.v" +
      "3.Organization.StateB\003\340A\003\0224\n\013create_time" +
      "\030\005 \001(\0132\032.google.protobuf.TimestampB\003\340A\003\022" +
      "4\n\013update_time\030\006 \001(\0132\032.google.protobuf.T" +
      "imestampB\003\340A\003\0224\n\013delete_time\030\007 \001(\0132\032.goo" +
      "gle.protobuf.TimestampB\003\340A\003\022\021\n\004etag\030\010 \001(" +
      "\tB\003\340A\003\"@\n\005State\022\025\n\021STATE_UNSPECIFIED\020\000\022\n" +
      "\n\006ACTIVE\020\001\022\024\n\020DELETE_REQUESTED\020\002:V\352AS\n0c" +
      "loudresourcemanager.googleapis.com/Organ" +
      "ization\022\034organizations/{organization}R\001\001" +
      "B\007\n\005owner\"`\n\026GetOrganizationRequest\022F\n\004n" +
      "ame\030\001 \001(\tB8\340A\002\372A2\n0cloudresourcemanager." +
      "googleapis.com/Organization\"a\n\032SearchOrg" +
      "anizationsRequest\022\026\n\tpage_size\030\001 \001(\005B\003\340A" +
      "\001\022\027\n\npage_token\030\002 \001(\tB\003\340A\001\022\022\n\005query\030\003 \001(" +
      "\tB\003\340A\001\"|\n\033SearchOrganizationsResponse\022D\n" +
      "\rorganizations\030\001 \003(\0132-.google.cloud.reso" +
      "urcemanager.v3.Organization\022\027\n\017next_page" +
      "_token\030\002 \001(\t\"\034\n\032DeleteOrganizationMetada" +
      "ta\"\036\n\034UndeleteOrganizationMetadata2\345\007\n\rO" +
      "rganizations\022\244\001\n\017GetOrganization\0227.googl" +
      "e.cloud.resourcemanager.v3.GetOrganizati" +
      "onRequest\032-.google.cloud.resourcemanager" +
      ".v3.Organization\")\202\323\344\223\002\034\022\032/v3/{name=orga" +
      "nizations/*}\332A\004name\022\272\001\n\023SearchOrganizati" +
      "ons\022;.google.cloud.resourcemanager.v3.Se" +
      "archOrganizationsRequest\032<.google.cloud." +
      "resourcemanager.v3.SearchOrganizationsRe" +
      "sponse\"(\202\323\344\223\002\032\022\030/v3/organizations:search" +
      "\332A\005query\022\214\001\n\014GetIamPolicy\022\".google.iam.v" +
      "1.GetIamPolicyRequest\032\025.google.iam.v1.Po" +
      "licy\"A\202\323\344\223\0020\"+/v3/{resource=organization" +
      "s/*}:getIamPolicy:\001*\332A\010resource\022\214\001\n\014SetI" +
      "amPolicy\022\".google.iam.v1.SetIamPolicyReq" +
      "uest\032\025.google.iam.v1.Policy\"A\202\323\344\223\0020\"+/v3" +
      "/{resource=organizations/*}:setIamPolicy" +
      ":\001*\332A\010resource\022\276\001\n\022TestIamPermissions\022(." +
      "google.iam.v1.TestIamPermissionsRequest\032" +
      ").google.iam.v1.TestIamPermissionsRespon" +
      "se\"S\202\323\344\223\0026\"1/v3/{resource=organizations/" +
      "*}:testIamPermissions:\001*\332A\024resource,perm" +
      "issions\032\220\001\312A#cloudresourcemanager.google" +
      "apis.com\322Aghttps://www.googleapis.com/au" +
      "th/cloud-platform,https://www.googleapis" +
      ".com/auth/cloud-platform.read-onlyB\364\001\n#c" +
      "om.google.cloud.resourcemanager.v3B\022Orga" +
      "nizationsProtoP\001ZNgoogle.golang.org/genp" +
      "roto/googleapis/cloud/resourcemanager/v3" +
      ";resourcemanager\252\002\037Google.Cloud.Resource" +
      "Manager.V3\312\002\037Google\\Cloud\\ResourceManage" +
      "r\\V3\352\002\"Google::Cloud::ResourceManager::V" +
      "3b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.api.AnnotationsProto.getDescriptor(),
          com.google.api.ClientProto.getDescriptor(),
          com.google.api.FieldBehaviorProto.getDescriptor(),
          com.google.api.ResourceProto.getDescriptor(),
          com.google.iam.v1.IamPolicyProto.getDescriptor(),
          com.google.iam.v1.PolicyProto.getDescriptor(),
          com.google.longrunning.OperationsProto.getDescriptor(),
          com.google.protobuf.TimestampProto.getDescriptor(),
        });
    internal_static_google_cloud_resourcemanager_v3_Organization_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_google_cloud_resourcemanager_v3_Organization_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_cloud_resourcemanager_v3_Organization_descriptor,
        new java.lang.String[] { "Name", "DisplayName", "DirectoryCustomerId", "State", "CreateTime", "UpdateTime", "DeleteTime", "Etag", "Owner", });
    internal_static_google_cloud_resourcemanager_v3_GetOrganizationRequest_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_google_cloud_resourcemanager_v3_GetOrganizationRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_cloud_resourcemanager_v3_GetOrganizationRequest_descriptor,
        new java.lang.String[] { "Name", });
    internal_static_google_cloud_resourcemanager_v3_SearchOrganizationsRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_google_cloud_resourcemanager_v3_SearchOrganizationsRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_cloud_resourcemanager_v3_SearchOrganizationsRequest_descriptor,
        new java.lang.String[] { "PageSize", "PageToken", "Query", });
    internal_static_google_cloud_resourcemanager_v3_SearchOrganizationsResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_google_cloud_resourcemanager_v3_SearchOrganizationsResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_cloud_resourcemanager_v3_SearchOrganizationsResponse_descriptor,
        new java.lang.String[] { "Organizations", "NextPageToken", });
    internal_static_google_cloud_resourcemanager_v3_DeleteOrganizationMetadata_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_google_cloud_resourcemanager_v3_DeleteOrganizationMetadata_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_cloud_resourcemanager_v3_DeleteOrganizationMetadata_descriptor,
        new java.lang.String[] { });
    internal_static_google_cloud_resourcemanager_v3_UndeleteOrganizationMetadata_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_google_cloud_resourcemanager_v3_UndeleteOrganizationMetadata_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_cloud_resourcemanager_v3_UndeleteOrganizationMetadata_descriptor,
        new java.lang.String[] { });
    com.google.protobuf.ExtensionRegistry registry =
        com.google.protobuf.ExtensionRegistry.newInstance();
    registry.add(com.google.api.ClientProto.defaultHost);
    registry.add(com.google.api.FieldBehaviorProto.fieldBehavior);
    registry.add(com.google.api.AnnotationsProto.http);
    registry.add(com.google.api.ClientProto.methodSignature);
    registry.add(com.google.api.ClientProto.oauthScopes);
    registry.add(com.google.api.ResourceProto.resource);
    registry.add(com.google.api.ResourceProto.resourceReference);
    com.google.protobuf.Descriptors.FileDescriptor
        .internalUpdateFileDescriptor(descriptor, registry);
    com.google.api.AnnotationsProto.getDescriptor();
    com.google.api.ClientProto.getDescriptor();
    com.google.api.FieldBehaviorProto.getDescriptor();
    com.google.api.ResourceProto.getDescriptor();
    com.google.iam.v1.IamPolicyProto.getDescriptor();
    com.google.iam.v1.PolicyProto.getDescriptor();
    com.google.longrunning.OperationsProto.getDescriptor();
    com.google.protobuf.TimestampProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
