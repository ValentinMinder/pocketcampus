/**
 * Autogenerated by Thrift Compiler (0.7.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package org.pocketcampus.plugin.freeroom.shared;

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

public class Occupancy implements org.apache.thrift.TBase<Occupancy, Occupancy._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Occupancy");

  private static final org.apache.thrift.protocol.TField ROOM_FIELD_DESC = new org.apache.thrift.protocol.TField("room", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField OCCUPANCY_FIELD_DESC = new org.apache.thrift.protocol.TField("occupancy", org.apache.thrift.protocol.TType.LIST, (short)2);
  private static final org.apache.thrift.protocol.TField IS_AT_LEAST_OCCUPIED_ONCE_FIELD_DESC = new org.apache.thrift.protocol.TField("isAtLeastOccupiedOnce", org.apache.thrift.protocol.TType.BOOL, (short)3);
  private static final org.apache.thrift.protocol.TField IS_AT_LEAST_FREE_ONCE_FIELD_DESC = new org.apache.thrift.protocol.TField("isAtLeastFreeOnce", org.apache.thrift.protocol.TType.BOOL, (short)4);

  private FRRoom room; // required
  private List<ActualOccupation> occupancy; // required
  private boolean isAtLeastOccupiedOnce; // required
  private boolean isAtLeastFreeOnce; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ROOM((short)1, "room"),
    OCCUPANCY((short)2, "occupancy"),
    IS_AT_LEAST_OCCUPIED_ONCE((short)3, "isAtLeastOccupiedOnce"),
    IS_AT_LEAST_FREE_ONCE((short)4, "isAtLeastFreeOnce");

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
        case 1: // ROOM
          return ROOM;
        case 2: // OCCUPANCY
          return OCCUPANCY;
        case 3: // IS_AT_LEAST_OCCUPIED_ONCE
          return IS_AT_LEAST_OCCUPIED_ONCE;
        case 4: // IS_AT_LEAST_FREE_ONCE
          return IS_AT_LEAST_FREE_ONCE;
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
  private static final int __ISATLEASTOCCUPIEDONCE_ISSET_ID = 0;
  private static final int __ISATLEASTFREEONCE_ISSET_ID = 1;
  private BitSet __isset_bit_vector = new BitSet(2);

  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ROOM, new org.apache.thrift.meta_data.FieldMetaData("room", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, FRRoom.class)));
    tmpMap.put(_Fields.OCCUPANCY, new org.apache.thrift.meta_data.FieldMetaData("occupancy", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, ActualOccupation.class))));
    tmpMap.put(_Fields.IS_AT_LEAST_OCCUPIED_ONCE, new org.apache.thrift.meta_data.FieldMetaData("isAtLeastOccupiedOnce", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    tmpMap.put(_Fields.IS_AT_LEAST_FREE_ONCE, new org.apache.thrift.meta_data.FieldMetaData("isAtLeastFreeOnce", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Occupancy.class, metaDataMap);
  }

  public Occupancy() {
  }

  public Occupancy(
    FRRoom room,
    List<ActualOccupation> occupancy,
    boolean isAtLeastOccupiedOnce,
    boolean isAtLeastFreeOnce)
  {
    this();
    this.room = room;
    this.occupancy = occupancy;
    this.isAtLeastOccupiedOnce = isAtLeastOccupiedOnce;
    setIsAtLeastOccupiedOnceIsSet(true);
    this.isAtLeastFreeOnce = isAtLeastFreeOnce;
    setIsAtLeastFreeOnceIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Occupancy(Occupancy other) {
    __isset_bit_vector.clear();
    __isset_bit_vector.or(other.__isset_bit_vector);
    if (other.isSetRoom()) {
      this.room = new FRRoom(other.room);
    }
    if (other.isSetOccupancy()) {
      List<ActualOccupation> __this__occupancy = new ArrayList<ActualOccupation>();
      for (ActualOccupation other_element : other.occupancy) {
        __this__occupancy.add(new ActualOccupation(other_element));
      }
      this.occupancy = __this__occupancy;
    }
    this.isAtLeastOccupiedOnce = other.isAtLeastOccupiedOnce;
    this.isAtLeastFreeOnce = other.isAtLeastFreeOnce;
  }

  public Occupancy deepCopy() {
    return new Occupancy(this);
  }

  @Override
  public void clear() {
    this.room = null;
    this.occupancy = null;
    setIsAtLeastOccupiedOnceIsSet(false);
    this.isAtLeastOccupiedOnce = false;
    setIsAtLeastFreeOnceIsSet(false);
    this.isAtLeastFreeOnce = false;
  }

  public FRRoom getRoom() {
    return this.room;
  }

  public Occupancy setRoom(FRRoom room) {
    this.room = room;
    return this;
  }

  public void unsetRoom() {
    this.room = null;
  }

  /** Returns true if field room is set (has been assigned a value) and false otherwise */
  public boolean isSetRoom() {
    return this.room != null;
  }

  public void setRoomIsSet(boolean value) {
    if (!value) {
      this.room = null;
    }
  }

  public int getOccupancySize() {
    return (this.occupancy == null) ? 0 : this.occupancy.size();
  }

  public java.util.Iterator<ActualOccupation> getOccupancyIterator() {
    return (this.occupancy == null) ? null : this.occupancy.iterator();
  }

  public void addToOccupancy(ActualOccupation elem) {
    if (this.occupancy == null) {
      this.occupancy = new ArrayList<ActualOccupation>();
    }
    this.occupancy.add(elem);
  }

  public List<ActualOccupation> getOccupancy() {
    return this.occupancy;
  }

  public Occupancy setOccupancy(List<ActualOccupation> occupancy) {
    this.occupancy = occupancy;
    return this;
  }

  public void unsetOccupancy() {
    this.occupancy = null;
  }

  /** Returns true if field occupancy is set (has been assigned a value) and false otherwise */
  public boolean isSetOccupancy() {
    return this.occupancy != null;
  }

  public void setOccupancyIsSet(boolean value) {
    if (!value) {
      this.occupancy = null;
    }
  }

  public boolean isIsAtLeastOccupiedOnce() {
    return this.isAtLeastOccupiedOnce;
  }

  public Occupancy setIsAtLeastOccupiedOnce(boolean isAtLeastOccupiedOnce) {
    this.isAtLeastOccupiedOnce = isAtLeastOccupiedOnce;
    setIsAtLeastOccupiedOnceIsSet(true);
    return this;
  }

  public void unsetIsAtLeastOccupiedOnce() {
    __isset_bit_vector.clear(__ISATLEASTOCCUPIEDONCE_ISSET_ID);
  }

  /** Returns true if field isAtLeastOccupiedOnce is set (has been assigned a value) and false otherwise */
  public boolean isSetIsAtLeastOccupiedOnce() {
    return __isset_bit_vector.get(__ISATLEASTOCCUPIEDONCE_ISSET_ID);
  }

  public void setIsAtLeastOccupiedOnceIsSet(boolean value) {
    __isset_bit_vector.set(__ISATLEASTOCCUPIEDONCE_ISSET_ID, value);
  }

  public boolean isIsAtLeastFreeOnce() {
    return this.isAtLeastFreeOnce;
  }

  public Occupancy setIsAtLeastFreeOnce(boolean isAtLeastFreeOnce) {
    this.isAtLeastFreeOnce = isAtLeastFreeOnce;
    setIsAtLeastFreeOnceIsSet(true);
    return this;
  }

  public void unsetIsAtLeastFreeOnce() {
    __isset_bit_vector.clear(__ISATLEASTFREEONCE_ISSET_ID);
  }

  /** Returns true if field isAtLeastFreeOnce is set (has been assigned a value) and false otherwise */
  public boolean isSetIsAtLeastFreeOnce() {
    return __isset_bit_vector.get(__ISATLEASTFREEONCE_ISSET_ID);
  }

  public void setIsAtLeastFreeOnceIsSet(boolean value) {
    __isset_bit_vector.set(__ISATLEASTFREEONCE_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case ROOM:
      if (value == null) {
        unsetRoom();
      } else {
        setRoom((FRRoom)value);
      }
      break;

    case OCCUPANCY:
      if (value == null) {
        unsetOccupancy();
      } else {
        setOccupancy((List<ActualOccupation>)value);
      }
      break;

    case IS_AT_LEAST_OCCUPIED_ONCE:
      if (value == null) {
        unsetIsAtLeastOccupiedOnce();
      } else {
        setIsAtLeastOccupiedOnce((Boolean)value);
      }
      break;

    case IS_AT_LEAST_FREE_ONCE:
      if (value == null) {
        unsetIsAtLeastFreeOnce();
      } else {
        setIsAtLeastFreeOnce((Boolean)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case ROOM:
      return getRoom();

    case OCCUPANCY:
      return getOccupancy();

    case IS_AT_LEAST_OCCUPIED_ONCE:
      return Boolean.valueOf(isIsAtLeastOccupiedOnce());

    case IS_AT_LEAST_FREE_ONCE:
      return Boolean.valueOf(isIsAtLeastFreeOnce());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case ROOM:
      return isSetRoom();
    case OCCUPANCY:
      return isSetOccupancy();
    case IS_AT_LEAST_OCCUPIED_ONCE:
      return isSetIsAtLeastOccupiedOnce();
    case IS_AT_LEAST_FREE_ONCE:
      return isSetIsAtLeastFreeOnce();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Occupancy)
      return this.equals((Occupancy)that);
    return false;
  }

  public boolean equals(Occupancy that) {
    if (that == null)
      return false;

    boolean this_present_room = true && this.isSetRoom();
    boolean that_present_room = true && that.isSetRoom();
    if (this_present_room || that_present_room) {
      if (!(this_present_room && that_present_room))
        return false;
      if (!this.room.equals(that.room))
        return false;
    }

    boolean this_present_occupancy = true && this.isSetOccupancy();
    boolean that_present_occupancy = true && that.isSetOccupancy();
    if (this_present_occupancy || that_present_occupancy) {
      if (!(this_present_occupancy && that_present_occupancy))
        return false;
      if (!this.occupancy.equals(that.occupancy))
        return false;
    }

    boolean this_present_isAtLeastOccupiedOnce = true;
    boolean that_present_isAtLeastOccupiedOnce = true;
    if (this_present_isAtLeastOccupiedOnce || that_present_isAtLeastOccupiedOnce) {
      if (!(this_present_isAtLeastOccupiedOnce && that_present_isAtLeastOccupiedOnce))
        return false;
      if (this.isAtLeastOccupiedOnce != that.isAtLeastOccupiedOnce)
        return false;
    }

    boolean this_present_isAtLeastFreeOnce = true;
    boolean that_present_isAtLeastFreeOnce = true;
    if (this_present_isAtLeastFreeOnce || that_present_isAtLeastFreeOnce) {
      if (!(this_present_isAtLeastFreeOnce && that_present_isAtLeastFreeOnce))
        return false;
      if (this.isAtLeastFreeOnce != that.isAtLeastFreeOnce)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_room = true && (isSetRoom());
    builder.append(present_room);
    if (present_room)
      builder.append(room);

    boolean present_occupancy = true && (isSetOccupancy());
    builder.append(present_occupancy);
    if (present_occupancy)
      builder.append(occupancy);

    boolean present_isAtLeastOccupiedOnce = true;
    builder.append(present_isAtLeastOccupiedOnce);
    if (present_isAtLeastOccupiedOnce)
      builder.append(isAtLeastOccupiedOnce);

    boolean present_isAtLeastFreeOnce = true;
    builder.append(present_isAtLeastFreeOnce);
    if (present_isAtLeastFreeOnce)
      builder.append(isAtLeastFreeOnce);

    return builder.toHashCode();
  }

  public int compareTo(Occupancy other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    Occupancy typedOther = (Occupancy)other;

    lastComparison = Boolean.valueOf(isSetRoom()).compareTo(typedOther.isSetRoom());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRoom()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.room, typedOther.room);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetOccupancy()).compareTo(typedOther.isSetOccupancy());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetOccupancy()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.occupancy, typedOther.occupancy);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetIsAtLeastOccupiedOnce()).compareTo(typedOther.isSetIsAtLeastOccupiedOnce());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetIsAtLeastOccupiedOnce()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.isAtLeastOccupiedOnce, typedOther.isAtLeastOccupiedOnce);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetIsAtLeastFreeOnce()).compareTo(typedOther.isSetIsAtLeastFreeOnce());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetIsAtLeastFreeOnce()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.isAtLeastFreeOnce, typedOther.isAtLeastFreeOnce);
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
        case 1: // ROOM
          if (field.type == org.apache.thrift.protocol.TType.STRUCT) {
            this.room = new FRRoom();
            this.room.read(iprot);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // OCCUPANCY
          if (field.type == org.apache.thrift.protocol.TType.LIST) {
            {
              org.apache.thrift.protocol.TList _list8 = iprot.readListBegin();
              this.occupancy = new ArrayList<ActualOccupation>(_list8.size);
              for (int _i9 = 0; _i9 < _list8.size; ++_i9)
              {
                ActualOccupation _elem10; // required
                _elem10 = new ActualOccupation();
                _elem10.read(iprot);
                this.occupancy.add(_elem10);
              }
              iprot.readListEnd();
            }
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 3: // IS_AT_LEAST_OCCUPIED_ONCE
          if (field.type == org.apache.thrift.protocol.TType.BOOL) {
            this.isAtLeastOccupiedOnce = iprot.readBool();
            setIsAtLeastOccupiedOnceIsSet(true);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 4: // IS_AT_LEAST_FREE_ONCE
          if (field.type == org.apache.thrift.protocol.TType.BOOL) {
            this.isAtLeastFreeOnce = iprot.readBool();
            setIsAtLeastFreeOnceIsSet(true);
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
    if (!isSetIsAtLeastOccupiedOnce()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'isAtLeastOccupiedOnce' was not found in serialized data! Struct: " + toString());
    }
    if (!isSetIsAtLeastFreeOnce()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'isAtLeastFreeOnce' was not found in serialized data! Struct: " + toString());
    }
    validate();
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    validate();

    oprot.writeStructBegin(STRUCT_DESC);
    if (this.room != null) {
      oprot.writeFieldBegin(ROOM_FIELD_DESC);
      this.room.write(oprot);
      oprot.writeFieldEnd();
    }
    if (this.occupancy != null) {
      oprot.writeFieldBegin(OCCUPANCY_FIELD_DESC);
      {
        oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, this.occupancy.size()));
        for (ActualOccupation _iter11 : this.occupancy)
        {
          _iter11.write(oprot);
        }
        oprot.writeListEnd();
      }
      oprot.writeFieldEnd();
    }
    oprot.writeFieldBegin(IS_AT_LEAST_OCCUPIED_ONCE_FIELD_DESC);
    oprot.writeBool(this.isAtLeastOccupiedOnce);
    oprot.writeFieldEnd();
    oprot.writeFieldBegin(IS_AT_LEAST_FREE_ONCE_FIELD_DESC);
    oprot.writeBool(this.isAtLeastFreeOnce);
    oprot.writeFieldEnd();
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Occupancy(");
    boolean first = true;

    sb.append("room:");
    if (this.room == null) {
      sb.append("null");
    } else {
      sb.append(this.room);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("occupancy:");
    if (this.occupancy == null) {
      sb.append("null");
    } else {
      sb.append(this.occupancy);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("isAtLeastOccupiedOnce:");
    sb.append(this.isAtLeastOccupiedOnce);
    first = false;
    if (!first) sb.append(", ");
    sb.append("isAtLeastFreeOnce:");
    sb.append(this.isAtLeastFreeOnce);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (room == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'room' was not present! Struct: " + toString());
    }
    if (occupancy == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'occupancy' was not present! Struct: " + toString());
    }
    // alas, we cannot check 'isAtLeastOccupiedOnce' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'isAtLeastFreeOnce' because it's a primitive and you chose the non-beans generator.
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
