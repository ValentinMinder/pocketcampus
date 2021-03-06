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

public class MsgPsgReceiveBroadcastReq implements org.apache.thrift.TBase<MsgPsgReceiveBroadcastReq, MsgPsgReceiveBroadcastReq._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("MsgPsgReceiveBroadcastReq");

  private static final org.apache.thrift.protocol.TField RECEIVER_REF_FIELD_DESC = new org.apache.thrift.protocol.TField("receiverRef", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField ROOM_REF_FIELD_DESC = new org.apache.thrift.protocol.TField("roomRef", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField LAST_MESSAGE_REF_FIELD_DESC = new org.apache.thrift.protocol.TField("lastMessageRef", org.apache.thrift.protocol.TType.I64, (short)3);
  private static final org.apache.thrift.protocol.TField PENDING_AUDIO_FIELD_DESC = new org.apache.thrift.protocol.TField("pendingAudio", org.apache.thrift.protocol.TType.I32, (short)4);

  private String receiverRef; // required
  private String roomRef; // required
  private long lastMessageRef; // required
  private int pendingAudio; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    RECEIVER_REF((short)1, "receiverRef"),
    ROOM_REF((short)2, "roomRef"),
    LAST_MESSAGE_REF((short)3, "lastMessageRef"),
    PENDING_AUDIO((short)4, "pendingAudio");

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
        case 1: // RECEIVER_REF
          return RECEIVER_REF;
        case 2: // ROOM_REF
          return ROOM_REF;
        case 3: // LAST_MESSAGE_REF
          return LAST_MESSAGE_REF;
        case 4: // PENDING_AUDIO
          return PENDING_AUDIO;
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
  private static final int __LASTMESSAGEREF_ISSET_ID = 0;
  private static final int __PENDINGAUDIO_ISSET_ID = 1;
  private BitSet __isset_bit_vector = new BitSet(2);

  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.RECEIVER_REF, new org.apache.thrift.meta_data.FieldMetaData("receiverRef", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.ROOM_REF, new org.apache.thrift.meta_data.FieldMetaData("roomRef", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.LAST_MESSAGE_REF, new org.apache.thrift.meta_data.FieldMetaData("lastMessageRef", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.PENDING_AUDIO, new org.apache.thrift.meta_data.FieldMetaData("pendingAudio", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(MsgPsgReceiveBroadcastReq.class, metaDataMap);
  }

  public MsgPsgReceiveBroadcastReq() {
  }

  public MsgPsgReceiveBroadcastReq(
    String receiverRef,
    String roomRef,
    long lastMessageRef,
    int pendingAudio)
  {
    this();
    this.receiverRef = receiverRef;
    this.roomRef = roomRef;
    this.lastMessageRef = lastMessageRef;
    setLastMessageRefIsSet(true);
    this.pendingAudio = pendingAudio;
    setPendingAudioIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public MsgPsgReceiveBroadcastReq(MsgPsgReceiveBroadcastReq other) {
    __isset_bit_vector.clear();
    __isset_bit_vector.or(other.__isset_bit_vector);
    if (other.isSetReceiverRef()) {
      this.receiverRef = other.receiverRef;
    }
    if (other.isSetRoomRef()) {
      this.roomRef = other.roomRef;
    }
    this.lastMessageRef = other.lastMessageRef;
    this.pendingAudio = other.pendingAudio;
  }

  public MsgPsgReceiveBroadcastReq deepCopy() {
    return new MsgPsgReceiveBroadcastReq(this);
  }

  @Override
  public void clear() {
    this.receiverRef = null;
    this.roomRef = null;
    setLastMessageRefIsSet(false);
    this.lastMessageRef = 0;
    setPendingAudioIsSet(false);
    this.pendingAudio = 0;
  }

  public String getReceiverRef() {
    return this.receiverRef;
  }

  public MsgPsgReceiveBroadcastReq setReceiverRef(String receiverRef) {
    this.receiverRef = receiverRef;
    return this;
  }

  public void unsetReceiverRef() {
    this.receiverRef = null;
  }

  /** Returns true if field receiverRef is set (has been assigned a value) and false otherwise */
  public boolean isSetReceiverRef() {
    return this.receiverRef != null;
  }

  public void setReceiverRefIsSet(boolean value) {
    if (!value) {
      this.receiverRef = null;
    }
  }

  public String getRoomRef() {
    return this.roomRef;
  }

  public MsgPsgReceiveBroadcastReq setRoomRef(String roomRef) {
    this.roomRef = roomRef;
    return this;
  }

  public void unsetRoomRef() {
    this.roomRef = null;
  }

  /** Returns true if field roomRef is set (has been assigned a value) and false otherwise */
  public boolean isSetRoomRef() {
    return this.roomRef != null;
  }

  public void setRoomRefIsSet(boolean value) {
    if (!value) {
      this.roomRef = null;
    }
  }

  public long getLastMessageRef() {
    return this.lastMessageRef;
  }

  public MsgPsgReceiveBroadcastReq setLastMessageRef(long lastMessageRef) {
    this.lastMessageRef = lastMessageRef;
    setLastMessageRefIsSet(true);
    return this;
  }

  public void unsetLastMessageRef() {
    __isset_bit_vector.clear(__LASTMESSAGEREF_ISSET_ID);
  }

  /** Returns true if field lastMessageRef is set (has been assigned a value) and false otherwise */
  public boolean isSetLastMessageRef() {
    return __isset_bit_vector.get(__LASTMESSAGEREF_ISSET_ID);
  }

  public void setLastMessageRefIsSet(boolean value) {
    __isset_bit_vector.set(__LASTMESSAGEREF_ISSET_ID, value);
  }

  public int getPendingAudio() {
    return this.pendingAudio;
  }

  public MsgPsgReceiveBroadcastReq setPendingAudio(int pendingAudio) {
    this.pendingAudio = pendingAudio;
    setPendingAudioIsSet(true);
    return this;
  }

  public void unsetPendingAudio() {
    __isset_bit_vector.clear(__PENDINGAUDIO_ISSET_ID);
  }

  /** Returns true if field pendingAudio is set (has been assigned a value) and false otherwise */
  public boolean isSetPendingAudio() {
    return __isset_bit_vector.get(__PENDINGAUDIO_ISSET_ID);
  }

  public void setPendingAudioIsSet(boolean value) {
    __isset_bit_vector.set(__PENDINGAUDIO_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case RECEIVER_REF:
      if (value == null) {
        unsetReceiverRef();
      } else {
        setReceiverRef((String)value);
      }
      break;

    case ROOM_REF:
      if (value == null) {
        unsetRoomRef();
      } else {
        setRoomRef((String)value);
      }
      break;

    case LAST_MESSAGE_REF:
      if (value == null) {
        unsetLastMessageRef();
      } else {
        setLastMessageRef((Long)value);
      }
      break;

    case PENDING_AUDIO:
      if (value == null) {
        unsetPendingAudio();
      } else {
        setPendingAudio((Integer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case RECEIVER_REF:
      return getReceiverRef();

    case ROOM_REF:
      return getRoomRef();

    case LAST_MESSAGE_REF:
      return Long.valueOf(getLastMessageRef());

    case PENDING_AUDIO:
      return Integer.valueOf(getPendingAudio());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case RECEIVER_REF:
      return isSetReceiverRef();
    case ROOM_REF:
      return isSetRoomRef();
    case LAST_MESSAGE_REF:
      return isSetLastMessageRef();
    case PENDING_AUDIO:
      return isSetPendingAudio();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof MsgPsgReceiveBroadcastReq)
      return this.equals((MsgPsgReceiveBroadcastReq)that);
    return false;
  }

  public boolean equals(MsgPsgReceiveBroadcastReq that) {
    if (that == null)
      return false;

    boolean this_present_receiverRef = true && this.isSetReceiverRef();
    boolean that_present_receiverRef = true && that.isSetReceiverRef();
    if (this_present_receiverRef || that_present_receiverRef) {
      if (!(this_present_receiverRef && that_present_receiverRef))
        return false;
      if (!this.receiverRef.equals(that.receiverRef))
        return false;
    }

    boolean this_present_roomRef = true && this.isSetRoomRef();
    boolean that_present_roomRef = true && that.isSetRoomRef();
    if (this_present_roomRef || that_present_roomRef) {
      if (!(this_present_roomRef && that_present_roomRef))
        return false;
      if (!this.roomRef.equals(that.roomRef))
        return false;
    }

    boolean this_present_lastMessageRef = true;
    boolean that_present_lastMessageRef = true;
    if (this_present_lastMessageRef || that_present_lastMessageRef) {
      if (!(this_present_lastMessageRef && that_present_lastMessageRef))
        return false;
      if (this.lastMessageRef != that.lastMessageRef)
        return false;
    }

    boolean this_present_pendingAudio = true;
    boolean that_present_pendingAudio = true;
    if (this_present_pendingAudio || that_present_pendingAudio) {
      if (!(this_present_pendingAudio && that_present_pendingAudio))
        return false;
      if (this.pendingAudio != that.pendingAudio)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_receiverRef = true && (isSetReceiverRef());
    builder.append(present_receiverRef);
    if (present_receiverRef)
      builder.append(receiverRef);

    boolean present_roomRef = true && (isSetRoomRef());
    builder.append(present_roomRef);
    if (present_roomRef)
      builder.append(roomRef);

    boolean present_lastMessageRef = true;
    builder.append(present_lastMessageRef);
    if (present_lastMessageRef)
      builder.append(lastMessageRef);

    boolean present_pendingAudio = true;
    builder.append(present_pendingAudio);
    if (present_pendingAudio)
      builder.append(pendingAudio);

    return builder.toHashCode();
  }

  public int compareTo(MsgPsgReceiveBroadcastReq other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    MsgPsgReceiveBroadcastReq typedOther = (MsgPsgReceiveBroadcastReq)other;

    lastComparison = Boolean.valueOf(isSetReceiverRef()).compareTo(typedOther.isSetReceiverRef());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetReceiverRef()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.receiverRef, typedOther.receiverRef);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetRoomRef()).compareTo(typedOther.isSetRoomRef());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRoomRef()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.roomRef, typedOther.roomRef);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetLastMessageRef()).compareTo(typedOther.isSetLastMessageRef());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLastMessageRef()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.lastMessageRef, typedOther.lastMessageRef);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPendingAudio()).compareTo(typedOther.isSetPendingAudio());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPendingAudio()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.pendingAudio, typedOther.pendingAudio);
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
        case 1: // RECEIVER_REF
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.receiverRef = iprot.readString();
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // ROOM_REF
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.roomRef = iprot.readString();
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 3: // LAST_MESSAGE_REF
          if (field.type == org.apache.thrift.protocol.TType.I64) {
            this.lastMessageRef = iprot.readI64();
            setLastMessageRefIsSet(true);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 4: // PENDING_AUDIO
          if (field.type == org.apache.thrift.protocol.TType.I32) {
            this.pendingAudio = iprot.readI32();
            setPendingAudioIsSet(true);
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
    if (!isSetLastMessageRef()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'lastMessageRef' was not found in serialized data! Struct: " + toString());
    }
    if (!isSetPendingAudio()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'pendingAudio' was not found in serialized data! Struct: " + toString());
    }
    validate();
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    validate();

    oprot.writeStructBegin(STRUCT_DESC);
    if (this.receiverRef != null) {
      oprot.writeFieldBegin(RECEIVER_REF_FIELD_DESC);
      oprot.writeString(this.receiverRef);
      oprot.writeFieldEnd();
    }
    if (this.roomRef != null) {
      oprot.writeFieldBegin(ROOM_REF_FIELD_DESC);
      oprot.writeString(this.roomRef);
      oprot.writeFieldEnd();
    }
    oprot.writeFieldBegin(LAST_MESSAGE_REF_FIELD_DESC);
    oprot.writeI64(this.lastMessageRef);
    oprot.writeFieldEnd();
    oprot.writeFieldBegin(PENDING_AUDIO_FIELD_DESC);
    oprot.writeI32(this.pendingAudio);
    oprot.writeFieldEnd();
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("MsgPsgReceiveBroadcastReq(");
    boolean first = true;

    sb.append("receiverRef:");
    if (this.receiverRef == null) {
      sb.append("null");
    } else {
      sb.append(this.receiverRef);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("roomRef:");
    if (this.roomRef == null) {
      sb.append("null");
    } else {
      sb.append(this.roomRef);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("lastMessageRef:");
    sb.append(this.lastMessageRef);
    first = false;
    if (!first) sb.append(", ");
    sb.append("pendingAudio:");
    sb.append(this.pendingAudio);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (receiverRef == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'receiverRef' was not present! Struct: " + toString());
    }
    if (roomRef == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'roomRef' was not present! Struct: " + toString());
    }
    // alas, we cannot check 'lastMessageRef' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'pendingAudio' because it's a primitive and you chose the non-beans generator.
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

