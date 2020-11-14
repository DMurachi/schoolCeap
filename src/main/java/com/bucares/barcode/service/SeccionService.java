package com.bucares.barcode.service;

import com.bucares.barcode.model.Estudiante;
import com.bucares.barcode.model.PlanEstudio;
import com.bucares.barcode.model.Product;
import com.bucares.barcode.model.Seccion;
import com.bucares.barcode.repository.SeccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SeccionService {
    @Autowired
    private SeccionRepository seccionRepository;

    public Seccion storeSeccion(Seccion seccion) {
        return seccionRepository.save(seccion);
    }

    public List<Seccion> getAllSeccion() {
        return seccionRepository.findAll();
    }

    public Seccion getSeccionById(String id) {
        return seccionRepository.findByseccionId(id);
    }
    public PlanEstudio getPlanEstudio(){ return getPlanEstudio(); }

}
