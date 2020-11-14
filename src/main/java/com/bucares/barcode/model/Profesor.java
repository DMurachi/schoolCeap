package com.bucares.barcode.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private String id;

    private String name;
    @OneToMany
    private List<Seccion> seccionAsignada;
    @OneToMany
    private List<Materia> materiaAsignada;

    public Profesor(){}
    public Profesor(String password, String name, List<Seccion> seccionAsignada, String username,
                    List<Materia> materiaAsignada){
        this.name = name;
        this.seccionAsignada = seccionAsignada;
        this.materiaAsignada = materiaAsignada;
    }
    public String getUserID(){ return this.id; }
    public void setUserID(String userid){ this.id = userid; }
    public String getName(){return this.name; }
    public void setName(String name){ this.name = name; }
    public List<Seccion> getSeccionAsignada(){ return this.seccionAsignada; }
    public void setSeccionAsignada(List<Seccion> seccionAsignada){
        this.seccionAsignada = seccionAsignada;
    }
    public List<Materia> getMateriaAsignada(){ return this.materiaAsignada; }
    public void setMateriaAsignada(List<Materia> materiaAsignada){
        this.materiaAsignada = materiaAsignada;
    }
}
