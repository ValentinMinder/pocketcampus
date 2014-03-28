/**
 * Autogenerated by Thrift Compiler (0.7.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package org.pocketcampus.plugin.freeroom.shared;

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

public class ActualOccupation implements org.apache.thrift.TBase<ActualOccupation, ActualOccupation._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ActualOccupation");

  private static final org.apache.thrift.protocol.TField PERIOD_FIELD_DESC = new org.apache.thrift.protocol.TField("period", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField AVAILABLE_FIELD_DESC = new org.apache.thrift.protocol.TField("available", org.apache.thrift.protocol.TType.BOOL, (short)2);
  private static final org.apache.thrift.protocol.TField OCCUPATION_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("occupationType", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField PROBABLE_OCCUPATION_FIELD_DESC = new org.apache.thrift.protocol.TField("probableOccupation", org.apache.thrift.protocol.TType.I32, (short)4);

  private FRPeriod period; // required
  private boolean available; // required
  private OccupationType occupationType; // required
  private int probableOccupation; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    PERIOD((short)1, "period"),
    AVAILABLE((short)2, "available"),
    /**
     * 
     * @see OccupationType
     */
    OCCUPATION_TYPE((short)3, "occupationType"),
    PROBABLE_OCCUPATION((short)4, "probableOccupation");

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
        case 1: // PERIOD
          return PERIOD;
        case 2: // AVAILABLE
          return AVAILABLE;
        case 3: // OCCUPATION_TYPE
          return OCCUPATION_TYPE;
        case 4: // PROBABLE_OCCUPATION
          return PROBABLE_OCCUPATION;
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
  private static final int __AVAILABLE_ISSET_ID = 0;
  private static final int __PROBABLEOCCUPATION_ISSET_ID = 1;
  private BitSet __isset_bit_vector = new BitSet(2);

  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.PERIOD, new org.apache.thrift.meta_data.FieldMetaData("period", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, FRPeriod.class)));
    tmpMap.put(_Fields.AVAILABLE, new org.apache.thrift.meta_data.FieldMetaData("available", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    tmpMap.put(_Fields.OCCUPATION_TYPE, new org.apache.thrift.meta_data.FieldMetaData("occupationType", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, OccupationType.class)));
    tmpMap.put(_Fields.PROBABLE_OCCUPATION, new org.apache.thrift.meta_data.FieldMetaData("probableOccupation", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ActualOccupation.class, metaDataMap);
  }

  public ActualOccupation() {
  }

  public ActualOccupation(
    FRPeriod period,
    boolean available,
    OccupationType occupationType)
  {
    this();
    this.period = period;
    this.available = available;
    setAvailableIsSet(true);
    this.occupationType = occupationType;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ActualOccupation(ActualOccupation other) {
    __isset_bit_vector.clear();
    __isset_bit_vector.or(other.__isset_bit_vector);
    if (other.isSetPeriod()) {
      this.period = new FRPeriod(other.period);
    }
    this.available = other.available;
    if (other.isSetOccupationType()) {
      this.occupationType = other.occupationType;
    }
    this.probableOccupation = other.probableOccupation;
  }

  public ActualOccupation deepCopy() {
    return new ActualOccupation(this);
  }

  @Override
  public void clear() {
    this.period = null;
    setAvailableIsSet(false);
    this.available = false;
    this.occupationType = null;
    setProbableOccupationIsSet(false);
    this.probableOccupation = 0;
  }

  public FRPeriod getPeriod() {
    return this.period;
  }

  public ActualOccupation setPeriod(FRPeriod period) {
    this.period = period;
    return this;
  }

  public void unsetPeriod() {
    this.period = null;
  }

  /** Returns true if field period is set (has been assigned a value) and false otherwise */
  public boolean isSetPeriod() {
    return this.period != null;
  }

  public void setPeriodIsSet(boolean value) {
    if (!value) {
      this.period = null;
    }
  }

  public boolean isAvailable() {
    return this.available;
  }

  public ActualOccupation setAvailable(boolean available) {
    this.available = available;
    setAvailableIsSet(true);
    return this;
  }

  public void unsetAvailable() {
    __isset_bit_vector.clear(__AVAILABLE_ISSET_ID);
  }

  /** Returns true if field available is set (has been assigned a value) and false otherwise */
  public boolean isSetAvailable() {
    return __isset_bit_vector.get(__AVAILABLE_ISSET_ID);
  }

  public void setAvailableIsSet(boolean value) {
    __isset_bit_vector.set(__AVAILABLE_ISSET_ID, value);
  }

  /**
   * 
   * @see OccupationType
   */
  public OccupationType getOccupationType() {
    return this.occupationType;
  }

  /**
   * 
   * @see OccupationType
   */
  public ActualOccupation setOccupationType(OccupationType occupationType) {
    this.occupationType = occupationType;
    return this;
  }

  public void unsetOccupationType() {
    this.occupationType = null;
  }

  /** Returns true if field occupationType is set (has been assigned a value) and false otherwise */
  public boolean isSetOccupationType() {
    return this.occupationType != null;
  }

  public void setOccupationTypeIsSet(boolean value) {
    if (!value) {
      this.occupationType = null;
    }
  }

  public int getProbableOccupation() {
    return this.probableOccupation;
  }

  public ActualOccupation setProbableOccupation(int probableOccupation) {
    this.probableOccupation = probableOccupation;
    setProbableOccupationIsSet(true);
    return this;
  }

  public void unsetProbableOccupation() {
    __isset_bit_vector.clear(__PROBABLEOCCUPATION_ISSET_ID);
  }

  /** Returns true if field probableOccupation is set (has been assigned a value) and false otherwise */
  public boolean isSetProbableOccupation() {
    return __isset_bit_vector.get(__PROBABLEOCCUPATION_ISSET_ID);
  }

  public void setProbableOccupationIsSet(boolean value) {
    __isset_bit_vector.set(__PROBABLEOCCUPATION_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case PERIOD:
      if (value == null) {
        unsetPeriod();
      } else {
        setPeriod((FRPeriod)value);
      }
      break;

    case AVAILABLE:
      if (value == null) {
        unsetAvailable();
      } else {
        setAvailable((Boolean)value);
      }
      break;

    case OCCUPATION_TYPE:
      if (value == null) {
        unsetOccupationType();
      } else {
        setOccupationType((OccupationType)value);
      }
      break;

    case PROBABLE_OCCUPATION:
      if (value == null) {
        unsetProbableOccupation();
      } else {
        setProbableOccupation((Integer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case PERIOD:
      return getPeriod();

    case AVAILABLE:
      return Boolean.valueOf(isAvailable());

    case OCCUPATION_TYPE:
      return getOccupationType();

    case PROBABLE_OCCUPATION:
      return Integer.valueOf(getProbableOccupation());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case PERIOD:
      return isSetPeriod();
    case AVAILABLE:
      return isSetAvailable();
    case OCCUPATION_TYPE:
      return isSetOccupationType();
    case PROBABLE_OCCUPATION:
      return isSetProbableOccupation();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof ActualOccupation)
      return this.equals((ActualOccupation)that);
    return false;
  }

  public boolean equals(ActualOccupation that) {
    if (that == null)
      return false;

    boolean this_present_period = true && this.isSetPeriod();
    boolean that_present_period = true && that.isSetPeriod();
    if (this_present_period || that_present_period) {
      if (!(this_present_period && that_present_period))
        return false;
      if (!this.period.equals(that.period))
        return false;
    }

    boolean this_present_available = true;
    boolean that_present_available = true;
    if (this_present_available || that_present_available) {
      if (!(this_present_available && that_present_available))
        return false;
      if (this.available != that.available)
        return false;
    }

    boolean this_present_occupationType = true && this.isSetOccupationType();
    boolean that_present_occupationType = true && that.isSetOccupationType();
    if (this_present_occupationType || that_present_occupationType) {
      if (!(this_present_occupationType && that_present_occupationType))
        return false;
      if (!this.occupationType.equals(that.occupationType))
        return false;
    }

    boolean this_present_probableOccupation = true && this.isSetProbableOccupation();
    boolean that_present_probableOccupation = true && that.isSetProbableOccupation();
    if (this_present_probableOccupation || that_present_probableOccupation) {
      if (!(this_present_probableOccupation && that_present_probableOccupation))
        return false;
      if (this.probableOccupation != that.probableOccupation)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_period = true && (isSetPeriod());
    builder.append(present_period);
    if (present_period)
      builder.append(period);

    boolean present_available = true;
    builder.append(present_available);
    if (present_available)
      builder.append(available);

    boolean present_occupationType = true && (isSetOccupationType());
    builder.append(present_occupationType);
    if (present_occupationType)
      builder.append(occupationType.getValue());

    boolean present_probableOccupation = true && (isSetProbableOccupation());
    builder.append(present_probableOccupation);
    if (present_probableOccupation)
      builder.append(probableOccupation);

    return builder.toHashCode();
  }

  public int compareTo(ActualOccupation other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    ActualOccupation typedOther = (ActualOccupation)other;

    lastComparison = Boolean.valueOf(isSetPeriod()).compareTo(typedOther.isSetPeriod());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPeriod()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.period, typedOther.period);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetAvailable()).compareTo(typedOther.isSetAvailable());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAvailable()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.available, typedOther.available);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetOccupationType()).compareTo(typedOther.isSetOccupationType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetOccupationType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.occupationType, typedOther.occupationType);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetProbableOccupation()).compareTo(typedOther.isSetProbableOccupation());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetProbableOccupation()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.probableOccupation, typedOther.probableOccupation);
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
        case 1: // PERIOD
          if (field.type == org.apache.thrift.protocol.TType.STRUCT) {
            this.period = new FRPeriod();
            this.period.read(iprot);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // AVAILABLE
          if (field.type == org.apache.thrift.protocol.TType.BOOL) {
            this.available = iprot.readBool();
            setAvailableIsSet(true);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 3: // OCCUPATION_TYPE
          if (field.type == org.apache.thrift.protocol.TType.I32) {
            this.occupationType = OccupationType.findByValue(iprot.readI32());
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 4: // PROBABLE_OCCUPATION
          if (field.type == org.apache.thrift.protocol.TType.I32) {
            this.probableOccupation = iprot.readI32();
            setProbableOccupationIsSet(true);
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
    if (!isSetAvailable()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'available' was not found in serialized data! Struct: " + toString());
    }
    validate();
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    validate();

    oprot.writeStructBegin(STRUCT_DESC);
    if (this.period != null) {
      oprot.writeFieldBegin(PERIOD_FIELD_DESC);
      this.period.write(oprot);
      oprot.writeFieldEnd();
    }
    oprot.writeFieldBegin(AVAILABLE_FIELD_DESC);
    oprot.writeBool(this.available);
    oprot.writeFieldEnd();
    if (this.occupationType != null) {
      oprot.writeFieldBegin(OCCUPATION_TYPE_FIELD_DESC);
      oprot.writeI32(this.occupationType.getValue());
      oprot.writeFieldEnd();
    }
    if (isSetProbableOccupation()) {
      oprot.writeFieldBegin(PROBABLE_OCCUPATION_FIELD_DESC);
      oprot.writeI32(this.probableOccupation);
      oprot.writeFieldEnd();
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("ActualOccupation(");
    boolean first = true;

    sb.append("period:");
    if (this.period == null) {
      sb.append("null");
    } else {
      sb.append(this.period);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("available:");
    sb.append(this.available);
    first = false;
    if (!first) sb.append(", ");
    sb.append("occupationType:");
    if (this.occupationType == null) {
      sb.append("null");
    } else {
      sb.append(this.occupationType);
    }
    first = false;
    if (isSetProbableOccupation()) {
      if (!first) sb.append(", ");
      sb.append("probableOccupation:");
      sb.append(this.probableOccupation);
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (period == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'period' was not present! Struct: " + toString());
    }
    // alas, we cannot check 'available' because it's a primitive and you chose the non-beans generator.
    if (occupationType == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'occupationType' was not present! Struct: " + toString());
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

