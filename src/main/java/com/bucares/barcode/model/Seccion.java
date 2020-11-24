package com.bucares.barcode.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "seccion")
public class Seccion {

    private PlanEstudio planestudio;
    private AnioEscolar anioescolar;
    private Long id;
    private List<Estudiante> estudiante;
    private List<Profesor> profesor;
//PRUEBA METIENDO LOS IDS EN EL GET LOS MANYTOMANY NECESITAN JOINTABLES USA EL DE LA PAGINA
    //PRUEBA PONIENDO LAS RELACIONES EN LOS GETS Y NO EN LAS DECLARACIONES.
    public Seccion(){}
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "s_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToOne(mappedBy = "seccion")
    public PlanEstudio getPlanEstudio() {
        return this.planestudio;
    }

    public void setPlanEstudio(PlanEstudio planEstudio) {
        this.planestudio = planEstudio;
    }
    @OneToMany(mappedBy = "seccion", cascade = CascadeType.ALL)
    public List<Estudiante> getEstudiantes() {
        return estudiante;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiante = estudiantes;
    }
    @ManyToOne
    @JoinColumn(name = "anioescolar_ae_id")
    public AnioEscolar getAnioescolar() {
        return anioescolar;
    }

    public void setAnioescolar(AnioEscolar anioescolar) {
        this.anioescolar = anioescolar;
    }
    @ManyToMany(mappedBy = "seccion")
    public List<Profesor> getProfesor() {
        return profesor;
    }

    public void setProfesor(List<Profesor> profesor) {
        this.profesor = profesor;
    }
}
