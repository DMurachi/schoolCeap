package com.bucares.barcode.repository;

import com.bucares.barcode.model.Estudiante;
import com.bucares.barcode.model.Seccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RestResource(exported = false)
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
    Estudiante findByCedula(String cedula);
    Estudiante findByNameAndIdAndSeccion(String name, String id, String seccion);
    List<Estudiante> findBySeccion(Seccion seccion);
}
