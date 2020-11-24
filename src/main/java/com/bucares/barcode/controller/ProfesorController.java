package com.bucares.barcode.controller;

import com.bucares.barcode.model.*;
import com.bucares.barcode.service.*;
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
import java.util.Optional;

@RestController
@RequestMapping("/profesor")
public class ProfesorController {
    @Autowired
    private EstudianteService estudianteService;
    @Autowired
    private MateriaService materiaService;
    @Autowired
    private SeccionService seccionService;
    @Autowired
    private AvanceService avanceService;
    @Autowired
    private ProfesorService profesorService;

    private static final Logger logger = LoggerFactory.getLogger(ProfesorController.class);

    @RequestMapping(value = "/seccion", method = RequestMethod.GET)
    public ResponseEntity<Response<List<Seccion>>> getAllSeccionAsignada(String id){
        logger.info("Called resource: getAllSeccionAsignada");
        Profesor profesorAux = profesorService.getById(id);
        List<Seccion> seccionAux = profesorAux.getSeccion();
        Response<List<Seccion>> response = new Response<>("0000", seccionAux, null);
        logger.info("Consulted: list of seccion thru userdto in database");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @RequestMapping(value = "/seccion/{idSeccion}", method = RequestMethod.GET)
    public ResponseEntity<Response<Optional<Seccion>>> getSeccionAsignada(@PathVariable("idSeccion") Long idS){
        logger.info("Called resource: getSeccionASignada");
        Optional<Seccion> seccionAux = seccionService.getSeccionById(idS);
        Response<Optional<Seccion>> response = new Response<>("0000", seccionAux, null);
        logger.info("Consulted: Seccion Asignada from profesor");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @RequestMapping(value = "/materia", method = RequestMethod.GET)
    public ResponseEntity<Response<List<Materia>>> getMaterias(String id){
        logger.info("called resource: getMaterias");
        List<Materia> materiaAux = profesorService.getById(id).getMateria();
        Response<List<Materia>> response = new Response<>("0000", materiaAux, null);
        logger.info("Consulted: List de Materias del profe");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @RequestMapping(value = "/materia/{idMateria}", method = RequestMethod.GET)
    public ResponseEntity<Response<Optional<Materia>>> getMateriaAsignada(@PathVariable("idMateria")Long idM){
        logger.info("called resource: getMateriaASignada");
        Optional<Materia> materiaAux = materiaService.getMateriaById(idM);
        Response<Optional<Materia>> response = new Response<>("0000", materiaAux, null);
        logger.info("Consulted: Materia Asignada from profesor");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @RequestMapping(value = "/seccion/{idSeccion}/estudiantes", method = RequestMethod.GET)
    public ResponseEntity<Response<List<Estudiante>>> getEstudiantes(@PathVariable("idSeccion") Long idS){
        logger.info("called resource: getEstudiantes");
        Optional<Seccion> seccionAux = seccionService.getSeccionById(idS);
        List<Estudiante> estudiantes = seccionAux.get().getEstudiantes();
        Response<List<Estudiante>> response = new Response<>("0000", estudiantes, null);
        logger.info("Consulted: Materia Asignada from profesor");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @RequestMapping(value = "/materia/{idMateria}/avance", method = RequestMethod.GET)
    public ResponseEntity<Response<List<Avance>>> getAvance(@PathVariable("idMateria")Long idM){
        logger.info("called resource: getAvances");
        List<Avance> avanceAux = materiaService.getMateriaById(idM).get().getAvances();
        Response<List<Avance>> response = new Response<>("0000", avanceAux, null);
        logger.info("Consulted: Materia Asignada from profesor");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
   /* @RequestMapping(value = "/seccion/{idSeccion}/materia/{idMateria}/estudiante/{idE}/avance", method = RequestMethod.GET)
    public ResponseEntity<Response<List<Avance>>> actualizarNota(@PathVariable("idSeccion") Long idS, @PathVariable("idMateria") Long idM,
                                                              @PathVariable("idE") Long idE, Avance avance)
    {
        List<Estudiante> estudiantes = estudianteService.getEstudianteSeccion(seccionService.getSeccionById(idS));
        List<Materia> materias = estudianteService.getOneEstudiante(idE).getSeccion().getPlanEstudio().getMaterias();
        List<Avance> avances = materiaService.getMateriaById(idM).getAvances();
        Response<List<Avance>> response = new Response<>("0000", avances , null);
        logger.info("Consulted: Materia Asignada from profesor");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }*/

}
