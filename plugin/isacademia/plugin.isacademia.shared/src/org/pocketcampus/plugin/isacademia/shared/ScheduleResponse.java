/**
 * Autogenerated by Thrift Compiler (0.7.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package org.pocketcampus.plugin.isacademia.shared;

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

public class ScheduleResponse implements org.apache.thrift.TBase<ScheduleResponse, ScheduleResponse._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ScheduleResponse");

  private static final org.apache.thrift.protocol.TField DAYS_FIELD_DESC = new org.apache.thrift.protocol.TField("days", org.apache.thrift.protocol.TType.LIST, (short)1);
  private static final org.apache.thrift.protocol.TField STATUS_CODE_FIELD_DESC = new org.apache.thrift.protocol.TField("statusCode", org.apache.thrift.protocol.TType.I32, (short)2);

  private List<StudyDay> days; // required
  private ScheduleStatusCode statusCode; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    DAYS((short)1, "days"),
    /**
     * 
     * @see ScheduleStatusCode
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

  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.DAYS, new org.apache.thrift.meta_data.FieldMetaData("days", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, StudyDay.class))));
    tmpMap.put(_Fields.STATUS_CODE, new org.apache.thrift.meta_data.FieldMetaData("statusCode", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, ScheduleStatusCode.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ScheduleResponse.class, metaDataMap);
  }

  public ScheduleResponse() {
  }

  public ScheduleResponse(
    ScheduleStatusCode statusCode)
  {
    this();
    this.statusCode = statusCode;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ScheduleResponse(ScheduleResponse other) {
    if (other.isSetDays()) {
      List<StudyDay> __this__days = new ArrayList<StudyDay>();
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
   * @see ScheduleStatusCode
   */
  public ScheduleStatusCode getStatusCode() {
    return this.statusCode;
  }

  /**
   * 
   * @see ScheduleStatusCode
   */
  public ScheduleResponse setStatusCode(ScheduleStatusCode statusCode) {
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
        setStatusCode((ScheduleStatusCode)value);
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
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_days = true && (isSetDays());
    builder.append(present_days);
    if (present_days)
      builder.append(days);

    boolean present_statusCode = true && (isSetStatusCode());
    builder.append(present_statusCode);
    if (present_statusCode)
      builder.append(statusCode.getValue());

    return builder.toHashCode();
  }

  public int compareTo(ScheduleResponse other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    ScheduleResponse typedOther = (ScheduleResponse)other;

    lastComparison = Boolean.valueOf(isSetDays()).compareTo(typedOther.isSetDays());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDays()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.days, typedOther.days);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetStatusCode()).compareTo(typedOther.isSetStatusCode());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetStatusCode()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.statusCode, typedOther.statusCode);
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
        case 1: // DAYS
          if (field.type == org.apache.thrift.protocol.TType.LIST) {
            {
              org.apache.thrift.protocol.TList _list8 = iprot.readListBegin();
              this.days = new ArrayList<StudyDay>(_list8.size);
              for (int _i9 = 0; _i9 < _list8.size; ++_i9)
              {
                StudyDay _elem10; // required
                _elem10 = new StudyDay();
                _elem10.read(iprot);
                this.days.add(_elem10);
              }
              iprot.readListEnd();
            }
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // STATUS_CODE
          if (field.type == org.apache.thrift.protocol.TType.I32) {
            this.statusCode = ScheduleStatusCode.findByValue(iprot.readI32());
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
    if (this.days != null) {
      if (isSetDays()) {
        oprot.writeFieldBegin(DAYS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, this.days.size()));
          for (StudyDay _iter11 : this.days)
          {
            _iter11.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
    }
    if (this.statusCode != null) {
      oprot.writeFieldBegin(STATUS_CODE_FIELD_DESC);
      oprot.writeI32(this.statusCode.getValue());
      oprot.writeFieldEnd();
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
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

