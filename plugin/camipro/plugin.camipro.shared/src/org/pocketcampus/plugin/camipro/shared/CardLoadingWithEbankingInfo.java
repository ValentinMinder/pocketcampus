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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CardLoadingWithEbankingInfo implements org.apache.thrift.TBase<CardLoadingWithEbankingInfo, CardLoadingWithEbankingInfo._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("CardLoadingWithEbankingInfo");

  private static final org.apache.thrift.protocol.TField I_PAID_TO_FIELD_DESC = new org.apache.thrift.protocol.TField("iPaidTo", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField I_ACCOUNT_NUMBER_FIELD_DESC = new org.apache.thrift.protocol.TField("iAccountNumber", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField I_REFERENCE_NUMBER_FIELD_DESC = new org.apache.thrift.protocol.TField("iReferenceNumber", org.apache.thrift.protocol.TType.STRING, (short)3);

  public String iPaidTo; // required
  public String iAccountNumber; // required
  public String iReferenceNumber; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    I_PAID_TO((short)1, "iPaidTo"),
    I_ACCOUNT_NUMBER((short)2, "iAccountNumber"),
    I_REFERENCE_NUMBER((short)3, "iReferenceNumber");

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
        case 1: // I_PAID_TO
          return I_PAID_TO;
        case 2: // I_ACCOUNT_NUMBER
          return I_ACCOUNT_NUMBER;
        case 3: // I_REFERENCE_NUMBER
          return I_REFERENCE_NUMBER;
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
    tmpMap.put(_Fields.I_PAID_TO, new org.apache.thrift.meta_data.FieldMetaData("iPaidTo", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.I_ACCOUNT_NUMBER, new org.apache.thrift.meta_data.FieldMetaData("iAccountNumber", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.I_REFERENCE_NUMBER, new org.apache.thrift.meta_data.FieldMetaData("iReferenceNumber", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(CardLoadingWithEbankingInfo.class, metaDataMap);
  }

  public CardLoadingWithEbankingInfo() {
  }

  public CardLoadingWithEbankingInfo(
    String iPaidTo,
    String iAccountNumber,
    String iReferenceNumber)
  {
    this();
    this.iPaidTo = iPaidTo;
    this.iAccountNumber = iAccountNumber;
    this.iReferenceNumber = iReferenceNumber;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public CardLoadingWithEbankingInfo(CardLoadingWithEbankingInfo other) {
    if (other.isSetIPaidTo()) {
      this.iPaidTo = other.iPaidTo;
    }
    if (other.isSetIAccountNumber()) {
      this.iAccountNumber = other.iAccountNumber;
    }
    if (other.isSetIReferenceNumber()) {
      this.iReferenceNumber = other.iReferenceNumber;
    }
  }

  public CardLoadingWithEbankingInfo deepCopy() {
    return new CardLoadingWithEbankingInfo(this);
  }

  @Override
  public void clear() {
    this.iPaidTo = null;
    this.iAccountNumber = null;
    this.iReferenceNumber = null;
  }

  public String getIPaidTo() {
    return this.iPaidTo;
  }

  public CardLoadingWithEbankingInfo setIPaidTo(String iPaidTo) {
    this.iPaidTo = iPaidTo;
    return this;
  }

  public void unsetIPaidTo() {
    this.iPaidTo = null;
  }

  /** Returns true if field iPaidTo is set (has been assigned a value) and false otherwise */
  public boolean isSetIPaidTo() {
    return this.iPaidTo != null;
  }

  public void setIPaidToIsSet(boolean value) {
    if (!value) {
      this.iPaidTo = null;
    }
  }

  public String getIAccountNumber() {
    return this.iAccountNumber;
  }

  public CardLoadingWithEbankingInfo setIAccountNumber(String iAccountNumber) {
    this.iAccountNumber = iAccountNumber;
    return this;
  }

  public void unsetIAccountNumber() {
    this.iAccountNumber = null;
  }

  /** Returns true if field iAccountNumber is set (has been assigned a value) and false otherwise */
  public boolean isSetIAccountNumber() {
    return this.iAccountNumber != null;
  }

  public void setIAccountNumberIsSet(boolean value) {
    if (!value) {
      this.iAccountNumber = null;
    }
  }

  public String getIReferenceNumber() {
    return this.iReferenceNumber;
  }

  public CardLoadingWithEbankingInfo setIReferenceNumber(String iReferenceNumber) {
    this.iReferenceNumber = iReferenceNumber;
    return this;
  }

  public void unsetIReferenceNumber() {
    this.iReferenceNumber = null;
  }

  /** Returns true if field iReferenceNumber is set (has been assigned a value) and false otherwise */
  public boolean isSetIReferenceNumber() {
    return this.iReferenceNumber != null;
  }

  public void setIReferenceNumberIsSet(boolean value) {
    if (!value) {
      this.iReferenceNumber = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case I_PAID_TO:
      if (value == null) {
        unsetIPaidTo();
      } else {
        setIPaidTo((String)value);
      }
      break;

    case I_ACCOUNT_NUMBER:
      if (value == null) {
        unsetIAccountNumber();
      } else {
        setIAccountNumber((String)value);
      }
      break;

    case I_REFERENCE_NUMBER:
      if (value == null) {
        unsetIReferenceNumber();
      } else {
        setIReferenceNumber((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case I_PAID_TO:
      return getIPaidTo();

    case I_ACCOUNT_NUMBER:
      return getIAccountNumber();

    case I_REFERENCE_NUMBER:
      return getIReferenceNumber();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case I_PAID_TO:
      return isSetIPaidTo();
    case I_ACCOUNT_NUMBER:
      return isSetIAccountNumber();
    case I_REFERENCE_NUMBER:
      return isSetIReferenceNumber();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof CardLoadingWithEbankingInfo)
      return this.equals((CardLoadingWithEbankingInfo)that);
    return false;
  }

  public boolean equals(CardLoadingWithEbankingInfo that) {
    if (that == null)
      return false;

    boolean this_present_iPaidTo = true && this.isSetIPaidTo();
    boolean that_present_iPaidTo = true && that.isSetIPaidTo();
    if (this_present_iPaidTo || that_present_iPaidTo) {
      if (!(this_present_iPaidTo && that_present_iPaidTo))
        return false;
      if (!this.iPaidTo.equals(that.iPaidTo))
        return false;
    }

    boolean this_present_iAccountNumber = true && this.isSetIAccountNumber();
    boolean that_present_iAccountNumber = true && that.isSetIAccountNumber();
    if (this_present_iAccountNumber || that_present_iAccountNumber) {
      if (!(this_present_iAccountNumber && that_present_iAccountNumber))
        return false;
      if (!this.iAccountNumber.equals(that.iAccountNumber))
        return false;
    }

    boolean this_present_iReferenceNumber = true && this.isSetIReferenceNumber();
    boolean that_present_iReferenceNumber = true && that.isSetIReferenceNumber();
    if (this_present_iReferenceNumber || that_present_iReferenceNumber) {
      if (!(this_present_iReferenceNumber && that_present_iReferenceNumber))
        return false;
      if (!this.iReferenceNumber.equals(that.iReferenceNumber))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_iPaidTo = true && (isSetIPaidTo());
    builder.append(present_iPaidTo);
    if (present_iPaidTo)
      builder.append(iPaidTo);

    boolean present_iAccountNumber = true && (isSetIAccountNumber());
    builder.append(present_iAccountNumber);
    if (present_iAccountNumber)
      builder.append(iAccountNumber);

    boolean present_iReferenceNumber = true && (isSetIReferenceNumber());
    builder.append(present_iReferenceNumber);
    if (present_iReferenceNumber)
      builder.append(iReferenceNumber);

    return builder.toHashCode();
  }

  public int compareTo(CardLoadingWithEbankingInfo other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    CardLoadingWithEbankingInfo typedOther = (CardLoadingWithEbankingInfo)other;

    lastComparison = Boolean.valueOf(isSetIPaidTo()).compareTo(typedOther.isSetIPaidTo());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetIPaidTo()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.iPaidTo, typedOther.iPaidTo);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetIAccountNumber()).compareTo(typedOther.isSetIAccountNumber());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetIAccountNumber()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.iAccountNumber, typedOther.iAccountNumber);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetIReferenceNumber()).compareTo(typedOther.isSetIReferenceNumber());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetIReferenceNumber()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.iReferenceNumber, typedOther.iReferenceNumber);
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
        case 1: // I_PAID_TO
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.iPaidTo = iprot.readString();
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // I_ACCOUNT_NUMBER
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.iAccountNumber = iprot.readString();
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 3: // I_REFERENCE_NUMBER
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.iReferenceNumber = iprot.readString();
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
    if (this.iPaidTo != null) {
      oprot.writeFieldBegin(I_PAID_TO_FIELD_DESC);
      oprot.writeString(this.iPaidTo);
      oprot.writeFieldEnd();
    }
    if (this.iAccountNumber != null) {
      oprot.writeFieldBegin(I_ACCOUNT_NUMBER_FIELD_DESC);
      oprot.writeString(this.iAccountNumber);
      oprot.writeFieldEnd();
    }
    if (this.iReferenceNumber != null) {
      oprot.writeFieldBegin(I_REFERENCE_NUMBER_FIELD_DESC);
      oprot.writeString(this.iReferenceNumber);
      oprot.writeFieldEnd();
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("CardLoadingWithEbankingInfo(");
    boolean first = true;

    sb.append("iPaidTo:");
    if (this.iPaidTo == null) {
      sb.append("null");
    } else {
      sb.append(this.iPaidTo);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("iAccountNumber:");
    if (this.iAccountNumber == null) {
      sb.append("null");
    } else {
      sb.append(this.iAccountNumber);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("iReferenceNumber:");
    if (this.iReferenceNumber == null) {
      sb.append("null");
    } else {
      sb.append(this.iReferenceNumber);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (iPaidTo == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'iPaidTo' was not present! Struct: " + toString());
    }
    if (iAccountNumber == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'iAccountNumber' was not present! Struct: " + toString());
    }
    if (iReferenceNumber == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'iReferenceNumber' was not present! Struct: " + toString());
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

