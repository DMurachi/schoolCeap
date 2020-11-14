package com.bucares.barcode.service;

import com.bucares.barcode.model.Materia;
import com.bucares.barcode.model.Product;
import com.bucares.barcode.repository.MateriaRepository;
import com.bucares.barcode.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MateriaService {
    @Autowired
    private MateriaRepository materiaRepository;

    public Materia storeMateria(Materia materia) {
        return materiaRepository.save(materia);
    }

    public List<Materia> getAllMaterias() {
        return materiaRepository.findAll();
    }

    public Materia getMateriaByNombre(String nombre) {
        return materiaRepository.findByNombre(nombre);
    }

    public Materia getMateriaById(String id){ return materiaRepository.findBymateriaId(id); }
}
