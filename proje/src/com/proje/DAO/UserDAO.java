package com.proje.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.proje.model.UserModel;
public class UserDAO {

    private Connection connection;

    public UserDAO(Connection connection) {
        this.connection = connection;    }

    public void insert(User user) throws SQLException {
        String sql = "INSERT INTO user (id, name) VALUES (?, ?)";
        try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.Object(1, user.getId());
            pstmt.Object(2, user.getName());
            pstmt.executeUpdate();
        }
    }

