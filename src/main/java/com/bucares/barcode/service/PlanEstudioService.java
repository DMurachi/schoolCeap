package com.bucares.barcode.service;

import com.bucares.barcode.model.PlanEstudio;
import com.bucares.barcode.model.Product;
import com.bucares.barcode.repository.PlanEstudioRepository;
import com.bucares.barcode.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanEstudioService {
    @Autowired
    private PlanEstudioRepository planEstudioRepository;

    public PlanEstudio storePlanEstudio(PlanEstudio planEstudio) {
        return planEstudioRepository.save(planEstudio);
    }

    public List<PlanEstudio> getAllPlanEstudio() {
        return planEstudioRepository.findAll();
    }

    public PlanEstudio getPlanEstudioById(int id) {
        return planEstudioRepository.findById(id);
    }
}
