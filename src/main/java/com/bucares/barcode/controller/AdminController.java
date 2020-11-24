package com.bucares.barcode.controller;

import com.bucares.barcode.model.*;
import com.bucares.barcode.service.EstudianteService;
import com.bucares.barcode.service.MateriaService;
import com.bucares.barcode.utilities.DTOUtils;
import com.bucares.barcode.utilities.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private EstudianteService estudianteService;
    @Autowired
    private MateriaService materiaService;
    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
    @GetMapping
    @ResponseBody
    public ResponseEntity<Response<List<Estudiante>>> getAllStudent(){
        List<Estudiante> estudiante = estudianteService.getAllEstudiantes();
        Response<List<Estudiante>> response = new Response<>("0000",estudiante,null);
        logger.info("Called resource: getAllStudent");
        logger.info("Consulted: every studentDTO in database");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
