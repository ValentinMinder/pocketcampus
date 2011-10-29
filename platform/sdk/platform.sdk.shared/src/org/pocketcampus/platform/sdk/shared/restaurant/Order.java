/**
 * Autogenerated by Thrift Compiler (0.7.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package org.pocketcampus.platform.sdk.shared.restaurant;

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

/**
 * Order the restaurant gets from the server,
 * ie represents what a client has ordered
 */
public class Order implements org.apache.thrift.TBase<Order, Order._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Order");

  private static final org.apache.thrift.protocol.TField ID_FIELD_DESC = new org.apache.thrift.protocol.TField("id", org.apache.thrift.protocol.TType.I64, (short)1);
  private static final org.apache.thrift.protocol.TField CHOSEN_ITEMS_FIELD_DESC = new org.apache.thrift.protocol.TField("chosenItems", org.apache.thrift.protocol.TType.LIST, (short)2);
  private static final org.apache.thrift.protocol.TField DATE_FIELD_DESC = new org.apache.thrift.protocol.TField("date", org.apache.thrift.protocol.TType.I64, (short)3);
  private static final org.apache.thrift.protocol.TField USER_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("userId", org.apache.thrift.protocol.TType.I64, (short)4);

  public long id; // required
  public List<MenuItem> chosenItems; // required
  public long date; // required
  public long userId; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ID((short)1, "id"),
    CHOSEN_ITEMS((short)2, "chosenItems"),
    DATE((short)3, "date"),
    USER_ID((short)4, "userId");

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
        case 2: // CHOSEN_ITEMS
          return CHOSEN_ITEMS;
        case 3: // DATE
          return DATE;
        case 4: // USER_ID
          return USER_ID;
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
  private static final int __DATE_ISSET_ID = 1;
  private static final int __USERID_ISSET_ID = 2;
  private BitSet __isset_bit_vector = new BitSet(3);

  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ID, new org.apache.thrift.meta_data.FieldMetaData("id", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64        , "Id")));
    tmpMap.put(_Fields.CHOSEN_ITEMS, new org.apache.thrift.meta_data.FieldMetaData("chosenItems", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, MenuItem.class))));
    tmpMap.put(_Fields.DATE, new org.apache.thrift.meta_data.FieldMetaData("date", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64        , "Timestamp")));
    tmpMap.put(_Fields.USER_ID, new org.apache.thrift.meta_data.FieldMetaData("userId", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64        , "Id")));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Order.class, metaDataMap);
  }

  public Order() {
  }

  public Order(
    long id,
    List<MenuItem> chosenItems,
    long date,
    long userId)
  {
    this();
    this.id = id;
    setIdIsSet(true);
    this.chosenItems = chosenItems;
    this.date = date;
    setDateIsSet(true);
    this.userId = userId;
    setUserIdIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Order(Order other) {
    __isset_bit_vector.clear();
    __isset_bit_vector.or(other.__isset_bit_vector);
    this.id = other.id;
    if (other.isSetChosenItems()) {
      List<MenuItem> __this__chosenItems = new ArrayList<MenuItem>();
      for (MenuItem other_element : other.chosenItems) {
        __this__chosenItems.add(new MenuItem(other_element));
      }
      this.chosenItems = __this__chosenItems;
    }
    this.date = other.date;
    this.userId = other.userId;
  }

  public Order deepCopy() {
    return new Order(this);
  }

  @Override
  public void clear() {
    setIdIsSet(false);
    this.id = 0;
    this.chosenItems = null;
    setDateIsSet(false);
    this.date = 0;
    setUserIdIsSet(false);
    this.userId = 0;
  }

  public long getId() {
    return this.id;
  }

  public Order setId(long id) {
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

  public int getChosenItemsSize() {
    return (this.chosenItems == null) ? 0 : this.chosenItems.size();
  }

  public java.util.Iterator<MenuItem> getChosenItemsIterator() {
    return (this.chosenItems == null) ? null : this.chosenItems.iterator();
  }

  public void addToChosenItems(MenuItem elem) {
    if (this.chosenItems == null) {
      this.chosenItems = new ArrayList<MenuItem>();
    }
    this.chosenItems.add(elem);
  }

  public List<MenuItem> getChosenItems() {
    return this.chosenItems;
  }

  public Order setChosenItems(List<MenuItem> chosenItems) {
    this.chosenItems = chosenItems;
    return this;
  }

  public void unsetChosenItems() {
    this.chosenItems = null;
  }

  /** Returns true if field chosenItems is set (has been assigned a value) and false otherwise */
  public boolean isSetChosenItems() {
    return this.chosenItems != null;
  }

  public void setChosenItemsIsSet(boolean value) {
    if (!value) {
      this.chosenItems = null;
    }
  }

  public long getDate() {
    return this.date;
  }

  public Order setDate(long date) {
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

  public long getUserId() {
    return this.userId;
  }

  public Order setUserId(long userId) {
    this.userId = userId;
    setUserIdIsSet(true);
    return this;
  }

  public void unsetUserId() {
    __isset_bit_vector.clear(__USERID_ISSET_ID);
  }

  /** Returns true if field userId is set (has been assigned a value) and false otherwise */
  public boolean isSetUserId() {
    return __isset_bit_vector.get(__USERID_ISSET_ID);
  }

  public void setUserIdIsSet(boolean value) {
    __isset_bit_vector.set(__USERID_ISSET_ID, value);
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

    case CHOSEN_ITEMS:
      if (value == null) {
        unsetChosenItems();
      } else {
        setChosenItems((List<MenuItem>)value);
      }
      break;

    case DATE:
      if (value == null) {
        unsetDate();
      } else {
        setDate((Long)value);
      }
      break;

    case USER_ID:
      if (value == null) {
        unsetUserId();
      } else {
        setUserId((Long)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case ID:
      return Long.valueOf(getId());

    case CHOSEN_ITEMS:
      return getChosenItems();

    case DATE:
      return Long.valueOf(getDate());

    case USER_ID:
      return Long.valueOf(getUserId());

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
    case CHOSEN_ITEMS:
      return isSetChosenItems();
    case DATE:
      return isSetDate();
    case USER_ID:
      return isSetUserId();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Order)
      return this.equals((Order)that);
    return false;
  }

  public boolean equals(Order that) {
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

    boolean this_present_chosenItems = true && this.isSetChosenItems();
    boolean that_present_chosenItems = true && that.isSetChosenItems();
    if (this_present_chosenItems || that_present_chosenItems) {
      if (!(this_present_chosenItems && that_present_chosenItems))
        return false;
      if (!this.chosenItems.equals(that.chosenItems))
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

    boolean this_present_userId = true;
    boolean that_present_userId = true;
    if (this_present_userId || that_present_userId) {
      if (!(this_present_userId && that_present_userId))
        return false;
      if (this.userId != that.userId)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(Order other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    Order typedOther = (Order)other;

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
    lastComparison = Boolean.valueOf(isSetChosenItems()).compareTo(typedOther.isSetChosenItems());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetChosenItems()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.chosenItems, typedOther.chosenItems);
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
    lastComparison = Boolean.valueOf(isSetUserId()).compareTo(typedOther.isSetUserId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUserId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.userId, typedOther.userId);
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
        case 2: // CHOSEN_ITEMS
          if (field.type == org.apache.thrift.protocol.TType.LIST) {
            {
              org.apache.thrift.protocol.TList _list28 = iprot.readListBegin();
              this.chosenItems = new ArrayList<MenuItem>(_list28.size);
              for (int _i29 = 0; _i29 < _list28.size; ++_i29)
              {
                MenuItem _elem30; // required
                _elem30 = new MenuItem();
                _elem30.read(iprot);
                this.chosenItems.add(_elem30);
              }
              iprot.readListEnd();
            }
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
        case 4: // USER_ID
          if (field.type == org.apache.thrift.protocol.TType.I64) {
            this.userId = iprot.readI64();
            setUserIdIsSet(true);
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
    if (!isSetDate()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'date' was not found in serialized data! Struct: " + toString());
    }
    if (!isSetUserId()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'userId' was not found in serialized data! Struct: " + toString());
    }
    validate();
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    validate();

    oprot.writeStructBegin(STRUCT_DESC);
    oprot.writeFieldBegin(ID_FIELD_DESC);
    oprot.writeI64(this.id);
    oprot.writeFieldEnd();
    if (this.chosenItems != null) {
      oprot.writeFieldBegin(CHOSEN_ITEMS_FIELD_DESC);
      {
        oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, this.chosenItems.size()));
        for (MenuItem _iter31 : this.chosenItems)
        {
          _iter31.write(oprot);
        }
        oprot.writeListEnd();
      }
      oprot.writeFieldEnd();
    }
    oprot.writeFieldBegin(DATE_FIELD_DESC);
    oprot.writeI64(this.date);
    oprot.writeFieldEnd();
    oprot.writeFieldBegin(USER_ID_FIELD_DESC);
    oprot.writeI64(this.userId);
    oprot.writeFieldEnd();
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Order(");
    boolean first = true;

    sb.append("id:");
    sb.append(this.id);
    first = false;
    if (!first) sb.append(", ");
    sb.append("chosenItems:");
    if (this.chosenItems == null) {
      sb.append("null");
    } else {
      sb.append(this.chosenItems);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("date:");
    sb.append(this.date);
    first = false;
    if (!first) sb.append(", ");
    sb.append("userId:");
    sb.append(this.userId);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // alas, we cannot check 'id' because it's a primitive and you chose the non-beans generator.
    if (chosenItems == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'chosenItems' was not present! Struct: " + toString());
    }
    // alas, we cannot check 'date' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'userId' because it's a primitive and you chose the non-beans generator.
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

