package com.bucares.barcode.service;

import com.bucares.barcode.model.Estudiante;
import com.bucares.barcode.model.Nota;
import com.bucares.barcode.model.Seccion;
import com.bucares.barcode.repository.EstudianteRepository;
import com.bucares.barcode.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NotaService {
    @Autowired
    private NotaRepository notaRepository;

    public Nota storeNota(Nota nota) {
        return notaRepository.save(nota);
    }
    public List<Nota> getAllNotas() {
        return notaRepository.findAll();
    }
    public Nota getNotaById(Long id){
        return notaRepository.getNotaById(id);
    }
}
