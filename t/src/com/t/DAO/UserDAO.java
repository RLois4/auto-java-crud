package com.t.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import com.t.model.User;
public class UserDAO {

    private Connection connection;

    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    public void insert(User user) throws SQLException {
        String sql = "INSERT INTO user (name, cd) VALUES (?, ?)";
        try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setObject(1, user.getName());
            pstmt.setObject(2, user.getCd());
            pstmt.executeUpdate();
        }
    }

    public void update(User user) throws SQLException {
        String sql = "UPDATE user SET name = ? WHERE cd = ?";
        try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setObject(1, user.getName());
            pstmt.setObject(2, user.getCd());
            pstmt.executeUpdate();
        }
    }

    public void delete(User user) throws SQLException {
        String sql = "DELETE FROM user WHERE cd = ?";
        try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setObject(1, user.getCd());
            pstmt.executeUpdate();
        }
    }

    public List<User> findAll() throws SQLException {
        List<User> list = new ArrayList<>();
        String sql = "SELECT * FROM user";
        try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                User obj = new User();
                obj.setName(rs.getObject("name"));
                obj.setCd(rs.getObject("cd"));
                list.add(obj);
            }
        }
        return list;
    }

    public User findById(int id) throws SQLException {
        String sql = "SELECT * FROM user WHERE cd = ?";
        try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setObject(1, id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                User obj = new User();
                obj.setName(rs.getObject("name"));
                obj.setCd(rs.getObject("cd"));
                return obj;
            } else {
                return null;
            }
        }
    }
}
