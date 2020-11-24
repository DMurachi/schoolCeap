package com.bucares.barcode.service;

import com.bucares.barcode.model.AnioEscolar;
import com.bucares.barcode.repository.AnioEscolarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<AnioEscolar> getById(Long id) {
        return anioEscolarRepository.findById(id);
    }

    public void deleteAnioEscolarById(Long idAe) { anioEscolarRepository.deleteById(idAe);
    }

    public void deleteAllAnioEscolar() { anioEscolarRepository.deleteAll();
    }
}
