package com.po.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.po.model.People;
public class PeopleDAO {

    private Connection connection;

    public PeopleDAO(Connection connection) {
        this.connection = connection;    }

    public void insert(People people) throws SQLException {
        String sql = "INSERT INTO people (cpf) VALUES (?)";
        try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setObject(1, people.getCpf());
            pstmt.executeUpdate();
        }
    }

