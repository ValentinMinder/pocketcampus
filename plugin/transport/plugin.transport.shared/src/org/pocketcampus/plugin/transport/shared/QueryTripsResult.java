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

public class QueryTripsResult implements org.apache.thrift.TBase<QueryTripsResult, QueryTripsResult._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("QueryTripsResult");

  private static final org.apache.thrift.protocol.TField FROM_FIELD_DESC = new org.apache.thrift.protocol.TField("from", org.apache.thrift.protocol.TType.STRUCT, (short)5);
  private static final org.apache.thrift.protocol.TField TO_FIELD_DESC = new org.apache.thrift.protocol.TField("to", org.apache.thrift.protocol.TType.STRUCT, (short)7);
  private static final org.apache.thrift.protocol.TField CONNECTIONS_FIELD_DESC = new org.apache.thrift.protocol.TField("connections", org.apache.thrift.protocol.TType.LIST, (short)9);

  private TransportStation from; // required
  private TransportStation to; // required
  private List<TransportTrip> connections; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    FROM((short)5, "from"),
    TO((short)7, "to"),
    CONNECTIONS((short)9, "connections");

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
        case 5: // FROM
          return FROM;
        case 7: // TO
          return TO;
        case 9: // CONNECTIONS
          return CONNECTIONS;
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
    tmpMap.put(_Fields.FROM, new org.apache.thrift.meta_data.FieldMetaData("from", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TransportStation.class)));
    tmpMap.put(_Fields.TO, new org.apache.thrift.meta_data.FieldMetaData("to", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TransportStation.class)));
    tmpMap.put(_Fields.CONNECTIONS, new org.apache.thrift.meta_data.FieldMetaData("connections", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TransportTrip.class))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(QueryTripsResult.class, metaDataMap);
  }

  public QueryTripsResult() {
  }

  public QueryTripsResult(
    TransportStation from,
    TransportStation to,
    List<TransportTrip> connections)
  {
    this();
    this.from = from;
    this.to = to;
    this.connections = connections;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public QueryTripsResult(QueryTripsResult other) {
    if (other.isSetFrom()) {
      this.from = new TransportStation(other.from);
    }
    if (other.isSetTo()) {
      this.to = new TransportStation(other.to);
    }
    if (other.isSetConnections()) {
      List<TransportTrip> __this__connections = new ArrayList<TransportTrip>();
      for (TransportTrip other_element : other.connections) {
        __this__connections.add(new TransportTrip(other_element));
      }
      this.connections = __this__connections;
    }
  }

  public QueryTripsResult deepCopy() {
    return new QueryTripsResult(this);
  }

  @Override
  public void clear() {
    this.from = null;
    this.to = null;
    this.connections = null;
  }

  public TransportStation getFrom() {
    return this.from;
  }

  public QueryTripsResult setFrom(TransportStation from) {
    this.from = from;
    return this;
  }

  public void unsetFrom() {
    this.from = null;
  }

  /** Returns true if field from is set (has been assigned a value) and false otherwise */
  public boolean isSetFrom() {
    return this.from != null;
  }

  public void setFromIsSet(boolean value) {
    if (!value) {
      this.from = null;
    }
  }

  public TransportStation getTo() {
    return this.to;
  }

  public QueryTripsResult setTo(TransportStation to) {
    this.to = to;
    return this;
  }

  public void unsetTo() {
    this.to = null;
  }

  /** Returns true if field to is set (has been assigned a value) and false otherwise */
  public boolean isSetTo() {
    return this.to != null;
  }

  public void setToIsSet(boolean value) {
    if (!value) {
      this.to = null;
    }
  }

  public int getConnectionsSize() {
    return (this.connections == null) ? 0 : this.connections.size();
  }

  public java.util.Iterator<TransportTrip> getConnectionsIterator() {
    return (this.connections == null) ? null : this.connections.iterator();
  }

  public void addToConnections(TransportTrip elem) {
    if (this.connections == null) {
      this.connections = new ArrayList<TransportTrip>();
    }
    this.connections.add(elem);
  }

  public List<TransportTrip> getConnections() {
    return this.connections;
  }

  public QueryTripsResult setConnections(List<TransportTrip> connections) {
    this.connections = connections;
    return this;
  }

  public void unsetConnections() {
    this.connections = null;
  }

  /** Returns true if field connections is set (has been assigned a value) and false otherwise */
  public boolean isSetConnections() {
    return this.connections != null;
  }

  public void setConnectionsIsSet(boolean value) {
    if (!value) {
      this.connections = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case FROM:
      if (value == null) {
        unsetFrom();
      } else {
        setFrom((TransportStation)value);
      }
      break;

    case TO:
      if (value == null) {
        unsetTo();
      } else {
        setTo((TransportStation)value);
      }
      break;

    case CONNECTIONS:
      if (value == null) {
        unsetConnections();
      } else {
        setConnections((List<TransportTrip>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case FROM:
      return getFrom();

    case TO:
      return getTo();

    case CONNECTIONS:
      return getConnections();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case FROM:
      return isSetFrom();
    case TO:
      return isSetTo();
    case CONNECTIONS:
      return isSetConnections();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof QueryTripsResult)
      return this.equals((QueryTripsResult)that);
    return false;
  }

  public boolean equals(QueryTripsResult that) {
    if (that == null)
      return false;

    boolean this_present_from = true && this.isSetFrom();
    boolean that_present_from = true && that.isSetFrom();
    if (this_present_from || that_present_from) {
      if (!(this_present_from && that_present_from))
        return false;
      if (!this.from.equals(that.from))
        return false;
    }

    boolean this_present_to = true && this.isSetTo();
    boolean that_present_to = true && that.isSetTo();
    if (this_present_to || that_present_to) {
      if (!(this_present_to && that_present_to))
        return false;
      if (!this.to.equals(that.to))
        return false;
    }

    boolean this_present_connections = true && this.isSetConnections();
    boolean that_present_connections = true && that.isSetConnections();
    if (this_present_connections || that_present_connections) {
      if (!(this_present_connections && that_present_connections))
        return false;
      if (!this.connections.equals(that.connections))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_from = true && (isSetFrom());
    builder.append(present_from);
    if (present_from)
      builder.append(from);

    boolean present_to = true && (isSetTo());
    builder.append(present_to);
    if (present_to)
      builder.append(to);

    boolean present_connections = true && (isSetConnections());
    builder.append(present_connections);
    if (present_connections)
      builder.append(connections);

    return builder.toHashCode();
  }

  public int compareTo(QueryTripsResult other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    QueryTripsResult typedOther = (QueryTripsResult)other;

    lastComparison = Boolean.valueOf(isSetFrom()).compareTo(typedOther.isSetFrom());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFrom()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.from, typedOther.from);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTo()).compareTo(typedOther.isSetTo());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTo()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.to, typedOther.to);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetConnections()).compareTo(typedOther.isSetConnections());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetConnections()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.connections, typedOther.connections);
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
        case 5: // FROM
          if (field.type == org.apache.thrift.protocol.TType.STRUCT) {
            this.from = new TransportStation();
            this.from.read(iprot);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 7: // TO
          if (field.type == org.apache.thrift.protocol.TType.STRUCT) {
            this.to = new TransportStation();
            this.to.read(iprot);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 9: // CONNECTIONS
          if (field.type == org.apache.thrift.protocol.TType.LIST) {
            {
              org.apache.thrift.protocol.TList _list8 = iprot.readListBegin();
              this.connections = new ArrayList<TransportTrip>(_list8.size);
              for (int _i9 = 0; _i9 < _list8.size; ++_i9)
              {
                TransportTrip _elem10; // required
                _elem10 = new TransportTrip();
                _elem10.read(iprot);
                this.connections.add(_elem10);
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
    if (this.from != null) {
      oprot.writeFieldBegin(FROM_FIELD_DESC);
      this.from.write(oprot);
      oprot.writeFieldEnd();
    }
    if (this.to != null) {
      oprot.writeFieldBegin(TO_FIELD_DESC);
      this.to.write(oprot);
      oprot.writeFieldEnd();
    }
    if (this.connections != null) {
      oprot.writeFieldBegin(CONNECTIONS_FIELD_DESC);
      {
        oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, this.connections.size()));
        for (TransportTrip _iter11 : this.connections)
        {
          _iter11.write(oprot);
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
    StringBuilder sb = new StringBuilder("QueryTripsResult(");
    boolean first = true;

    sb.append("from:");
    if (this.from == null) {
      sb.append("null");
    } else {
      sb.append(this.from);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("to:");
    if (this.to == null) {
      sb.append("null");
    } else {
      sb.append(this.to);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("connections:");
    if (this.connections == null) {
      sb.append("null");
    } else {
      sb.append(this.connections);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (from == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'from' was not present! Struct: " + toString());
    }
    if (to == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'to' was not present! Struct: " + toString());
    }
    if (connections == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'connections' was not present! Struct: " + toString());
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

