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

public class ImWorkingRequest implements org.apache.thrift.TBase<ImWorkingRequest, ImWorkingRequest._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ImWorkingRequest");

  private static final org.apache.thrift.protocol.TField WORK_FIELD_DESC = new org.apache.thrift.protocol.TField("work", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField HASH_FIELD_DESC = new org.apache.thrift.protocol.TField("hash", org.apache.thrift.protocol.TType.STRING, (short)2);

  private WorkingOccupancy work; // required
  private String hash; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    WORK((short)1, "work"),
    HASH((short)2, "hash");

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
        case 1: // WORK
          return WORK;
        case 2: // HASH
          return HASH;
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
    tmpMap.put(_Fields.WORK, new org.apache.thrift.meta_data.FieldMetaData("work", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, WorkingOccupancy.class)));
    tmpMap.put(_Fields.HASH, new org.apache.thrift.meta_data.FieldMetaData("hash", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ImWorkingRequest.class, metaDataMap);
  }

  public ImWorkingRequest() {
  }

  public ImWorkingRequest(
    WorkingOccupancy work,
    String hash)
  {
    this();
    this.work = work;
    this.hash = hash;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ImWorkingRequest(ImWorkingRequest other) {
    if (other.isSetWork()) {
      this.work = new WorkingOccupancy(other.work);
    }
    if (other.isSetHash()) {
      this.hash = other.hash;
    }
  }

  public ImWorkingRequest deepCopy() {
    return new ImWorkingRequest(this);
  }

  @Override
  public void clear() {
    this.work = null;
    this.hash = null;
  }

  public WorkingOccupancy getWork() {
    return this.work;
  }

  public ImWorkingRequest setWork(WorkingOccupancy work) {
    this.work = work;
    return this;
  }

  public void unsetWork() {
    this.work = null;
  }

  /** Returns true if field work is set (has been assigned a value) and false otherwise */
  public boolean isSetWork() {
    return this.work != null;
  }

  public void setWorkIsSet(boolean value) {
    if (!value) {
      this.work = null;
    }
  }

  public String getHash() {
    return this.hash;
  }

  public ImWorkingRequest setHash(String hash) {
    this.hash = hash;
    return this;
  }

  public void unsetHash() {
    this.hash = null;
  }

  /** Returns true if field hash is set (has been assigned a value) and false otherwise */
  public boolean isSetHash() {
    return this.hash != null;
  }

  public void setHashIsSet(boolean value) {
    if (!value) {
      this.hash = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case WORK:
      if (value == null) {
        unsetWork();
      } else {
        setWork((WorkingOccupancy)value);
      }
      break;

    case HASH:
      if (value == null) {
        unsetHash();
      } else {
        setHash((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case WORK:
      return getWork();

    case HASH:
      return getHash();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case WORK:
      return isSetWork();
    case HASH:
      return isSetHash();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof ImWorkingRequest)
      return this.equals((ImWorkingRequest)that);
    return false;
  }

  public boolean equals(ImWorkingRequest that) {
    if (that == null)
      return false;

    boolean this_present_work = true && this.isSetWork();
    boolean that_present_work = true && that.isSetWork();
    if (this_present_work || that_present_work) {
      if (!(this_present_work && that_present_work))
        return false;
      if (!this.work.equals(that.work))
        return false;
    }

    boolean this_present_hash = true && this.isSetHash();
    boolean that_present_hash = true && that.isSetHash();
    if (this_present_hash || that_present_hash) {
      if (!(this_present_hash && that_present_hash))
        return false;
      if (!this.hash.equals(that.hash))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_work = true && (isSetWork());
    builder.append(present_work);
    if (present_work)
      builder.append(work);

    boolean present_hash = true && (isSetHash());
    builder.append(present_hash);
    if (present_hash)
      builder.append(hash);

    return builder.toHashCode();
  }

  public int compareTo(ImWorkingRequest other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    ImWorkingRequest typedOther = (ImWorkingRequest)other;

    lastComparison = Boolean.valueOf(isSetWork()).compareTo(typedOther.isSetWork());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetWork()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.work, typedOther.work);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetHash()).compareTo(typedOther.isSetHash());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetHash()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.hash, typedOther.hash);
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
        case 1: // WORK
          if (field.type == org.apache.thrift.protocol.TType.STRUCT) {
            this.work = new WorkingOccupancy();
            this.work.read(iprot);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // HASH
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.hash = iprot.readString();
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
    if (this.work != null) {
      oprot.writeFieldBegin(WORK_FIELD_DESC);
      this.work.write(oprot);
      oprot.writeFieldEnd();
    }
    if (this.hash != null) {
      oprot.writeFieldBegin(HASH_FIELD_DESC);
      oprot.writeString(this.hash);
      oprot.writeFieldEnd();
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("ImWorkingRequest(");
    boolean first = true;

    sb.append("work:");
    if (this.work == null) {
      sb.append("null");
    } else {
      sb.append(this.work);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("hash:");
    if (this.hash == null) {
      sb.append("null");
    } else {
      sb.append(this.hash);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (work == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'work' was not present! Struct: " + toString());
    }
    if (hash == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'hash' was not present! Struct: " + toString());
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
