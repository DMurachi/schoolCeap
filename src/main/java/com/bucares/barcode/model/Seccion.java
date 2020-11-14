package com.bucares.barcode.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "seccion")
public class Seccion {
    @OneToOne
    private PlanEstudio planEstudio;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private String seccionId;
    @OneToMany
    private List<Estudiante> estudiantes;

    public String getSeccionId() {
        return seccionId;
    }
    public void setSeccionId(String seccionId) {
        this.seccionId = seccionId;
    }
    public PlanEstudio getPlanEstudio() {
        return this.planEstudio;
    }

    public void setPlanEstudio(PlanEstudio planEstudio) {
        this.planEstudio = planEstudio;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }
}
