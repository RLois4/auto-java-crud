package com.projetot.controller;

import java.sql.SQLException;
import java.util.List;
import com.projetot.DAO.UsuarioDAO;
import com.projetot.model.Usuario;


public class UsuarioController {
    private final UsuarioDAO usuarioDAO;

    public void insert(Usuario usuario) {
        try {
            usuarioDAO.insert(usuario);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Usuario usuario) {
        try {
            usuarioDAO.update(usuario);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Usuario usuario) {
        try {
            usuarioDAO.delete(usuario);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Usuario> listAll() {
        try {
            return usuarioDAO.listAll();
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Usuario findById(int codigo) {
        try {
            return usuarioDAO.findById(codigo);
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
