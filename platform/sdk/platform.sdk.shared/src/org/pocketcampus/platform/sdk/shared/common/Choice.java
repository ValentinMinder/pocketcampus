/**
 * Autogenerated by Thrift Compiler (0.7.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package org.pocketcampus.platform.sdk.shared.common;

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

public class Choice implements org.apache.thrift.TBase<Choice, Choice._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Choice");

  private static final org.apache.thrift.protocol.TField CHOICE_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("choiceId", org.apache.thrift.protocol.TType.I64, (short)1);
  private static final org.apache.thrift.protocol.TField CHOICE_VALUE_FIELD_DESC = new org.apache.thrift.protocol.TField("choiceValue", org.apache.thrift.protocol.TType.STRING, (short)2);

  public long choiceId; // required
  public String choiceValue; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    CHOICE_ID((short)1, "choiceId"),
    CHOICE_VALUE((short)2, "choiceValue");

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
        case 1: // CHOICE_ID
          return CHOICE_ID;
        case 2: // CHOICE_VALUE
          return CHOICE_VALUE;
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
  private static final int __CHOICEID_ISSET_ID = 0;
  private BitSet __isset_bit_vector = new BitSet(1);

  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.CHOICE_ID, new org.apache.thrift.meta_data.FieldMetaData("choiceId", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64        , "Id")));
    tmpMap.put(_Fields.CHOICE_VALUE, new org.apache.thrift.meta_data.FieldMetaData("choiceValue", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Choice.class, metaDataMap);
  }

  public Choice() {
  }

  public Choice(
    long choiceId,
    String choiceValue)
  {
    this();
    this.choiceId = choiceId;
    setChoiceIdIsSet(true);
    this.choiceValue = choiceValue;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Choice(Choice other) {
    __isset_bit_vector.clear();
    __isset_bit_vector.or(other.__isset_bit_vector);
    this.choiceId = other.choiceId;
    if (other.isSetChoiceValue()) {
      this.choiceValue = other.choiceValue;
    }
  }

  public Choice deepCopy() {
    return new Choice(this);
  }

  @Override
  public void clear() {
    setChoiceIdIsSet(false);
    this.choiceId = 0;
    this.choiceValue = null;
  }

  public long getChoiceId() {
    return this.choiceId;
  }

  public Choice setChoiceId(long choiceId) {
    this.choiceId = choiceId;
    setChoiceIdIsSet(true);
    return this;
  }

  public void unsetChoiceId() {
    __isset_bit_vector.clear(__CHOICEID_ISSET_ID);
  }

  /** Returns true if field choiceId is set (has been assigned a value) and false otherwise */
  public boolean isSetChoiceId() {
    return __isset_bit_vector.get(__CHOICEID_ISSET_ID);
  }

  public void setChoiceIdIsSet(boolean value) {
    __isset_bit_vector.set(__CHOICEID_ISSET_ID, value);
  }

  public String getChoiceValue() {
    return this.choiceValue;
  }

  public Choice setChoiceValue(String choiceValue) {
    this.choiceValue = choiceValue;
    return this;
  }

  public void unsetChoiceValue() {
    this.choiceValue = null;
  }

  /** Returns true if field choiceValue is set (has been assigned a value) and false otherwise */
  public boolean isSetChoiceValue() {
    return this.choiceValue != null;
  }

  public void setChoiceValueIsSet(boolean value) {
    if (!value) {
      this.choiceValue = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case CHOICE_ID:
      if (value == null) {
        unsetChoiceId();
      } else {
        setChoiceId((Long)value);
      }
      break;

    case CHOICE_VALUE:
      if (value == null) {
        unsetChoiceValue();
      } else {
        setChoiceValue((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case CHOICE_ID:
      return Long.valueOf(getChoiceId());

    case CHOICE_VALUE:
      return getChoiceValue();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case CHOICE_ID:
      return isSetChoiceId();
    case CHOICE_VALUE:
      return isSetChoiceValue();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Choice)
      return this.equals((Choice)that);
    return false;
  }

  public boolean equals(Choice that) {
    if (that == null)
      return false;

    boolean this_present_choiceId = true;
    boolean that_present_choiceId = true;
    if (this_present_choiceId || that_present_choiceId) {
      if (!(this_present_choiceId && that_present_choiceId))
        return false;
      if (this.choiceId != that.choiceId)
        return false;
    }

    boolean this_present_choiceValue = true && this.isSetChoiceValue();
    boolean that_present_choiceValue = true && that.isSetChoiceValue();
    if (this_present_choiceValue || that_present_choiceValue) {
      if (!(this_present_choiceValue && that_present_choiceValue))
        return false;
      if (!this.choiceValue.equals(that.choiceValue))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(Choice other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    Choice typedOther = (Choice)other;

    lastComparison = Boolean.valueOf(isSetChoiceId()).compareTo(typedOther.isSetChoiceId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetChoiceId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.choiceId, typedOther.choiceId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetChoiceValue()).compareTo(typedOther.isSetChoiceValue());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetChoiceValue()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.choiceValue, typedOther.choiceValue);
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
        case 1: // CHOICE_ID
          if (field.type == org.apache.thrift.protocol.TType.I64) {
            this.choiceId = iprot.readI64();
            setChoiceIdIsSet(true);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // CHOICE_VALUE
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.choiceValue = iprot.readString();
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
    if (!isSetChoiceId()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'choiceId' was not found in serialized data! Struct: " + toString());
    }
    validate();
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    validate();

    oprot.writeStructBegin(STRUCT_DESC);
    oprot.writeFieldBegin(CHOICE_ID_FIELD_DESC);
    oprot.writeI64(this.choiceId);
    oprot.writeFieldEnd();
    if (this.choiceValue != null) {
      oprot.writeFieldBegin(CHOICE_VALUE_FIELD_DESC);
      oprot.writeString(this.choiceValue);
      oprot.writeFieldEnd();
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Choice(");
    boolean first = true;

    sb.append("choiceId:");
    sb.append(this.choiceId);
    first = false;
    if (!first) sb.append(", ");
    sb.append("choiceValue:");
    if (this.choiceValue == null) {
      sb.append("null");
    } else {
      sb.append(this.choiceValue);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // alas, we cannot check 'choiceId' because it's a primitive and you chose the non-beans generator.
    if (choiceValue == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'choiceValue' was not present! Struct: " + toString());
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
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bit_vector = new BitSet(1);
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

}

