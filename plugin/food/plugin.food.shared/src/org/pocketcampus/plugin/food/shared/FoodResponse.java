/**
 * Autogenerated by Thrift Compiler (0.7.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package org.pocketcampus.plugin.food.shared;

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

public class FoodResponse implements org.apache.thrift.TBase<FoodResponse, FoodResponse._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("FoodResponse");

  private static final org.apache.thrift.protocol.TField MENU_FIELD_DESC = new org.apache.thrift.protocol.TField("menu", org.apache.thrift.protocol.TType.LIST, (short)1);
  private static final org.apache.thrift.protocol.TField USER_STATUS_FIELD_DESC = new org.apache.thrift.protocol.TField("userStatus", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField MEAL_TYPE_PICTURE_URLS_FIELD_DESC = new org.apache.thrift.protocol.TField("mealTypePictureUrls", org.apache.thrift.protocol.TType.MAP, (short)3);
  private static final org.apache.thrift.protocol.TField STATUS_CODE_FIELD_DESC = new org.apache.thrift.protocol.TField("statusCode", org.apache.thrift.protocol.TType.I32, (short)4);

  private List<EpflRestaurant> menu; // required
  private PriceTarget userStatus; // required
  private Map<MealType,String> mealTypePictureUrls; // required
  private FoodStatusCode statusCode; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    MENU((short)1, "menu"),
    /**
     * 
     * @see PriceTarget
     */
    USER_STATUS((short)2, "userStatus"),
    MEAL_TYPE_PICTURE_URLS((short)3, "mealTypePictureUrls"),
    /**
     * 
     * @see FoodStatusCode
     */
    STATUS_CODE((short)4, "statusCode");

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
        case 1: // MENU
          return MENU;
        case 2: // USER_STATUS
          return USER_STATUS;
        case 3: // MEAL_TYPE_PICTURE_URLS
          return MEAL_TYPE_PICTURE_URLS;
        case 4: // STATUS_CODE
          return STATUS_CODE;
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
    tmpMap.put(_Fields.MENU, new org.apache.thrift.meta_data.FieldMetaData("menu", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, EpflRestaurant.class))));
    tmpMap.put(_Fields.USER_STATUS, new org.apache.thrift.meta_data.FieldMetaData("userStatus", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, PriceTarget.class)));
    tmpMap.put(_Fields.MEAL_TYPE_PICTURE_URLS, new org.apache.thrift.meta_data.FieldMetaData("mealTypePictureUrls", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.MapMetaData(org.apache.thrift.protocol.TType.MAP, 
            new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, MealType.class), 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    tmpMap.put(_Fields.STATUS_CODE, new org.apache.thrift.meta_data.FieldMetaData("statusCode", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, FoodStatusCode.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(FoodResponse.class, metaDataMap);
  }

  public FoodResponse() {
  }

  public FoodResponse(
    Map<MealType,String> mealTypePictureUrls,
    FoodStatusCode statusCode)
  {
    this();
    this.mealTypePictureUrls = mealTypePictureUrls;
    this.statusCode = statusCode;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public FoodResponse(FoodResponse other) {
    if (other.isSetMenu()) {
      List<EpflRestaurant> __this__menu = new ArrayList<EpflRestaurant>();
      for (EpflRestaurant other_element : other.menu) {
        __this__menu.add(new EpflRestaurant(other_element));
      }
      this.menu = __this__menu;
    }
    if (other.isSetUserStatus()) {
      this.userStatus = other.userStatus;
    }
    if (other.isSetMealTypePictureUrls()) {
      Map<MealType,String> __this__mealTypePictureUrls = new HashMap<MealType,String>();
      for (Map.Entry<MealType, String> other_element : other.mealTypePictureUrls.entrySet()) {

        MealType other_element_key = other_element.getKey();
        String other_element_value = other_element.getValue();

        MealType __this__mealTypePictureUrls_copy_key = other_element_key;

        String __this__mealTypePictureUrls_copy_value = other_element_value;

        __this__mealTypePictureUrls.put(__this__mealTypePictureUrls_copy_key, __this__mealTypePictureUrls_copy_value);
      }
      this.mealTypePictureUrls = __this__mealTypePictureUrls;
    }
    if (other.isSetStatusCode()) {
      this.statusCode = other.statusCode;
    }
  }

  public FoodResponse deepCopy() {
    return new FoodResponse(this);
  }

  @Override
  public void clear() {
    this.menu = null;
    this.userStatus = null;
    this.mealTypePictureUrls = null;
    this.statusCode = null;
  }

  public int getMenuSize() {
    return (this.menu == null) ? 0 : this.menu.size();
  }

  public java.util.Iterator<EpflRestaurant> getMenuIterator() {
    return (this.menu == null) ? null : this.menu.iterator();
  }

  public void addToMenu(EpflRestaurant elem) {
    if (this.menu == null) {
      this.menu = new ArrayList<EpflRestaurant>();
    }
    this.menu.add(elem);
  }

  public List<EpflRestaurant> getMenu() {
    return this.menu;
  }

  public FoodResponse setMenu(List<EpflRestaurant> menu) {
    this.menu = menu;
    return this;
  }

  public void unsetMenu() {
    this.menu = null;
  }

  /** Returns true if field menu is set (has been assigned a value) and false otherwise */
  public boolean isSetMenu() {
    return this.menu != null;
  }

  public void setMenuIsSet(boolean value) {
    if (!value) {
      this.menu = null;
    }
  }

  /**
   * 
   * @see PriceTarget
   */
  public PriceTarget getUserStatus() {
    return this.userStatus;
  }

  /**
   * 
   * @see PriceTarget
   */
  public FoodResponse setUserStatus(PriceTarget userStatus) {
    this.userStatus = userStatus;
    return this;
  }

  public void unsetUserStatus() {
    this.userStatus = null;
  }

  /** Returns true if field userStatus is set (has been assigned a value) and false otherwise */
  public boolean isSetUserStatus() {
    return this.userStatus != null;
  }

  public void setUserStatusIsSet(boolean value) {
    if (!value) {
      this.userStatus = null;
    }
  }

  public int getMealTypePictureUrlsSize() {
    return (this.mealTypePictureUrls == null) ? 0 : this.mealTypePictureUrls.size();
  }

  public void putToMealTypePictureUrls(MealType key, String val) {
    if (this.mealTypePictureUrls == null) {
      this.mealTypePictureUrls = new HashMap<MealType,String>();
    }
    this.mealTypePictureUrls.put(key, val);
  }

  public Map<MealType,String> getMealTypePictureUrls() {
    return this.mealTypePictureUrls;
  }

  public FoodResponse setMealTypePictureUrls(Map<MealType,String> mealTypePictureUrls) {
    this.mealTypePictureUrls = mealTypePictureUrls;
    return this;
  }

  public void unsetMealTypePictureUrls() {
    this.mealTypePictureUrls = null;
  }

  /** Returns true if field mealTypePictureUrls is set (has been assigned a value) and false otherwise */
  public boolean isSetMealTypePictureUrls() {
    return this.mealTypePictureUrls != null;
  }

  public void setMealTypePictureUrlsIsSet(boolean value) {
    if (!value) {
      this.mealTypePictureUrls = null;
    }
  }

  /**
   * 
   * @see FoodStatusCode
   */
  public FoodStatusCode getStatusCode() {
    return this.statusCode;
  }

  /**
   * 
   * @see FoodStatusCode
   */
  public FoodResponse setStatusCode(FoodStatusCode statusCode) {
    this.statusCode = statusCode;
    return this;
  }

  public void unsetStatusCode() {
    this.statusCode = null;
  }

  /** Returns true if field statusCode is set (has been assigned a value) and false otherwise */
  public boolean isSetStatusCode() {
    return this.statusCode != null;
  }

  public void setStatusCodeIsSet(boolean value) {
    if (!value) {
      this.statusCode = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case MENU:
      if (value == null) {
        unsetMenu();
      } else {
        setMenu((List<EpflRestaurant>)value);
      }
      break;

    case USER_STATUS:
      if (value == null) {
        unsetUserStatus();
      } else {
        setUserStatus((PriceTarget)value);
      }
      break;

    case MEAL_TYPE_PICTURE_URLS:
      if (value == null) {
        unsetMealTypePictureUrls();
      } else {
        setMealTypePictureUrls((Map<MealType,String>)value);
      }
      break;

    case STATUS_CODE:
      if (value == null) {
        unsetStatusCode();
      } else {
        setStatusCode((FoodStatusCode)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case MENU:
      return getMenu();

    case USER_STATUS:
      return getUserStatus();

    case MEAL_TYPE_PICTURE_URLS:
      return getMealTypePictureUrls();

    case STATUS_CODE:
      return getStatusCode();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case MENU:
      return isSetMenu();
    case USER_STATUS:
      return isSetUserStatus();
    case MEAL_TYPE_PICTURE_URLS:
      return isSetMealTypePictureUrls();
    case STATUS_CODE:
      return isSetStatusCode();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof FoodResponse)
      return this.equals((FoodResponse)that);
    return false;
  }

  public boolean equals(FoodResponse that) {
    if (that == null)
      return false;

    boolean this_present_menu = true && this.isSetMenu();
    boolean that_present_menu = true && that.isSetMenu();
    if (this_present_menu || that_present_menu) {
      if (!(this_present_menu && that_present_menu))
        return false;
      if (!this.menu.equals(that.menu))
        return false;
    }

    boolean this_present_userStatus = true && this.isSetUserStatus();
    boolean that_present_userStatus = true && that.isSetUserStatus();
    if (this_present_userStatus || that_present_userStatus) {
      if (!(this_present_userStatus && that_present_userStatus))
        return false;
      if (!this.userStatus.equals(that.userStatus))
        return false;
    }

    boolean this_present_mealTypePictureUrls = true && this.isSetMealTypePictureUrls();
    boolean that_present_mealTypePictureUrls = true && that.isSetMealTypePictureUrls();
    if (this_present_mealTypePictureUrls || that_present_mealTypePictureUrls) {
      if (!(this_present_mealTypePictureUrls && that_present_mealTypePictureUrls))
        return false;
      if (!this.mealTypePictureUrls.equals(that.mealTypePictureUrls))
        return false;
    }

    boolean this_present_statusCode = true && this.isSetStatusCode();
    boolean that_present_statusCode = true && that.isSetStatusCode();
    if (this_present_statusCode || that_present_statusCode) {
      if (!(this_present_statusCode && that_present_statusCode))
        return false;
      if (!this.statusCode.equals(that.statusCode))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_menu = true && (isSetMenu());
    builder.append(present_menu);
    if (present_menu)
      builder.append(menu);

    boolean present_userStatus = true && (isSetUserStatus());
    builder.append(present_userStatus);
    if (present_userStatus)
      builder.append(userStatus.getValue());

    boolean present_mealTypePictureUrls = true && (isSetMealTypePictureUrls());
    builder.append(present_mealTypePictureUrls);
    if (present_mealTypePictureUrls)
      builder.append(mealTypePictureUrls);

    boolean present_statusCode = true && (isSetStatusCode());
    builder.append(present_statusCode);
    if (present_statusCode)
      builder.append(statusCode.getValue());

    return builder.toHashCode();
  }

  public int compareTo(FoodResponse other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    FoodResponse typedOther = (FoodResponse)other;

    lastComparison = Boolean.valueOf(isSetMenu()).compareTo(typedOther.isSetMenu());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMenu()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.menu, typedOther.menu);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetUserStatus()).compareTo(typedOther.isSetUserStatus());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUserStatus()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.userStatus, typedOther.userStatus);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetMealTypePictureUrls()).compareTo(typedOther.isSetMealTypePictureUrls());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMealTypePictureUrls()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.mealTypePictureUrls, typedOther.mealTypePictureUrls);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetStatusCode()).compareTo(typedOther.isSetStatusCode());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetStatusCode()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.statusCode, typedOther.statusCode);
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
        case 1: // MENU
          if (field.type == org.apache.thrift.protocol.TType.LIST) {
            {
              org.apache.thrift.protocol.TList _list13 = iprot.readListBegin();
              this.menu = new ArrayList<EpflRestaurant>(_list13.size);
              for (int _i14 = 0; _i14 < _list13.size; ++_i14)
              {
                EpflRestaurant _elem15; // required
                _elem15 = new EpflRestaurant();
                _elem15.read(iprot);
                this.menu.add(_elem15);
              }
              iprot.readListEnd();
            }
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // USER_STATUS
          if (field.type == org.apache.thrift.protocol.TType.I32) {
            this.userStatus = PriceTarget.findByValue(iprot.readI32());
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 3: // MEAL_TYPE_PICTURE_URLS
          if (field.type == org.apache.thrift.protocol.TType.MAP) {
            {
              org.apache.thrift.protocol.TMap _map16 = iprot.readMapBegin();
              this.mealTypePictureUrls = new HashMap<MealType,String>(2*_map16.size);
              for (int _i17 = 0; _i17 < _map16.size; ++_i17)
              {
                MealType _key18; // required
                String _val19; // required
                _key18 = MealType.findByValue(iprot.readI32());
                _val19 = iprot.readString();
                this.mealTypePictureUrls.put(_key18, _val19);
              }
              iprot.readMapEnd();
            }
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 4: // STATUS_CODE
          if (field.type == org.apache.thrift.protocol.TType.I32) {
            this.statusCode = FoodStatusCode.findByValue(iprot.readI32());
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
    if (this.menu != null) {
      if (isSetMenu()) {
        oprot.writeFieldBegin(MENU_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, this.menu.size()));
          for (EpflRestaurant _iter20 : this.menu)
          {
            _iter20.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
    }
    if (this.userStatus != null) {
      if (isSetUserStatus()) {
        oprot.writeFieldBegin(USER_STATUS_FIELD_DESC);
        oprot.writeI32(this.userStatus.getValue());
        oprot.writeFieldEnd();
      }
    }
    if (this.mealTypePictureUrls != null) {
      oprot.writeFieldBegin(MEAL_TYPE_PICTURE_URLS_FIELD_DESC);
      {
        oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.I32, org.apache.thrift.protocol.TType.STRING, this.mealTypePictureUrls.size()));
        for (Map.Entry<MealType, String> _iter21 : this.mealTypePictureUrls.entrySet())
        {
          oprot.writeI32(_iter21.getKey().getValue());
          oprot.writeString(_iter21.getValue());
        }
        oprot.writeMapEnd();
      }
      oprot.writeFieldEnd();
    }
    if (this.statusCode != null) {
      oprot.writeFieldBegin(STATUS_CODE_FIELD_DESC);
      oprot.writeI32(this.statusCode.getValue());
      oprot.writeFieldEnd();
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("FoodResponse(");
    boolean first = true;

    if (isSetMenu()) {
      sb.append("menu:");
      if (this.menu == null) {
        sb.append("null");
      } else {
        sb.append(this.menu);
      }
      first = false;
    }
    if (isSetUserStatus()) {
      if (!first) sb.append(", ");
      sb.append("userStatus:");
      if (this.userStatus == null) {
        sb.append("null");
      } else {
        sb.append(this.userStatus);
      }
      first = false;
    }
    if (!first) sb.append(", ");
    sb.append("mealTypePictureUrls:");
    if (this.mealTypePictureUrls == null) {
      sb.append("null");
    } else {
      sb.append(this.mealTypePictureUrls);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("statusCode:");
    if (this.statusCode == null) {
      sb.append("null");
    } else {
      sb.append(this.statusCode);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (mealTypePictureUrls == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'mealTypePictureUrls' was not present! Struct: " + toString());
    }
    if (statusCode == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'statusCode' was not present! Struct: " + toString());
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

