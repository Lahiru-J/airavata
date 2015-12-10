/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * Autogenerated by Thrift Compiler (0.9.2)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.apache.airavata.model.messaging.event;

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
@Generated(value = "Autogenerated by Thrift Compiler (0.9.2)", date = "2015-12-10")
public class Message implements org.apache.thrift.TBase<Message, Message._Fields>, java.io.Serializable, Cloneable, Comparable<Message> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Message");

  private static final org.apache.thrift.protocol.TField EVENT_FIELD_DESC = new org.apache.thrift.protocol.TField("event", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField MESSAGE_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("messageId", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField MESSAGE_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("messageType", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField UPDATED_TIME_FIELD_DESC = new org.apache.thrift.protocol.TField("updatedTime", org.apache.thrift.protocol.TType.I64, (short)4);
  private static final org.apache.thrift.protocol.TField MESSAGE_LEVEL_FIELD_DESC = new org.apache.thrift.protocol.TField("messageLevel", org.apache.thrift.protocol.TType.I32, (short)5);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new MessageStandardSchemeFactory());
    schemes.put(TupleScheme.class, new MessageTupleSchemeFactory());
  }

  private ByteBuffer event; // required
  private String messageId; // required
  private MessageType messageType; // required
  private long updatedTime; // optional
  private MessageLevel messageLevel; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    EVENT((short)1, "event"),
    MESSAGE_ID((short)2, "messageId"),
    /**
     * 
     * @see MessageType
     */
    MESSAGE_TYPE((short)3, "messageType"),
    UPDATED_TIME((short)4, "updatedTime"),
    /**
     * 
     * @see MessageLevel
     */
    MESSAGE_LEVEL((short)5, "messageLevel");

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
        case 1: // EVENT
          return EVENT;
        case 2: // MESSAGE_ID
          return MESSAGE_ID;
        case 3: // MESSAGE_TYPE
          return MESSAGE_TYPE;
        case 4: // UPDATED_TIME
          return UPDATED_TIME;
        case 5: // MESSAGE_LEVEL
          return MESSAGE_LEVEL;
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
  private static final int __UPDATEDTIME_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.UPDATED_TIME,_Fields.MESSAGE_LEVEL};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.EVENT, new org.apache.thrift.meta_data.FieldMetaData("event", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , true)));
    tmpMap.put(_Fields.MESSAGE_ID, new org.apache.thrift.meta_data.FieldMetaData("messageId", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.MESSAGE_TYPE, new org.apache.thrift.meta_data.FieldMetaData("messageType", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, MessageType.class)));
    tmpMap.put(_Fields.UPDATED_TIME, new org.apache.thrift.meta_data.FieldMetaData("updatedTime", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.MESSAGE_LEVEL, new org.apache.thrift.meta_data.FieldMetaData("messageLevel", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, MessageLevel.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Message.class, metaDataMap);
  }

  public Message() {
    this.messageId = "DO_NOT_SET_AT_CLIENTS";

  }

  public Message(
    ByteBuffer event,
    String messageId,
    MessageType messageType)
  {
    this();
    this.event = org.apache.thrift.TBaseHelper.copyBinary(event);
    this.messageId = messageId;
    this.messageType = messageType;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Message(Message other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetEvent()) {
      this.event = org.apache.thrift.TBaseHelper.copyBinary(other.event);
    }
    if (other.isSetMessageId()) {
      this.messageId = other.messageId;
    }
    if (other.isSetMessageType()) {
      this.messageType = other.messageType;
    }
    this.updatedTime = other.updatedTime;
    if (other.isSetMessageLevel()) {
      this.messageLevel = other.messageLevel;
    }
  }

  public Message deepCopy() {
    return new Message(this);
  }

  @Override
  public void clear() {
    this.event = null;
    this.messageId = "DO_NOT_SET_AT_CLIENTS";

    this.messageType = null;
    setUpdatedTimeIsSet(false);
    this.updatedTime = 0;
    this.messageLevel = null;
  }

  public byte[] getEvent() {
    setEvent(org.apache.thrift.TBaseHelper.rightSize(event));
    return event == null ? null : event.array();
  }

  public ByteBuffer bufferForEvent() {
    return org.apache.thrift.TBaseHelper.copyBinary(event);
  }

  public void setEvent(byte[] event) {
    this.event = event == null ? (ByteBuffer)null : ByteBuffer.wrap(Arrays.copyOf(event, event.length));
  }

  public void setEvent(ByteBuffer event) {
    this.event = org.apache.thrift.TBaseHelper.copyBinary(event);
  }

  public void unsetEvent() {
    this.event = null;
  }

  /** Returns true if field event is set (has been assigned a value) and false otherwise */
  public boolean isSetEvent() {
    return this.event != null;
  }

  public void setEventIsSet(boolean value) {
    if (!value) {
      this.event = null;
    }
  }

  public String getMessageId() {
    return this.messageId;
  }

  public void setMessageId(String messageId) {
    this.messageId = messageId;
  }

  public void unsetMessageId() {
    this.messageId = null;
  }

  /** Returns true if field messageId is set (has been assigned a value) and false otherwise */
  public boolean isSetMessageId() {
    return this.messageId != null;
  }

  public void setMessageIdIsSet(boolean value) {
    if (!value) {
      this.messageId = null;
    }
  }

  /**
   * 
   * @see MessageType
   */
  public MessageType getMessageType() {
    return this.messageType;
  }

  /**
   * 
   * @see MessageType
   */
  public void setMessageType(MessageType messageType) {
    this.messageType = messageType;
  }

  public void unsetMessageType() {
    this.messageType = null;
  }

  /** Returns true if field messageType is set (has been assigned a value) and false otherwise */
  public boolean isSetMessageType() {
    return this.messageType != null;
  }

  public void setMessageTypeIsSet(boolean value) {
    if (!value) {
      this.messageType = null;
    }
  }

  public long getUpdatedTime() {
    return this.updatedTime;
  }

  public void setUpdatedTime(long updatedTime) {
    this.updatedTime = updatedTime;
    setUpdatedTimeIsSet(true);
  }

  public void unsetUpdatedTime() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __UPDATEDTIME_ISSET_ID);
  }

  /** Returns true if field updatedTime is set (has been assigned a value) and false otherwise */
  public boolean isSetUpdatedTime() {
    return EncodingUtils.testBit(__isset_bitfield, __UPDATEDTIME_ISSET_ID);
  }

  public void setUpdatedTimeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __UPDATEDTIME_ISSET_ID, value);
  }

  /**
   * 
   * @see MessageLevel
   */
  public MessageLevel getMessageLevel() {
    return this.messageLevel;
  }

  /**
   * 
   * @see MessageLevel
   */
  public void setMessageLevel(MessageLevel messageLevel) {
    this.messageLevel = messageLevel;
  }

  public void unsetMessageLevel() {
    this.messageLevel = null;
  }

  /** Returns true if field messageLevel is set (has been assigned a value) and false otherwise */
  public boolean isSetMessageLevel() {
    return this.messageLevel != null;
  }

  public void setMessageLevelIsSet(boolean value) {
    if (!value) {
      this.messageLevel = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case EVENT:
      if (value == null) {
        unsetEvent();
      } else {
        setEvent((ByteBuffer)value);
      }
      break;

    case MESSAGE_ID:
      if (value == null) {
        unsetMessageId();
      } else {
        setMessageId((String)value);
      }
      break;

    case MESSAGE_TYPE:
      if (value == null) {
        unsetMessageType();
      } else {
        setMessageType((MessageType)value);
      }
      break;

    case UPDATED_TIME:
      if (value == null) {
        unsetUpdatedTime();
      } else {
        setUpdatedTime((Long)value);
      }
      break;

    case MESSAGE_LEVEL:
      if (value == null) {
        unsetMessageLevel();
      } else {
        setMessageLevel((MessageLevel)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case EVENT:
      return getEvent();

    case MESSAGE_ID:
      return getMessageId();

    case MESSAGE_TYPE:
      return getMessageType();

    case UPDATED_TIME:
      return Long.valueOf(getUpdatedTime());

    case MESSAGE_LEVEL:
      return getMessageLevel();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case EVENT:
      return isSetEvent();
    case MESSAGE_ID:
      return isSetMessageId();
    case MESSAGE_TYPE:
      return isSetMessageType();
    case UPDATED_TIME:
      return isSetUpdatedTime();
    case MESSAGE_LEVEL:
      return isSetMessageLevel();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Message)
      return this.equals((Message)that);
    return false;
  }

  public boolean equals(Message that) {
    if (that == null)
      return false;

    boolean this_present_event = true && this.isSetEvent();
    boolean that_present_event = true && that.isSetEvent();
    if (this_present_event || that_present_event) {
      if (!(this_present_event && that_present_event))
        return false;
      if (!this.event.equals(that.event))
        return false;
    }

    boolean this_present_messageId = true && this.isSetMessageId();
    boolean that_present_messageId = true && that.isSetMessageId();
    if (this_present_messageId || that_present_messageId) {
      if (!(this_present_messageId && that_present_messageId))
        return false;
      if (!this.messageId.equals(that.messageId))
        return false;
    }

    boolean this_present_messageType = true && this.isSetMessageType();
    boolean that_present_messageType = true && that.isSetMessageType();
    if (this_present_messageType || that_present_messageType) {
      if (!(this_present_messageType && that_present_messageType))
        return false;
      if (!this.messageType.equals(that.messageType))
        return false;
    }

    boolean this_present_updatedTime = true && this.isSetUpdatedTime();
    boolean that_present_updatedTime = true && that.isSetUpdatedTime();
    if (this_present_updatedTime || that_present_updatedTime) {
      if (!(this_present_updatedTime && that_present_updatedTime))
        return false;
      if (this.updatedTime != that.updatedTime)
        return false;
    }

    boolean this_present_messageLevel = true && this.isSetMessageLevel();
    boolean that_present_messageLevel = true && that.isSetMessageLevel();
    if (this_present_messageLevel || that_present_messageLevel) {
      if (!(this_present_messageLevel && that_present_messageLevel))
        return false;
      if (!this.messageLevel.equals(that.messageLevel))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_event = true && (isSetEvent());
    list.add(present_event);
    if (present_event)
      list.add(event);

    boolean present_messageId = true && (isSetMessageId());
    list.add(present_messageId);
    if (present_messageId)
      list.add(messageId);

    boolean present_messageType = true && (isSetMessageType());
    list.add(present_messageType);
    if (present_messageType)
      list.add(messageType.getValue());

    boolean present_updatedTime = true && (isSetUpdatedTime());
    list.add(present_updatedTime);
    if (present_updatedTime)
      list.add(updatedTime);

    boolean present_messageLevel = true && (isSetMessageLevel());
    list.add(present_messageLevel);
    if (present_messageLevel)
      list.add(messageLevel.getValue());

    return list.hashCode();
  }

  @Override
  public int compareTo(Message other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetEvent()).compareTo(other.isSetEvent());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetEvent()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.event, other.event);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetMessageId()).compareTo(other.isSetMessageId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMessageId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.messageId, other.messageId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetMessageType()).compareTo(other.isSetMessageType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMessageType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.messageType, other.messageType);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetUpdatedTime()).compareTo(other.isSetUpdatedTime());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUpdatedTime()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.updatedTime, other.updatedTime);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetMessageLevel()).compareTo(other.isSetMessageLevel());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMessageLevel()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.messageLevel, other.messageLevel);
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
    StringBuilder sb = new StringBuilder("Message(");
    boolean first = true;

    sb.append("event:");
    if (this.event == null) {
      sb.append("null");
    } else {
      org.apache.thrift.TBaseHelper.toString(this.event, sb);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("messageId:");
    if (this.messageId == null) {
      sb.append("null");
    } else {
      sb.append(this.messageId);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("messageType:");
    if (this.messageType == null) {
      sb.append("null");
    } else {
      sb.append(this.messageType);
    }
    first = false;
    if (isSetUpdatedTime()) {
      if (!first) sb.append(", ");
      sb.append("updatedTime:");
      sb.append(this.updatedTime);
      first = false;
    }
    if (isSetMessageLevel()) {
      if (!first) sb.append(", ");
      sb.append("messageLevel:");
      if (this.messageLevel == null) {
        sb.append("null");
      } else {
        sb.append(this.messageLevel);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (!isSetEvent()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'event' is unset! Struct:" + toString());
    }

    if (!isSetMessageId()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'messageId' is unset! Struct:" + toString());
    }

    if (!isSetMessageType()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'messageType' is unset! Struct:" + toString());
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
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class MessageStandardSchemeFactory implements SchemeFactory {
    public MessageStandardScheme getScheme() {
      return new MessageStandardScheme();
    }
  }

  private static class MessageStandardScheme extends StandardScheme<Message> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, Message struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // EVENT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.event = iprot.readBinary();
              struct.setEventIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // MESSAGE_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.messageId = iprot.readString();
              struct.setMessageIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // MESSAGE_TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.messageType = org.apache.airavata.model.messaging.event.MessageType.findByValue(iprot.readI32());
              struct.setMessageTypeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // UPDATED_TIME
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.updatedTime = iprot.readI64();
              struct.setUpdatedTimeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // MESSAGE_LEVEL
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.messageLevel = org.apache.airavata.model.messaging.event.MessageLevel.findByValue(iprot.readI32());
              struct.setMessageLevelIsSet(true);
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
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, Message struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.event != null) {
        oprot.writeFieldBegin(EVENT_FIELD_DESC);
        oprot.writeBinary(struct.event);
        oprot.writeFieldEnd();
      }
      if (struct.messageId != null) {
        oprot.writeFieldBegin(MESSAGE_ID_FIELD_DESC);
        oprot.writeString(struct.messageId);
        oprot.writeFieldEnd();
      }
      if (struct.messageType != null) {
        oprot.writeFieldBegin(MESSAGE_TYPE_FIELD_DESC);
        oprot.writeI32(struct.messageType.getValue());
        oprot.writeFieldEnd();
      }
      if (struct.isSetUpdatedTime()) {
        oprot.writeFieldBegin(UPDATED_TIME_FIELD_DESC);
        oprot.writeI64(struct.updatedTime);
        oprot.writeFieldEnd();
      }
      if (struct.messageLevel != null) {
        if (struct.isSetMessageLevel()) {
          oprot.writeFieldBegin(MESSAGE_LEVEL_FIELD_DESC);
          oprot.writeI32(struct.messageLevel.getValue());
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class MessageTupleSchemeFactory implements SchemeFactory {
    public MessageTupleScheme getScheme() {
      return new MessageTupleScheme();
    }
  }

  private static class MessageTupleScheme extends TupleScheme<Message> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Message struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeBinary(struct.event);
      oprot.writeString(struct.messageId);
      oprot.writeI32(struct.messageType.getValue());
      BitSet optionals = new BitSet();
      if (struct.isSetUpdatedTime()) {
        optionals.set(0);
      }
      if (struct.isSetMessageLevel()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetUpdatedTime()) {
        oprot.writeI64(struct.updatedTime);
      }
      if (struct.isSetMessageLevel()) {
        oprot.writeI32(struct.messageLevel.getValue());
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Message struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.event = iprot.readBinary();
      struct.setEventIsSet(true);
      struct.messageId = iprot.readString();
      struct.setMessageIdIsSet(true);
      struct.messageType = org.apache.airavata.model.messaging.event.MessageType.findByValue(iprot.readI32());
      struct.setMessageTypeIsSet(true);
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.updatedTime = iprot.readI64();
        struct.setUpdatedTimeIsSet(true);
      }
      if (incoming.get(1)) {
        struct.messageLevel = org.apache.airavata.model.messaging.event.MessageLevel.findByValue(iprot.readI32());
        struct.setMessageLevelIsSet(true);
      }
    }
  }

}

