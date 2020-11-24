package com.bucares.barcode.model;

import javax.persistence.*;

@Entity
@Table(name = "avance")
public class Avance {
    private Long id;
    @Column(name = "a_notaavance")
    private float notaAvance;
    private Materia materia;

    public Avance(){ }

    public float getNotaAvance() {
        return notaAvance;
    }

    public void setNotaAvance(float notaAvance) {
        this.notaAvance = notaAvance;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "a_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "materia_m_id")
    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }
}
