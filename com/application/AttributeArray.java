package com.application;

import java.util.ArrayList;


public class AttributeArray extends ArrayList<Attribute> {
  public AttributeArray() {}

  public AttributeArray(Attribute... attributes) {
    for(Attribute attr: attributes) {
      this.add(attr);
    }
  }
 
  public AttributeArray(String attributes) {
    String[] attrSplit = attributes.split(",");
    for(String i: attrSplit) {
      Attribute attr = new Attribute(i);
      this.add(attr);
    }
  }

  public Attribute top() {
    if(this.isEmpty()) return null;
    return this.get(this.size() -1);
  }

  public void pop() {
    if(!this.isEmpty()) this.remove(this.size() -1);
  }
}