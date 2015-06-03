/**
 * Autogenerated by Thrift Compiler (0.9.2)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.pocketcampus.plugin.isacademia.shared;

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
@Generated(value = "Autogenerated by Thrift Compiler (0.9.2)", date = "2015-6-3")
public class ScheduleResponse implements org.apache.thrift.TBase<ScheduleResponse, ScheduleResponse._Fields>, java.io.Serializable, Cloneable, Comparable<ScheduleResponse> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ScheduleResponse");

  private static final org.apache.thrift.protocol.TField DAYS_FIELD_DESC = new org.apache.thrift.protocol.TField("days", org.apache.thrift.protocol.TType.LIST, (short)1);
  private static final org.apache.thrift.protocol.TField STATUS_CODE_FIELD_DESC = new org.apache.thrift.protocol.TField("statusCode", org.apache.thrift.protocol.TType.I32, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new ScheduleResponseStandardSchemeFactory());
    schemes.put(TupleScheme.class, new ScheduleResponseTupleSchemeFactory());
  }

  private List<StudyDay> days; // optional
  private IsaStatusCode statusCode; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    DAYS((short)1, "days"),
    /**
     * 
     * @see IsaStatusCode
     */
    STATUS_CODE((short)2, "statusCode");

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
        case 1: // DAYS
          return DAYS;
        case 2: // STATUS_CODE
          return STATUS_CODE;
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
  private static final _Fields optionals[] = {_Fields.DAYS};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.DAYS, new org.apache.thrift.meta_data.FieldMetaData("days", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, StudyDay.class))));
    tmpMap.put(_Fields.STATUS_CODE, new org.apache.thrift.meta_data.FieldMetaData("statusCode", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, IsaStatusCode.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ScheduleResponse.class, metaDataMap);
  }

  public ScheduleResponse() {
  }

  public ScheduleResponse(
    IsaStatusCode statusCode)
  {
    this();
    this.statusCode = statusCode;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ScheduleResponse(ScheduleResponse other) {
    if (other.isSetDays()) {
      List<StudyDay> __this__days = new ArrayList<StudyDay>(other.days.size());
      for (StudyDay other_element : other.days) {
        __this__days.add(new StudyDay(other_element));
      }
      this.days = __this__days;
    }
    if (other.isSetStatusCode()) {
      this.statusCode = other.statusCode;
    }
  }

  public ScheduleResponse deepCopy() {
    return new ScheduleResponse(this);
  }

  @Override
  public void clear() {
    this.days = null;
    this.statusCode = null;
  }

  public int getDaysSize() {
    return (this.days == null) ? 0 : this.days.size();
  }

  public java.util.Iterator<StudyDay> getDaysIterator() {
    return (this.days == null) ? null : this.days.iterator();
  }

  public void addToDays(StudyDay elem) {
    if (this.days == null) {
      this.days = new ArrayList<StudyDay>();
    }
    this.days.add(elem);
  }

  public List<StudyDay> getDays() {
    return this.days;
  }

  public ScheduleResponse setDays(List<StudyDay> days) {
    this.days = days;
    return this;
  }

  public void unsetDays() {
    this.days = null;
  }

  /** Returns true if field days is set (has been assigned a value) and false otherwise */
  public boolean isSetDays() {
    return this.days != null;
  }

  public void setDaysIsSet(boolean value) {
    if (!value) {
      this.days = null;
    }
  }

  /**
   * 
   * @see IsaStatusCode
   */
  public IsaStatusCode getStatusCode() {
    return this.statusCode;
  }

  /**
   * 
   * @see IsaStatusCode
   */
  public ScheduleResponse setStatusCode(IsaStatusCode statusCode) {
    this.statusCode = statusCode;
    return this;
  }

  public void unsetStatusCode() {
    this.statusCode = null;
  }

  /** Returns true if field statusCode is set (has been assigned a value) and false otherwise */
  public boolean isSetStatusCode() {
    return this.statusCode != null;
  }

  public void setStatusCodeIsSet(boolean value) {
    if (!value) {
      this.statusCode = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case DAYS:
      if (value == null) {
        unsetDays();
      } else {
        setDays((List<StudyDay>)value);
      }
      break;

    case STATUS_CODE:
      if (value == null) {
        unsetStatusCode();
      } else {
        setStatusCode((IsaStatusCode)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case DAYS:
      return getDays();

    case STATUS_CODE:
      return getStatusCode();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case DAYS:
      return isSetDays();
    case STATUS_CODE:
      return isSetStatusCode();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof ScheduleResponse)
      return this.equals((ScheduleResponse)that);
    return false;
  }

  public boolean equals(ScheduleResponse that) {
    if (that == null)
      return false;

    boolean this_present_days = true && this.isSetDays();
    boolean that_present_days = true && that.isSetDays();
    if (this_present_days || that_present_days) {
      if (!(this_present_days && that_present_days))
        return false;
      if (!this.days.equals(that.days))
        return false;
    }

    boolean this_present_statusCode = true && this.isSetStatusCode();
    boolean that_present_statusCode = true && that.isSetStatusCode();
    if (this_present_statusCode || that_present_statusCode) {
      if (!(this_present_statusCode && that_present_statusCode))
        return false;
      if (!this.statusCode.equals(that.statusCode))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_days = true && (isSetDays());
    list.add(present_days);
    if (present_days)
      list.add(days);

    boolean present_statusCode = true && (isSetStatusCode());
    list.add(present_statusCode);
    if (present_statusCode)
      list.add(statusCode.getValue());

    return list.hashCode();
  }

  @Override
  public int compareTo(ScheduleResponse other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetDays()).compareTo(other.isSetDays());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDays()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.days, other.days);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetStatusCode()).compareTo(other.isSetStatusCode());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetStatusCode()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.statusCode, other.statusCode);
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
    StringBuilder sb = new StringBuilder("ScheduleResponse(");
    boolean first = true;

    if (isSetDays()) {
      sb.append("days:");
      if (this.days == null) {
        sb.append("null");
      } else {
        sb.append(this.days);
      }
      first = false;
    }
    if (!first) sb.append(", ");
    sb.append("statusCode:");
    if (this.statusCode == null) {
      sb.append("null");
    } else {
      sb.append(this.statusCode);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (statusCode == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'statusCode' was not present! Struct: " + toString());
    }
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
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class ScheduleResponseStandardSchemeFactory implements SchemeFactory {
    public ScheduleResponseStandardScheme getScheme() {
      return new ScheduleResponseStandardScheme();
    }
  }

  private static class ScheduleResponseStandardScheme extends StandardScheme<ScheduleResponse> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, ScheduleResponse struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // DAYS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list16 = iprot.readListBegin();
                struct.days = new ArrayList<StudyDay>(_list16.size);
                StudyDay _elem17;
                for (int _i18 = 0; _i18 < _list16.size; ++_i18)
                {
                  _elem17 = new StudyDay();
                  _elem17.read(iprot);
                  struct.days.add(_elem17);
                }
                iprot.readListEnd();
              }
              struct.setDaysIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // STATUS_CODE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.statusCode = org.pocketcampus.plugin.isacademia.shared.IsaStatusCode.findByValue(iprot.readI32());
              struct.setStatusCodeIsSet(true);
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
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, ScheduleResponse struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.days != null) {
        if (struct.isSetDays()) {
          oprot.writeFieldBegin(DAYS_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.days.size()));
            for (StudyDay _iter19 : struct.days)
            {
              _iter19.write(oprot);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.statusCode != null) {
        oprot.writeFieldBegin(STATUS_CODE_FIELD_DESC);
        oprot.writeI32(struct.statusCode.getValue());
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ScheduleResponseTupleSchemeFactory implements SchemeFactory {
    public ScheduleResponseTupleScheme getScheme() {
      return new ScheduleResponseTupleScheme();
    }
  }

  private static class ScheduleResponseTupleScheme extends TupleScheme<ScheduleResponse> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, ScheduleResponse struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeI32(struct.statusCode.getValue());
      BitSet optionals = new BitSet();
      if (struct.isSetDays()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetDays()) {
        {
          oprot.writeI32(struct.days.size());
          for (StudyDay _iter20 : struct.days)
          {
            _iter20.write(oprot);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, ScheduleResponse struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.statusCode = org.pocketcampus.plugin.isacademia.shared.IsaStatusCode.findByValue(iprot.readI32());
      struct.setStatusCodeIsSet(true);
      BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TList _list21 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.days = new ArrayList<StudyDay>(_list21.size);
          StudyDay _elem22;
          for (int _i23 = 0; _i23 < _list21.size; ++_i23)
          {
            _elem22 = new StudyDay();
            _elem22.read(iprot);
            struct.days.add(_elem22);
          }
        }
        struct.setDaysIsSet(true);
      }
    }
  }

}

