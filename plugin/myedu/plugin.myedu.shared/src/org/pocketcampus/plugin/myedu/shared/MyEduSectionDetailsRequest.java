/**
 * Autogenerated by Thrift Compiler (0.7.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package org.pocketcampus.plugin.myedu.shared;

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

public class MyEduSectionDetailsRequest implements org.apache.thrift.TBase<MyEduSectionDetailsRequest, MyEduSectionDetailsRequest._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("MyEduSectionDetailsRequest");

  private static final org.apache.thrift.protocol.TField I_MY_EDU_REQUEST_FIELD_DESC = new org.apache.thrift.protocol.TField("iMyEduRequest", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField I_COURSE_CODE_FIELD_DESC = new org.apache.thrift.protocol.TField("iCourseCode", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField I_SECTION_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("iSectionId", org.apache.thrift.protocol.TType.I32, (short)3);

  public MyEduRequest iMyEduRequest; // required
  public String iCourseCode; // required
  public int iSectionId; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    I_MY_EDU_REQUEST((short)1, "iMyEduRequest"),
    I_COURSE_CODE((short)2, "iCourseCode"),
    I_SECTION_ID((short)3, "iSectionId");

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
        case 1: // I_MY_EDU_REQUEST
          return I_MY_EDU_REQUEST;
        case 2: // I_COURSE_CODE
          return I_COURSE_CODE;
        case 3: // I_SECTION_ID
          return I_SECTION_ID;
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
  private static final int __ISECTIONID_ISSET_ID = 0;
  private BitSet __isset_bit_vector = new BitSet(1);

  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.I_MY_EDU_REQUEST, new org.apache.thrift.meta_data.FieldMetaData("iMyEduRequest", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, MyEduRequest.class)));
    tmpMap.put(_Fields.I_COURSE_CODE, new org.apache.thrift.meta_data.FieldMetaData("iCourseCode", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.I_SECTION_ID, new org.apache.thrift.meta_data.FieldMetaData("iSectionId", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(MyEduSectionDetailsRequest.class, metaDataMap);
  }

  public MyEduSectionDetailsRequest() {
  }

  public MyEduSectionDetailsRequest(
    MyEduRequest iMyEduRequest,
    String iCourseCode,
    int iSectionId)
  {
    this();
    this.iMyEduRequest = iMyEduRequest;
    this.iCourseCode = iCourseCode;
    this.iSectionId = iSectionId;
    setISectionIdIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public MyEduSectionDetailsRequest(MyEduSectionDetailsRequest other) {
    __isset_bit_vector.clear();
    __isset_bit_vector.or(other.__isset_bit_vector);
    if (other.isSetIMyEduRequest()) {
      this.iMyEduRequest = new MyEduRequest(other.iMyEduRequest);
    }
    if (other.isSetICourseCode()) {
      this.iCourseCode = other.iCourseCode;
    }
    this.iSectionId = other.iSectionId;
  }

  public MyEduSectionDetailsRequest deepCopy() {
    return new MyEduSectionDetailsRequest(this);
  }

  @Override
  public void clear() {
    this.iMyEduRequest = null;
    this.iCourseCode = null;
    setISectionIdIsSet(false);
    this.iSectionId = 0;
  }

  public MyEduRequest getIMyEduRequest() {
    return this.iMyEduRequest;
  }

  public MyEduSectionDetailsRequest setIMyEduRequest(MyEduRequest iMyEduRequest) {
    this.iMyEduRequest = iMyEduRequest;
    return this;
  }

  public void unsetIMyEduRequest() {
    this.iMyEduRequest = null;
  }

  /** Returns true if field iMyEduRequest is set (has been assigned a value) and false otherwise */
  public boolean isSetIMyEduRequest() {
    return this.iMyEduRequest != null;
  }

  public void setIMyEduRequestIsSet(boolean value) {
    if (!value) {
      this.iMyEduRequest = null;
    }
  }

  public String getICourseCode() {
    return this.iCourseCode;
  }

  public MyEduSectionDetailsRequest setICourseCode(String iCourseCode) {
    this.iCourseCode = iCourseCode;
    return this;
  }

  public void unsetICourseCode() {
    this.iCourseCode = null;
  }

  /** Returns true if field iCourseCode is set (has been assigned a value) and false otherwise */
  public boolean isSetICourseCode() {
    return this.iCourseCode != null;
  }

  public void setICourseCodeIsSet(boolean value) {
    if (!value) {
      this.iCourseCode = null;
    }
  }

  public int getISectionId() {
    return this.iSectionId;
  }

  public MyEduSectionDetailsRequest setISectionId(int iSectionId) {
    this.iSectionId = iSectionId;
    setISectionIdIsSet(true);
    return this;
  }

  public void unsetISectionId() {
    __isset_bit_vector.clear(__ISECTIONID_ISSET_ID);
  }

  /** Returns true if field iSectionId is set (has been assigned a value) and false otherwise */
  public boolean isSetISectionId() {
    return __isset_bit_vector.get(__ISECTIONID_ISSET_ID);
  }

  public void setISectionIdIsSet(boolean value) {
    __isset_bit_vector.set(__ISECTIONID_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case I_MY_EDU_REQUEST:
      if (value == null) {
        unsetIMyEduRequest();
      } else {
        setIMyEduRequest((MyEduRequest)value);
      }
      break;

    case I_COURSE_CODE:
      if (value == null) {
        unsetICourseCode();
      } else {
        setICourseCode((String)value);
      }
      break;

    case I_SECTION_ID:
      if (value == null) {
        unsetISectionId();
      } else {
        setISectionId((Integer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case I_MY_EDU_REQUEST:
      return getIMyEduRequest();

    case I_COURSE_CODE:
      return getICourseCode();

    case I_SECTION_ID:
      return Integer.valueOf(getISectionId());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case I_MY_EDU_REQUEST:
      return isSetIMyEduRequest();
    case I_COURSE_CODE:
      return isSetICourseCode();
    case I_SECTION_ID:
      return isSetISectionId();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof MyEduSectionDetailsRequest)
      return this.equals((MyEduSectionDetailsRequest)that);
    return false;
  }

  public boolean equals(MyEduSectionDetailsRequest that) {
    if (that == null)
      return false;

    boolean this_present_iMyEduRequest = true && this.isSetIMyEduRequest();
    boolean that_present_iMyEduRequest = true && that.isSetIMyEduRequest();
    if (this_present_iMyEduRequest || that_present_iMyEduRequest) {
      if (!(this_present_iMyEduRequest && that_present_iMyEduRequest))
        return false;
      if (!this.iMyEduRequest.equals(that.iMyEduRequest))
        return false;
    }

    boolean this_present_iCourseCode = true && this.isSetICourseCode();
    boolean that_present_iCourseCode = true && that.isSetICourseCode();
    if (this_present_iCourseCode || that_present_iCourseCode) {
      if (!(this_present_iCourseCode && that_present_iCourseCode))
        return false;
      if (!this.iCourseCode.equals(that.iCourseCode))
        return false;
    }

    boolean this_present_iSectionId = true;
    boolean that_present_iSectionId = true;
    if (this_present_iSectionId || that_present_iSectionId) {
      if (!(this_present_iSectionId && that_present_iSectionId))
        return false;
      if (this.iSectionId != that.iSectionId)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_iMyEduRequest = true && (isSetIMyEduRequest());
    builder.append(present_iMyEduRequest);
    if (present_iMyEduRequest)
      builder.append(iMyEduRequest);

    boolean present_iCourseCode = true && (isSetICourseCode());
    builder.append(present_iCourseCode);
    if (present_iCourseCode)
      builder.append(iCourseCode);

    boolean present_iSectionId = true;
    builder.append(present_iSectionId);
    if (present_iSectionId)
      builder.append(iSectionId);

    return builder.toHashCode();
  }

  public int compareTo(MyEduSectionDetailsRequest other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    MyEduSectionDetailsRequest typedOther = (MyEduSectionDetailsRequest)other;

    lastComparison = Boolean.valueOf(isSetIMyEduRequest()).compareTo(typedOther.isSetIMyEduRequest());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetIMyEduRequest()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.iMyEduRequest, typedOther.iMyEduRequest);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetICourseCode()).compareTo(typedOther.isSetICourseCode());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetICourseCode()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.iCourseCode, typedOther.iCourseCode);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetISectionId()).compareTo(typedOther.isSetISectionId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetISectionId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.iSectionId, typedOther.iSectionId);
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
        case 1: // I_MY_EDU_REQUEST
          if (field.type == org.apache.thrift.protocol.TType.STRUCT) {
            this.iMyEduRequest = new MyEduRequest();
            this.iMyEduRequest.read(iprot);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // I_COURSE_CODE
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.iCourseCode = iprot.readString();
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 3: // I_SECTION_ID
          if (field.type == org.apache.thrift.protocol.TType.I32) {
            this.iSectionId = iprot.readI32();
            setISectionIdIsSet(true);
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
    if (!isSetISectionId()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'iSectionId' was not found in serialized data! Struct: " + toString());
    }
    validate();
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    validate();

    oprot.writeStructBegin(STRUCT_DESC);
    if (this.iMyEduRequest != null) {
      oprot.writeFieldBegin(I_MY_EDU_REQUEST_FIELD_DESC);
      this.iMyEduRequest.write(oprot);
      oprot.writeFieldEnd();
    }
    if (this.iCourseCode != null) {
      oprot.writeFieldBegin(I_COURSE_CODE_FIELD_DESC);
      oprot.writeString(this.iCourseCode);
      oprot.writeFieldEnd();
    }
    oprot.writeFieldBegin(I_SECTION_ID_FIELD_DESC);
    oprot.writeI32(this.iSectionId);
    oprot.writeFieldEnd();
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("MyEduSectionDetailsRequest(");
    boolean first = true;

    sb.append("iMyEduRequest:");
    if (this.iMyEduRequest == null) {
      sb.append("null");
    } else {
      sb.append(this.iMyEduRequest);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("iCourseCode:");
    if (this.iCourseCode == null) {
      sb.append("null");
    } else {
      sb.append(this.iCourseCode);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("iSectionId:");
    sb.append(this.iSectionId);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (iMyEduRequest == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'iMyEduRequest' was not present! Struct: " + toString());
    }
    if (iCourseCode == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'iCourseCode' was not present! Struct: " + toString());
    }
    // alas, we cannot check 'iSectionId' because it's a primitive and you chose the non-beans generator.
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
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bit_vector = new BitSet(1);
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

}

