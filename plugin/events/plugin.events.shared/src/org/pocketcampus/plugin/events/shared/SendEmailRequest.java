/**
 * Autogenerated by Thrift Compiler (0.7.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package org.pocketcampus.plugin.events.shared;

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

public class SendEmailRequest implements org.apache.thrift.TBase<SendEmailRequest, SendEmailRequest._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("SendEmailRequest");

  private static final org.apache.thrift.protocol.TField STARRED_EVENT_ITEMS_FIELD_DESC = new org.apache.thrift.protocol.TField("starredEventItems", org.apache.thrift.protocol.TType.LIST, (short)1);
  private static final org.apache.thrift.protocol.TField USER_TICKETS_FIELD_DESC = new org.apache.thrift.protocol.TField("userTickets", org.apache.thrift.protocol.TType.LIST, (short)2);
  private static final org.apache.thrift.protocol.TField EMAIL_ADDRESS_FIELD_DESC = new org.apache.thrift.protocol.TField("emailAddress", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField LANG_FIELD_DESC = new org.apache.thrift.protocol.TField("lang", org.apache.thrift.protocol.TType.STRING, (short)5);

  public List<Long> starredEventItems; // required
  public List<String> userTickets; // required
  public String emailAddress; // required
  public String lang; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    STARRED_EVENT_ITEMS((short)1, "starredEventItems"),
    USER_TICKETS((short)2, "userTickets"),
    EMAIL_ADDRESS((short)3, "emailAddress"),
    LANG((short)5, "lang");

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
        case 1: // STARRED_EVENT_ITEMS
          return STARRED_EVENT_ITEMS;
        case 2: // USER_TICKETS
          return USER_TICKETS;
        case 3: // EMAIL_ADDRESS
          return EMAIL_ADDRESS;
        case 5: // LANG
          return LANG;
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
    tmpMap.put(_Fields.STARRED_EVENT_ITEMS, new org.apache.thrift.meta_data.FieldMetaData("starredEventItems", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64))));
    tmpMap.put(_Fields.USER_TICKETS, new org.apache.thrift.meta_data.FieldMetaData("userTickets", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    tmpMap.put(_Fields.EMAIL_ADDRESS, new org.apache.thrift.meta_data.FieldMetaData("emailAddress", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.LANG, new org.apache.thrift.meta_data.FieldMetaData("lang", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(SendEmailRequest.class, metaDataMap);
  }

  public SendEmailRequest() {
  }

  public SendEmailRequest(
    List<Long> starredEventItems)
  {
    this();
    this.starredEventItems = starredEventItems;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public SendEmailRequest(SendEmailRequest other) {
    if (other.isSetStarredEventItems()) {
      List<Long> __this__starredEventItems = new ArrayList<Long>();
      for (Long other_element : other.starredEventItems) {
        __this__starredEventItems.add(other_element);
      }
      this.starredEventItems = __this__starredEventItems;
    }
    if (other.isSetUserTickets()) {
      List<String> __this__userTickets = new ArrayList<String>();
      for (String other_element : other.userTickets) {
        __this__userTickets.add(other_element);
      }
      this.userTickets = __this__userTickets;
    }
    if (other.isSetEmailAddress()) {
      this.emailAddress = other.emailAddress;
    }
    if (other.isSetLang()) {
      this.lang = other.lang;
    }
  }

  public SendEmailRequest deepCopy() {
    return new SendEmailRequest(this);
  }

  @Override
  public void clear() {
    this.starredEventItems = null;
    this.userTickets = null;
    this.emailAddress = null;
    this.lang = null;
  }

  public int getStarredEventItemsSize() {
    return (this.starredEventItems == null) ? 0 : this.starredEventItems.size();
  }

  public java.util.Iterator<Long> getStarredEventItemsIterator() {
    return (this.starredEventItems == null) ? null : this.starredEventItems.iterator();
  }

  public void addToStarredEventItems(long elem) {
    if (this.starredEventItems == null) {
      this.starredEventItems = new ArrayList<Long>();
    }
    this.starredEventItems.add(elem);
  }

  public List<Long> getStarredEventItems() {
    return this.starredEventItems;
  }

  public SendEmailRequest setStarredEventItems(List<Long> starredEventItems) {
    this.starredEventItems = starredEventItems;
    return this;
  }

  public void unsetStarredEventItems() {
    this.starredEventItems = null;
  }

  /** Returns true if field starredEventItems is set (has been assigned a value) and false otherwise */
  public boolean isSetStarredEventItems() {
    return this.starredEventItems != null;
  }

  public void setStarredEventItemsIsSet(boolean value) {
    if (!value) {
      this.starredEventItems = null;
    }
  }

  public int getUserTicketsSize() {
    return (this.userTickets == null) ? 0 : this.userTickets.size();
  }

  public java.util.Iterator<String> getUserTicketsIterator() {
    return (this.userTickets == null) ? null : this.userTickets.iterator();
  }

  public void addToUserTickets(String elem) {
    if (this.userTickets == null) {
      this.userTickets = new ArrayList<String>();
    }
    this.userTickets.add(elem);
  }

  public List<String> getUserTickets() {
    return this.userTickets;
  }

  public SendEmailRequest setUserTickets(List<String> userTickets) {
    this.userTickets = userTickets;
    return this;
  }

  public void unsetUserTickets() {
    this.userTickets = null;
  }

  /** Returns true if field userTickets is set (has been assigned a value) and false otherwise */
  public boolean isSetUserTickets() {
    return this.userTickets != null;
  }

  public void setUserTicketsIsSet(boolean value) {
    if (!value) {
      this.userTickets = null;
    }
  }

  public String getEmailAddress() {
    return this.emailAddress;
  }

  public SendEmailRequest setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
    return this;
  }

  public void unsetEmailAddress() {
    this.emailAddress = null;
  }

  /** Returns true if field emailAddress is set (has been assigned a value) and false otherwise */
  public boolean isSetEmailAddress() {
    return this.emailAddress != null;
  }

  public void setEmailAddressIsSet(boolean value) {
    if (!value) {
      this.emailAddress = null;
    }
  }

  public String getLang() {
    return this.lang;
  }

  public SendEmailRequest setLang(String lang) {
    this.lang = lang;
    return this;
  }

  public void unsetLang() {
    this.lang = null;
  }

  /** Returns true if field lang is set (has been assigned a value) and false otherwise */
  public boolean isSetLang() {
    return this.lang != null;
  }

  public void setLangIsSet(boolean value) {
    if (!value) {
      this.lang = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case STARRED_EVENT_ITEMS:
      if (value == null) {
        unsetStarredEventItems();
      } else {
        setStarredEventItems((List<Long>)value);
      }
      break;

    case USER_TICKETS:
      if (value == null) {
        unsetUserTickets();
      } else {
        setUserTickets((List<String>)value);
      }
      break;

    case EMAIL_ADDRESS:
      if (value == null) {
        unsetEmailAddress();
      } else {
        setEmailAddress((String)value);
      }
      break;

    case LANG:
      if (value == null) {
        unsetLang();
      } else {
        setLang((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case STARRED_EVENT_ITEMS:
      return getStarredEventItems();

    case USER_TICKETS:
      return getUserTickets();

    case EMAIL_ADDRESS:
      return getEmailAddress();

    case LANG:
      return getLang();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case STARRED_EVENT_ITEMS:
      return isSetStarredEventItems();
    case USER_TICKETS:
      return isSetUserTickets();
    case EMAIL_ADDRESS:
      return isSetEmailAddress();
    case LANG:
      return isSetLang();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof SendEmailRequest)
      return this.equals((SendEmailRequest)that);
    return false;
  }

  public boolean equals(SendEmailRequest that) {
    if (that == null)
      return false;

    boolean this_present_starredEventItems = true && this.isSetStarredEventItems();
    boolean that_present_starredEventItems = true && that.isSetStarredEventItems();
    if (this_present_starredEventItems || that_present_starredEventItems) {
      if (!(this_present_starredEventItems && that_present_starredEventItems))
        return false;
      if (!this.starredEventItems.equals(that.starredEventItems))
        return false;
    }

    boolean this_present_userTickets = true && this.isSetUserTickets();
    boolean that_present_userTickets = true && that.isSetUserTickets();
    if (this_present_userTickets || that_present_userTickets) {
      if (!(this_present_userTickets && that_present_userTickets))
        return false;
      if (!this.userTickets.equals(that.userTickets))
        return false;
    }

    boolean this_present_emailAddress = true && this.isSetEmailAddress();
    boolean that_present_emailAddress = true && that.isSetEmailAddress();
    if (this_present_emailAddress || that_present_emailAddress) {
      if (!(this_present_emailAddress && that_present_emailAddress))
        return false;
      if (!this.emailAddress.equals(that.emailAddress))
        return false;
    }

    boolean this_present_lang = true && this.isSetLang();
    boolean that_present_lang = true && that.isSetLang();
    if (this_present_lang || that_present_lang) {
      if (!(this_present_lang && that_present_lang))
        return false;
      if (!this.lang.equals(that.lang))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_starredEventItems = true && (isSetStarredEventItems());
    builder.append(present_starredEventItems);
    if (present_starredEventItems)
      builder.append(starredEventItems);

    boolean present_userTickets = true && (isSetUserTickets());
    builder.append(present_userTickets);
    if (present_userTickets)
      builder.append(userTickets);

    boolean present_emailAddress = true && (isSetEmailAddress());
    builder.append(present_emailAddress);
    if (present_emailAddress)
      builder.append(emailAddress);

    boolean present_lang = true && (isSetLang());
    builder.append(present_lang);
    if (present_lang)
      builder.append(lang);

    return builder.toHashCode();
  }

  public int compareTo(SendEmailRequest other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    SendEmailRequest typedOther = (SendEmailRequest)other;

    lastComparison = Boolean.valueOf(isSetStarredEventItems()).compareTo(typedOther.isSetStarredEventItems());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetStarredEventItems()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.starredEventItems, typedOther.starredEventItems);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetUserTickets()).compareTo(typedOther.isSetUserTickets());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUserTickets()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.userTickets, typedOther.userTickets);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetEmailAddress()).compareTo(typedOther.isSetEmailAddress());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetEmailAddress()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.emailAddress, typedOther.emailAddress);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetLang()).compareTo(typedOther.isSetLang());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLang()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.lang, typedOther.lang);
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
        case 1: // STARRED_EVENT_ITEMS
          if (field.type == org.apache.thrift.protocol.TType.LIST) {
            {
              org.apache.thrift.protocol.TList _list62 = iprot.readListBegin();
              this.starredEventItems = new ArrayList<Long>(_list62.size);
              for (int _i63 = 0; _i63 < _list62.size; ++_i63)
              {
                long _elem64; // required
                _elem64 = iprot.readI64();
                this.starredEventItems.add(_elem64);
              }
              iprot.readListEnd();
            }
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // USER_TICKETS
          if (field.type == org.apache.thrift.protocol.TType.LIST) {
            {
              org.apache.thrift.protocol.TList _list65 = iprot.readListBegin();
              this.userTickets = new ArrayList<String>(_list65.size);
              for (int _i66 = 0; _i66 < _list65.size; ++_i66)
              {
                String _elem67; // required
                _elem67 = iprot.readString();
                this.userTickets.add(_elem67);
              }
              iprot.readListEnd();
            }
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 3: // EMAIL_ADDRESS
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.emailAddress = iprot.readString();
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 5: // LANG
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.lang = iprot.readString();
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
    if (this.starredEventItems != null) {
      oprot.writeFieldBegin(STARRED_EVENT_ITEMS_FIELD_DESC);
      {
        oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I64, this.starredEventItems.size()));
        for (long _iter68 : this.starredEventItems)
        {
          oprot.writeI64(_iter68);
        }
        oprot.writeListEnd();
      }
      oprot.writeFieldEnd();
    }
    if (this.userTickets != null) {
      if (isSetUserTickets()) {
        oprot.writeFieldBegin(USER_TICKETS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, this.userTickets.size()));
          for (String _iter69 : this.userTickets)
          {
            oprot.writeString(_iter69);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
    }
    if (this.emailAddress != null) {
      if (isSetEmailAddress()) {
        oprot.writeFieldBegin(EMAIL_ADDRESS_FIELD_DESC);
        oprot.writeString(this.emailAddress);
        oprot.writeFieldEnd();
      }
    }
    if (this.lang != null) {
      if (isSetLang()) {
        oprot.writeFieldBegin(LANG_FIELD_DESC);
        oprot.writeString(this.lang);
        oprot.writeFieldEnd();
      }
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("SendEmailRequest(");
    boolean first = true;

    sb.append("starredEventItems:");
    if (this.starredEventItems == null) {
      sb.append("null");
    } else {
      sb.append(this.starredEventItems);
    }
    first = false;
    if (isSetUserTickets()) {
      if (!first) sb.append(", ");
      sb.append("userTickets:");
      if (this.userTickets == null) {
        sb.append("null");
      } else {
        sb.append(this.userTickets);
      }
      first = false;
    }
    if (isSetEmailAddress()) {
      if (!first) sb.append(", ");
      sb.append("emailAddress:");
      if (this.emailAddress == null) {
        sb.append("null");
      } else {
        sb.append(this.emailAddress);
      }
      first = false;
    }
    if (isSetLang()) {
      if (!first) sb.append(", ");
      sb.append("lang:");
      if (this.lang == null) {
        sb.append("null");
      } else {
        sb.append(this.lang);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (starredEventItems == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'starredEventItems' was not present! Struct: " + toString());
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

