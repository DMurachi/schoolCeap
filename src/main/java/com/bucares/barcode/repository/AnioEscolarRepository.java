package com.bucares.barcode.repository;

import com.bucares.barcode.model.AnioEscolar;
import com.bucares.barcode.model.Seccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RepositoryRestResource
public interface AnioEscolarRepository extends JpaRepository<AnioEscolar,Long> {
    Optional<AnioEscolar> findById(Long id);
}
