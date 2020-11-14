package com.bucares.barcode.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "planestudio")
public class PlanEstudio {
    @OneToMany
    private List<Materia> materias;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "planID")
    private int id;

    public List<Materia> getMaterias(){
        return this.materias;
    }
    public void setMaterias(List<Materia> mats){
        this.materias = mats;
    }
    public int getId(){ return this.id; }
    public void setId(int planId){ this.id = planId; }
}
