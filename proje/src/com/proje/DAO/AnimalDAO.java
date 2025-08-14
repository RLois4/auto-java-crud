package com.proje.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.proje.model.AnimalModel;
public class AnimalDAO {

    private Connection connection;

    public AnimalDAO(Connection connection) {
        this.connection = connection;    }

    public void insert(Animal animal) throws SQLException {
        String sql = "INSERT INTO animal (age) VALUES (?)";
        try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.Object(1, animal.getAge());
            pstmt.executeUpdate();
        }
    }

