package com.application;

class ClassDefinition {
  private AttributeArray attributes = new AttributeArray();
  private String name;


  public ClassDefinition(String name) {
    this.name = name;
  }

  public void addAttr(String type, String attrName) {
    Attribute attr = new Attribute(type, attrName);
    attributes.add(attr);
  }

  public String getName() {
    return name;
  }

  public AttributeArray getAttributes() {
    return attributes;
  }
}
