/**
 * Autogenerated by Thrift Compiler (0.9.2)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.pocketcampus.plugin.camipro.shared;

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
public class SessionId implements org.apache.thrift.TBase<SessionId, SessionId._Fields>, java.io.Serializable, Cloneable, Comparable<SessionId> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("SessionId");

  private static final org.apache.thrift.protocol.TField TOS_FIELD_DESC = new org.apache.thrift.protocol.TField("tos", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField CAMIPRO_COOKIE_FIELD_DESC = new org.apache.thrift.protocol.TField("camiproCookie", org.apache.thrift.protocol.TType.STRING, (short)4);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new SessionIdStandardSchemeFactory());
    schemes.put(TupleScheme.class, new SessionIdTupleSchemeFactory());
  }

  private int tos; // required
  private String camiproCookie; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    TOS((short)1, "tos"),
    CAMIPRO_COOKIE((short)4, "camiproCookie");

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
        case 1: // TOS
          return TOS;
        case 4: // CAMIPRO_COOKIE
          return CAMIPRO_COOKIE;
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
  private static final int __TOS_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.CAMIPRO_COOKIE};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.TOS, new org.apache.thrift.meta_data.FieldMetaData("tos", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.CAMIPRO_COOKIE, new org.apache.thrift.meta_data.FieldMetaData("camiproCookie", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(SessionId.class, metaDataMap);
  }

  public SessionId() {
  }

  public SessionId(
    int tos)
  {
    this();
    this.tos = tos;
    setTosIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public SessionId(SessionId other) {
    __isset_bitfield = other.__isset_bitfield;
    this.tos = other.tos;
    if (other.isSetCamiproCookie()) {
      this.camiproCookie = other.camiproCookie;
    }
  }

  public SessionId deepCopy() {
    return new SessionId(this);
  }

  @Override
  public void clear() {
    setTosIsSet(false);
    this.tos = 0;
    this.camiproCookie = null;
  }

  public int getTos() {
    return this.tos;
  }

  public SessionId setTos(int tos) {
    this.tos = tos;
    setTosIsSet(true);
    return this;
  }

  public void unsetTos() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __TOS_ISSET_ID);
  }

  /** Returns true if field tos is set (has been assigned a value) and false otherwise */
  public boolean isSetTos() {
    return EncodingUtils.testBit(__isset_bitfield, __TOS_ISSET_ID);
  }

  public void setTosIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __TOS_ISSET_ID, value);
  }

  public String getCamiproCookie() {
    return this.camiproCookie;
  }

  public SessionId setCamiproCookie(String camiproCookie) {
    this.camiproCookie = camiproCookie;
    return this;
  }

  public void unsetCamiproCookie() {
    this.camiproCookie = null;
  }

  /** Returns true if field camiproCookie is set (has been assigned a value) and false otherwise */
  public boolean isSetCamiproCookie() {
    return this.camiproCookie != null;
  }

  public void setCamiproCookieIsSet(boolean value) {
    if (!value) {
      this.camiproCookie = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case TOS:
      if (value == null) {
        unsetTos();
      } else {
        setTos((Integer)value);
      }
      break;

    case CAMIPRO_COOKIE:
      if (value == null) {
        unsetCamiproCookie();
      } else {
        setCamiproCookie((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case TOS:
      return Integer.valueOf(getTos());

    case CAMIPRO_COOKIE:
      return getCamiproCookie();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case TOS:
      return isSetTos();
    case CAMIPRO_COOKIE:
      return isSetCamiproCookie();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof SessionId)
      return this.equals((SessionId)that);
    return false;
  }

  public boolean equals(SessionId that) {
    if (that == null)
      return false;

    boolean this_present_tos = true;
    boolean that_present_tos = true;
    if (this_present_tos || that_present_tos) {
      if (!(this_present_tos && that_present_tos))
        return false;
      if (this.tos != that.tos)
        return false;
    }

    boolean this_present_camiproCookie = true && this.isSetCamiproCookie();
    boolean that_present_camiproCookie = true && that.isSetCamiproCookie();
    if (this_present_camiproCookie || that_present_camiproCookie) {
      if (!(this_present_camiproCookie && that_present_camiproCookie))
        return false;
      if (!this.camiproCookie.equals(that.camiproCookie))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_tos = true;
    list.add(present_tos);
    if (present_tos)
      list.add(tos);

    boolean present_camiproCookie = true && (isSetCamiproCookie());
    list.add(present_camiproCookie);
    if (present_camiproCookie)
      list.add(camiproCookie);

    return list.hashCode();
  }

  @Override
  public int compareTo(SessionId other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetTos()).compareTo(other.isSetTos());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTos()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.tos, other.tos);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetCamiproCookie()).compareTo(other.isSetCamiproCookie());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCamiproCookie()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.camiproCookie, other.camiproCookie);
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
    StringBuilder sb = new StringBuilder("SessionId(");
    boolean first = true;

    sb.append("tos:");
    sb.append(this.tos);
    first = false;
    if (isSetCamiproCookie()) {
      if (!first) sb.append(", ");
      sb.append("camiproCookie:");
      if (this.camiproCookie == null) {
        sb.append("null");
      } else {
        sb.append(this.camiproCookie);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // alas, we cannot check 'tos' because it's a primitive and you chose the non-beans generator.
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

  private static class SessionIdStandardSchemeFactory implements SchemeFactory {
    public SessionIdStandardScheme getScheme() {
      return new SessionIdStandardScheme();
    }
  }

  private static class SessionIdStandardScheme extends StandardScheme<SessionId> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, SessionId struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // TOS
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.tos = iprot.readI32();
              struct.setTosIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // CAMIPRO_COOKIE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.camiproCookie = iprot.readString();
              struct.setCamiproCookieIsSet(true);
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
      if (!struct.isSetTos()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'tos' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, SessionId struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(TOS_FIELD_DESC);
      oprot.writeI32(struct.tos);
      oprot.writeFieldEnd();
      if (struct.camiproCookie != null) {
        if (struct.isSetCamiproCookie()) {
          oprot.writeFieldBegin(CAMIPRO_COOKIE_FIELD_DESC);
          oprot.writeString(struct.camiproCookie);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class SessionIdTupleSchemeFactory implements SchemeFactory {
    public SessionIdTupleScheme getScheme() {
      return new SessionIdTupleScheme();
    }
  }

  private static class SessionIdTupleScheme extends TupleScheme<SessionId> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, SessionId struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeI32(struct.tos);
      BitSet optionals = new BitSet();
      if (struct.isSetCamiproCookie()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetCamiproCookie()) {
        oprot.writeString(struct.camiproCookie);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, SessionId struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.tos = iprot.readI32();
      struct.setTosIsSet(true);
      BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        struct.camiproCookie = iprot.readString();
        struct.setCamiproCookieIsSet(true);
      }
    }
  }

}

