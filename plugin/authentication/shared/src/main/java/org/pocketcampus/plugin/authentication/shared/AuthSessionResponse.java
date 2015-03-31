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
@Generated(value = "Autogenerated by Thrift Compiler (0.9.2)", date = "2015-3-24")
public class AuthSessionResponse implements org.apache.thrift.TBase<AuthSessionResponse, AuthSessionResponse._Fields>, java.io.Serializable, Cloneable, Comparable<AuthSessionResponse> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("AuthSessionResponse");

  private static final org.apache.thrift.protocol.TField SESSION_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("sessionId", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField STATUS_CODE_FIELD_DESC = new org.apache.thrift.protocol.TField("statusCode", org.apache.thrift.protocol.TType.I32, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new AuthSessionResponseStandardSchemeFactory());
    schemes.put(TupleScheme.class, new AuthSessionResponseTupleSchemeFactory());
  }

  private String sessionId; // optional
  private AuthStatusCode statusCode; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    SESSION_ID((short)1, "sessionId"),
    /**
     * 
     * @see AuthStatusCode
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
        case 1: // SESSION_ID
          return SESSION_ID;
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
  private static final _Fields optionals[] = {_Fields.SESSION_ID};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.SESSION_ID, new org.apache.thrift.meta_data.FieldMetaData("sessionId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.STATUS_CODE, new org.apache.thrift.meta_data.FieldMetaData("statusCode", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, AuthStatusCode.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(AuthSessionResponse.class, metaDataMap);
  }

  public AuthSessionResponse() {
  }

  public AuthSessionResponse(
    AuthStatusCode statusCode)
  {
    this();
    this.statusCode = statusCode;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public AuthSessionResponse(AuthSessionResponse other) {
    if (other.isSetSessionId()) {
      this.sessionId = other.sessionId;
    }
    if (other.isSetStatusCode()) {
      this.statusCode = other.statusCode;
    }
  }

  public AuthSessionResponse deepCopy() {
    return new AuthSessionResponse(this);
  }

  @Override
  public void clear() {
    this.sessionId = null;
    this.statusCode = null;
  }

  public String getSessionId() {
    return this.sessionId;
  }

  public AuthSessionResponse setSessionId(String sessionId) {
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
  public AuthSessionResponse setStatusCode(AuthStatusCode statusCode) {
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
    case SESSION_ID:
      if (value == null) {
        unsetSessionId();
      } else {
        setSessionId((String)value);
      }
      break;

    case STATUS_CODE:
      if (value == null) {
        unsetStatusCode();
      } else {
        setStatusCode((AuthStatusCode)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case SESSION_ID:
      return getSessionId();

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
    case SESSION_ID:
      return isSetSessionId();
    case STATUS_CODE:
      return isSetStatusCode();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof AuthSessionResponse)
      return this.equals((AuthSessionResponse)that);
    return false;
  }

  public boolean equals(AuthSessionResponse that) {
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

    boolean present_sessionId = true && (isSetSessionId());
    list.add(present_sessionId);
    if (present_sessionId)
      list.add(sessionId);

    boolean present_statusCode = true && (isSetStatusCode());
    list.add(present_statusCode);
    if (present_statusCode)
      list.add(statusCode.getValue());

    return list.hashCode();
  }

  @Override
  public int compareTo(AuthSessionResponse other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetSessionId()).compareTo(other.isSetSessionId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSessionId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.sessionId, other.sessionId);
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
    StringBuilder sb = new StringBuilder("AuthSessionResponse(");
    boolean first = true;

    if (isSetSessionId()) {
      sb.append("sessionId:");
      if (this.sessionId == null) {
        sb.append("null");
      } else {
        sb.append(this.sessionId);
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

  private static class AuthSessionResponseStandardSchemeFactory implements SchemeFactory {
    public AuthSessionResponseStandardScheme getScheme() {
      return new AuthSessionResponseStandardScheme();
    }
  }

  private static class AuthSessionResponseStandardScheme extends StandardScheme<AuthSessionResponse> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, AuthSessionResponse struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // SESSION_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.sessionId = iprot.readString();
              struct.setSessionIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // STATUS_CODE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.statusCode = org.pocketcampus.plugin.authentication.shared.AuthStatusCode.findByValue(iprot.readI32());
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, AuthSessionResponse struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.sessionId != null) {
        if (struct.isSetSessionId()) {
          oprot.writeFieldBegin(SESSION_ID_FIELD_DESC);
          oprot.writeString(struct.sessionId);
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

  private static class AuthSessionResponseTupleSchemeFactory implements SchemeFactory {
    public AuthSessionResponseTupleScheme getScheme() {
      return new AuthSessionResponseTupleScheme();
    }
  }

  private static class AuthSessionResponseTupleScheme extends TupleScheme<AuthSessionResponse> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, AuthSessionResponse struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeI32(struct.statusCode.getValue());
      BitSet optionals = new BitSet();
      if (struct.isSetSessionId()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetSessionId()) {
        oprot.writeString(struct.sessionId);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, AuthSessionResponse struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.statusCode = org.pocketcampus.plugin.authentication.shared.AuthStatusCode.findByValue(iprot.readI32());
      struct.setStatusCodeIsSet(true);
      BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        struct.sessionId = iprot.readString();
        struct.setSessionIdIsSet(true);
      }
    }
  }

}
