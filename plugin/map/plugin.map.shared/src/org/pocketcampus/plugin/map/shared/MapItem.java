/**
 * Autogenerated by Thrift Compiler (0.7.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package org.pocketcampus.plugin.map.shared;

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

public class MapItem implements org.apache.thrift.TBase<MapItem, MapItem._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("MapItem");

  private static final org.apache.thrift.protocol.TField TITLE_FIELD_DESC = new org.apache.thrift.protocol.TField("title", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField DESCRIPTION_FIELD_DESC = new org.apache.thrift.protocol.TField("description", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField LATITUDE_FIELD_DESC = new org.apache.thrift.protocol.TField("latitude", org.apache.thrift.protocol.TType.DOUBLE, (short)3);
  private static final org.apache.thrift.protocol.TField LONGITUDE_FIELD_DESC = new org.apache.thrift.protocol.TField("longitude", org.apache.thrift.protocol.TType.DOUBLE, (short)4);
  private static final org.apache.thrift.protocol.TField LAYER_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("layerId", org.apache.thrift.protocol.TType.I64, (short)5);
  private static final org.apache.thrift.protocol.TField ITEM_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("itemId", org.apache.thrift.protocol.TType.I64, (short)6);

  public String title; // required
  public String description; // required
  public double latitude; // required
  public double longitude; // required
  public long layerId; // required
  public long itemId; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    TITLE((short)1, "title"),
    DESCRIPTION((short)2, "description"),
    LATITUDE((short)3, "latitude"),
    LONGITUDE((short)4, "longitude"),
    LAYER_ID((short)5, "layerId"),
    ITEM_ID((short)6, "itemId");

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
        case 1: // TITLE
          return TITLE;
        case 2: // DESCRIPTION
          return DESCRIPTION;
        case 3: // LATITUDE
          return LATITUDE;
        case 4: // LONGITUDE
          return LONGITUDE;
        case 5: // LAYER_ID
          return LAYER_ID;
        case 6: // ITEM_ID
          return ITEM_ID;
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
  private static final int __LATITUDE_ISSET_ID = 0;
  private static final int __LONGITUDE_ISSET_ID = 1;
  private static final int __LAYERID_ISSET_ID = 2;
  private static final int __ITEMID_ISSET_ID = 3;
  private BitSet __isset_bit_vector = new BitSet(4);

  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.TITLE, new org.apache.thrift.meta_data.FieldMetaData("title", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.DESCRIPTION, new org.apache.thrift.meta_data.FieldMetaData("description", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.LATITUDE, new org.apache.thrift.meta_data.FieldMetaData("latitude", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.LONGITUDE, new org.apache.thrift.meta_data.FieldMetaData("longitude", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.LAYER_ID, new org.apache.thrift.meta_data.FieldMetaData("layerId", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64        , "Id")));
    tmpMap.put(_Fields.ITEM_ID, new org.apache.thrift.meta_data.FieldMetaData("itemId", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64        , "Id")));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(MapItem.class, metaDataMap);
  }

  public MapItem() {
  }

  public MapItem(
    String title,
    String description,
    double latitude,
    double longitude,
    long layerId,
    long itemId)
  {
    this();
    this.title = title;
    this.description = description;
    this.latitude = latitude;
    setLatitudeIsSet(true);
    this.longitude = longitude;
    setLongitudeIsSet(true);
    this.layerId = layerId;
    setLayerIdIsSet(true);
    this.itemId = itemId;
    setItemIdIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public MapItem(MapItem other) {
    __isset_bit_vector.clear();
    __isset_bit_vector.or(other.__isset_bit_vector);
    if (other.isSetTitle()) {
      this.title = other.title;
    }
    if (other.isSetDescription()) {
      this.description = other.description;
    }
    this.latitude = other.latitude;
    this.longitude = other.longitude;
    this.layerId = other.layerId;
    this.itemId = other.itemId;
  }

  public MapItem deepCopy() {
    return new MapItem(this);
  }

  @Override
  public void clear() {
    this.title = null;
    this.description = null;
    setLatitudeIsSet(false);
    this.latitude = 0.0;
    setLongitudeIsSet(false);
    this.longitude = 0.0;
    setLayerIdIsSet(false);
    this.layerId = 0;
    setItemIdIsSet(false);
    this.itemId = 0;
  }

  public String getTitle() {
    return this.title;
  }

  public MapItem setTitle(String title) {
    this.title = title;
    return this;
  }

  public void unsetTitle() {
    this.title = null;
  }

  /** Returns true if field title is set (has been assigned a value) and false otherwise */
  public boolean isSetTitle() {
    return this.title != null;
  }

  public void setTitleIsSet(boolean value) {
    if (!value) {
      this.title = null;
    }
  }

  public String getDescription() {
    return this.description;
  }

  public MapItem setDescription(String description) {
    this.description = description;
    return this;
  }

  public void unsetDescription() {
    this.description = null;
  }

  /** Returns true if field description is set (has been assigned a value) and false otherwise */
  public boolean isSetDescription() {
    return this.description != null;
  }

  public void setDescriptionIsSet(boolean value) {
    if (!value) {
      this.description = null;
    }
  }

  public double getLatitude() {
    return this.latitude;
  }

  public MapItem setLatitude(double latitude) {
    this.latitude = latitude;
    setLatitudeIsSet(true);
    return this;
  }

  public void unsetLatitude() {
    __isset_bit_vector.clear(__LATITUDE_ISSET_ID);
  }

  /** Returns true if field latitude is set (has been assigned a value) and false otherwise */
  public boolean isSetLatitude() {
    return __isset_bit_vector.get(__LATITUDE_ISSET_ID);
  }

  public void setLatitudeIsSet(boolean value) {
    __isset_bit_vector.set(__LATITUDE_ISSET_ID, value);
  }

  public double getLongitude() {
    return this.longitude;
  }

  public MapItem setLongitude(double longitude) {
    this.longitude = longitude;
    setLongitudeIsSet(true);
    return this;
  }

  public void unsetLongitude() {
    __isset_bit_vector.clear(__LONGITUDE_ISSET_ID);
  }

  /** Returns true if field longitude is set (has been assigned a value) and false otherwise */
  public boolean isSetLongitude() {
    return __isset_bit_vector.get(__LONGITUDE_ISSET_ID);
  }

  public void setLongitudeIsSet(boolean value) {
    __isset_bit_vector.set(__LONGITUDE_ISSET_ID, value);
  }

  public long getLayerId() {
    return this.layerId;
  }

  public MapItem setLayerId(long layerId) {
    this.layerId = layerId;
    setLayerIdIsSet(true);
    return this;
  }

  public void unsetLayerId() {
    __isset_bit_vector.clear(__LAYERID_ISSET_ID);
  }

  /** Returns true if field layerId is set (has been assigned a value) and false otherwise */
  public boolean isSetLayerId() {
    return __isset_bit_vector.get(__LAYERID_ISSET_ID);
  }

  public void setLayerIdIsSet(boolean value) {
    __isset_bit_vector.set(__LAYERID_ISSET_ID, value);
  }

  public long getItemId() {
    return this.itemId;
  }

  public MapItem setItemId(long itemId) {
    this.itemId = itemId;
    setItemIdIsSet(true);
    return this;
  }

  public void unsetItemId() {
    __isset_bit_vector.clear(__ITEMID_ISSET_ID);
  }

  /** Returns true if field itemId is set (has been assigned a value) and false otherwise */
  public boolean isSetItemId() {
    return __isset_bit_vector.get(__ITEMID_ISSET_ID);
  }

  public void setItemIdIsSet(boolean value) {
    __isset_bit_vector.set(__ITEMID_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case TITLE:
      if (value == null) {
        unsetTitle();
      } else {
        setTitle((String)value);
      }
      break;

    case DESCRIPTION:
      if (value == null) {
        unsetDescription();
      } else {
        setDescription((String)value);
      }
      break;

    case LATITUDE:
      if (value == null) {
        unsetLatitude();
      } else {
        setLatitude((Double)value);
      }
      break;

    case LONGITUDE:
      if (value == null) {
        unsetLongitude();
      } else {
        setLongitude((Double)value);
      }
      break;

    case LAYER_ID:
      if (value == null) {
        unsetLayerId();
      } else {
        setLayerId((Long)value);
      }
      break;

    case ITEM_ID:
      if (value == null) {
        unsetItemId();
      } else {
        setItemId((Long)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case TITLE:
      return getTitle();

    case DESCRIPTION:
      return getDescription();

    case LATITUDE:
      return Double.valueOf(getLatitude());

    case LONGITUDE:
      return Double.valueOf(getLongitude());

    case LAYER_ID:
      return Long.valueOf(getLayerId());

    case ITEM_ID:
      return Long.valueOf(getItemId());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case TITLE:
      return isSetTitle();
    case DESCRIPTION:
      return isSetDescription();
    case LATITUDE:
      return isSetLatitude();
    case LONGITUDE:
      return isSetLongitude();
    case LAYER_ID:
      return isSetLayerId();
    case ITEM_ID:
      return isSetItemId();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof MapItem)
      return this.equals((MapItem)that);
    return false;
  }

  public boolean equals(MapItem that) {
    if (that == null)
      return false;

    boolean this_present_title = true && this.isSetTitle();
    boolean that_present_title = true && that.isSetTitle();
    if (this_present_title || that_present_title) {
      if (!(this_present_title && that_present_title))
        return false;
      if (!this.title.equals(that.title))
        return false;
    }

    boolean this_present_description = true && this.isSetDescription();
    boolean that_present_description = true && that.isSetDescription();
    if (this_present_description || that_present_description) {
      if (!(this_present_description && that_present_description))
        return false;
      if (!this.description.equals(that.description))
        return false;
    }

    boolean this_present_latitude = true;
    boolean that_present_latitude = true;
    if (this_present_latitude || that_present_latitude) {
      if (!(this_present_latitude && that_present_latitude))
        return false;
      if (this.latitude != that.latitude)
        return false;
    }

    boolean this_present_longitude = true;
    boolean that_present_longitude = true;
    if (this_present_longitude || that_present_longitude) {
      if (!(this_present_longitude && that_present_longitude))
        return false;
      if (this.longitude != that.longitude)
        return false;
    }

    boolean this_present_layerId = true;
    boolean that_present_layerId = true;
    if (this_present_layerId || that_present_layerId) {
      if (!(this_present_layerId && that_present_layerId))
        return false;
      if (this.layerId != that.layerId)
        return false;
    }

    boolean this_present_itemId = true;
    boolean that_present_itemId = true;
    if (this_present_itemId || that_present_itemId) {
      if (!(this_present_itemId && that_present_itemId))
        return false;
      if (this.itemId != that.itemId)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_title = true && (isSetTitle());
    builder.append(present_title);
    if (present_title)
      builder.append(title);

    boolean present_description = true && (isSetDescription());
    builder.append(present_description);
    if (present_description)
      builder.append(description);

    boolean present_latitude = true;
    builder.append(present_latitude);
    if (present_latitude)
      builder.append(latitude);

    boolean present_longitude = true;
    builder.append(present_longitude);
    if (present_longitude)
      builder.append(longitude);

    boolean present_layerId = true;
    builder.append(present_layerId);
    if (present_layerId)
      builder.append(layerId);

    boolean present_itemId = true;
    builder.append(present_itemId);
    if (present_itemId)
      builder.append(itemId);

    return builder.toHashCode();
  }

  public int compareTo(MapItem other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    MapItem typedOther = (MapItem)other;

    lastComparison = Boolean.valueOf(isSetTitle()).compareTo(typedOther.isSetTitle());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTitle()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.title, typedOther.title);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetDescription()).compareTo(typedOther.isSetDescription());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDescription()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.description, typedOther.description);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetLatitude()).compareTo(typedOther.isSetLatitude());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLatitude()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.latitude, typedOther.latitude);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetLongitude()).compareTo(typedOther.isSetLongitude());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLongitude()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.longitude, typedOther.longitude);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetLayerId()).compareTo(typedOther.isSetLayerId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLayerId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.layerId, typedOther.layerId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetItemId()).compareTo(typedOther.isSetItemId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetItemId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.itemId, typedOther.itemId);
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
        case 1: // TITLE
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.title = iprot.readString();
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // DESCRIPTION
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.description = iprot.readString();
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 3: // LATITUDE
          if (field.type == org.apache.thrift.protocol.TType.DOUBLE) {
            this.latitude = iprot.readDouble();
            setLatitudeIsSet(true);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 4: // LONGITUDE
          if (field.type == org.apache.thrift.protocol.TType.DOUBLE) {
            this.longitude = iprot.readDouble();
            setLongitudeIsSet(true);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 5: // LAYER_ID
          if (field.type == org.apache.thrift.protocol.TType.I64) {
            this.layerId = iprot.readI64();
            setLayerIdIsSet(true);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 6: // ITEM_ID
          if (field.type == org.apache.thrift.protocol.TType.I64) {
            this.itemId = iprot.readI64();
            setItemIdIsSet(true);
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
    if (!isSetLatitude()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'latitude' was not found in serialized data! Struct: " + toString());
    }
    if (!isSetLongitude()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'longitude' was not found in serialized data! Struct: " + toString());
    }
    if (!isSetLayerId()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'layerId' was not found in serialized data! Struct: " + toString());
    }
    if (!isSetItemId()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'itemId' was not found in serialized data! Struct: " + toString());
    }
    validate();
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    validate();

    oprot.writeStructBegin(STRUCT_DESC);
    if (this.title != null) {
      oprot.writeFieldBegin(TITLE_FIELD_DESC);
      oprot.writeString(this.title);
      oprot.writeFieldEnd();
    }
    if (this.description != null) {
      oprot.writeFieldBegin(DESCRIPTION_FIELD_DESC);
      oprot.writeString(this.description);
      oprot.writeFieldEnd();
    }
    oprot.writeFieldBegin(LATITUDE_FIELD_DESC);
    oprot.writeDouble(this.latitude);
    oprot.writeFieldEnd();
    oprot.writeFieldBegin(LONGITUDE_FIELD_DESC);
    oprot.writeDouble(this.longitude);
    oprot.writeFieldEnd();
    oprot.writeFieldBegin(LAYER_ID_FIELD_DESC);
    oprot.writeI64(this.layerId);
    oprot.writeFieldEnd();
    oprot.writeFieldBegin(ITEM_ID_FIELD_DESC);
    oprot.writeI64(this.itemId);
    oprot.writeFieldEnd();
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("MapItem(");
    boolean first = true;

    sb.append("title:");
    if (this.title == null) {
      sb.append("null");
    } else {
      sb.append(this.title);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("description:");
    if (this.description == null) {
      sb.append("null");
    } else {
      sb.append(this.description);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("latitude:");
    sb.append(this.latitude);
    first = false;
    if (!first) sb.append(", ");
    sb.append("longitude:");
    sb.append(this.longitude);
    first = false;
    if (!first) sb.append(", ");
    sb.append("layerId:");
    sb.append(this.layerId);
    first = false;
    if (!first) sb.append(", ");
    sb.append("itemId:");
    sb.append(this.itemId);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (title == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'title' was not present! Struct: " + toString());
    }
    // alas, we cannot check 'latitude' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'longitude' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'layerId' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'itemId' because it's a primitive and you chose the non-beans generator.
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

