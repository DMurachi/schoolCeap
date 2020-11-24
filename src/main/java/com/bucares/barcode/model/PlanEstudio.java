package com.bucares.barcode.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "planestudio")
public class PlanEstudio {

    private List<Materia> materia;

    private Long id;

    private Seccion seccion;

    public PlanEstudio(){}
    @OneToMany(mappedBy = "planestudio", cascade = CascadeType.ALL)
    public List<Materia> getMaterias(){
        return this.materia;
    }
    public void setMaterias(List<Materia> mats){
        this.materia = mats;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pl_id")
    public Long getId(){ return this.id; }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "seccion_s_id", referencedColumnName = "s_id")
    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }
}
