package com.application;

public class Attribute {
  private final String type;
  private final String name;

  public Attribute(String type, String name) {
    this.type = type;
    this.name = name;
  }

  public Attribute(String typename) {
    String[] strSplit = typename.split(" ");
    if(strSplit.length != 2 || strSplit[0].isBlank() || strSplit[1].isBlank()) throw new IllegalArgumentException("Invalid: argument");
    type = strSplit[0];
    name = strSplit[1];
  }

  public String getType() {
    return type;
  }

  public String getName() {
    return name;
  }
}
