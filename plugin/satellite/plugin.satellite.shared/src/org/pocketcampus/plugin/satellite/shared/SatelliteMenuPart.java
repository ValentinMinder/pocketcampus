/**
 * Autogenerated by Thrift Compiler (0.7.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package org.pocketcampus.plugin.satellite.shared;

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

public class SatelliteMenuPart implements org.apache.thrift.TBase<SatelliteMenuPart, SatelliteMenuPart._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("SatelliteMenuPart");

  private static final org.apache.thrift.protocol.TField BEERS_OF_THE_MONTH_FIELD_DESC = new org.apache.thrift.protocol.TField("beersOfTheMonth", org.apache.thrift.protocol.TType.LIST, (short)1);
  private static final org.apache.thrift.protocol.TField BEERS_FIELD_DESC = new org.apache.thrift.protocol.TField("beers", org.apache.thrift.protocol.TType.MAP, (short)2);

  private List<SatelliteBeer> beersOfTheMonth; // required
  private Map<String,List<SatelliteBeer>> beers; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    BEERS_OF_THE_MONTH((short)1, "beersOfTheMonth"),
    BEERS((short)2, "beers");

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
        case 1: // BEERS_OF_THE_MONTH
          return BEERS_OF_THE_MONTH;
        case 2: // BEERS
          return BEERS;
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
    tmpMap.put(_Fields.BEERS_OF_THE_MONTH, new org.apache.thrift.meta_data.FieldMetaData("beersOfTheMonth", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, SatelliteBeer.class))));
    tmpMap.put(_Fields.BEERS, new org.apache.thrift.meta_data.FieldMetaData("beers", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.MapMetaData(org.apache.thrift.protocol.TType.MAP, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING), 
            new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
                new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, SatelliteBeer.class)))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(SatelliteMenuPart.class, metaDataMap);
  }

  public SatelliteMenuPart() {
  }

  public SatelliteMenuPart(
    List<SatelliteBeer> beersOfTheMonth,
    Map<String,List<SatelliteBeer>> beers)
  {
    this();
    this.beersOfTheMonth = beersOfTheMonth;
    this.beers = beers;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public SatelliteMenuPart(SatelliteMenuPart other) {
    if (other.isSetBeersOfTheMonth()) {
      List<SatelliteBeer> __this__beersOfTheMonth = new ArrayList<SatelliteBeer>();
      for (SatelliteBeer other_element : other.beersOfTheMonth) {
        __this__beersOfTheMonth.add(new SatelliteBeer(other_element));
      }
      this.beersOfTheMonth = __this__beersOfTheMonth;
    }
    if (other.isSetBeers()) {
      Map<String,List<SatelliteBeer>> __this__beers = new HashMap<String,List<SatelliteBeer>>();
      for (Map.Entry<String, List<SatelliteBeer>> other_element : other.beers.entrySet()) {

        String other_element_key = other_element.getKey();
        List<SatelliteBeer> other_element_value = other_element.getValue();

        String __this__beers_copy_key = other_element_key;

        List<SatelliteBeer> __this__beers_copy_value = new ArrayList<SatelliteBeer>();
        for (SatelliteBeer other_element_value_element : other_element_value) {
          __this__beers_copy_value.add(new SatelliteBeer(other_element_value_element));
        }

        __this__beers.put(__this__beers_copy_key, __this__beers_copy_value);
      }
      this.beers = __this__beers;
    }
  }

  public SatelliteMenuPart deepCopy() {
    return new SatelliteMenuPart(this);
  }

  @Override
  public void clear() {
    this.beersOfTheMonth = null;
    this.beers = null;
  }

  public int getBeersOfTheMonthSize() {
    return (this.beersOfTheMonth == null) ? 0 : this.beersOfTheMonth.size();
  }

  public java.util.Iterator<SatelliteBeer> getBeersOfTheMonthIterator() {
    return (this.beersOfTheMonth == null) ? null : this.beersOfTheMonth.iterator();
  }

  public void addToBeersOfTheMonth(SatelliteBeer elem) {
    if (this.beersOfTheMonth == null) {
      this.beersOfTheMonth = new ArrayList<SatelliteBeer>();
    }
    this.beersOfTheMonth.add(elem);
  }

  public List<SatelliteBeer> getBeersOfTheMonth() {
    return this.beersOfTheMonth;
  }

  public SatelliteMenuPart setBeersOfTheMonth(List<SatelliteBeer> beersOfTheMonth) {
    this.beersOfTheMonth = beersOfTheMonth;
    return this;
  }

  public void unsetBeersOfTheMonth() {
    this.beersOfTheMonth = null;
  }

  /** Returns true if field beersOfTheMonth is set (has been assigned a value) and false otherwise */
  public boolean isSetBeersOfTheMonth() {
    return this.beersOfTheMonth != null;
  }

  public void setBeersOfTheMonthIsSet(boolean value) {
    if (!value) {
      this.beersOfTheMonth = null;
    }
  }

  public int getBeersSize() {
    return (this.beers == null) ? 0 : this.beers.size();
  }

  public void putToBeers(String key, List<SatelliteBeer> val) {
    if (this.beers == null) {
      this.beers = new HashMap<String,List<SatelliteBeer>>();
    }
    this.beers.put(key, val);
  }

  public Map<String,List<SatelliteBeer>> getBeers() {
    return this.beers;
  }

  public SatelliteMenuPart setBeers(Map<String,List<SatelliteBeer>> beers) {
    this.beers = beers;
    return this;
  }

  public void unsetBeers() {
    this.beers = null;
  }

  /** Returns true if field beers is set (has been assigned a value) and false otherwise */
  public boolean isSetBeers() {
    return this.beers != null;
  }

  public void setBeersIsSet(boolean value) {
    if (!value) {
      this.beers = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case BEERS_OF_THE_MONTH:
      if (value == null) {
        unsetBeersOfTheMonth();
      } else {
        setBeersOfTheMonth((List<SatelliteBeer>)value);
      }
      break;

    case BEERS:
      if (value == null) {
        unsetBeers();
      } else {
        setBeers((Map<String,List<SatelliteBeer>>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case BEERS_OF_THE_MONTH:
      return getBeersOfTheMonth();

    case BEERS:
      return getBeers();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case BEERS_OF_THE_MONTH:
      return isSetBeersOfTheMonth();
    case BEERS:
      return isSetBeers();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof SatelliteMenuPart)
      return this.equals((SatelliteMenuPart)that);
    return false;
  }

  public boolean equals(SatelliteMenuPart that) {
    if (that == null)
      return false;

    boolean this_present_beersOfTheMonth = true && this.isSetBeersOfTheMonth();
    boolean that_present_beersOfTheMonth = true && that.isSetBeersOfTheMonth();
    if (this_present_beersOfTheMonth || that_present_beersOfTheMonth) {
      if (!(this_present_beersOfTheMonth && that_present_beersOfTheMonth))
        return false;
      if (!this.beersOfTheMonth.equals(that.beersOfTheMonth))
        return false;
    }

    boolean this_present_beers = true && this.isSetBeers();
    boolean that_present_beers = true && that.isSetBeers();
    if (this_present_beers || that_present_beers) {
      if (!(this_present_beers && that_present_beers))
        return false;
      if (!this.beers.equals(that.beers))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_beersOfTheMonth = true && (isSetBeersOfTheMonth());
    builder.append(present_beersOfTheMonth);
    if (present_beersOfTheMonth)
      builder.append(beersOfTheMonth);

    boolean present_beers = true && (isSetBeers());
    builder.append(present_beers);
    if (present_beers)
      builder.append(beers);

    return builder.toHashCode();
  }

  public int compareTo(SatelliteMenuPart other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    SatelliteMenuPart typedOther = (SatelliteMenuPart)other;

    lastComparison = Boolean.valueOf(isSetBeersOfTheMonth()).compareTo(typedOther.isSetBeersOfTheMonth());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBeersOfTheMonth()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.beersOfTheMonth, typedOther.beersOfTheMonth);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetBeers()).compareTo(typedOther.isSetBeers());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBeers()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.beers, typedOther.beers);
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
        case 1: // BEERS_OF_THE_MONTH
          if (field.type == org.apache.thrift.protocol.TType.LIST) {
            {
              org.apache.thrift.protocol.TList _list0 = iprot.readListBegin();
              this.beersOfTheMonth = new ArrayList<SatelliteBeer>(_list0.size);
              for (int _i1 = 0; _i1 < _list0.size; ++_i1)
              {
                SatelliteBeer _elem2; // required
                _elem2 = new SatelliteBeer();
                _elem2.read(iprot);
                this.beersOfTheMonth.add(_elem2);
              }
              iprot.readListEnd();
            }
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // BEERS
          if (field.type == org.apache.thrift.protocol.TType.MAP) {
            {
              org.apache.thrift.protocol.TMap _map3 = iprot.readMapBegin();
              this.beers = new HashMap<String,List<SatelliteBeer>>(2*_map3.size);
              for (int _i4 = 0; _i4 < _map3.size; ++_i4)
              {
                String _key5; // required
                List<SatelliteBeer> _val6; // required
                _key5 = iprot.readString();
                {
                  org.apache.thrift.protocol.TList _list7 = iprot.readListBegin();
                  _val6 = new ArrayList<SatelliteBeer>(_list7.size);
                  for (int _i8 = 0; _i8 < _list7.size; ++_i8)
                  {
                    SatelliteBeer _elem9; // required
                    _elem9 = new SatelliteBeer();
                    _elem9.read(iprot);
                    _val6.add(_elem9);
                  }
                  iprot.readListEnd();
                }
                this.beers.put(_key5, _val6);
              }
              iprot.readMapEnd();
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
    if (this.beersOfTheMonth != null) {
      oprot.writeFieldBegin(BEERS_OF_THE_MONTH_FIELD_DESC);
      {
        oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, this.beersOfTheMonth.size()));
        for (SatelliteBeer _iter10 : this.beersOfTheMonth)
        {
          _iter10.write(oprot);
        }
        oprot.writeListEnd();
      }
      oprot.writeFieldEnd();
    }
    if (this.beers != null) {
      oprot.writeFieldBegin(BEERS_FIELD_DESC);
      {
        oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.LIST, this.beers.size()));
        for (Map.Entry<String, List<SatelliteBeer>> _iter11 : this.beers.entrySet())
        {
          oprot.writeString(_iter11.getKey());
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, _iter11.getValue().size()));
            for (SatelliteBeer _iter12 : _iter11.getValue())
            {
              _iter12.write(oprot);
            }
            oprot.writeListEnd();
          }
        }
        oprot.writeMapEnd();
      }
      oprot.writeFieldEnd();
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("SatelliteMenuPart(");
    boolean first = true;

    sb.append("beersOfTheMonth:");
    if (this.beersOfTheMonth == null) {
      sb.append("null");
    } else {
      sb.append(this.beersOfTheMonth);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("beers:");
    if (this.beers == null) {
      sb.append("null");
    } else {
      sb.append(this.beers);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (beersOfTheMonth == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'beersOfTheMonth' was not present! Struct: " + toString());
    }
    if (beers == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'beers' was not present! Struct: " + toString());
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

