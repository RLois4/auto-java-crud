package com.application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import com.application.NameFormatter;


public class Writer {
    
  private final static String lb = System.lineSeparator();

  public void writePackage(String path, String classPackage) throws IOException {
    try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
      StringBuilder sb = new StringBuilder();
      sb.append("package " + classPackage + ";" + lb);
      bw.write(sb.toString());
    }
  }

  public void writeImport(String path, String[] toImport, String tabValue, int identationLevel) throws IOException {
    if(identationLevel < 0) {
      System.err.println("Error: writeImport(): identation level cannot be negative.");
      return;
    }
    if(!tabValue.isBlank()) {
      System.err.println("Warning: the identation String have not common characters.");
    }
    try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
      StringBuilder sb = new StringBuilder();
      for(String packageToImport: toImport) {
        for(int i = 0; i < identationLevel; i++) sb.append(tabValue);
        sb.append("import " + packageToImport + ";" + lb);
        bw.write(sb.toString());
      }
    }
  }


  public static void main(String[] args) {
    Writer wr = new Writer();
    try {
      String[] toImport = {};
      wr.writeImport("./a.txt", toImport, "  ", 1);
    } catch(IOException e) {
      e.printStackTrace();
    }
  }
}
