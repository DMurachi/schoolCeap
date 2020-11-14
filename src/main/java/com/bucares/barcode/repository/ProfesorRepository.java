package com.bucares.barcode.repository;

import com.bucares.barcode.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository<Profesor,Long> {
    Profesor findById(String id);
}
