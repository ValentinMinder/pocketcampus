/**
 * Autogenerated by Thrift Compiler (0.7.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package org.pocketcampus.plugin.edx.shared;

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

public class EdxReq implements org.apache.thrift.TBase<EdxReq, EdxReq._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("EdxReq");

  private static final org.apache.thrift.protocol.TField SESSION_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("sessionId", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField COURSE_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("courseId", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField MODULE_URL_FIELD_DESC = new org.apache.thrift.protocol.TField("moduleUrl", org.apache.thrift.protocol.TType.STRING, (short)3);

  private String sessionId; // required
  private String courseId; // required
  private String moduleUrl; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    SESSION_ID((short)1, "sessionId"),
    COURSE_ID((short)2, "courseId"),
    MODULE_URL((short)3, "moduleUrl");

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
        case 1: // SESSION_ID
          return SESSION_ID;
        case 2: // COURSE_ID
          return COURSE_ID;
        case 3: // MODULE_URL
          return MODULE_URL;
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
    tmpMap.put(_Fields.SESSION_ID, new org.apache.thrift.meta_data.FieldMetaData("sessionId", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.COURSE_ID, new org.apache.thrift.meta_data.FieldMetaData("courseId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.MODULE_URL, new org.apache.thrift.meta_data.FieldMetaData("moduleUrl", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(EdxReq.class, metaDataMap);
  }

  public EdxReq() {
  }

  public EdxReq(
    String sessionId)
  {
    this();
    this.sessionId = sessionId;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public EdxReq(EdxReq other) {
    if (other.isSetSessionId()) {
      this.sessionId = other.sessionId;
    }
    if (other.isSetCourseId()) {
      this.courseId = other.courseId;
    }
    if (other.isSetModuleUrl()) {
      this.moduleUrl = other.moduleUrl;
    }
  }

  public EdxReq deepCopy() {
    return new EdxReq(this);
  }

  @Override
  public void clear() {
    this.sessionId = null;
    this.courseId = null;
    this.moduleUrl = null;
  }

  public String getSessionId() {
    return this.sessionId;
  }

  public EdxReq setSessionId(String sessionId) {
    this.sessionId = sessionId;
    return this;
  }

  public void unsetSessionId() {
    this.sessionId = null;
  }

  /** Returns true if field sessionId is set (has been assigned a value) and false otherwise */
  public boolean isSetSessionId() {
    return this.sessionId != null;
  }

  public void setSessionIdIsSet(boolean value) {
    if (!value) {
      this.sessionId = null;
    }
  }

  public String getCourseId() {
    return this.courseId;
  }

  public EdxReq setCourseId(String courseId) {
    this.courseId = courseId;
    return this;
  }

  public void unsetCourseId() {
    this.courseId = null;
  }

  /** Returns true if field courseId is set (has been assigned a value) and false otherwise */
  public boolean isSetCourseId() {
    return this.courseId != null;
  }

  public void setCourseIdIsSet(boolean value) {
    if (!value) {
      this.courseId = null;
    }
  }

  public String getModuleUrl() {
    return this.moduleUrl;
  }

  public EdxReq setModuleUrl(String moduleUrl) {
    this.moduleUrl = moduleUrl;
    return this;
  }

  public void unsetModuleUrl() {
    this.moduleUrl = null;
  }

  /** Returns true if field moduleUrl is set (has been assigned a value) and false otherwise */
  public boolean isSetModuleUrl() {
    return this.moduleUrl != null;
  }

  public void setModuleUrlIsSet(boolean value) {
    if (!value) {
      this.moduleUrl = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case SESSION_ID:
      if (value == null) {
        unsetSessionId();
      } else {
        setSessionId((String)value);
      }
      break;

    case COURSE_ID:
      if (value == null) {
        unsetCourseId();
      } else {
        setCourseId((String)value);
      }
      break;

    case MODULE_URL:
      if (value == null) {
        unsetModuleUrl();
      } else {
        setModuleUrl((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case SESSION_ID:
      return getSessionId();

    case COURSE_ID:
      return getCourseId();

    case MODULE_URL:
      return getModuleUrl();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case SESSION_ID:
      return isSetSessionId();
    case COURSE_ID:
      return isSetCourseId();
    case MODULE_URL:
      return isSetModuleUrl();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof EdxReq)
      return this.equals((EdxReq)that);
    return false;
  }

  public boolean equals(EdxReq that) {
    if (that == null)
      return false;

    boolean this_present_sessionId = true && this.isSetSessionId();
    boolean that_present_sessionId = true && that.isSetSessionId();
    if (this_present_sessionId || that_present_sessionId) {
      if (!(this_present_sessionId && that_present_sessionId))
        return false;
      if (!this.sessionId.equals(that.sessionId))
        return false;
    }

    boolean this_present_courseId = true && this.isSetCourseId();
    boolean that_present_courseId = true && that.isSetCourseId();
    if (this_present_courseId || that_present_courseId) {
      if (!(this_present_courseId && that_present_courseId))
        return false;
      if (!this.courseId.equals(that.courseId))
        return false;
    }

    boolean this_present_moduleUrl = true && this.isSetModuleUrl();
    boolean that_present_moduleUrl = true && that.isSetModuleUrl();
    if (this_present_moduleUrl || that_present_moduleUrl) {
      if (!(this_present_moduleUrl && that_present_moduleUrl))
        return false;
      if (!this.moduleUrl.equals(that.moduleUrl))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_sessionId = true && (isSetSessionId());
    builder.append(present_sessionId);
    if (present_sessionId)
      builder.append(sessionId);

    boolean present_courseId = true && (isSetCourseId());
    builder.append(present_courseId);
    if (present_courseId)
      builder.append(courseId);

    boolean present_moduleUrl = true && (isSetModuleUrl());
    builder.append(present_moduleUrl);
    if (present_moduleUrl)
      builder.append(moduleUrl);

    return builder.toHashCode();
  }

  public int compareTo(EdxReq other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    EdxReq typedOther = (EdxReq)other;

    lastComparison = Boolean.valueOf(isSetSessionId()).compareTo(typedOther.isSetSessionId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSessionId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.sessionId, typedOther.sessionId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetCourseId()).compareTo(typedOther.isSetCourseId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCourseId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.courseId, typedOther.courseId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetModuleUrl()).compareTo(typedOther.isSetModuleUrl());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetModuleUrl()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.moduleUrl, typedOther.moduleUrl);
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
        case 1: // SESSION_ID
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.sessionId = iprot.readString();
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // COURSE_ID
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.courseId = iprot.readString();
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 3: // MODULE_URL
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.moduleUrl = iprot.readString();
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
    if (this.sessionId != null) {
      oprot.writeFieldBegin(SESSION_ID_FIELD_DESC);
      oprot.writeString(this.sessionId);
      oprot.writeFieldEnd();
    }
    if (this.courseId != null) {
      if (isSetCourseId()) {
        oprot.writeFieldBegin(COURSE_ID_FIELD_DESC);
        oprot.writeString(this.courseId);
        oprot.writeFieldEnd();
      }
    }
    if (this.moduleUrl != null) {
      if (isSetModuleUrl()) {
        oprot.writeFieldBegin(MODULE_URL_FIELD_DESC);
        oprot.writeString(this.moduleUrl);
        oprot.writeFieldEnd();
      }
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("EdxReq(");
    boolean first = true;

    sb.append("sessionId:");
    if (this.sessionId == null) {
      sb.append("null");
    } else {
      sb.append(this.sessionId);
    }
    first = false;
    if (isSetCourseId()) {
      if (!first) sb.append(", ");
      sb.append("courseId:");
      if (this.courseId == null) {
        sb.append("null");
      } else {
        sb.append(this.courseId);
      }
      first = false;
    }
    if (isSetModuleUrl()) {
      if (!first) sb.append(", ");
      sb.append("moduleUrl:");
      if (this.moduleUrl == null) {
        sb.append("null");
      } else {
        sb.append(this.moduleUrl);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (sessionId == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'sessionId' was not present! Struct: " + toString());
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

