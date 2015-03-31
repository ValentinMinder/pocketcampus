/**
 * Autogenerated by Thrift Compiler (0.9.2)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.pocketcampus.plugin.moodle.shared;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
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
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.2)", date = "2014-11-28")
public class MoodleCourseSection2 implements org.apache.thrift.TBase<MoodleCourseSection2, MoodleCourseSection2._Fields>, java.io.Serializable, Cloneable, Comparable<MoodleCourseSection2> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("MoodleCourseSection2");

  private static final org.apache.thrift.protocol.TField RESOURCES_FIELD_DESC = new org.apache.thrift.protocol.TField("resources", org.apache.thrift.protocol.TType.LIST, (short)1);
  private static final org.apache.thrift.protocol.TField TITLE_FIELD_DESC = new org.apache.thrift.protocol.TField("title", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField START_DATE_FIELD_DESC = new org.apache.thrift.protocol.TField("startDate", org.apache.thrift.protocol.TType.I64, (short)3);
  private static final org.apache.thrift.protocol.TField END_DATE_FIELD_DESC = new org.apache.thrift.protocol.TField("endDate", org.apache.thrift.protocol.TType.I64, (short)4);
  private static final org.apache.thrift.protocol.TField DETAILS_FIELD_DESC = new org.apache.thrift.protocol.TField("details", org.apache.thrift.protocol.TType.STRING, (short)5);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new MoodleCourseSection2StandardSchemeFactory());
    schemes.put(TupleScheme.class, new MoodleCourseSection2TupleSchemeFactory());
  }

  private List<MoodleResource2> resources; // required
  private String title; // optional
  private long startDate; // optional
  private long endDate; // optional
  private String details; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    RESOURCES((short)1, "resources"),
    TITLE((short)2, "title"),
    START_DATE((short)3, "startDate"),
    END_DATE((short)4, "endDate"),
    DETAILS((short)5, "details");

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
        case 1: // RESOURCES
          return RESOURCES;
        case 2: // TITLE
          return TITLE;
        case 3: // START_DATE
          return START_DATE;
        case 4: // END_DATE
          return END_DATE;
        case 5: // DETAILS
          return DETAILS;
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
  private static final int __STARTDATE_ISSET_ID = 0;
  private static final int __ENDDATE_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.TITLE,_Fields.START_DATE,_Fields.END_DATE,_Fields.DETAILS};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.RESOURCES, new org.apache.thrift.meta_data.FieldMetaData("resources", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, MoodleResource2.class))));
    tmpMap.put(_Fields.TITLE, new org.apache.thrift.meta_data.FieldMetaData("title", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.START_DATE, new org.apache.thrift.meta_data.FieldMetaData("startDate", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.END_DATE, new org.apache.thrift.meta_data.FieldMetaData("endDate", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.DETAILS, new org.apache.thrift.meta_data.FieldMetaData("details", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(MoodleCourseSection2.class, metaDataMap);
  }

  public MoodleCourseSection2() {
  }

  public MoodleCourseSection2(
    List<MoodleResource2> resources)
  {
    this();
    this.resources = resources;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public MoodleCourseSection2(MoodleCourseSection2 other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetResources()) {
      List<MoodleResource2> __this__resources = new ArrayList<MoodleResource2>(other.resources.size());
      for (MoodleResource2 other_element : other.resources) {
        __this__resources.add(new MoodleResource2(other_element));
      }
      this.resources = __this__resources;
    }
    if (other.isSetTitle()) {
      this.title = other.title;
    }
    this.startDate = other.startDate;
    this.endDate = other.endDate;
    if (other.isSetDetails()) {
      this.details = other.details;
    }
  }

  public MoodleCourseSection2 deepCopy() {
    return new MoodleCourseSection2(this);
  }

  @Override
  public void clear() {
    this.resources = null;
    this.title = null;
    setStartDateIsSet(false);
    this.startDate = 0;
    setEndDateIsSet(false);
    this.endDate = 0;
    this.details = null;
  }

  public int getResourcesSize() {
    return (this.resources == null) ? 0 : this.resources.size();
  }

  public java.util.Iterator<MoodleResource2> getResourcesIterator() {
    return (this.resources == null) ? null : this.resources.iterator();
  }

  public void addToResources(MoodleResource2 elem) {
    if (this.resources == null) {
      this.resources = new ArrayList<MoodleResource2>();
    }
    this.resources.add(elem);
  }

  public List<MoodleResource2> getResources() {
    return this.resources;
  }

  public MoodleCourseSection2 setResources(List<MoodleResource2> resources) {
    this.resources = resources;
    return this;
  }

  public void unsetResources() {
    this.resources = null;
  }

  /** Returns true if field resources is set (has been assigned a value) and false otherwise */
  public boolean isSetResources() {
    return this.resources != null;
  }

  public void setResourcesIsSet(boolean value) {
    if (!value) {
      this.resources = null;
    }
  }

  public String getTitle() {
    return this.title;
  }

  public MoodleCourseSection2 setTitle(String title) {
    this.title = title;
    return this;
  }

  public void unsetTitle() {
    this.title = null;
  }

  /** Returns true if field title is set (has been assigned a value) and false otherwise */
  public boolean isSetTitle() {
    return this.title != null;
  }

  public void setTitleIsSet(boolean value) {
    if (!value) {
      this.title = null;
    }
  }

  public long getStartDate() {
    return this.startDate;
  }

  public MoodleCourseSection2 setStartDate(long startDate) {
    this.startDate = startDate;
    setStartDateIsSet(true);
    return this;
  }

  public void unsetStartDate() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __STARTDATE_ISSET_ID);
  }

  /** Returns true if field startDate is set (has been assigned a value) and false otherwise */
  public boolean isSetStartDate() {
    return EncodingUtils.testBit(__isset_bitfield, __STARTDATE_ISSET_ID);
  }

  public void setStartDateIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __STARTDATE_ISSET_ID, value);
  }

  public long getEndDate() {
    return this.endDate;
  }

  public MoodleCourseSection2 setEndDate(long endDate) {
    this.endDate = endDate;
    setEndDateIsSet(true);
    return this;
  }

  public void unsetEndDate() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __ENDDATE_ISSET_ID);
  }

  /** Returns true if field endDate is set (has been assigned a value) and false otherwise */
  public boolean isSetEndDate() {
    return EncodingUtils.testBit(__isset_bitfield, __ENDDATE_ISSET_ID);
  }

  public void setEndDateIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __ENDDATE_ISSET_ID, value);
  }

  public String getDetails() {
    return this.details;
  }

  public MoodleCourseSection2 setDetails(String details) {
    this.details = details;
    return this;
  }

  public void unsetDetails() {
    this.details = null;
  }

  /** Returns true if field details is set (has been assigned a value) and false otherwise */
  public boolean isSetDetails() {
    return this.details != null;
  }

  public void setDetailsIsSet(boolean value) {
    if (!value) {
      this.details = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case RESOURCES:
      if (value == null) {
        unsetResources();
      } else {
        setResources((List<MoodleResource2>)value);
      }
      break;

    case TITLE:
      if (value == null) {
        unsetTitle();
      } else {
        setTitle((String)value);
      }
      break;

    case START_DATE:
      if (value == null) {
        unsetStartDate();
      } else {
        setStartDate((Long)value);
      }
      break;

    case END_DATE:
      if (value == null) {
        unsetEndDate();
      } else {
        setEndDate((Long)value);
      }
      break;

    case DETAILS:
      if (value == null) {
        unsetDetails();
      } else {
        setDetails((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case RESOURCES:
      return getResources();

    case TITLE:
      return getTitle();

    case START_DATE:
      return Long.valueOf(getStartDate());

    case END_DATE:
      return Long.valueOf(getEndDate());

    case DETAILS:
      return getDetails();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case RESOURCES:
      return isSetResources();
    case TITLE:
      return isSetTitle();
    case START_DATE:
      return isSetStartDate();
    case END_DATE:
      return isSetEndDate();
    case DETAILS:
      return isSetDetails();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof MoodleCourseSection2)
      return this.equals((MoodleCourseSection2)that);
    return false;
  }

  public boolean equals(MoodleCourseSection2 that) {
    if (that == null)
      return false;

    boolean this_present_resources = true && this.isSetResources();
    boolean that_present_resources = true && that.isSetResources();
    if (this_present_resources || that_present_resources) {
      if (!(this_present_resources && that_present_resources))
        return false;
      if (!this.resources.equals(that.resources))
        return false;
    }

    boolean this_present_title = true && this.isSetTitle();
    boolean that_present_title = true && that.isSetTitle();
    if (this_present_title || that_present_title) {
      if (!(this_present_title && that_present_title))
        return false;
      if (!this.title.equals(that.title))
        return false;
    }

    boolean this_present_startDate = true && this.isSetStartDate();
    boolean that_present_startDate = true && that.isSetStartDate();
    if (this_present_startDate || that_present_startDate) {
      if (!(this_present_startDate && that_present_startDate))
        return false;
      if (this.startDate != that.startDate)
        return false;
    }

    boolean this_present_endDate = true && this.isSetEndDate();
    boolean that_present_endDate = true && that.isSetEndDate();
    if (this_present_endDate || that_present_endDate) {
      if (!(this_present_endDate && that_present_endDate))
        return false;
      if (this.endDate != that.endDate)
        return false;
    }

    boolean this_present_details = true && this.isSetDetails();
    boolean that_present_details = true && that.isSetDetails();
    if (this_present_details || that_present_details) {
      if (!(this_present_details && that_present_details))
        return false;
      if (!this.details.equals(that.details))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_resources = true && (isSetResources());
    list.add(present_resources);
    if (present_resources)
      list.add(resources);

    boolean present_title = true && (isSetTitle());
    list.add(present_title);
    if (present_title)
      list.add(title);

    boolean present_startDate = true && (isSetStartDate());
    list.add(present_startDate);
    if (present_startDate)
      list.add(startDate);

    boolean present_endDate = true && (isSetEndDate());
    list.add(present_endDate);
    if (present_endDate)
      list.add(endDate);

    boolean present_details = true && (isSetDetails());
    list.add(present_details);
    if (present_details)
      list.add(details);

    return list.hashCode();
  }

  @Override
  public int compareTo(MoodleCourseSection2 other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetResources()).compareTo(other.isSetResources());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetResources()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.resources, other.resources);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTitle()).compareTo(other.isSetTitle());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTitle()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.title, other.title);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetStartDate()).compareTo(other.isSetStartDate());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetStartDate()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.startDate, other.startDate);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetEndDate()).compareTo(other.isSetEndDate());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetEndDate()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.endDate, other.endDate);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetDetails()).compareTo(other.isSetDetails());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDetails()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.details, other.details);
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
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("MoodleCourseSection2(");
    boolean first = true;

    sb.append("resources:");
    if (this.resources == null) {
      sb.append("null");
    } else {
      sb.append(this.resources);
    }
    first = false;
    if (isSetTitle()) {
      if (!first) sb.append(", ");
      sb.append("title:");
      if (this.title == null) {
        sb.append("null");
      } else {
        sb.append(this.title);
      }
      first = false;
    }
    if (isSetStartDate()) {
      if (!first) sb.append(", ");
      sb.append("startDate:");
      sb.append(this.startDate);
      first = false;
    }
    if (isSetEndDate()) {
      if (!first) sb.append(", ");
      sb.append("endDate:");
      sb.append(this.endDate);
      first = false;
    }
    if (isSetDetails()) {
      if (!first) sb.append(", ");
      sb.append("details:");
      if (this.details == null) {
        sb.append("null");
      } else {
        sb.append(this.details);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (resources == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'resources' was not present! Struct: " + toString());
    }
    // check for sub-struct validity
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
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class MoodleCourseSection2StandardSchemeFactory implements SchemeFactory {
    public MoodleCourseSection2StandardScheme getScheme() {
      return new MoodleCourseSection2StandardScheme();
    }
  }

  private static class MoodleCourseSection2StandardScheme extends StandardScheme<MoodleCourseSection2> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, MoodleCourseSection2 struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // RESOURCES
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list32 = iprot.readListBegin();
                struct.resources = new ArrayList<MoodleResource2>(_list32.size);
                MoodleResource2 _elem33;
                for (int _i34 = 0; _i34 < _list32.size; ++_i34)
                {
                  _elem33 = new MoodleResource2();
                  _elem33.read(iprot);
                  struct.resources.add(_elem33);
                }
                iprot.readListEnd();
              }
              struct.setResourcesIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // TITLE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.title = iprot.readString();
              struct.setTitleIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // START_DATE
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.startDate = iprot.readI64();
              struct.setStartDateIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // END_DATE
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.endDate = iprot.readI64();
              struct.setEndDateIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // DETAILS
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.details = iprot.readString();
              struct.setDetailsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, MoodleCourseSection2 struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.resources != null) {
        oprot.writeFieldBegin(RESOURCES_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.resources.size()));
          for (MoodleResource2 _iter35 : struct.resources)
          {
            _iter35.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.title != null) {
        if (struct.isSetTitle()) {
          oprot.writeFieldBegin(TITLE_FIELD_DESC);
          oprot.writeString(struct.title);
          oprot.writeFieldEnd();
        }
      }
      if (struct.isSetStartDate()) {
        oprot.writeFieldBegin(START_DATE_FIELD_DESC);
        oprot.writeI64(struct.startDate);
        oprot.writeFieldEnd();
      }
      if (struct.isSetEndDate()) {
        oprot.writeFieldBegin(END_DATE_FIELD_DESC);
        oprot.writeI64(struct.endDate);
        oprot.writeFieldEnd();
      }
      if (struct.details != null) {
        if (struct.isSetDetails()) {
          oprot.writeFieldBegin(DETAILS_FIELD_DESC);
          oprot.writeString(struct.details);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class MoodleCourseSection2TupleSchemeFactory implements SchemeFactory {
    public MoodleCourseSection2TupleScheme getScheme() {
      return new MoodleCourseSection2TupleScheme();
    }
  }

  private static class MoodleCourseSection2TupleScheme extends TupleScheme<MoodleCourseSection2> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, MoodleCourseSection2 struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      {
        oprot.writeI32(struct.resources.size());
        for (MoodleResource2 _iter36 : struct.resources)
        {
          _iter36.write(oprot);
        }
      }
      BitSet optionals = new BitSet();
      if (struct.isSetTitle()) {
        optionals.set(0);
      }
      if (struct.isSetStartDate()) {
        optionals.set(1);
      }
      if (struct.isSetEndDate()) {
        optionals.set(2);
      }
      if (struct.isSetDetails()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetTitle()) {
        oprot.writeString(struct.title);
      }
      if (struct.isSetStartDate()) {
        oprot.writeI64(struct.startDate);
      }
      if (struct.isSetEndDate()) {
        oprot.writeI64(struct.endDate);
      }
      if (struct.isSetDetails()) {
        oprot.writeString(struct.details);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, MoodleCourseSection2 struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      {
        org.apache.thrift.protocol.TList _list37 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
        struct.resources = new ArrayList<MoodleResource2>(_list37.size);
        MoodleResource2 _elem38;
        for (int _i39 = 0; _i39 < _list37.size; ++_i39)
        {
          _elem38 = new MoodleResource2();
          _elem38.read(iprot);
          struct.resources.add(_elem38);
        }
      }
      struct.setResourcesIsSet(true);
      BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.title = iprot.readString();
        struct.setTitleIsSet(true);
      }
      if (incoming.get(1)) {
        struct.startDate = iprot.readI64();
        struct.setStartDateIsSet(true);
      }
      if (incoming.get(2)) {
        struct.endDate = iprot.readI64();
        struct.setEndDateIsSet(true);
      }
      if (incoming.get(3)) {
        struct.details = iprot.readString();
        struct.setDetailsIsSet(true);
      }
    }
  }

}
