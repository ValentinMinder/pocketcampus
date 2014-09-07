/**
 * Autogenerated by Thrift Compiler (0.7.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package org.pocketcampus.plugin.cloudprint.shared;

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

public class CloudPrintMultipleCopies implements org.apache.thrift.TBase<CloudPrintMultipleCopies, CloudPrintMultipleCopies._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("CloudPrintMultipleCopies");

  private static final org.apache.thrift.protocol.TField NUMBER_OF_COPIES_FIELD_DESC = new org.apache.thrift.protocol.TField("numberOfCopies", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField COLLATE_FIELD_DESC = new org.apache.thrift.protocol.TField("collate", org.apache.thrift.protocol.TType.BOOL, (short)2);

  private int numberOfCopies; // required
  private boolean collate; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    NUMBER_OF_COPIES((short)1, "numberOfCopies"),
    COLLATE((short)2, "collate");

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
        case 1: // NUMBER_OF_COPIES
          return NUMBER_OF_COPIES;
        case 2: // COLLATE
          return COLLATE;
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
  private static final int __NUMBEROFCOPIES_ISSET_ID = 0;
  private static final int __COLLATE_ISSET_ID = 1;
  private BitSet __isset_bit_vector = new BitSet(2);

  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.NUMBER_OF_COPIES, new org.apache.thrift.meta_data.FieldMetaData("numberOfCopies", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.COLLATE, new org.apache.thrift.meta_data.FieldMetaData("collate", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(CloudPrintMultipleCopies.class, metaDataMap);
  }

  public CloudPrintMultipleCopies() {
  }

  public CloudPrintMultipleCopies(
    int numberOfCopies,
    boolean collate)
  {
    this();
    this.numberOfCopies = numberOfCopies;
    setNumberOfCopiesIsSet(true);
    this.collate = collate;
    setCollateIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public CloudPrintMultipleCopies(CloudPrintMultipleCopies other) {
    __isset_bit_vector.clear();
    __isset_bit_vector.or(other.__isset_bit_vector);
    this.numberOfCopies = other.numberOfCopies;
    this.collate = other.collate;
  }

  public CloudPrintMultipleCopies deepCopy() {
    return new CloudPrintMultipleCopies(this);
  }

  @Override
  public void clear() {
    setNumberOfCopiesIsSet(false);
    this.numberOfCopies = 0;
    setCollateIsSet(false);
    this.collate = false;
  }

  public int getNumberOfCopies() {
    return this.numberOfCopies;
  }

  public CloudPrintMultipleCopies setNumberOfCopies(int numberOfCopies) {
    this.numberOfCopies = numberOfCopies;
    setNumberOfCopiesIsSet(true);
    return this;
  }

  public void unsetNumberOfCopies() {
    __isset_bit_vector.clear(__NUMBEROFCOPIES_ISSET_ID);
  }

  /** Returns true if field numberOfCopies is set (has been assigned a value) and false otherwise */
  public boolean isSetNumberOfCopies() {
    return __isset_bit_vector.get(__NUMBEROFCOPIES_ISSET_ID);
  }

  public void setNumberOfCopiesIsSet(boolean value) {
    __isset_bit_vector.set(__NUMBEROFCOPIES_ISSET_ID, value);
  }

  public boolean isCollate() {
    return this.collate;
  }

  public CloudPrintMultipleCopies setCollate(boolean collate) {
    this.collate = collate;
    setCollateIsSet(true);
    return this;
  }

  public void unsetCollate() {
    __isset_bit_vector.clear(__COLLATE_ISSET_ID);
  }

  /** Returns true if field collate is set (has been assigned a value) and false otherwise */
  public boolean isSetCollate() {
    return __isset_bit_vector.get(__COLLATE_ISSET_ID);
  }

  public void setCollateIsSet(boolean value) {
    __isset_bit_vector.set(__COLLATE_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case NUMBER_OF_COPIES:
      if (value == null) {
        unsetNumberOfCopies();
      } else {
        setNumberOfCopies((Integer)value);
      }
      break;

    case COLLATE:
      if (value == null) {
        unsetCollate();
      } else {
        setCollate((Boolean)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case NUMBER_OF_COPIES:
      return Integer.valueOf(getNumberOfCopies());

    case COLLATE:
      return Boolean.valueOf(isCollate());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case NUMBER_OF_COPIES:
      return isSetNumberOfCopies();
    case COLLATE:
      return isSetCollate();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof CloudPrintMultipleCopies)
      return this.equals((CloudPrintMultipleCopies)that);
    return false;
  }

  public boolean equals(CloudPrintMultipleCopies that) {
    if (that == null)
      return false;

    boolean this_present_numberOfCopies = true;
    boolean that_present_numberOfCopies = true;
    if (this_present_numberOfCopies || that_present_numberOfCopies) {
      if (!(this_present_numberOfCopies && that_present_numberOfCopies))
        return false;
      if (this.numberOfCopies != that.numberOfCopies)
        return false;
    }

    boolean this_present_collate = true;
    boolean that_present_collate = true;
    if (this_present_collate || that_present_collate) {
      if (!(this_present_collate && that_present_collate))
        return false;
      if (this.collate != that.collate)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_numberOfCopies = true;
    builder.append(present_numberOfCopies);
    if (present_numberOfCopies)
      builder.append(numberOfCopies);

    boolean present_collate = true;
    builder.append(present_collate);
    if (present_collate)
      builder.append(collate);

    return builder.toHashCode();
  }

  public int compareTo(CloudPrintMultipleCopies other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    CloudPrintMultipleCopies typedOther = (CloudPrintMultipleCopies)other;

    lastComparison = Boolean.valueOf(isSetNumberOfCopies()).compareTo(typedOther.isSetNumberOfCopies());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetNumberOfCopies()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.numberOfCopies, typedOther.numberOfCopies);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetCollate()).compareTo(typedOther.isSetCollate());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCollate()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.collate, typedOther.collate);
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
        case 1: // NUMBER_OF_COPIES
          if (field.type == org.apache.thrift.protocol.TType.I32) {
            this.numberOfCopies = iprot.readI32();
            setNumberOfCopiesIsSet(true);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // COLLATE
          if (field.type == org.apache.thrift.protocol.TType.BOOL) {
            this.collate = iprot.readBool();
            setCollateIsSet(true);
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
    if (!isSetNumberOfCopies()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'numberOfCopies' was not found in serialized data! Struct: " + toString());
    }
    if (!isSetCollate()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'collate' was not found in serialized data! Struct: " + toString());
    }
    validate();
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    validate();

    oprot.writeStructBegin(STRUCT_DESC);
    oprot.writeFieldBegin(NUMBER_OF_COPIES_FIELD_DESC);
    oprot.writeI32(this.numberOfCopies);
    oprot.writeFieldEnd();
    oprot.writeFieldBegin(COLLATE_FIELD_DESC);
    oprot.writeBool(this.collate);
    oprot.writeFieldEnd();
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("CloudPrintMultipleCopies(");
    boolean first = true;

    sb.append("numberOfCopies:");
    sb.append(this.numberOfCopies);
    first = false;
    if (!first) sb.append(", ");
    sb.append("collate:");
    sb.append(this.collate);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // alas, we cannot check 'numberOfCopies' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'collate' because it's a primitive and you chose the non-beans generator.
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

