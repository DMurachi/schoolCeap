package com.bucares.barcode.service;

import com.bucares.barcode.model.AnioEscolar;
import com.bucares.barcode.model.Product;
import com.bucares.barcode.repository.AnioEscolarRepository;
import com.bucares.barcode.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnioEscolarService {
    @Autowired
    private AnioEscolarRepository anioEscolarRepository;
    public AnioEscolar storeAnioEscolar(AnioEscolar anioEscolar) {
        return anioEscolarRepository.save(anioEscolar);
    }
    public List<AnioEscolar> getAllAnioEscolar() {
        return anioEscolarRepository.findAll();
    }
    public AnioEscolar getById(String id) {
        return anioEscolarRepository.findByanioId(id);
    }
}
