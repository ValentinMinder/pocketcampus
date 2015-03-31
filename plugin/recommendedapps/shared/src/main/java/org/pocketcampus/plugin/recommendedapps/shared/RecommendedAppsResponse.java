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
public class RecommendedAppsResponse implements org.apache.thrift.TBase<RecommendedAppsResponse, RecommendedAppsResponse._Fields>, java.io.Serializable, Cloneable, Comparable<RecommendedAppsResponse> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("RecommendedAppsResponse");

  private static final org.apache.thrift.protocol.TField STATUS_FIELD_DESC = new org.apache.thrift.protocol.TField("status", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField CATEGORIES_FIELD_DESC = new org.apache.thrift.protocol.TField("categories", org.apache.thrift.protocol.TType.LIST, (short)2);
  private static final org.apache.thrift.protocol.TField APPS_FIELD_DESC = new org.apache.thrift.protocol.TField("apps", org.apache.thrift.protocol.TType.MAP, (short)3);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new RecommendedAppsResponseStandardSchemeFactory());
    schemes.put(TupleScheme.class, new RecommendedAppsResponseTupleSchemeFactory());
  }

  private RecommendedAppsResponseStatus status; // required
  private List<RecommendedAppCategory> categories; // required
  private Map<Integer,RecommendedApp> apps; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    /**
     * 
     * @see RecommendedAppsResponseStatus
     */
    STATUS((short)1, "status"),
    CATEGORIES((short)2, "categories"),
    APPS((short)3, "apps");

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
        case 1: // STATUS
          return STATUS;
        case 2: // CATEGORIES
          return CATEGORIES;
        case 3: // APPS
          return APPS;
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
    tmpMap.put(_Fields.STATUS, new org.apache.thrift.meta_data.FieldMetaData("status", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, RecommendedAppsResponseStatus.class)));
    tmpMap.put(_Fields.CATEGORIES, new org.apache.thrift.meta_data.FieldMetaData("categories", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, RecommendedAppCategory.class))));
    tmpMap.put(_Fields.APPS, new org.apache.thrift.meta_data.FieldMetaData("apps", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.MapMetaData(org.apache.thrift.protocol.TType.MAP, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32), 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, RecommendedApp.class))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(RecommendedAppsResponse.class, metaDataMap);
  }

  public RecommendedAppsResponse() {
  }

  public RecommendedAppsResponse(
    RecommendedAppsResponseStatus status,
    List<RecommendedAppCategory> categories,
    Map<Integer,RecommendedApp> apps)
  {
    this();
    this.status = status;
    this.categories = categories;
    this.apps = apps;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public RecommendedAppsResponse(RecommendedAppsResponse other) {
    if (other.isSetStatus()) {
      this.status = other.status;
    }
    if (other.isSetCategories()) {
      List<RecommendedAppCategory> __this__categories = new ArrayList<RecommendedAppCategory>(other.categories.size());
      for (RecommendedAppCategory other_element : other.categories) {
        __this__categories.add(new RecommendedAppCategory(other_element));
      }
      this.categories = __this__categories;
    }
    if (other.isSetApps()) {
      Map<Integer,RecommendedApp> __this__apps = new HashMap<Integer,RecommendedApp>(other.apps.size());
      for (Map.Entry<Integer, RecommendedApp> other_element : other.apps.entrySet()) {

        Integer other_element_key = other_element.getKey();
        RecommendedApp other_element_value = other_element.getValue();

        Integer __this__apps_copy_key = other_element_key;

        RecommendedApp __this__apps_copy_value = new RecommendedApp(other_element_value);

        __this__apps.put(__this__apps_copy_key, __this__apps_copy_value);
      }
      this.apps = __this__apps;
    }
  }

  public RecommendedAppsResponse deepCopy() {
    return new RecommendedAppsResponse(this);
  }

  @Override
  public void clear() {
    this.status = null;
    this.categories = null;
    this.apps = null;
  }

  /**
   * 
   * @see RecommendedAppsResponseStatus
   */
  public RecommendedAppsResponseStatus getStatus() {
    return this.status;
  }

  /**
   * 
   * @see RecommendedAppsResponseStatus
   */
  public RecommendedAppsResponse setStatus(RecommendedAppsResponseStatus status) {
    this.status = status;
    return this;
  }

  public void unsetStatus() {
    this.status = null;
  }

  /** Returns true if field status is set (has been assigned a value) and false otherwise */
  public boolean isSetStatus() {
    return this.status != null;
  }

  public void setStatusIsSet(boolean value) {
    if (!value) {
      this.status = null;
    }
  }

  public int getCategoriesSize() {
    return (this.categories == null) ? 0 : this.categories.size();
  }

  public java.util.Iterator<RecommendedAppCategory> getCategoriesIterator() {
    return (this.categories == null) ? null : this.categories.iterator();
  }

  public void addToCategories(RecommendedAppCategory elem) {
    if (this.categories == null) {
      this.categories = new ArrayList<RecommendedAppCategory>();
    }
    this.categories.add(elem);
  }

  public List<RecommendedAppCategory> getCategories() {
    return this.categories;
  }

  public RecommendedAppsResponse setCategories(List<RecommendedAppCategory> categories) {
    this.categories = categories;
    return this;
  }

  public void unsetCategories() {
    this.categories = null;
  }

  /** Returns true if field categories is set (has been assigned a value) and false otherwise */
  public boolean isSetCategories() {
    return this.categories != null;
  }

  public void setCategoriesIsSet(boolean value) {
    if (!value) {
      this.categories = null;
    }
  }

  public int getAppsSize() {
    return (this.apps == null) ? 0 : this.apps.size();
  }

  public void putToApps(int key, RecommendedApp val) {
    if (this.apps == null) {
      this.apps = new HashMap<Integer,RecommendedApp>();
    }
    this.apps.put(key, val);
  }

  public Map<Integer,RecommendedApp> getApps() {
    return this.apps;
  }

  public RecommendedAppsResponse setApps(Map<Integer,RecommendedApp> apps) {
    this.apps = apps;
    return this;
  }

  public void unsetApps() {
    this.apps = null;
  }

  /** Returns true if field apps is set (has been assigned a value) and false otherwise */
  public boolean isSetApps() {
    return this.apps != null;
  }

  public void setAppsIsSet(boolean value) {
    if (!value) {
      this.apps = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case STATUS:
      if (value == null) {
        unsetStatus();
      } else {
        setStatus((RecommendedAppsResponseStatus)value);
      }
      break;

    case CATEGORIES:
      if (value == null) {
        unsetCategories();
      } else {
        setCategories((List<RecommendedAppCategory>)value);
      }
      break;

    case APPS:
      if (value == null) {
        unsetApps();
      } else {
        setApps((Map<Integer,RecommendedApp>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case STATUS:
      return getStatus();

    case CATEGORIES:
      return getCategories();

    case APPS:
      return getApps();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case STATUS:
      return isSetStatus();
    case CATEGORIES:
      return isSetCategories();
    case APPS:
      return isSetApps();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof RecommendedAppsResponse)
      return this.equals((RecommendedAppsResponse)that);
    return false;
  }

  public boolean equals(RecommendedAppsResponse that) {
    if (that == null)
      return false;

    boolean this_present_status = true && this.isSetStatus();
    boolean that_present_status = true && that.isSetStatus();
    if (this_present_status || that_present_status) {
      if (!(this_present_status && that_present_status))
        return false;
      if (!this.status.equals(that.status))
        return false;
    }

    boolean this_present_categories = true && this.isSetCategories();
    boolean that_present_categories = true && that.isSetCategories();
    if (this_present_categories || that_present_categories) {
      if (!(this_present_categories && that_present_categories))
        return false;
      if (!this.categories.equals(that.categories))
        return false;
    }

    boolean this_present_apps = true && this.isSetApps();
    boolean that_present_apps = true && that.isSetApps();
    if (this_present_apps || that_present_apps) {
      if (!(this_present_apps && that_present_apps))
        return false;
      if (!this.apps.equals(that.apps))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_status = true && (isSetStatus());
    list.add(present_status);
    if (present_status)
      list.add(status.getValue());

    boolean present_categories = true && (isSetCategories());
    list.add(present_categories);
    if (present_categories)
      list.add(categories);

    boolean present_apps = true && (isSetApps());
    list.add(present_apps);
    if (present_apps)
      list.add(apps);

    return list.hashCode();
  }

  @Override
  public int compareTo(RecommendedAppsResponse other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetStatus()).compareTo(other.isSetStatus());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetStatus()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.status, other.status);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetCategories()).compareTo(other.isSetCategories());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCategories()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.categories, other.categories);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetApps()).compareTo(other.isSetApps());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetApps()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.apps, other.apps);
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
    StringBuilder sb = new StringBuilder("RecommendedAppsResponse(");
    boolean first = true;

    sb.append("status:");
    if (this.status == null) {
      sb.append("null");
    } else {
      sb.append(this.status);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("categories:");
    if (this.categories == null) {
      sb.append("null");
    } else {
      sb.append(this.categories);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("apps:");
    if (this.apps == null) {
      sb.append("null");
    } else {
      sb.append(this.apps);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (status == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'status' was not present! Struct: " + toString());
    }
    if (categories == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'categories' was not present! Struct: " + toString());
    }
    if (apps == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'apps' was not present! Struct: " + toString());
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

  private static class RecommendedAppsResponseStandardSchemeFactory implements SchemeFactory {
    public RecommendedAppsResponseStandardScheme getScheme() {
      return new RecommendedAppsResponseStandardScheme();
    }
  }

  private static class RecommendedAppsResponseStandardScheme extends StandardScheme<RecommendedAppsResponse> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, RecommendedAppsResponse struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // STATUS
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.status = org.pocketcampus.plugin.recommendedapps.shared.RecommendedAppsResponseStatus.findByValue(iprot.readI32());
              struct.setStatusIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // CATEGORIES
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list8 = iprot.readListBegin();
                struct.categories = new ArrayList<RecommendedAppCategory>(_list8.size);
                RecommendedAppCategory _elem9;
                for (int _i10 = 0; _i10 < _list8.size; ++_i10)
                {
                  _elem9 = new RecommendedAppCategory();
                  _elem9.read(iprot);
                  struct.categories.add(_elem9);
                }
                iprot.readListEnd();
              }
              struct.setCategoriesIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // APPS
            if (schemeField.type == org.apache.thrift.protocol.TType.MAP) {
              {
                org.apache.thrift.protocol.TMap _map11 = iprot.readMapBegin();
                struct.apps = new HashMap<Integer,RecommendedApp>(2*_map11.size);
                int _key12;
                RecommendedApp _val13;
                for (int _i14 = 0; _i14 < _map11.size; ++_i14)
                {
                  _key12 = iprot.readI32();
                  _val13 = new RecommendedApp();
                  _val13.read(iprot);
                  struct.apps.put(_key12, _val13);
                }
                iprot.readMapEnd();
              }
              struct.setAppsIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, RecommendedAppsResponse struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.status != null) {
        oprot.writeFieldBegin(STATUS_FIELD_DESC);
        oprot.writeI32(struct.status.getValue());
        oprot.writeFieldEnd();
      }
      if (struct.categories != null) {
        oprot.writeFieldBegin(CATEGORIES_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.categories.size()));
          for (RecommendedAppCategory _iter15 : struct.categories)
          {
            _iter15.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.apps != null) {
        oprot.writeFieldBegin(APPS_FIELD_DESC);
        {
          oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.I32, org.apache.thrift.protocol.TType.STRUCT, struct.apps.size()));
          for (Map.Entry<Integer, RecommendedApp> _iter16 : struct.apps.entrySet())
          {
            oprot.writeI32(_iter16.getKey());
            _iter16.getValue().write(oprot);
          }
          oprot.writeMapEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class RecommendedAppsResponseTupleSchemeFactory implements SchemeFactory {
    public RecommendedAppsResponseTupleScheme getScheme() {
      return new RecommendedAppsResponseTupleScheme();
    }
  }

  private static class RecommendedAppsResponseTupleScheme extends TupleScheme<RecommendedAppsResponse> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, RecommendedAppsResponse struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeI32(struct.status.getValue());
      {
        oprot.writeI32(struct.categories.size());
        for (RecommendedAppCategory _iter17 : struct.categories)
        {
          _iter17.write(oprot);
        }
      }
      {
        oprot.writeI32(struct.apps.size());
        for (Map.Entry<Integer, RecommendedApp> _iter18 : struct.apps.entrySet())
        {
          oprot.writeI32(_iter18.getKey());
          _iter18.getValue().write(oprot);
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, RecommendedAppsResponse struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.status = org.pocketcampus.plugin.recommendedapps.shared.RecommendedAppsResponseStatus.findByValue(iprot.readI32());
      struct.setStatusIsSet(true);
      {
        org.apache.thrift.protocol.TList _list19 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
        struct.categories = new ArrayList<RecommendedAppCategory>(_list19.size);
        RecommendedAppCategory _elem20;
        for (int _i21 = 0; _i21 < _list19.size; ++_i21)
        {
          _elem20 = new RecommendedAppCategory();
          _elem20.read(iprot);
          struct.categories.add(_elem20);
        }
      }
      struct.setCategoriesIsSet(true);
      {
        org.apache.thrift.protocol.TMap _map22 = new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.I32, org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
        struct.apps = new HashMap<Integer,RecommendedApp>(2*_map22.size);
        int _key23;
        RecommendedApp _val24;
        for (int _i25 = 0; _i25 < _map22.size; ++_i25)
        {
          _key23 = iprot.readI32();
          _val24 = new RecommendedApp();
          _val24.read(iprot);
          struct.apps.put(_key23, _val24);
        }
      }
      struct.setAppsIsSet(true);
    }
  }

}
