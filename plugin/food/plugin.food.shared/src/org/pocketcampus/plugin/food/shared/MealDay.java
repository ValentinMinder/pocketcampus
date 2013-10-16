/**
 * Autogenerated by Thrift Compiler (0.7.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package org.pocketcampus.plugin.food.shared;


import java.util.Map;
import java.util.HashMap;
import org.apache.thrift.TEnum;

public enum MealDay implements org.apache.thrift.TEnum {
  SUN(0),
  MON(1),
  TUE(2),
  WED(3),
  THU(4),
  FRI(5),
  SAT(6);

  private final int value;

  private MealDay(int value) {
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
  public static MealDay findByValue(int value) { 
    switch (value) {
      case 0:
        return SUN;
      case 1:
        return MON;
      case 2:
        return TUE;
      case 3:
        return WED;
      case 4:
        return THU;
      case 5:
        return FRI;
      case 6:
        return SAT;
      default:
        return null;
    }
  }
}
