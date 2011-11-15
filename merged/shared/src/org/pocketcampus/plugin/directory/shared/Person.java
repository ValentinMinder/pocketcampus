/**
 * Autogenerated by Thrift Compiler (0.7.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package org.pocketcampus.plugin.directory.shared;

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

public class Person implements org.apache.thrift.TBase<Person, Person._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Person");

  private static final org.apache.thrift.protocol.TField FIRST_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("firstName", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField LAST_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("lastName", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField SCIPER_FIELD_DESC = new org.apache.thrift.protocol.TField("sciper", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField MAIL_FIELD_DESC = new org.apache.thrift.protocol.TField("mail", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField WEB_FIELD_DESC = new org.apache.thrift.protocol.TField("web", org.apache.thrift.protocol.TType.STRING, (short)5);
  private static final org.apache.thrift.protocol.TField PHONE_NUMBER_FIELD_DESC = new org.apache.thrift.protocol.TField("phone_number", org.apache.thrift.protocol.TType.STRING, (short)6);
  private static final org.apache.thrift.protocol.TField OFFICE_FIELD_DESC = new org.apache.thrift.protocol.TField("office", org.apache.thrift.protocol.TType.STRING, (short)7);
  private static final org.apache.thrift.protocol.TField GASPAR_FIELD_DESC = new org.apache.thrift.protocol.TField("gaspar", org.apache.thrift.protocol.TType.STRING, (short)8);
  private static final org.apache.thrift.protocol.TField OU_FIELD_DESC = new org.apache.thrift.protocol.TField("ou", org.apache.thrift.protocol.TType.STRING, (short)9);
  private static final org.apache.thrift.protocol.TField PICTURE_URL_FIELD_DESC = new org.apache.thrift.protocol.TField("picture_url", org.apache.thrift.protocol.TType.STRING, (short)10);

  public String firstName; // required
  public String lastName; // required
  public String sciper; // required
  public String mail; // required
  public String web; // required
  public String phone_number; // required
  public String office; // required
  public String gaspar; // required
  public String ou; // required
  public String picture_url; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    FIRST_NAME((short)1, "firstName"),
    LAST_NAME((short)2, "lastName"),
    SCIPER((short)3, "sciper"),
    MAIL((short)4, "mail"),
    WEB((short)5, "web"),
    PHONE_NUMBER((short)6, "phone_number"),
    OFFICE((short)7, "office"),
    GASPAR((short)8, "gaspar"),
    OU((short)9, "ou"),
    PICTURE_URL((short)10, "picture_url");

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
        case 1: // FIRST_NAME
          return FIRST_NAME;
        case 2: // LAST_NAME
          return LAST_NAME;
        case 3: // SCIPER
          return SCIPER;
        case 4: // MAIL
          return MAIL;
        case 5: // WEB
          return WEB;
        case 6: // PHONE_NUMBER
          return PHONE_NUMBER;
        case 7: // OFFICE
          return OFFICE;
        case 8: // GASPAR
          return GASPAR;
        case 9: // OU
          return OU;
        case 10: // PICTURE_URL
          return PICTURE_URL;
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
    tmpMap.put(_Fields.FIRST_NAME, new org.apache.thrift.meta_data.FieldMetaData("firstName", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.LAST_NAME, new org.apache.thrift.meta_data.FieldMetaData("lastName", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.SCIPER, new org.apache.thrift.meta_data.FieldMetaData("sciper", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.MAIL, new org.apache.thrift.meta_data.FieldMetaData("mail", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.WEB, new org.apache.thrift.meta_data.FieldMetaData("web", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PHONE_NUMBER, new org.apache.thrift.meta_data.FieldMetaData("phone_number", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.OFFICE, new org.apache.thrift.meta_data.FieldMetaData("office", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.GASPAR, new org.apache.thrift.meta_data.FieldMetaData("gaspar", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.OU, new org.apache.thrift.meta_data.FieldMetaData("ou", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PICTURE_URL, new org.apache.thrift.meta_data.FieldMetaData("picture_url", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Person.class, metaDataMap);
  }

  public Person() {
  }

  public Person(
    String firstName,
    String lastName,
    String sciper)
  {
    this();
    this.firstName = firstName;
    this.lastName = lastName;
    this.sciper = sciper;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Person(Person other) {
    if (other.isSetFirstName()) {
      this.firstName = other.firstName;
    }
    if (other.isSetLastName()) {
      this.lastName = other.lastName;
    }
    if (other.isSetSciper()) {
      this.sciper = other.sciper;
    }
    if (other.isSetMail()) {
      this.mail = other.mail;
    }
    if (other.isSetWeb()) {
      this.web = other.web;
    }
    if (other.isSetPhone_number()) {
      this.phone_number = other.phone_number;
    }
    if (other.isSetOffice()) {
      this.office = other.office;
    }
    if (other.isSetGaspar()) {
      this.gaspar = other.gaspar;
    }
    if (other.isSetOu()) {
      this.ou = other.ou;
    }
    if (other.isSetPicture_url()) {
      this.picture_url = other.picture_url;
    }
  }

  public Person deepCopy() {
    return new Person(this);
  }

  @Override
  public void clear() {
    this.firstName = null;
    this.lastName = null;
    this.sciper = null;
    this.mail = null;
    this.web = null;
    this.phone_number = null;
    this.office = null;
    this.gaspar = null;
    this.ou = null;
    this.picture_url = null;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public Person setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public void unsetFirstName() {
    this.firstName = null;
  }

  /** Returns true if field firstName is set (has been assigned a value) and false otherwise */
  public boolean isSetFirstName() {
    return this.firstName != null;
  }

  public void setFirstNameIsSet(boolean value) {
    if (!value) {
      this.firstName = null;
    }
  }

  public String getLastName() {
    return this.lastName;
  }

  public Person setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public void unsetLastName() {
    this.lastName = null;
  }

  /** Returns true if field lastName is set (has been assigned a value) and false otherwise */
  public boolean isSetLastName() {
    return this.lastName != null;
  }

  public void setLastNameIsSet(boolean value) {
    if (!value) {
      this.lastName = null;
    }
  }

  public String getSciper() {
    return this.sciper;
  }

  public Person setSciper(String sciper) {
    this.sciper = sciper;
    return this;
  }

  public void unsetSciper() {
    this.sciper = null;
  }

  /** Returns true if field sciper is set (has been assigned a value) and false otherwise */
  public boolean isSetSciper() {
    return this.sciper != null;
  }

  public void setSciperIsSet(boolean value) {
    if (!value) {
      this.sciper = null;
    }
  }

  public String getMail() {
    return this.mail;
  }

  public Person setMail(String mail) {
    this.mail = mail;
    return this;
  }

  public void unsetMail() {
    this.mail = null;
  }

  /** Returns true if field mail is set (has been assigned a value) and false otherwise */
  public boolean isSetMail() {
    return this.mail != null;
  }

  public void setMailIsSet(boolean value) {
    if (!value) {
      this.mail = null;
    }
  }

  public String getWeb() {
    return this.web;
  }

  public Person setWeb(String web) {
    this.web = web;
    return this;
  }

  public void unsetWeb() {
    this.web = null;
  }

  /** Returns true if field web is set (has been assigned a value) and false otherwise */
  public boolean isSetWeb() {
    return this.web != null;
  }

  public void setWebIsSet(boolean value) {
    if (!value) {
      this.web = null;
    }
  }

  public String getPhone_number() {
    return this.phone_number;
  }

  public Person setPhone_number(String phone_number) {
    this.phone_number = phone_number;
    return this;
  }

  public void unsetPhone_number() {
    this.phone_number = null;
  }

  /** Returns true if field phone_number is set (has been assigned a value) and false otherwise */
  public boolean isSetPhone_number() {
    return this.phone_number != null;
  }

  public void setPhone_numberIsSet(boolean value) {
    if (!value) {
      this.phone_number = null;
    }
  }

  public String getOffice() {
    return this.office;
  }

  public Person setOffice(String office) {
    this.office = office;
    return this;
  }

  public void unsetOffice() {
    this.office = null;
  }

  /** Returns true if field office is set (has been assigned a value) and false otherwise */
  public boolean isSetOffice() {
    return this.office != null;
  }

  public void setOfficeIsSet(boolean value) {
    if (!value) {
      this.office = null;
    }
  }

  public String getGaspar() {
    return this.gaspar;
  }

  public Person setGaspar(String gaspar) {
    this.gaspar = gaspar;
    return this;
  }

  public void unsetGaspar() {
    this.gaspar = null;
  }

  /** Returns true if field gaspar is set (has been assigned a value) and false otherwise */
  public boolean isSetGaspar() {
    return this.gaspar != null;
  }

  public void setGasparIsSet(boolean value) {
    if (!value) {
      this.gaspar = null;
    }
  }

  public String getOu() {
    return this.ou;
  }

  public Person setOu(String ou) {
    this.ou = ou;
    return this;
  }

  public void unsetOu() {
    this.ou = null;
  }

  /** Returns true if field ou is set (has been assigned a value) and false otherwise */
  public boolean isSetOu() {
    return this.ou != null;
  }

  public void setOuIsSet(boolean value) {
    if (!value) {
      this.ou = null;
    }
  }

  public String getPicture_url() {
    return this.picture_url;
  }

  public Person setPicture_url(String picture_url) {
    this.picture_url = picture_url;
    return this;
  }

  public void unsetPicture_url() {
    this.picture_url = null;
  }

  /** Returns true if field picture_url is set (has been assigned a value) and false otherwise */
  public boolean isSetPicture_url() {
    return this.picture_url != null;
  }

  public void setPicture_urlIsSet(boolean value) {
    if (!value) {
      this.picture_url = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case FIRST_NAME:
      if (value == null) {
        unsetFirstName();
      } else {
        setFirstName((String)value);
      }
      break;

    case LAST_NAME:
      if (value == null) {
        unsetLastName();
      } else {
        setLastName((String)value);
      }
      break;

    case SCIPER:
      if (value == null) {
        unsetSciper();
      } else {
        setSciper((String)value);
      }
      break;

    case MAIL:
      if (value == null) {
        unsetMail();
      } else {
        setMail((String)value);
      }
      break;

    case WEB:
      if (value == null) {
        unsetWeb();
      } else {
        setWeb((String)value);
      }
      break;

    case PHONE_NUMBER:
      if (value == null) {
        unsetPhone_number();
      } else {
        setPhone_number((String)value);
      }
      break;

    case OFFICE:
      if (value == null) {
        unsetOffice();
      } else {
        setOffice((String)value);
      }
      break;

    case GASPAR:
      if (value == null) {
        unsetGaspar();
      } else {
        setGaspar((String)value);
      }
      break;

    case OU:
      if (value == null) {
        unsetOu();
      } else {
        setOu((String)value);
      }
      break;

    case PICTURE_URL:
      if (value == null) {
        unsetPicture_url();
      } else {
        setPicture_url((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case FIRST_NAME:
      return getFirstName();

    case LAST_NAME:
      return getLastName();

    case SCIPER:
      return getSciper();

    case MAIL:
      return getMail();

    case WEB:
      return getWeb();

    case PHONE_NUMBER:
      return getPhone_number();

    case OFFICE:
      return getOffice();

    case GASPAR:
      return getGaspar();

    case OU:
      return getOu();

    case PICTURE_URL:
      return getPicture_url();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case FIRST_NAME:
      return isSetFirstName();
    case LAST_NAME:
      return isSetLastName();
    case SCIPER:
      return isSetSciper();
    case MAIL:
      return isSetMail();
    case WEB:
      return isSetWeb();
    case PHONE_NUMBER:
      return isSetPhone_number();
    case OFFICE:
      return isSetOffice();
    case GASPAR:
      return isSetGaspar();
    case OU:
      return isSetOu();
    case PICTURE_URL:
      return isSetPicture_url();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Person)
      return this.equals((Person)that);
    return false;
  }

  public boolean equals(Person that) {
    if (that == null)
      return false;

    boolean this_present_firstName = true && this.isSetFirstName();
    boolean that_present_firstName = true && that.isSetFirstName();
    if (this_present_firstName || that_present_firstName) {
      if (!(this_present_firstName && that_present_firstName))
        return false;
      if (!this.firstName.equals(that.firstName))
        return false;
    }

    boolean this_present_lastName = true && this.isSetLastName();
    boolean that_present_lastName = true && that.isSetLastName();
    if (this_present_lastName || that_present_lastName) {
      if (!(this_present_lastName && that_present_lastName))
        return false;
      if (!this.lastName.equals(that.lastName))
        return false;
    }

    boolean this_present_sciper = true && this.isSetSciper();
    boolean that_present_sciper = true && that.isSetSciper();
    if (this_present_sciper || that_present_sciper) {
      if (!(this_present_sciper && that_present_sciper))
        return false;
      if (!this.sciper.equals(that.sciper))
        return false;
    }

    boolean this_present_mail = true && this.isSetMail();
    boolean that_present_mail = true && that.isSetMail();
    if (this_present_mail || that_present_mail) {
      if (!(this_present_mail && that_present_mail))
        return false;
      if (!this.mail.equals(that.mail))
        return false;
    }

    boolean this_present_web = true && this.isSetWeb();
    boolean that_present_web = true && that.isSetWeb();
    if (this_present_web || that_present_web) {
      if (!(this_present_web && that_present_web))
        return false;
      if (!this.web.equals(that.web))
        return false;
    }

    boolean this_present_phone_number = true && this.isSetPhone_number();
    boolean that_present_phone_number = true && that.isSetPhone_number();
    if (this_present_phone_number || that_present_phone_number) {
      if (!(this_present_phone_number && that_present_phone_number))
        return false;
      if (!this.phone_number.equals(that.phone_number))
        return false;
    }

    boolean this_present_office = true && this.isSetOffice();
    boolean that_present_office = true && that.isSetOffice();
    if (this_present_office || that_present_office) {
      if (!(this_present_office && that_present_office))
        return false;
      if (!this.office.equals(that.office))
        return false;
    }

    boolean this_present_gaspar = true && this.isSetGaspar();
    boolean that_present_gaspar = true && that.isSetGaspar();
    if (this_present_gaspar || that_present_gaspar) {
      if (!(this_present_gaspar && that_present_gaspar))
        return false;
      if (!this.gaspar.equals(that.gaspar))
        return false;
    }

    boolean this_present_ou = true && this.isSetOu();
    boolean that_present_ou = true && that.isSetOu();
    if (this_present_ou || that_present_ou) {
      if (!(this_present_ou && that_present_ou))
        return false;
      if (!this.ou.equals(that.ou))
        return false;
    }

    boolean this_present_picture_url = true && this.isSetPicture_url();
    boolean that_present_picture_url = true && that.isSetPicture_url();
    if (this_present_picture_url || that_present_picture_url) {
      if (!(this_present_picture_url && that_present_picture_url))
        return false;
      if (!this.picture_url.equals(that.picture_url))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_firstName = true && (isSetFirstName());
    builder.append(present_firstName);
    if (present_firstName)
      builder.append(firstName);

    boolean present_lastName = true && (isSetLastName());
    builder.append(present_lastName);
    if (present_lastName)
      builder.append(lastName);

    boolean present_sciper = true && (isSetSciper());
    builder.append(present_sciper);
    if (present_sciper)
      builder.append(sciper);

    boolean present_mail = true && (isSetMail());
    builder.append(present_mail);
    if (present_mail)
      builder.append(mail);

    boolean present_web = true && (isSetWeb());
    builder.append(present_web);
    if (present_web)
      builder.append(web);

    boolean present_phone_number = true && (isSetPhone_number());
    builder.append(present_phone_number);
    if (present_phone_number)
      builder.append(phone_number);

    boolean present_office = true && (isSetOffice());
    builder.append(present_office);
    if (present_office)
      builder.append(office);

    boolean present_gaspar = true && (isSetGaspar());
    builder.append(present_gaspar);
    if (present_gaspar)
      builder.append(gaspar);

    boolean present_ou = true && (isSetOu());
    builder.append(present_ou);
    if (present_ou)
      builder.append(ou);

    boolean present_picture_url = true && (isSetPicture_url());
    builder.append(present_picture_url);
    if (present_picture_url)
      builder.append(picture_url);

    return builder.toHashCode();
  }

  public int compareTo(Person other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    Person typedOther = (Person)other;

    lastComparison = Boolean.valueOf(isSetFirstName()).compareTo(typedOther.isSetFirstName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFirstName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.firstName, typedOther.firstName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetLastName()).compareTo(typedOther.isSetLastName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLastName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.lastName, typedOther.lastName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSciper()).compareTo(typedOther.isSetSciper());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSciper()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.sciper, typedOther.sciper);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetMail()).compareTo(typedOther.isSetMail());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMail()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.mail, typedOther.mail);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetWeb()).compareTo(typedOther.isSetWeb());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetWeb()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.web, typedOther.web);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPhone_number()).compareTo(typedOther.isSetPhone_number());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPhone_number()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.phone_number, typedOther.phone_number);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetOffice()).compareTo(typedOther.isSetOffice());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetOffice()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.office, typedOther.office);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetGaspar()).compareTo(typedOther.isSetGaspar());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetGaspar()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.gaspar, typedOther.gaspar);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetOu()).compareTo(typedOther.isSetOu());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetOu()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.ou, typedOther.ou);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPicture_url()).compareTo(typedOther.isSetPicture_url());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPicture_url()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.picture_url, typedOther.picture_url);
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
        case 1: // FIRST_NAME
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.firstName = iprot.readString();
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // LAST_NAME
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.lastName = iprot.readString();
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 3: // SCIPER
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.sciper = iprot.readString();
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 4: // MAIL
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.mail = iprot.readString();
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 5: // WEB
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.web = iprot.readString();
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 6: // PHONE_NUMBER
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.phone_number = iprot.readString();
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 7: // OFFICE
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.office = iprot.readString();
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 8: // GASPAR
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.gaspar = iprot.readString();
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 9: // OU
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.ou = iprot.readString();
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 10: // PICTURE_URL
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.picture_url = iprot.readString();
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
    if (this.firstName != null) {
      oprot.writeFieldBegin(FIRST_NAME_FIELD_DESC);
      oprot.writeString(this.firstName);
      oprot.writeFieldEnd();
    }
    if (this.lastName != null) {
      oprot.writeFieldBegin(LAST_NAME_FIELD_DESC);
      oprot.writeString(this.lastName);
      oprot.writeFieldEnd();
    }
    if (this.sciper != null) {
      oprot.writeFieldBegin(SCIPER_FIELD_DESC);
      oprot.writeString(this.sciper);
      oprot.writeFieldEnd();
    }
    if (this.mail != null) {
      if (isSetMail()) {
        oprot.writeFieldBegin(MAIL_FIELD_DESC);
        oprot.writeString(this.mail);
        oprot.writeFieldEnd();
      }
    }
    if (this.web != null) {
      if (isSetWeb()) {
        oprot.writeFieldBegin(WEB_FIELD_DESC);
        oprot.writeString(this.web);
        oprot.writeFieldEnd();
      }
    }
    if (this.phone_number != null) {
      if (isSetPhone_number()) {
        oprot.writeFieldBegin(PHONE_NUMBER_FIELD_DESC);
        oprot.writeString(this.phone_number);
        oprot.writeFieldEnd();
      }
    }
    if (this.office != null) {
      if (isSetOffice()) {
        oprot.writeFieldBegin(OFFICE_FIELD_DESC);
        oprot.writeString(this.office);
        oprot.writeFieldEnd();
      }
    }
    if (this.gaspar != null) {
      if (isSetGaspar()) {
        oprot.writeFieldBegin(GASPAR_FIELD_DESC);
        oprot.writeString(this.gaspar);
        oprot.writeFieldEnd();
      }
    }
    if (this.ou != null) {
      if (isSetOu()) {
        oprot.writeFieldBegin(OU_FIELD_DESC);
        oprot.writeString(this.ou);
        oprot.writeFieldEnd();
      }
    }
    if (this.picture_url != null) {
      if (isSetPicture_url()) {
        oprot.writeFieldBegin(PICTURE_URL_FIELD_DESC);
        oprot.writeString(this.picture_url);
        oprot.writeFieldEnd();
      }
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Person(");
    boolean first = true;

    sb.append("firstName:");
    if (this.firstName == null) {
      sb.append("null");
    } else {
      sb.append(this.firstName);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("lastName:");
    if (this.lastName == null) {
      sb.append("null");
    } else {
      sb.append(this.lastName);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("sciper:");
    if (this.sciper == null) {
      sb.append("null");
    } else {
      sb.append(this.sciper);
    }
    first = false;
    if (isSetMail()) {
      if (!first) sb.append(", ");
      sb.append("mail:");
      if (this.mail == null) {
        sb.append("null");
      } else {
        sb.append(this.mail);
      }
      first = false;
    }
    if (isSetWeb()) {
      if (!first) sb.append(", ");
      sb.append("web:");
      if (this.web == null) {
        sb.append("null");
      } else {
        sb.append(this.web);
      }
      first = false;
    }
    if (isSetPhone_number()) {
      if (!first) sb.append(", ");
      sb.append("phone_number:");
      if (this.phone_number == null) {
        sb.append("null");
      } else {
        sb.append(this.phone_number);
      }
      first = false;
    }
    if (isSetOffice()) {
      if (!first) sb.append(", ");
      sb.append("office:");
      if (this.office == null) {
        sb.append("null");
      } else {
        sb.append(this.office);
      }
      first = false;
    }
    if (isSetGaspar()) {
      if (!first) sb.append(", ");
      sb.append("gaspar:");
      if (this.gaspar == null) {
        sb.append("null");
      } else {
        sb.append(this.gaspar);
      }
      first = false;
    }
    if (isSetOu()) {
      if (!first) sb.append(", ");
      sb.append("ou:");
      if (this.ou == null) {
        sb.append("null");
      } else {
        sb.append(this.ou);
      }
      first = false;
    }
    if (isSetPicture_url()) {
      if (!first) sb.append(", ");
      sb.append("picture_url:");
      if (this.picture_url == null) {
        sb.append("null");
      } else {
        sb.append(this.picture_url);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (firstName == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'firstName' was not present! Struct: " + toString());
    }
    if (lastName == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'lastName' was not present! Struct: " + toString());
    }
    if (sciper == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'sciper' was not present! Struct: " + toString());
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

