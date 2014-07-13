/**
 * Autogenerated by Thrift Compiler (0.7.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package org.pocketcampus.plugin.myedu.shared;

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

public class MyEduSubscribedCoursesListReply implements org.apache.thrift.TBase<MyEduSubscribedCoursesListReply, MyEduSubscribedCoursesListReply._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("MyEduSubscribedCoursesListReply");

  private static final org.apache.thrift.protocol.TField I_SUBSCRIBED_COURSES_FIELD_DESC = new org.apache.thrift.protocol.TField("iSubscribedCourses", org.apache.thrift.protocol.TType.LIST, (short)1);
  private static final org.apache.thrift.protocol.TField I_STATUS_FIELD_DESC = new org.apache.thrift.protocol.TField("iStatus", org.apache.thrift.protocol.TType.I32, (short)2);

  public List<MyEduCourse> iSubscribedCourses; // required
  public int iStatus; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    I_SUBSCRIBED_COURSES((short)1, "iSubscribedCourses"),
    I_STATUS((short)2, "iStatus");

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
        case 1: // I_SUBSCRIBED_COURSES
          return I_SUBSCRIBED_COURSES;
        case 2: // I_STATUS
          return I_STATUS;
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
  private static final int __ISTATUS_ISSET_ID = 0;
  private BitSet __isset_bit_vector = new BitSet(1);

  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.I_SUBSCRIBED_COURSES, new org.apache.thrift.meta_data.FieldMetaData("iSubscribedCourses", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, MyEduCourse.class))));
    tmpMap.put(_Fields.I_STATUS, new org.apache.thrift.meta_data.FieldMetaData("iStatus", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(MyEduSubscribedCoursesListReply.class, metaDataMap);
  }

  public MyEduSubscribedCoursesListReply() {
  }

  public MyEduSubscribedCoursesListReply(
    int iStatus)
  {
    this();
    this.iStatus = iStatus;
    setIStatusIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public MyEduSubscribedCoursesListReply(MyEduSubscribedCoursesListReply other) {
    __isset_bit_vector.clear();
    __isset_bit_vector.or(other.__isset_bit_vector);
    if (other.isSetISubscribedCourses()) {
      List<MyEduCourse> __this__iSubscribedCourses = new ArrayList<MyEduCourse>();
      for (MyEduCourse other_element : other.iSubscribedCourses) {
        __this__iSubscribedCourses.add(new MyEduCourse(other_element));
      }
      this.iSubscribedCourses = __this__iSubscribedCourses;
    }
    this.iStatus = other.iStatus;
  }

  public MyEduSubscribedCoursesListReply deepCopy() {
    return new MyEduSubscribedCoursesListReply(this);
  }

  @Override
  public void clear() {
    this.iSubscribedCourses = null;
    setIStatusIsSet(false);
    this.iStatus = 0;
  }

  public int getISubscribedCoursesSize() {
    return (this.iSubscribedCourses == null) ? 0 : this.iSubscribedCourses.size();
  }

  public java.util.Iterator<MyEduCourse> getISubscribedCoursesIterator() {
    return (this.iSubscribedCourses == null) ? null : this.iSubscribedCourses.iterator();
  }

  public void addToISubscribedCourses(MyEduCourse elem) {
    if (this.iSubscribedCourses == null) {
      this.iSubscribedCourses = new ArrayList<MyEduCourse>();
    }
    this.iSubscribedCourses.add(elem);
  }

  public List<MyEduCourse> getISubscribedCourses() {
    return this.iSubscribedCourses;
  }

  public MyEduSubscribedCoursesListReply setISubscribedCourses(List<MyEduCourse> iSubscribedCourses) {
    this.iSubscribedCourses = iSubscribedCourses;
    return this;
  }

  public void unsetISubscribedCourses() {
    this.iSubscribedCourses = null;
  }

  /** Returns true if field iSubscribedCourses is set (has been assigned a value) and false otherwise */
  public boolean isSetISubscribedCourses() {
    return this.iSubscribedCourses != null;
  }

  public void setISubscribedCoursesIsSet(boolean value) {
    if (!value) {
      this.iSubscribedCourses = null;
    }
  }

  public int getIStatus() {
    return this.iStatus;
  }

  public MyEduSubscribedCoursesListReply setIStatus(int iStatus) {
    this.iStatus = iStatus;
    setIStatusIsSet(true);
    return this;
  }

  public void unsetIStatus() {
    __isset_bit_vector.clear(__ISTATUS_ISSET_ID);
  }

  /** Returns true if field iStatus is set (has been assigned a value) and false otherwise */
  public boolean isSetIStatus() {
    return __isset_bit_vector.get(__ISTATUS_ISSET_ID);
  }

  public void setIStatusIsSet(boolean value) {
    __isset_bit_vector.set(__ISTATUS_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case I_SUBSCRIBED_COURSES:
      if (value == null) {
        unsetISubscribedCourses();
      } else {
        setISubscribedCourses((List<MyEduCourse>)value);
      }
      break;

    case I_STATUS:
      if (value == null) {
        unsetIStatus();
      } else {
        setIStatus((Integer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case I_SUBSCRIBED_COURSES:
      return getISubscribedCourses();

    case I_STATUS:
      return Integer.valueOf(getIStatus());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case I_SUBSCRIBED_COURSES:
      return isSetISubscribedCourses();
    case I_STATUS:
      return isSetIStatus();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof MyEduSubscribedCoursesListReply)
      return this.equals((MyEduSubscribedCoursesListReply)that);
    return false;
  }

  public boolean equals(MyEduSubscribedCoursesListReply that) {
    if (that == null)
      return false;

    boolean this_present_iSubscribedCourses = true && this.isSetISubscribedCourses();
    boolean that_present_iSubscribedCourses = true && that.isSetISubscribedCourses();
    if (this_present_iSubscribedCourses || that_present_iSubscribedCourses) {
      if (!(this_present_iSubscribedCourses && that_present_iSubscribedCourses))
        return false;
      if (!this.iSubscribedCourses.equals(that.iSubscribedCourses))
        return false;
    }

    boolean this_present_iStatus = true;
    boolean that_present_iStatus = true;
    if (this_present_iStatus || that_present_iStatus) {
      if (!(this_present_iStatus && that_present_iStatus))
        return false;
      if (this.iStatus != that.iStatus)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_iSubscribedCourses = true && (isSetISubscribedCourses());
    builder.append(present_iSubscribedCourses);
    if (present_iSubscribedCourses)
      builder.append(iSubscribedCourses);

    boolean present_iStatus = true;
    builder.append(present_iStatus);
    if (present_iStatus)
      builder.append(iStatus);

    return builder.toHashCode();
  }

  public int compareTo(MyEduSubscribedCoursesListReply other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    MyEduSubscribedCoursesListReply typedOther = (MyEduSubscribedCoursesListReply)other;

    lastComparison = Boolean.valueOf(isSetISubscribedCourses()).compareTo(typedOther.isSetISubscribedCourses());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetISubscribedCourses()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.iSubscribedCourses, typedOther.iSubscribedCourses);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetIStatus()).compareTo(typedOther.isSetIStatus());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetIStatus()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.iStatus, typedOther.iStatus);
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
        case 1: // I_SUBSCRIBED_COURSES
          if (field.type == org.apache.thrift.protocol.TType.LIST) {
            {
              org.apache.thrift.protocol.TList _list0 = iprot.readListBegin();
              this.iSubscribedCourses = new ArrayList<MyEduCourse>(_list0.size);
              for (int _i1 = 0; _i1 < _list0.size; ++_i1)
              {
                MyEduCourse _elem2; // required
                _elem2 = new MyEduCourse();
                _elem2.read(iprot);
                this.iSubscribedCourses.add(_elem2);
              }
              iprot.readListEnd();
            }
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // I_STATUS
          if (field.type == org.apache.thrift.protocol.TType.I32) {
            this.iStatus = iprot.readI32();
            setIStatusIsSet(true);
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
    if (!isSetIStatus()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'iStatus' was not found in serialized data! Struct: " + toString());
    }
    validate();
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    validate();

    oprot.writeStructBegin(STRUCT_DESC);
    if (this.iSubscribedCourses != null) {
      if (isSetISubscribedCourses()) {
        oprot.writeFieldBegin(I_SUBSCRIBED_COURSES_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, this.iSubscribedCourses.size()));
          for (MyEduCourse _iter3 : this.iSubscribedCourses)
          {
            _iter3.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
    }
    oprot.writeFieldBegin(I_STATUS_FIELD_DESC);
    oprot.writeI32(this.iStatus);
    oprot.writeFieldEnd();
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("MyEduSubscribedCoursesListReply(");
    boolean first = true;

    if (isSetISubscribedCourses()) {
      sb.append("iSubscribedCourses:");
      if (this.iSubscribedCourses == null) {
        sb.append("null");
      } else {
        sb.append(this.iSubscribedCourses);
      }
      first = false;
    }
    if (!first) sb.append(", ");
    sb.append("iStatus:");
    sb.append(this.iStatus);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // alas, we cannot check 'iStatus' because it's a primitive and you chose the non-beans generator.
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

