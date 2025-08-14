package com.projetos.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.projetos.model.User;
public class UserDAO {

    private Connection connection;

    public UserDAO(Connection connection) {
        this.connection = connection;    }

    public void insert(User user) throws SQLException {
        String sql = "INSERT INTO user (name, idade, email, a_pagar) VALUES (?, ?, ?, ?)";
        try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setObject(1, user.getName());
            pstmt.setObject(2, user.getIdade());
            pstmt.setObject(3, user.getEmail());
            pstmt.setObject(4, user.getA_pagar());
            pstmt.executeUpdate();
        }
    }

    public void update(User user) throws SQLException {
        String sql = "UPDATE user SET name = ?, idade = ?, email = ?, a_pagar = ? WHERE id = ?";
        try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setObject(1, user.getName());
            pstmt.setObject(2, user.getIdade());
            pstmt.setObject(3, user.getEmail());
            pstmt.executeUpdate();
        }
    }

    public void delete(User user) throws SQLException {
        String sql = "DELETE FROM user WHERE a_pagar = ?";
        try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setObject(1, user.getA_pagar());
            pstmt.executeUpdate();
        }
    }
