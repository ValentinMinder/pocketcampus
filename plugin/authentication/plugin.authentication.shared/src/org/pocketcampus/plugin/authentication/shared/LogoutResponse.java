/**
 * Autogenerated by Thrift Compiler (0.9.2)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.pocketcampus.plugin.authentication.shared;

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
public class LogoutResponse implements org.apache.thrift.TBase<LogoutResponse, LogoutResponse._Fields>, java.io.Serializable, Cloneable, Comparable<LogoutResponse> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("LogoutResponse");

  private static final org.apache.thrift.protocol.TField STATUS_CODE_FIELD_DESC = new org.apache.thrift.protocol.TField("statusCode", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField DELETED_SESSIONS_COUNT_FIELD_DESC = new org.apache.thrift.protocol.TField("deletedSessionsCount", org.apache.thrift.protocol.TType.I32, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new LogoutResponseStandardSchemeFactory());
    schemes.put(TupleScheme.class, new LogoutResponseTupleSchemeFactory());
  }

  private AuthStatusCode statusCode; // required
  private int deletedSessionsCount; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    /**
     * 
     * @see AuthStatusCode
     */
    STATUS_CODE((short)1, "statusCode"),
    DELETED_SESSIONS_COUNT((short)2, "deletedSessionsCount");

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
        case 1: // STATUS_CODE
          return STATUS_CODE;
        case 2: // DELETED_SESSIONS_COUNT
          return DELETED_SESSIONS_COUNT;
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
  private static final int __DELETEDSESSIONSCOUNT_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.DELETED_SESSIONS_COUNT};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.STATUS_CODE, new org.apache.thrift.meta_data.FieldMetaData("statusCode", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, AuthStatusCode.class)));
    tmpMap.put(_Fields.DELETED_SESSIONS_COUNT, new org.apache.thrift.meta_data.FieldMetaData("deletedSessionsCount", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(LogoutResponse.class, metaDataMap);
  }

  public LogoutResponse() {
  }

  public LogoutResponse(
    AuthStatusCode statusCode)
  {
    this();
    this.statusCode = statusCode;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public LogoutResponse(LogoutResponse other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetStatusCode()) {
      this.statusCode = other.statusCode;
    }
    this.deletedSessionsCount = other.deletedSessionsCount;
  }

  public LogoutResponse deepCopy() {
    return new LogoutResponse(this);
  }

  @Override
  public void clear() {
    this.statusCode = null;
    setDeletedSessionsCountIsSet(false);
    this.deletedSessionsCount = 0;
  }

  /**
   * 
   * @see AuthStatusCode
   */
  public AuthStatusCode getStatusCode() {
    return this.statusCode;
  }

  /**
   * 
   * @see AuthStatusCode
   */
  public LogoutResponse setStatusCode(AuthStatusCode statusCode) {
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

  public int getDeletedSessionsCount() {
    return this.deletedSessionsCount;
  }

  public LogoutResponse setDeletedSessionsCount(int deletedSessionsCount) {
    this.deletedSessionsCount = deletedSessionsCount;
    setDeletedSessionsCountIsSet(true);
    return this;
  }

  public void unsetDeletedSessionsCount() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __DELETEDSESSIONSCOUNT_ISSET_ID);
  }

  /** Returns true if field deletedSessionsCount is set (has been assigned a value) and false otherwise */
  public boolean isSetDeletedSessionsCount() {
    return EncodingUtils.testBit(__isset_bitfield, __DELETEDSESSIONSCOUNT_ISSET_ID);
  }

  public void setDeletedSessionsCountIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __DELETEDSESSIONSCOUNT_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case STATUS_CODE:
      if (value == null) {
        unsetStatusCode();
      } else {
        setStatusCode((AuthStatusCode)value);
      }
      break;

    case DELETED_SESSIONS_COUNT:
      if (value == null) {
        unsetDeletedSessionsCount();
      } else {
        setDeletedSessionsCount((Integer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case STATUS_CODE:
      return getStatusCode();

    case DELETED_SESSIONS_COUNT:
      return Integer.valueOf(getDeletedSessionsCount());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case STATUS_CODE:
      return isSetStatusCode();
    case DELETED_SESSIONS_COUNT:
      return isSetDeletedSessionsCount();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof LogoutResponse)
      return this.equals((LogoutResponse)that);
    return false;
  }

  public boolean equals(LogoutResponse that) {
    if (that == null)
      return false;

    boolean this_present_statusCode = true && this.isSetStatusCode();
    boolean that_present_statusCode = true && that.isSetStatusCode();
    if (this_present_statusCode || that_present_statusCode) {
      if (!(this_present_statusCode && that_present_statusCode))
        return false;
      if (!this.statusCode.equals(that.statusCode))
        return false;
    }

    boolean this_present_deletedSessionsCount = true && this.isSetDeletedSessionsCount();
    boolean that_present_deletedSessionsCount = true && that.isSetDeletedSessionsCount();
    if (this_present_deletedSessionsCount || that_present_deletedSessionsCount) {
      if (!(this_present_deletedSessionsCount && that_present_deletedSessionsCount))
        return false;
      if (this.deletedSessionsCount != that.deletedSessionsCount)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_statusCode = true && (isSetStatusCode());
    list.add(present_statusCode);
    if (present_statusCode)
      list.add(statusCode.getValue());

    boolean present_deletedSessionsCount = true && (isSetDeletedSessionsCount());
    list.add(present_deletedSessionsCount);
    if (present_deletedSessionsCount)
      list.add(deletedSessionsCount);

    return list.hashCode();
  }

  @Override
  public int compareTo(LogoutResponse other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

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
    lastComparison = Boolean.valueOf(isSetDeletedSessionsCount()).compareTo(other.isSetDeletedSessionsCount());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDeletedSessionsCount()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.deletedSessionsCount, other.deletedSessionsCount);
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
    StringBuilder sb = new StringBuilder("LogoutResponse(");
    boolean first = true;

    sb.append("statusCode:");
    if (this.statusCode == null) {
      sb.append("null");
    } else {
      sb.append(this.statusCode);
    }
    first = false;
    if (isSetDeletedSessionsCount()) {
      if (!first) sb.append(", ");
      sb.append("deletedSessionsCount:");
      sb.append(this.deletedSessionsCount);
      first = false;
    }
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
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class LogoutResponseStandardSchemeFactory implements SchemeFactory {
    public LogoutResponseStandardScheme getScheme() {
      return new LogoutResponseStandardScheme();
    }
  }

  private static class LogoutResponseStandardScheme extends StandardScheme<LogoutResponse> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, LogoutResponse struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // STATUS_CODE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.statusCode = org.pocketcampus.plugin.authentication.shared.AuthStatusCode.findByValue(iprot.readI32());
              struct.setStatusCodeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // DELETED_SESSIONS_COUNT
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.deletedSessionsCount = iprot.readI32();
              struct.setDeletedSessionsCountIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, LogoutResponse struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.statusCode != null) {
        oprot.writeFieldBegin(STATUS_CODE_FIELD_DESC);
        oprot.writeI32(struct.statusCode.getValue());
        oprot.writeFieldEnd();
      }
      if (struct.isSetDeletedSessionsCount()) {
        oprot.writeFieldBegin(DELETED_SESSIONS_COUNT_FIELD_DESC);
        oprot.writeI32(struct.deletedSessionsCount);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class LogoutResponseTupleSchemeFactory implements SchemeFactory {
    public LogoutResponseTupleScheme getScheme() {
      return new LogoutResponseTupleScheme();
    }
  }

  private static class LogoutResponseTupleScheme extends TupleScheme<LogoutResponse> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, LogoutResponse struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeI32(struct.statusCode.getValue());
      BitSet optionals = new BitSet();
      if (struct.isSetDeletedSessionsCount()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetDeletedSessionsCount()) {
        oprot.writeI32(struct.deletedSessionsCount);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, LogoutResponse struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.statusCode = org.pocketcampus.plugin.authentication.shared.AuthStatusCode.findByValue(iprot.readI32());
      struct.setStatusCodeIsSet(true);
      BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        struct.deletedSessionsCount = iprot.readI32();
        struct.setDeletedSessionsCountIsSet(true);
      }
    }
  }

}

