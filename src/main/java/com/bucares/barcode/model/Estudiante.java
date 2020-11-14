package com.bucares.barcode.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "estudiante")
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true)
    private String id;
    @Column(name = "Cedula", unique = true, nullable = false)
    private String cedula;
    @Column(name = "Nombre", nullable = false)
    private String name;
    @OneToOne
    private Seccion seccion;
    @OneToMany
    private List<Nota> notaEstudiante;
    @ManyToOne
    private AnioEscolar anio;

    public String getId(){ return this.id; }
    public void setId(String id){ this.id=id; }
    public String getCedula(){ return this.cedula; }
    public void setCedula(String cedula){ this.cedula= cedula; }
    public String getName(){ return this.name; }
    public void setName(String name){ this.name = name; }
    public Seccion getSeccion() {
        return this.seccion;
    }
    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }
    public List<Nota> getNotaEstudiante() {
        return notaEstudiante;
    }
    public void setNotaEstudiante(List<Nota> notaEstudiante) {
        this.notaEstudiante = notaEstudiante;
    }
}
