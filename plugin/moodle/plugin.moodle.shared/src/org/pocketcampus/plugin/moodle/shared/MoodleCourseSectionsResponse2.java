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

public class MoodleCourseSectionsResponse2 implements org.apache.thrift.TBase<MoodleCourseSectionsResponse2, MoodleCourseSectionsResponse2._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("MoodleCourseSectionsResponse2");

  private static final org.apache.thrift.protocol.TField STATUS_CODE_FIELD_DESC = new org.apache.thrift.protocol.TField("statusCode", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField SECTIONS_FIELD_DESC = new org.apache.thrift.protocol.TField("sections", org.apache.thrift.protocol.TType.LIST, (short)2);

  private MoodleStatusCode2 statusCode; // required
  private List<MoodleCourseSection2> sections; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    /**
     * 
     * @see MoodleStatusCode2
     */
    STATUS_CODE((short)1, "statusCode"),
    SECTIONS((short)2, "sections");

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
        case 2: // SECTIONS
          return SECTIONS;
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
    tmpMap.put(_Fields.STATUS_CODE, new org.apache.thrift.meta_data.FieldMetaData("statusCode", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, MoodleStatusCode2.class)));
    tmpMap.put(_Fields.SECTIONS, new org.apache.thrift.meta_data.FieldMetaData("sections", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, MoodleCourseSection2.class))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(MoodleCourseSectionsResponse2.class, metaDataMap);
  }

  public MoodleCourseSectionsResponse2() {
  }

  public MoodleCourseSectionsResponse2(
    MoodleStatusCode2 statusCode,
    List<MoodleCourseSection2> sections)
  {
    this();
    this.statusCode = statusCode;
    this.sections = sections;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public MoodleCourseSectionsResponse2(MoodleCourseSectionsResponse2 other) {
    if (other.isSetStatusCode()) {
      this.statusCode = other.statusCode;
    }
    if (other.isSetSections()) {
      List<MoodleCourseSection2> __this__sections = new ArrayList<MoodleCourseSection2>();
      for (MoodleCourseSection2 other_element : other.sections) {
        __this__sections.add(new MoodleCourseSection2(other_element));
      }
      this.sections = __this__sections;
    }
  }

  public MoodleCourseSectionsResponse2 deepCopy() {
    return new MoodleCourseSectionsResponse2(this);
  }

  @Override
  public void clear() {
    this.statusCode = null;
    this.sections = null;
  }

  /**
   * 
   * @see MoodleStatusCode2
   */
  public MoodleStatusCode2 getStatusCode() {
    return this.statusCode;
  }

  /**
   * 
   * @see MoodleStatusCode2
   */
  public MoodleCourseSectionsResponse2 setStatusCode(MoodleStatusCode2 statusCode) {
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

  public int getSectionsSize() {
    return (this.sections == null) ? 0 : this.sections.size();
  }

  public java.util.Iterator<MoodleCourseSection2> getSectionsIterator() {
    return (this.sections == null) ? null : this.sections.iterator();
  }

  public void addToSections(MoodleCourseSection2 elem) {
    if (this.sections == null) {
      this.sections = new ArrayList<MoodleCourseSection2>();
    }
    this.sections.add(elem);
  }

  public List<MoodleCourseSection2> getSections() {
    return this.sections;
  }

  public MoodleCourseSectionsResponse2 setSections(List<MoodleCourseSection2> sections) {
    this.sections = sections;
    return this;
  }

  public void unsetSections() {
    this.sections = null;
  }

  /** Returns true if field sections is set (has been assigned a value) and false otherwise */
  public boolean isSetSections() {
    return this.sections != null;
  }

  public void setSectionsIsSet(boolean value) {
    if (!value) {
      this.sections = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case STATUS_CODE:
      if (value == null) {
        unsetStatusCode();
      } else {
        setStatusCode((MoodleStatusCode2)value);
      }
      break;

    case SECTIONS:
      if (value == null) {
        unsetSections();
      } else {
        setSections((List<MoodleCourseSection2>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case STATUS_CODE:
      return getStatusCode();

    case SECTIONS:
      return getSections();

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
    case SECTIONS:
      return isSetSections();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof MoodleCourseSectionsResponse2)
      return this.equals((MoodleCourseSectionsResponse2)that);
    return false;
  }

  public boolean equals(MoodleCourseSectionsResponse2 that) {
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

    boolean this_present_sections = true && this.isSetSections();
    boolean that_present_sections = true && that.isSetSections();
    if (this_present_sections || that_present_sections) {
      if (!(this_present_sections && that_present_sections))
        return false;
      if (!this.sections.equals(that.sections))
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

    boolean present_sections = true && (isSetSections());
    builder.append(present_sections);
    if (present_sections)
      builder.append(sections);

    return builder.toHashCode();
  }

  public int compareTo(MoodleCourseSectionsResponse2 other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    MoodleCourseSectionsResponse2 typedOther = (MoodleCourseSectionsResponse2)other;

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
    lastComparison = Boolean.valueOf(isSetSections()).compareTo(typedOther.isSetSections());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSections()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.sections, typedOther.sections);
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
            this.statusCode = MoodleStatusCode2.findByValue(iprot.readI32());
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // SECTIONS
          if (field.type == org.apache.thrift.protocol.TType.LIST) {
            {
              org.apache.thrift.protocol.TList _list24 = iprot.readListBegin();
              this.sections = new ArrayList<MoodleCourseSection2>(_list24.size);
              for (int _i25 = 0; _i25 < _list24.size; ++_i25)
              {
                MoodleCourseSection2 _elem26; // required
                _elem26 = new MoodleCourseSection2();
                _elem26.read(iprot);
                this.sections.add(_elem26);
              }
              iprot.readListEnd();
            }
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
    if (this.sections != null) {
      oprot.writeFieldBegin(SECTIONS_FIELD_DESC);
      {
        oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, this.sections.size()));
        for (MoodleCourseSection2 _iter27 : this.sections)
        {
          _iter27.write(oprot);
        }
        oprot.writeListEnd();
      }
      oprot.writeFieldEnd();
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("MoodleCourseSectionsResponse2(");
    boolean first = true;

    sb.append("statusCode:");
    if (this.statusCode == null) {
      sb.append("null");
    } else {
      sb.append(this.statusCode);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("sections:");
    if (this.sections == null) {
      sb.append("null");
    } else {
      sb.append(this.sections);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (statusCode == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'statusCode' was not present! Struct: " + toString());
    }
    if (sections == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'sections' was not present! Struct: " + toString());
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

