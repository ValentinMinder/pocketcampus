/**
 * Autogenerated by Thrift Compiler (0.7.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package org.pocketcampus.plugin.news.shared;

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

public class NewsFeedsResponse implements org.apache.thrift.TBase<NewsFeedsResponse, NewsFeedsResponse._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("NewsFeedsResponse");

  private static final org.apache.thrift.protocol.TField STATUS_CODE_FIELD_DESC = new org.apache.thrift.protocol.TField("statusCode", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField FEEDS_FIELD_DESC = new org.apache.thrift.protocol.TField("feeds", org.apache.thrift.protocol.TType.LIST, (short)2);

  private NewsStatusCode statusCode; // required
  private List<NewsFeed> feeds; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    /**
     * 
     * @see NewsStatusCode
     */
    STATUS_CODE((short)1, "statusCode"),
    FEEDS((short)2, "feeds");

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
        case 2: // FEEDS
          return FEEDS;
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
    tmpMap.put(_Fields.STATUS_CODE, new org.apache.thrift.meta_data.FieldMetaData("statusCode", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, NewsStatusCode.class)));
    tmpMap.put(_Fields.FEEDS, new org.apache.thrift.meta_data.FieldMetaData("feeds", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, NewsFeed.class))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(NewsFeedsResponse.class, metaDataMap);
  }

  public NewsFeedsResponse() {
  }

  public NewsFeedsResponse(
    NewsStatusCode statusCode,
    List<NewsFeed> feeds)
  {
    this();
    this.statusCode = statusCode;
    this.feeds = feeds;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public NewsFeedsResponse(NewsFeedsResponse other) {
    if (other.isSetStatusCode()) {
      this.statusCode = other.statusCode;
    }
    if (other.isSetFeeds()) {
      List<NewsFeed> __this__feeds = new ArrayList<NewsFeed>();
      for (NewsFeed other_element : other.feeds) {
        __this__feeds.add(new NewsFeed(other_element));
      }
      this.feeds = __this__feeds;
    }
  }

  public NewsFeedsResponse deepCopy() {
    return new NewsFeedsResponse(this);
  }

  @Override
  public void clear() {
    this.statusCode = null;
    this.feeds = null;
  }

  /**
   * 
   * @see NewsStatusCode
   */
  public NewsStatusCode getStatusCode() {
    return this.statusCode;
  }

  /**
   * 
   * @see NewsStatusCode
   */
  public NewsFeedsResponse setStatusCode(NewsStatusCode statusCode) {
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

  public int getFeedsSize() {
    return (this.feeds == null) ? 0 : this.feeds.size();
  }

  public java.util.Iterator<NewsFeed> getFeedsIterator() {
    return (this.feeds == null) ? null : this.feeds.iterator();
  }

  public void addToFeeds(NewsFeed elem) {
    if (this.feeds == null) {
      this.feeds = new ArrayList<NewsFeed>();
    }
    this.feeds.add(elem);
  }

  public List<NewsFeed> getFeeds() {
    return this.feeds;
  }

  public NewsFeedsResponse setFeeds(List<NewsFeed> feeds) {
    this.feeds = feeds;
    return this;
  }

  public void unsetFeeds() {
    this.feeds = null;
  }

  /** Returns true if field feeds is set (has been assigned a value) and false otherwise */
  public boolean isSetFeeds() {
    return this.feeds != null;
  }

  public void setFeedsIsSet(boolean value) {
    if (!value) {
      this.feeds = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case STATUS_CODE:
      if (value == null) {
        unsetStatusCode();
      } else {
        setStatusCode((NewsStatusCode)value);
      }
      break;

    case FEEDS:
      if (value == null) {
        unsetFeeds();
      } else {
        setFeeds((List<NewsFeed>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case STATUS_CODE:
      return getStatusCode();

    case FEEDS:
      return getFeeds();

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
    case FEEDS:
      return isSetFeeds();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof NewsFeedsResponse)
      return this.equals((NewsFeedsResponse)that);
    return false;
  }

  public boolean equals(NewsFeedsResponse that) {
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

    boolean this_present_feeds = true && this.isSetFeeds();
    boolean that_present_feeds = true && that.isSetFeeds();
    if (this_present_feeds || that_present_feeds) {
      if (!(this_present_feeds && that_present_feeds))
        return false;
      if (!this.feeds.equals(that.feeds))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_statusCode = true && (isSetStatusCode());
    builder.append(present_statusCode);
    if (present_statusCode)
      builder.append(statusCode.getValue());

    boolean present_feeds = true && (isSetFeeds());
    builder.append(present_feeds);
    if (present_feeds)
      builder.append(feeds);

    return builder.toHashCode();
  }

  public int compareTo(NewsFeedsResponse other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    NewsFeedsResponse typedOther = (NewsFeedsResponse)other;

    lastComparison = Boolean.valueOf(isSetStatusCode()).compareTo(typedOther.isSetStatusCode());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetStatusCode()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.statusCode, typedOther.statusCode);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetFeeds()).compareTo(typedOther.isSetFeeds());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFeeds()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.feeds, typedOther.feeds);
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
        case 1: // STATUS_CODE
          if (field.type == org.apache.thrift.protocol.TType.I32) {
            this.statusCode = NewsStatusCode.findByValue(iprot.readI32());
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // FEEDS
          if (field.type == org.apache.thrift.protocol.TType.LIST) {
            {
              org.apache.thrift.protocol.TList _list8 = iprot.readListBegin();
              this.feeds = new ArrayList<NewsFeed>(_list8.size);
              for (int _i9 = 0; _i9 < _list8.size; ++_i9)
              {
                NewsFeed _elem10; // required
                _elem10 = new NewsFeed();
                _elem10.read(iprot);
                this.feeds.add(_elem10);
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
    if (this.statusCode != null) {
      oprot.writeFieldBegin(STATUS_CODE_FIELD_DESC);
      oprot.writeI32(this.statusCode.getValue());
      oprot.writeFieldEnd();
    }
    if (this.feeds != null) {
      oprot.writeFieldBegin(FEEDS_FIELD_DESC);
      {
        oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, this.feeds.size()));
        for (NewsFeed _iter11 : this.feeds)
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
    StringBuilder sb = new StringBuilder("NewsFeedsResponse(");
    boolean first = true;

    sb.append("statusCode:");
    if (this.statusCode == null) {
      sb.append("null");
    } else {
      sb.append(this.statusCode);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("feeds:");
    if (this.feeds == null) {
      sb.append("null");
    } else {
      sb.append(this.feeds);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (statusCode == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'statusCode' was not present! Struct: " + toString());
    }
    if (feeds == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'feeds' was not present! Struct: " + toString());
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

