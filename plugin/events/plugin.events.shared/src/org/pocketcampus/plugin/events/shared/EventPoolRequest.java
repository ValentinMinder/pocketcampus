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

public class EventPoolRequest implements org.apache.thrift.TBase<EventPoolRequest, EventPoolRequest._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("EventPoolRequest");

  private static final org.apache.thrift.protocol.TField EVENT_POOL_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("eventPoolId", org.apache.thrift.protocol.TType.I64, (short)1);
  private static final org.apache.thrift.protocol.TField USER_TOKEN_FIELD_DESC = new org.apache.thrift.protocol.TField("userToken", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField USER_TICKETS_FIELD_DESC = new org.apache.thrift.protocol.TField("userTickets", org.apache.thrift.protocol.TType.LIST, (short)3);
  private static final org.apache.thrift.protocol.TField STARRED_EVENT_ITEMS_FIELD_DESC = new org.apache.thrift.protocol.TField("starredEventItems", org.apache.thrift.protocol.TType.LIST, (short)4);
  private static final org.apache.thrift.protocol.TField LANG_FIELD_DESC = new org.apache.thrift.protocol.TField("lang", org.apache.thrift.protocol.TType.STRING, (short)5);
  private static final org.apache.thrift.protocol.TField PERIOD_FIELD_DESC = new org.apache.thrift.protocol.TField("period", org.apache.thrift.protocol.TType.I32, (short)6);
  private static final org.apache.thrift.protocol.TField FETCH_PAST_FIELD_DESC = new org.apache.thrift.protocol.TField("fetchPast", org.apache.thrift.protocol.TType.BOOL, (short)7);

  public long eventPoolId; // required
  public String userToken; // required
  public List<String> userTickets; // required
  public List<Long> starredEventItems; // required
  public String lang; // required
  public int period; // required
  public boolean fetchPast; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    EVENT_POOL_ID((short)1, "eventPoolId"),
    USER_TOKEN((short)2, "userToken"),
    USER_TICKETS((short)3, "userTickets"),
    STARRED_EVENT_ITEMS((short)4, "starredEventItems"),
    LANG((short)5, "lang"),
    PERIOD((short)6, "period"),
    FETCH_PAST((short)7, "fetchPast");

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
        case 1: // EVENT_POOL_ID
          return EVENT_POOL_ID;
        case 2: // USER_TOKEN
          return USER_TOKEN;
        case 3: // USER_TICKETS
          return USER_TICKETS;
        case 4: // STARRED_EVENT_ITEMS
          return STARRED_EVENT_ITEMS;
        case 5: // LANG
          return LANG;
        case 6: // PERIOD
          return PERIOD;
        case 7: // FETCH_PAST
          return FETCH_PAST;
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
  private static final int __EVENTPOOLID_ISSET_ID = 0;
  private static final int __PERIOD_ISSET_ID = 1;
  private static final int __FETCHPAST_ISSET_ID = 2;
  private BitSet __isset_bit_vector = new BitSet(3);

  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.EVENT_POOL_ID, new org.apache.thrift.meta_data.FieldMetaData("eventPoolId", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.USER_TOKEN, new org.apache.thrift.meta_data.FieldMetaData("userToken", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.USER_TICKETS, new org.apache.thrift.meta_data.FieldMetaData("userTickets", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    tmpMap.put(_Fields.STARRED_EVENT_ITEMS, new org.apache.thrift.meta_data.FieldMetaData("starredEventItems", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64))));
    tmpMap.put(_Fields.LANG, new org.apache.thrift.meta_data.FieldMetaData("lang", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PERIOD, new org.apache.thrift.meta_data.FieldMetaData("period", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.FETCH_PAST, new org.apache.thrift.meta_data.FieldMetaData("fetchPast", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(EventPoolRequest.class, metaDataMap);
  }

  public EventPoolRequest() {
  }

  public EventPoolRequest(
    long eventPoolId)
  {
    this();
    this.eventPoolId = eventPoolId;
    setEventPoolIdIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public EventPoolRequest(EventPoolRequest other) {
    __isset_bit_vector.clear();
    __isset_bit_vector.or(other.__isset_bit_vector);
    this.eventPoolId = other.eventPoolId;
    if (other.isSetUserToken()) {
      this.userToken = other.userToken;
    }
    if (other.isSetUserTickets()) {
      List<String> __this__userTickets = new ArrayList<String>();
      for (String other_element : other.userTickets) {
        __this__userTickets.add(other_element);
      }
      this.userTickets = __this__userTickets;
    }
    if (other.isSetStarredEventItems()) {
      List<Long> __this__starredEventItems = new ArrayList<Long>();
      for (Long other_element : other.starredEventItems) {
        __this__starredEventItems.add(other_element);
      }
      this.starredEventItems = __this__starredEventItems;
    }
    if (other.isSetLang()) {
      this.lang = other.lang;
    }
    this.period = other.period;
    this.fetchPast = other.fetchPast;
  }

  public EventPoolRequest deepCopy() {
    return new EventPoolRequest(this);
  }

  @Override
  public void clear() {
    setEventPoolIdIsSet(false);
    this.eventPoolId = 0;
    this.userToken = null;
    this.userTickets = null;
    this.starredEventItems = null;
    this.lang = null;
    setPeriodIsSet(false);
    this.period = 0;
    setFetchPastIsSet(false);
    this.fetchPast = false;
  }

  public long getEventPoolId() {
    return this.eventPoolId;
  }

  public EventPoolRequest setEventPoolId(long eventPoolId) {
    this.eventPoolId = eventPoolId;
    setEventPoolIdIsSet(true);
    return this;
  }

  public void unsetEventPoolId() {
    __isset_bit_vector.clear(__EVENTPOOLID_ISSET_ID);
  }

  /** Returns true if field eventPoolId is set (has been assigned a value) and false otherwise */
  public boolean isSetEventPoolId() {
    return __isset_bit_vector.get(__EVENTPOOLID_ISSET_ID);
  }

  public void setEventPoolIdIsSet(boolean value) {
    __isset_bit_vector.set(__EVENTPOOLID_ISSET_ID, value);
  }

  public String getUserToken() {
    return this.userToken;
  }

  public EventPoolRequest setUserToken(String userToken) {
    this.userToken = userToken;
    return this;
  }

  public void unsetUserToken() {
    this.userToken = null;
  }

  /** Returns true if field userToken is set (has been assigned a value) and false otherwise */
  public boolean isSetUserToken() {
    return this.userToken != null;
  }

  public void setUserTokenIsSet(boolean value) {
    if (!value) {
      this.userToken = null;
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

  public EventPoolRequest setUserTickets(List<String> userTickets) {
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

  public EventPoolRequest setStarredEventItems(List<Long> starredEventItems) {
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

  public String getLang() {
    return this.lang;
  }

  public EventPoolRequest setLang(String lang) {
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

  public int getPeriod() {
    return this.period;
  }

  public EventPoolRequest setPeriod(int period) {
    this.period = period;
    setPeriodIsSet(true);
    return this;
  }

  public void unsetPeriod() {
    __isset_bit_vector.clear(__PERIOD_ISSET_ID);
  }

  /** Returns true if field period is set (has been assigned a value) and false otherwise */
  public boolean isSetPeriod() {
    return __isset_bit_vector.get(__PERIOD_ISSET_ID);
  }

  public void setPeriodIsSet(boolean value) {
    __isset_bit_vector.set(__PERIOD_ISSET_ID, value);
  }

  public boolean isFetchPast() {
    return this.fetchPast;
  }

  public EventPoolRequest setFetchPast(boolean fetchPast) {
    this.fetchPast = fetchPast;
    setFetchPastIsSet(true);
    return this;
  }

  public void unsetFetchPast() {
    __isset_bit_vector.clear(__FETCHPAST_ISSET_ID);
  }

  /** Returns true if field fetchPast is set (has been assigned a value) and false otherwise */
  public boolean isSetFetchPast() {
    return __isset_bit_vector.get(__FETCHPAST_ISSET_ID);
  }

  public void setFetchPastIsSet(boolean value) {
    __isset_bit_vector.set(__FETCHPAST_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case EVENT_POOL_ID:
      if (value == null) {
        unsetEventPoolId();
      } else {
        setEventPoolId((Long)value);
      }
      break;

    case USER_TOKEN:
      if (value == null) {
        unsetUserToken();
      } else {
        setUserToken((String)value);
      }
      break;

    case USER_TICKETS:
      if (value == null) {
        unsetUserTickets();
      } else {
        setUserTickets((List<String>)value);
      }
      break;

    case STARRED_EVENT_ITEMS:
      if (value == null) {
        unsetStarredEventItems();
      } else {
        setStarredEventItems((List<Long>)value);
      }
      break;

    case LANG:
      if (value == null) {
        unsetLang();
      } else {
        setLang((String)value);
      }
      break;

    case PERIOD:
      if (value == null) {
        unsetPeriod();
      } else {
        setPeriod((Integer)value);
      }
      break;

    case FETCH_PAST:
      if (value == null) {
        unsetFetchPast();
      } else {
        setFetchPast((Boolean)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case EVENT_POOL_ID:
      return Long.valueOf(getEventPoolId());

    case USER_TOKEN:
      return getUserToken();

    case USER_TICKETS:
      return getUserTickets();

    case STARRED_EVENT_ITEMS:
      return getStarredEventItems();

    case LANG:
      return getLang();

    case PERIOD:
      return Integer.valueOf(getPeriod());

    case FETCH_PAST:
      return Boolean.valueOf(isFetchPast());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case EVENT_POOL_ID:
      return isSetEventPoolId();
    case USER_TOKEN:
      return isSetUserToken();
    case USER_TICKETS:
      return isSetUserTickets();
    case STARRED_EVENT_ITEMS:
      return isSetStarredEventItems();
    case LANG:
      return isSetLang();
    case PERIOD:
      return isSetPeriod();
    case FETCH_PAST:
      return isSetFetchPast();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof EventPoolRequest)
      return this.equals((EventPoolRequest)that);
    return false;
  }

  public boolean equals(EventPoolRequest that) {
    if (that == null)
      return false;

    boolean this_present_eventPoolId = true;
    boolean that_present_eventPoolId = true;
    if (this_present_eventPoolId || that_present_eventPoolId) {
      if (!(this_present_eventPoolId && that_present_eventPoolId))
        return false;
      if (this.eventPoolId != that.eventPoolId)
        return false;
    }

    boolean this_present_userToken = true && this.isSetUserToken();
    boolean that_present_userToken = true && that.isSetUserToken();
    if (this_present_userToken || that_present_userToken) {
      if (!(this_present_userToken && that_present_userToken))
        return false;
      if (!this.userToken.equals(that.userToken))
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

    boolean this_present_starredEventItems = true && this.isSetStarredEventItems();
    boolean that_present_starredEventItems = true && that.isSetStarredEventItems();
    if (this_present_starredEventItems || that_present_starredEventItems) {
      if (!(this_present_starredEventItems && that_present_starredEventItems))
        return false;
      if (!this.starredEventItems.equals(that.starredEventItems))
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

    boolean this_present_period = true && this.isSetPeriod();
    boolean that_present_period = true && that.isSetPeriod();
    if (this_present_period || that_present_period) {
      if (!(this_present_period && that_present_period))
        return false;
      if (this.period != that.period)
        return false;
    }

    boolean this_present_fetchPast = true && this.isSetFetchPast();
    boolean that_present_fetchPast = true && that.isSetFetchPast();
    if (this_present_fetchPast || that_present_fetchPast) {
      if (!(this_present_fetchPast && that_present_fetchPast))
        return false;
      if (this.fetchPast != that.fetchPast)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_eventPoolId = true;
    builder.append(present_eventPoolId);
    if (present_eventPoolId)
      builder.append(eventPoolId);

    boolean present_userToken = true && (isSetUserToken());
    builder.append(present_userToken);
    if (present_userToken)
      builder.append(userToken);

    boolean present_userTickets = true && (isSetUserTickets());
    builder.append(present_userTickets);
    if (present_userTickets)
      builder.append(userTickets);

    boolean present_starredEventItems = true && (isSetStarredEventItems());
    builder.append(present_starredEventItems);
    if (present_starredEventItems)
      builder.append(starredEventItems);

    boolean present_lang = true && (isSetLang());
    builder.append(present_lang);
    if (present_lang)
      builder.append(lang);

    boolean present_period = true && (isSetPeriod());
    builder.append(present_period);
    if (present_period)
      builder.append(period);

    boolean present_fetchPast = true && (isSetFetchPast());
    builder.append(present_fetchPast);
    if (present_fetchPast)
      builder.append(fetchPast);

    return builder.toHashCode();
  }

  public int compareTo(EventPoolRequest other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    EventPoolRequest typedOther = (EventPoolRequest)other;

    lastComparison = Boolean.valueOf(isSetEventPoolId()).compareTo(typedOther.isSetEventPoolId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetEventPoolId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.eventPoolId, typedOther.eventPoolId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetUserToken()).compareTo(typedOther.isSetUserToken());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUserToken()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.userToken, typedOther.userToken);
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
    lastComparison = Boolean.valueOf(isSetPeriod()).compareTo(typedOther.isSetPeriod());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPeriod()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.period, typedOther.period);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetFetchPast()).compareTo(typedOther.isSetFetchPast());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFetchPast()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.fetchPast, typedOther.fetchPast);
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
        case 1: // EVENT_POOL_ID
          if (field.type == org.apache.thrift.protocol.TType.I64) {
            this.eventPoolId = iprot.readI64();
            setEventPoolIdIsSet(true);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // USER_TOKEN
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.userToken = iprot.readString();
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 3: // USER_TICKETS
          if (field.type == org.apache.thrift.protocol.TType.LIST) {
            {
              org.apache.thrift.protocol.TList _list16 = iprot.readListBegin();
              this.userTickets = new ArrayList<String>(_list16.size);
              for (int _i17 = 0; _i17 < _list16.size; ++_i17)
              {
                String _elem18; // required
                _elem18 = iprot.readString();
                this.userTickets.add(_elem18);
              }
              iprot.readListEnd();
            }
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 4: // STARRED_EVENT_ITEMS
          if (field.type == org.apache.thrift.protocol.TType.LIST) {
            {
              org.apache.thrift.protocol.TList _list19 = iprot.readListBegin();
              this.starredEventItems = new ArrayList<Long>(_list19.size);
              for (int _i20 = 0; _i20 < _list19.size; ++_i20)
              {
                long _elem21; // required
                _elem21 = iprot.readI64();
                this.starredEventItems.add(_elem21);
              }
              iprot.readListEnd();
            }
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
        case 6: // PERIOD
          if (field.type == org.apache.thrift.protocol.TType.I32) {
            this.period = iprot.readI32();
            setPeriodIsSet(true);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 7: // FETCH_PAST
          if (field.type == org.apache.thrift.protocol.TType.BOOL) {
            this.fetchPast = iprot.readBool();
            setFetchPastIsSet(true);
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
    if (!isSetEventPoolId()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'eventPoolId' was not found in serialized data! Struct: " + toString());
    }
    validate();
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    validate();

    oprot.writeStructBegin(STRUCT_DESC);
    oprot.writeFieldBegin(EVENT_POOL_ID_FIELD_DESC);
    oprot.writeI64(this.eventPoolId);
    oprot.writeFieldEnd();
    if (this.userToken != null) {
      if (isSetUserToken()) {
        oprot.writeFieldBegin(USER_TOKEN_FIELD_DESC);
        oprot.writeString(this.userToken);
        oprot.writeFieldEnd();
      }
    }
    if (this.userTickets != null) {
      if (isSetUserTickets()) {
        oprot.writeFieldBegin(USER_TICKETS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, this.userTickets.size()));
          for (String _iter22 : this.userTickets)
          {
            oprot.writeString(_iter22);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
    }
    if (this.starredEventItems != null) {
      if (isSetStarredEventItems()) {
        oprot.writeFieldBegin(STARRED_EVENT_ITEMS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I64, this.starredEventItems.size()));
          for (long _iter23 : this.starredEventItems)
          {
            oprot.writeI64(_iter23);
          }
          oprot.writeListEnd();
        }
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
    if (isSetPeriod()) {
      oprot.writeFieldBegin(PERIOD_FIELD_DESC);
      oprot.writeI32(this.period);
      oprot.writeFieldEnd();
    }
    if (isSetFetchPast()) {
      oprot.writeFieldBegin(FETCH_PAST_FIELD_DESC);
      oprot.writeBool(this.fetchPast);
      oprot.writeFieldEnd();
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("EventPoolRequest(");
    boolean first = true;

    sb.append("eventPoolId:");
    sb.append(this.eventPoolId);
    first = false;
    if (isSetUserToken()) {
      if (!first) sb.append(", ");
      sb.append("userToken:");
      if (this.userToken == null) {
        sb.append("null");
      } else {
        sb.append(this.userToken);
      }
      first = false;
    }
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
    if (isSetStarredEventItems()) {
      if (!first) sb.append(", ");
      sb.append("starredEventItems:");
      if (this.starredEventItems == null) {
        sb.append("null");
      } else {
        sb.append(this.starredEventItems);
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
    if (isSetPeriod()) {
      if (!first) sb.append(", ");
      sb.append("period:");
      sb.append(this.period);
      first = false;
    }
    if (isSetFetchPast()) {
      if (!first) sb.append(", ");
      sb.append("fetchPast:");
      sb.append(this.fetchPast);
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // alas, we cannot check 'eventPoolId' because it's a primitive and you chose the non-beans generator.
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

