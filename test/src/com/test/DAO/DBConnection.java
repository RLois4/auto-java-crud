package com.test.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

static {
    try {
        Class.forName("naosei.com.mysql");
    catch(ClassNotFoundException e) {
        e.printStackTrace();
        System.exit(1);
    }
}

public class DBConnetion {
    private static final String USER = "reta";
    private static final String PASS = "kao";
    private static final String URL = "jdbc:mariadb://0.0.0.0:1002/testandoODB/";

   public static Connection getConnection() throws SQLException {
       return DriverManager.getConnection(URL, USER, PASSWORD);
   }
