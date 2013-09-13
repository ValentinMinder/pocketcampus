/**
 * Autogenerated by Thrift Compiler (0.7.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package org.pocketcampus.plugin.qaforum.shared;

import org.apache.commons.lang.builder.HashCodeBuilder;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class s_request implements org.apache.thrift.TBase<s_request, s_request._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("s_request");

  private static final org.apache.thrift.protocol.TField SESSIONID_FIELD_DESC = new org.apache.thrift.protocol.TField("sessionid", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField TOPICS_FIELD_DESC = new org.apache.thrift.protocol.TField("topics", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField TAGS_FIELD_DESC = new org.apache.thrift.protocol.TField("tags", org.apache.thrift.protocol.TType.STRING, (short)3);

  public String sessionid; // required
  public String topics; // required
  public String tags; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    SESSIONID((short)1, "sessionid"),
    TOPICS((short)2, "topics"),
    TAGS((short)3, "tags");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // SESSIONID
          return SESSIONID;
        case 2: // TOPICS
          return TOPICS;
        case 3: // TAGS
          return TAGS;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments

  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.SESSIONID, new org.apache.thrift.meta_data.FieldMetaData("sessionid", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.TOPICS, new org.apache.thrift.meta_data.FieldMetaData("topics", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.TAGS, new org.apache.thrift.meta_data.FieldMetaData("tags", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(s_request.class, metaDataMap);
  }

  public s_request() {
  }

  public s_request(
    String sessionid,
    String topics,
    String tags)
  {
    this();
    this.sessionid = sessionid;
    this.topics = topics;
    this.tags = tags;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public s_request(s_request other) {
    if (other.isSetSessionid()) {
      this.sessionid = other.sessionid;
    }
    if (other.isSetTopics()) {
      this.topics = other.topics;
    }
    if (other.isSetTags()) {
      this.tags = other.tags;
    }
  }

  public s_request deepCopy() {
    return new s_request(this);
  }

  @Override
  public void clear() {
    this.sessionid = null;
    this.topics = null;
    this.tags = null;
  }

  public String getSessionid() {
    return this.sessionid;
  }

  public s_request setSessionid(String sessionid) {
    this.sessionid = sessionid;
    return this;
  }

  public void unsetSessionid() {
    this.sessionid = null;
  }

  /** Returns true if field sessionid is set (has been assigned a value) and false otherwise */
  public boolean isSetSessionid() {
    return this.sessionid != null;
  }

  public void setSessionidIsSet(boolean value) {
    if (!value) {
      this.sessionid = null;
    }
  }

  public String getTopics() {
    return this.topics;
  }

  public s_request setTopics(String topics) {
    this.topics = topics;
    return this;
  }

  public void unsetTopics() {
    this.topics = null;
  }

  /** Returns true if field topics is set (has been assigned a value) and false otherwise */
  public boolean isSetTopics() {
    return this.topics != null;
  }

  public void setTopicsIsSet(boolean value) {
    if (!value) {
      this.topics = null;
    }
  }

  public String getTags() {
    return this.tags;
  }

  public s_request setTags(String tags) {
    this.tags = tags;
    return this;
  }

  public void unsetTags() {
    this.tags = null;
  }

  /** Returns true if field tags is set (has been assigned a value) and false otherwise */
  public boolean isSetTags() {
    return this.tags != null;
  }

  public void setTagsIsSet(boolean value) {
    if (!value) {
      this.tags = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case SESSIONID:
      if (value == null) {
        unsetSessionid();
      } else {
        setSessionid((String)value);
      }
      break;

    case TOPICS:
      if (value == null) {
        unsetTopics();
      } else {
        setTopics((String)value);
      }
      break;

    case TAGS:
      if (value == null) {
        unsetTags();
      } else {
        setTags((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case SESSIONID:
      return getSessionid();

    case TOPICS:
      return getTopics();

    case TAGS:
      return getTags();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case SESSIONID:
      return isSetSessionid();
    case TOPICS:
      return isSetTopics();
    case TAGS:
      return isSetTags();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof s_request)
      return this.equals((s_request)that);
    return false;
  }

  public boolean equals(s_request that) {
    if (that == null)
      return false;

    boolean this_present_sessionid = true && this.isSetSessionid();
    boolean that_present_sessionid = true && that.isSetSessionid();
    if (this_present_sessionid || that_present_sessionid) {
      if (!(this_present_sessionid && that_present_sessionid))
        return false;
      if (!this.sessionid.equals(that.sessionid))
        return false;
    }

    boolean this_present_topics = true && this.isSetTopics();
    boolean that_present_topics = true && that.isSetTopics();
    if (this_present_topics || that_present_topics) {
      if (!(this_present_topics && that_present_topics))
        return false;
      if (!this.topics.equals(that.topics))
        return false;
    }

    boolean this_present_tags = true && this.isSetTags();
    boolean that_present_tags = true && that.isSetTags();
    if (this_present_tags || that_present_tags) {
      if (!(this_present_tags && that_present_tags))
        return false;
      if (!this.tags.equals(that.tags))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_sessionid = true && (isSetSessionid());
    builder.append(present_sessionid);
    if (present_sessionid)
      builder.append(sessionid);

    boolean present_topics = true && (isSetTopics());
    builder.append(present_topics);
    if (present_topics)
      builder.append(topics);

    boolean present_tags = true && (isSetTags());
    builder.append(present_tags);
    if (present_tags)
      builder.append(tags);

    return builder.toHashCode();
  }

  public int compareTo(s_request other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    s_request typedOther = (s_request)other;

    lastComparison = Boolean.valueOf(isSetSessionid()).compareTo(typedOther.isSetSessionid());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSessionid()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.sessionid, typedOther.sessionid);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTopics()).compareTo(typedOther.isSetTopics());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTopics()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.topics, typedOther.topics);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTags()).compareTo(typedOther.isSetTags());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTags()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.tags, typedOther.tags);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    org.apache.thrift.protocol.TField field;
    iprot.readStructBegin();
    while (true)
    {
      field = iprot.readFieldBegin();
      if (field.type == org.apache.thrift.protocol.TType.STOP) { 
        break;
      }
      switch (field.id) {
        case 1: // SESSIONID
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.sessionid = iprot.readString();
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // TOPICS
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.topics = iprot.readString();
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 3: // TAGS
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.tags = iprot.readString();
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        default:
          org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
      }
      iprot.readFieldEnd();
    }
    iprot.readStructEnd();

    // check for required fields of primitive type, which can't be checked in the validate method
    validate();
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    validate();

    oprot.writeStructBegin(STRUCT_DESC);
    if (this.sessionid != null) {
      oprot.writeFieldBegin(SESSIONID_FIELD_DESC);
      oprot.writeString(this.sessionid);
      oprot.writeFieldEnd();
    }
    if (this.topics != null) {
      oprot.writeFieldBegin(TOPICS_FIELD_DESC);
      oprot.writeString(this.topics);
      oprot.writeFieldEnd();
    }
    if (this.tags != null) {
      oprot.writeFieldBegin(TAGS_FIELD_DESC);
      oprot.writeString(this.tags);
      oprot.writeFieldEnd();
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("s_request(");
    boolean first = true;

    sb.append("sessionid:");
    if (this.sessionid == null) {
      sb.append("null");
    } else {
      sb.append(this.sessionid);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("topics:");
    if (this.topics == null) {
      sb.append("null");
    } else {
      sb.append(this.topics);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("tags:");
    if (this.tags == null) {
      sb.append("null");
    } else {
      sb.append(this.tags);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (sessionid == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'sessionid' was not present! Struct: " + toString());
    }
    if (topics == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'topics' was not present! Struct: " + toString());
    }
    if (tags == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'tags' was not present! Struct: " + toString());
    }
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

}
