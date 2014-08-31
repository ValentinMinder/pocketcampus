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

public class PrintDocumentRequest implements org.apache.thrift.TBase<PrintDocumentRequest, PrintDocumentRequest._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("PrintDocumentRequest");

  private static final org.apache.thrift.protocol.TField DOCUMENT_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("documentId", org.apache.thrift.protocol.TType.I64, (short)1);
  private static final org.apache.thrift.protocol.TField DOUBLE_SIDED_FIELD_DESC = new org.apache.thrift.protocol.TField("doubleSided", org.apache.thrift.protocol.TType.BOOL, (short)2);
  private static final org.apache.thrift.protocol.TField BLACK_AND_WHITE_FIELD_DESC = new org.apache.thrift.protocol.TField("blackAndWhite", org.apache.thrift.protocol.TType.BOOL, (short)3);
  private static final org.apache.thrift.protocol.TField NUMBER_OF_COPIES_FIELD_DESC = new org.apache.thrift.protocol.TField("numberOfCopies", org.apache.thrift.protocol.TType.I32, (short)4);
  private static final org.apache.thrift.protocol.TField PAGE_SELECTION_FIELD_DESC = new org.apache.thrift.protocol.TField("pageSelection", org.apache.thrift.protocol.TType.STRUCT, (short)5);

  private long documentId; // required
  private boolean doubleSided; // required
  private boolean blackAndWhite; // required
  private int numberOfCopies; // required
  private CloudPrintPageRange pageSelection; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    DOCUMENT_ID((short)1, "documentId"),
    DOUBLE_SIDED((short)2, "doubleSided"),
    BLACK_AND_WHITE((short)3, "blackAndWhite"),
    NUMBER_OF_COPIES((short)4, "numberOfCopies"),
    PAGE_SELECTION((short)5, "pageSelection");

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
        case 1: // DOCUMENT_ID
          return DOCUMENT_ID;
        case 2: // DOUBLE_SIDED
          return DOUBLE_SIDED;
        case 3: // BLACK_AND_WHITE
          return BLACK_AND_WHITE;
        case 4: // NUMBER_OF_COPIES
          return NUMBER_OF_COPIES;
        case 5: // PAGE_SELECTION
          return PAGE_SELECTION;
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
  private static final int __DOCUMENTID_ISSET_ID = 0;
  private static final int __DOUBLESIDED_ISSET_ID = 1;
  private static final int __BLACKANDWHITE_ISSET_ID = 2;
  private static final int __NUMBEROFCOPIES_ISSET_ID = 3;
  private BitSet __isset_bit_vector = new BitSet(4);

  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.DOCUMENT_ID, new org.apache.thrift.meta_data.FieldMetaData("documentId", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.DOUBLE_SIDED, new org.apache.thrift.meta_data.FieldMetaData("doubleSided", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    tmpMap.put(_Fields.BLACK_AND_WHITE, new org.apache.thrift.meta_data.FieldMetaData("blackAndWhite", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    tmpMap.put(_Fields.NUMBER_OF_COPIES, new org.apache.thrift.meta_data.FieldMetaData("numberOfCopies", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.PAGE_SELECTION, new org.apache.thrift.meta_data.FieldMetaData("pageSelection", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, CloudPrintPageRange.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(PrintDocumentRequest.class, metaDataMap);
  }

  public PrintDocumentRequest() {
  }

  public PrintDocumentRequest(
    long documentId,
    boolean doubleSided,
    boolean blackAndWhite,
    int numberOfCopies)
  {
    this();
    this.documentId = documentId;
    setDocumentIdIsSet(true);
    this.doubleSided = doubleSided;
    setDoubleSidedIsSet(true);
    this.blackAndWhite = blackAndWhite;
    setBlackAndWhiteIsSet(true);
    this.numberOfCopies = numberOfCopies;
    setNumberOfCopiesIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public PrintDocumentRequest(PrintDocumentRequest other) {
    __isset_bit_vector.clear();
    __isset_bit_vector.or(other.__isset_bit_vector);
    this.documentId = other.documentId;
    this.doubleSided = other.doubleSided;
    this.blackAndWhite = other.blackAndWhite;
    this.numberOfCopies = other.numberOfCopies;
    if (other.isSetPageSelection()) {
      this.pageSelection = new CloudPrintPageRange(other.pageSelection);
    }
  }

  public PrintDocumentRequest deepCopy() {
    return new PrintDocumentRequest(this);
  }

  @Override
  public void clear() {
    setDocumentIdIsSet(false);
    this.documentId = 0;
    setDoubleSidedIsSet(false);
    this.doubleSided = false;
    setBlackAndWhiteIsSet(false);
    this.blackAndWhite = false;
    setNumberOfCopiesIsSet(false);
    this.numberOfCopies = 0;
    this.pageSelection = null;
  }

  public long getDocumentId() {
    return this.documentId;
  }

  public PrintDocumentRequest setDocumentId(long documentId) {
    this.documentId = documentId;
    setDocumentIdIsSet(true);
    return this;
  }

  public void unsetDocumentId() {
    __isset_bit_vector.clear(__DOCUMENTID_ISSET_ID);
  }

  /** Returns true if field documentId is set (has been assigned a value) and false otherwise */
  public boolean isSetDocumentId() {
    return __isset_bit_vector.get(__DOCUMENTID_ISSET_ID);
  }

  public void setDocumentIdIsSet(boolean value) {
    __isset_bit_vector.set(__DOCUMENTID_ISSET_ID, value);
  }

  public boolean isDoubleSided() {
    return this.doubleSided;
  }

  public PrintDocumentRequest setDoubleSided(boolean doubleSided) {
    this.doubleSided = doubleSided;
    setDoubleSidedIsSet(true);
    return this;
  }

  public void unsetDoubleSided() {
    __isset_bit_vector.clear(__DOUBLESIDED_ISSET_ID);
  }

  /** Returns true if field doubleSided is set (has been assigned a value) and false otherwise */
  public boolean isSetDoubleSided() {
    return __isset_bit_vector.get(__DOUBLESIDED_ISSET_ID);
  }

  public void setDoubleSidedIsSet(boolean value) {
    __isset_bit_vector.set(__DOUBLESIDED_ISSET_ID, value);
  }

  public boolean isBlackAndWhite() {
    return this.blackAndWhite;
  }

  public PrintDocumentRequest setBlackAndWhite(boolean blackAndWhite) {
    this.blackAndWhite = blackAndWhite;
    setBlackAndWhiteIsSet(true);
    return this;
  }

  public void unsetBlackAndWhite() {
    __isset_bit_vector.clear(__BLACKANDWHITE_ISSET_ID);
  }

  /** Returns true if field blackAndWhite is set (has been assigned a value) and false otherwise */
  public boolean isSetBlackAndWhite() {
    return __isset_bit_vector.get(__BLACKANDWHITE_ISSET_ID);
  }

  public void setBlackAndWhiteIsSet(boolean value) {
    __isset_bit_vector.set(__BLACKANDWHITE_ISSET_ID, value);
  }

  public int getNumberOfCopies() {
    return this.numberOfCopies;
  }

  public PrintDocumentRequest setNumberOfCopies(int numberOfCopies) {
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

  public CloudPrintPageRange getPageSelection() {
    return this.pageSelection;
  }

  public PrintDocumentRequest setPageSelection(CloudPrintPageRange pageSelection) {
    this.pageSelection = pageSelection;
    return this;
  }

  public void unsetPageSelection() {
    this.pageSelection = null;
  }

  /** Returns true if field pageSelection is set (has been assigned a value) and false otherwise */
  public boolean isSetPageSelection() {
    return this.pageSelection != null;
  }

  public void setPageSelectionIsSet(boolean value) {
    if (!value) {
      this.pageSelection = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case DOCUMENT_ID:
      if (value == null) {
        unsetDocumentId();
      } else {
        setDocumentId((Long)value);
      }
      break;

    case DOUBLE_SIDED:
      if (value == null) {
        unsetDoubleSided();
      } else {
        setDoubleSided((Boolean)value);
      }
      break;

    case BLACK_AND_WHITE:
      if (value == null) {
        unsetBlackAndWhite();
      } else {
        setBlackAndWhite((Boolean)value);
      }
      break;

    case NUMBER_OF_COPIES:
      if (value == null) {
        unsetNumberOfCopies();
      } else {
        setNumberOfCopies((Integer)value);
      }
      break;

    case PAGE_SELECTION:
      if (value == null) {
        unsetPageSelection();
      } else {
        setPageSelection((CloudPrintPageRange)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case DOCUMENT_ID:
      return Long.valueOf(getDocumentId());

    case DOUBLE_SIDED:
      return Boolean.valueOf(isDoubleSided());

    case BLACK_AND_WHITE:
      return Boolean.valueOf(isBlackAndWhite());

    case NUMBER_OF_COPIES:
      return Integer.valueOf(getNumberOfCopies());

    case PAGE_SELECTION:
      return getPageSelection();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case DOCUMENT_ID:
      return isSetDocumentId();
    case DOUBLE_SIDED:
      return isSetDoubleSided();
    case BLACK_AND_WHITE:
      return isSetBlackAndWhite();
    case NUMBER_OF_COPIES:
      return isSetNumberOfCopies();
    case PAGE_SELECTION:
      return isSetPageSelection();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof PrintDocumentRequest)
      return this.equals((PrintDocumentRequest)that);
    return false;
  }

  public boolean equals(PrintDocumentRequest that) {
    if (that == null)
      return false;

    boolean this_present_documentId = true;
    boolean that_present_documentId = true;
    if (this_present_documentId || that_present_documentId) {
      if (!(this_present_documentId && that_present_documentId))
        return false;
      if (this.documentId != that.documentId)
        return false;
    }

    boolean this_present_doubleSided = true;
    boolean that_present_doubleSided = true;
    if (this_present_doubleSided || that_present_doubleSided) {
      if (!(this_present_doubleSided && that_present_doubleSided))
        return false;
      if (this.doubleSided != that.doubleSided)
        return false;
    }

    boolean this_present_blackAndWhite = true;
    boolean that_present_blackAndWhite = true;
    if (this_present_blackAndWhite || that_present_blackAndWhite) {
      if (!(this_present_blackAndWhite && that_present_blackAndWhite))
        return false;
      if (this.blackAndWhite != that.blackAndWhite)
        return false;
    }

    boolean this_present_numberOfCopies = true;
    boolean that_present_numberOfCopies = true;
    if (this_present_numberOfCopies || that_present_numberOfCopies) {
      if (!(this_present_numberOfCopies && that_present_numberOfCopies))
        return false;
      if (this.numberOfCopies != that.numberOfCopies)
        return false;
    }

    boolean this_present_pageSelection = true && this.isSetPageSelection();
    boolean that_present_pageSelection = true && that.isSetPageSelection();
    if (this_present_pageSelection || that_present_pageSelection) {
      if (!(this_present_pageSelection && that_present_pageSelection))
        return false;
      if (!this.pageSelection.equals(that.pageSelection))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_documentId = true;
    builder.append(present_documentId);
    if (present_documentId)
      builder.append(documentId);

    boolean present_doubleSided = true;
    builder.append(present_doubleSided);
    if (present_doubleSided)
      builder.append(doubleSided);

    boolean present_blackAndWhite = true;
    builder.append(present_blackAndWhite);
    if (present_blackAndWhite)
      builder.append(blackAndWhite);

    boolean present_numberOfCopies = true;
    builder.append(present_numberOfCopies);
    if (present_numberOfCopies)
      builder.append(numberOfCopies);

    boolean present_pageSelection = true && (isSetPageSelection());
    builder.append(present_pageSelection);
    if (present_pageSelection)
      builder.append(pageSelection);

    return builder.toHashCode();
  }

  public int compareTo(PrintDocumentRequest other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    PrintDocumentRequest typedOther = (PrintDocumentRequest)other;

    lastComparison = Boolean.valueOf(isSetDocumentId()).compareTo(typedOther.isSetDocumentId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDocumentId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.documentId, typedOther.documentId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetDoubleSided()).compareTo(typedOther.isSetDoubleSided());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDoubleSided()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.doubleSided, typedOther.doubleSided);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetBlackAndWhite()).compareTo(typedOther.isSetBlackAndWhite());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBlackAndWhite()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.blackAndWhite, typedOther.blackAndWhite);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
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
    lastComparison = Boolean.valueOf(isSetPageSelection()).compareTo(typedOther.isSetPageSelection());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPageSelection()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.pageSelection, typedOther.pageSelection);
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
        case 1: // DOCUMENT_ID
          if (field.type == org.apache.thrift.protocol.TType.I64) {
            this.documentId = iprot.readI64();
            setDocumentIdIsSet(true);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // DOUBLE_SIDED
          if (field.type == org.apache.thrift.protocol.TType.BOOL) {
            this.doubleSided = iprot.readBool();
            setDoubleSidedIsSet(true);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 3: // BLACK_AND_WHITE
          if (field.type == org.apache.thrift.protocol.TType.BOOL) {
            this.blackAndWhite = iprot.readBool();
            setBlackAndWhiteIsSet(true);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 4: // NUMBER_OF_COPIES
          if (field.type == org.apache.thrift.protocol.TType.I32) {
            this.numberOfCopies = iprot.readI32();
            setNumberOfCopiesIsSet(true);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 5: // PAGE_SELECTION
          if (field.type == org.apache.thrift.protocol.TType.STRUCT) {
            this.pageSelection = new CloudPrintPageRange();
            this.pageSelection.read(iprot);
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
    if (!isSetDocumentId()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'documentId' was not found in serialized data! Struct: " + toString());
    }
    if (!isSetDoubleSided()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'doubleSided' was not found in serialized data! Struct: " + toString());
    }
    if (!isSetBlackAndWhite()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'blackAndWhite' was not found in serialized data! Struct: " + toString());
    }
    if (!isSetNumberOfCopies()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'numberOfCopies' was not found in serialized data! Struct: " + toString());
    }
    validate();
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    validate();

    oprot.writeStructBegin(STRUCT_DESC);
    oprot.writeFieldBegin(DOCUMENT_ID_FIELD_DESC);
    oprot.writeI64(this.documentId);
    oprot.writeFieldEnd();
    oprot.writeFieldBegin(DOUBLE_SIDED_FIELD_DESC);
    oprot.writeBool(this.doubleSided);
    oprot.writeFieldEnd();
    oprot.writeFieldBegin(BLACK_AND_WHITE_FIELD_DESC);
    oprot.writeBool(this.blackAndWhite);
    oprot.writeFieldEnd();
    oprot.writeFieldBegin(NUMBER_OF_COPIES_FIELD_DESC);
    oprot.writeI32(this.numberOfCopies);
    oprot.writeFieldEnd();
    if (this.pageSelection != null) {
      if (isSetPageSelection()) {
        oprot.writeFieldBegin(PAGE_SELECTION_FIELD_DESC);
        this.pageSelection.write(oprot);
        oprot.writeFieldEnd();
      }
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("PrintDocumentRequest(");
    boolean first = true;

    sb.append("documentId:");
    sb.append(this.documentId);
    first = false;
    if (!first) sb.append(", ");
    sb.append("doubleSided:");
    sb.append(this.doubleSided);
    first = false;
    if (!first) sb.append(", ");
    sb.append("blackAndWhite:");
    sb.append(this.blackAndWhite);
    first = false;
    if (!first) sb.append(", ");
    sb.append("numberOfCopies:");
    sb.append(this.numberOfCopies);
    first = false;
    if (isSetPageSelection()) {
      if (!first) sb.append(", ");
      sb.append("pageSelection:");
      if (this.pageSelection == null) {
        sb.append("null");
      } else {
        sb.append(this.pageSelection);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // alas, we cannot check 'documentId' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'doubleSided' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'blackAndWhite' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'numberOfCopies' because it's a primitive and you chose the non-beans generator.
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
