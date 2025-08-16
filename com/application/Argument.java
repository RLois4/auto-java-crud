package com.application;

class Attribute {
  private String type;
  private String name;
 
  public Attribute(String type, String name) {
    this.type = type;
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public String getName() {
    return name;
  }
}
