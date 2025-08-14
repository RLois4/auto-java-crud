package com.proje.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.proje.model.PeopleModel;
public class PeopleDAO {

    private Connection connection;

    public PeopleDAO(Connection connection) {
        this.connection = connection;    }

    public void insert(People people) throws SQLException {
        String sql = "INSERT INTO people (id) VALUES (?)";
        try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.Object(1, people.getId());
            pstmt.executeUpdate();
        }
    }

