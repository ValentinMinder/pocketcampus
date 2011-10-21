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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NewsItem implements org.apache.thrift.TBase<NewsItem, NewsItem._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("NewsItem");

  private static final org.apache.thrift.protocol.TField ID_FIELD_DESC = new org.apache.thrift.protocol.TField("id", org.apache.thrift.protocol.TType.I64, (short)1);
  private static final org.apache.thrift.protocol.TField TITLE_FIELD_DESC = new org.apache.thrift.protocol.TField("title", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField DESCRIPTION_FIELD_DESC = new org.apache.thrift.protocol.TField("description", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField LINK_FIELD_DESC = new org.apache.thrift.protocol.TField("link", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField PUB_DATE_FIELD_DESC = new org.apache.thrift.protocol.TField("pubDate", org.apache.thrift.protocol.TType.STRING, (short)5);
  private static final org.apache.thrift.protocol.TField PUB_DATE_DATE_FIELD_DESC = new org.apache.thrift.protocol.TField("pubDateDate", org.apache.thrift.protocol.TType.I64, (short)6);
  private static final org.apache.thrift.protocol.TField IMAGE_URL_FIELD_DESC = new org.apache.thrift.protocol.TField("imageUrl", org.apache.thrift.protocol.TType.STRING, (short)7);

  public long id; // required
  public String title; // required
  public String description; // required
  public String link; // required
  public String pubDate; // required
  public long pubDateDate; // required
  public String imageUrl; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ID((short)1, "id"),
    TITLE((short)2, "title"),
    DESCRIPTION((short)3, "description"),
    LINK((short)4, "link"),
    PUB_DATE((short)5, "pubDate"),
    PUB_DATE_DATE((short)6, "pubDateDate"),
    IMAGE_URL((short)7, "imageUrl");

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
        case 1: // ID
          return ID;
        case 2: // TITLE
          return TITLE;
        case 3: // DESCRIPTION
          return DESCRIPTION;
        case 4: // LINK
          return LINK;
        case 5: // PUB_DATE
          return PUB_DATE;
        case 6: // PUB_DATE_DATE
          return PUB_DATE_DATE;
        case 7: // IMAGE_URL
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
  private static final int __ID_ISSET_ID = 0;
  private static final int __PUBDATEDATE_ISSET_ID = 1;
  private BitSet __isset_bit_vector = new BitSet(2);

  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ID, new org.apache.thrift.meta_data.FieldMetaData("id", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64        , "Id")));
    tmpMap.put(_Fields.TITLE, new org.apache.thrift.meta_data.FieldMetaData("title", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.DESCRIPTION, new org.apache.thrift.meta_data.FieldMetaData("description", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.LINK, new org.apache.thrift.meta_data.FieldMetaData("link", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PUB_DATE, new org.apache.thrift.meta_data.FieldMetaData("pubDate", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PUB_DATE_DATE, new org.apache.thrift.meta_data.FieldMetaData("pubDateDate", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64        , "timestamp")));
    tmpMap.put(_Fields.IMAGE_URL, new org.apache.thrift.meta_data.FieldMetaData("imageUrl", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(NewsItem.class, metaDataMap);
  }

  public NewsItem() {
  }

  public NewsItem(
    long id,
    String title,
    String description,
    String link,
    String pubDate,
    long pubDateDate,
    String imageUrl)
  {
    this();
    this.id = id;
    setIdIsSet(true);
    this.title = title;
    this.description = description;
    this.link = link;
    this.pubDate = pubDate;
    this.pubDateDate = pubDateDate;
    setPubDateDateIsSet(true);
    this.imageUrl = imageUrl;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public NewsItem(NewsItem other) {
    __isset_bit_vector.clear();
    __isset_bit_vector.or(other.__isset_bit_vector);
    this.id = other.id;
    if (other.isSetTitle()) {
      this.title = other.title;
    }
    if (other.isSetDescription()) {
      this.description = other.description;
    }
    if (other.isSetLink()) {
      this.link = other.link;
    }
    if (other.isSetPubDate()) {
      this.pubDate = other.pubDate;
    }
    this.pubDateDate = other.pubDateDate;
    if (other.isSetImageUrl()) {
      this.imageUrl = other.imageUrl;
    }
  }

  public NewsItem deepCopy() {
    return new NewsItem(this);
  }

  @Override
  public void clear() {
    setIdIsSet(false);
    this.id = 0;
    this.title = null;
    this.description = null;
    this.link = null;
    this.pubDate = null;
    setPubDateDateIsSet(false);
    this.pubDateDate = 0;
    this.imageUrl = null;
  }

  public long getId() {
    return this.id;
  }

  public NewsItem setId(long id) {
    this.id = id;
    setIdIsSet(true);
    return this;
  }

  public void unsetId() {
    __isset_bit_vector.clear(__ID_ISSET_ID);
  }

  /** Returns true if field id is set (has been assigned a value) and false otherwise */
  public boolean isSetId() {
    return __isset_bit_vector.get(__ID_ISSET_ID);
  }

  public void setIdIsSet(boolean value) {
    __isset_bit_vector.set(__ID_ISSET_ID, value);
  }

  public String getTitle() {
    return this.title;
  }

  public NewsItem setTitle(String title) {
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

  public NewsItem setDescription(String description) {
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

  public String getLink() {
    return this.link;
  }

  public NewsItem setLink(String link) {
    this.link = link;
    return this;
  }

  public void unsetLink() {
    this.link = null;
  }

  /** Returns true if field link is set (has been assigned a value) and false otherwise */
  public boolean isSetLink() {
    return this.link != null;
  }

  public void setLinkIsSet(boolean value) {
    if (!value) {
      this.link = null;
    }
  }

  public String getPubDate() {
    return this.pubDate;
  }

  public NewsItem setPubDate(String pubDate) {
    this.pubDate = pubDate;
    return this;
  }

  public void unsetPubDate() {
    this.pubDate = null;
  }

  /** Returns true if field pubDate is set (has been assigned a value) and false otherwise */
  public boolean isSetPubDate() {
    return this.pubDate != null;
  }

  public void setPubDateIsSet(boolean value) {
    if (!value) {
      this.pubDate = null;
    }
  }

  public long getPubDateDate() {
    return this.pubDateDate;
  }

  public NewsItem setPubDateDate(long pubDateDate) {
    this.pubDateDate = pubDateDate;
    setPubDateDateIsSet(true);
    return this;
  }

  public void unsetPubDateDate() {
    __isset_bit_vector.clear(__PUBDATEDATE_ISSET_ID);
  }

  /** Returns true if field pubDateDate is set (has been assigned a value) and false otherwise */
  public boolean isSetPubDateDate() {
    return __isset_bit_vector.get(__PUBDATEDATE_ISSET_ID);
  }

  public void setPubDateDateIsSet(boolean value) {
    __isset_bit_vector.set(__PUBDATEDATE_ISSET_ID, value);
  }

  public String getImageUrl() {
    return this.imageUrl;
  }

  public NewsItem setImageUrl(String imageUrl) {
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
    case ID:
      if (value == null) {
        unsetId();
      } else {
        setId((Long)value);
      }
      break;

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

    case LINK:
      if (value == null) {
        unsetLink();
      } else {
        setLink((String)value);
      }
      break;

    case PUB_DATE:
      if (value == null) {
        unsetPubDate();
      } else {
        setPubDate((String)value);
      }
      break;

    case PUB_DATE_DATE:
      if (value == null) {
        unsetPubDateDate();
      } else {
        setPubDateDate((Long)value);
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
    case ID:
      return Long.valueOf(getId());

    case TITLE:
      return getTitle();

    case DESCRIPTION:
      return getDescription();

    case LINK:
      return getLink();

    case PUB_DATE:
      return getPubDate();

    case PUB_DATE_DATE:
      return Long.valueOf(getPubDateDate());

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
    case ID:
      return isSetId();
    case TITLE:
      return isSetTitle();
    case DESCRIPTION:
      return isSetDescription();
    case LINK:
      return isSetLink();
    case PUB_DATE:
      return isSetPubDate();
    case PUB_DATE_DATE:
      return isSetPubDateDate();
    case IMAGE_URL:
      return isSetImageUrl();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof NewsItem)
      return this.equals((NewsItem)that);
    return false;
  }

  public boolean equals(NewsItem that) {
    if (that == null)
      return false;

    boolean this_present_id = true;
    boolean that_present_id = true;
    if (this_present_id || that_present_id) {
      if (!(this_present_id && that_present_id))
        return false;
      if (this.id != that.id)
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

    boolean this_present_description = true && this.isSetDescription();
    boolean that_present_description = true && that.isSetDescription();
    if (this_present_description || that_present_description) {
      if (!(this_present_description && that_present_description))
        return false;
      if (!this.description.equals(that.description))
        return false;
    }

    boolean this_present_link = true && this.isSetLink();
    boolean that_present_link = true && that.isSetLink();
    if (this_present_link || that_present_link) {
      if (!(this_present_link && that_present_link))
        return false;
      if (!this.link.equals(that.link))
        return false;
    }

    boolean this_present_pubDate = true && this.isSetPubDate();
    boolean that_present_pubDate = true && that.isSetPubDate();
    if (this_present_pubDate || that_present_pubDate) {
      if (!(this_present_pubDate && that_present_pubDate))
        return false;
      if (!this.pubDate.equals(that.pubDate))
        return false;
    }

    boolean this_present_pubDateDate = true;
    boolean that_present_pubDateDate = true;
    if (this_present_pubDateDate || that_present_pubDateDate) {
      if (!(this_present_pubDateDate && that_present_pubDateDate))
        return false;
      if (this.pubDateDate != that.pubDateDate)
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

    boolean present_id = true;
    builder.append(present_id);
    if (present_id)
      builder.append(id);

    boolean present_title = true && (isSetTitle());
    builder.append(present_title);
    if (present_title)
      builder.append(title);

    boolean present_description = true && (isSetDescription());
    builder.append(present_description);
    if (present_description)
      builder.append(description);

    boolean present_link = true && (isSetLink());
    builder.append(present_link);
    if (present_link)
      builder.append(link);

    boolean present_pubDate = true && (isSetPubDate());
    builder.append(present_pubDate);
    if (present_pubDate)
      builder.append(pubDate);

    boolean present_pubDateDate = true;
    builder.append(present_pubDateDate);
    if (present_pubDateDate)
      builder.append(pubDateDate);

    boolean present_imageUrl = true && (isSetImageUrl());
    builder.append(present_imageUrl);
    if (present_imageUrl)
      builder.append(imageUrl);

    return builder.toHashCode();
  }

  public int compareTo(NewsItem other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    NewsItem typedOther = (NewsItem)other;

    lastComparison = Boolean.valueOf(isSetId()).compareTo(typedOther.isSetId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.id, typedOther.id);
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
    lastComparison = Boolean.valueOf(isSetLink()).compareTo(typedOther.isSetLink());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLink()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.link, typedOther.link);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPubDate()).compareTo(typedOther.isSetPubDate());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPubDate()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.pubDate, typedOther.pubDate);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPubDateDate()).compareTo(typedOther.isSetPubDateDate());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPubDateDate()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.pubDateDate, typedOther.pubDateDate);
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
        case 1: // ID
          if (field.type == org.apache.thrift.protocol.TType.I64) {
            this.id = iprot.readI64();
            setIdIsSet(true);
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
        case 3: // DESCRIPTION
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.description = iprot.readString();
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 4: // LINK
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.link = iprot.readString();
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 5: // PUB_DATE
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.pubDate = iprot.readString();
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 6: // PUB_DATE_DATE
          if (field.type == org.apache.thrift.protocol.TType.I64) {
            this.pubDateDate = iprot.readI64();
            setPubDateDateIsSet(true);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 7: // IMAGE_URL
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
    if (!isSetId()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'id' was not found in serialized data! Struct: " + toString());
    }
    if (!isSetPubDateDate()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'pubDateDate' was not found in serialized data! Struct: " + toString());
    }
    validate();
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    validate();

    oprot.writeStructBegin(STRUCT_DESC);
    oprot.writeFieldBegin(ID_FIELD_DESC);
    oprot.writeI64(this.id);
    oprot.writeFieldEnd();
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
    if (this.link != null) {
      oprot.writeFieldBegin(LINK_FIELD_DESC);
      oprot.writeString(this.link);
      oprot.writeFieldEnd();
    }
    if (this.pubDate != null) {
      oprot.writeFieldBegin(PUB_DATE_FIELD_DESC);
      oprot.writeString(this.pubDate);
      oprot.writeFieldEnd();
    }
    oprot.writeFieldBegin(PUB_DATE_DATE_FIELD_DESC);
    oprot.writeI64(this.pubDateDate);
    oprot.writeFieldEnd();
    if (this.imageUrl != null) {
      oprot.writeFieldBegin(IMAGE_URL_FIELD_DESC);
      oprot.writeString(this.imageUrl);
      oprot.writeFieldEnd();
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("NewsItem(");
    boolean first = true;

    sb.append("id:");
    sb.append(this.id);
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
    sb.append("description:");
    if (this.description == null) {
      sb.append("null");
    } else {
      sb.append(this.description);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("link:");
    if (this.link == null) {
      sb.append("null");
    } else {
      sb.append(this.link);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("pubDate:");
    if (this.pubDate == null) {
      sb.append("null");
    } else {
      sb.append(this.pubDate);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("pubDateDate:");
    sb.append(this.pubDateDate);
    first = false;
    if (!first) sb.append(", ");
    sb.append("imageUrl:");
    if (this.imageUrl == null) {
      sb.append("null");
    } else {
      sb.append(this.imageUrl);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // alas, we cannot check 'id' because it's a primitive and you chose the non-beans generator.
    if (title == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'title' was not present! Struct: " + toString());
    }
    if (description == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'description' was not present! Struct: " + toString());
    }
    if (link == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'link' was not present! Struct: " + toString());
    }
    if (pubDate == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'pubDate' was not present! Struct: " + toString());
    }
    // alas, we cannot check 'pubDateDate' because it's a primitive and you chose the non-beans generator.
    if (imageUrl == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'imageUrl' was not present! Struct: " + toString());
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

