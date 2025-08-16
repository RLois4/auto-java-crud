package com.application;

public class Argument {
  private final String name;
  private final String type;

  public Argument(String type, String name) {
    this.type = type;
    this.name = name;
  }

  public Argument(String typename) {
    String[] strSplit = typename.split(" ");
    if(strSplit.length != 2 || strSplit[0].isBlank() || strSplit[1].isBlank()) throw new IllegalArgumentException("Invalid: argument");
    type = strSplit[0];
    name = strSplit[1];
  }

  public getArg
}
