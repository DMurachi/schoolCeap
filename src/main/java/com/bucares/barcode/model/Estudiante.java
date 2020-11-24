package com.bucares.barcode.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
public class Estudiante {
    private Long id;
    @Column(name = "e_cedula",length = 11)
    private String cedula;
    @Column(name = "e_name",length = 16)
    private String name;
    private Seccion seccion;
    private AnioEscolar anioescolar;
    @Column(name = "e_promedio")
    private float promedio;

    public Estudiante(){}
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId(){ return this.id; }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCedula(){ return this.cedula; }
    public void setCedula(String cedula){ this.cedula= cedula; }
    public String getName(){ return this.name; }
    public void setName(String name){ this.name = name; }
    @ManyToOne
    @JoinColumn(name = "seccion_s_id")
    public Seccion getSeccion() {
        return this.seccion;
    }
    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }
    @ManyToOne
    @JoinColumn(name = "anioescolar_ae_id")
    public AnioEscolar getAnioescolar() {
        return anioescolar;
    }
    public void setAnioescolar(AnioEscolar anioescolar) {
        this.anioescolar = anioescolar;
    }
}
