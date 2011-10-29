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

public class ChosenSingleChoiceOption implements org.apache.thrift.TBase<ChosenSingleChoiceOption, ChosenSingleChoiceOption._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ChosenSingleChoiceOption");

  private static final org.apache.thrift.protocol.TField SINGLE_CHOICE_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("singleChoiceId", org.apache.thrift.protocol.TType.I64, (short)1);
  private static final org.apache.thrift.protocol.TField CHOSEN_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("chosenId", org.apache.thrift.protocol.TType.I64, (short)2);

  public long singleChoiceId; // required
  public long chosenId; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    SINGLE_CHOICE_ID((short)1, "singleChoiceId"),
    CHOSEN_ID((short)2, "chosenId");

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
        case 1: // SINGLE_CHOICE_ID
          return SINGLE_CHOICE_ID;
        case 2: // CHOSEN_ID
          return CHOSEN_ID;
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
  private static final int __SINGLECHOICEID_ISSET_ID = 0;
  private static final int __CHOSENID_ISSET_ID = 1;
  private BitSet __isset_bit_vector = new BitSet(2);

  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.SINGLE_CHOICE_ID, new org.apache.thrift.meta_data.FieldMetaData("singleChoiceId", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64        , "Id")));
    tmpMap.put(_Fields.CHOSEN_ID, new org.apache.thrift.meta_data.FieldMetaData("chosenId", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64        , "Id")));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ChosenSingleChoiceOption.class, metaDataMap);
  }

  public ChosenSingleChoiceOption() {
  }

  public ChosenSingleChoiceOption(
    long singleChoiceId,
    long chosenId)
  {
    this();
    this.singleChoiceId = singleChoiceId;
    setSingleChoiceIdIsSet(true);
    this.chosenId = chosenId;
    setChosenIdIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ChosenSingleChoiceOption(ChosenSingleChoiceOption other) {
    __isset_bit_vector.clear();
    __isset_bit_vector.or(other.__isset_bit_vector);
    this.singleChoiceId = other.singleChoiceId;
    this.chosenId = other.chosenId;
  }

  public ChosenSingleChoiceOption deepCopy() {
    return new ChosenSingleChoiceOption(this);
  }

  @Override
  public void clear() {
    setSingleChoiceIdIsSet(false);
    this.singleChoiceId = 0;
    setChosenIdIsSet(false);
    this.chosenId = 0;
  }

  public long getSingleChoiceId() {
    return this.singleChoiceId;
  }

  public ChosenSingleChoiceOption setSingleChoiceId(long singleChoiceId) {
    this.singleChoiceId = singleChoiceId;
    setSingleChoiceIdIsSet(true);
    return this;
  }

  public void unsetSingleChoiceId() {
    __isset_bit_vector.clear(__SINGLECHOICEID_ISSET_ID);
  }

  /** Returns true if field singleChoiceId is set (has been assigned a value) and false otherwise */
  public boolean isSetSingleChoiceId() {
    return __isset_bit_vector.get(__SINGLECHOICEID_ISSET_ID);
  }

  public void setSingleChoiceIdIsSet(boolean value) {
    __isset_bit_vector.set(__SINGLECHOICEID_ISSET_ID, value);
  }

  public long getChosenId() {
    return this.chosenId;
  }

  public ChosenSingleChoiceOption setChosenId(long chosenId) {
    this.chosenId = chosenId;
    setChosenIdIsSet(true);
    return this;
  }

  public void unsetChosenId() {
    __isset_bit_vector.clear(__CHOSENID_ISSET_ID);
  }

  /** Returns true if field chosenId is set (has been assigned a value) and false otherwise */
  public boolean isSetChosenId() {
    return __isset_bit_vector.get(__CHOSENID_ISSET_ID);
  }

  public void setChosenIdIsSet(boolean value) {
    __isset_bit_vector.set(__CHOSENID_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case SINGLE_CHOICE_ID:
      if (value == null) {
        unsetSingleChoiceId();
      } else {
        setSingleChoiceId((Long)value);
      }
      break;

    case CHOSEN_ID:
      if (value == null) {
        unsetChosenId();
      } else {
        setChosenId((Long)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case SINGLE_CHOICE_ID:
      return Long.valueOf(getSingleChoiceId());

    case CHOSEN_ID:
      return Long.valueOf(getChosenId());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case SINGLE_CHOICE_ID:
      return isSetSingleChoiceId();
    case CHOSEN_ID:
      return isSetChosenId();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof ChosenSingleChoiceOption)
      return this.equals((ChosenSingleChoiceOption)that);
    return false;
  }

  public boolean equals(ChosenSingleChoiceOption that) {
    if (that == null)
      return false;

    boolean this_present_singleChoiceId = true;
    boolean that_present_singleChoiceId = true;
    if (this_present_singleChoiceId || that_present_singleChoiceId) {
      if (!(this_present_singleChoiceId && that_present_singleChoiceId))
        return false;
      if (this.singleChoiceId != that.singleChoiceId)
        return false;
    }

    boolean this_present_chosenId = true;
    boolean that_present_chosenId = true;
    if (this_present_chosenId || that_present_chosenId) {
      if (!(this_present_chosenId && that_present_chosenId))
        return false;
      if (this.chosenId != that.chosenId)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(ChosenSingleChoiceOption other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    ChosenSingleChoiceOption typedOther = (ChosenSingleChoiceOption)other;

    lastComparison = Boolean.valueOf(isSetSingleChoiceId()).compareTo(typedOther.isSetSingleChoiceId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSingleChoiceId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.singleChoiceId, typedOther.singleChoiceId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetChosenId()).compareTo(typedOther.isSetChosenId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetChosenId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.chosenId, typedOther.chosenId);
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
        case 1: // SINGLE_CHOICE_ID
          if (field.type == org.apache.thrift.protocol.TType.I64) {
            this.singleChoiceId = iprot.readI64();
            setSingleChoiceIdIsSet(true);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // CHOSEN_ID
          if (field.type == org.apache.thrift.protocol.TType.I64) {
            this.chosenId = iprot.readI64();
            setChosenIdIsSet(true);
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
    if (!isSetSingleChoiceId()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'singleChoiceId' was not found in serialized data! Struct: " + toString());
    }
    if (!isSetChosenId()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'chosenId' was not found in serialized data! Struct: " + toString());
    }
    validate();
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    validate();

    oprot.writeStructBegin(STRUCT_DESC);
    oprot.writeFieldBegin(SINGLE_CHOICE_ID_FIELD_DESC);
    oprot.writeI64(this.singleChoiceId);
    oprot.writeFieldEnd();
    oprot.writeFieldBegin(CHOSEN_ID_FIELD_DESC);
    oprot.writeI64(this.chosenId);
    oprot.writeFieldEnd();
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("ChosenSingleChoiceOption(");
    boolean first = true;

    sb.append("singleChoiceId:");
    sb.append(this.singleChoiceId);
    first = false;
    if (!first) sb.append(", ");
    sb.append("chosenId:");
    sb.append(this.chosenId);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // alas, we cannot check 'singleChoiceId' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'chosenId' because it's a primitive and you chose the non-beans generator.
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

