/**
 * Autogenerated by Thrift Compiler (0.9.2)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.pocketcampus.plugin.freeroom.shared;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
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
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.2)", date = "2014-11-28")
public class FRPeriod implements org.apache.thrift.TBase<FRPeriod, FRPeriod._Fields>, java.io.Serializable, Cloneable, Comparable<FRPeriod> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("FRPeriod");

  private static final org.apache.thrift.protocol.TField TIME_STAMP_START_FIELD_DESC = new org.apache.thrift.protocol.TField("timeStampStart", org.apache.thrift.protocol.TType.I64, (short)1);
  private static final org.apache.thrift.protocol.TField TIME_STAMP_END_FIELD_DESC = new org.apache.thrift.protocol.TField("timeStampEnd", org.apache.thrift.protocol.TType.I64, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new FRPeriodStandardSchemeFactory());
    schemes.put(TupleScheme.class, new FRPeriodTupleSchemeFactory());
  }

  private long timeStampStart; // required
  private long timeStampEnd; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    TIME_STAMP_START((short)1, "timeStampStart"),
    TIME_STAMP_END((short)2, "timeStampEnd");

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
        case 1: // TIME_STAMP_START
          return TIME_STAMP_START;
        case 2: // TIME_STAMP_END
          return TIME_STAMP_END;
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
  private static final int __TIMESTAMPSTART_ISSET_ID = 0;
  private static final int __TIMESTAMPEND_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.TIME_STAMP_START, new org.apache.thrift.meta_data.FieldMetaData("timeStampStart", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.TIME_STAMP_END, new org.apache.thrift.meta_data.FieldMetaData("timeStampEnd", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(FRPeriod.class, metaDataMap);
  }

  public FRPeriod() {
  }

  public FRPeriod(
    long timeStampStart,
    long timeStampEnd)
  {
    this();
    this.timeStampStart = timeStampStart;
    setTimeStampStartIsSet(true);
    this.timeStampEnd = timeStampEnd;
    setTimeStampEndIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public FRPeriod(FRPeriod other) {
    __isset_bitfield = other.__isset_bitfield;
    this.timeStampStart = other.timeStampStart;
    this.timeStampEnd = other.timeStampEnd;
  }

  public FRPeriod deepCopy() {
    return new FRPeriod(this);
  }

  @Override
  public void clear() {
    setTimeStampStartIsSet(false);
    this.timeStampStart = 0;
    setTimeStampEndIsSet(false);
    this.timeStampEnd = 0;
  }

  public long getTimeStampStart() {
    return this.timeStampStart;
  }

  public FRPeriod setTimeStampStart(long timeStampStart) {
    this.timeStampStart = timeStampStart;
    setTimeStampStartIsSet(true);
    return this;
  }

  public void unsetTimeStampStart() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __TIMESTAMPSTART_ISSET_ID);
  }

  /** Returns true if field timeStampStart is set (has been assigned a value) and false otherwise */
  public boolean isSetTimeStampStart() {
    return EncodingUtils.testBit(__isset_bitfield, __TIMESTAMPSTART_ISSET_ID);
  }

  public void setTimeStampStartIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __TIMESTAMPSTART_ISSET_ID, value);
  }

  public long getTimeStampEnd() {
    return this.timeStampEnd;
  }

  public FRPeriod setTimeStampEnd(long timeStampEnd) {
    this.timeStampEnd = timeStampEnd;
    setTimeStampEndIsSet(true);
    return this;
  }

  public void unsetTimeStampEnd() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __TIMESTAMPEND_ISSET_ID);
  }

  /** Returns true if field timeStampEnd is set (has been assigned a value) and false otherwise */
  public boolean isSetTimeStampEnd() {
    return EncodingUtils.testBit(__isset_bitfield, __TIMESTAMPEND_ISSET_ID);
  }

  public void setTimeStampEndIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __TIMESTAMPEND_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case TIME_STAMP_START:
      if (value == null) {
        unsetTimeStampStart();
      } else {
        setTimeStampStart((Long)value);
      }
      break;

    case TIME_STAMP_END:
      if (value == null) {
        unsetTimeStampEnd();
      } else {
        setTimeStampEnd((Long)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case TIME_STAMP_START:
      return Long.valueOf(getTimeStampStart());

    case TIME_STAMP_END:
      return Long.valueOf(getTimeStampEnd());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case TIME_STAMP_START:
      return isSetTimeStampStart();
    case TIME_STAMP_END:
      return isSetTimeStampEnd();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof FRPeriod)
      return this.equals((FRPeriod)that);
    return false;
  }

  public boolean equals(FRPeriod that) {
    if (that == null)
      return false;

    boolean this_present_timeStampStart = true;
    boolean that_present_timeStampStart = true;
    if (this_present_timeStampStart || that_present_timeStampStart) {
      if (!(this_present_timeStampStart && that_present_timeStampStart))
        return false;
      if (this.timeStampStart != that.timeStampStart)
        return false;
    }

    boolean this_present_timeStampEnd = true;
    boolean that_present_timeStampEnd = true;
    if (this_present_timeStampEnd || that_present_timeStampEnd) {
      if (!(this_present_timeStampEnd && that_present_timeStampEnd))
        return false;
      if (this.timeStampEnd != that.timeStampEnd)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_timeStampStart = true;
    list.add(present_timeStampStart);
    if (present_timeStampStart)
      list.add(timeStampStart);

    boolean present_timeStampEnd = true;
    list.add(present_timeStampEnd);
    if (present_timeStampEnd)
      list.add(timeStampEnd);

    return list.hashCode();
  }

  @Override
  public int compareTo(FRPeriod other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetTimeStampStart()).compareTo(other.isSetTimeStampStart());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTimeStampStart()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.timeStampStart, other.timeStampStart);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTimeStampEnd()).compareTo(other.isSetTimeStampEnd());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTimeStampEnd()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.timeStampEnd, other.timeStampEnd);
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
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("FRPeriod(");
    boolean first = true;

    sb.append("timeStampStart:");
    sb.append(this.timeStampStart);
    first = false;
    if (!first) sb.append(", ");
    sb.append("timeStampEnd:");
    sb.append(this.timeStampEnd);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // alas, we cannot check 'timeStampStart' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'timeStampEnd' because it's a primitive and you chose the non-beans generator.
    // check for sub-struct validity
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
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class FRPeriodStandardSchemeFactory implements SchemeFactory {
    public FRPeriodStandardScheme getScheme() {
      return new FRPeriodStandardScheme();
    }
  }

  private static class FRPeriodStandardScheme extends StandardScheme<FRPeriod> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, FRPeriod struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // TIME_STAMP_START
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.timeStampStart = iprot.readI64();
              struct.setTimeStampStartIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // TIME_STAMP_END
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.timeStampEnd = iprot.readI64();
              struct.setTimeStampEndIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      if (!struct.isSetTimeStampStart()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'timeStampStart' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetTimeStampEnd()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'timeStampEnd' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, FRPeriod struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(TIME_STAMP_START_FIELD_DESC);
      oprot.writeI64(struct.timeStampStart);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(TIME_STAMP_END_FIELD_DESC);
      oprot.writeI64(struct.timeStampEnd);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class FRPeriodTupleSchemeFactory implements SchemeFactory {
    public FRPeriodTupleScheme getScheme() {
      return new FRPeriodTupleScheme();
    }
  }

  private static class FRPeriodTupleScheme extends TupleScheme<FRPeriod> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, FRPeriod struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeI64(struct.timeStampStart);
      oprot.writeI64(struct.timeStampEnd);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, FRPeriod struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.timeStampStart = iprot.readI64();
      struct.setTimeStampStartIsSet(true);
      struct.timeStampEnd = iprot.readI64();
      struct.setTimeStampEndIsSet(true);
    }
  }

}
