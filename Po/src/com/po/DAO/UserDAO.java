package com.po.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.po.model.User;
public class UserDAO {

    private Connection connection;

    public UserDAO(Connection connection) {
        this.connection = connection;    }

    public void insert(User user) throws SQLException {
        String sql = "INSERT INTO user (id, name, grana) VALUES (?, ?, ?)";
        try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setObject(1, user.getId());
            pstmt.setObject(2, user.getName());
            pstmt.setObject(3, user.getGrana());
            pstmt.executeUpdate();
        }
    }

