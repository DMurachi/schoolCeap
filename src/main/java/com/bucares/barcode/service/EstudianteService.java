package com.bucares.barcode.service;

import com.bucares.barcode.model.Estudiante;
import com.bucares.barcode.model.Product;
import com.bucares.barcode.model.Seccion;
import com.bucares.barcode.repository.EstudianteRepository;
import com.bucares.barcode.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EstudianteService {
    @Autowired
    private EstudianteRepository estudianteRepository;

    public Estudiante storeEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    public List<Estudiante> getAllEstudiantes() {
        return estudianteRepository.findAll();
    }

    public Estudiante getEstudianteByCedula(String cedula) {
        return estudianteRepository.findByCedula(cedula);
    }

    public Estudiante getEstudianteByNombreIdSeccion(String name, String id, String seccion){
        return estudianteRepository.findByNameAndIdAndSeccion(name,id,seccion);
    }
    public List<Estudiante> getEstudianteSeccion(Seccion seccion){ return estudianteRepository.findBySeccion(seccion); }

}
