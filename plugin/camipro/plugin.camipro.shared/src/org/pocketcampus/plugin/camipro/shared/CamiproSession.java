/**
 * Autogenerated by Thrift Compiler (0.7.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package org.pocketcampus.plugin.camipro.shared;

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

public class CamiproSession implements org.apache.thrift.TBase<CamiproSession, CamiproSession._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("CamiproSession");

  private static final org.apache.thrift.protocol.TField CAMIPRO_COOKIE_FIELD_DESC = new org.apache.thrift.protocol.TField("camiproCookie", org.apache.thrift.protocol.TType.STRING, (short)1);

  public String camiproCookie; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    CAMIPRO_COOKIE((short)1, "camiproCookie");

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
        case 1: // CAMIPRO_COOKIE
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

  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.CAMIPRO_COOKIE, new org.apache.thrift.meta_data.FieldMetaData("camiproCookie", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(CamiproSession.class, metaDataMap);
  }

  public CamiproSession() {
  }

  public CamiproSession(
    String camiproCookie)
  {
    this();
    this.camiproCookie = camiproCookie;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public CamiproSession(CamiproSession other) {
    if (other.isSetCamiproCookie()) {
      this.camiproCookie = other.camiproCookie;
    }
  }

  public CamiproSession deepCopy() {
    return new CamiproSession(this);
  }

  @Override
  public void clear() {
    this.camiproCookie = null;
  }

  public String getCamiproCookie() {
    return this.camiproCookie;
  }

  public CamiproSession setCamiproCookie(String camiproCookie) {
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
    case CAMIPRO_COOKIE:
      return isSetCamiproCookie();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof CamiproSession)
      return this.equals((CamiproSession)that);
    return false;
  }

  public boolean equals(CamiproSession that) {
    if (that == null)
      return false;

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
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_camiproCookie = true && (isSetCamiproCookie());
    builder.append(present_camiproCookie);
    if (present_camiproCookie)
      builder.append(camiproCookie);

    return builder.toHashCode();
  }

  public int compareTo(CamiproSession other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    CamiproSession typedOther = (CamiproSession)other;

    lastComparison = Boolean.valueOf(isSetCamiproCookie()).compareTo(typedOther.isSetCamiproCookie());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCamiproCookie()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.camiproCookie, typedOther.camiproCookie);
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
        case 1: // CAMIPRO_COOKIE
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.camiproCookie = iprot.readString();
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
    if (this.camiproCookie != null) {
      oprot.writeFieldBegin(CAMIPRO_COOKIE_FIELD_DESC);
      oprot.writeString(this.camiproCookie);
      oprot.writeFieldEnd();
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("CamiproSession(");
    boolean first = true;

    sb.append("camiproCookie:");
    if (this.camiproCookie == null) {
      sb.append("null");
    } else {
      sb.append(this.camiproCookie);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (camiproCookie == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'camiproCookie' was not present! Struct: " + toString());
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

