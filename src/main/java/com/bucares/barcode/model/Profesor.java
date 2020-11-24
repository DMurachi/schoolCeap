package com.bucares.barcode.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "profesor")
public class Profesor {
    private Long id;
    @Column(name = "p_name")
    private String name;
    private List<Seccion> seccion;
    private List<Materia> materia;

    public Profesor(){}
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "p_id")
    public Long getId(){ return this.id; }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName(){return this.name; }
    public void setName(String name){ this.name = name; }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "profesor_seccion", joinColumns = @JoinColumn(name = "profesor_p_id", referencedColumnName = "p_id"),
            inverseJoinColumns = @JoinColumn(name = "seccion_s_id", referencedColumnName = "s_id"))
    public List<Seccion> getSeccion(){ return this.seccion; }
    public void setSeccion(List<Seccion> seccionAsignada){
        this.seccion = seccionAsignada;
    }

    @OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL)
    public List<Materia> getMateria(){ return this.materia; }
    public void setMateria(List<Materia> materiaAsignada){
        this.materia = materiaAsignada;
    }
}
