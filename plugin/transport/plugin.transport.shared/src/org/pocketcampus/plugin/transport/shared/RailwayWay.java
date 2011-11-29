/**
 * Autogenerated by Thrift Compiler (0.7.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package org.pocketcampus.plugin.transport.shared;

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

public class RailwayWay implements org.apache.thrift.TBase<RailwayWay, RailwayWay._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("RailwayWay");

  private static final org.apache.thrift.protocol.TField NDS_FIELD_DESC = new org.apache.thrift.protocol.TField("nds", org.apache.thrift.protocol.TType.SET, (short)1);
  private static final org.apache.thrift.protocol.TField NUM_FIELD_DESC = new org.apache.thrift.protocol.TField("num", org.apache.thrift.protocol.TType.I32, (short)2);

  public Set<RailwayNd> nds; // required
  public int num; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    NDS((short)1, "nds"),
    NUM((short)2, "num");

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
        case 1: // NDS
          return NDS;
        case 2: // NUM
          return NUM;
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
  private static final int __NUM_ISSET_ID = 0;
  private BitSet __isset_bit_vector = new BitSet(1);

  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.NDS, new org.apache.thrift.meta_data.FieldMetaData("nds", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.SetMetaData(org.apache.thrift.protocol.TType.SET, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, RailwayNd.class))));
    tmpMap.put(_Fields.NUM, new org.apache.thrift.meta_data.FieldMetaData("num", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(RailwayWay.class, metaDataMap);
  }

  public RailwayWay() {
  }

  public RailwayWay(
    Set<RailwayNd> nds,
    int num)
  {
    this();
    this.nds = nds;
    this.num = num;
    setNumIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public RailwayWay(RailwayWay other) {
    __isset_bit_vector.clear();
    __isset_bit_vector.or(other.__isset_bit_vector);
    if (other.isSetNds()) {
      Set<RailwayNd> __this__nds = new HashSet<RailwayNd>();
      for (RailwayNd other_element : other.nds) {
        __this__nds.add(new RailwayNd(other_element));
      }
      this.nds = __this__nds;
    }
    this.num = other.num;
  }

  public RailwayWay deepCopy() {
    return new RailwayWay(this);
  }

  @Override
  public void clear() {
    this.nds = null;
    setNumIsSet(false);
    this.num = 0;
  }

  public int getNdsSize() {
    return (this.nds == null) ? 0 : this.nds.size();
  }

  public java.util.Iterator<RailwayNd> getNdsIterator() {
    return (this.nds == null) ? null : this.nds.iterator();
  }

  public void addToNds(RailwayNd elem) {
    if (this.nds == null) {
      this.nds = new HashSet<RailwayNd>();
    }
    this.nds.add(elem);
  }

  public Set<RailwayNd> getNds() {
    return this.nds;
  }

  public RailwayWay setNds(Set<RailwayNd> nds) {
    this.nds = nds;
    return this;
  }

  public void unsetNds() {
    this.nds = null;
  }

  /** Returns true if field nds is set (has been assigned a value) and false otherwise */
  public boolean isSetNds() {
    return this.nds != null;
  }

  public void setNdsIsSet(boolean value) {
    if (!value) {
      this.nds = null;
    }
  }

  public int getNum() {
    return this.num;
  }

  public RailwayWay setNum(int num) {
    this.num = num;
    setNumIsSet(true);
    return this;
  }

  public void unsetNum() {
    __isset_bit_vector.clear(__NUM_ISSET_ID);
  }

  /** Returns true if field num is set (has been assigned a value) and false otherwise */
  public boolean isSetNum() {
    return __isset_bit_vector.get(__NUM_ISSET_ID);
  }

  public void setNumIsSet(boolean value) {
    __isset_bit_vector.set(__NUM_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case NDS:
      if (value == null) {
        unsetNds();
      } else {
        setNds((Set<RailwayNd>)value);
      }
      break;

    case NUM:
      if (value == null) {
        unsetNum();
      } else {
        setNum((Integer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case NDS:
      return getNds();

    case NUM:
      return Integer.valueOf(getNum());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case NDS:
      return isSetNds();
    case NUM:
      return isSetNum();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof RailwayWay)
      return this.equals((RailwayWay)that);
    return false;
  }

  public boolean equals(RailwayWay that) {
    if (that == null)
      return false;

    boolean this_present_nds = true && this.isSetNds();
    boolean that_present_nds = true && that.isSetNds();
    if (this_present_nds || that_present_nds) {
      if (!(this_present_nds && that_present_nds))
        return false;
      if (!this.nds.equals(that.nds))
        return false;
    }

    boolean this_present_num = true;
    boolean that_present_num = true;
    if (this_present_num || that_present_num) {
      if (!(this_present_num && that_present_num))
        return false;
      if (this.num != that.num)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_nds = true && (isSetNds());
    builder.append(present_nds);
    if (present_nds)
      builder.append(nds);

    boolean present_num = true;
    builder.append(present_num);
    if (present_num)
      builder.append(num);

    return builder.toHashCode();
  }

  public int compareTo(RailwayWay other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    RailwayWay typedOther = (RailwayWay)other;

    lastComparison = Boolean.valueOf(isSetNds()).compareTo(typedOther.isSetNds());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetNds()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.nds, typedOther.nds);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetNum()).compareTo(typedOther.isSetNum());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetNum()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.num, typedOther.num);
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
        case 1: // NDS
          if (field.type == org.apache.thrift.protocol.TType.SET) {
            {
              org.apache.thrift.protocol.TSet _set65 = iprot.readSetBegin();
              this.nds = new HashSet<RailwayNd>(2*_set65.size);
              for (int _i66 = 0; _i66 < _set65.size; ++_i66)
              {
                RailwayNd _elem67; // required
                _elem67 = new RailwayNd();
                _elem67.read(iprot);
                this.nds.add(_elem67);
              }
              iprot.readSetEnd();
            }
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // NUM
          if (field.type == org.apache.thrift.protocol.TType.I32) {
            this.num = iprot.readI32();
            setNumIsSet(true);
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
    if (!isSetNum()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'num' was not found in serialized data! Struct: " + toString());
    }
    validate();
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    validate();

    oprot.writeStructBegin(STRUCT_DESC);
    if (this.nds != null) {
      oprot.writeFieldBegin(NDS_FIELD_DESC);
      {
        oprot.writeSetBegin(new org.apache.thrift.protocol.TSet(org.apache.thrift.protocol.TType.STRUCT, this.nds.size()));
        for (RailwayNd _iter68 : this.nds)
        {
          _iter68.write(oprot);
        }
        oprot.writeSetEnd();
      }
      oprot.writeFieldEnd();
    }
    oprot.writeFieldBegin(NUM_FIELD_DESC);
    oprot.writeI32(this.num);
    oprot.writeFieldEnd();
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("RailwayWay(");
    boolean first = true;

    sb.append("nds:");
    if (this.nds == null) {
      sb.append("null");
    } else {
      sb.append(this.nds);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("num:");
    sb.append(this.num);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (nds == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'nds' was not present! Struct: " + toString());
    }
    // alas, we cannot check 'num' because it's a primitive and you chose the non-beans generator.
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

