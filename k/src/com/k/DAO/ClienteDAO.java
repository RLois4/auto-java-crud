package com.k.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.k.model.Cliente;
public class ClienteDAO {

    private Connection connection;

    public ClienteDAO(Connection connection) {
        this.connection = connection;
    }

    public void insert(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO cliente (nome, email, pk) VALUES (?, ?, ?)";
        try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setObject(1, cliente.getNome());
            pstmt.setObject(2, cliente.getEmail());
            pstmt.setObject(3, cliente.getPk());
            pstmt.executeUpdate();
        }
    }

    public void update(Cliente cliente) throws SQLException {
        String sql = "UPDATE cliente SET nome = ?, email = ? WHERE pk = ?";
        try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setObject(1, cliente.getNome());
            pstmt.setObject(2, cliente.getEmail());
            pstmt.executeUpdate();
        }
    }

    public void delete(Cliente cliente) throws SQLException {
        String sql = "DELETE FROM cliente WHERE pk = ?";
        try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setObject(1, cliente.getPk());
            pstmt.executeUpdate();
        }
    }
