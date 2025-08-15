package com.projetot.controller;

import java.sql.SQLException;
import java.util.List;
import com.projetot.DAO.LivroDAO;
import com.projetot.model.Livro;


public class LivroController {
    private final LivroDAO livroDAO;

    public void insert(Livro livro) {
        try {
            livroDAO.insert(livro);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Livro livro) {
        try {
            livroDAO.update(livro);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Livro livro) {
        try {
            livroDAO.delete(livro);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Livro> listAll() {
        try {
            return livroDAO.listAll();
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Livro findById(String isbn) {
        try {
            return livroDAO.findById(isbn);
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
