package com.bucares.barcode.repository;

import com.bucares.barcode.model.PlanEstudio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

@Repository
@RestResource(exported = false)
public interface PlanEstudioRepository extends JpaRepository<PlanEstudio,Long> {
    PlanEstudio findById(int id);
}
