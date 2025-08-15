package com.projetot.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import com.projetot.model.Usuario;


public class UsuarioDAO {

    private Connection connection;

    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }

    public void insert(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuario (name, email, cpf, dinheiro, codigo) VALUES (?, ?, ?, ?, ?)";
        try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setObject(1, usuario.getName());
            pstmt.setObject(2, usuario.getEmail());
            pstmt.setObject(3, usuario.getCpf());
            pstmt.setObject(4, usuario.getDinheiro());
            pstmt.setObject(5, usuario.getCodigo());
            pstmt.executeUpdate();
        }
    }

    public void update(Usuario usuario) throws SQLException {
        String sql = "UPDATE usuario SET name = ?, email = ?, cpf = ?, dinheiro = ? WHERE codigo = ?";
        try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setObject(1, usuario.getName());
            pstmt.setObject(2, usuario.getEmail());
            pstmt.setObject(3, usuario.getCpf());
            pstmt.setObject(4, usuario.getDinheiro());
            pstmt.setObject(5, usuario.getCodigo());
            pstmt.executeUpdate();
        }
    }

    public void delete(Usuario usuario) throws SQLException {
        String sql = "DELETE FROM usuario WHERE codigo = ?";
        try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setObject(1, usuario.getCodigo());
            pstmt.executeUpdate();
        }
    }

    public List<Usuario> listAll() throws SQLException {
        List<Usuario> list = new ArrayList<>();
        String sql = "SELECT * FROM usuario";
        try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                Usuario obj = new Usuario();
                obj.setName(rs.getObject("name"));
                obj.setEmail(rs.getObject("email"));
                obj.setCpf(rs.getObject("cpf"));
                obj.setDinheiro(rs.getObject("dinheiro"));
                obj.setCodigo(rs.getObject("codigo"));
                list.add(obj);
            }
        }
        return list;
    }

    public Usuario findById(int id) throws SQLException {
        String sql = "SELECT * FROM usuario WHERE codigo = ?";
        try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setObject(1, id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                Usuario obj = new Usuario();
                obj.setName(rs.getObject("name"));
                obj.setEmail(rs.getObject("email"));
                obj.setCpf(rs.getObject("cpf"));
                obj.setDinheiro(rs.getObject("dinheiro"));
                obj.setCodigo(rs.getObject("codigo"));
                return obj;
            } else {
                return null;
            }
        }
    }
}
