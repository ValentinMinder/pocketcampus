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

public class NewsFeedItem implements org.apache.thrift.TBase<NewsFeedItem, NewsFeedItem._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("NewsFeedItem");

  private static final org.apache.thrift.protocol.TField ITEM_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("itemId", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField TITLE_FIELD_DESC = new org.apache.thrift.protocol.TField("title", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField DATE_FIELD_DESC = new org.apache.thrift.protocol.TField("date", org.apache.thrift.protocol.TType.I64, (short)3);
  private static final org.apache.thrift.protocol.TField IMAGE_URL_FIELD_DESC = new org.apache.thrift.protocol.TField("imageUrl", org.apache.thrift.protocol.TType.STRING, (short)4);

  private int itemId; // required
  private String title; // required
  private long date; // required
  private String imageUrl; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ITEM_ID((short)1, "itemId"),
    TITLE((short)2, "title"),
    DATE((short)3, "date"),
    IMAGE_URL((short)4, "imageUrl");

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
        case 1: // ITEM_ID
          return ITEM_ID;
        case 2: // TITLE
          return TITLE;
        case 3: // DATE
          return DATE;
        case 4: // IMAGE_URL
          return IMAGE_URL;
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
  private static final int __ITEMID_ISSET_ID = 0;
  private static final int __DATE_ISSET_ID = 1;
  private BitSet __isset_bit_vector = new BitSet(2);

  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ITEM_ID, new org.apache.thrift.meta_data.FieldMetaData("itemId", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.TITLE, new org.apache.thrift.meta_data.FieldMetaData("title", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.DATE, new org.apache.thrift.meta_data.FieldMetaData("date", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.IMAGE_URL, new org.apache.thrift.meta_data.FieldMetaData("imageUrl", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(NewsFeedItem.class, metaDataMap);
  }

  public NewsFeedItem() {
  }

  public NewsFeedItem(
    int itemId,
    String title,
    long date)
  {
    this();
    this.itemId = itemId;
    setItemIdIsSet(true);
    this.title = title;
    this.date = date;
    setDateIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public NewsFeedItem(NewsFeedItem other) {
    __isset_bit_vector.clear();
    __isset_bit_vector.or(other.__isset_bit_vector);
    this.itemId = other.itemId;
    if (other.isSetTitle()) {
      this.title = other.title;
    }
    this.date = other.date;
    if (other.isSetImageUrl()) {
      this.imageUrl = other.imageUrl;
    }
  }

  public NewsFeedItem deepCopy() {
    return new NewsFeedItem(this);
  }

  @Override
  public void clear() {
    setItemIdIsSet(false);
    this.itemId = 0;
    this.title = null;
    setDateIsSet(false);
    this.date = 0;
    this.imageUrl = null;
  }

  public int getItemId() {
    return this.itemId;
  }

  public NewsFeedItem setItemId(int itemId) {
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

  public String getTitle() {
    return this.title;
  }

  public NewsFeedItem setTitle(String title) {
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

  public long getDate() {
    return this.date;
  }

  public NewsFeedItem setDate(long date) {
    this.date = date;
    setDateIsSet(true);
    return this;
  }

  public void unsetDate() {
    __isset_bit_vector.clear(__DATE_ISSET_ID);
  }

  /** Returns true if field date is set (has been assigned a value) and false otherwise */
  public boolean isSetDate() {
    return __isset_bit_vector.get(__DATE_ISSET_ID);
  }

  public void setDateIsSet(boolean value) {
    __isset_bit_vector.set(__DATE_ISSET_ID, value);
  }

  public String getImageUrl() {
    return this.imageUrl;
  }

  public NewsFeedItem setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
    return this;
  }

  public void unsetImageUrl() {
    this.imageUrl = null;
  }

  /** Returns true if field imageUrl is set (has been assigned a value) and false otherwise */
  public boolean isSetImageUrl() {
    return this.imageUrl != null;
  }

  public void setImageUrlIsSet(boolean value) {
    if (!value) {
      this.imageUrl = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case ITEM_ID:
      if (value == null) {
        unsetItemId();
      } else {
        setItemId((Integer)value);
      }
      break;

    case TITLE:
      if (value == null) {
        unsetTitle();
      } else {
        setTitle((String)value);
      }
      break;

    case DATE:
      if (value == null) {
        unsetDate();
      } else {
        setDate((Long)value);
      }
      break;

    case IMAGE_URL:
      if (value == null) {
        unsetImageUrl();
      } else {
        setImageUrl((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case ITEM_ID:
      return Integer.valueOf(getItemId());

    case TITLE:
      return getTitle();

    case DATE:
      return Long.valueOf(getDate());

    case IMAGE_URL:
      return getImageUrl();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case ITEM_ID:
      return isSetItemId();
    case TITLE:
      return isSetTitle();
    case DATE:
      return isSetDate();
    case IMAGE_URL:
      return isSetImageUrl();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof NewsFeedItem)
      return this.equals((NewsFeedItem)that);
    return false;
  }

  public boolean equals(NewsFeedItem that) {
    if (that == null)
      return false;

    boolean this_present_itemId = true;
    boolean that_present_itemId = true;
    if (this_present_itemId || that_present_itemId) {
      if (!(this_present_itemId && that_present_itemId))
        return false;
      if (this.itemId != that.itemId)
        return false;
    }

    boolean this_present_title = true && this.isSetTitle();
    boolean that_present_title = true && that.isSetTitle();
    if (this_present_title || that_present_title) {
      if (!(this_present_title && that_present_title))
        return false;
      if (!this.title.equals(that.title))
        return false;
    }

    boolean this_present_date = true;
    boolean that_present_date = true;
    if (this_present_date || that_present_date) {
      if (!(this_present_date && that_present_date))
        return false;
      if (this.date != that.date)
        return false;
    }

    boolean this_present_imageUrl = true && this.isSetImageUrl();
    boolean that_present_imageUrl = true && that.isSetImageUrl();
    if (this_present_imageUrl || that_present_imageUrl) {
      if (!(this_present_imageUrl && that_present_imageUrl))
        return false;
      if (!this.imageUrl.equals(that.imageUrl))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_itemId = true;
    builder.append(present_itemId);
    if (present_itemId)
      builder.append(itemId);

    boolean present_title = true && (isSetTitle());
    builder.append(present_title);
    if (present_title)
      builder.append(title);

    boolean present_date = true;
    builder.append(present_date);
    if (present_date)
      builder.append(date);

    boolean present_imageUrl = true && (isSetImageUrl());
    builder.append(present_imageUrl);
    if (present_imageUrl)
      builder.append(imageUrl);

    return builder.toHashCode();
  }

  public int compareTo(NewsFeedItem other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    NewsFeedItem typedOther = (NewsFeedItem)other;

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
    lastComparison = Boolean.valueOf(isSetDate()).compareTo(typedOther.isSetDate());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDate()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.date, typedOther.date);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetImageUrl()).compareTo(typedOther.isSetImageUrl());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetImageUrl()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.imageUrl, typedOther.imageUrl);
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
        case 1: // ITEM_ID
          if (field.type == org.apache.thrift.protocol.TType.I32) {
            this.itemId = iprot.readI32();
            setItemIdIsSet(true);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // TITLE
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.title = iprot.readString();
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 3: // DATE
          if (field.type == org.apache.thrift.protocol.TType.I64) {
            this.date = iprot.readI64();
            setDateIsSet(true);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 4: // IMAGE_URL
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.imageUrl = iprot.readString();
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
    if (!isSetItemId()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'itemId' was not found in serialized data! Struct: " + toString());
    }
    if (!isSetDate()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'date' was not found in serialized data! Struct: " + toString());
    }
    validate();
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    validate();

    oprot.writeStructBegin(STRUCT_DESC);
    oprot.writeFieldBegin(ITEM_ID_FIELD_DESC);
    oprot.writeI32(this.itemId);
    oprot.writeFieldEnd();
    if (this.title != null) {
      oprot.writeFieldBegin(TITLE_FIELD_DESC);
      oprot.writeString(this.title);
      oprot.writeFieldEnd();
    }
    oprot.writeFieldBegin(DATE_FIELD_DESC);
    oprot.writeI64(this.date);
    oprot.writeFieldEnd();
    if (this.imageUrl != null) {
      if (isSetImageUrl()) {
        oprot.writeFieldBegin(IMAGE_URL_FIELD_DESC);
        oprot.writeString(this.imageUrl);
        oprot.writeFieldEnd();
      }
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("NewsFeedItem(");
    boolean first = true;

    sb.append("itemId:");
    sb.append(this.itemId);
    first = false;
    if (!first) sb.append(", ");
    sb.append("title:");
    if (this.title == null) {
      sb.append("null");
    } else {
      sb.append(this.title);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("date:");
    sb.append(this.date);
    first = false;
    if (isSetImageUrl()) {
      if (!first) sb.append(", ");
      sb.append("imageUrl:");
      if (this.imageUrl == null) {
        sb.append("null");
      } else {
        sb.append(this.imageUrl);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // alas, we cannot check 'itemId' because it's a primitive and you chose the non-beans generator.
    if (title == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'title' was not present! Struct: " + toString());
    }
    // alas, we cannot check 'date' because it's a primitive and you chose the non-beans generator.
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

