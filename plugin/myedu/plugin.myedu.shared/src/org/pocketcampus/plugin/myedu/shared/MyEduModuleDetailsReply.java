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

public class MyEduModuleDetailsReply implements org.apache.thrift.TBase<MyEduModuleDetailsReply, MyEduModuleDetailsReply._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("MyEduModuleDetailsReply");

  private static final org.apache.thrift.protocol.TField I_MY_EDU_MATERIALS_FIELD_DESC = new org.apache.thrift.protocol.TField("iMyEduMaterials", org.apache.thrift.protocol.TType.LIST, (short)1);
  private static final org.apache.thrift.protocol.TField I_MY_EDU_RECORD_FIELD_DESC = new org.apache.thrift.protocol.TField("iMyEduRecord", org.apache.thrift.protocol.TType.STRUCT, (short)2);
  private static final org.apache.thrift.protocol.TField I_STATUS_FIELD_DESC = new org.apache.thrift.protocol.TField("iStatus", org.apache.thrift.protocol.TType.I32, (short)3);

  public List<MyEduMaterial> iMyEduMaterials; // required
  public MyEduModuleRecord iMyEduRecord; // required
  public int iStatus; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    I_MY_EDU_MATERIALS((short)1, "iMyEduMaterials"),
    I_MY_EDU_RECORD((short)2, "iMyEduRecord"),
    I_STATUS((short)3, "iStatus");

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
        case 1: // I_MY_EDU_MATERIALS
          return I_MY_EDU_MATERIALS;
        case 2: // I_MY_EDU_RECORD
          return I_MY_EDU_RECORD;
        case 3: // I_STATUS
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
    tmpMap.put(_Fields.I_MY_EDU_MATERIALS, new org.apache.thrift.meta_data.FieldMetaData("iMyEduMaterials", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, MyEduMaterial.class))));
    tmpMap.put(_Fields.I_MY_EDU_RECORD, new org.apache.thrift.meta_data.FieldMetaData("iMyEduRecord", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, MyEduModuleRecord.class)));
    tmpMap.put(_Fields.I_STATUS, new org.apache.thrift.meta_data.FieldMetaData("iStatus", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(MyEduModuleDetailsReply.class, metaDataMap);
  }

  public MyEduModuleDetailsReply() {
  }

  public MyEduModuleDetailsReply(
    int iStatus)
  {
    this();
    this.iStatus = iStatus;
    setIStatusIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public MyEduModuleDetailsReply(MyEduModuleDetailsReply other) {
    __isset_bit_vector.clear();
    __isset_bit_vector.or(other.__isset_bit_vector);
    if (other.isSetIMyEduMaterials()) {
      List<MyEduMaterial> __this__iMyEduMaterials = new ArrayList<MyEduMaterial>();
      for (MyEduMaterial other_element : other.iMyEduMaterials) {
        __this__iMyEduMaterials.add(new MyEduMaterial(other_element));
      }
      this.iMyEduMaterials = __this__iMyEduMaterials;
    }
    if (other.isSetIMyEduRecord()) {
      this.iMyEduRecord = new MyEduModuleRecord(other.iMyEduRecord);
    }
    this.iStatus = other.iStatus;
  }

  public MyEduModuleDetailsReply deepCopy() {
    return new MyEduModuleDetailsReply(this);
  }

  @Override
  public void clear() {
    this.iMyEduMaterials = null;
    this.iMyEduRecord = null;
    setIStatusIsSet(false);
    this.iStatus = 0;
  }

  public int getIMyEduMaterialsSize() {
    return (this.iMyEduMaterials == null) ? 0 : this.iMyEduMaterials.size();
  }

  public java.util.Iterator<MyEduMaterial> getIMyEduMaterialsIterator() {
    return (this.iMyEduMaterials == null) ? null : this.iMyEduMaterials.iterator();
  }

  public void addToIMyEduMaterials(MyEduMaterial elem) {
    if (this.iMyEduMaterials == null) {
      this.iMyEduMaterials = new ArrayList<MyEduMaterial>();
    }
    this.iMyEduMaterials.add(elem);
  }

  public List<MyEduMaterial> getIMyEduMaterials() {
    return this.iMyEduMaterials;
  }

  public MyEduModuleDetailsReply setIMyEduMaterials(List<MyEduMaterial> iMyEduMaterials) {
    this.iMyEduMaterials = iMyEduMaterials;
    return this;
  }

  public void unsetIMyEduMaterials() {
    this.iMyEduMaterials = null;
  }

  /** Returns true if field iMyEduMaterials is set (has been assigned a value) and false otherwise */
  public boolean isSetIMyEduMaterials() {
    return this.iMyEduMaterials != null;
  }

  public void setIMyEduMaterialsIsSet(boolean value) {
    if (!value) {
      this.iMyEduMaterials = null;
    }
  }

  public MyEduModuleRecord getIMyEduRecord() {
    return this.iMyEduRecord;
  }

  public MyEduModuleDetailsReply setIMyEduRecord(MyEduModuleRecord iMyEduRecord) {
    this.iMyEduRecord = iMyEduRecord;
    return this;
  }

  public void unsetIMyEduRecord() {
    this.iMyEduRecord = null;
  }

  /** Returns true if field iMyEduRecord is set (has been assigned a value) and false otherwise */
  public boolean isSetIMyEduRecord() {
    return this.iMyEduRecord != null;
  }

  public void setIMyEduRecordIsSet(boolean value) {
    if (!value) {
      this.iMyEduRecord = null;
    }
  }

  public int getIStatus() {
    return this.iStatus;
  }

  public MyEduModuleDetailsReply setIStatus(int iStatus) {
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
    case I_MY_EDU_MATERIALS:
      if (value == null) {
        unsetIMyEduMaterials();
      } else {
        setIMyEduMaterials((List<MyEduMaterial>)value);
      }
      break;

    case I_MY_EDU_RECORD:
      if (value == null) {
        unsetIMyEduRecord();
      } else {
        setIMyEduRecord((MyEduModuleRecord)value);
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
    case I_MY_EDU_MATERIALS:
      return getIMyEduMaterials();

    case I_MY_EDU_RECORD:
      return getIMyEduRecord();

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
    case I_MY_EDU_MATERIALS:
      return isSetIMyEduMaterials();
    case I_MY_EDU_RECORD:
      return isSetIMyEduRecord();
    case I_STATUS:
      return isSetIStatus();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof MyEduModuleDetailsReply)
      return this.equals((MyEduModuleDetailsReply)that);
    return false;
  }

  public boolean equals(MyEduModuleDetailsReply that) {
    if (that == null)
      return false;

    boolean this_present_iMyEduMaterials = true && this.isSetIMyEduMaterials();
    boolean that_present_iMyEduMaterials = true && that.isSetIMyEduMaterials();
    if (this_present_iMyEduMaterials || that_present_iMyEduMaterials) {
      if (!(this_present_iMyEduMaterials && that_present_iMyEduMaterials))
        return false;
      if (!this.iMyEduMaterials.equals(that.iMyEduMaterials))
        return false;
    }

    boolean this_present_iMyEduRecord = true && this.isSetIMyEduRecord();
    boolean that_present_iMyEduRecord = true && that.isSetIMyEduRecord();
    if (this_present_iMyEduRecord || that_present_iMyEduRecord) {
      if (!(this_present_iMyEduRecord && that_present_iMyEduRecord))
        return false;
      if (!this.iMyEduRecord.equals(that.iMyEduRecord))
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

    boolean present_iMyEduMaterials = true && (isSetIMyEduMaterials());
    builder.append(present_iMyEduMaterials);
    if (present_iMyEduMaterials)
      builder.append(iMyEduMaterials);

    boolean present_iMyEduRecord = true && (isSetIMyEduRecord());
    builder.append(present_iMyEduRecord);
    if (present_iMyEduRecord)
      builder.append(iMyEduRecord);

    boolean present_iStatus = true;
    builder.append(present_iStatus);
    if (present_iStatus)
      builder.append(iStatus);

    return builder.toHashCode();
  }

  public int compareTo(MyEduModuleDetailsReply other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    MyEduModuleDetailsReply typedOther = (MyEduModuleDetailsReply)other;

    lastComparison = Boolean.valueOf(isSetIMyEduMaterials()).compareTo(typedOther.isSetIMyEduMaterials());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetIMyEduMaterials()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.iMyEduMaterials, typedOther.iMyEduMaterials);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetIMyEduRecord()).compareTo(typedOther.isSetIMyEduRecord());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetIMyEduRecord()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.iMyEduRecord, typedOther.iMyEduRecord);
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
        case 1: // I_MY_EDU_MATERIALS
          if (field.type == org.apache.thrift.protocol.TType.LIST) {
            {
              org.apache.thrift.protocol.TList _list12 = iprot.readListBegin();
              this.iMyEduMaterials = new ArrayList<MyEduMaterial>(_list12.size);
              for (int _i13 = 0; _i13 < _list12.size; ++_i13)
              {
                MyEduMaterial _elem14; // required
                _elem14 = new MyEduMaterial();
                _elem14.read(iprot);
                this.iMyEduMaterials.add(_elem14);
              }
              iprot.readListEnd();
            }
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // I_MY_EDU_RECORD
          if (field.type == org.apache.thrift.protocol.TType.STRUCT) {
            this.iMyEduRecord = new MyEduModuleRecord();
            this.iMyEduRecord.read(iprot);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 3: // I_STATUS
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
    if (this.iMyEduMaterials != null) {
      if (isSetIMyEduMaterials()) {
        oprot.writeFieldBegin(I_MY_EDU_MATERIALS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, this.iMyEduMaterials.size()));
          for (MyEduMaterial _iter15 : this.iMyEduMaterials)
          {
            _iter15.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
    }
    if (this.iMyEduRecord != null) {
      if (isSetIMyEduRecord()) {
        oprot.writeFieldBegin(I_MY_EDU_RECORD_FIELD_DESC);
        this.iMyEduRecord.write(oprot);
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
    StringBuilder sb = new StringBuilder("MyEduModuleDetailsReply(");
    boolean first = true;

    if (isSetIMyEduMaterials()) {
      sb.append("iMyEduMaterials:");
      if (this.iMyEduMaterials == null) {
        sb.append("null");
      } else {
        sb.append(this.iMyEduMaterials);
      }
      first = false;
    }
    if (isSetIMyEduRecord()) {
      if (!first) sb.append(", ");
      sb.append("iMyEduRecord:");
      if (this.iMyEduRecord == null) {
        sb.append("null");
      } else {
        sb.append(this.iMyEduRecord);
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

