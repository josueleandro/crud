/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.crud.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Owner
 */
@Entity
@Table(name = "usuarios")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name="id")
    private Long id;
    
    @Getter @Setter @Column(name="nombre")
    private String nombre;
    
    @Getter @Setter @Column(name="apellido")
    private String apellido;
    
    @Getter @Setter @Column(name="email")
    private String email;
    
    @Getter @Setter @Column(name="telefono")
    private String telefono;
    
    @Getter @Setter @Column(name="password")
    private String password;

}
