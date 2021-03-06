/**
 * Autogenerated by Thrift Compiler (0.7.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package org.pocketcampus.plugin.cloudprint.shared;


import java.util.Map;
import java.util.HashMap;
import org.apache.thrift.TEnum;

public enum CloudPrintStatusCode implements org.apache.thrift.TEnum {
  OK(200),
  AUTHENTICATION_ERROR(407),
  PRINT_ERROR(404);

  private final int value;

  private CloudPrintStatusCode(int value) {
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
  public static CloudPrintStatusCode findByValue(int value) { 
    switch (value) {
      case 200:
        return OK;
      case 407:
        return AUTHENTICATION_ERROR;
      case 404:
        return PRINT_ERROR;
      default:
        return null;
    }
  }
}
