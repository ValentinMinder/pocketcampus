/**
 * Autogenerated by Thrift Compiler (0.7.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package org.pocketcampus.plugin.camipro.shared;

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

public class BalanceAndTransactions implements org.apache.thrift.TBase<BalanceAndTransactions, BalanceAndTransactions._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("BalanceAndTransactions");

  private static final org.apache.thrift.protocol.TField I_BALANCE_FIELD_DESC = new org.apache.thrift.protocol.TField("iBalance", org.apache.thrift.protocol.TType.DOUBLE, (short)1);
  private static final org.apache.thrift.protocol.TField I_TRANSACTIONS_FIELD_DESC = new org.apache.thrift.protocol.TField("iTransactions", org.apache.thrift.protocol.TType.LIST, (short)2);

  public double iBalance; // required
  public List<Transaction> iTransactions; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    I_BALANCE((short)1, "iBalance"),
    I_TRANSACTIONS((short)2, "iTransactions");

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
        case 1: // I_BALANCE
          return I_BALANCE;
        case 2: // I_TRANSACTIONS
          return I_TRANSACTIONS;
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
  private static final int __IBALANCE_ISSET_ID = 0;
  private BitSet __isset_bit_vector = new BitSet(1);

  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.I_BALANCE, new org.apache.thrift.meta_data.FieldMetaData("iBalance", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.I_TRANSACTIONS, new org.apache.thrift.meta_data.FieldMetaData("iTransactions", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, Transaction.class))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(BalanceAndTransactions.class, metaDataMap);
  }

  public BalanceAndTransactions() {
  }

  public BalanceAndTransactions(
    double iBalance,
    List<Transaction> iTransactions)
  {
    this();
    this.iBalance = iBalance;
    setIBalanceIsSet(true);
    this.iTransactions = iTransactions;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public BalanceAndTransactions(BalanceAndTransactions other) {
    __isset_bit_vector.clear();
    __isset_bit_vector.or(other.__isset_bit_vector);
    this.iBalance = other.iBalance;
    if (other.isSetITransactions()) {
      List<Transaction> __this__iTransactions = new ArrayList<Transaction>();
      for (Transaction other_element : other.iTransactions) {
        __this__iTransactions.add(new Transaction(other_element));
      }
      this.iTransactions = __this__iTransactions;
    }
  }

  public BalanceAndTransactions deepCopy() {
    return new BalanceAndTransactions(this);
  }

  @Override
  public void clear() {
    setIBalanceIsSet(false);
    this.iBalance = 0.0;
    this.iTransactions = null;
  }

  public double getIBalance() {
    return this.iBalance;
  }

  public BalanceAndTransactions setIBalance(double iBalance) {
    this.iBalance = iBalance;
    setIBalanceIsSet(true);
    return this;
  }

  public void unsetIBalance() {
    __isset_bit_vector.clear(__IBALANCE_ISSET_ID);
  }

  /** Returns true if field iBalance is set (has been assigned a value) and false otherwise */
  public boolean isSetIBalance() {
    return __isset_bit_vector.get(__IBALANCE_ISSET_ID);
  }

  public void setIBalanceIsSet(boolean value) {
    __isset_bit_vector.set(__IBALANCE_ISSET_ID, value);
  }

  public int getITransactionsSize() {
    return (this.iTransactions == null) ? 0 : this.iTransactions.size();
  }

  public java.util.Iterator<Transaction> getITransactionsIterator() {
    return (this.iTransactions == null) ? null : this.iTransactions.iterator();
  }

  public void addToITransactions(Transaction elem) {
    if (this.iTransactions == null) {
      this.iTransactions = new ArrayList<Transaction>();
    }
    this.iTransactions.add(elem);
  }

  public List<Transaction> getITransactions() {
    return this.iTransactions;
  }

  public BalanceAndTransactions setITransactions(List<Transaction> iTransactions) {
    this.iTransactions = iTransactions;
    return this;
  }

  public void unsetITransactions() {
    this.iTransactions = null;
  }

  /** Returns true if field iTransactions is set (has been assigned a value) and false otherwise */
  public boolean isSetITransactions() {
    return this.iTransactions != null;
  }

  public void setITransactionsIsSet(boolean value) {
    if (!value) {
      this.iTransactions = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case I_BALANCE:
      if (value == null) {
        unsetIBalance();
      } else {
        setIBalance((Double)value);
      }
      break;

    case I_TRANSACTIONS:
      if (value == null) {
        unsetITransactions();
      } else {
        setITransactions((List<Transaction>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case I_BALANCE:
      return Double.valueOf(getIBalance());

    case I_TRANSACTIONS:
      return getITransactions();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case I_BALANCE:
      return isSetIBalance();
    case I_TRANSACTIONS:
      return isSetITransactions();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof BalanceAndTransactions)
      return this.equals((BalanceAndTransactions)that);
    return false;
  }

  public boolean equals(BalanceAndTransactions that) {
    if (that == null)
      return false;

    boolean this_present_iBalance = true;
    boolean that_present_iBalance = true;
    if (this_present_iBalance || that_present_iBalance) {
      if (!(this_present_iBalance && that_present_iBalance))
        return false;
      if (this.iBalance != that.iBalance)
        return false;
    }

    boolean this_present_iTransactions = true && this.isSetITransactions();
    boolean that_present_iTransactions = true && that.isSetITransactions();
    if (this_present_iTransactions || that_present_iTransactions) {
      if (!(this_present_iTransactions && that_present_iTransactions))
        return false;
      if (!this.iTransactions.equals(that.iTransactions))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_iBalance = true;
    builder.append(present_iBalance);
    if (present_iBalance)
      builder.append(iBalance);

    boolean present_iTransactions = true && (isSetITransactions());
    builder.append(present_iTransactions);
    if (present_iTransactions)
      builder.append(iTransactions);

    return builder.toHashCode();
  }

  public int compareTo(BalanceAndTransactions other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    BalanceAndTransactions typedOther = (BalanceAndTransactions)other;

    lastComparison = Boolean.valueOf(isSetIBalance()).compareTo(typedOther.isSetIBalance());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetIBalance()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.iBalance, typedOther.iBalance);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetITransactions()).compareTo(typedOther.isSetITransactions());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetITransactions()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.iTransactions, typedOther.iTransactions);
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
        case 1: // I_BALANCE
          if (field.type == org.apache.thrift.protocol.TType.DOUBLE) {
            this.iBalance = iprot.readDouble();
            setIBalanceIsSet(true);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // I_TRANSACTIONS
          if (field.type == org.apache.thrift.protocol.TType.LIST) {
            {
              org.apache.thrift.protocol.TList _list0 = iprot.readListBegin();
              this.iTransactions = new ArrayList<Transaction>(_list0.size);
              for (int _i1 = 0; _i1 < _list0.size; ++_i1)
              {
                Transaction _elem2; // required
                _elem2 = new Transaction();
                _elem2.read(iprot);
                this.iTransactions.add(_elem2);
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
    if (!isSetIBalance()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'iBalance' was not found in serialized data! Struct: " + toString());
    }
    validate();
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    validate();

    oprot.writeStructBegin(STRUCT_DESC);
    oprot.writeFieldBegin(I_BALANCE_FIELD_DESC);
    oprot.writeDouble(this.iBalance);
    oprot.writeFieldEnd();
    if (this.iTransactions != null) {
      oprot.writeFieldBegin(I_TRANSACTIONS_FIELD_DESC);
      {
        oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, this.iTransactions.size()));
        for (Transaction _iter3 : this.iTransactions)
        {
          _iter3.write(oprot);
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
    StringBuilder sb = new StringBuilder("BalanceAndTransactions(");
    boolean first = true;

    sb.append("iBalance:");
    sb.append(this.iBalance);
    first = false;
    if (!first) sb.append(", ");
    sb.append("iTransactions:");
    if (this.iTransactions == null) {
      sb.append("null");
    } else {
      sb.append(this.iTransactions);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // alas, we cannot check 'iBalance' because it's a primitive and you chose the non-beans generator.
    if (iTransactions == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'iTransactions' was not present! Struct: " + toString());
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

