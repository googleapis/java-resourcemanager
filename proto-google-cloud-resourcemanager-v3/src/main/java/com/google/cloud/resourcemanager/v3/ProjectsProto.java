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
// source: google/cloud/resourcemanager/v3/projects.proto

package com.google.cloud.resourcemanager.v3;

public final class ProjectsProto {
  private ProjectsProto() {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistryLite registry) {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions((com.google.protobuf.ExtensionRegistryLite) registry);
  }

  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_resourcemanager_v3_Project_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_resourcemanager_v3_Project_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_resourcemanager_v3_Project_LabelsEntry_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_resourcemanager_v3_Project_LabelsEntry_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_resourcemanager_v3_GetProjectRequest_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_resourcemanager_v3_GetProjectRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_resourcemanager_v3_ListProjectsRequest_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_resourcemanager_v3_ListProjectsRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_resourcemanager_v3_ListProjectsResponse_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_resourcemanager_v3_ListProjectsResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_resourcemanager_v3_SearchProjectsRequest_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_resourcemanager_v3_SearchProjectsRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_resourcemanager_v3_SearchProjectsResponse_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_resourcemanager_v3_SearchProjectsResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_resourcemanager_v3_CreateProjectRequest_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_resourcemanager_v3_CreateProjectRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_resourcemanager_v3_CreateProjectMetadata_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_resourcemanager_v3_CreateProjectMetadata_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_resourcemanager_v3_UpdateProjectRequest_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_resourcemanager_v3_UpdateProjectRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_resourcemanager_v3_UpdateProjectMetadata_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_resourcemanager_v3_UpdateProjectMetadata_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_resourcemanager_v3_MoveProjectRequest_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_resourcemanager_v3_MoveProjectRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_resourcemanager_v3_MoveProjectMetadata_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_resourcemanager_v3_MoveProjectMetadata_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_resourcemanager_v3_DeleteProjectRequest_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_resourcemanager_v3_DeleteProjectRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_resourcemanager_v3_DeleteProjectMetadata_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_resourcemanager_v3_DeleteProjectMetadata_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_resourcemanager_v3_UndeleteProjectRequest_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_resourcemanager_v3_UndeleteProjectRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_resourcemanager_v3_UndeleteProjectMetadata_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_resourcemanager_v3_UndeleteProjectMetadata_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }

  private static com.google.protobuf.Descriptors.FileDescriptor descriptor;

  static {
    java.lang.String[] descriptorData = {
      "\n.google/cloud/resourcemanager/v3/projec"
          + "ts.proto\022\037google.cloud.resourcemanager.v"
          + "3\032\034google/api/annotations.proto\032\027google/"
          + "api/client.proto\032\037google/api/field_behav"
          + "ior.proto\032\031google/api/resource.proto\032\036go"
          + "ogle/iam/v1/iam_policy.proto\032\032google/iam"
          + "/v1/policy.proto\032#google/longrunning/ope"
          + "rations.proto\032 google/protobuf/field_mas"
          + "k.proto\032\037google/protobuf/timestamp.proto"
          + "\"\343\004\n\007Project\022\021\n\004name\030\001 \001(\tB\003\340A\003\022\023\n\006paren"
          + "t\030\002 \001(\tB\003\340A\001\022\027\n\nproject_id\030\003 \001(\tB\003\340A\005\022B\n"
          + "\005state\030\004 \001(\0162..google.cloud.resourcemana"
          + "ger.v3.Project.StateB\003\340A\003\022\031\n\014display_nam"
          + "e\030\005 \001(\tB\003\340A\001\0224\n\013create_time\030\006 \001(\0132\032.goog"
          + "le.protobuf.TimestampB\003\340A\003\0224\n\013update_tim"
          + "e\030\007 \001(\0132\032.google.protobuf.TimestampB\003\340A\003"
          + "\0224\n\013delete_time\030\010 \001(\0132\032.google.protobuf."
          + "TimestampB\003\340A\003\022\021\n\004etag\030\t \001(\tB\003\340A\003\022I\n\006lab"
          + "els\030\n \003(\01324.google.cloud.resourcemanager"
          + ".v3.Project.LabelsEntryB\003\340A\001\032-\n\013LabelsEn"
          + "try\022\013\n\003key\030\001 \001(\t\022\r\n\005value\030\002 \001(\t:\0028\001\"@\n\005S"
          + "tate\022\025\n\021STATE_UNSPECIFIED\020\000\022\n\n\006ACTIVE\020\001\022"
          + "\024\n\020DELETE_REQUESTED\020\002:G\352AD\n+cloudresourc"
          + "emanager.googleapis.com/Project\022\022project"
          + "s/{project}R\001\001\"V\n\021GetProjectRequest\022A\n\004n"
          + "ame\030\001 \001(\tB3\340A\002\372A-\n+cloudresourcemanager."
          + "googleapis.com/Project\"|\n\023ListProjectsRe"
          + "quest\022\031\n\006parent\030\001 \001(\tB\t\340A\002\372A\003\022\001*\022\027\n\npage"
          + "_token\030\002 \001(\tB\003\340A\001\022\026\n\tpage_size\030\003 \001(\005B\003\340A"
          + "\001\022\031\n\014show_deleted\030\004 \001(\010B\003\340A\001\"k\n\024ListProj"
          + "ectsResponse\022:\n\010projects\030\001 \003(\0132(.google."
          + "cloud.resourcemanager.v3.Project\022\027\n\017next"
          + "_page_token\030\002 \001(\t\"\\\n\025SearchProjectsReque"
          + "st\022\022\n\005query\030\001 \001(\tB\003\340A\001\022\027\n\npage_token\030\002 \001"
          + "(\tB\003\340A\001\022\026\n\tpage_size\030\003 \001(\005B\003\340A\001\"m\n\026Searc"
          + "hProjectsResponse\022:\n\010projects\030\001 \003(\0132(.go"
          + "ogle.cloud.resourcemanager.v3.Project\022\027\n"
          + "\017next_page_token\030\002 \001(\t\"V\n\024CreateProjectR"
          + "equest\022>\n\007project\030\001 \001(\0132(.google.cloud.r"
          + "esourcemanager.v3.ProjectB\003\340A\002\"i\n\025Create"
          + "ProjectMetadata\022/\n\013create_time\030\001 \001(\0132\032.g"
          + "oogle.protobuf.Timestamp\022\020\n\010gettable\030\002 \001"
          + "(\010\022\r\n\005ready\030\003 \001(\010\"\214\001\n\024UpdateProjectReque"
          + "st\022>\n\007project\030\001 \001(\0132(.google.cloud.resou"
          + "rcemanager.v3.ProjectB\003\340A\002\0224\n\013update_mas"
          + "k\030\002 \001(\0132\032.google.protobuf.FieldMaskB\003\340A\001"
          + "\"\027\n\025UpdateProjectMetadata\"~\n\022MoveProject"
          + "Request\022A\n\004name\030\001 \001(\tB3\340A\002\372A-\n+cloudreso"
          + "urcemanager.googleapis.com/Project\022%\n\022de"
          + "stination_parent\030\002 \001(\tB\t\340A\002\372A\003\022\001*\"\025\n\023Mov"
          + "eProjectMetadata\"Y\n\024DeleteProjectRequest"
          + "\022A\n\004name\030\001 \001(\tB3\340A\002\372A-\n+cloudresourceman"
          + "ager.googleapis.com/Project\"\027\n\025DeletePro"
          + "jectMetadata\"[\n\026UndeleteProjectRequest\022A"
          + "\n\004name\030\001 \001(\tB3\340A\002\372A-\n+cloudresourcemanag"
          + "er.googleapis.com/Project\"\031\n\027UndeletePro"
          + "jectMetadata2\217\020\n\010Projects\022\220\001\n\nGetProject"
          + "\0222.google.cloud.resourcemanager.v3.GetPr"
          + "ojectRequest\032(.google.cloud.resourcemana"
          + "ger.v3.Project\"$\202\323\344\223\002\027\022\025/v3/{name=projec"
          + "ts/*}\332A\004name\022\232\001\n\014ListProjects\0224.google.c"
          + "loud.resourcemanager.v3.ListProjectsRequ"
          + "est\0325.google.cloud.resourcemanager.v3.Li"
          + "stProjectsResponse\"\035\202\323\344\223\002\016\022\014/v3/projects"
          + "\332A\006parent\022\246\001\n\016SearchProjects\0226.google.cl"
          + "oud.resourcemanager.v3.SearchProjectsReq"
          + "uest\0327.google.cloud.resourcemanager.v3.S"
          + "earchProjectsResponse\"#\202\323\344\223\002\025\022\023/v3/proje"
          + "cts:search\332A\005query\022\261\001\n\rCreateProject\0225.g"
          + "oogle.cloud.resourcemanager.v3.CreatePro"
          + "jectRequest\032\035.google.longrunning.Operati"
          + "on\"J\202\323\344\223\002\027\"\014/v3/projects:\007project\332A\007proj"
          + "ect\312A \n\007Project\022\025CreateProjectMetadata\022\316"
          + "\001\n\rUpdateProject\0225.google.cloud.resource"
          + "manager.v3.UpdateProjectRequest\032\035.google"
          + ".longrunning.Operation\"g\202\323\344\223\002(2\035/v3/{pro"
          + "ject.name=projects/*}:\007project\332A\023project"
          + ",update_mask\312A \n\007Project\022\025UpdateProjectM"
          + "etadata\022\304\001\n\013MoveProject\0223.google.cloud.r"
          + "esourcemanager.v3.MoveProjectRequest\032\035.g"
          + "oogle.longrunning.Operation\"a\202\323\344\223\002\037\"\032/v3"
          + "/{name=projects/*}:move:\001*\332A\030name, desti"
          + "nation_parent\312A\036\n\007Project\022\023MoveProjectMe"
          + "tadata\022\256\001\n\rDeleteProject\0225.google.cloud."
          + "resourcemanager.v3.DeleteProjectRequest\032"
          + "\035.google.longrunning.Operation\"G\202\323\344\223\002\027*\025"
          + "/v3/{name=projects/*}\332A\004name\312A \n\007Project"
          + "\022\025DeleteProjectMetadata\022\300\001\n\017UndeleteProj"
          + "ect\0227.google.cloud.resourcemanager.v3.Un"
          + "deleteProjectRequest\032\035.google.longrunnin"
          + "g.Operation\"U\202\323\344\223\002#\"\036/v3/{name=projects/"
          + "*}:undelete:\001*\332A\004name\312A\"\n\007Project\022\027Undel"
          + "eteProjectMetadata\022\207\001\n\014GetIamPolicy\022\".go"
          + "ogle.iam.v1.GetIamPolicyRequest\032\025.google"
          + ".iam.v1.Policy\"<\202\323\344\223\002+\"&/v3/{resource=pr"
          + "ojects/*}:getIamPolicy:\001*\332A\010resource\022\217\001\n"
          + "\014SetIamPolicy\022\".google.iam.v1.SetIamPoli"
          + "cyRequest\032\025.google.iam.v1.Policy\"D\202\323\344\223\002+"
          + "\"&/v3/{resource=projects/*}:setIamPolicy"
          + ":\001*\332A\020resource, policy\022\272\001\n\022TestIamPermis"
          + "sions\022(.google.iam.v1.TestIamPermissions"
          + "Request\032).google.iam.v1.TestIamPermissio"
          + "nsResponse\"O\202\323\344\223\0021\",/v3/{resource=projec"
          + "ts/*}:testIamPermissions:\001*\332A\025resource, "
          + "permissions\032\220\001\312A#cloudresourcemanager.go"
          + "ogleapis.com\322Aghttps://www.googleapis.co"
          + "m/auth/cloud-platform,https://www.google"
          + "apis.com/auth/cloud-platform.read-onlyB\312"
          + "\001\n#com.google.cloud.resourcemanager.v3B\r"
          + "ProjectsProtoP\001ZNgoogle.golang.org/genpr"
          + "oto/googleapis/cloud/resourcemanager/v3;"
          + "resourcemanager\252\002\037Google.Cloud.ResourceM"
          + "anager.V3\312\002\037Google\\Cloud\\ResourceManager"
          + "\\V3b\006proto3"
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
    internal_static_google_cloud_resourcemanager_v3_Project_descriptor =
        getDescriptor().getMessageTypes().get(0);
    internal_static_google_cloud_resourcemanager_v3_Project_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_resourcemanager_v3_Project_descriptor,
            new java.lang.String[] {
              "Name",
              "Parent",
              "ProjectId",
              "State",
              "DisplayName",
              "CreateTime",
              "UpdateTime",
              "DeleteTime",
              "Etag",
              "Labels",
            });
    internal_static_google_cloud_resourcemanager_v3_Project_LabelsEntry_descriptor =
        internal_static_google_cloud_resourcemanager_v3_Project_descriptor.getNestedTypes().get(0);
    internal_static_google_cloud_resourcemanager_v3_Project_LabelsEntry_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_resourcemanager_v3_Project_LabelsEntry_descriptor,
            new java.lang.String[] {
              "Key", "Value",
            });
    internal_static_google_cloud_resourcemanager_v3_GetProjectRequest_descriptor =
        getDescriptor().getMessageTypes().get(1);
    internal_static_google_cloud_resourcemanager_v3_GetProjectRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_resourcemanager_v3_GetProjectRequest_descriptor,
            new java.lang.String[] {
              "Name",
            });
    internal_static_google_cloud_resourcemanager_v3_ListProjectsRequest_descriptor =
        getDescriptor().getMessageTypes().get(2);
    internal_static_google_cloud_resourcemanager_v3_ListProjectsRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_resourcemanager_v3_ListProjectsRequest_descriptor,
            new java.lang.String[] {
              "Parent", "PageToken", "PageSize", "ShowDeleted",
            });
    internal_static_google_cloud_resourcemanager_v3_ListProjectsResponse_descriptor =
        getDescriptor().getMessageTypes().get(3);
    internal_static_google_cloud_resourcemanager_v3_ListProjectsResponse_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_resourcemanager_v3_ListProjectsResponse_descriptor,
            new java.lang.String[] {
              "Projects", "NextPageToken",
            });
    internal_static_google_cloud_resourcemanager_v3_SearchProjectsRequest_descriptor =
        getDescriptor().getMessageTypes().get(4);
    internal_static_google_cloud_resourcemanager_v3_SearchProjectsRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_resourcemanager_v3_SearchProjectsRequest_descriptor,
            new java.lang.String[] {
              "Query", "PageToken", "PageSize",
            });
    internal_static_google_cloud_resourcemanager_v3_SearchProjectsResponse_descriptor =
        getDescriptor().getMessageTypes().get(5);
    internal_static_google_cloud_resourcemanager_v3_SearchProjectsResponse_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_resourcemanager_v3_SearchProjectsResponse_descriptor,
            new java.lang.String[] {
              "Projects", "NextPageToken",
            });
    internal_static_google_cloud_resourcemanager_v3_CreateProjectRequest_descriptor =
        getDescriptor().getMessageTypes().get(6);
    internal_static_google_cloud_resourcemanager_v3_CreateProjectRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_resourcemanager_v3_CreateProjectRequest_descriptor,
            new java.lang.String[] {
              "Project",
            });
    internal_static_google_cloud_resourcemanager_v3_CreateProjectMetadata_descriptor =
        getDescriptor().getMessageTypes().get(7);
    internal_static_google_cloud_resourcemanager_v3_CreateProjectMetadata_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_resourcemanager_v3_CreateProjectMetadata_descriptor,
            new java.lang.String[] {
              "CreateTime", "Gettable", "Ready",
            });
    internal_static_google_cloud_resourcemanager_v3_UpdateProjectRequest_descriptor =
        getDescriptor().getMessageTypes().get(8);
    internal_static_google_cloud_resourcemanager_v3_UpdateProjectRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_resourcemanager_v3_UpdateProjectRequest_descriptor,
            new java.lang.String[] {
              "Project", "UpdateMask",
            });
    internal_static_google_cloud_resourcemanager_v3_UpdateProjectMetadata_descriptor =
        getDescriptor().getMessageTypes().get(9);
    internal_static_google_cloud_resourcemanager_v3_UpdateProjectMetadata_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_resourcemanager_v3_UpdateProjectMetadata_descriptor,
            new java.lang.String[] {});
    internal_static_google_cloud_resourcemanager_v3_MoveProjectRequest_descriptor =
        getDescriptor().getMessageTypes().get(10);
    internal_static_google_cloud_resourcemanager_v3_MoveProjectRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_resourcemanager_v3_MoveProjectRequest_descriptor,
            new java.lang.String[] {
              "Name", "DestinationParent",
            });
    internal_static_google_cloud_resourcemanager_v3_MoveProjectMetadata_descriptor =
        getDescriptor().getMessageTypes().get(11);
    internal_static_google_cloud_resourcemanager_v3_MoveProjectMetadata_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_resourcemanager_v3_MoveProjectMetadata_descriptor,
            new java.lang.String[] {});
    internal_static_google_cloud_resourcemanager_v3_DeleteProjectRequest_descriptor =
        getDescriptor().getMessageTypes().get(12);
    internal_static_google_cloud_resourcemanager_v3_DeleteProjectRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_resourcemanager_v3_DeleteProjectRequest_descriptor,
            new java.lang.String[] {
              "Name",
            });
    internal_static_google_cloud_resourcemanager_v3_DeleteProjectMetadata_descriptor =
        getDescriptor().getMessageTypes().get(13);
    internal_static_google_cloud_resourcemanager_v3_DeleteProjectMetadata_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_resourcemanager_v3_DeleteProjectMetadata_descriptor,
            new java.lang.String[] {});
    internal_static_google_cloud_resourcemanager_v3_UndeleteProjectRequest_descriptor =
        getDescriptor().getMessageTypes().get(14);
    internal_static_google_cloud_resourcemanager_v3_UndeleteProjectRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_resourcemanager_v3_UndeleteProjectRequest_descriptor,
            new java.lang.String[] {
              "Name",
            });
    internal_static_google_cloud_resourcemanager_v3_UndeleteProjectMetadata_descriptor =
        getDescriptor().getMessageTypes().get(15);
    internal_static_google_cloud_resourcemanager_v3_UndeleteProjectMetadata_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_resourcemanager_v3_UndeleteProjectMetadata_descriptor,
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
