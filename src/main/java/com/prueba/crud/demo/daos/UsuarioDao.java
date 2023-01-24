/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.crud.demo.daos;

import com.prueba.crud.demo.models.Usuario;
import java.util.List;

/**
 *
 * @author Owner
 */
public interface UsuarioDao {
    List<Usuario> getUsuarios();
    void eliminar(Long id);
    void registrar(Usuario usuario);
    Usuario obtenerUsuarioPorCredenciales(Usuario usuario);
}
