/**
 * Autogenerated by Thrift Compiler (0.7.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package org.pocketcampus.plugin.food.shared;

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

public class VoteRequest implements org.apache.thrift.TBase<VoteRequest, VoteRequest._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("VoteRequest");

  private static final org.apache.thrift.protocol.TField MEAL_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("mealId", org.apache.thrift.protocol.TType.I64, (short)1);
  private static final org.apache.thrift.protocol.TField RATING_FIELD_DESC = new org.apache.thrift.protocol.TField("rating", org.apache.thrift.protocol.TType.DOUBLE, (short)2);
  private static final org.apache.thrift.protocol.TField DEVICE_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("deviceId", org.apache.thrift.protocol.TType.STRING, (short)3);

  private long mealId; // required
  private double rating; // required
  private String deviceId; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    MEAL_ID((short)1, "mealId"),
    RATING((short)2, "rating"),
    DEVICE_ID((short)3, "deviceId");

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
        case 1: // MEAL_ID
          return MEAL_ID;
        case 2: // RATING
          return RATING;
        case 3: // DEVICE_ID
          return DEVICE_ID;
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
  private static final int __MEALID_ISSET_ID = 0;
  private static final int __RATING_ISSET_ID = 1;
  private BitSet __isset_bit_vector = new BitSet(2);

  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.MEAL_ID, new org.apache.thrift.meta_data.FieldMetaData("mealId", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.RATING, new org.apache.thrift.meta_data.FieldMetaData("rating", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.DEVICE_ID, new org.apache.thrift.meta_data.FieldMetaData("deviceId", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(VoteRequest.class, metaDataMap);
  }

  public VoteRequest() {
  }

  public VoteRequest(
    long mealId,
    double rating,
    String deviceId)
  {
    this();
    this.mealId = mealId;
    setMealIdIsSet(true);
    this.rating = rating;
    setRatingIsSet(true);
    this.deviceId = deviceId;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public VoteRequest(VoteRequest other) {
    __isset_bit_vector.clear();
    __isset_bit_vector.or(other.__isset_bit_vector);
    this.mealId = other.mealId;
    this.rating = other.rating;
    if (other.isSetDeviceId()) {
      this.deviceId = other.deviceId;
    }
  }

  public VoteRequest deepCopy() {
    return new VoteRequest(this);
  }

  @Override
  public void clear() {
    setMealIdIsSet(false);
    this.mealId = 0;
    setRatingIsSet(false);
    this.rating = 0.0;
    this.deviceId = null;
  }

  public long getMealId() {
    return this.mealId;
  }

  public VoteRequest setMealId(long mealId) {
    this.mealId = mealId;
    setMealIdIsSet(true);
    return this;
  }

  public void unsetMealId() {
    __isset_bit_vector.clear(__MEALID_ISSET_ID);
  }

  /** Returns true if field mealId is set (has been assigned a value) and false otherwise */
  public boolean isSetMealId() {
    return __isset_bit_vector.get(__MEALID_ISSET_ID);
  }

  public void setMealIdIsSet(boolean value) {
    __isset_bit_vector.set(__MEALID_ISSET_ID, value);
  }

  public double getRating() {
    return this.rating;
  }

  public VoteRequest setRating(double rating) {
    this.rating = rating;
    setRatingIsSet(true);
    return this;
  }

  public void unsetRating() {
    __isset_bit_vector.clear(__RATING_ISSET_ID);
  }

  /** Returns true if field rating is set (has been assigned a value) and false otherwise */
  public boolean isSetRating() {
    return __isset_bit_vector.get(__RATING_ISSET_ID);
  }

  public void setRatingIsSet(boolean value) {
    __isset_bit_vector.set(__RATING_ISSET_ID, value);
  }

  public String getDeviceId() {
    return this.deviceId;
  }

  public VoteRequest setDeviceId(String deviceId) {
    this.deviceId = deviceId;
    return this;
  }

  public void unsetDeviceId() {
    this.deviceId = null;
  }

  /** Returns true if field deviceId is set (has been assigned a value) and false otherwise */
  public boolean isSetDeviceId() {
    return this.deviceId != null;
  }

  public void setDeviceIdIsSet(boolean value) {
    if (!value) {
      this.deviceId = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case MEAL_ID:
      if (value == null) {
        unsetMealId();
      } else {
        setMealId((Long)value);
      }
      break;

    case RATING:
      if (value == null) {
        unsetRating();
      } else {
        setRating((Double)value);
      }
      break;

    case DEVICE_ID:
      if (value == null) {
        unsetDeviceId();
      } else {
        setDeviceId((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case MEAL_ID:
      return Long.valueOf(getMealId());

    case RATING:
      return Double.valueOf(getRating());

    case DEVICE_ID:
      return getDeviceId();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case MEAL_ID:
      return isSetMealId();
    case RATING:
      return isSetRating();
    case DEVICE_ID:
      return isSetDeviceId();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof VoteRequest)
      return this.equals((VoteRequest)that);
    return false;
  }

  public boolean equals(VoteRequest that) {
    if (that == null)
      return false;

    boolean this_present_mealId = true;
    boolean that_present_mealId = true;
    if (this_present_mealId || that_present_mealId) {
      if (!(this_present_mealId && that_present_mealId))
        return false;
      if (this.mealId != that.mealId)
        return false;
    }

    boolean this_present_rating = true;
    boolean that_present_rating = true;
    if (this_present_rating || that_present_rating) {
      if (!(this_present_rating && that_present_rating))
        return false;
      if (this.rating != that.rating)
        return false;
    }

    boolean this_present_deviceId = true && this.isSetDeviceId();
    boolean that_present_deviceId = true && that.isSetDeviceId();
    if (this_present_deviceId || that_present_deviceId) {
      if (!(this_present_deviceId && that_present_deviceId))
        return false;
      if (!this.deviceId.equals(that.deviceId))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_mealId = true;
    builder.append(present_mealId);
    if (present_mealId)
      builder.append(mealId);

    boolean present_rating = true;
    builder.append(present_rating);
    if (present_rating)
      builder.append(rating);

    boolean present_deviceId = true && (isSetDeviceId());
    builder.append(present_deviceId);
    if (present_deviceId)
      builder.append(deviceId);

    return builder.toHashCode();
  }

  public int compareTo(VoteRequest other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    VoteRequest typedOther = (VoteRequest)other;

    lastComparison = Boolean.valueOf(isSetMealId()).compareTo(typedOther.isSetMealId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMealId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.mealId, typedOther.mealId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetRating()).compareTo(typedOther.isSetRating());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRating()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.rating, typedOther.rating);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetDeviceId()).compareTo(typedOther.isSetDeviceId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDeviceId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.deviceId, typedOther.deviceId);
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
        case 1: // MEAL_ID
          if (field.type == org.apache.thrift.protocol.TType.I64) {
            this.mealId = iprot.readI64();
            setMealIdIsSet(true);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // RATING
          if (field.type == org.apache.thrift.protocol.TType.DOUBLE) {
            this.rating = iprot.readDouble();
            setRatingIsSet(true);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 3: // DEVICE_ID
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.deviceId = iprot.readString();
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
    if (!isSetMealId()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'mealId' was not found in serialized data! Struct: " + toString());
    }
    if (!isSetRating()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'rating' was not found in serialized data! Struct: " + toString());
    }
    validate();
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    validate();

    oprot.writeStructBegin(STRUCT_DESC);
    oprot.writeFieldBegin(MEAL_ID_FIELD_DESC);
    oprot.writeI64(this.mealId);
    oprot.writeFieldEnd();
    oprot.writeFieldBegin(RATING_FIELD_DESC);
    oprot.writeDouble(this.rating);
    oprot.writeFieldEnd();
    if (this.deviceId != null) {
      oprot.writeFieldBegin(DEVICE_ID_FIELD_DESC);
      oprot.writeString(this.deviceId);
      oprot.writeFieldEnd();
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("VoteRequest(");
    boolean first = true;

    sb.append("mealId:");
    sb.append(this.mealId);
    first = false;
    if (!first) sb.append(", ");
    sb.append("rating:");
    sb.append(this.rating);
    first = false;
    if (!first) sb.append(", ");
    sb.append("deviceId:");
    if (this.deviceId == null) {
      sb.append("null");
    } else {
      sb.append(this.deviceId);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // alas, we cannot check 'mealId' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'rating' because it's a primitive and you chose the non-beans generator.
    if (deviceId == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'deviceId' was not present! Struct: " + toString());
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
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bit_vector = new BitSet(1);
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

}

