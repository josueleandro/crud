/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.crud.demo.daos;

import com.prueba.crud.demo.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author
 */

@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao{
    
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public List<Usuario> getUsuarios() {
        String sql = "FROM Usuario";
        return em.createQuery(sql).getResultList();
    }
    
    public void eliminar(Long id){
        Usuario usuario =em.find(Usuario.class, id);
        em.remove(usuario);
    }
    
    public void registrar(Usuario usuario){
        //em.persist(usuario);
        em.merge(usuario);
    }
    
    @Override
    public Usuario obtenerUsuarioPorCredenciales(Usuario usuario){
        System.out.println("Llego a consultar el usuario");
        String sql = "FROM Usuario where email = :email";
        try{
            List<Usuario> lista = em.createQuery(sql)
                    .setParameter("email", usuario.getEmail())
                    .getResultList();
            if(lista.isEmpty()){
                return null;
            }

            String passwordHash = lista.get(0).getPassword();
            Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);

            if(argon2.verify(passwordHash, usuario.getPassword())){
                return lista.get(0);
            }
            else{
                return null;
            }
        }
        catch(Exception ex){
            System.out.println("Error en UsuarioDaoImp: " + ex.getMessage());
            return null;
        }
    }
}
