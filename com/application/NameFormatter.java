package com.application;

public class NameFormatter {
  public static String toLowerCase(String str) {
    return str.toLowerCase();
  }

  public static String toCamelCase(String str) {
    if(str.isEmpty()) return str;
    if(str.length() == 1) return str.toLowerCase();
    return Character.toLowerCase(str.charAt(0)) + str.substring(1);
  }

  public static String toPascalCase(String str) {
    if(str.isEmpty()) return str;
    if(str.length() == 1) return str.toUpperCase();
    return Character.toUpperCase(str.charAt(0)) + str.substring(1);
  }
}
