package com.bucares.barcode.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "materia")
public class Materia {

    private Long id;
    @Column(name = "m_name")
    private String name;
    private Profesor profesor;

    private List<Avance> avance;

    private PlanEstudio planestudio;

    public Materia(){}
    public String getNombre(){ return this.name; }
    public void setNombre(String name){ this.name = name; }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "m_id")
    public Long getId(){ return this.id; }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "materia", cascade = CascadeType.ALL)
    public List<Avance> getAvances() {
        return avance;
    }

    public void setAvances(List<Avance> avances) {
        this.avance = avances;
    }
    @ManyToOne
    @JoinColumn(name = "profesor_p_id")
    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
    @ManyToOne
    @JoinColumn(name = "planestudio_pl_id")
    public PlanEstudio getPlanestudio() {
        return planestudio;
    }

    public void setPlanestudio(PlanEstudio planestudio) {
        this.planestudio = planestudio;
    }
}
