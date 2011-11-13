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

public class PendingOrders implements org.apache.thrift.TBase<PendingOrders, PendingOrders._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("PendingOrders");

  private static final org.apache.thrift.protocol.TField ORDERS_FIELD_DESC = new org.apache.thrift.protocol.TField("orders", org.apache.thrift.protocol.TType.LIST, (short)1);

  public List<CookReceivedOrder> orders; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ORDERS((short)1, "orders");

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
        case 1: // ORDERS
          return ORDERS;
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
    tmpMap.put(_Fields.ORDERS, new org.apache.thrift.meta_data.FieldMetaData("orders", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, CookReceivedOrder.class))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(PendingOrders.class, metaDataMap);
  }

  public PendingOrders() {
  }

  public PendingOrders(
    List<CookReceivedOrder> orders)
  {
    this();
    this.orders = orders;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public PendingOrders(PendingOrders other) {
    if (other.isSetOrders()) {
      List<CookReceivedOrder> __this__orders = new ArrayList<CookReceivedOrder>();
      for (CookReceivedOrder other_element : other.orders) {
        __this__orders.add(new CookReceivedOrder(other_element));
      }
      this.orders = __this__orders;
    }
  }

  public PendingOrders deepCopy() {
    return new PendingOrders(this);
  }

  @Override
  public void clear() {
    this.orders = null;
  }

  public int getOrdersSize() {
    return (this.orders == null) ? 0 : this.orders.size();
  }

  public java.util.Iterator<CookReceivedOrder> getOrdersIterator() {
    return (this.orders == null) ? null : this.orders.iterator();
  }

  public void addToOrders(CookReceivedOrder elem) {
    if (this.orders == null) {
      this.orders = new ArrayList<CookReceivedOrder>();
    }
    this.orders.add(elem);
  }

  public List<CookReceivedOrder> getOrders() {
    return this.orders;
  }

  public PendingOrders setOrders(List<CookReceivedOrder> orders) {
    this.orders = orders;
    return this;
  }

  public void unsetOrders() {
    this.orders = null;
  }

  /** Returns true if field orders is set (has been assigned a value) and false otherwise */
  public boolean isSetOrders() {
    return this.orders != null;
  }

  public void setOrdersIsSet(boolean value) {
    if (!value) {
      this.orders = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case ORDERS:
      if (value == null) {
        unsetOrders();
      } else {
        setOrders((List<CookReceivedOrder>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case ORDERS:
      return getOrders();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case ORDERS:
      return isSetOrders();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof PendingOrders)
      return this.equals((PendingOrders)that);
    return false;
  }

  public boolean equals(PendingOrders that) {
    if (that == null)
      return false;

    boolean this_present_orders = true && this.isSetOrders();
    boolean that_present_orders = true && that.isSetOrders();
    if (this_present_orders || that_present_orders) {
      if (!(this_present_orders && that_present_orders))
        return false;
      if (!this.orders.equals(that.orders))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(PendingOrders other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    PendingOrders typedOther = (PendingOrders)other;

    lastComparison = Boolean.valueOf(isSetOrders()).compareTo(typedOther.isSetOrders());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetOrders()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.orders, typedOther.orders);
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
        case 1: // ORDERS
          if (field.type == org.apache.thrift.protocol.TType.LIST) {
            {
              org.apache.thrift.protocol.TList _list50 = iprot.readListBegin();
              this.orders = new ArrayList<CookReceivedOrder>(_list50.size);
              for (int _i51 = 0; _i51 < _list50.size; ++_i51)
              {
                CookReceivedOrder _elem52; // required
                _elem52 = new CookReceivedOrder();
                _elem52.read(iprot);
                this.orders.add(_elem52);
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
    if (this.orders != null) {
      oprot.writeFieldBegin(ORDERS_FIELD_DESC);
      {
        oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, this.orders.size()));
        for (CookReceivedOrder _iter53 : this.orders)
        {
          _iter53.write(oprot);
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
    StringBuilder sb = new StringBuilder("PendingOrders(");
    boolean first = true;

    sb.append("orders:");
    if (this.orders == null) {
      sb.append("null");
    } else {
      sb.append(this.orders);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
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

