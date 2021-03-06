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

public class PrintPreviewDocumentResponse implements org.apache.thrift.TBase<PrintPreviewDocumentResponse, PrintPreviewDocumentResponse._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("PrintPreviewDocumentResponse");

  private static final org.apache.thrift.protocol.TField STATUS_CODE_FIELD_DESC = new org.apache.thrift.protocol.TField("statusCode", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField NUMBER_OF_PAGES_FIELD_DESC = new org.apache.thrift.protocol.TField("numberOfPages", org.apache.thrift.protocol.TType.I32, (short)2);

  private CloudPrintStatusCode statusCode; // required
  private int numberOfPages; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    /**
     * 
     * @see CloudPrintStatusCode
     */
    STATUS_CODE((short)1, "statusCode"),
    NUMBER_OF_PAGES((short)2, "numberOfPages");

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
        case 2: // NUMBER_OF_PAGES
          return NUMBER_OF_PAGES;
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
  private static final int __NUMBEROFPAGES_ISSET_ID = 0;
  private BitSet __isset_bit_vector = new BitSet(1);

  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.STATUS_CODE, new org.apache.thrift.meta_data.FieldMetaData("statusCode", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, CloudPrintStatusCode.class)));
    tmpMap.put(_Fields.NUMBER_OF_PAGES, new org.apache.thrift.meta_data.FieldMetaData("numberOfPages", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(PrintPreviewDocumentResponse.class, metaDataMap);
  }

  public PrintPreviewDocumentResponse() {
  }

  public PrintPreviewDocumentResponse(
    CloudPrintStatusCode statusCode)
  {
    this();
    this.statusCode = statusCode;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public PrintPreviewDocumentResponse(PrintPreviewDocumentResponse other) {
    __isset_bit_vector.clear();
    __isset_bit_vector.or(other.__isset_bit_vector);
    if (other.isSetStatusCode()) {
      this.statusCode = other.statusCode;
    }
    this.numberOfPages = other.numberOfPages;
  }

  public PrintPreviewDocumentResponse deepCopy() {
    return new PrintPreviewDocumentResponse(this);
  }

  @Override
  public void clear() {
    this.statusCode = null;
    setNumberOfPagesIsSet(false);
    this.numberOfPages = 0;
  }

  /**
   * 
   * @see CloudPrintStatusCode
   */
  public CloudPrintStatusCode getStatusCode() {
    return this.statusCode;
  }

  /**
   * 
   * @see CloudPrintStatusCode
   */
  public PrintPreviewDocumentResponse setStatusCode(CloudPrintStatusCode statusCode) {
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

  public int getNumberOfPages() {
    return this.numberOfPages;
  }

  public PrintPreviewDocumentResponse setNumberOfPages(int numberOfPages) {
    this.numberOfPages = numberOfPages;
    setNumberOfPagesIsSet(true);
    return this;
  }

  public void unsetNumberOfPages() {
    __isset_bit_vector.clear(__NUMBEROFPAGES_ISSET_ID);
  }

  /** Returns true if field numberOfPages is set (has been assigned a value) and false otherwise */
  public boolean isSetNumberOfPages() {
    return __isset_bit_vector.get(__NUMBEROFPAGES_ISSET_ID);
  }

  public void setNumberOfPagesIsSet(boolean value) {
    __isset_bit_vector.set(__NUMBEROFPAGES_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case STATUS_CODE:
      if (value == null) {
        unsetStatusCode();
      } else {
        setStatusCode((CloudPrintStatusCode)value);
      }
      break;

    case NUMBER_OF_PAGES:
      if (value == null) {
        unsetNumberOfPages();
      } else {
        setNumberOfPages((Integer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case STATUS_CODE:
      return getStatusCode();

    case NUMBER_OF_PAGES:
      return Integer.valueOf(getNumberOfPages());

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
    case NUMBER_OF_PAGES:
      return isSetNumberOfPages();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof PrintPreviewDocumentResponse)
      return this.equals((PrintPreviewDocumentResponse)that);
    return false;
  }

  public boolean equals(PrintPreviewDocumentResponse that) {
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

    boolean this_present_numberOfPages = true && this.isSetNumberOfPages();
    boolean that_present_numberOfPages = true && that.isSetNumberOfPages();
    if (this_present_numberOfPages || that_present_numberOfPages) {
      if (!(this_present_numberOfPages && that_present_numberOfPages))
        return false;
      if (this.numberOfPages != that.numberOfPages)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_statusCode = true && (isSetStatusCode());
    builder.append(present_statusCode);
    if (present_statusCode)
      builder.append(statusCode.getValue());

    boolean present_numberOfPages = true && (isSetNumberOfPages());
    builder.append(present_numberOfPages);
    if (present_numberOfPages)
      builder.append(numberOfPages);

    return builder.toHashCode();
  }

  public int compareTo(PrintPreviewDocumentResponse other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    PrintPreviewDocumentResponse typedOther = (PrintPreviewDocumentResponse)other;

    lastComparison = Boolean.valueOf(isSetStatusCode()).compareTo(typedOther.isSetStatusCode());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetStatusCode()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.statusCode, typedOther.statusCode);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetNumberOfPages()).compareTo(typedOther.isSetNumberOfPages());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetNumberOfPages()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.numberOfPages, typedOther.numberOfPages);
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
        case 1: // STATUS_CODE
          if (field.type == org.apache.thrift.protocol.TType.I32) {
            this.statusCode = CloudPrintStatusCode.findByValue(iprot.readI32());
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // NUMBER_OF_PAGES
          if (field.type == org.apache.thrift.protocol.TType.I32) {
            this.numberOfPages = iprot.readI32();
            setNumberOfPagesIsSet(true);
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
    if (this.statusCode != null) {
      oprot.writeFieldBegin(STATUS_CODE_FIELD_DESC);
      oprot.writeI32(this.statusCode.getValue());
      oprot.writeFieldEnd();
    }
    if (isSetNumberOfPages()) {
      oprot.writeFieldBegin(NUMBER_OF_PAGES_FIELD_DESC);
      oprot.writeI32(this.numberOfPages);
      oprot.writeFieldEnd();
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("PrintPreviewDocumentResponse(");
    boolean first = true;

    sb.append("statusCode:");
    if (this.statusCode == null) {
      sb.append("null");
    } else {
      sb.append(this.statusCode);
    }
    first = false;
    if (isSetNumberOfPages()) {
      if (!first) sb.append(", ");
      sb.append("numberOfPages:");
      sb.append(this.numberOfPages);
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

