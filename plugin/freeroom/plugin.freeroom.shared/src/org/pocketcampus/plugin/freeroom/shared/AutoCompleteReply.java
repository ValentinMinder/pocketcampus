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

public class AutoCompleteReply implements org.apache.thrift.TBase<AutoCompleteReply, AutoCompleteReply._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("AutoCompleteReply");

  private static final org.apache.thrift.protocol.TField LIST_FRROOM_FIELD_DESC = new org.apache.thrift.protocol.TField("listFRRoom", org.apache.thrift.protocol.TType.LIST, (short)1);

  private List<FRRoom> listFRRoom; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    LIST_FRROOM((short)1, "listFRRoom");

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
        case 1: // LIST_FRROOM
          return LIST_FRROOM;
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
    tmpMap.put(_Fields.LIST_FRROOM, new org.apache.thrift.meta_data.FieldMetaData("listFRRoom", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, FRRoom.class))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(AutoCompleteReply.class, metaDataMap);
  }

  public AutoCompleteReply() {
  }

  public AutoCompleteReply(
    List<FRRoom> listFRRoom)
  {
    this();
    this.listFRRoom = listFRRoom;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public AutoCompleteReply(AutoCompleteReply other) {
    if (other.isSetListFRRoom()) {
      List<FRRoom> __this__listFRRoom = new ArrayList<FRRoom>();
      for (FRRoom other_element : other.listFRRoom) {
        __this__listFRRoom.add(new FRRoom(other_element));
      }
      this.listFRRoom = __this__listFRRoom;
    }
  }

  public AutoCompleteReply deepCopy() {
    return new AutoCompleteReply(this);
  }

  @Override
  public void clear() {
    this.listFRRoom = null;
  }

  public int getListFRRoomSize() {
    return (this.listFRRoom == null) ? 0 : this.listFRRoom.size();
  }

  public java.util.Iterator<FRRoom> getListFRRoomIterator() {
    return (this.listFRRoom == null) ? null : this.listFRRoom.iterator();
  }

  public void addToListFRRoom(FRRoom elem) {
    if (this.listFRRoom == null) {
      this.listFRRoom = new ArrayList<FRRoom>();
    }
    this.listFRRoom.add(elem);
  }

  public List<FRRoom> getListFRRoom() {
    return this.listFRRoom;
  }

  public AutoCompleteReply setListFRRoom(List<FRRoom> listFRRoom) {
    this.listFRRoom = listFRRoom;
    return this;
  }

  public void unsetListFRRoom() {
    this.listFRRoom = null;
  }

  /** Returns true if field listFRRoom is set (has been assigned a value) and false otherwise */
  public boolean isSetListFRRoom() {
    return this.listFRRoom != null;
  }

  public void setListFRRoomIsSet(boolean value) {
    if (!value) {
      this.listFRRoom = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case LIST_FRROOM:
      if (value == null) {
        unsetListFRRoom();
      } else {
        setListFRRoom((List<FRRoom>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case LIST_FRROOM:
      return getListFRRoom();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case LIST_FRROOM:
      return isSetListFRRoom();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof AutoCompleteReply)
      return this.equals((AutoCompleteReply)that);
    return false;
  }

  public boolean equals(AutoCompleteReply that) {
    if (that == null)
      return false;

    boolean this_present_listFRRoom = true && this.isSetListFRRoom();
    boolean that_present_listFRRoom = true && that.isSetListFRRoom();
    if (this_present_listFRRoom || that_present_listFRRoom) {
      if (!(this_present_listFRRoom && that_present_listFRRoom))
        return false;
      if (!this.listFRRoom.equals(that.listFRRoom))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_listFRRoom = true && (isSetListFRRoom());
    builder.append(present_listFRRoom);
    if (present_listFRRoom)
      builder.append(listFRRoom);

    return builder.toHashCode();
  }

  public int compareTo(AutoCompleteReply other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    AutoCompleteReply typedOther = (AutoCompleteReply)other;

    lastComparison = Boolean.valueOf(isSetListFRRoom()).compareTo(typedOther.isSetListFRRoom());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetListFRRoom()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.listFRRoom, typedOther.listFRRoom);
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
        case 1: // LIST_FRROOM
          if (field.type == org.apache.thrift.protocol.TType.LIST) {
            {
              org.apache.thrift.protocol.TList _list16 = iprot.readListBegin();
              this.listFRRoom = new ArrayList<FRRoom>(_list16.size);
              for (int _i17 = 0; _i17 < _list16.size; ++_i17)
              {
                FRRoom _elem18; // required
                _elem18 = new FRRoom();
                _elem18.read(iprot);
                this.listFRRoom.add(_elem18);
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
    if (this.listFRRoom != null) {
      oprot.writeFieldBegin(LIST_FRROOM_FIELD_DESC);
      {
        oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, this.listFRRoom.size()));
        for (FRRoom _iter19 : this.listFRRoom)
        {
          _iter19.write(oprot);
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
    StringBuilder sb = new StringBuilder("AutoCompleteReply(");
    boolean first = true;

    sb.append("listFRRoom:");
    if (this.listFRRoom == null) {
      sb.append("null");
    } else {
      sb.append(this.listFRRoom);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (listFRRoom == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'listFRRoom' was not present! Struct: " + toString());
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

