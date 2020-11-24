package com.bucares.barcode.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "nota")
public class Nota {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    @Column
    private float notaFinal;

    public Nota(){}
    public float getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(float notaFinal) {
        this.notaFinal = notaFinal;
    }

    public Long getId() {
        return id;
    }
}
