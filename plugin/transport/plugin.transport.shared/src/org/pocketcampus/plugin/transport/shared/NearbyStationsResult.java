/**
 * Autogenerated by Thrift Compiler (0.7.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package org.pocketcampus.plugin.transport.shared;

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

public class NearbyStationsResult implements org.apache.thrift.TBase<NearbyStationsResult, NearbyStationsResult._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("NearbyStationsResult");

  private static final org.apache.thrift.protocol.TField STATUS_FIELD_DESC = new org.apache.thrift.protocol.TField("status", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField STATIONS_FIELD_DESC = new org.apache.thrift.protocol.TField("stations", org.apache.thrift.protocol.TType.LIST, (short)2);

  /**
   * 
   * @see NearbyStatus
   */
  public NearbyStatus status; // required
  public List<TransportStation> stations; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    /**
     * 
     * @see NearbyStatus
     */
    STATUS((short)1, "status"),
    STATIONS((short)2, "stations");

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
        case 2: // STATIONS
          return STATIONS;
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
    tmpMap.put(_Fields.STATUS, new org.apache.thrift.meta_data.FieldMetaData("status", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, NearbyStatus.class)));
    tmpMap.put(_Fields.STATIONS, new org.apache.thrift.meta_data.FieldMetaData("stations", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TransportStation.class))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(NearbyStationsResult.class, metaDataMap);
  }

  public NearbyStationsResult() {
  }

  public NearbyStationsResult(
    NearbyStatus status,
    List<TransportStation> stations)
  {
    this();
    this.status = status;
    this.stations = stations;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public NearbyStationsResult(NearbyStationsResult other) {
    if (other.isSetStatus()) {
      this.status = other.status;
    }
    if (other.isSetStations()) {
      List<TransportStation> __this__stations = new ArrayList<TransportStation>();
      for (TransportStation other_element : other.stations) {
        __this__stations.add(new TransportStation(other_element));
      }
      this.stations = __this__stations;
    }
  }

  public NearbyStationsResult deepCopy() {
    return new NearbyStationsResult(this);
  }

  @Override
  public void clear() {
    this.status = null;
    this.stations = null;
  }

  /**
   * 
   * @see NearbyStatus
   */
  public NearbyStatus getStatus() {
    return this.status;
  }

  /**
   * 
   * @see NearbyStatus
   */
  public NearbyStationsResult setStatus(NearbyStatus status) {
    this.status = status;
    return this;
  }

  public void unsetStatus() {
    this.status = null;
  }

  /** Returns true if field status is set (has been assigned a value) and false otherwise */
  public boolean isSetStatus() {
    return this.status != null;
  }

  public void setStatusIsSet(boolean value) {
    if (!value) {
      this.status = null;
    }
  }

  public int getStationsSize() {
    return (this.stations == null) ? 0 : this.stations.size();
  }

  public java.util.Iterator<TransportStation> getStationsIterator() {
    return (this.stations == null) ? null : this.stations.iterator();
  }

  public void addToStations(TransportStation elem) {
    if (this.stations == null) {
      this.stations = new ArrayList<TransportStation>();
    }
    this.stations.add(elem);
  }

  public List<TransportStation> getStations() {
    return this.stations;
  }

  public NearbyStationsResult setStations(List<TransportStation> stations) {
    this.stations = stations;
    return this;
  }

  public void unsetStations() {
    this.stations = null;
  }

  /** Returns true if field stations is set (has been assigned a value) and false otherwise */
  public boolean isSetStations() {
    return this.stations != null;
  }

  public void setStationsIsSet(boolean value) {
    if (!value) {
      this.stations = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case STATUS:
      if (value == null) {
        unsetStatus();
      } else {
        setStatus((NearbyStatus)value);
      }
      break;

    case STATIONS:
      if (value == null) {
        unsetStations();
      } else {
        setStations((List<TransportStation>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case STATUS:
      return getStatus();

    case STATIONS:
      return getStations();

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
    case STATIONS:
      return isSetStations();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof NearbyStationsResult)
      return this.equals((NearbyStationsResult)that);
    return false;
  }

  public boolean equals(NearbyStationsResult that) {
    if (that == null)
      return false;

    boolean this_present_status = true && this.isSetStatus();
    boolean that_present_status = true && that.isSetStatus();
    if (this_present_status || that_present_status) {
      if (!(this_present_status && that_present_status))
        return false;
      if (!this.status.equals(that.status))
        return false;
    }

    boolean this_present_stations = true && this.isSetStations();
    boolean that_present_stations = true && that.isSetStations();
    if (this_present_stations || that_present_stations) {
      if (!(this_present_stations && that_present_stations))
        return false;
      if (!this.stations.equals(that.stations))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_status = true && (isSetStatus());
    builder.append(present_status);
    if (present_status)
      builder.append(status.getValue());

    boolean present_stations = true && (isSetStations());
    builder.append(present_stations);
    if (present_stations)
      builder.append(stations);

    return builder.toHashCode();
  }

  public int compareTo(NearbyStationsResult other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    NearbyStationsResult typedOther = (NearbyStationsResult)other;

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
    lastComparison = Boolean.valueOf(isSetStations()).compareTo(typedOther.isSetStations());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetStations()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.stations, typedOther.stations);
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
            this.status = NearbyStatus.findByValue(iprot.readI32());
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // STATIONS
          if (field.type == org.apache.thrift.protocol.TType.LIST) {
            {
              org.apache.thrift.protocol.TList _list28 = iprot.readListBegin();
              this.stations = new ArrayList<TransportStation>(_list28.size);
              for (int _i29 = 0; _i29 < _list28.size; ++_i29)
              {
                TransportStation _elem30; // required
                _elem30 = new TransportStation();
                _elem30.read(iprot);
                this.stations.add(_elem30);
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
    if (this.status != null) {
      oprot.writeFieldBegin(STATUS_FIELD_DESC);
      oprot.writeI32(this.status.getValue());
      oprot.writeFieldEnd();
    }
    if (this.stations != null) {
      oprot.writeFieldBegin(STATIONS_FIELD_DESC);
      {
        oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, this.stations.size()));
        for (TransportStation _iter31 : this.stations)
        {
          _iter31.write(oprot);
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
    StringBuilder sb = new StringBuilder("NearbyStationsResult(");
    boolean first = true;

    sb.append("status:");
    if (this.status == null) {
      sb.append("null");
    } else {
      sb.append(this.status);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("stations:");
    if (this.stations == null) {
      sb.append("null");
    } else {
      sb.append(this.stations);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (status == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'status' was not present! Struct: " + toString());
    }
    if (stations == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'stations' was not present! Struct: " + toString());
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

