package com.bucares.barcode.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "anioEscolar")
public class AnioEscolar {
    private Long id;
    private List<Seccion> seccion;
    private List<Estudiante> estudiante;

    public AnioEscolar(){ }

    @OneToMany(mappedBy = "anioescolar", cascade = CascadeType.ALL)
    public List<Seccion> getSecciones() {
        return seccion;
    }

    public void setSecciones(List<Seccion> secciones) {
        this.seccion = secciones;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ae_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "anioescolar", cascade = CascadeType.ALL)
    public List<Estudiante> getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(List<Estudiante> estudiante) {
        this.estudiante = estudiante;
    }
}
