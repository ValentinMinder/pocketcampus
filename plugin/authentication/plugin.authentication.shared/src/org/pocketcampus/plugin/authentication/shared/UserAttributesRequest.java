/**
 * Autogenerated by Thrift Compiler (0.7.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package org.pocketcampus.plugin.authentication.shared;

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

public class UserAttributesRequest implements org.apache.thrift.TBase<UserAttributesRequest, UserAttributesRequest._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("UserAttributesRequest");

  private static final org.apache.thrift.protocol.TField SESSION_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("sessionId", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField ATTRIBUTE_NAMES_FIELD_DESC = new org.apache.thrift.protocol.TField("attributeNames", org.apache.thrift.protocol.TType.LIST, (short)2);

  private String sessionId; // required
  private List<String> attributeNames; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    SESSION_ID((short)1, "sessionId"),
    ATTRIBUTE_NAMES((short)2, "attributeNames");

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
        case 1: // SESSION_ID
          return SESSION_ID;
        case 2: // ATTRIBUTE_NAMES
          return ATTRIBUTE_NAMES;
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
    tmpMap.put(_Fields.SESSION_ID, new org.apache.thrift.meta_data.FieldMetaData("sessionId", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.ATTRIBUTE_NAMES, new org.apache.thrift.meta_data.FieldMetaData("attributeNames", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(UserAttributesRequest.class, metaDataMap);
  }

  public UserAttributesRequest() {
  }

  public UserAttributesRequest(
    String sessionId,
    List<String> attributeNames)
  {
    this();
    this.sessionId = sessionId;
    this.attributeNames = attributeNames;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public UserAttributesRequest(UserAttributesRequest other) {
    if (other.isSetSessionId()) {
      this.sessionId = other.sessionId;
    }
    if (other.isSetAttributeNames()) {
      List<String> __this__attributeNames = new ArrayList<String>();
      for (String other_element : other.attributeNames) {
        __this__attributeNames.add(other_element);
      }
      this.attributeNames = __this__attributeNames;
    }
  }

  public UserAttributesRequest deepCopy() {
    return new UserAttributesRequest(this);
  }

  @Override
  public void clear() {
    this.sessionId = null;
    this.attributeNames = null;
  }

  public String getSessionId() {
    return this.sessionId;
  }

  public UserAttributesRequest setSessionId(String sessionId) {
    this.sessionId = sessionId;
    return this;
  }

  public void unsetSessionId() {
    this.sessionId = null;
  }

  /** Returns true if field sessionId is set (has been assigned a value) and false otherwise */
  public boolean isSetSessionId() {
    return this.sessionId != null;
  }

  public void setSessionIdIsSet(boolean value) {
    if (!value) {
      this.sessionId = null;
    }
  }

  public int getAttributeNamesSize() {
    return (this.attributeNames == null) ? 0 : this.attributeNames.size();
  }

  public java.util.Iterator<String> getAttributeNamesIterator() {
    return (this.attributeNames == null) ? null : this.attributeNames.iterator();
  }

  public void addToAttributeNames(String elem) {
    if (this.attributeNames == null) {
      this.attributeNames = new ArrayList<String>();
    }
    this.attributeNames.add(elem);
  }

  public List<String> getAttributeNames() {
    return this.attributeNames;
  }

  public UserAttributesRequest setAttributeNames(List<String> attributeNames) {
    this.attributeNames = attributeNames;
    return this;
  }

  public void unsetAttributeNames() {
    this.attributeNames = null;
  }

  /** Returns true if field attributeNames is set (has been assigned a value) and false otherwise */
  public boolean isSetAttributeNames() {
    return this.attributeNames != null;
  }

  public void setAttributeNamesIsSet(boolean value) {
    if (!value) {
      this.attributeNames = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case SESSION_ID:
      if (value == null) {
        unsetSessionId();
      } else {
        setSessionId((String)value);
      }
      break;

    case ATTRIBUTE_NAMES:
      if (value == null) {
        unsetAttributeNames();
      } else {
        setAttributeNames((List<String>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case SESSION_ID:
      return getSessionId();

    case ATTRIBUTE_NAMES:
      return getAttributeNames();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case SESSION_ID:
      return isSetSessionId();
    case ATTRIBUTE_NAMES:
      return isSetAttributeNames();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof UserAttributesRequest)
      return this.equals((UserAttributesRequest)that);
    return false;
  }

  public boolean equals(UserAttributesRequest that) {
    if (that == null)
      return false;

    boolean this_present_sessionId = true && this.isSetSessionId();
    boolean that_present_sessionId = true && that.isSetSessionId();
    if (this_present_sessionId || that_present_sessionId) {
      if (!(this_present_sessionId && that_present_sessionId))
        return false;
      if (!this.sessionId.equals(that.sessionId))
        return false;
    }

    boolean this_present_attributeNames = true && this.isSetAttributeNames();
    boolean that_present_attributeNames = true && that.isSetAttributeNames();
    if (this_present_attributeNames || that_present_attributeNames) {
      if (!(this_present_attributeNames && that_present_attributeNames))
        return false;
      if (!this.attributeNames.equals(that.attributeNames))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_sessionId = true && (isSetSessionId());
    builder.append(present_sessionId);
    if (present_sessionId)
      builder.append(sessionId);

    boolean present_attributeNames = true && (isSetAttributeNames());
    builder.append(present_attributeNames);
    if (present_attributeNames)
      builder.append(attributeNames);

    return builder.toHashCode();
  }

  public int compareTo(UserAttributesRequest other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    UserAttributesRequest typedOther = (UserAttributesRequest)other;

    lastComparison = Boolean.valueOf(isSetSessionId()).compareTo(typedOther.isSetSessionId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSessionId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.sessionId, typedOther.sessionId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetAttributeNames()).compareTo(typedOther.isSetAttributeNames());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAttributeNames()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.attributeNames, typedOther.attributeNames);
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
        case 1: // SESSION_ID
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.sessionId = iprot.readString();
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // ATTRIBUTE_NAMES
          if (field.type == org.apache.thrift.protocol.TType.LIST) {
            {
              org.apache.thrift.protocol.TList _list4 = iprot.readListBegin();
              this.attributeNames = new ArrayList<String>(_list4.size);
              for (int _i5 = 0; _i5 < _list4.size; ++_i5)
              {
                String _elem6; // required
                _elem6 = iprot.readString();
                this.attributeNames.add(_elem6);
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
    if (this.sessionId != null) {
      oprot.writeFieldBegin(SESSION_ID_FIELD_DESC);
      oprot.writeString(this.sessionId);
      oprot.writeFieldEnd();
    }
    if (this.attributeNames != null) {
      oprot.writeFieldBegin(ATTRIBUTE_NAMES_FIELD_DESC);
      {
        oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, this.attributeNames.size()));
        for (String _iter7 : this.attributeNames)
        {
          oprot.writeString(_iter7);
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
    StringBuilder sb = new StringBuilder("UserAttributesRequest(");
    boolean first = true;

    sb.append("sessionId:");
    if (this.sessionId == null) {
      sb.append("null");
    } else {
      sb.append(this.sessionId);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("attributeNames:");
    if (this.attributeNames == null) {
      sb.append("null");
    } else {
      sb.append(this.attributeNames);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (sessionId == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'sessionId' was not present! Struct: " + toString());
    }
    if (attributeNames == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'attributeNames' was not present! Struct: " + toString());
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
