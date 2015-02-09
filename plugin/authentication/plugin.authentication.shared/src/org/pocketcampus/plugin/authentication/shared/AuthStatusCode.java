/**
 * Autogenerated by Thrift Compiler (0.9.2)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.pocketcampus.plugin.authentication.shared;


import java.util.Map;
import java.util.HashMap;
import org.apache.thrift.TEnum;

public enum AuthStatusCode implements org.apache.thrift.TEnum {
  OK(200),
  NETWORK_ERROR(404),
  INVALID_SESSION(407),
  SERVER_ERROR(500);

  private final int value;

  private AuthStatusCode(int value) {
    this.value = value;
  }

  /**
   * Get the integer value of this enum value, as defined in the Thrift IDL.
   */
  public int getValue() {
    return value;
  }

  /**
   * Find a the enum type by its integer value, as defined in the Thrift IDL.
   * @return null if the value is not found.
   */
  public static AuthStatusCode findByValue(int value) { 
    switch (value) {
      case 200:
        return OK;
      case 404:
        return NETWORK_ERROR;
      case 407:
        return INVALID_SESSION;
      case 500:
        return SERVER_ERROR;
      default:
        return null;
    }
  }
}
