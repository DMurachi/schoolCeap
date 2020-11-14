package com.bucares.barcode.service;

import com.bucares.barcode.model.Profesor;
import com.bucares.barcode.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProfesorService {
    @Autowired
    private ProfesorRepository userRepository;

    public Profesor storeUser(Profesor user) {
        return userRepository.save(user);
    }

    public List<Profesor> getAllUser() {
        return userRepository.findAll();
    }

    public Profesor getById(String id){ return userRepository.findById(id); }

}
