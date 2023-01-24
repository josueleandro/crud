/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.crud.demo.controllers;

import com.prueba.crud.demo.daos.UsuarioDao;
import com.prueba.crud.demo.models.Usuario;
import com.prueba.crud.demo.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController{
    @Autowired
    private UsuarioDao usuarioDao;
    
    @Autowired
    private JWTUtil jwtUtil;
    
    @RequestMapping(value="api/login", method = RequestMethod.POST)
    public String login(@RequestBody Usuario usuario){
        Usuario usuarioLogueado = usuarioDao.obtenerUsuarioPorCredenciales(usuario);
        if(usuarioLogueado != null){
            System.out.println("Datos: " + usuarioLogueado.getEmail() + " - " + usuarioLogueado.getPassword());
            String token = jwtUtil.create(String.valueOf(usuarioLogueado.getId()), usuarioLogueado.getEmail());
            return token;
        }
        else{
            System.out.println("No se encontraron datos del usuario");
            return "FAIL";
        }
    }
}
