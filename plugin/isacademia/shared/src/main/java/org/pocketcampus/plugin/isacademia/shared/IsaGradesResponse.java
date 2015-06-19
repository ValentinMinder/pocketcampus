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
@Generated(value = "Autogenerated by Thrift Compiler (0.9.2)", date = "2015-6-3")
public class IsaGradesResponse implements org.apache.thrift.TBase<IsaGradesResponse, IsaGradesResponse._Fields>, java.io.Serializable, Cloneable, Comparable<IsaGradesResponse> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("IsaGradesResponse");

  private static final org.apache.thrift.protocol.TField STATUS_CODE_FIELD_DESC = new org.apache.thrift.protocol.TField("statusCode", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField SEMESTERS_FIELD_DESC = new org.apache.thrift.protocol.TField("semesters", org.apache.thrift.protocol.TType.LIST, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new IsaGradesResponseStandardSchemeFactory());
    schemes.put(TupleScheme.class, new IsaGradesResponseTupleSchemeFactory());
  }

  private IsaStatusCode statusCode; // required
  private List<SemesterGrades> semesters; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    /**
     * 
     * @see IsaStatusCode
     */
    STATUS_CODE((short)1, "statusCode"),
    SEMESTERS((short)2, "semesters");

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
        case 2: // SEMESTERS
          return SEMESTERS;
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
  private static final _Fields optionals[] = {_Fields.SEMESTERS};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.STATUS_CODE, new org.apache.thrift.meta_data.FieldMetaData("statusCode", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, IsaStatusCode.class)));
    tmpMap.put(_Fields.SEMESTERS, new org.apache.thrift.meta_data.FieldMetaData("semesters", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, SemesterGrades.class))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(IsaGradesResponse.class, metaDataMap);
  }

  public IsaGradesResponse() {
  }

  public IsaGradesResponse(
    IsaStatusCode statusCode)
  {
    this();
    this.statusCode = statusCode;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public IsaGradesResponse(IsaGradesResponse other) {
    if (other.isSetStatusCode()) {
      this.statusCode = other.statusCode;
    }
    if (other.isSetSemesters()) {
      List<SemesterGrades> __this__semesters = new ArrayList<SemesterGrades>(other.semesters.size());
      for (SemesterGrades other_element : other.semesters) {
        __this__semesters.add(new SemesterGrades(other_element));
      }
      this.semesters = __this__semesters;
    }
  }

  public IsaGradesResponse deepCopy() {
    return new IsaGradesResponse(this);
  }

  @Override
  public void clear() {
    this.statusCode = null;
    this.semesters = null;
  }

  /**
   * 
   * @see IsaStatusCode
   */
  public IsaStatusCode getStatusCode() {
    return this.statusCode;
  }

  /**
   * 
   * @see IsaStatusCode
   */
  public IsaGradesResponse setStatusCode(IsaStatusCode statusCode) {
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

  public int getSemestersSize() {
    return (this.semesters == null) ? 0 : this.semesters.size();
  }

  public java.util.Iterator<SemesterGrades> getSemestersIterator() {
    return (this.semesters == null) ? null : this.semesters.iterator();
  }

  public void addToSemesters(SemesterGrades elem) {
    if (this.semesters == null) {
      this.semesters = new ArrayList<SemesterGrades>();
    }
    this.semesters.add(elem);
  }

  public List<SemesterGrades> getSemesters() {
    return this.semesters;
  }

  public IsaGradesResponse setSemesters(List<SemesterGrades> semesters) {
    this.semesters = semesters;
    return this;
  }

  public void unsetSemesters() {
    this.semesters = null;
  }

  /** Returns true if field semesters is set (has been assigned a value) and false otherwise */
  public boolean isSetSemesters() {
    return this.semesters != null;
  }

  public void setSemestersIsSet(boolean value) {
    if (!value) {
      this.semesters = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case STATUS_CODE:
      if (value == null) {
        unsetStatusCode();
      } else {
        setStatusCode((IsaStatusCode)value);
      }
      break;

    case SEMESTERS:
      if (value == null) {
        unsetSemesters();
      } else {
        setSemesters((List<SemesterGrades>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case STATUS_CODE:
      return getStatusCode();

    case SEMESTERS:
      return getSemesters();

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
    case SEMESTERS:
      return isSetSemesters();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof IsaGradesResponse)
      return this.equals((IsaGradesResponse)that);
    return false;
  }

  public boolean equals(IsaGradesResponse that) {
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

    boolean this_present_semesters = true && this.isSetSemesters();
    boolean that_present_semesters = true && that.isSetSemesters();
    if (this_present_semesters || that_present_semesters) {
      if (!(this_present_semesters && that_present_semesters))
        return false;
      if (!this.semesters.equals(that.semesters))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_statusCode = true && (isSetStatusCode());
    list.add(present_statusCode);
    if (present_statusCode)
      list.add(statusCode.getValue());

    boolean present_semesters = true && (isSetSemesters());
    list.add(present_semesters);
    if (present_semesters)
      list.add(semesters);

    return list.hashCode();
  }

  @Override
  public int compareTo(IsaGradesResponse other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetStatusCode()).compareTo(other.isSetStatusCode());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetStatusCode()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.statusCode, other.statusCode);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSemesters()).compareTo(other.isSetSemesters());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSemesters()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.semesters, other.semesters);
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
    StringBuilder sb = new StringBuilder("IsaGradesResponse(");
    boolean first = true;

    sb.append("statusCode:");
    if (this.statusCode == null) {
      sb.append("null");
    } else {
      sb.append(this.statusCode);
    }
    first = false;
    if (isSetSemesters()) {
      if (!first) sb.append(", ");
      sb.append("semesters:");
      if (this.semesters == null) {
        sb.append("null");
      } else {
        sb.append(this.semesters);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (statusCode == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'statusCode' was not present! Struct: " + toString());
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
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class IsaGradesResponseStandardSchemeFactory implements SchemeFactory {
    public IsaGradesResponseStandardScheme getScheme() {
      return new IsaGradesResponseStandardScheme();
    }
  }

  private static class IsaGradesResponseStandardScheme extends StandardScheme<IsaGradesResponse> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, IsaGradesResponse struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // STATUS_CODE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.statusCode = org.pocketcampus.plugin.isacademia.shared.IsaStatusCode.findByValue(iprot.readI32());
              struct.setStatusCodeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // SEMESTERS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list34 = iprot.readListBegin();
                struct.semesters = new ArrayList<SemesterGrades>(_list34.size);
                SemesterGrades _elem35;
                for (int _i36 = 0; _i36 < _list34.size; ++_i36)
                {
                  _elem35 = new SemesterGrades();
                  _elem35.read(iprot);
                  struct.semesters.add(_elem35);
                }
                iprot.readListEnd();
              }
              struct.setSemestersIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, IsaGradesResponse struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.statusCode != null) {
        oprot.writeFieldBegin(STATUS_CODE_FIELD_DESC);
        oprot.writeI32(struct.statusCode.getValue());
        oprot.writeFieldEnd();
      }
      if (struct.semesters != null) {
        if (struct.isSetSemesters()) {
          oprot.writeFieldBegin(SEMESTERS_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.semesters.size()));
            for (SemesterGrades _iter37 : struct.semesters)
            {
              _iter37.write(oprot);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class IsaGradesResponseTupleSchemeFactory implements SchemeFactory {
    public IsaGradesResponseTupleScheme getScheme() {
      return new IsaGradesResponseTupleScheme();
    }
  }

  private static class IsaGradesResponseTupleScheme extends TupleScheme<IsaGradesResponse> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, IsaGradesResponse struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeI32(struct.statusCode.getValue());
      BitSet optionals = new BitSet();
      if (struct.isSetSemesters()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetSemesters()) {
        {
          oprot.writeI32(struct.semesters.size());
          for (SemesterGrades _iter38 : struct.semesters)
          {
            _iter38.write(oprot);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, IsaGradesResponse struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.statusCode = org.pocketcampus.plugin.isacademia.shared.IsaStatusCode.findByValue(iprot.readI32());
      struct.setStatusCodeIsSet(true);
      BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TList _list39 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.semesters = new ArrayList<SemesterGrades>(_list39.size);
          SemesterGrades _elem40;
          for (int _i41 = 0; _i41 < _list39.size; ++_i41)
          {
            _elem40 = new SemesterGrades();
            _elem40.read(iprot);
            struct.semesters.add(_elem40);
          }
        }
        struct.setSemestersIsSet(true);
      }
    }
  }

}
