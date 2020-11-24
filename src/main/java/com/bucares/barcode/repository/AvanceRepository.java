package com.bucares.barcode.repository;

import com.bucares.barcode.model.Avance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RepositoryRestResource
public interface AvanceRepository extends JpaRepository<Avance,Long> {
    Optional<Avance> getAvanceById(Long id);
}
