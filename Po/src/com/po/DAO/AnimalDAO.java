package com.po.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.po.model.Animal;
public class AnimalDAO {

    private Connection connection;

    public AnimalDAO(Connection connection) {
        this.connection = connection;    }

    public void insert(Animal animal) throws SQLException {
        String sql = "INSERT INTO animal (age, raca) VALUES (?, ?)";
        try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setObject(1, animal.getAge());
            pstmt.setObject(2, animal.getRaca());
            pstmt.executeUpdate();
        }
    }

