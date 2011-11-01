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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Rating implements org.apache.thrift.TBase<Rating, Rating._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Rating");

  private static final org.apache.thrift.protocol.TField RATING_VALUE_FIELD_DESC = new org.apache.thrift.protocol.TField("ratingValue", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField NB_VOTES_FIELD_DESC = new org.apache.thrift.protocol.TField("nbVotes", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField TOTAL_RATING_FIELD_DESC = new org.apache.thrift.protocol.TField("totalRating", org.apache.thrift.protocol.TType.DOUBLE, (short)3);

  /**
   * 
   * @see RatingValue
   */
  public RatingValue ratingValue; // required
  public int nbVotes; // required
  public double totalRating; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    /**
     * 
     * @see RatingValue
     */
    RATING_VALUE((short)1, "ratingValue"),
    NB_VOTES((short)2, "nbVotes"),
    TOTAL_RATING((short)3, "totalRating");

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
        case 1: // RATING_VALUE
          return RATING_VALUE;
        case 2: // NB_VOTES
          return NB_VOTES;
        case 3: // TOTAL_RATING
          return TOTAL_RATING;
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
  private static final int __NBVOTES_ISSET_ID = 0;
  private static final int __TOTALRATING_ISSET_ID = 1;
  private BitSet __isset_bit_vector = new BitSet(2);

  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.RATING_VALUE, new org.apache.thrift.meta_data.FieldMetaData("ratingValue", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, RatingValue.class)));
    tmpMap.put(_Fields.NB_VOTES, new org.apache.thrift.meta_data.FieldMetaData("nbVotes", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.TOTAL_RATING, new org.apache.thrift.meta_data.FieldMetaData("totalRating", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Rating.class, metaDataMap);
  }

  public Rating() {
  }

  public Rating(
    RatingValue ratingValue,
    int nbVotes,
    double totalRating)
  {
    this();
    this.ratingValue = ratingValue;
    this.nbVotes = nbVotes;
    setNbVotesIsSet(true);
    this.totalRating = totalRating;
    setTotalRatingIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Rating(Rating other) {
    __isset_bit_vector.clear();
    __isset_bit_vector.or(other.__isset_bit_vector);
    if (other.isSetRatingValue()) {
      this.ratingValue = other.ratingValue;
    }
    this.nbVotes = other.nbVotes;
    this.totalRating = other.totalRating;
  }

  public Rating deepCopy() {
    return new Rating(this);
  }

  @Override
  public void clear() {
    this.ratingValue = null;
    setNbVotesIsSet(false);
    this.nbVotes = 0;
    setTotalRatingIsSet(false);
    this.totalRating = 0.0;
  }

  /**
   * 
   * @see RatingValue
   */
  public RatingValue getRatingValue() {
    return this.ratingValue;
  }

  /**
   * 
   * @see RatingValue
   */
  public Rating setRatingValue(RatingValue ratingValue) {
    this.ratingValue = ratingValue;
    return this;
  }

  public void unsetRatingValue() {
    this.ratingValue = null;
  }

  /** Returns true if field ratingValue is set (has been assigned a value) and false otherwise */
  public boolean isSetRatingValue() {
    return this.ratingValue != null;
  }

  public void setRatingValueIsSet(boolean value) {
    if (!value) {
      this.ratingValue = null;
    }
  }

  public int getNbVotes() {
    return this.nbVotes;
  }

  public Rating setNbVotes(int nbVotes) {
    this.nbVotes = nbVotes;
    setNbVotesIsSet(true);
    return this;
  }

  public void unsetNbVotes() {
    __isset_bit_vector.clear(__NBVOTES_ISSET_ID);
  }

  /** Returns true if field nbVotes is set (has been assigned a value) and false otherwise */
  public boolean isSetNbVotes() {
    return __isset_bit_vector.get(__NBVOTES_ISSET_ID);
  }

  public void setNbVotesIsSet(boolean value) {
    __isset_bit_vector.set(__NBVOTES_ISSET_ID, value);
  }

  public double getTotalRating() {
    return this.totalRating;
  }

  public Rating setTotalRating(double totalRating) {
    this.totalRating = totalRating;
    setTotalRatingIsSet(true);
    return this;
  }

  public void unsetTotalRating() {
    __isset_bit_vector.clear(__TOTALRATING_ISSET_ID);
  }

  /** Returns true if field totalRating is set (has been assigned a value) and false otherwise */
  public boolean isSetTotalRating() {
    return __isset_bit_vector.get(__TOTALRATING_ISSET_ID);
  }

  public void setTotalRatingIsSet(boolean value) {
    __isset_bit_vector.set(__TOTALRATING_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case RATING_VALUE:
      if (value == null) {
        unsetRatingValue();
      } else {
        setRatingValue((RatingValue)value);
      }
      break;

    case NB_VOTES:
      if (value == null) {
        unsetNbVotes();
      } else {
        setNbVotes((Integer)value);
      }
      break;

    case TOTAL_RATING:
      if (value == null) {
        unsetTotalRating();
      } else {
        setTotalRating((Double)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case RATING_VALUE:
      return getRatingValue();

    case NB_VOTES:
      return Integer.valueOf(getNbVotes());

    case TOTAL_RATING:
      return Double.valueOf(getTotalRating());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case RATING_VALUE:
      return isSetRatingValue();
    case NB_VOTES:
      return isSetNbVotes();
    case TOTAL_RATING:
      return isSetTotalRating();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Rating)
      return this.equals((Rating)that);
    return false;
  }

  public boolean equals(Rating that) {
    if (that == null)
      return false;

    boolean this_present_ratingValue = true && this.isSetRatingValue();
    boolean that_present_ratingValue = true && that.isSetRatingValue();
    if (this_present_ratingValue || that_present_ratingValue) {
      if (!(this_present_ratingValue && that_present_ratingValue))
        return false;
      if (!this.ratingValue.equals(that.ratingValue))
        return false;
    }

    boolean this_present_nbVotes = true;
    boolean that_present_nbVotes = true;
    if (this_present_nbVotes || that_present_nbVotes) {
      if (!(this_present_nbVotes && that_present_nbVotes))
        return false;
      if (this.nbVotes != that.nbVotes)
        return false;
    }

    boolean this_present_totalRating = true;
    boolean that_present_totalRating = true;
    if (this_present_totalRating || that_present_totalRating) {
      if (!(this_present_totalRating && that_present_totalRating))
        return false;
      if (this.totalRating != that.totalRating)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_ratingValue = true && (isSetRatingValue());
    builder.append(present_ratingValue);
    if (present_ratingValue)
      builder.append(ratingValue.getValue());

    boolean present_nbVotes = true;
    builder.append(present_nbVotes);
    if (present_nbVotes)
      builder.append(nbVotes);

    boolean present_totalRating = true;
    builder.append(present_totalRating);
    if (present_totalRating)
      builder.append(totalRating);

    return builder.toHashCode();
  }

  public int compareTo(Rating other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    Rating typedOther = (Rating)other;

    lastComparison = Boolean.valueOf(isSetRatingValue()).compareTo(typedOther.isSetRatingValue());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRatingValue()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.ratingValue, typedOther.ratingValue);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetNbVotes()).compareTo(typedOther.isSetNbVotes());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetNbVotes()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.nbVotes, typedOther.nbVotes);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTotalRating()).compareTo(typedOther.isSetTotalRating());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTotalRating()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.totalRating, typedOther.totalRating);
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
        case 1: // RATING_VALUE
          if (field.type == org.apache.thrift.protocol.TType.I32) {
            this.ratingValue = RatingValue.findByValue(iprot.readI32());
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // NB_VOTES
          if (field.type == org.apache.thrift.protocol.TType.I32) {
            this.nbVotes = iprot.readI32();
            setNbVotesIsSet(true);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 3: // TOTAL_RATING
          if (field.type == org.apache.thrift.protocol.TType.DOUBLE) {
            this.totalRating = iprot.readDouble();
            setTotalRatingIsSet(true);
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
    if (!isSetNbVotes()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'nbVotes' was not found in serialized data! Struct: " + toString());
    }
    if (!isSetTotalRating()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'totalRating' was not found in serialized data! Struct: " + toString());
    }
    validate();
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    validate();

    oprot.writeStructBegin(STRUCT_DESC);
    if (this.ratingValue != null) {
      oprot.writeFieldBegin(RATING_VALUE_FIELD_DESC);
      oprot.writeI32(this.ratingValue.getValue());
      oprot.writeFieldEnd();
    }
    oprot.writeFieldBegin(NB_VOTES_FIELD_DESC);
    oprot.writeI32(this.nbVotes);
    oprot.writeFieldEnd();
    oprot.writeFieldBegin(TOTAL_RATING_FIELD_DESC);
    oprot.writeDouble(this.totalRating);
    oprot.writeFieldEnd();
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Rating(");
    boolean first = true;

    sb.append("ratingValue:");
    if (this.ratingValue == null) {
      sb.append("null");
    } else {
      sb.append(this.ratingValue);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("nbVotes:");
    sb.append(this.nbVotes);
    first = false;
    if (!first) sb.append(", ");
    sb.append("totalRating:");
    sb.append(this.totalRating);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (ratingValue == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'ratingValue' was not present! Struct: " + toString());
    }
    // alas, we cannot check 'nbVotes' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'totalRating' because it's a primitive and you chose the non-beans generator.
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

