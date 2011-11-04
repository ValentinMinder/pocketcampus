/**
 * Autogenerated by Thrift Compiler (0.7.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package org.pocketcampus.plugin.camipro.shared;

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

public class EbankingBean implements org.apache.thrift.TBase<EbankingBean, EbankingBean._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("EbankingBean");

  private static final org.apache.thrift.protocol.TField PAID_NAME_TO_FIELD_DESC = new org.apache.thrift.protocol.TField("paidNameTo", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField ACCOUNT_NR_FIELD_DESC = new org.apache.thrift.protocol.TField("accountNr", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField BVR_REFERENCE_FIELD_DESC = new org.apache.thrift.protocol.TField("BvrReference", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField BVR_REFERENCE_READABLE_FIELD_DESC = new org.apache.thrift.protocol.TField("BvrReferenceReadable", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField TOTAL1_M_FIELD_DESC = new org.apache.thrift.protocol.TField("total1M", org.apache.thrift.protocol.TType.DOUBLE, (short)5);
  private static final org.apache.thrift.protocol.TField TOTAL3_M_FIELD_DESC = new org.apache.thrift.protocol.TField("total3M", org.apache.thrift.protocol.TType.DOUBLE, (short)6);
  private static final org.apache.thrift.protocol.TField AVERAGE3_M_FIELD_DESC = new org.apache.thrift.protocol.TField("average3M", org.apache.thrift.protocol.TType.DOUBLE, (short)7);

  public String paidNameTo; // required
  public String accountNr; // required
  public String BvrReference; // required
  public String BvrReferenceReadable; // required
  public double total1M; // required
  public double total3M; // required
  public double average3M; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    PAID_NAME_TO((short)1, "paidNameTo"),
    ACCOUNT_NR((short)2, "accountNr"),
    BVR_REFERENCE((short)3, "BvrReference"),
    BVR_REFERENCE_READABLE((short)4, "BvrReferenceReadable"),
    TOTAL1_M((short)5, "total1M"),
    TOTAL3_M((short)6, "total3M"),
    AVERAGE3_M((short)7, "average3M");

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
        case 1: // PAID_NAME_TO
          return PAID_NAME_TO;
        case 2: // ACCOUNT_NR
          return ACCOUNT_NR;
        case 3: // BVR_REFERENCE
          return BVR_REFERENCE;
        case 4: // BVR_REFERENCE_READABLE
          return BVR_REFERENCE_READABLE;
        case 5: // TOTAL1_M
          return TOTAL1_M;
        case 6: // TOTAL3_M
          return TOTAL3_M;
        case 7: // AVERAGE3_M
          return AVERAGE3_M;
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
  private static final int __TOTAL1M_ISSET_ID = 0;
  private static final int __TOTAL3M_ISSET_ID = 1;
  private static final int __AVERAGE3M_ISSET_ID = 2;
  private BitSet __isset_bit_vector = new BitSet(3);

  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.PAID_NAME_TO, new org.apache.thrift.meta_data.FieldMetaData("paidNameTo", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.ACCOUNT_NR, new org.apache.thrift.meta_data.FieldMetaData("accountNr", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.BVR_REFERENCE, new org.apache.thrift.meta_data.FieldMetaData("BvrReference", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.BVR_REFERENCE_READABLE, new org.apache.thrift.meta_data.FieldMetaData("BvrReferenceReadable", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.TOTAL1_M, new org.apache.thrift.meta_data.FieldMetaData("total1M", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.TOTAL3_M, new org.apache.thrift.meta_data.FieldMetaData("total3M", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.AVERAGE3_M, new org.apache.thrift.meta_data.FieldMetaData("average3M", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(EbankingBean.class, metaDataMap);
  }

  public EbankingBean() {
  }

  public EbankingBean(
    String paidNameTo,
    String accountNr,
    String BvrReference,
    String BvrReferenceReadable,
    double total1M,
    double total3M,
    double average3M)
  {
    this();
    this.paidNameTo = paidNameTo;
    this.accountNr = accountNr;
    this.BvrReference = BvrReference;
    this.BvrReferenceReadable = BvrReferenceReadable;
    this.total1M = total1M;
    setTotal1MIsSet(true);
    this.total3M = total3M;
    setTotal3MIsSet(true);
    this.average3M = average3M;
    setAverage3MIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public EbankingBean(EbankingBean other) {
    __isset_bit_vector.clear();
    __isset_bit_vector.or(other.__isset_bit_vector);
    if (other.isSetPaidNameTo()) {
      this.paidNameTo = other.paidNameTo;
    }
    if (other.isSetAccountNr()) {
      this.accountNr = other.accountNr;
    }
    if (other.isSetBvrReference()) {
      this.BvrReference = other.BvrReference;
    }
    if (other.isSetBvrReferenceReadable()) {
      this.BvrReferenceReadable = other.BvrReferenceReadable;
    }
    this.total1M = other.total1M;
    this.total3M = other.total3M;
    this.average3M = other.average3M;
  }

  public EbankingBean deepCopy() {
    return new EbankingBean(this);
  }

  @Override
  public void clear() {
    this.paidNameTo = null;
    this.accountNr = null;
    this.BvrReference = null;
    this.BvrReferenceReadable = null;
    setTotal1MIsSet(false);
    this.total1M = 0.0;
    setTotal3MIsSet(false);
    this.total3M = 0.0;
    setAverage3MIsSet(false);
    this.average3M = 0.0;
  }

  public String getPaidNameTo() {
    return this.paidNameTo;
  }

  public EbankingBean setPaidNameTo(String paidNameTo) {
    this.paidNameTo = paidNameTo;
    return this;
  }

  public void unsetPaidNameTo() {
    this.paidNameTo = null;
  }

  /** Returns true if field paidNameTo is set (has been assigned a value) and false otherwise */
  public boolean isSetPaidNameTo() {
    return this.paidNameTo != null;
  }

  public void setPaidNameToIsSet(boolean value) {
    if (!value) {
      this.paidNameTo = null;
    }
  }

  public String getAccountNr() {
    return this.accountNr;
  }

  public EbankingBean setAccountNr(String accountNr) {
    this.accountNr = accountNr;
    return this;
  }

  public void unsetAccountNr() {
    this.accountNr = null;
  }

  /** Returns true if field accountNr is set (has been assigned a value) and false otherwise */
  public boolean isSetAccountNr() {
    return this.accountNr != null;
  }

  public void setAccountNrIsSet(boolean value) {
    if (!value) {
      this.accountNr = null;
    }
  }

  public String getBvrReference() {
    return this.BvrReference;
  }

  public EbankingBean setBvrReference(String BvrReference) {
    this.BvrReference = BvrReference;
    return this;
  }

  public void unsetBvrReference() {
    this.BvrReference = null;
  }

  /** Returns true if field BvrReference is set (has been assigned a value) and false otherwise */
  public boolean isSetBvrReference() {
    return this.BvrReference != null;
  }

  public void setBvrReferenceIsSet(boolean value) {
    if (!value) {
      this.BvrReference = null;
    }
  }

  public String getBvrReferenceReadable() {
    return this.BvrReferenceReadable;
  }

  public EbankingBean setBvrReferenceReadable(String BvrReferenceReadable) {
    this.BvrReferenceReadable = BvrReferenceReadable;
    return this;
  }

  public void unsetBvrReferenceReadable() {
    this.BvrReferenceReadable = null;
  }

  /** Returns true if field BvrReferenceReadable is set (has been assigned a value) and false otherwise */
  public boolean isSetBvrReferenceReadable() {
    return this.BvrReferenceReadable != null;
  }

  public void setBvrReferenceReadableIsSet(boolean value) {
    if (!value) {
      this.BvrReferenceReadable = null;
    }
  }

  public double getTotal1M() {
    return this.total1M;
  }

  public EbankingBean setTotal1M(double total1M) {
    this.total1M = total1M;
    setTotal1MIsSet(true);
    return this;
  }

  public void unsetTotal1M() {
    __isset_bit_vector.clear(__TOTAL1M_ISSET_ID);
  }

  /** Returns true if field total1M is set (has been assigned a value) and false otherwise */
  public boolean isSetTotal1M() {
    return __isset_bit_vector.get(__TOTAL1M_ISSET_ID);
  }

  public void setTotal1MIsSet(boolean value) {
    __isset_bit_vector.set(__TOTAL1M_ISSET_ID, value);
  }

  public double getTotal3M() {
    return this.total3M;
  }

  public EbankingBean setTotal3M(double total3M) {
    this.total3M = total3M;
    setTotal3MIsSet(true);
    return this;
  }

  public void unsetTotal3M() {
    __isset_bit_vector.clear(__TOTAL3M_ISSET_ID);
  }

  /** Returns true if field total3M is set (has been assigned a value) and false otherwise */
  public boolean isSetTotal3M() {
    return __isset_bit_vector.get(__TOTAL3M_ISSET_ID);
  }

  public void setTotal3MIsSet(boolean value) {
    __isset_bit_vector.set(__TOTAL3M_ISSET_ID, value);
  }

  public double getAverage3M() {
    return this.average3M;
  }

  public EbankingBean setAverage3M(double average3M) {
    this.average3M = average3M;
    setAverage3MIsSet(true);
    return this;
  }

  public void unsetAverage3M() {
    __isset_bit_vector.clear(__AVERAGE3M_ISSET_ID);
  }

  /** Returns true if field average3M is set (has been assigned a value) and false otherwise */
  public boolean isSetAverage3M() {
    return __isset_bit_vector.get(__AVERAGE3M_ISSET_ID);
  }

  public void setAverage3MIsSet(boolean value) {
    __isset_bit_vector.set(__AVERAGE3M_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case PAID_NAME_TO:
      if (value == null) {
        unsetPaidNameTo();
      } else {
        setPaidNameTo((String)value);
      }
      break;

    case ACCOUNT_NR:
      if (value == null) {
        unsetAccountNr();
      } else {
        setAccountNr((String)value);
      }
      break;

    case BVR_REFERENCE:
      if (value == null) {
        unsetBvrReference();
      } else {
        setBvrReference((String)value);
      }
      break;

    case BVR_REFERENCE_READABLE:
      if (value == null) {
        unsetBvrReferenceReadable();
      } else {
        setBvrReferenceReadable((String)value);
      }
      break;

    case TOTAL1_M:
      if (value == null) {
        unsetTotal1M();
      } else {
        setTotal1M((Double)value);
      }
      break;

    case TOTAL3_M:
      if (value == null) {
        unsetTotal3M();
      } else {
        setTotal3M((Double)value);
      }
      break;

    case AVERAGE3_M:
      if (value == null) {
        unsetAverage3M();
      } else {
        setAverage3M((Double)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case PAID_NAME_TO:
      return getPaidNameTo();

    case ACCOUNT_NR:
      return getAccountNr();

    case BVR_REFERENCE:
      return getBvrReference();

    case BVR_REFERENCE_READABLE:
      return getBvrReferenceReadable();

    case TOTAL1_M:
      return Double.valueOf(getTotal1M());

    case TOTAL3_M:
      return Double.valueOf(getTotal3M());

    case AVERAGE3_M:
      return Double.valueOf(getAverage3M());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case PAID_NAME_TO:
      return isSetPaidNameTo();
    case ACCOUNT_NR:
      return isSetAccountNr();
    case BVR_REFERENCE:
      return isSetBvrReference();
    case BVR_REFERENCE_READABLE:
      return isSetBvrReferenceReadable();
    case TOTAL1_M:
      return isSetTotal1M();
    case TOTAL3_M:
      return isSetTotal3M();
    case AVERAGE3_M:
      return isSetAverage3M();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof EbankingBean)
      return this.equals((EbankingBean)that);
    return false;
  }

  public boolean equals(EbankingBean that) {
    if (that == null)
      return false;

    boolean this_present_paidNameTo = true && this.isSetPaidNameTo();
    boolean that_present_paidNameTo = true && that.isSetPaidNameTo();
    if (this_present_paidNameTo || that_present_paidNameTo) {
      if (!(this_present_paidNameTo && that_present_paidNameTo))
        return false;
      if (!this.paidNameTo.equals(that.paidNameTo))
        return false;
    }

    boolean this_present_accountNr = true && this.isSetAccountNr();
    boolean that_present_accountNr = true && that.isSetAccountNr();
    if (this_present_accountNr || that_present_accountNr) {
      if (!(this_present_accountNr && that_present_accountNr))
        return false;
      if (!this.accountNr.equals(that.accountNr))
        return false;
    }

    boolean this_present_BvrReference = true && this.isSetBvrReference();
    boolean that_present_BvrReference = true && that.isSetBvrReference();
    if (this_present_BvrReference || that_present_BvrReference) {
      if (!(this_present_BvrReference && that_present_BvrReference))
        return false;
      if (!this.BvrReference.equals(that.BvrReference))
        return false;
    }

    boolean this_present_BvrReferenceReadable = true && this.isSetBvrReferenceReadable();
    boolean that_present_BvrReferenceReadable = true && that.isSetBvrReferenceReadable();
    if (this_present_BvrReferenceReadable || that_present_BvrReferenceReadable) {
      if (!(this_present_BvrReferenceReadable && that_present_BvrReferenceReadable))
        return false;
      if (!this.BvrReferenceReadable.equals(that.BvrReferenceReadable))
        return false;
    }

    boolean this_present_total1M = true;
    boolean that_present_total1M = true;
    if (this_present_total1M || that_present_total1M) {
      if (!(this_present_total1M && that_present_total1M))
        return false;
      if (this.total1M != that.total1M)
        return false;
    }

    boolean this_present_total3M = true;
    boolean that_present_total3M = true;
    if (this_present_total3M || that_present_total3M) {
      if (!(this_present_total3M && that_present_total3M))
        return false;
      if (this.total3M != that.total3M)
        return false;
    }

    boolean this_present_average3M = true;
    boolean that_present_average3M = true;
    if (this_present_average3M || that_present_average3M) {
      if (!(this_present_average3M && that_present_average3M))
        return false;
      if (this.average3M != that.average3M)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(EbankingBean other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    EbankingBean typedOther = (EbankingBean)other;

    lastComparison = Boolean.valueOf(isSetPaidNameTo()).compareTo(typedOther.isSetPaidNameTo());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPaidNameTo()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.paidNameTo, typedOther.paidNameTo);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetAccountNr()).compareTo(typedOther.isSetAccountNr());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAccountNr()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.accountNr, typedOther.accountNr);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetBvrReference()).compareTo(typedOther.isSetBvrReference());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBvrReference()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.BvrReference, typedOther.BvrReference);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetBvrReferenceReadable()).compareTo(typedOther.isSetBvrReferenceReadable());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBvrReferenceReadable()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.BvrReferenceReadable, typedOther.BvrReferenceReadable);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTotal1M()).compareTo(typedOther.isSetTotal1M());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTotal1M()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.total1M, typedOther.total1M);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTotal3M()).compareTo(typedOther.isSetTotal3M());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTotal3M()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.total3M, typedOther.total3M);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetAverage3M()).compareTo(typedOther.isSetAverage3M());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAverage3M()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.average3M, typedOther.average3M);
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
        case 1: // PAID_NAME_TO
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.paidNameTo = iprot.readString();
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // ACCOUNT_NR
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.accountNr = iprot.readString();
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 3: // BVR_REFERENCE
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.BvrReference = iprot.readString();
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 4: // BVR_REFERENCE_READABLE
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.BvrReferenceReadable = iprot.readString();
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 5: // TOTAL1_M
          if (field.type == org.apache.thrift.protocol.TType.DOUBLE) {
            this.total1M = iprot.readDouble();
            setTotal1MIsSet(true);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 6: // TOTAL3_M
          if (field.type == org.apache.thrift.protocol.TType.DOUBLE) {
            this.total3M = iprot.readDouble();
            setTotal3MIsSet(true);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 7: // AVERAGE3_M
          if (field.type == org.apache.thrift.protocol.TType.DOUBLE) {
            this.average3M = iprot.readDouble();
            setAverage3MIsSet(true);
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
    if (!isSetTotal1M()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'total1M' was not found in serialized data! Struct: " + toString());
    }
    if (!isSetTotal3M()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'total3M' was not found in serialized data! Struct: " + toString());
    }
    if (!isSetAverage3M()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'average3M' was not found in serialized data! Struct: " + toString());
    }
    validate();
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    validate();

    oprot.writeStructBegin(STRUCT_DESC);
    if (this.paidNameTo != null) {
      oprot.writeFieldBegin(PAID_NAME_TO_FIELD_DESC);
      oprot.writeString(this.paidNameTo);
      oprot.writeFieldEnd();
    }
    if (this.accountNr != null) {
      oprot.writeFieldBegin(ACCOUNT_NR_FIELD_DESC);
      oprot.writeString(this.accountNr);
      oprot.writeFieldEnd();
    }
    if (this.BvrReference != null) {
      oprot.writeFieldBegin(BVR_REFERENCE_FIELD_DESC);
      oprot.writeString(this.BvrReference);
      oprot.writeFieldEnd();
    }
    if (this.BvrReferenceReadable != null) {
      oprot.writeFieldBegin(BVR_REFERENCE_READABLE_FIELD_DESC);
      oprot.writeString(this.BvrReferenceReadable);
      oprot.writeFieldEnd();
    }
    oprot.writeFieldBegin(TOTAL1_M_FIELD_DESC);
    oprot.writeDouble(this.total1M);
    oprot.writeFieldEnd();
    oprot.writeFieldBegin(TOTAL3_M_FIELD_DESC);
    oprot.writeDouble(this.total3M);
    oprot.writeFieldEnd();
    oprot.writeFieldBegin(AVERAGE3_M_FIELD_DESC);
    oprot.writeDouble(this.average3M);
    oprot.writeFieldEnd();
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("EbankingBean(");
    boolean first = true;

    sb.append("paidNameTo:");
    if (this.paidNameTo == null) {
      sb.append("null");
    } else {
      sb.append(this.paidNameTo);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("accountNr:");
    if (this.accountNr == null) {
      sb.append("null");
    } else {
      sb.append(this.accountNr);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("BvrReference:");
    if (this.BvrReference == null) {
      sb.append("null");
    } else {
      sb.append(this.BvrReference);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("BvrReferenceReadable:");
    if (this.BvrReferenceReadable == null) {
      sb.append("null");
    } else {
      sb.append(this.BvrReferenceReadable);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("total1M:");
    sb.append(this.total1M);
    first = false;
    if (!first) sb.append(", ");
    sb.append("total3M:");
    sb.append(this.total3M);
    first = false;
    if (!first) sb.append(", ");
    sb.append("average3M:");
    sb.append(this.average3M);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (paidNameTo == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'paidNameTo' was not present! Struct: " + toString());
    }
    if (accountNr == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'accountNr' was not present! Struct: " + toString());
    }
    if (BvrReference == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'BvrReference' was not present! Struct: " + toString());
    }
    if (BvrReferenceReadable == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'BvrReferenceReadable' was not present! Struct: " + toString());
    }
    // alas, we cannot check 'total1M' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'total3M' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'average3M' because it's a primitive and you chose the non-beans generator.
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
