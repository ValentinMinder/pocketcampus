/**
 * Autogenerated by Thrift Compiler (0.7.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package org.pocketcampus.plugin.edx.shared;

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

public class MsgPsgGetActiveRoomsResp implements org.apache.thrift.TBase<MsgPsgGetActiveRoomsResp, MsgPsgGetActiveRoomsResp._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("MsgPsgGetActiveRoomsResp");

  private static final org.apache.thrift.protocol.TField STATUS_FIELD_DESC = new org.apache.thrift.protocol.TField("status", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField ROOMS_FIELD_DESC = new org.apache.thrift.protocol.TField("rooms", org.apache.thrift.protocol.TType.LIST, (short)2);

  private int status; // required
  private List<MsgPsgRoom> rooms; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    STATUS((short)1, "status"),
    ROOMS((short)2, "rooms");

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
        case 1: // STATUS
          return STATUS;
        case 2: // ROOMS
          return ROOMS;
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
  private static final int __STATUS_ISSET_ID = 0;
  private BitSet __isset_bit_vector = new BitSet(1);

  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.STATUS, new org.apache.thrift.meta_data.FieldMetaData("status", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.ROOMS, new org.apache.thrift.meta_data.FieldMetaData("rooms", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, MsgPsgRoom.class))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(MsgPsgGetActiveRoomsResp.class, metaDataMap);
  }

  public MsgPsgGetActiveRoomsResp() {
  }

  public MsgPsgGetActiveRoomsResp(
    int status)
  {
    this();
    this.status = status;
    setStatusIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public MsgPsgGetActiveRoomsResp(MsgPsgGetActiveRoomsResp other) {
    __isset_bit_vector.clear();
    __isset_bit_vector.or(other.__isset_bit_vector);
    this.status = other.status;
    if (other.isSetRooms()) {
      List<MsgPsgRoom> __this__rooms = new ArrayList<MsgPsgRoom>();
      for (MsgPsgRoom other_element : other.rooms) {
        __this__rooms.add(new MsgPsgRoom(other_element));
      }
      this.rooms = __this__rooms;
    }
  }

  public MsgPsgGetActiveRoomsResp deepCopy() {
    return new MsgPsgGetActiveRoomsResp(this);
  }

  @Override
  public void clear() {
    setStatusIsSet(false);
    this.status = 0;
    this.rooms = null;
  }

  public int getStatus() {
    return this.status;
  }

  public MsgPsgGetActiveRoomsResp setStatus(int status) {
    this.status = status;
    setStatusIsSet(true);
    return this;
  }

  public void unsetStatus() {
    __isset_bit_vector.clear(__STATUS_ISSET_ID);
  }

  /** Returns true if field status is set (has been assigned a value) and false otherwise */
  public boolean isSetStatus() {
    return __isset_bit_vector.get(__STATUS_ISSET_ID);
  }

  public void setStatusIsSet(boolean value) {
    __isset_bit_vector.set(__STATUS_ISSET_ID, value);
  }

  public int getRoomsSize() {
    return (this.rooms == null) ? 0 : this.rooms.size();
  }

  public java.util.Iterator<MsgPsgRoom> getRoomsIterator() {
    return (this.rooms == null) ? null : this.rooms.iterator();
  }

  public void addToRooms(MsgPsgRoom elem) {
    if (this.rooms == null) {
      this.rooms = new ArrayList<MsgPsgRoom>();
    }
    this.rooms.add(elem);
  }

  public List<MsgPsgRoom> getRooms() {
    return this.rooms;
  }

  public MsgPsgGetActiveRoomsResp setRooms(List<MsgPsgRoom> rooms) {
    this.rooms = rooms;
    return this;
  }

  public void unsetRooms() {
    this.rooms = null;
  }

  /** Returns true if field rooms is set (has been assigned a value) and false otherwise */
  public boolean isSetRooms() {
    return this.rooms != null;
  }

  public void setRoomsIsSet(boolean value) {
    if (!value) {
      this.rooms = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case STATUS:
      if (value == null) {
        unsetStatus();
      } else {
        setStatus((Integer)value);
      }
      break;

    case ROOMS:
      if (value == null) {
        unsetRooms();
      } else {
        setRooms((List<MsgPsgRoom>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case STATUS:
      return Integer.valueOf(getStatus());

    case ROOMS:
      return getRooms();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case STATUS:
      return isSetStatus();
    case ROOMS:
      return isSetRooms();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof MsgPsgGetActiveRoomsResp)
      return this.equals((MsgPsgGetActiveRoomsResp)that);
    return false;
  }

  public boolean equals(MsgPsgGetActiveRoomsResp that) {
    if (that == null)
      return false;

    boolean this_present_status = true;
    boolean that_present_status = true;
    if (this_present_status || that_present_status) {
      if (!(this_present_status && that_present_status))
        return false;
      if (this.status != that.status)
        return false;
    }

    boolean this_present_rooms = true && this.isSetRooms();
    boolean that_present_rooms = true && that.isSetRooms();
    if (this_present_rooms || that_present_rooms) {
      if (!(this_present_rooms && that_present_rooms))
        return false;
      if (!this.rooms.equals(that.rooms))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_status = true;
    builder.append(present_status);
    if (present_status)
      builder.append(status);

    boolean present_rooms = true && (isSetRooms());
    builder.append(present_rooms);
    if (present_rooms)
      builder.append(rooms);

    return builder.toHashCode();
  }

  public int compareTo(MsgPsgGetActiveRoomsResp other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    MsgPsgGetActiveRoomsResp typedOther = (MsgPsgGetActiveRoomsResp)other;

    lastComparison = Boolean.valueOf(isSetStatus()).compareTo(typedOther.isSetStatus());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetStatus()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.status, typedOther.status);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetRooms()).compareTo(typedOther.isSetRooms());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRooms()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.rooms, typedOther.rooms);
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
        case 1: // STATUS
          if (field.type == org.apache.thrift.protocol.TType.I32) {
            this.status = iprot.readI32();
            setStatusIsSet(true);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // ROOMS
          if (field.type == org.apache.thrift.protocol.TType.LIST) {
            {
              org.apache.thrift.protocol.TList _list39 = iprot.readListBegin();
              this.rooms = new ArrayList<MsgPsgRoom>(_list39.size);
              for (int _i40 = 0; _i40 < _list39.size; ++_i40)
              {
                MsgPsgRoom _elem41; // required
                _elem41 = new MsgPsgRoom();
                _elem41.read(iprot);
                this.rooms.add(_elem41);
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
    if (!isSetStatus()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'status' was not found in serialized data! Struct: " + toString());
    }
    validate();
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    validate();

    oprot.writeStructBegin(STRUCT_DESC);
    oprot.writeFieldBegin(STATUS_FIELD_DESC);
    oprot.writeI32(this.status);
    oprot.writeFieldEnd();
    if (this.rooms != null) {
      if (isSetRooms()) {
        oprot.writeFieldBegin(ROOMS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, this.rooms.size()));
          for (MsgPsgRoom _iter42 : this.rooms)
          {
            _iter42.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("MsgPsgGetActiveRoomsResp(");
    boolean first = true;

    sb.append("status:");
    sb.append(this.status);
    first = false;
    if (isSetRooms()) {
      if (!first) sb.append(", ");
      sb.append("rooms:");
      if (this.rooms == null) {
        sb.append("null");
      } else {
        sb.append(this.rooms);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // alas, we cannot check 'status' because it's a primitive and you chose the non-beans generator.
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
