package com.proj.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

static {
    try {
        Class.forName("com.mysql.cj.jdbc.DriverTeste");
    catch(ClassNotFoundException e) {
        e.printStackTrace();
        System.exit(1);
    }
}

public class DBConnetion {
    private static final String USER = "root";
    private static final String PASS = "root";
    private static final String URL = "jdbc:mysql://localhost:3306/testDB/";

   public static Connection getConnection() throws SQLException {
       return DriverManager.getConnection(URL, USER, PASSWORD);
   }
