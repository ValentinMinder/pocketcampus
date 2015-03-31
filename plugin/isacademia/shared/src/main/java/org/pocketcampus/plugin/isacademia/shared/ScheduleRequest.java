/**
 * Autogenerated by Thrift Compiler (0.9.2)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.pocketcampus.plugin.isacademia.shared;

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
public class ScheduleRequest implements org.apache.thrift.TBase<ScheduleRequest, ScheduleRequest._Fields>, java.io.Serializable, Cloneable, Comparable<ScheduleRequest> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ScheduleRequest");

  private static final org.apache.thrift.protocol.TField WEEK_START_FIELD_DESC = new org.apache.thrift.protocol.TField("weekStart", org.apache.thrift.protocol.TType.I64, (short)2);
  private static final org.apache.thrift.protocol.TField LANGUAGE_FIELD_DESC = new org.apache.thrift.protocol.TField("language", org.apache.thrift.protocol.TType.STRING, (short)3);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new ScheduleRequestStandardSchemeFactory());
    schemes.put(TupleScheme.class, new ScheduleRequestTupleSchemeFactory());
  }

  private long weekStart; // optional
  private String language; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    WEEK_START((short)2, "weekStart"),
    LANGUAGE((short)3, "language");

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
        case 2: // WEEK_START
          return WEEK_START;
        case 3: // LANGUAGE
          return LANGUAGE;
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
  private static final int __WEEKSTART_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.WEEK_START,_Fields.LANGUAGE};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.WEEK_START, new org.apache.thrift.meta_data.FieldMetaData("weekStart", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64        , "timestamp")));
    tmpMap.put(_Fields.LANGUAGE, new org.apache.thrift.meta_data.FieldMetaData("language", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ScheduleRequest.class, metaDataMap);
  }

  public ScheduleRequest() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ScheduleRequest(ScheduleRequest other) {
    __isset_bitfield = other.__isset_bitfield;
    this.weekStart = other.weekStart;
    if (other.isSetLanguage()) {
      this.language = other.language;
    }
  }

  public ScheduleRequest deepCopy() {
    return new ScheduleRequest(this);
  }

  @Override
  public void clear() {
    setWeekStartIsSet(false);
    this.weekStart = 0;
    this.language = null;
  }

  public long getWeekStart() {
    return this.weekStart;
  }

  public ScheduleRequest setWeekStart(long weekStart) {
    this.weekStart = weekStart;
    setWeekStartIsSet(true);
    return this;
  }

  public void unsetWeekStart() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __WEEKSTART_ISSET_ID);
  }

  /** Returns true if field weekStart is set (has been assigned a value) and false otherwise */
  public boolean isSetWeekStart() {
    return EncodingUtils.testBit(__isset_bitfield, __WEEKSTART_ISSET_ID);
  }

  public void setWeekStartIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __WEEKSTART_ISSET_ID, value);
  }

  public String getLanguage() {
    return this.language;
  }

  public ScheduleRequest setLanguage(String language) {
    this.language = language;
    return this;
  }

  public void unsetLanguage() {
    this.language = null;
  }

  /** Returns true if field language is set (has been assigned a value) and false otherwise */
  public boolean isSetLanguage() {
    return this.language != null;
  }

  public void setLanguageIsSet(boolean value) {
    if (!value) {
      this.language = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case WEEK_START:
      if (value == null) {
        unsetWeekStart();
      } else {
        setWeekStart((Long)value);
      }
      break;

    case LANGUAGE:
      if (value == null) {
        unsetLanguage();
      } else {
        setLanguage((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case WEEK_START:
      return Long.valueOf(getWeekStart());

    case LANGUAGE:
      return getLanguage();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case WEEK_START:
      return isSetWeekStart();
    case LANGUAGE:
      return isSetLanguage();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof ScheduleRequest)
      return this.equals((ScheduleRequest)that);
    return false;
  }

  public boolean equals(ScheduleRequest that) {
    if (that == null)
      return false;

    boolean this_present_weekStart = true && this.isSetWeekStart();
    boolean that_present_weekStart = true && that.isSetWeekStart();
    if (this_present_weekStart || that_present_weekStart) {
      if (!(this_present_weekStart && that_present_weekStart))
        return false;
      if (this.weekStart != that.weekStart)
        return false;
    }

    boolean this_present_language = true && this.isSetLanguage();
    boolean that_present_language = true && that.isSetLanguage();
    if (this_present_language || that_present_language) {
      if (!(this_present_language && that_present_language))
        return false;
      if (!this.language.equals(that.language))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_weekStart = true && (isSetWeekStart());
    list.add(present_weekStart);
    if (present_weekStart)
      list.add(weekStart);

    boolean present_language = true && (isSetLanguage());
    list.add(present_language);
    if (present_language)
      list.add(language);

    return list.hashCode();
  }

  @Override
  public int compareTo(ScheduleRequest other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetWeekStart()).compareTo(other.isSetWeekStart());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetWeekStart()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.weekStart, other.weekStart);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetLanguage()).compareTo(other.isSetLanguage());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLanguage()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.language, other.language);
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
    StringBuilder sb = new StringBuilder("ScheduleRequest(");
    boolean first = true;

    if (isSetWeekStart()) {
      sb.append("weekStart:");
      sb.append(this.weekStart);
      first = false;
    }
    if (isSetLanguage()) {
      if (!first) sb.append(", ");
      sb.append("language:");
      if (this.language == null) {
        sb.append("null");
      } else {
        sb.append(this.language);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
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

  private static class ScheduleRequestStandardSchemeFactory implements SchemeFactory {
    public ScheduleRequestStandardScheme getScheme() {
      return new ScheduleRequestStandardScheme();
    }
  }

  private static class ScheduleRequestStandardScheme extends StandardScheme<ScheduleRequest> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, ScheduleRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 2: // WEEK_START
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.weekStart = iprot.readI64();
              struct.setWeekStartIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // LANGUAGE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.language = iprot.readString();
              struct.setLanguageIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, ScheduleRequest struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.isSetWeekStart()) {
        oprot.writeFieldBegin(WEEK_START_FIELD_DESC);
        oprot.writeI64(struct.weekStart);
        oprot.writeFieldEnd();
      }
      if (struct.language != null) {
        if (struct.isSetLanguage()) {
          oprot.writeFieldBegin(LANGUAGE_FIELD_DESC);
          oprot.writeString(struct.language);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ScheduleRequestTupleSchemeFactory implements SchemeFactory {
    public ScheduleRequestTupleScheme getScheme() {
      return new ScheduleRequestTupleScheme();
    }
  }

  private static class ScheduleRequestTupleScheme extends TupleScheme<ScheduleRequest> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, ScheduleRequest struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetWeekStart()) {
        optionals.set(0);
      }
      if (struct.isSetLanguage()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetWeekStart()) {
        oprot.writeI64(struct.weekStart);
      }
      if (struct.isSetLanguage()) {
        oprot.writeString(struct.language);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, ScheduleRequest struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.weekStart = iprot.readI64();
        struct.setWeekStartIsSet(true);
      }
      if (incoming.get(1)) {
        struct.language = iprot.readString();
        struct.setLanguageIsSet(true);
      }
    }
  }

}
