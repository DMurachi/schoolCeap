package com.bucares.barcode.repository;

import com.bucares.barcode.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProfesorRepository extends JpaRepository<Profesor,Long> {
    Profesor findById(String id);
}
