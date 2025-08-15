package com.projetot.controller;

import java.sql.SQLException;
import java.util.List;
import com.projetot.DAO.AnimalDAO;
import com.projetot.model.Animal;


public class AnimalController {
    private final AnimalDAO animalDAO;

    public void insert(Animal animal) {
        try {
            animalDAO.insert(animal);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Animal animal) {
        try {
            animalDAO.update(animal);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Animal animal) {
        try {
            animalDAO.delete(animal);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Animal> listAll() {
        try {
            return animalDAO.listAll();
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Animal findById(String codigo_animal) {
        try {
            return animalDAO.findById(codigo_animal);
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
