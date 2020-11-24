package com.bucares.barcode.repository;

import com.bucares.barcode.model.Estudiante;
import com.bucares.barcode.model.Seccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
    Estudiante findByNameAndIdAndSeccion(String name, Long id, String seccion);
    List<Estudiante> findBySeccion(Seccion seccion);
}
