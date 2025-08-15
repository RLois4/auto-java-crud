package com.projetot.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import com.projetot.model.Livro;


public class LivroDAO {

    private Connection connection;

    public LivroDAO(Connection connection) {
        this.connection = connection;
    }

    public void insert(Livro livro) throws SQLException {
        String sql = "INSERT INTO livro (title, isbn) VALUES (?, ?)";
        try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setObject(1, livro.getTitle());
            pstmt.setObject(2, livro.getIsbn());
            pstmt.executeUpdate();
        }
    }

    public void update(Livro livro) throws SQLException {
        String sql = "UPDATE livro SET title = ? WHERE isbn = ?";
        try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setObject(1, livro.getTitle());
            pstmt.setObject(2, livro.getIsbn());
            pstmt.executeUpdate();
        }
    }

    public void delete(Livro livro) throws SQLException {
        String sql = "DELETE FROM livro WHERE isbn = ?";
        try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setObject(1, livro.getIsbn());
            pstmt.executeUpdate();
        }
    }

    public List<Livro> listAll() throws SQLException {
        List<Livro> list = new ArrayList<>();
        String sql = "SELECT * FROM livro";
        try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                Livro obj = new Livro();
                obj.setTitle(rs.getObject("title"));
                obj.setIsbn(rs.getObject("isbn"));
                list.add(obj);
            }
        }
        return list;
    }

    public Livro findById(int id) throws SQLException {
        String sql = "SELECT * FROM livro WHERE isbn = ?";
        try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setObject(1, id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                Livro obj = new Livro();
                obj.setTitle(rs.getObject("title"));
                obj.setIsbn(rs.getObject("isbn"));
                return obj;
            } else {
                return null;
            }
        }
    }
}
