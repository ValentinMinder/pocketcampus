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

public class MyEduCourse implements org.apache.thrift.TBase<MyEduCourse, MyEduCourse._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("MyEduCourse");

  private static final org.apache.thrift.protocol.TField I_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("iId", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField I_CODE_FIELD_DESC = new org.apache.thrift.protocol.TField("iCode", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField I_TITLE_FIELD_DESC = new org.apache.thrift.protocol.TField("iTitle", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField I_DESCRIPTION_FIELD_DESC = new org.apache.thrift.protocol.TField("iDescription", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField I_CREATION_TIMESTAMP_FIELD_DESC = new org.apache.thrift.protocol.TField("iCreationTimestamp", org.apache.thrift.protocol.TType.I64, (short)5);
  private static final org.apache.thrift.protocol.TField I_LAST_UPDATE_TIMESTAMP_FIELD_DESC = new org.apache.thrift.protocol.TField("iLastUpdateTimestamp", org.apache.thrift.protocol.TType.I64, (short)6);

  public int iId; // required
  public String iCode; // required
  public String iTitle; // required
  public String iDescription; // required
  public long iCreationTimestamp; // required
  public long iLastUpdateTimestamp; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    I_ID((short)1, "iId"),
    I_CODE((short)2, "iCode"),
    I_TITLE((short)3, "iTitle"),
    I_DESCRIPTION((short)4, "iDescription"),
    I_CREATION_TIMESTAMP((short)5, "iCreationTimestamp"),
    I_LAST_UPDATE_TIMESTAMP((short)6, "iLastUpdateTimestamp");

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
        case 1: // I_ID
          return I_ID;
        case 2: // I_CODE
          return I_CODE;
        case 3: // I_TITLE
          return I_TITLE;
        case 4: // I_DESCRIPTION
          return I_DESCRIPTION;
        case 5: // I_CREATION_TIMESTAMP
          return I_CREATION_TIMESTAMP;
        case 6: // I_LAST_UPDATE_TIMESTAMP
          return I_LAST_UPDATE_TIMESTAMP;
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
  private static final int __IID_ISSET_ID = 0;
  private static final int __ICREATIONTIMESTAMP_ISSET_ID = 1;
  private static final int __ILASTUPDATETIMESTAMP_ISSET_ID = 2;
  private BitSet __isset_bit_vector = new BitSet(3);

  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.I_ID, new org.apache.thrift.meta_data.FieldMetaData("iId", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.I_CODE, new org.apache.thrift.meta_data.FieldMetaData("iCode", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.I_TITLE, new org.apache.thrift.meta_data.FieldMetaData("iTitle", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.I_DESCRIPTION, new org.apache.thrift.meta_data.FieldMetaData("iDescription", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.I_CREATION_TIMESTAMP, new org.apache.thrift.meta_data.FieldMetaData("iCreationTimestamp", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64        , "timestamp")));
    tmpMap.put(_Fields.I_LAST_UPDATE_TIMESTAMP, new org.apache.thrift.meta_data.FieldMetaData("iLastUpdateTimestamp", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64        , "timestamp")));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(MyEduCourse.class, metaDataMap);
  }

  public MyEduCourse() {
  }

  public MyEduCourse(
    int iId,
    String iCode,
    String iTitle,
    long iCreationTimestamp,
    long iLastUpdateTimestamp)
  {
    this();
    this.iId = iId;
    setIIdIsSet(true);
    this.iCode = iCode;
    this.iTitle = iTitle;
    this.iCreationTimestamp = iCreationTimestamp;
    setICreationTimestampIsSet(true);
    this.iLastUpdateTimestamp = iLastUpdateTimestamp;
    setILastUpdateTimestampIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public MyEduCourse(MyEduCourse other) {
    __isset_bit_vector.clear();
    __isset_bit_vector.or(other.__isset_bit_vector);
    this.iId = other.iId;
    if (other.isSetICode()) {
      this.iCode = other.iCode;
    }
    if (other.isSetITitle()) {
      this.iTitle = other.iTitle;
    }
    if (other.isSetIDescription()) {
      this.iDescription = other.iDescription;
    }
    this.iCreationTimestamp = other.iCreationTimestamp;
    this.iLastUpdateTimestamp = other.iLastUpdateTimestamp;
  }

  public MyEduCourse deepCopy() {
    return new MyEduCourse(this);
  }

  @Override
  public void clear() {
    setIIdIsSet(false);
    this.iId = 0;
    this.iCode = null;
    this.iTitle = null;
    this.iDescription = null;
    setICreationTimestampIsSet(false);
    this.iCreationTimestamp = 0;
    setILastUpdateTimestampIsSet(false);
    this.iLastUpdateTimestamp = 0;
  }

  public int getIId() {
    return this.iId;
  }

  public MyEduCourse setIId(int iId) {
    this.iId = iId;
    setIIdIsSet(true);
    return this;
  }

  public void unsetIId() {
    __isset_bit_vector.clear(__IID_ISSET_ID);
  }

  /** Returns true if field iId is set (has been assigned a value) and false otherwise */
  public boolean isSetIId() {
    return __isset_bit_vector.get(__IID_ISSET_ID);
  }

  public void setIIdIsSet(boolean value) {
    __isset_bit_vector.set(__IID_ISSET_ID, value);
  }

  public String getICode() {
    return this.iCode;
  }

  public MyEduCourse setICode(String iCode) {
    this.iCode = iCode;
    return this;
  }

  public void unsetICode() {
    this.iCode = null;
  }

  /** Returns true if field iCode is set (has been assigned a value) and false otherwise */
  public boolean isSetICode() {
    return this.iCode != null;
  }

  public void setICodeIsSet(boolean value) {
    if (!value) {
      this.iCode = null;
    }
  }

  public String getITitle() {
    return this.iTitle;
  }

  public MyEduCourse setITitle(String iTitle) {
    this.iTitle = iTitle;
    return this;
  }

  public void unsetITitle() {
    this.iTitle = null;
  }

  /** Returns true if field iTitle is set (has been assigned a value) and false otherwise */
  public boolean isSetITitle() {
    return this.iTitle != null;
  }

  public void setITitleIsSet(boolean value) {
    if (!value) {
      this.iTitle = null;
    }
  }

  public String getIDescription() {
    return this.iDescription;
  }

  public MyEduCourse setIDescription(String iDescription) {
    this.iDescription = iDescription;
    return this;
  }

  public void unsetIDescription() {
    this.iDescription = null;
  }

  /** Returns true if field iDescription is set (has been assigned a value) and false otherwise */
  public boolean isSetIDescription() {
    return this.iDescription != null;
  }

  public void setIDescriptionIsSet(boolean value) {
    if (!value) {
      this.iDescription = null;
    }
  }

  public long getICreationTimestamp() {
    return this.iCreationTimestamp;
  }

  public MyEduCourse setICreationTimestamp(long iCreationTimestamp) {
    this.iCreationTimestamp = iCreationTimestamp;
    setICreationTimestampIsSet(true);
    return this;
  }

  public void unsetICreationTimestamp() {
    __isset_bit_vector.clear(__ICREATIONTIMESTAMP_ISSET_ID);
  }

  /** Returns true if field iCreationTimestamp is set (has been assigned a value) and false otherwise */
  public boolean isSetICreationTimestamp() {
    return __isset_bit_vector.get(__ICREATIONTIMESTAMP_ISSET_ID);
  }

  public void setICreationTimestampIsSet(boolean value) {
    __isset_bit_vector.set(__ICREATIONTIMESTAMP_ISSET_ID, value);
  }

  public long getILastUpdateTimestamp() {
    return this.iLastUpdateTimestamp;
  }

  public MyEduCourse setILastUpdateTimestamp(long iLastUpdateTimestamp) {
    this.iLastUpdateTimestamp = iLastUpdateTimestamp;
    setILastUpdateTimestampIsSet(true);
    return this;
  }

  public void unsetILastUpdateTimestamp() {
    __isset_bit_vector.clear(__ILASTUPDATETIMESTAMP_ISSET_ID);
  }

  /** Returns true if field iLastUpdateTimestamp is set (has been assigned a value) and false otherwise */
  public boolean isSetILastUpdateTimestamp() {
    return __isset_bit_vector.get(__ILASTUPDATETIMESTAMP_ISSET_ID);
  }

  public void setILastUpdateTimestampIsSet(boolean value) {
    __isset_bit_vector.set(__ILASTUPDATETIMESTAMP_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case I_ID:
      if (value == null) {
        unsetIId();
      } else {
        setIId((Integer)value);
      }
      break;

    case I_CODE:
      if (value == null) {
        unsetICode();
      } else {
        setICode((String)value);
      }
      break;

    case I_TITLE:
      if (value == null) {
        unsetITitle();
      } else {
        setITitle((String)value);
      }
      break;

    case I_DESCRIPTION:
      if (value == null) {
        unsetIDescription();
      } else {
        setIDescription((String)value);
      }
      break;

    case I_CREATION_TIMESTAMP:
      if (value == null) {
        unsetICreationTimestamp();
      } else {
        setICreationTimestamp((Long)value);
      }
      break;

    case I_LAST_UPDATE_TIMESTAMP:
      if (value == null) {
        unsetILastUpdateTimestamp();
      } else {
        setILastUpdateTimestamp((Long)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case I_ID:
      return Integer.valueOf(getIId());

    case I_CODE:
      return getICode();

    case I_TITLE:
      return getITitle();

    case I_DESCRIPTION:
      return getIDescription();

    case I_CREATION_TIMESTAMP:
      return Long.valueOf(getICreationTimestamp());

    case I_LAST_UPDATE_TIMESTAMP:
      return Long.valueOf(getILastUpdateTimestamp());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case I_ID:
      return isSetIId();
    case I_CODE:
      return isSetICode();
    case I_TITLE:
      return isSetITitle();
    case I_DESCRIPTION:
      return isSetIDescription();
    case I_CREATION_TIMESTAMP:
      return isSetICreationTimestamp();
    case I_LAST_UPDATE_TIMESTAMP:
      return isSetILastUpdateTimestamp();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof MyEduCourse)
      return this.equals((MyEduCourse)that);
    return false;
  }

  public boolean equals(MyEduCourse that) {
    if (that == null)
      return false;

    boolean this_present_iId = true;
    boolean that_present_iId = true;
    if (this_present_iId || that_present_iId) {
      if (!(this_present_iId && that_present_iId))
        return false;
      if (this.iId != that.iId)
        return false;
    }

    boolean this_present_iCode = true && this.isSetICode();
    boolean that_present_iCode = true && that.isSetICode();
    if (this_present_iCode || that_present_iCode) {
      if (!(this_present_iCode && that_present_iCode))
        return false;
      if (!this.iCode.equals(that.iCode))
        return false;
    }

    boolean this_present_iTitle = true && this.isSetITitle();
    boolean that_present_iTitle = true && that.isSetITitle();
    if (this_present_iTitle || that_present_iTitle) {
      if (!(this_present_iTitle && that_present_iTitle))
        return false;
      if (!this.iTitle.equals(that.iTitle))
        return false;
    }

    boolean this_present_iDescription = true && this.isSetIDescription();
    boolean that_present_iDescription = true && that.isSetIDescription();
    if (this_present_iDescription || that_present_iDescription) {
      if (!(this_present_iDescription && that_present_iDescription))
        return false;
      if (!this.iDescription.equals(that.iDescription))
        return false;
    }

    boolean this_present_iCreationTimestamp = true;
    boolean that_present_iCreationTimestamp = true;
    if (this_present_iCreationTimestamp || that_present_iCreationTimestamp) {
      if (!(this_present_iCreationTimestamp && that_present_iCreationTimestamp))
        return false;
      if (this.iCreationTimestamp != that.iCreationTimestamp)
        return false;
    }

    boolean this_present_iLastUpdateTimestamp = true;
    boolean that_present_iLastUpdateTimestamp = true;
    if (this_present_iLastUpdateTimestamp || that_present_iLastUpdateTimestamp) {
      if (!(this_present_iLastUpdateTimestamp && that_present_iLastUpdateTimestamp))
        return false;
      if (this.iLastUpdateTimestamp != that.iLastUpdateTimestamp)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_iId = true;
    builder.append(present_iId);
    if (present_iId)
      builder.append(iId);

    boolean present_iCode = true && (isSetICode());
    builder.append(present_iCode);
    if (present_iCode)
      builder.append(iCode);

    boolean present_iTitle = true && (isSetITitle());
    builder.append(present_iTitle);
    if (present_iTitle)
      builder.append(iTitle);

    boolean present_iDescription = true && (isSetIDescription());
    builder.append(present_iDescription);
    if (present_iDescription)
      builder.append(iDescription);

    boolean present_iCreationTimestamp = true;
    builder.append(present_iCreationTimestamp);
    if (present_iCreationTimestamp)
      builder.append(iCreationTimestamp);

    boolean present_iLastUpdateTimestamp = true;
    builder.append(present_iLastUpdateTimestamp);
    if (present_iLastUpdateTimestamp)
      builder.append(iLastUpdateTimestamp);

    return builder.toHashCode();
  }

  public int compareTo(MyEduCourse other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    MyEduCourse typedOther = (MyEduCourse)other;

    lastComparison = Boolean.valueOf(isSetIId()).compareTo(typedOther.isSetIId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetIId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.iId, typedOther.iId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetICode()).compareTo(typedOther.isSetICode());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetICode()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.iCode, typedOther.iCode);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetITitle()).compareTo(typedOther.isSetITitle());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetITitle()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.iTitle, typedOther.iTitle);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetIDescription()).compareTo(typedOther.isSetIDescription());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetIDescription()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.iDescription, typedOther.iDescription);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetICreationTimestamp()).compareTo(typedOther.isSetICreationTimestamp());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetICreationTimestamp()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.iCreationTimestamp, typedOther.iCreationTimestamp);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetILastUpdateTimestamp()).compareTo(typedOther.isSetILastUpdateTimestamp());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetILastUpdateTimestamp()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.iLastUpdateTimestamp, typedOther.iLastUpdateTimestamp);
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
        case 1: // I_ID
          if (field.type == org.apache.thrift.protocol.TType.I32) {
            this.iId = iprot.readI32();
            setIIdIsSet(true);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // I_CODE
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.iCode = iprot.readString();
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 3: // I_TITLE
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.iTitle = iprot.readString();
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 4: // I_DESCRIPTION
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.iDescription = iprot.readString();
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 5: // I_CREATION_TIMESTAMP
          if (field.type == org.apache.thrift.protocol.TType.I64) {
            this.iCreationTimestamp = iprot.readI64();
            setICreationTimestampIsSet(true);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 6: // I_LAST_UPDATE_TIMESTAMP
          if (field.type == org.apache.thrift.protocol.TType.I64) {
            this.iLastUpdateTimestamp = iprot.readI64();
            setILastUpdateTimestampIsSet(true);
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
    if (!isSetIId()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'iId' was not found in serialized data! Struct: " + toString());
    }
    if (!isSetICreationTimestamp()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'iCreationTimestamp' was not found in serialized data! Struct: " + toString());
    }
    if (!isSetILastUpdateTimestamp()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'iLastUpdateTimestamp' was not found in serialized data! Struct: " + toString());
    }
    validate();
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    validate();

    oprot.writeStructBegin(STRUCT_DESC);
    oprot.writeFieldBegin(I_ID_FIELD_DESC);
    oprot.writeI32(this.iId);
    oprot.writeFieldEnd();
    if (this.iCode != null) {
      oprot.writeFieldBegin(I_CODE_FIELD_DESC);
      oprot.writeString(this.iCode);
      oprot.writeFieldEnd();
    }
    if (this.iTitle != null) {
      oprot.writeFieldBegin(I_TITLE_FIELD_DESC);
      oprot.writeString(this.iTitle);
      oprot.writeFieldEnd();
    }
    if (this.iDescription != null) {
      if (isSetIDescription()) {
        oprot.writeFieldBegin(I_DESCRIPTION_FIELD_DESC);
        oprot.writeString(this.iDescription);
        oprot.writeFieldEnd();
      }
    }
    oprot.writeFieldBegin(I_CREATION_TIMESTAMP_FIELD_DESC);
    oprot.writeI64(this.iCreationTimestamp);
    oprot.writeFieldEnd();
    oprot.writeFieldBegin(I_LAST_UPDATE_TIMESTAMP_FIELD_DESC);
    oprot.writeI64(this.iLastUpdateTimestamp);
    oprot.writeFieldEnd();
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("MyEduCourse(");
    boolean first = true;

    sb.append("iId:");
    sb.append(this.iId);
    first = false;
    if (!first) sb.append(", ");
    sb.append("iCode:");
    if (this.iCode == null) {
      sb.append("null");
    } else {
      sb.append(this.iCode);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("iTitle:");
    if (this.iTitle == null) {
      sb.append("null");
    } else {
      sb.append(this.iTitle);
    }
    first = false;
    if (isSetIDescription()) {
      if (!first) sb.append(", ");
      sb.append("iDescription:");
      if (this.iDescription == null) {
        sb.append("null");
      } else {
        sb.append(this.iDescription);
      }
      first = false;
    }
    if (!first) sb.append(", ");
    sb.append("iCreationTimestamp:");
    sb.append(this.iCreationTimestamp);
    first = false;
    if (!first) sb.append(", ");
    sb.append("iLastUpdateTimestamp:");
    sb.append(this.iLastUpdateTimestamp);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // alas, we cannot check 'iId' because it's a primitive and you chose the non-beans generator.
    if (iCode == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'iCode' was not present! Struct: " + toString());
    }
    if (iTitle == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'iTitle' was not present! Struct: " + toString());
    }
    // alas, we cannot check 'iCreationTimestamp' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'iLastUpdateTimestamp' because it's a primitive and you chose the non-beans generator.
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

