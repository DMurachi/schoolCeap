package com.bucares.barcode.service;

import com.bucares.barcode.model.Avance;
import com.bucares.barcode.repository.AvanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvanceService {
    @Autowired
    private AvanceRepository avanceRepository;

    public Avance storeAvance(Avance avance) {
        return avanceRepository.save(avance);
    }

    public List<Avance> getAllAvances() {
        return avanceRepository.findAll();
    }

    public Optional<Avance> getAvanceById(Long Id) {
        return avanceRepository.getAvanceById(Id);
    }

    public Avance getOneAvance(Long id){ return avanceRepository.getOne(id); }

    public void deleteAvanceById(Long id) { avanceRepository.deleteById(id);
    }

    public void deleteAllAvance() { avanceRepository.deleteAll();
    }
}
