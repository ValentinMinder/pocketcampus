/**
 * Autogenerated by Thrift Compiler (0.7.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package org.pocketcampus.plugin.moodle.shared;

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

public class MoodleFile2 implements org.apache.thrift.TBase<MoodleFile2, MoodleFile2._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("MoodleFile2");

  private static final org.apache.thrift.protocol.TField NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("name", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField EXTENSION_FIELD_DESC = new org.apache.thrift.protocol.TField("extension", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField URL_FIELD_DESC = new org.apache.thrift.protocol.TField("url", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField ICON_FIELD_DESC = new org.apache.thrift.protocol.TField("icon", org.apache.thrift.protocol.TType.STRING, (short)4);

  private String name; // required
  private String extension; // required
  private String url; // required
  private String icon; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    NAME((short)1, "name"),
    EXTENSION((short)2, "extension"),
    URL((short)3, "url"),
    ICON((short)4, "icon");

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
        case 1: // NAME
          return NAME;
        case 2: // EXTENSION
          return EXTENSION;
        case 3: // URL
          return URL;
        case 4: // ICON
          return ICON;
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
    tmpMap.put(_Fields.NAME, new org.apache.thrift.meta_data.FieldMetaData("name", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.EXTENSION, new org.apache.thrift.meta_data.FieldMetaData("extension", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.URL, new org.apache.thrift.meta_data.FieldMetaData("url", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.ICON, new org.apache.thrift.meta_data.FieldMetaData("icon", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(MoodleFile2.class, metaDataMap);
  }

  public MoodleFile2() {
  }

  public MoodleFile2(
    String name,
    String extension,
    String url)
  {
    this();
    this.name = name;
    this.extension = extension;
    this.url = url;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public MoodleFile2(MoodleFile2 other) {
    if (other.isSetName()) {
      this.name = other.name;
    }
    if (other.isSetExtension()) {
      this.extension = other.extension;
    }
    if (other.isSetUrl()) {
      this.url = other.url;
    }
    if (other.isSetIcon()) {
      this.icon = other.icon;
    }
  }

  public MoodleFile2 deepCopy() {
    return new MoodleFile2(this);
  }

  @Override
  public void clear() {
    this.name = null;
    this.extension = null;
    this.url = null;
    this.icon = null;
  }

  public String getName() {
    return this.name;
  }

  public MoodleFile2 setName(String name) {
    this.name = name;
    return this;
  }

  public void unsetName() {
    this.name = null;
  }

  /** Returns true if field name is set (has been assigned a value) and false otherwise */
  public boolean isSetName() {
    return this.name != null;
  }

  public void setNameIsSet(boolean value) {
    if (!value) {
      this.name = null;
    }
  }

  public String getExtension() {
    return this.extension;
  }

  public MoodleFile2 setExtension(String extension) {
    this.extension = extension;
    return this;
  }

  public void unsetExtension() {
    this.extension = null;
  }

  /** Returns true if field extension is set (has been assigned a value) and false otherwise */
  public boolean isSetExtension() {
    return this.extension != null;
  }

  public void setExtensionIsSet(boolean value) {
    if (!value) {
      this.extension = null;
    }
  }

  public String getUrl() {
    return this.url;
  }

  public MoodleFile2 setUrl(String url) {
    this.url = url;
    return this;
  }

  public void unsetUrl() {
    this.url = null;
  }

  /** Returns true if field url is set (has been assigned a value) and false otherwise */
  public boolean isSetUrl() {
    return this.url != null;
  }

  public void setUrlIsSet(boolean value) {
    if (!value) {
      this.url = null;
    }
  }

  public String getIcon() {
    return this.icon;
  }

  public MoodleFile2 setIcon(String icon) {
    this.icon = icon;
    return this;
  }

  public void unsetIcon() {
    this.icon = null;
  }

  /** Returns true if field icon is set (has been assigned a value) and false otherwise */
  public boolean isSetIcon() {
    return this.icon != null;
  }

  public void setIconIsSet(boolean value) {
    if (!value) {
      this.icon = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case NAME:
      if (value == null) {
        unsetName();
      } else {
        setName((String)value);
      }
      break;

    case EXTENSION:
      if (value == null) {
        unsetExtension();
      } else {
        setExtension((String)value);
      }
      break;

    case URL:
      if (value == null) {
        unsetUrl();
      } else {
        setUrl((String)value);
      }
      break;

    case ICON:
      if (value == null) {
        unsetIcon();
      } else {
        setIcon((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case NAME:
      return getName();

    case EXTENSION:
      return getExtension();

    case URL:
      return getUrl();

    case ICON:
      return getIcon();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case NAME:
      return isSetName();
    case EXTENSION:
      return isSetExtension();
    case URL:
      return isSetUrl();
    case ICON:
      return isSetIcon();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof MoodleFile2)
      return this.equals((MoodleFile2)that);
    return false;
  }

  public boolean equals(MoodleFile2 that) {
    if (that == null)
      return false;

    boolean this_present_name = true && this.isSetName();
    boolean that_present_name = true && that.isSetName();
    if (this_present_name || that_present_name) {
      if (!(this_present_name && that_present_name))
        return false;
      if (!this.name.equals(that.name))
        return false;
    }

    boolean this_present_extension = true && this.isSetExtension();
    boolean that_present_extension = true && that.isSetExtension();
    if (this_present_extension || that_present_extension) {
      if (!(this_present_extension && that_present_extension))
        return false;
      if (!this.extension.equals(that.extension))
        return false;
    }

    boolean this_present_url = true && this.isSetUrl();
    boolean that_present_url = true && that.isSetUrl();
    if (this_present_url || that_present_url) {
      if (!(this_present_url && that_present_url))
        return false;
      if (!this.url.equals(that.url))
        return false;
    }

    boolean this_present_icon = true && this.isSetIcon();
    boolean that_present_icon = true && that.isSetIcon();
    if (this_present_icon || that_present_icon) {
      if (!(this_present_icon && that_present_icon))
        return false;
      if (!this.icon.equals(that.icon))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_name = true && (isSetName());
    builder.append(present_name);
    if (present_name)
      builder.append(name);

    boolean present_extension = true && (isSetExtension());
    builder.append(present_extension);
    if (present_extension)
      builder.append(extension);

    boolean present_url = true && (isSetUrl());
    builder.append(present_url);
    if (present_url)
      builder.append(url);

    boolean present_icon = true && (isSetIcon());
    builder.append(present_icon);
    if (present_icon)
      builder.append(icon);

    return builder.toHashCode();
  }

  public int compareTo(MoodleFile2 other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    MoodleFile2 typedOther = (MoodleFile2)other;

    lastComparison = Boolean.valueOf(isSetName()).compareTo(typedOther.isSetName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.name, typedOther.name);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetExtension()).compareTo(typedOther.isSetExtension());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetExtension()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.extension, typedOther.extension);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetUrl()).compareTo(typedOther.isSetUrl());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUrl()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.url, typedOther.url);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetIcon()).compareTo(typedOther.isSetIcon());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetIcon()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.icon, typedOther.icon);
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
        case 1: // NAME
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.name = iprot.readString();
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // EXTENSION
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.extension = iprot.readString();
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 3: // URL
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.url = iprot.readString();
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 4: // ICON
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.icon = iprot.readString();
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
    if (this.name != null) {
      oprot.writeFieldBegin(NAME_FIELD_DESC);
      oprot.writeString(this.name);
      oprot.writeFieldEnd();
    }
    if (this.extension != null) {
      oprot.writeFieldBegin(EXTENSION_FIELD_DESC);
      oprot.writeString(this.extension);
      oprot.writeFieldEnd();
    }
    if (this.url != null) {
      oprot.writeFieldBegin(URL_FIELD_DESC);
      oprot.writeString(this.url);
      oprot.writeFieldEnd();
    }
    if (this.icon != null) {
      if (isSetIcon()) {
        oprot.writeFieldBegin(ICON_FIELD_DESC);
        oprot.writeString(this.icon);
        oprot.writeFieldEnd();
      }
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("MoodleFile2(");
    boolean first = true;

    sb.append("name:");
    if (this.name == null) {
      sb.append("null");
    } else {
      sb.append(this.name);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("extension:");
    if (this.extension == null) {
      sb.append("null");
    } else {
      sb.append(this.extension);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("url:");
    if (this.url == null) {
      sb.append("null");
    } else {
      sb.append(this.url);
    }
    first = false;
    if (isSetIcon()) {
      if (!first) sb.append(", ");
      sb.append("icon:");
      if (this.icon == null) {
        sb.append("null");
      } else {
        sb.append(this.icon);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (name == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'name' was not present! Struct: " + toString());
    }
    if (extension == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'extension' was not present! Struct: " + toString());
    }
    if (url == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'url' was not present! Struct: " + toString());
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

