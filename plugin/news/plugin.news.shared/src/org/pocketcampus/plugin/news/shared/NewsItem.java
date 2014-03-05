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

  private static final org.apache.thrift.protocol.TField NEWS_ITEM_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("newsItemId", org.apache.thrift.protocol.TType.I64, (short)1);
  private static final org.apache.thrift.protocol.TField TITLE_FIELD_DESC = new org.apache.thrift.protocol.TField("title", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField LINK_FIELD_DESC = new org.apache.thrift.protocol.TField("link", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField FEED_FIELD_DESC = new org.apache.thrift.protocol.TField("feed", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField PUB_DATE_FIELD_DESC = new org.apache.thrift.protocol.TField("pubDate", org.apache.thrift.protocol.TType.I64, (short)5);
  private static final org.apache.thrift.protocol.TField IMAGE_URL_FIELD_DESC = new org.apache.thrift.protocol.TField("imageUrl", org.apache.thrift.protocol.TType.STRING, (short)6);

  private long newsItemId; // required
  private String title; // required
  private String link; // required
  private String feed; // required
  private long pubDate; // required
  private String imageUrl; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    NEWS_ITEM_ID((short)1, "newsItemId"),
    TITLE((short)2, "title"),
    LINK((short)3, "link"),
    FEED((short)4, "feed"),
    PUB_DATE((short)5, "pubDate"),
    IMAGE_URL((short)6, "imageUrl");

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
        case 1: // NEWS_ITEM_ID
          return NEWS_ITEM_ID;
        case 2: // TITLE
          return TITLE;
        case 3: // LINK
          return LINK;
        case 4: // FEED
          return FEED;
        case 5: // PUB_DATE
          return PUB_DATE;
        case 6: // IMAGE_URL
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
  private static final int __NEWSITEMID_ISSET_ID = 0;
  private static final int __PUBDATE_ISSET_ID = 1;
  private BitSet __isset_bit_vector = new BitSet(2);

  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.NEWS_ITEM_ID, new org.apache.thrift.meta_data.FieldMetaData("newsItemId", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.TITLE, new org.apache.thrift.meta_data.FieldMetaData("title", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.LINK, new org.apache.thrift.meta_data.FieldMetaData("link", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.FEED, new org.apache.thrift.meta_data.FieldMetaData("feed", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PUB_DATE, new org.apache.thrift.meta_data.FieldMetaData("pubDate", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.IMAGE_URL, new org.apache.thrift.meta_data.FieldMetaData("imageUrl", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(NewsItem.class, metaDataMap);
  }

  public NewsItem() {
  }

  public NewsItem(
    long newsItemId,
    String title,
    String link,
    String feed,
    long pubDate)
  {
    this();
    this.newsItemId = newsItemId;
    setNewsItemIdIsSet(true);
    this.title = title;
    this.link = link;
    this.feed = feed;
    this.pubDate = pubDate;
    setPubDateIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public NewsItem(NewsItem other) {
    __isset_bit_vector.clear();
    __isset_bit_vector.or(other.__isset_bit_vector);
    this.newsItemId = other.newsItemId;
    if (other.isSetTitle()) {
      this.title = other.title;
    }
    if (other.isSetLink()) {
      this.link = other.link;
    }
    if (other.isSetFeed()) {
      this.feed = other.feed;
    }
    this.pubDate = other.pubDate;
    if (other.isSetImageUrl()) {
      this.imageUrl = other.imageUrl;
    }
  }

  public NewsItem deepCopy() {
    return new NewsItem(this);
  }

  @Override
  public void clear() {
    setNewsItemIdIsSet(false);
    this.newsItemId = 0;
    this.title = null;
    this.link = null;
    this.feed = null;
    setPubDateIsSet(false);
    this.pubDate = 0;
    this.imageUrl = null;
  }

  public long getNewsItemId() {
    return this.newsItemId;
  }

  public NewsItem setNewsItemId(long newsItemId) {
    this.newsItemId = newsItemId;
    setNewsItemIdIsSet(true);
    return this;
  }

  public void unsetNewsItemId() {
    __isset_bit_vector.clear(__NEWSITEMID_ISSET_ID);
  }

  /** Returns true if field newsItemId is set (has been assigned a value) and false otherwise */
  public boolean isSetNewsItemId() {
    return __isset_bit_vector.get(__NEWSITEMID_ISSET_ID);
  }

  public void setNewsItemIdIsSet(boolean value) {
    __isset_bit_vector.set(__NEWSITEMID_ISSET_ID, value);
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

  public String getFeed() {
    return this.feed;
  }

  public NewsItem setFeed(String feed) {
    this.feed = feed;
    return this;
  }

  public void unsetFeed() {
    this.feed = null;
  }

  /** Returns true if field feed is set (has been assigned a value) and false otherwise */
  public boolean isSetFeed() {
    return this.feed != null;
  }

  public void setFeedIsSet(boolean value) {
    if (!value) {
      this.feed = null;
    }
  }

  public long getPubDate() {
    return this.pubDate;
  }

  public NewsItem setPubDate(long pubDate) {
    this.pubDate = pubDate;
    setPubDateIsSet(true);
    return this;
  }

  public void unsetPubDate() {
    __isset_bit_vector.clear(__PUBDATE_ISSET_ID);
  }

  /** Returns true if field pubDate is set (has been assigned a value) and false otherwise */
  public boolean isSetPubDate() {
    return __isset_bit_vector.get(__PUBDATE_ISSET_ID);
  }

  public void setPubDateIsSet(boolean value) {
    __isset_bit_vector.set(__PUBDATE_ISSET_ID, value);
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
    case NEWS_ITEM_ID:
      if (value == null) {
        unsetNewsItemId();
      } else {
        setNewsItemId((Long)value);
      }
      break;

    case TITLE:
      if (value == null) {
        unsetTitle();
      } else {
        setTitle((String)value);
      }
      break;

    case LINK:
      if (value == null) {
        unsetLink();
      } else {
        setLink((String)value);
      }
      break;

    case FEED:
      if (value == null) {
        unsetFeed();
      } else {
        setFeed((String)value);
      }
      break;

    case PUB_DATE:
      if (value == null) {
        unsetPubDate();
      } else {
        setPubDate((Long)value);
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
    case NEWS_ITEM_ID:
      return Long.valueOf(getNewsItemId());

    case TITLE:
      return getTitle();

    case LINK:
      return getLink();

    case FEED:
      return getFeed();

    case PUB_DATE:
      return Long.valueOf(getPubDate());

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
    case NEWS_ITEM_ID:
      return isSetNewsItemId();
    case TITLE:
      return isSetTitle();
    case LINK:
      return isSetLink();
    case FEED:
      return isSetFeed();
    case PUB_DATE:
      return isSetPubDate();
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

    boolean this_present_newsItemId = true;
    boolean that_present_newsItemId = true;
    if (this_present_newsItemId || that_present_newsItemId) {
      if (!(this_present_newsItemId && that_present_newsItemId))
        return false;
      if (this.newsItemId != that.newsItemId)
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

    boolean this_present_link = true && this.isSetLink();
    boolean that_present_link = true && that.isSetLink();
    if (this_present_link || that_present_link) {
      if (!(this_present_link && that_present_link))
        return false;
      if (!this.link.equals(that.link))
        return false;
    }

    boolean this_present_feed = true && this.isSetFeed();
    boolean that_present_feed = true && that.isSetFeed();
    if (this_present_feed || that_present_feed) {
      if (!(this_present_feed && that_present_feed))
        return false;
      if (!this.feed.equals(that.feed))
        return false;
    }

    boolean this_present_pubDate = true;
    boolean that_present_pubDate = true;
    if (this_present_pubDate || that_present_pubDate) {
      if (!(this_present_pubDate && that_present_pubDate))
        return false;
      if (this.pubDate != that.pubDate)
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

    boolean present_newsItemId = true;
    builder.append(present_newsItemId);
    if (present_newsItemId)
      builder.append(newsItemId);

    boolean present_title = true && (isSetTitle());
    builder.append(present_title);
    if (present_title)
      builder.append(title);

    boolean present_link = true && (isSetLink());
    builder.append(present_link);
    if (present_link)
      builder.append(link);

    boolean present_feed = true && (isSetFeed());
    builder.append(present_feed);
    if (present_feed)
      builder.append(feed);

    boolean present_pubDate = true;
    builder.append(present_pubDate);
    if (present_pubDate)
      builder.append(pubDate);

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

    lastComparison = Boolean.valueOf(isSetNewsItemId()).compareTo(typedOther.isSetNewsItemId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetNewsItemId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.newsItemId, typedOther.newsItemId);
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
    lastComparison = Boolean.valueOf(isSetFeed()).compareTo(typedOther.isSetFeed());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFeed()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.feed, typedOther.feed);
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
        case 1: // NEWS_ITEM_ID
          if (field.type == org.apache.thrift.protocol.TType.I64) {
            this.newsItemId = iprot.readI64();
            setNewsItemIdIsSet(true);
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
        case 3: // LINK
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.link = iprot.readString();
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 4: // FEED
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.feed = iprot.readString();
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 5: // PUB_DATE
          if (field.type == org.apache.thrift.protocol.TType.I64) {
            this.pubDate = iprot.readI64();
            setPubDateIsSet(true);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 6: // IMAGE_URL
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
    if (!isSetNewsItemId()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'newsItemId' was not found in serialized data! Struct: " + toString());
    }
    if (!isSetPubDate()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'pubDate' was not found in serialized data! Struct: " + toString());
    }
    validate();
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    validate();

    oprot.writeStructBegin(STRUCT_DESC);
    oprot.writeFieldBegin(NEWS_ITEM_ID_FIELD_DESC);
    oprot.writeI64(this.newsItemId);
    oprot.writeFieldEnd();
    if (this.title != null) {
      oprot.writeFieldBegin(TITLE_FIELD_DESC);
      oprot.writeString(this.title);
      oprot.writeFieldEnd();
    }
    if (this.link != null) {
      oprot.writeFieldBegin(LINK_FIELD_DESC);
      oprot.writeString(this.link);
      oprot.writeFieldEnd();
    }
    if (this.feed != null) {
      oprot.writeFieldBegin(FEED_FIELD_DESC);
      oprot.writeString(this.feed);
      oprot.writeFieldEnd();
    }
    oprot.writeFieldBegin(PUB_DATE_FIELD_DESC);
    oprot.writeI64(this.pubDate);
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
    StringBuilder sb = new StringBuilder("NewsItem(");
    boolean first = true;

    sb.append("newsItemId:");
    sb.append(this.newsItemId);
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
    sb.append("link:");
    if (this.link == null) {
      sb.append("null");
    } else {
      sb.append(this.link);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("feed:");
    if (this.feed == null) {
      sb.append("null");
    } else {
      sb.append(this.feed);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("pubDate:");
    sb.append(this.pubDate);
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
    // alas, we cannot check 'newsItemId' because it's a primitive and you chose the non-beans generator.
    if (title == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'title' was not present! Struct: " + toString());
    }
    if (link == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'link' was not present! Struct: " + toString());
    }
    if (feed == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'feed' was not present! Struct: " + toString());
    }
    // alas, we cannot check 'pubDate' because it's a primitive and you chose the non-beans generator.
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

