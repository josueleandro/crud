/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.crud.demo.models;

import java.util.Date;
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
@Table(name = "tareas")
public class Tarea {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name="id")
    private Long id;
    
    @Getter @Setter @Column(name="descripcion")
    private String descripcion;
    
    @Getter @Setter @Column(name="estado")
    private Boolean estado;
    
    @Getter @Setter @Column(name="fechaInicio")
    private Date fechaInicio;
    
    @Getter @Setter @Column(name="fechaFin")
    private Date fechaFin;
    
    
}
