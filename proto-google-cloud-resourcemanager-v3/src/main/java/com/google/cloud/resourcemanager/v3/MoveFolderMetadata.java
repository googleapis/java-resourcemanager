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
// source: google/cloud/resourcemanager/v3/folders.proto

package com.google.cloud.resourcemanager.v3;

/**
 *
 *
 * <pre>
 * Metadata pertaining to the folder move process.
 * </pre>
 *
 * Protobuf type {@code google.cloud.resourcemanager.v3.MoveFolderMetadata}
 */
public final class MoveFolderMetadata extends com.google.protobuf.GeneratedMessageV3
    implements
    // @@protoc_insertion_point(message_implements:google.cloud.resourcemanager.v3.MoveFolderMetadata)
    MoveFolderMetadataOrBuilder {
  private static final long serialVersionUID = 0L;
  // Use MoveFolderMetadata.newBuilder() to construct.
  private MoveFolderMetadata(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }

  private MoveFolderMetadata() {
    displayName_ = "";
    sourceParent_ = "";
    destinationParent_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
    return new MoveFolderMetadata();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }

  private MoveFolderMetadata(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10:
            {
              java.lang.String s = input.readStringRequireUtf8();

              displayName_ = s;
              break;
            }
          case 18:
            {
              java.lang.String s = input.readStringRequireUtf8();

              sourceParent_ = s;
              break;
            }
          case 26:
            {
              java.lang.String s = input.readStringRequireUtf8();

              destinationParent_ = s;
              break;
            }
          default:
            {
              if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }

  public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
    return com.google.cloud.resourcemanager.v3.FoldersProto
        .internal_static_google_cloud_resourcemanager_v3_MoveFolderMetadata_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.google.cloud.resourcemanager.v3.FoldersProto
        .internal_static_google_cloud_resourcemanager_v3_MoveFolderMetadata_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.google.cloud.resourcemanager.v3.MoveFolderMetadata.class,
            com.google.cloud.resourcemanager.v3.MoveFolderMetadata.Builder.class);
  }

  public static final int DISPLAY_NAME_FIELD_NUMBER = 1;
  private volatile java.lang.Object displayName_;
  /**
   *
   *
   * <pre>
   * The display name of the folder.
   * </pre>
   *
   * <code>string display_name = 1;</code>
   *
   * @return The displayName.
   */
  @java.lang.Override
  public java.lang.String getDisplayName() {
    java.lang.Object ref = displayName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      displayName_ = s;
      return s;
    }
  }
  /**
   *
   *
   * <pre>
   * The display name of the folder.
   * </pre>
   *
   * <code>string display_name = 1;</code>
   *
   * @return The bytes for displayName.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString getDisplayNameBytes() {
    java.lang.Object ref = displayName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
      displayName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int SOURCE_PARENT_FIELD_NUMBER = 2;
  private volatile java.lang.Object sourceParent_;
  /**
   *
   *
   * <pre>
   * The resource name of the folder's parent.
   * </pre>
   *
   * <code>string source_parent = 2;</code>
   *
   * @return The sourceParent.
   */
  @java.lang.Override
  public java.lang.String getSourceParent() {
    java.lang.Object ref = sourceParent_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      sourceParent_ = s;
      return s;
    }
  }
  /**
   *
   *
   * <pre>
   * The resource name of the folder's parent.
   * </pre>
   *
   * <code>string source_parent = 2;</code>
   *
   * @return The bytes for sourceParent.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString getSourceParentBytes() {
    java.lang.Object ref = sourceParent_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
      sourceParent_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int DESTINATION_PARENT_FIELD_NUMBER = 3;
  private volatile java.lang.Object destinationParent_;
  /**
   *
   *
   * <pre>
   * The resource name of the folder or organization to move the folder to.
   * </pre>
   *
   * <code>string destination_parent = 3;</code>
   *
   * @return The destinationParent.
   */
  @java.lang.Override
  public java.lang.String getDestinationParent() {
    java.lang.Object ref = destinationParent_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      destinationParent_ = s;
      return s;
    }
  }
  /**
   *
   *
   * <pre>
   * The resource name of the folder or organization to move the folder to.
   * </pre>
   *
   * <code>string destination_parent = 3;</code>
   *
   * @return The bytes for destinationParent.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString getDestinationParentBytes() {
    java.lang.Object ref = destinationParent_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
      destinationParent_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;

  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output) throws java.io.IOException {
    if (!getDisplayNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, displayName_);
    }
    if (!getSourceParentBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, sourceParent_);
    }
    if (!getDestinationParentBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, destinationParent_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getDisplayNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, displayName_);
    }
    if (!getSourceParentBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, sourceParent_);
    }
    if (!getDestinationParentBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, destinationParent_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof com.google.cloud.resourcemanager.v3.MoveFolderMetadata)) {
      return super.equals(obj);
    }
    com.google.cloud.resourcemanager.v3.MoveFolderMetadata other =
        (com.google.cloud.resourcemanager.v3.MoveFolderMetadata) obj;

    if (!getDisplayName().equals(other.getDisplayName())) return false;
    if (!getSourceParent().equals(other.getSourceParent())) return false;
    if (!getDestinationParent().equals(other.getDestinationParent())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + DISPLAY_NAME_FIELD_NUMBER;
    hash = (53 * hash) + getDisplayName().hashCode();
    hash = (37 * hash) + SOURCE_PARENT_FIELD_NUMBER;
    hash = (53 * hash) + getSourceParent().hashCode();
    hash = (37 * hash) + DESTINATION_PARENT_FIELD_NUMBER;
    hash = (53 * hash) + getDestinationParent().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.google.cloud.resourcemanager.v3.MoveFolderMetadata parseFrom(
      java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.cloud.resourcemanager.v3.MoveFolderMetadata parseFrom(
      java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.cloud.resourcemanager.v3.MoveFolderMetadata parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.cloud.resourcemanager.v3.MoveFolderMetadata parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.cloud.resourcemanager.v3.MoveFolderMetadata parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.cloud.resourcemanager.v3.MoveFolderMetadata parseFrom(
      byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.cloud.resourcemanager.v3.MoveFolderMetadata parseFrom(
      java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.google.cloud.resourcemanager.v3.MoveFolderMetadata parseFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.google.cloud.resourcemanager.v3.MoveFolderMetadata parseDelimitedFrom(
      java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
  }

  public static com.google.cloud.resourcemanager.v3.MoveFolderMetadata parseDelimitedFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.google.cloud.resourcemanager.v3.MoveFolderMetadata parseFrom(
      com.google.protobuf.CodedInputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.google.cloud.resourcemanager.v3.MoveFolderMetadata parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
        PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() {
    return newBuilder();
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(
      com.google.cloud.resourcemanager.v3.MoveFolderMetadata prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   *
   *
   * <pre>
   * Metadata pertaining to the folder move process.
   * </pre>
   *
   * Protobuf type {@code google.cloud.resourcemanager.v3.MoveFolderMetadata}
   */
  public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
      implements
      // @@protoc_insertion_point(builder_implements:google.cloud.resourcemanager.v3.MoveFolderMetadata)
      com.google.cloud.resourcemanager.v3.MoveFolderMetadataOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.google.cloud.resourcemanager.v3.FoldersProto
          .internal_static_google_cloud_resourcemanager_v3_MoveFolderMetadata_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.google.cloud.resourcemanager.v3.FoldersProto
          .internal_static_google_cloud_resourcemanager_v3_MoveFolderMetadata_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.google.cloud.resourcemanager.v3.MoveFolderMetadata.class,
              com.google.cloud.resourcemanager.v3.MoveFolderMetadata.Builder.class);
    }

    // Construct using com.google.cloud.resourcemanager.v3.MoveFolderMetadata.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders) {}
    }

    @java.lang.Override
    public Builder clear() {
      super.clear();
      displayName_ = "";

      sourceParent_ = "";

      destinationParent_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
      return com.google.cloud.resourcemanager.v3.FoldersProto
          .internal_static_google_cloud_resourcemanager_v3_MoveFolderMetadata_descriptor;
    }

    @java.lang.Override
    public com.google.cloud.resourcemanager.v3.MoveFolderMetadata getDefaultInstanceForType() {
      return com.google.cloud.resourcemanager.v3.MoveFolderMetadata.getDefaultInstance();
    }

    @java.lang.Override
    public com.google.cloud.resourcemanager.v3.MoveFolderMetadata build() {
      com.google.cloud.resourcemanager.v3.MoveFolderMetadata result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.google.cloud.resourcemanager.v3.MoveFolderMetadata buildPartial() {
      com.google.cloud.resourcemanager.v3.MoveFolderMetadata result =
          new com.google.cloud.resourcemanager.v3.MoveFolderMetadata(this);
      result.displayName_ = displayName_;
      result.sourceParent_ = sourceParent_;
      result.destinationParent_ = destinationParent_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }

    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field, java.lang.Object value) {
      return super.setField(field, value);
    }

    @java.lang.Override
    public Builder clearField(com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }

    @java.lang.Override
    public Builder clearOneof(com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }

    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field, int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }

    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field, java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.google.cloud.resourcemanager.v3.MoveFolderMetadata) {
        return mergeFrom((com.google.cloud.resourcemanager.v3.MoveFolderMetadata) other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.google.cloud.resourcemanager.v3.MoveFolderMetadata other) {
      if (other == com.google.cloud.resourcemanager.v3.MoveFolderMetadata.getDefaultInstance())
        return this;
      if (!other.getDisplayName().isEmpty()) {
        displayName_ = other.displayName_;
        onChanged();
      }
      if (!other.getSourceParent().isEmpty()) {
        sourceParent_ = other.sourceParent_;
        onChanged();
      }
      if (!other.getDestinationParent().isEmpty()) {
        destinationParent_ = other.destinationParent_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.google.cloud.resourcemanager.v3.MoveFolderMetadata parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage =
            (com.google.cloud.resourcemanager.v3.MoveFolderMetadata) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object displayName_ = "";
    /**
     *
     *
     * <pre>
     * The display name of the folder.
     * </pre>
     *
     * <code>string display_name = 1;</code>
     *
     * @return The displayName.
     */
    public java.lang.String getDisplayName() {
      java.lang.Object ref = displayName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        displayName_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     *
     *
     * <pre>
     * The display name of the folder.
     * </pre>
     *
     * <code>string display_name = 1;</code>
     *
     * @return The bytes for displayName.
     */
    public com.google.protobuf.ByteString getDisplayNameBytes() {
      java.lang.Object ref = displayName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        displayName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     *
     *
     * <pre>
     * The display name of the folder.
     * </pre>
     *
     * <code>string display_name = 1;</code>
     *
     * @param value The displayName to set.
     * @return This builder for chaining.
     */
    public Builder setDisplayName(java.lang.String value) {
      if (value == null) {
        throw new NullPointerException();
      }

      displayName_ = value;
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * The display name of the folder.
     * </pre>
     *
     * <code>string display_name = 1;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearDisplayName() {

      displayName_ = getDefaultInstance().getDisplayName();
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * The display name of the folder.
     * </pre>
     *
     * <code>string display_name = 1;</code>
     *
     * @param value The bytes for displayName to set.
     * @return This builder for chaining.
     */
    public Builder setDisplayNameBytes(com.google.protobuf.ByteString value) {
      if (value == null) {
        throw new NullPointerException();
      }
      checkByteStringIsUtf8(value);

      displayName_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object sourceParent_ = "";
    /**
     *
     *
     * <pre>
     * The resource name of the folder's parent.
     * </pre>
     *
     * <code>string source_parent = 2;</code>
     *
     * @return The sourceParent.
     */
    public java.lang.String getSourceParent() {
      java.lang.Object ref = sourceParent_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        sourceParent_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     *
     *
     * <pre>
     * The resource name of the folder's parent.
     * </pre>
     *
     * <code>string source_parent = 2;</code>
     *
     * @return The bytes for sourceParent.
     */
    public com.google.protobuf.ByteString getSourceParentBytes() {
      java.lang.Object ref = sourceParent_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        sourceParent_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     *
     *
     * <pre>
     * The resource name of the folder's parent.
     * </pre>
     *
     * <code>string source_parent = 2;</code>
     *
     * @param value The sourceParent to set.
     * @return This builder for chaining.
     */
    public Builder setSourceParent(java.lang.String value) {
      if (value == null) {
        throw new NullPointerException();
      }

      sourceParent_ = value;
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * The resource name of the folder's parent.
     * </pre>
     *
     * <code>string source_parent = 2;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearSourceParent() {

      sourceParent_ = getDefaultInstance().getSourceParent();
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * The resource name of the folder's parent.
     * </pre>
     *
     * <code>string source_parent = 2;</code>
     *
     * @param value The bytes for sourceParent to set.
     * @return This builder for chaining.
     */
    public Builder setSourceParentBytes(com.google.protobuf.ByteString value) {
      if (value == null) {
        throw new NullPointerException();
      }
      checkByteStringIsUtf8(value);

      sourceParent_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object destinationParent_ = "";
    /**
     *
     *
     * <pre>
     * The resource name of the folder or organization to move the folder to.
     * </pre>
     *
     * <code>string destination_parent = 3;</code>
     *
     * @return The destinationParent.
     */
    public java.lang.String getDestinationParent() {
      java.lang.Object ref = destinationParent_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        destinationParent_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     *
     *
     * <pre>
     * The resource name of the folder or organization to move the folder to.
     * </pre>
     *
     * <code>string destination_parent = 3;</code>
     *
     * @return The bytes for destinationParent.
     */
    public com.google.protobuf.ByteString getDestinationParentBytes() {
      java.lang.Object ref = destinationParent_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        destinationParent_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     *
     *
     * <pre>
     * The resource name of the folder or organization to move the folder to.
     * </pre>
     *
     * <code>string destination_parent = 3;</code>
     *
     * @param value The destinationParent to set.
     * @return This builder for chaining.
     */
    public Builder setDestinationParent(java.lang.String value) {
      if (value == null) {
        throw new NullPointerException();
      }

      destinationParent_ = value;
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * The resource name of the folder or organization to move the folder to.
     * </pre>
     *
     * <code>string destination_parent = 3;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearDestinationParent() {

      destinationParent_ = getDefaultInstance().getDestinationParent();
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * The resource name of the folder or organization to move the folder to.
     * </pre>
     *
     * <code>string destination_parent = 3;</code>
     *
     * @param value The bytes for destinationParent to set.
     * @return This builder for chaining.
     */
    public Builder setDestinationParentBytes(com.google.protobuf.ByteString value) {
      if (value == null) {
        throw new NullPointerException();
      }
      checkByteStringIsUtf8(value);

      destinationParent_ = value;
      onChanged();
      return this;
    }

    @java.lang.Override
    public final Builder setUnknownFields(final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }

    // @@protoc_insertion_point(builder_scope:google.cloud.resourcemanager.v3.MoveFolderMetadata)
  }

  // @@protoc_insertion_point(class_scope:google.cloud.resourcemanager.v3.MoveFolderMetadata)
  private static final com.google.cloud.resourcemanager.v3.MoveFolderMetadata DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new com.google.cloud.resourcemanager.v3.MoveFolderMetadata();
  }

  public static com.google.cloud.resourcemanager.v3.MoveFolderMetadata getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<MoveFolderMetadata> PARSER =
      new com.google.protobuf.AbstractParser<MoveFolderMetadata>() {
        @java.lang.Override
        public MoveFolderMetadata parsePartialFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
          return new MoveFolderMetadata(input, extensionRegistry);
        }
      };

  public static com.google.protobuf.Parser<MoveFolderMetadata> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<MoveFolderMetadata> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.cloud.resourcemanager.v3.MoveFolderMetadata getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
}
