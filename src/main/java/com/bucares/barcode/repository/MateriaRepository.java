package com.bucares.barcode.repository;

import com.bucares.barcode.model.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

@Repository
@RestResource(exported = false)
public interface MateriaRepository extends JpaRepository<Materia,Long>{
    Materia findByNombre(String nombre);
    Materia findBymateriaId(String id);
}
