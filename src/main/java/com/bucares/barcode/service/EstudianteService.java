package com.bucares.barcode.service;

import com.bucares.barcode.model.Estudiante;
import com.bucares.barcode.model.Seccion;
import com.bucares.barcode.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<Estudiante> getEstudianteById(Long id){ return estudianteRepository.findById(id); }

    public Estudiante getEstudianteByNombreIdSeccion(String name, Long id, String seccion){
        return estudianteRepository.findByNameAndIdAndSeccion(name,id,seccion);
    }
    public List<Estudiante> getEstudianteSeccion(Seccion seccion){ return estudianteRepository.findBySeccion(seccion); }

    public void deleteEstudianteById(Long id) { estudianteRepository.deleteById(id);
    }

    public void deleteAllSeccion() { estudianteRepository.deleteAll();
    }
}
