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
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private String anioId;
    @OneToMany
    private List<Seccion> secciones;
    @OneToMany
    private List<Estudiante> estudiantes;

    public List<Seccion> getSecciones() {
        return secciones;
    }

    public void setSecciones(List<Seccion> secciones) {
        this.secciones = secciones;
    }

    public String getAnioId() {
        return anioId;
    }

    public void setAnioId(String anioId) {
        this.anioId = anioId;
    }
}
