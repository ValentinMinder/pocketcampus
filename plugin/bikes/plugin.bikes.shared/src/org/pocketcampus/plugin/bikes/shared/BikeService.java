/**
 * Autogenerated by Thrift Compiler (0.7.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package org.pocketcampus.plugin.bikes.shared;

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

public class BikeService {

  public interface Iface {

    public List<BikeEmplacement> getAvailableBikes() throws WebParseException, org.apache.thrift.TException;

  }

  public interface AsyncIface {

    public void getAvailableBikes(org.apache.thrift.async.AsyncMethodCallback<AsyncClient.getAvailableBikes_call> resultHandler) throws org.apache.thrift.TException;

  }

  public static class Client extends org.apache.thrift.TServiceClient implements Iface {
    public static class Factory implements org.apache.thrift.TServiceClientFactory<Client> {
      public Factory() {}
      public Client getClient(org.apache.thrift.protocol.TProtocol prot) {
        return new Client(prot);
      }
      public Client getClient(org.apache.thrift.protocol.TProtocol iprot, org.apache.thrift.protocol.TProtocol oprot) {
        return new Client(iprot, oprot);
      }
    }

    public Client(org.apache.thrift.protocol.TProtocol prot)
    {
      super(prot, prot);
    }

    public Client(org.apache.thrift.protocol.TProtocol iprot, org.apache.thrift.protocol.TProtocol oprot) {
      super(iprot, oprot);
    }

    public List<BikeEmplacement> getAvailableBikes() throws WebParseException, org.apache.thrift.TException
    {
      send_getAvailableBikes();
      return recv_getAvailableBikes();
    }

    public void send_getAvailableBikes() throws org.apache.thrift.TException
    {
      getAvailableBikes_args args = new getAvailableBikes_args();
      sendBase("getAvailableBikes", args);
    }

    public List<BikeEmplacement> recv_getAvailableBikes() throws WebParseException, org.apache.thrift.TException
    {
      getAvailableBikes_result result = new getAvailableBikes_result();
      receiveBase(result, "getAvailableBikes");
      if (result.isSetSuccess()) {
        return result.success;
      }
      if (result.wpe != null) {
        throw result.wpe;
      }
      throw new org.apache.thrift.TApplicationException(org.apache.thrift.TApplicationException.MISSING_RESULT, "getAvailableBikes failed: unknown result");
    }

  }
  public static class AsyncClient extends org.apache.thrift.async.TAsyncClient implements AsyncIface {
    public static class Factory implements org.apache.thrift.async.TAsyncClientFactory<AsyncClient> {
      private org.apache.thrift.async.TAsyncClientManager clientManager;
      private org.apache.thrift.protocol.TProtocolFactory protocolFactory;
      public Factory(org.apache.thrift.async.TAsyncClientManager clientManager, org.apache.thrift.protocol.TProtocolFactory protocolFactory) {
        this.clientManager = clientManager;
        this.protocolFactory = protocolFactory;
      }
      public AsyncClient getAsyncClient(org.apache.thrift.transport.TNonblockingTransport transport) {
        return new AsyncClient(protocolFactory, clientManager, transport);
      }
    }

    public AsyncClient(org.apache.thrift.protocol.TProtocolFactory protocolFactory, org.apache.thrift.async.TAsyncClientManager clientManager, org.apache.thrift.transport.TNonblockingTransport transport) {
      super(protocolFactory, clientManager, transport);
    }

    public void getAvailableBikes(org.apache.thrift.async.AsyncMethodCallback<getAvailableBikes_call> resultHandler) throws org.apache.thrift.TException {
      checkReady();
      getAvailableBikes_call method_call = new getAvailableBikes_call(resultHandler, this, ___protocolFactory, ___transport);
      this.___currentMethod = method_call;
      ___manager.call(method_call);
    }

    public static class getAvailableBikes_call extends org.apache.thrift.async.TAsyncMethodCall {
      public getAvailableBikes_call(org.apache.thrift.async.AsyncMethodCallback<getAvailableBikes_call> resultHandler, org.apache.thrift.async.TAsyncClient client, org.apache.thrift.protocol.TProtocolFactory protocolFactory, org.apache.thrift.transport.TNonblockingTransport transport) throws org.apache.thrift.TException {
        super(client, protocolFactory, transport, resultHandler, false);
      }

      public void write_args(org.apache.thrift.protocol.TProtocol prot) throws org.apache.thrift.TException {
        prot.writeMessageBegin(new org.apache.thrift.protocol.TMessage("getAvailableBikes", org.apache.thrift.protocol.TMessageType.CALL, 0));
        getAvailableBikes_args args = new getAvailableBikes_args();
        args.write(prot);
        prot.writeMessageEnd();
      }

      public List<BikeEmplacement> getResult() throws WebParseException, org.apache.thrift.TException {
        if (getState() != org.apache.thrift.async.TAsyncMethodCall.State.RESPONSE_READ) {
          throw new IllegalStateException("Method call not finished!");
        }
        org.apache.thrift.transport.TMemoryInputTransport memoryTransport = new org.apache.thrift.transport.TMemoryInputTransport(getFrameBuffer().array());
        org.apache.thrift.protocol.TProtocol prot = client.getProtocolFactory().getProtocol(memoryTransport);
        return (new Client(prot)).recv_getAvailableBikes();
      }
    }

  }

  public static class Processor<I extends Iface> extends org.apache.thrift.TBaseProcessor implements org.apache.thrift.TProcessor {
    private static final Logger LOGGER = LoggerFactory.getLogger(Processor.class.getName());
    public Processor(I iface) {
      super(iface, getProcessMap(new HashMap<String, org.apache.thrift.ProcessFunction<I, ? extends org.apache.thrift.TBase>>()));
    }

    protected Processor(I iface, Map<String,  org.apache.thrift.ProcessFunction<I, ? extends  org.apache.thrift.TBase>> processMap) {
      super(iface, getProcessMap(processMap));
    }

    private static <I extends Iface> Map<String,  org.apache.thrift.ProcessFunction<I, ? extends  org.apache.thrift.TBase>> getProcessMap(Map<String,  org.apache.thrift.ProcessFunction<I, ? extends  org.apache.thrift.TBase>> processMap) {
      processMap.put("getAvailableBikes", new getAvailableBikes());
      return processMap;
    }

    private static class getAvailableBikes<I extends Iface> extends org.apache.thrift.ProcessFunction<I, getAvailableBikes_args> {
      public getAvailableBikes() {
        super("getAvailableBikes");
      }

      protected getAvailableBikes_args getEmptyArgsInstance() {
        return new getAvailableBikes_args();
      }

      protected getAvailableBikes_result getResult(I iface, getAvailableBikes_args args) throws org.apache.thrift.TException {
        getAvailableBikes_result result = new getAvailableBikes_result();
        try {
          result.success = iface.getAvailableBikes();
        } catch (WebParseException wpe) {
          result.wpe = wpe;
        }
        return result;
      }
    }

  }

  public static class getAvailableBikes_args implements org.apache.thrift.TBase<getAvailableBikes_args, getAvailableBikes_args._Fields>, java.io.Serializable, Cloneable   {
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("getAvailableBikes_args");



    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
;

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
    public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
    static {
      Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
      metaDataMap = Collections.unmodifiableMap(tmpMap);
      org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(getAvailableBikes_args.class, metaDataMap);
    }

    public getAvailableBikes_args() {
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public getAvailableBikes_args(getAvailableBikes_args other) {
    }

    public getAvailableBikes_args deepCopy() {
      return new getAvailableBikes_args(this);
    }

    @Override
    public void clear() {
    }

    public void setFieldValue(_Fields field, Object value) {
      switch (field) {
      }
    }

    public Object getFieldValue(_Fields field) {
      switch (field) {
      }
      throw new IllegalStateException();
    }

    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
    public boolean isSet(_Fields field) {
      if (field == null) {
        throw new IllegalArgumentException();
      }

      switch (field) {
      }
      throw new IllegalStateException();
    }

    @Override
    public boolean equals(Object that) {
      if (that == null)
        return false;
      if (that instanceof getAvailableBikes_args)
        return this.equals((getAvailableBikes_args)that);
      return false;
    }

    public boolean equals(getAvailableBikes_args that) {
      if (that == null)
        return false;

      return true;
    }

    @Override
    public int hashCode() {
      HashCodeBuilder builder = new HashCodeBuilder();

      return builder.toHashCode();
    }

    public int compareTo(getAvailableBikes_args other) {
      if (!getClass().equals(other.getClass())) {
        return getClass().getName().compareTo(other.getClass().getName());
      }

      int lastComparison = 0;
      getAvailableBikes_args typedOther = (getAvailableBikes_args)other;

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
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder("getAvailableBikes_args(");
      boolean first = true;

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

  public static class getAvailableBikes_result implements org.apache.thrift.TBase<getAvailableBikes_result, getAvailableBikes_result._Fields>, java.io.Serializable, Cloneable   {
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("getAvailableBikes_result");

    private static final org.apache.thrift.protocol.TField SUCCESS_FIELD_DESC = new org.apache.thrift.protocol.TField("success", org.apache.thrift.protocol.TType.LIST, (short)0);
    private static final org.apache.thrift.protocol.TField WPE_FIELD_DESC = new org.apache.thrift.protocol.TField("wpe", org.apache.thrift.protocol.TType.STRUCT, (short)1);

    public List<BikeEmplacement> success; // required
    public WebParseException wpe; // required

    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
      SUCCESS((short)0, "success"),
      WPE((short)1, "wpe");

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
          case 0: // SUCCESS
            return SUCCESS;
          case 1: // WPE
            return WPE;
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
      tmpMap.put(_Fields.SUCCESS, new org.apache.thrift.meta_data.FieldMetaData("success", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
              new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, BikeEmplacement.class))));
      tmpMap.put(_Fields.WPE, new org.apache.thrift.meta_data.FieldMetaData("wpe", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRUCT)));
      metaDataMap = Collections.unmodifiableMap(tmpMap);
      org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(getAvailableBikes_result.class, metaDataMap);
    }

    public getAvailableBikes_result() {
    }

    public getAvailableBikes_result(
      List<BikeEmplacement> success,
      WebParseException wpe)
    {
      this();
      this.success = success;
      this.wpe = wpe;
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public getAvailableBikes_result(getAvailableBikes_result other) {
      if (other.isSetSuccess()) {
        List<BikeEmplacement> __this__success = new ArrayList<BikeEmplacement>();
        for (BikeEmplacement other_element : other.success) {
          __this__success.add(new BikeEmplacement(other_element));
        }
        this.success = __this__success;
      }
      if (other.isSetWpe()) {
        this.wpe = new WebParseException(other.wpe);
      }
    }

    public getAvailableBikes_result deepCopy() {
      return new getAvailableBikes_result(this);
    }

    @Override
    public void clear() {
      this.success = null;
      this.wpe = null;
    }

    public int getSuccessSize() {
      return (this.success == null) ? 0 : this.success.size();
    }

    public java.util.Iterator<BikeEmplacement> getSuccessIterator() {
      return (this.success == null) ? null : this.success.iterator();
    }

    public void addToSuccess(BikeEmplacement elem) {
      if (this.success == null) {
        this.success = new ArrayList<BikeEmplacement>();
      }
      this.success.add(elem);
    }

    public List<BikeEmplacement> getSuccess() {
      return this.success;
    }

    public getAvailableBikes_result setSuccess(List<BikeEmplacement> success) {
      this.success = success;
      return this;
    }

    public void unsetSuccess() {
      this.success = null;
    }

    /** Returns true if field success is set (has been assigned a value) and false otherwise */
    public boolean isSetSuccess() {
      return this.success != null;
    }

    public void setSuccessIsSet(boolean value) {
      if (!value) {
        this.success = null;
      }
    }

    public WebParseException getWpe() {
      return this.wpe;
    }

    public getAvailableBikes_result setWpe(WebParseException wpe) {
      this.wpe = wpe;
      return this;
    }

    public void unsetWpe() {
      this.wpe = null;
    }

    /** Returns true if field wpe is set (has been assigned a value) and false otherwise */
    public boolean isSetWpe() {
      return this.wpe != null;
    }

    public void setWpeIsSet(boolean value) {
      if (!value) {
        this.wpe = null;
      }
    }

    public void setFieldValue(_Fields field, Object value) {
      switch (field) {
      case SUCCESS:
        if (value == null) {
          unsetSuccess();
        } else {
          setSuccess((List<BikeEmplacement>)value);
        }
        break;

      case WPE:
        if (value == null) {
          unsetWpe();
        } else {
          setWpe((WebParseException)value);
        }
        break;

      }
    }

    public Object getFieldValue(_Fields field) {
      switch (field) {
      case SUCCESS:
        return getSuccess();

      case WPE:
        return getWpe();

      }
      throw new IllegalStateException();
    }

    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
    public boolean isSet(_Fields field) {
      if (field == null) {
        throw new IllegalArgumentException();
      }

      switch (field) {
      case SUCCESS:
        return isSetSuccess();
      case WPE:
        return isSetWpe();
      }
      throw new IllegalStateException();
    }

    @Override
    public boolean equals(Object that) {
      if (that == null)
        return false;
      if (that instanceof getAvailableBikes_result)
        return this.equals((getAvailableBikes_result)that);
      return false;
    }

    public boolean equals(getAvailableBikes_result that) {
      if (that == null)
        return false;

      boolean this_present_success = true && this.isSetSuccess();
      boolean that_present_success = true && that.isSetSuccess();
      if (this_present_success || that_present_success) {
        if (!(this_present_success && that_present_success))
          return false;
        if (!this.success.equals(that.success))
          return false;
      }

      boolean this_present_wpe = true && this.isSetWpe();
      boolean that_present_wpe = true && that.isSetWpe();
      if (this_present_wpe || that_present_wpe) {
        if (!(this_present_wpe && that_present_wpe))
          return false;
        if (!this.wpe.equals(that.wpe))
          return false;
      }

      return true;
    }

    @Override
    public int hashCode() {
      HashCodeBuilder builder = new HashCodeBuilder();

      boolean present_success = true && (isSetSuccess());
      builder.append(present_success);
      if (present_success)
        builder.append(success);

      boolean present_wpe = true && (isSetWpe());
      builder.append(present_wpe);
      if (present_wpe)
        builder.append(wpe);

      return builder.toHashCode();
    }

    public int compareTo(getAvailableBikes_result other) {
      if (!getClass().equals(other.getClass())) {
        return getClass().getName().compareTo(other.getClass().getName());
      }

      int lastComparison = 0;
      getAvailableBikes_result typedOther = (getAvailableBikes_result)other;

      lastComparison = Boolean.valueOf(isSetSuccess()).compareTo(typedOther.isSetSuccess());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetSuccess()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.success, typedOther.success);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      lastComparison = Boolean.valueOf(isSetWpe()).compareTo(typedOther.isSetWpe());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetWpe()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.wpe, typedOther.wpe);
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
          case 0: // SUCCESS
            if (field.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list0 = iprot.readListBegin();
                this.success = new ArrayList<BikeEmplacement>(_list0.size);
                for (int _i1 = 0; _i1 < _list0.size; ++_i1)
                {
                  BikeEmplacement _elem2; // required
                  _elem2 = new BikeEmplacement();
                  _elem2.read(iprot);
                  this.success.add(_elem2);
                }
                iprot.readListEnd();
              }
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
            }
            break;
          case 1: // WPE
            if (field.type == org.apache.thrift.protocol.TType.STRUCT) {
              this.wpe = new WebParseException();
              this.wpe.read(iprot);
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
      oprot.writeStructBegin(STRUCT_DESC);

      if (this.isSetSuccess()) {
        oprot.writeFieldBegin(SUCCESS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, this.success.size()));
          for (BikeEmplacement _iter3 : this.success)
          {
            _iter3.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      } else if (this.isSetWpe()) {
        oprot.writeFieldBegin(WPE_FIELD_DESC);
        this.wpe.write(oprot);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder("getAvailableBikes_result(");
      boolean first = true;

      sb.append("success:");
      if (this.success == null) {
        sb.append("null");
      } else {
        sb.append(this.success);
      }
      first = false;
      if (!first) sb.append(", ");
      sb.append("wpe:");
      if (this.wpe == null) {
        sb.append("null");
      } else {
        sb.append(this.wpe);
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

}