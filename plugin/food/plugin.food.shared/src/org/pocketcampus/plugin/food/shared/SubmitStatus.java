/**
 * Autogenerated by Thrift Compiler (0.9.2)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.pocketcampus.plugin.food.shared;


import java.util.Map;
import java.util.HashMap;
import org.apache.thrift.TEnum;

public enum SubmitStatus implements org.apache.thrift.TEnum {
  ALREADY_VOTED(0),
  VALID(1),
  TOO_EARLY(2),
  ERROR(3),
  MEAL_IN_DISTANT_PAST(4);

  private final int value;

  private SubmitStatus(int value) {
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
  public static SubmitStatus findByValue(int value) { 
    switch (value) {
      case 0:
        return ALREADY_VOTED;
      case 1:
        return VALID;
      case 2:
        return TOO_EARLY;
      case 3:
        return ERROR;
      case 4:
        return MEAL_IN_DISTANT_PAST;
      default:
        return null;
    }
  }
}
