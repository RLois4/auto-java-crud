package com.l.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.l.model.Cl;
public class ClDAO {

    private Connection connection;

    public ClDAO(Connection connection) {
        this.connection = connection;
    }

    public void insert(Cl cl) throws SQLException {
        String sql = "INSERT INTO cl (valor, name, id_teste) VALUES (?, ?, ?)";
        try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setObject(1, cl.getValor());
            pstmt.setObject(2, cl.getName());
            pstmt.setObject(3, cl.getId_teste());
            pstmt.executeUpdate();
        }
    }

    public void update(Cl cl) throws SQLException {
        String sql = "UPDATE cl SET valor = ?, name = ? WHERE id_teste = ?";
        try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setObject(1, cl.getValor());
            pstmt.setObject(2, cl.getName());
            pstmt.executeUpdate();
        }
    }

    public void delete(Cl cl) throws SQLException {
        String sql = "DELETE FROM cl WHERE id_teste = ?";
        try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setObject(1, cl.getId_teste());
            pstmt.executeUpdate();
        }
    }

    public List<Cl> findAll() throws SQLException {
        List<Cl> list = new ArrayList<>();
        String sql = "SELECT * FROM cl";
        try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                Cl obj = new Cl();
                obj.setValor(rs.getObject("valor"));
                obj.setName(rs.getObject("name"));
                obj.setId_teste(rs.getObject("id_teste"));
                list.add(obj);
            }
        }
        return list;
    }

    public Cl findById(int id) throws SQLException {
        String sql = "SELECT * FROM cl WHERE id = ?";
        try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                Cl obj = new Cl();
                obj.setValor(rs.getObject("valor"));
                obj.setName(rs.getObject("name"));
                obj.setId_teste(rs.getObject("id_teste"));
                return obj;
            } else {
                return null;
            }
        }
    }
}
