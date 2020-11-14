package com.bucares.barcode.model;

import javax.persistence.*;
@Entity
@Table(name = "nota")
public class Nota {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private String estudianteId;
    @Column
    private String materiaId;
    @Column
    private float nota;
    @ManyToOne
    @JoinColumn(name = "notaEstudiante")
    private Estudiante estudiante;

    public Nota(){}
    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public String getEstudianteId() {
        return estudianteId;
    }

    public String getMateriaId() {
        return materiaId;
    }

    public void setEstudianteId(String estudianteId) {
        this.estudianteId = estudianteId;
    }

    public void setMateriaId(String materiaId) {
        this.materiaId = materiaId;
    }
}
