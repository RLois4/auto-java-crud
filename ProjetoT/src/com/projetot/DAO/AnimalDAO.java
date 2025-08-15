package com.projetot.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import com.projetot.model.Animal;


public class AnimalDAO {

    private Connection connection;

    public AnimalDAO(Connection connection) {
        this.connection = connection;
    }

    public void insert(Animal animal) throws SQLException {
        String sql = "INSERT INTO animal (raca, name, age, codigo_animal) VALUES (?, ?, ?, ?)";
        try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setObject(1, animal.getRaca());
            pstmt.setObject(2, animal.getName());
            pstmt.setObject(3, animal.getAge());
            pstmt.setObject(4, animal.getCodigo_animal());
            pstmt.executeUpdate();
        }
    }

    public void update(Animal animal) throws SQLException {
        String sql = "UPDATE animal SET raca = ?, name = ?, age = ? WHERE codigo_animal = ?";
        try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setObject(1, animal.getRaca());
            pstmt.setObject(2, animal.getName());
            pstmt.setObject(3, animal.getAge());
            pstmt.setObject(4, animal.getCodigo_animal());
            pstmt.executeUpdate();
        }
    }

    public void delete(Animal animal) throws SQLException {
        String sql = "DELETE FROM animal WHERE codigo_animal = ?";
        try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setObject(1, animal.getCodigo_animal());
            pstmt.executeUpdate();
        }
    }

    public List<Animal> listAll() throws SQLException {
        List<Animal> list = new ArrayList<>();
        String sql = "SELECT * FROM animal";
        try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                Animal obj = new Animal();
                obj.setRaca(rs.getObject("raca"));
                obj.setName(rs.getObject("name"));
                obj.setAge(rs.getObject("age"));
                obj.setCodigo_animal(rs.getObject("codigo_animal"));
                list.add(obj);
            }
        }
        return list;
    }

    public Animal findById(int id) throws SQLException {
        String sql = "SELECT * FROM animal WHERE codigo_animal = ?";
        try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setObject(1, id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                Animal obj = new Animal();
                obj.setRaca(rs.getObject("raca"));
                obj.setName(rs.getObject("name"));
                obj.setAge(rs.getObject("age"));
                obj.setCodigo_animal(rs.getObject("codigo_animal"));
                return obj;
            } else {
                return null;
            }
        }
    }
}
