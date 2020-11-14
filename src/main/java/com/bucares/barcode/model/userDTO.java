package com.bucares.barcode.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

public class userDTO {
    private String studentName;
    private int studentId;
    private List<Materia> materiaAsignada;
    private int materiaId;
    private List<Seccion> seccionAsignada;
    public userDTO(){}
    public String getStudentName(){
        return this.studentName;
    }
    public void setStudentName(String studentname){
        this.studentName = studentname;
    }
    public int getStudentId(){ return this.studentId; }
    public void setStudentId(int studentid){
        this.studentId = studentid;
    }
    public List<Materia> getMateriaAsignada(){ return this.materiaAsignada; }
    public void setMateriaAsignada(List<Materia> materias) {
        this.materiaAsignada = materias;
    }
    public List<Seccion> getSeccionAsignada(){
        return this.seccionAsignada;
    }
    public void setSeccionAsignada(List<Seccion> seccions){
        this.seccionAsignada = seccions;
    }
    public int getMateriaId(){
        return this.materiaId;
    }
    public void setMateriaId(int id){
        this.materiaId = id;
    }
}
