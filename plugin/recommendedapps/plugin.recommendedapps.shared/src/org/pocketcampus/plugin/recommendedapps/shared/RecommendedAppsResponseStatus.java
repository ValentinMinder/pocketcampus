/**
 * Autogenerated by Thrift Compiler (0.9.2)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.pocketcampus.plugin.recommendedapps.shared;


import java.util.Map;
import java.util.HashMap;
import org.apache.thrift.TEnum;

public enum RecommendedAppsResponseStatus implements org.apache.thrift.TEnum {
  OK(200),
  ERROR(500);

  private final int value;

  private RecommendedAppsResponseStatus(int value) {
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
  public static RecommendedAppsResponseStatus findByValue(int value) { 
    switch (value) {
      case 200:
        return OK;
      case 500:
        return ERROR;
      default:
        return null;
    }
  }
}
