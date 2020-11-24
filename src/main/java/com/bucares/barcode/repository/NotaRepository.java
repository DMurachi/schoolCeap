package com.bucares.barcode.repository;

import com.bucares.barcode.model.Materia;
import com.bucares.barcode.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface NotaRepository extends JpaRepository<Nota,Long> {
    Nota getNotaById(Long id);
}
