package com.bucares.barcode.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Table(name = "materia")
public class Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true)
    private String materiaId;
    @Column(name="nombreMateria")
    private String nombre;

    public Materia(String nombre, String id) {
        this.nombre = nombre;
        this.materiaId = id;
    }
    public String getNombre(){ return this.nombre; }
    public void setNombre(String nombre){ this.nombre = nombre; }
    public String getId(){ return this.materiaId; }
    public void setId(String materiaId){ this.materiaId = materiaId; }

}
