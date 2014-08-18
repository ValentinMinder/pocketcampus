/**
 * Autogenerated by Thrift Compiler (0.7.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package org.pocketcampus.plugin.recommendedapps.shared;

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

public class RecommendedAppOSConfiguration implements org.apache.thrift.TBase<RecommendedAppOSConfiguration, RecommendedAppOSConfiguration._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("RecommendedAppOSConfiguration");

  private static final org.apache.thrift.protocol.TField APP_STORE_URL_FIELD_DESC = new org.apache.thrift.protocol.TField("appStoreURL", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField APP_OPEN_URLPATTERN_FIELD_DESC = new org.apache.thrift.protocol.TField("appOpenURLPattern", org.apache.thrift.protocol.TType.STRING, (short)2);

  private String appStoreURL; // required
  private String appOpenURLPattern; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    APP_STORE_URL((short)1, "appStoreURL"),
    APP_OPEN_URLPATTERN((short)2, "appOpenURLPattern");

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
        case 1: // APP_STORE_URL
          return APP_STORE_URL;
        case 2: // APP_OPEN_URLPATTERN
          return APP_OPEN_URLPATTERN;
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
    tmpMap.put(_Fields.APP_STORE_URL, new org.apache.thrift.meta_data.FieldMetaData("appStoreURL", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.APP_OPEN_URLPATTERN, new org.apache.thrift.meta_data.FieldMetaData("appOpenURLPattern", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(RecommendedAppOSConfiguration.class, metaDataMap);
  }

  public RecommendedAppOSConfiguration() {
  }

  public RecommendedAppOSConfiguration(
    String appStoreURL,
    String appOpenURLPattern)
  {
    this();
    this.appStoreURL = appStoreURL;
    this.appOpenURLPattern = appOpenURLPattern;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public RecommendedAppOSConfiguration(RecommendedAppOSConfiguration other) {
    if (other.isSetAppStoreURL()) {
      this.appStoreURL = other.appStoreURL;
    }
    if (other.isSetAppOpenURLPattern()) {
      this.appOpenURLPattern = other.appOpenURLPattern;
    }
  }

  public RecommendedAppOSConfiguration deepCopy() {
    return new RecommendedAppOSConfiguration(this);
  }

  @Override
  public void clear() {
    this.appStoreURL = null;
    this.appOpenURLPattern = null;
  }

  public String getAppStoreURL() {
    return this.appStoreURL;
  }

  public RecommendedAppOSConfiguration setAppStoreURL(String appStoreURL) {
    this.appStoreURL = appStoreURL;
    return this;
  }

  public void unsetAppStoreURL() {
    this.appStoreURL = null;
  }

  /** Returns true if field appStoreURL is set (has been assigned a value) and false otherwise */
  public boolean isSetAppStoreURL() {
    return this.appStoreURL != null;
  }

  public void setAppStoreURLIsSet(boolean value) {
    if (!value) {
      this.appStoreURL = null;
    }
  }

  public String getAppOpenURLPattern() {
    return this.appOpenURLPattern;
  }

  public RecommendedAppOSConfiguration setAppOpenURLPattern(String appOpenURLPattern) {
    this.appOpenURLPattern = appOpenURLPattern;
    return this;
  }

  public void unsetAppOpenURLPattern() {
    this.appOpenURLPattern = null;
  }

  /** Returns true if field appOpenURLPattern is set (has been assigned a value) and false otherwise */
  public boolean isSetAppOpenURLPattern() {
    return this.appOpenURLPattern != null;
  }

  public void setAppOpenURLPatternIsSet(boolean value) {
    if (!value) {
      this.appOpenURLPattern = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case APP_STORE_URL:
      if (value == null) {
        unsetAppStoreURL();
      } else {
        setAppStoreURL((String)value);
      }
      break;

    case APP_OPEN_URLPATTERN:
      if (value == null) {
        unsetAppOpenURLPattern();
      } else {
        setAppOpenURLPattern((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case APP_STORE_URL:
      return getAppStoreURL();

    case APP_OPEN_URLPATTERN:
      return getAppOpenURLPattern();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case APP_STORE_URL:
      return isSetAppStoreURL();
    case APP_OPEN_URLPATTERN:
      return isSetAppOpenURLPattern();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof RecommendedAppOSConfiguration)
      return this.equals((RecommendedAppOSConfiguration)that);
    return false;
  }

  public boolean equals(RecommendedAppOSConfiguration that) {
    if (that == null)
      return false;

    boolean this_present_appStoreURL = true && this.isSetAppStoreURL();
    boolean that_present_appStoreURL = true && that.isSetAppStoreURL();
    if (this_present_appStoreURL || that_present_appStoreURL) {
      if (!(this_present_appStoreURL && that_present_appStoreURL))
        return false;
      if (!this.appStoreURL.equals(that.appStoreURL))
        return false;
    }

    boolean this_present_appOpenURLPattern = true && this.isSetAppOpenURLPattern();
    boolean that_present_appOpenURLPattern = true && that.isSetAppOpenURLPattern();
    if (this_present_appOpenURLPattern || that_present_appOpenURLPattern) {
      if (!(this_present_appOpenURLPattern && that_present_appOpenURLPattern))
        return false;
      if (!this.appOpenURLPattern.equals(that.appOpenURLPattern))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_appStoreURL = true && (isSetAppStoreURL());
    builder.append(present_appStoreURL);
    if (present_appStoreURL)
      builder.append(appStoreURL);

    boolean present_appOpenURLPattern = true && (isSetAppOpenURLPattern());
    builder.append(present_appOpenURLPattern);
    if (present_appOpenURLPattern)
      builder.append(appOpenURLPattern);

    return builder.toHashCode();
  }

  public int compareTo(RecommendedAppOSConfiguration other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    RecommendedAppOSConfiguration typedOther = (RecommendedAppOSConfiguration)other;

    lastComparison = Boolean.valueOf(isSetAppStoreURL()).compareTo(typedOther.isSetAppStoreURL());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAppStoreURL()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.appStoreURL, typedOther.appStoreURL);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetAppOpenURLPattern()).compareTo(typedOther.isSetAppOpenURLPattern());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAppOpenURLPattern()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.appOpenURLPattern, typedOther.appOpenURLPattern);
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
        case 1: // APP_STORE_URL
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.appStoreURL = iprot.readString();
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // APP_OPEN_URLPATTERN
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.appOpenURLPattern = iprot.readString();
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
    if (this.appStoreURL != null) {
      oprot.writeFieldBegin(APP_STORE_URL_FIELD_DESC);
      oprot.writeString(this.appStoreURL);
      oprot.writeFieldEnd();
    }
    if (this.appOpenURLPattern != null) {
      oprot.writeFieldBegin(APP_OPEN_URLPATTERN_FIELD_DESC);
      oprot.writeString(this.appOpenURLPattern);
      oprot.writeFieldEnd();
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("RecommendedAppOSConfiguration(");
    boolean first = true;

    sb.append("appStoreURL:");
    if (this.appStoreURL == null) {
      sb.append("null");
    } else {
      sb.append(this.appStoreURL);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("appOpenURLPattern:");
    if (this.appOpenURLPattern == null) {
      sb.append("null");
    } else {
      sb.append(this.appOpenURLPattern);
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

