/**
 * Autogenerated by Thrift Compiler (0.9.2)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.pocketcampus.plugin.recommendedapps.shared;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
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
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.2)", date = "2014-11-28")
public class RecommendedAppCategory implements org.apache.thrift.TBase<RecommendedAppCategory, RecommendedAppCategory._Fields>, java.io.Serializable, Cloneable, Comparable<RecommendedAppCategory> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("RecommendedAppCategory");

  private static final org.apache.thrift.protocol.TField CATEGORY_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("categoryName", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField CATEGORY_LOGO_URL_FIELD_DESC = new org.apache.thrift.protocol.TField("categoryLogoURL", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField CATEGORY_DESCRIPTION_FIELD_DESC = new org.apache.thrift.protocol.TField("categoryDescription", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField APP_IDS_FIELD_DESC = new org.apache.thrift.protocol.TField("appIds", org.apache.thrift.protocol.TType.LIST, (short)4);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new RecommendedAppCategoryStandardSchemeFactory());
    schemes.put(TupleScheme.class, new RecommendedAppCategoryTupleSchemeFactory());
  }

  private String categoryName; // required
  private String categoryLogoURL; // optional
  private String categoryDescription; // required
  private List<Integer> appIds; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    CATEGORY_NAME((short)1, "categoryName"),
    CATEGORY_LOGO_URL((short)2, "categoryLogoURL"),
    CATEGORY_DESCRIPTION((short)3, "categoryDescription"),
    APP_IDS((short)4, "appIds");

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
        case 1: // CATEGORY_NAME
          return CATEGORY_NAME;
        case 2: // CATEGORY_LOGO_URL
          return CATEGORY_LOGO_URL;
        case 3: // CATEGORY_DESCRIPTION
          return CATEGORY_DESCRIPTION;
        case 4: // APP_IDS
          return APP_IDS;
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
  private static final _Fields optionals[] = {_Fields.CATEGORY_LOGO_URL};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.CATEGORY_NAME, new org.apache.thrift.meta_data.FieldMetaData("categoryName", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.CATEGORY_LOGO_URL, new org.apache.thrift.meta_data.FieldMetaData("categoryLogoURL", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.CATEGORY_DESCRIPTION, new org.apache.thrift.meta_data.FieldMetaData("categoryDescription", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.APP_IDS, new org.apache.thrift.meta_data.FieldMetaData("appIds", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(RecommendedAppCategory.class, metaDataMap);
  }

  public RecommendedAppCategory() {
  }

  public RecommendedAppCategory(
    String categoryName,
    String categoryDescription,
    List<Integer> appIds)
  {
    this();
    this.categoryName = categoryName;
    this.categoryDescription = categoryDescription;
    this.appIds = appIds;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public RecommendedAppCategory(RecommendedAppCategory other) {
    if (other.isSetCategoryName()) {
      this.categoryName = other.categoryName;
    }
    if (other.isSetCategoryLogoURL()) {
      this.categoryLogoURL = other.categoryLogoURL;
    }
    if (other.isSetCategoryDescription()) {
      this.categoryDescription = other.categoryDescription;
    }
    if (other.isSetAppIds()) {
      List<Integer> __this__appIds = new ArrayList<Integer>(other.appIds);
      this.appIds = __this__appIds;
    }
  }

  public RecommendedAppCategory deepCopy() {
    return new RecommendedAppCategory(this);
  }

  @Override
  public void clear() {
    this.categoryName = null;
    this.categoryLogoURL = null;
    this.categoryDescription = null;
    this.appIds = null;
  }

  public String getCategoryName() {
    return this.categoryName;
  }

  public RecommendedAppCategory setCategoryName(String categoryName) {
    this.categoryName = categoryName;
    return this;
  }

  public void unsetCategoryName() {
    this.categoryName = null;
  }

  /** Returns true if field categoryName is set (has been assigned a value) and false otherwise */
  public boolean isSetCategoryName() {
    return this.categoryName != null;
  }

  public void setCategoryNameIsSet(boolean value) {
    if (!value) {
      this.categoryName = null;
    }
  }

  public String getCategoryLogoURL() {
    return this.categoryLogoURL;
  }

  public RecommendedAppCategory setCategoryLogoURL(String categoryLogoURL) {
    this.categoryLogoURL = categoryLogoURL;
    return this;
  }

  public void unsetCategoryLogoURL() {
    this.categoryLogoURL = null;
  }

  /** Returns true if field categoryLogoURL is set (has been assigned a value) and false otherwise */
  public boolean isSetCategoryLogoURL() {
    return this.categoryLogoURL != null;
  }

  public void setCategoryLogoURLIsSet(boolean value) {
    if (!value) {
      this.categoryLogoURL = null;
    }
  }

  public String getCategoryDescription() {
    return this.categoryDescription;
  }

  public RecommendedAppCategory setCategoryDescription(String categoryDescription) {
    this.categoryDescription = categoryDescription;
    return this;
  }

  public void unsetCategoryDescription() {
    this.categoryDescription = null;
  }

  /** Returns true if field categoryDescription is set (has been assigned a value) and false otherwise */
  public boolean isSetCategoryDescription() {
    return this.categoryDescription != null;
  }

  public void setCategoryDescriptionIsSet(boolean value) {
    if (!value) {
      this.categoryDescription = null;
    }
  }

  public int getAppIdsSize() {
    return (this.appIds == null) ? 0 : this.appIds.size();
  }

  public java.util.Iterator<Integer> getAppIdsIterator() {
    return (this.appIds == null) ? null : this.appIds.iterator();
  }

  public void addToAppIds(int elem) {
    if (this.appIds == null) {
      this.appIds = new ArrayList<Integer>();
    }
    this.appIds.add(elem);
  }

  public List<Integer> getAppIds() {
    return this.appIds;
  }

  public RecommendedAppCategory setAppIds(List<Integer> appIds) {
    this.appIds = appIds;
    return this;
  }

  public void unsetAppIds() {
    this.appIds = null;
  }

  /** Returns true if field appIds is set (has been assigned a value) and false otherwise */
  public boolean isSetAppIds() {
    return this.appIds != null;
  }

  public void setAppIdsIsSet(boolean value) {
    if (!value) {
      this.appIds = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case CATEGORY_NAME:
      if (value == null) {
        unsetCategoryName();
      } else {
        setCategoryName((String)value);
      }
      break;

    case CATEGORY_LOGO_URL:
      if (value == null) {
        unsetCategoryLogoURL();
      } else {
        setCategoryLogoURL((String)value);
      }
      break;

    case CATEGORY_DESCRIPTION:
      if (value == null) {
        unsetCategoryDescription();
      } else {
        setCategoryDescription((String)value);
      }
      break;

    case APP_IDS:
      if (value == null) {
        unsetAppIds();
      } else {
        setAppIds((List<Integer>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case CATEGORY_NAME:
      return getCategoryName();

    case CATEGORY_LOGO_URL:
      return getCategoryLogoURL();

    case CATEGORY_DESCRIPTION:
      return getCategoryDescription();

    case APP_IDS:
      return getAppIds();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case CATEGORY_NAME:
      return isSetCategoryName();
    case CATEGORY_LOGO_URL:
      return isSetCategoryLogoURL();
    case CATEGORY_DESCRIPTION:
      return isSetCategoryDescription();
    case APP_IDS:
      return isSetAppIds();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof RecommendedAppCategory)
      return this.equals((RecommendedAppCategory)that);
    return false;
  }

  public boolean equals(RecommendedAppCategory that) {
    if (that == null)
      return false;

    boolean this_present_categoryName = true && this.isSetCategoryName();
    boolean that_present_categoryName = true && that.isSetCategoryName();
    if (this_present_categoryName || that_present_categoryName) {
      if (!(this_present_categoryName && that_present_categoryName))
        return false;
      if (!this.categoryName.equals(that.categoryName))
        return false;
    }

    boolean this_present_categoryLogoURL = true && this.isSetCategoryLogoURL();
    boolean that_present_categoryLogoURL = true && that.isSetCategoryLogoURL();
    if (this_present_categoryLogoURL || that_present_categoryLogoURL) {
      if (!(this_present_categoryLogoURL && that_present_categoryLogoURL))
        return false;
      if (!this.categoryLogoURL.equals(that.categoryLogoURL))
        return false;
    }

    boolean this_present_categoryDescription = true && this.isSetCategoryDescription();
    boolean that_present_categoryDescription = true && that.isSetCategoryDescription();
    if (this_present_categoryDescription || that_present_categoryDescription) {
      if (!(this_present_categoryDescription && that_present_categoryDescription))
        return false;
      if (!this.categoryDescription.equals(that.categoryDescription))
        return false;
    }

    boolean this_present_appIds = true && this.isSetAppIds();
    boolean that_present_appIds = true && that.isSetAppIds();
    if (this_present_appIds || that_present_appIds) {
      if (!(this_present_appIds && that_present_appIds))
        return false;
      if (!this.appIds.equals(that.appIds))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_categoryName = true && (isSetCategoryName());
    list.add(present_categoryName);
    if (present_categoryName)
      list.add(categoryName);

    boolean present_categoryLogoURL = true && (isSetCategoryLogoURL());
    list.add(present_categoryLogoURL);
    if (present_categoryLogoURL)
      list.add(categoryLogoURL);

    boolean present_categoryDescription = true && (isSetCategoryDescription());
    list.add(present_categoryDescription);
    if (present_categoryDescription)
      list.add(categoryDescription);

    boolean present_appIds = true && (isSetAppIds());
    list.add(present_appIds);
    if (present_appIds)
      list.add(appIds);

    return list.hashCode();
  }

  @Override
  public int compareTo(RecommendedAppCategory other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetCategoryName()).compareTo(other.isSetCategoryName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCategoryName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.categoryName, other.categoryName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetCategoryLogoURL()).compareTo(other.isSetCategoryLogoURL());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCategoryLogoURL()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.categoryLogoURL, other.categoryLogoURL);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetCategoryDescription()).compareTo(other.isSetCategoryDescription());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCategoryDescription()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.categoryDescription, other.categoryDescription);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetAppIds()).compareTo(other.isSetAppIds());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAppIds()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.appIds, other.appIds);
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
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("RecommendedAppCategory(");
    boolean first = true;

    sb.append("categoryName:");
    if (this.categoryName == null) {
      sb.append("null");
    } else {
      sb.append(this.categoryName);
    }
    first = false;
    if (isSetCategoryLogoURL()) {
      if (!first) sb.append(", ");
      sb.append("categoryLogoURL:");
      if (this.categoryLogoURL == null) {
        sb.append("null");
      } else {
        sb.append(this.categoryLogoURL);
      }
      first = false;
    }
    if (!first) sb.append(", ");
    sb.append("categoryDescription:");
    if (this.categoryDescription == null) {
      sb.append("null");
    } else {
      sb.append(this.categoryDescription);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("appIds:");
    if (this.appIds == null) {
      sb.append("null");
    } else {
      sb.append(this.appIds);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (categoryName == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'categoryName' was not present! Struct: " + toString());
    }
    if (categoryDescription == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'categoryDescription' was not present! Struct: " + toString());
    }
    if (appIds == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'appIds' was not present! Struct: " + toString());
    }
    // check for sub-struct validity
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

  private static class RecommendedAppCategoryStandardSchemeFactory implements SchemeFactory {
    public RecommendedAppCategoryStandardScheme getScheme() {
      return new RecommendedAppCategoryStandardScheme();
    }
  }

  private static class RecommendedAppCategoryStandardScheme extends StandardScheme<RecommendedAppCategory> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, RecommendedAppCategory struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // CATEGORY_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.categoryName = iprot.readString();
              struct.setCategoryNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // CATEGORY_LOGO_URL
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.categoryLogoURL = iprot.readString();
              struct.setCategoryLogoURLIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // CATEGORY_DESCRIPTION
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.categoryDescription = iprot.readString();
              struct.setCategoryDescriptionIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // APP_IDS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list0 = iprot.readListBegin();
                struct.appIds = new ArrayList<Integer>(_list0.size);
                int _elem1;
                for (int _i2 = 0; _i2 < _list0.size; ++_i2)
                {
                  _elem1 = iprot.readI32();
                  struct.appIds.add(_elem1);
                }
                iprot.readListEnd();
              }
              struct.setAppIdsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, RecommendedAppCategory struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.categoryName != null) {
        oprot.writeFieldBegin(CATEGORY_NAME_FIELD_DESC);
        oprot.writeString(struct.categoryName);
        oprot.writeFieldEnd();
      }
      if (struct.categoryLogoURL != null) {
        if (struct.isSetCategoryLogoURL()) {
          oprot.writeFieldBegin(CATEGORY_LOGO_URL_FIELD_DESC);
          oprot.writeString(struct.categoryLogoURL);
          oprot.writeFieldEnd();
        }
      }
      if (struct.categoryDescription != null) {
        oprot.writeFieldBegin(CATEGORY_DESCRIPTION_FIELD_DESC);
        oprot.writeString(struct.categoryDescription);
        oprot.writeFieldEnd();
      }
      if (struct.appIds != null) {
        oprot.writeFieldBegin(APP_IDS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I32, struct.appIds.size()));
          for (int _iter3 : struct.appIds)
          {
            oprot.writeI32(_iter3);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class RecommendedAppCategoryTupleSchemeFactory implements SchemeFactory {
    public RecommendedAppCategoryTupleScheme getScheme() {
      return new RecommendedAppCategoryTupleScheme();
    }
  }

  private static class RecommendedAppCategoryTupleScheme extends TupleScheme<RecommendedAppCategory> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, RecommendedAppCategory struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeString(struct.categoryName);
      oprot.writeString(struct.categoryDescription);
      {
        oprot.writeI32(struct.appIds.size());
        for (int _iter4 : struct.appIds)
        {
          oprot.writeI32(_iter4);
        }
      }
      BitSet optionals = new BitSet();
      if (struct.isSetCategoryLogoURL()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetCategoryLogoURL()) {
        oprot.writeString(struct.categoryLogoURL);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, RecommendedAppCategory struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.categoryName = iprot.readString();
      struct.setCategoryNameIsSet(true);
      struct.categoryDescription = iprot.readString();
      struct.setCategoryDescriptionIsSet(true);
      {
        org.apache.thrift.protocol.TList _list5 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I32, iprot.readI32());
        struct.appIds = new ArrayList<Integer>(_list5.size);
        int _elem6;
        for (int _i7 = 0; _i7 < _list5.size; ++_i7)
        {
          _elem6 = iprot.readI32();
          struct.appIds.add(_elem6);
        }
      }
      struct.setAppIdsIsSet(true);
      BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        struct.categoryLogoURL = iprot.readString();
        struct.setCategoryLogoURLIsSet(true);
      }
    }
  }

}
