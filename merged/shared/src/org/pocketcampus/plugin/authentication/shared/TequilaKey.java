/**
 * Autogenerated by Thrift Compiler (0.7.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package org.pocketcampus.plugin.authentication.shared;

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

public class TequilaKey implements org.apache.thrift.TBase<TequilaKey, TequilaKey._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TequilaKey");

  private static final org.apache.thrift.protocol.TField TOS_FIELD_DESC = new org.apache.thrift.protocol.TField("tos", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField I_TEQUILA_KEY_FIELD_DESC = new org.apache.thrift.protocol.TField("iTequilaKey", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField LOGIN_COOKIE_FIELD_DESC = new org.apache.thrift.protocol.TField("loginCookie", org.apache.thrift.protocol.TType.STRING, (short)3);

  /**
   * 
   * @see TypeOfService
   */
  public TypeOfService tos; // required
  public String iTequilaKey; // required
  public String loginCookie; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    /**
     * 
     * @see TypeOfService
     */
    TOS((short)1, "tos"),
    I_TEQUILA_KEY((short)2, "iTequilaKey"),
    LOGIN_COOKIE((short)3, "loginCookie");

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
        case 2: // I_TEQUILA_KEY
          return I_TEQUILA_KEY;
        case 3: // LOGIN_COOKIE
          return LOGIN_COOKIE;
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
    tmpMap.put(_Fields.TOS, new org.apache.thrift.meta_data.FieldMetaData("tos", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, TypeOfService.class)));
    tmpMap.put(_Fields.I_TEQUILA_KEY, new org.apache.thrift.meta_data.FieldMetaData("iTequilaKey", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.LOGIN_COOKIE, new org.apache.thrift.meta_data.FieldMetaData("loginCookie", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TequilaKey.class, metaDataMap);
  }

  public TequilaKey() {
  }

  public TequilaKey(
    TypeOfService tos,
    String iTequilaKey)
  {
    this();
    this.tos = tos;
    this.iTequilaKey = iTequilaKey;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TequilaKey(TequilaKey other) {
    if (other.isSetTos()) {
      this.tos = other.tos;
    }
    if (other.isSetITequilaKey()) {
      this.iTequilaKey = other.iTequilaKey;
    }
    if (other.isSetLoginCookie()) {
      this.loginCookie = other.loginCookie;
    }
  }

  public TequilaKey deepCopy() {
    return new TequilaKey(this);
  }

  @Override
  public void clear() {
    this.tos = null;
    this.iTequilaKey = null;
    this.loginCookie = null;
  }

  /**
   * 
   * @see TypeOfService
   */
  public TypeOfService getTos() {
    return this.tos;
  }

  /**
   * 
   * @see TypeOfService
   */
  public TequilaKey setTos(TypeOfService tos) {
    this.tos = tos;
    return this;
  }

  public void unsetTos() {
    this.tos = null;
  }

  /** Returns true if field tos is set (has been assigned a value) and false otherwise */
  public boolean isSetTos() {
    return this.tos != null;
  }

  public void setTosIsSet(boolean value) {
    if (!value) {
      this.tos = null;
    }
  }

  public String getITequilaKey() {
    return this.iTequilaKey;
  }

  public TequilaKey setITequilaKey(String iTequilaKey) {
    this.iTequilaKey = iTequilaKey;
    return this;
  }

  public void unsetITequilaKey() {
    this.iTequilaKey = null;
  }

  /** Returns true if field iTequilaKey is set (has been assigned a value) and false otherwise */
  public boolean isSetITequilaKey() {
    return this.iTequilaKey != null;
  }

  public void setITequilaKeyIsSet(boolean value) {
    if (!value) {
      this.iTequilaKey = null;
    }
  }

  public String getLoginCookie() {
    return this.loginCookie;
  }

  public TequilaKey setLoginCookie(String loginCookie) {
    this.loginCookie = loginCookie;
    return this;
  }

  public void unsetLoginCookie() {
    this.loginCookie = null;
  }

  /** Returns true if field loginCookie is set (has been assigned a value) and false otherwise */
  public boolean isSetLoginCookie() {
    return this.loginCookie != null;
  }

  public void setLoginCookieIsSet(boolean value) {
    if (!value) {
      this.loginCookie = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case TOS:
      if (value == null) {
        unsetTos();
      } else {
        setTos((TypeOfService)value);
      }
      break;

    case I_TEQUILA_KEY:
      if (value == null) {
        unsetITequilaKey();
      } else {
        setITequilaKey((String)value);
      }
      break;

    case LOGIN_COOKIE:
      if (value == null) {
        unsetLoginCookie();
      } else {
        setLoginCookie((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case TOS:
      return getTos();

    case I_TEQUILA_KEY:
      return getITequilaKey();

    case LOGIN_COOKIE:
      return getLoginCookie();

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
    case I_TEQUILA_KEY:
      return isSetITequilaKey();
    case LOGIN_COOKIE:
      return isSetLoginCookie();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof TequilaKey)
      return this.equals((TequilaKey)that);
    return false;
  }

  public boolean equals(TequilaKey that) {
    if (that == null)
      return false;

    boolean this_present_tos = true && this.isSetTos();
    boolean that_present_tos = true && that.isSetTos();
    if (this_present_tos || that_present_tos) {
      if (!(this_present_tos && that_present_tos))
        return false;
      if (!this.tos.equals(that.tos))
        return false;
    }

    boolean this_present_iTequilaKey = true && this.isSetITequilaKey();
    boolean that_present_iTequilaKey = true && that.isSetITequilaKey();
    if (this_present_iTequilaKey || that_present_iTequilaKey) {
      if (!(this_present_iTequilaKey && that_present_iTequilaKey))
        return false;
      if (!this.iTequilaKey.equals(that.iTequilaKey))
        return false;
    }

    boolean this_present_loginCookie = true && this.isSetLoginCookie();
    boolean that_present_loginCookie = true && that.isSetLoginCookie();
    if (this_present_loginCookie || that_present_loginCookie) {
      if (!(this_present_loginCookie && that_present_loginCookie))
        return false;
      if (!this.loginCookie.equals(that.loginCookie))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_tos = true && (isSetTos());
    builder.append(present_tos);
    if (present_tos)
      builder.append(tos.getValue());

    boolean present_iTequilaKey = true && (isSetITequilaKey());
    builder.append(present_iTequilaKey);
    if (present_iTequilaKey)
      builder.append(iTequilaKey);

    boolean present_loginCookie = true && (isSetLoginCookie());
    builder.append(present_loginCookie);
    if (present_loginCookie)
      builder.append(loginCookie);

    return builder.toHashCode();
  }

  public int compareTo(TequilaKey other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    TequilaKey typedOther = (TequilaKey)other;

    lastComparison = Boolean.valueOf(isSetTos()).compareTo(typedOther.isSetTos());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTos()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.tos, typedOther.tos);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetITequilaKey()).compareTo(typedOther.isSetITequilaKey());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetITequilaKey()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.iTequilaKey, typedOther.iTequilaKey);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetLoginCookie()).compareTo(typedOther.isSetLoginCookie());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLoginCookie()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.loginCookie, typedOther.loginCookie);
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
        case 1: // TOS
          if (field.type == org.apache.thrift.protocol.TType.I32) {
            this.tos = TypeOfService.findByValue(iprot.readI32());
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // I_TEQUILA_KEY
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.iTequilaKey = iprot.readString();
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 3: // LOGIN_COOKIE
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.loginCookie = iprot.readString();
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
    if (this.tos != null) {
      oprot.writeFieldBegin(TOS_FIELD_DESC);
      oprot.writeI32(this.tos.getValue());
      oprot.writeFieldEnd();
    }
    if (this.iTequilaKey != null) {
      oprot.writeFieldBegin(I_TEQUILA_KEY_FIELD_DESC);
      oprot.writeString(this.iTequilaKey);
      oprot.writeFieldEnd();
    }
    if (this.loginCookie != null) {
      if (isSetLoginCookie()) {
        oprot.writeFieldBegin(LOGIN_COOKIE_FIELD_DESC);
        oprot.writeString(this.loginCookie);
        oprot.writeFieldEnd();
      }
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("TequilaKey(");
    boolean first = true;

    sb.append("tos:");
    if (this.tos == null) {
      sb.append("null");
    } else {
      sb.append(this.tos);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("iTequilaKey:");
    if (this.iTequilaKey == null) {
      sb.append("null");
    } else {
      sb.append(this.iTequilaKey);
    }
    first = false;
    if (isSetLoginCookie()) {
      if (!first) sb.append(", ");
      sb.append("loginCookie:");
      if (this.loginCookie == null) {
        sb.append("null");
      } else {
        sb.append(this.loginCookie);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (tos == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'tos' was not present! Struct: " + toString());
    }
    if (iTequilaKey == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'iTequilaKey' was not present! Struct: " + toString());
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
