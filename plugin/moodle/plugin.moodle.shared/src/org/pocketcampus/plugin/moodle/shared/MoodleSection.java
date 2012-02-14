/**
 * Autogenerated by Thrift Compiler (0.7.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package org.pocketcampus.plugin.moodle.shared;

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

public class MoodleSection implements org.apache.thrift.TBase<MoodleSection, MoodleSection._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("MoodleSection");

  private static final org.apache.thrift.protocol.TField I_RESOURCES_FIELD_DESC = new org.apache.thrift.protocol.TField("iResources", org.apache.thrift.protocol.TType.LIST, (short)1);
  private static final org.apache.thrift.protocol.TField I_TEXT_FIELD_DESC = new org.apache.thrift.protocol.TField("iText", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField I_START_DATE_FIELD_DESC = new org.apache.thrift.protocol.TField("iStartDate", org.apache.thrift.protocol.TType.I64, (short)3);
  private static final org.apache.thrift.protocol.TField I_END_DATE_FIELD_DESC = new org.apache.thrift.protocol.TField("iEndDate", org.apache.thrift.protocol.TType.I64, (short)4);

  public List<MoodleResource> iResources; // required
  public String iText; // required
  public long iStartDate; // required
  public long iEndDate; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    I_RESOURCES((short)1, "iResources"),
    I_TEXT((short)2, "iText"),
    I_START_DATE((short)3, "iStartDate"),
    I_END_DATE((short)4, "iEndDate");

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
        case 1: // I_RESOURCES
          return I_RESOURCES;
        case 2: // I_TEXT
          return I_TEXT;
        case 3: // I_START_DATE
          return I_START_DATE;
        case 4: // I_END_DATE
          return I_END_DATE;
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
  private static final int __ISTARTDATE_ISSET_ID = 0;
  private static final int __IENDDATE_ISSET_ID = 1;
  private BitSet __isset_bit_vector = new BitSet(2);

  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.I_RESOURCES, new org.apache.thrift.meta_data.FieldMetaData("iResources", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, MoodleResource.class))));
    tmpMap.put(_Fields.I_TEXT, new org.apache.thrift.meta_data.FieldMetaData("iText", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.I_START_DATE, new org.apache.thrift.meta_data.FieldMetaData("iStartDate", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.I_END_DATE, new org.apache.thrift.meta_data.FieldMetaData("iEndDate", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(MoodleSection.class, metaDataMap);
  }

  public MoodleSection() {
  }

  public MoodleSection(
    List<MoodleResource> iResources,
    String iText)
  {
    this();
    this.iResources = iResources;
    this.iText = iText;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public MoodleSection(MoodleSection other) {
    __isset_bit_vector.clear();
    __isset_bit_vector.or(other.__isset_bit_vector);
    if (other.isSetIResources()) {
      List<MoodleResource> __this__iResources = new ArrayList<MoodleResource>();
      for (MoodleResource other_element : other.iResources) {
        __this__iResources.add(new MoodleResource(other_element));
      }
      this.iResources = __this__iResources;
    }
    if (other.isSetIText()) {
      this.iText = other.iText;
    }
    this.iStartDate = other.iStartDate;
    this.iEndDate = other.iEndDate;
  }

  public MoodleSection deepCopy() {
    return new MoodleSection(this);
  }

  @Override
  public void clear() {
    this.iResources = null;
    this.iText = null;
    setIStartDateIsSet(false);
    this.iStartDate = 0;
    setIEndDateIsSet(false);
    this.iEndDate = 0;
  }

  public int getIResourcesSize() {
    return (this.iResources == null) ? 0 : this.iResources.size();
  }

  public java.util.Iterator<MoodleResource> getIResourcesIterator() {
    return (this.iResources == null) ? null : this.iResources.iterator();
  }

  public void addToIResources(MoodleResource elem) {
    if (this.iResources == null) {
      this.iResources = new ArrayList<MoodleResource>();
    }
    this.iResources.add(elem);
  }

  public List<MoodleResource> getIResources() {
    return this.iResources;
  }

  public MoodleSection setIResources(List<MoodleResource> iResources) {
    this.iResources = iResources;
    return this;
  }

  public void unsetIResources() {
    this.iResources = null;
  }

  /** Returns true if field iResources is set (has been assigned a value) and false otherwise */
  public boolean isSetIResources() {
    return this.iResources != null;
  }

  public void setIResourcesIsSet(boolean value) {
    if (!value) {
      this.iResources = null;
    }
  }

  public String getIText() {
    return this.iText;
  }

  public MoodleSection setIText(String iText) {
    this.iText = iText;
    return this;
  }

  public void unsetIText() {
    this.iText = null;
  }

  /** Returns true if field iText is set (has been assigned a value) and false otherwise */
  public boolean isSetIText() {
    return this.iText != null;
  }

  public void setITextIsSet(boolean value) {
    if (!value) {
      this.iText = null;
    }
  }

  public long getIStartDate() {
    return this.iStartDate;
  }

  public MoodleSection setIStartDate(long iStartDate) {
    this.iStartDate = iStartDate;
    setIStartDateIsSet(true);
    return this;
  }

  public void unsetIStartDate() {
    __isset_bit_vector.clear(__ISTARTDATE_ISSET_ID);
  }

  /** Returns true if field iStartDate is set (has been assigned a value) and false otherwise */
  public boolean isSetIStartDate() {
    return __isset_bit_vector.get(__ISTARTDATE_ISSET_ID);
  }

  public void setIStartDateIsSet(boolean value) {
    __isset_bit_vector.set(__ISTARTDATE_ISSET_ID, value);
  }

  public long getIEndDate() {
    return this.iEndDate;
  }

  public MoodleSection setIEndDate(long iEndDate) {
    this.iEndDate = iEndDate;
    setIEndDateIsSet(true);
    return this;
  }

  public void unsetIEndDate() {
    __isset_bit_vector.clear(__IENDDATE_ISSET_ID);
  }

  /** Returns true if field iEndDate is set (has been assigned a value) and false otherwise */
  public boolean isSetIEndDate() {
    return __isset_bit_vector.get(__IENDDATE_ISSET_ID);
  }

  public void setIEndDateIsSet(boolean value) {
    __isset_bit_vector.set(__IENDDATE_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case I_RESOURCES:
      if (value == null) {
        unsetIResources();
      } else {
        setIResources((List<MoodleResource>)value);
      }
      break;

    case I_TEXT:
      if (value == null) {
        unsetIText();
      } else {
        setIText((String)value);
      }
      break;

    case I_START_DATE:
      if (value == null) {
        unsetIStartDate();
      } else {
        setIStartDate((Long)value);
      }
      break;

    case I_END_DATE:
      if (value == null) {
        unsetIEndDate();
      } else {
        setIEndDate((Long)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case I_RESOURCES:
      return getIResources();

    case I_TEXT:
      return getIText();

    case I_START_DATE:
      return Long.valueOf(getIStartDate());

    case I_END_DATE:
      return Long.valueOf(getIEndDate());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case I_RESOURCES:
      return isSetIResources();
    case I_TEXT:
      return isSetIText();
    case I_START_DATE:
      return isSetIStartDate();
    case I_END_DATE:
      return isSetIEndDate();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof MoodleSection)
      return this.equals((MoodleSection)that);
    return false;
  }

  public boolean equals(MoodleSection that) {
    if (that == null)
      return false;

    boolean this_present_iResources = true && this.isSetIResources();
    boolean that_present_iResources = true && that.isSetIResources();
    if (this_present_iResources || that_present_iResources) {
      if (!(this_present_iResources && that_present_iResources))
        return false;
      if (!this.iResources.equals(that.iResources))
        return false;
    }

    boolean this_present_iText = true && this.isSetIText();
    boolean that_present_iText = true && that.isSetIText();
    if (this_present_iText || that_present_iText) {
      if (!(this_present_iText && that_present_iText))
        return false;
      if (!this.iText.equals(that.iText))
        return false;
    }

    boolean this_present_iStartDate = true && this.isSetIStartDate();
    boolean that_present_iStartDate = true && that.isSetIStartDate();
    if (this_present_iStartDate || that_present_iStartDate) {
      if (!(this_present_iStartDate && that_present_iStartDate))
        return false;
      if (this.iStartDate != that.iStartDate)
        return false;
    }

    boolean this_present_iEndDate = true && this.isSetIEndDate();
    boolean that_present_iEndDate = true && that.isSetIEndDate();
    if (this_present_iEndDate || that_present_iEndDate) {
      if (!(this_present_iEndDate && that_present_iEndDate))
        return false;
      if (this.iEndDate != that.iEndDate)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_iResources = true && (isSetIResources());
    builder.append(present_iResources);
    if (present_iResources)
      builder.append(iResources);

    boolean present_iText = true && (isSetIText());
    builder.append(present_iText);
    if (present_iText)
      builder.append(iText);

    boolean present_iStartDate = true && (isSetIStartDate());
    builder.append(present_iStartDate);
    if (present_iStartDate)
      builder.append(iStartDate);

    boolean present_iEndDate = true && (isSetIEndDate());
    builder.append(present_iEndDate);
    if (present_iEndDate)
      builder.append(iEndDate);

    return builder.toHashCode();
  }

  public int compareTo(MoodleSection other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    MoodleSection typedOther = (MoodleSection)other;

    lastComparison = Boolean.valueOf(isSetIResources()).compareTo(typedOther.isSetIResources());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetIResources()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.iResources, typedOther.iResources);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetIText()).compareTo(typedOther.isSetIText());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetIText()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.iText, typedOther.iText);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetIStartDate()).compareTo(typedOther.isSetIStartDate());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetIStartDate()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.iStartDate, typedOther.iStartDate);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetIEndDate()).compareTo(typedOther.isSetIEndDate());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetIEndDate()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.iEndDate, typedOther.iEndDate);
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
        case 1: // I_RESOURCES
          if (field.type == org.apache.thrift.protocol.TType.LIST) {
            {
              org.apache.thrift.protocol.TList _list8 = iprot.readListBegin();
              this.iResources = new ArrayList<MoodleResource>(_list8.size);
              for (int _i9 = 0; _i9 < _list8.size; ++_i9)
              {
                MoodleResource _elem10; // required
                _elem10 = new MoodleResource();
                _elem10.read(iprot);
                this.iResources.add(_elem10);
              }
              iprot.readListEnd();
            }
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // I_TEXT
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.iText = iprot.readString();
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 3: // I_START_DATE
          if (field.type == org.apache.thrift.protocol.TType.I64) {
            this.iStartDate = iprot.readI64();
            setIStartDateIsSet(true);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 4: // I_END_DATE
          if (field.type == org.apache.thrift.protocol.TType.I64) {
            this.iEndDate = iprot.readI64();
            setIEndDateIsSet(true);
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
    if (this.iResources != null) {
      oprot.writeFieldBegin(I_RESOURCES_FIELD_DESC);
      {
        oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, this.iResources.size()));
        for (MoodleResource _iter11 : this.iResources)
        {
          _iter11.write(oprot);
        }
        oprot.writeListEnd();
      }
      oprot.writeFieldEnd();
    }
    if (this.iText != null) {
      oprot.writeFieldBegin(I_TEXT_FIELD_DESC);
      oprot.writeString(this.iText);
      oprot.writeFieldEnd();
    }
    if (isSetIStartDate()) {
      oprot.writeFieldBegin(I_START_DATE_FIELD_DESC);
      oprot.writeI64(this.iStartDate);
      oprot.writeFieldEnd();
    }
    if (isSetIEndDate()) {
      oprot.writeFieldBegin(I_END_DATE_FIELD_DESC);
      oprot.writeI64(this.iEndDate);
      oprot.writeFieldEnd();
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("MoodleSection(");
    boolean first = true;

    sb.append("iResources:");
    if (this.iResources == null) {
      sb.append("null");
    } else {
      sb.append(this.iResources);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("iText:");
    if (this.iText == null) {
      sb.append("null");
    } else {
      sb.append(this.iText);
    }
    first = false;
    if (isSetIStartDate()) {
      if (!first) sb.append(", ");
      sb.append("iStartDate:");
      sb.append(this.iStartDate);
      first = false;
    }
    if (isSetIEndDate()) {
      if (!first) sb.append(", ");
      sb.append("iEndDate:");
      sb.append(this.iEndDate);
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (iResources == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'iResources' was not present! Struct: " + toString());
    }
    if (iText == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'iText' was not present! Struct: " + toString());
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

