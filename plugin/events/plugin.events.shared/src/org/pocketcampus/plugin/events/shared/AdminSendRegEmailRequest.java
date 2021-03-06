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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdminSendRegEmailRequest implements org.apache.thrift.TBase<AdminSendRegEmailRequest, AdminSendRegEmailRequest._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("AdminSendRegEmailRequest");

  private static final org.apache.thrift.protocol.TField TEMPLATE_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("templateId", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField SEND_ONLY_TO_FIELD_DESC = new org.apache.thrift.protocol.TField("sendOnlyTo", org.apache.thrift.protocol.TType.LIST, (short)2);

  private String templateId; // required
  private List<String> sendOnlyTo; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    TEMPLATE_ID((short)1, "templateId"),
    SEND_ONLY_TO((short)2, "sendOnlyTo");

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
        case 1: // TEMPLATE_ID
          return TEMPLATE_ID;
        case 2: // SEND_ONLY_TO
          return SEND_ONLY_TO;
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
    tmpMap.put(_Fields.TEMPLATE_ID, new org.apache.thrift.meta_data.FieldMetaData("templateId", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.SEND_ONLY_TO, new org.apache.thrift.meta_data.FieldMetaData("sendOnlyTo", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(AdminSendRegEmailRequest.class, metaDataMap);
  }

  public AdminSendRegEmailRequest() {
  }

  public AdminSendRegEmailRequest(
    String templateId)
  {
    this();
    this.templateId = templateId;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public AdminSendRegEmailRequest(AdminSendRegEmailRequest other) {
    if (other.isSetTemplateId()) {
      this.templateId = other.templateId;
    }
    if (other.isSetSendOnlyTo()) {
      List<String> __this__sendOnlyTo = new ArrayList<String>();
      for (String other_element : other.sendOnlyTo) {
        __this__sendOnlyTo.add(other_element);
      }
      this.sendOnlyTo = __this__sendOnlyTo;
    }
  }

  public AdminSendRegEmailRequest deepCopy() {
    return new AdminSendRegEmailRequest(this);
  }

  @Override
  public void clear() {
    this.templateId = null;
    this.sendOnlyTo = null;
  }

  public String getTemplateId() {
    return this.templateId;
  }

  public AdminSendRegEmailRequest setTemplateId(String templateId) {
    this.templateId = templateId;
    return this;
  }

  public void unsetTemplateId() {
    this.templateId = null;
  }

  /** Returns true if field templateId is set (has been assigned a value) and false otherwise */
  public boolean isSetTemplateId() {
    return this.templateId != null;
  }

  public void setTemplateIdIsSet(boolean value) {
    if (!value) {
      this.templateId = null;
    }
  }

  public int getSendOnlyToSize() {
    return (this.sendOnlyTo == null) ? 0 : this.sendOnlyTo.size();
  }

  public java.util.Iterator<String> getSendOnlyToIterator() {
    return (this.sendOnlyTo == null) ? null : this.sendOnlyTo.iterator();
  }

  public void addToSendOnlyTo(String elem) {
    if (this.sendOnlyTo == null) {
      this.sendOnlyTo = new ArrayList<String>();
    }
    this.sendOnlyTo.add(elem);
  }

  public List<String> getSendOnlyTo() {
    return this.sendOnlyTo;
  }

  public AdminSendRegEmailRequest setSendOnlyTo(List<String> sendOnlyTo) {
    this.sendOnlyTo = sendOnlyTo;
    return this;
  }

  public void unsetSendOnlyTo() {
    this.sendOnlyTo = null;
  }

  /** Returns true if field sendOnlyTo is set (has been assigned a value) and false otherwise */
  public boolean isSetSendOnlyTo() {
    return this.sendOnlyTo != null;
  }

  public void setSendOnlyToIsSet(boolean value) {
    if (!value) {
      this.sendOnlyTo = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case TEMPLATE_ID:
      if (value == null) {
        unsetTemplateId();
      } else {
        setTemplateId((String)value);
      }
      break;

    case SEND_ONLY_TO:
      if (value == null) {
        unsetSendOnlyTo();
      } else {
        setSendOnlyTo((List<String>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case TEMPLATE_ID:
      return getTemplateId();

    case SEND_ONLY_TO:
      return getSendOnlyTo();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case TEMPLATE_ID:
      return isSetTemplateId();
    case SEND_ONLY_TO:
      return isSetSendOnlyTo();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof AdminSendRegEmailRequest)
      return this.equals((AdminSendRegEmailRequest)that);
    return false;
  }

  public boolean equals(AdminSendRegEmailRequest that) {
    if (that == null)
      return false;

    boolean this_present_templateId = true && this.isSetTemplateId();
    boolean that_present_templateId = true && that.isSetTemplateId();
    if (this_present_templateId || that_present_templateId) {
      if (!(this_present_templateId && that_present_templateId))
        return false;
      if (!this.templateId.equals(that.templateId))
        return false;
    }

    boolean this_present_sendOnlyTo = true && this.isSetSendOnlyTo();
    boolean that_present_sendOnlyTo = true && that.isSetSendOnlyTo();
    if (this_present_sendOnlyTo || that_present_sendOnlyTo) {
      if (!(this_present_sendOnlyTo && that_present_sendOnlyTo))
        return false;
      if (!this.sendOnlyTo.equals(that.sendOnlyTo))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_templateId = true && (isSetTemplateId());
    builder.append(present_templateId);
    if (present_templateId)
      builder.append(templateId);

    boolean present_sendOnlyTo = true && (isSetSendOnlyTo());
    builder.append(present_sendOnlyTo);
    if (present_sendOnlyTo)
      builder.append(sendOnlyTo);

    return builder.toHashCode();
  }

  public int compareTo(AdminSendRegEmailRequest other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    AdminSendRegEmailRequest typedOther = (AdminSendRegEmailRequest)other;

    lastComparison = Boolean.valueOf(isSetTemplateId()).compareTo(typedOther.isSetTemplateId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTemplateId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.templateId, typedOther.templateId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSendOnlyTo()).compareTo(typedOther.isSetSendOnlyTo());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSendOnlyTo()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.sendOnlyTo, typedOther.sendOnlyTo);
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
        case 1: // TEMPLATE_ID
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.templateId = iprot.readString();
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // SEND_ONLY_TO
          if (field.type == org.apache.thrift.protocol.TType.LIST) {
            {
              org.apache.thrift.protocol.TList _list66 = iprot.readListBegin();
              this.sendOnlyTo = new ArrayList<String>(_list66.size);
              for (int _i67 = 0; _i67 < _list66.size; ++_i67)
              {
                String _elem68; // required
                _elem68 = iprot.readString();
                this.sendOnlyTo.add(_elem68);
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
    if (this.templateId != null) {
      oprot.writeFieldBegin(TEMPLATE_ID_FIELD_DESC);
      oprot.writeString(this.templateId);
      oprot.writeFieldEnd();
    }
    if (this.sendOnlyTo != null) {
      if (isSetSendOnlyTo()) {
        oprot.writeFieldBegin(SEND_ONLY_TO_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, this.sendOnlyTo.size()));
          for (String _iter69 : this.sendOnlyTo)
          {
            oprot.writeString(_iter69);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("AdminSendRegEmailRequest(");
    boolean first = true;

    sb.append("templateId:");
    if (this.templateId == null) {
      sb.append("null");
    } else {
      sb.append(this.templateId);
    }
    first = false;
    if (isSetSendOnlyTo()) {
      if (!first) sb.append(", ");
      sb.append("sendOnlyTo:");
      if (this.sendOnlyTo == null) {
        sb.append("null");
      } else {
        sb.append(this.sendOnlyTo);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (templateId == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'templateId' was not present! Struct: " + toString());
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

