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

public class TakeoutServerAddress implements org.apache.thrift.TBase<TakeoutServerAddress, TakeoutServerAddress._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TakeoutServerAddress");

  private static final org.apache.thrift.protocol.TField SERVER_IP_FIELD_DESC = new org.apache.thrift.protocol.TField("serverIP", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField PORT_FIELD_DESC = new org.apache.thrift.protocol.TField("port", org.apache.thrift.protocol.TType.I64, (short)2);

  public String serverIP; // required
  public long port; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    SERVER_IP((short)1, "serverIP"),
    PORT((short)2, "port");

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
        case 1: // SERVER_IP
          return SERVER_IP;
        case 2: // PORT
          return PORT;
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
  private static final int __PORT_ISSET_ID = 0;
  private BitSet __isset_bit_vector = new BitSet(1);

  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.SERVER_IP, new org.apache.thrift.meta_data.FieldMetaData("serverIP", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PORT, new org.apache.thrift.meta_data.FieldMetaData("port", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64        , "integer")));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TakeoutServerAddress.class, metaDataMap);
  }

  public TakeoutServerAddress() {
  }

  public TakeoutServerAddress(
    String serverIP,
    long port)
  {
    this();
    this.serverIP = serverIP;
    this.port = port;
    setPortIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TakeoutServerAddress(TakeoutServerAddress other) {
    __isset_bit_vector.clear();
    __isset_bit_vector.or(other.__isset_bit_vector);
    if (other.isSetServerIP()) {
      this.serverIP = other.serverIP;
    }
    this.port = other.port;
  }

  public TakeoutServerAddress deepCopy() {
    return new TakeoutServerAddress(this);
  }

  @Override
  public void clear() {
    this.serverIP = null;
    setPortIsSet(false);
    this.port = 0;
  }

  public String getServerIP() {
    return this.serverIP;
  }

  public TakeoutServerAddress setServerIP(String serverIP) {
    this.serverIP = serverIP;
    return this;
  }

  public void unsetServerIP() {
    this.serverIP = null;
  }

  /** Returns true if field serverIP is set (has been assigned a value) and false otherwise */
  public boolean isSetServerIP() {
    return this.serverIP != null;
  }

  public void setServerIPIsSet(boolean value) {
    if (!value) {
      this.serverIP = null;
    }
  }

  public long getPort() {
    return this.port;
  }

  public TakeoutServerAddress setPort(long port) {
    this.port = port;
    setPortIsSet(true);
    return this;
  }

  public void unsetPort() {
    __isset_bit_vector.clear(__PORT_ISSET_ID);
  }

  /** Returns true if field port is set (has been assigned a value) and false otherwise */
  public boolean isSetPort() {
    return __isset_bit_vector.get(__PORT_ISSET_ID);
  }

  public void setPortIsSet(boolean value) {
    __isset_bit_vector.set(__PORT_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case SERVER_IP:
      if (value == null) {
        unsetServerIP();
      } else {
        setServerIP((String)value);
      }
      break;

    case PORT:
      if (value == null) {
        unsetPort();
      } else {
        setPort((Long)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case SERVER_IP:
      return getServerIP();

    case PORT:
      return Long.valueOf(getPort());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case SERVER_IP:
      return isSetServerIP();
    case PORT:
      return isSetPort();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof TakeoutServerAddress)
      return this.equals((TakeoutServerAddress)that);
    return false;
  }

  public boolean equals(TakeoutServerAddress that) {
    if (that == null)
      return false;

    boolean this_present_serverIP = true && this.isSetServerIP();
    boolean that_present_serverIP = true && that.isSetServerIP();
    if (this_present_serverIP || that_present_serverIP) {
      if (!(this_present_serverIP && that_present_serverIP))
        return false;
      if (!this.serverIP.equals(that.serverIP))
        return false;
    }

    boolean this_present_port = true;
    boolean that_present_port = true;
    if (this_present_port || that_present_port) {
      if (!(this_present_port && that_present_port))
        return false;
      if (this.port != that.port)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(TakeoutServerAddress other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    TakeoutServerAddress typedOther = (TakeoutServerAddress)other;

    lastComparison = Boolean.valueOf(isSetServerIP()).compareTo(typedOther.isSetServerIP());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetServerIP()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.serverIP, typedOther.serverIP);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPort()).compareTo(typedOther.isSetPort());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPort()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.port, typedOther.port);
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
        case 1: // SERVER_IP
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.serverIP = iprot.readString();
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // PORT
          if (field.type == org.apache.thrift.protocol.TType.I64) {
            this.port = iprot.readI64();
            setPortIsSet(true);
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
    if (!isSetPort()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'port' was not found in serialized data! Struct: " + toString());
    }
    validate();
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    validate();

    oprot.writeStructBegin(STRUCT_DESC);
    if (this.serverIP != null) {
      oprot.writeFieldBegin(SERVER_IP_FIELD_DESC);
      oprot.writeString(this.serverIP);
      oprot.writeFieldEnd();
    }
    oprot.writeFieldBegin(PORT_FIELD_DESC);
    oprot.writeI64(this.port);
    oprot.writeFieldEnd();
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("TakeoutServerAddress(");
    boolean first = true;

    sb.append("serverIP:");
    if (this.serverIP == null) {
      sb.append("null");
    } else {
      sb.append(this.serverIP);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("port:");
    sb.append(this.port);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (serverIP == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'serverIP' was not present! Struct: " + toString());
    }
    // alas, we cannot check 'port' because it's a primitive and you chose the non-beans generator.
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

