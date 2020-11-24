package com.bucares.barcode.service;

import com.bucares.barcode.model.PlanEstudio;
import com.bucares.barcode.model.Seccion;
import com.bucares.barcode.repository.SeccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Seccion> getSeccionById(Long id) {
        return seccionRepository.findById(id);
    }
    public PlanEstudio getPlanEstudio(){ return getPlanEstudio(); }
    public void deleteSeccionById(Long id){ seccionRepository.deleteById(id); }
    public void deleteAllSeccion(){ seccionRepository.deleteAll(); }

}
