package com.bucares.barcode.controller;

import com.bucares.barcode.model.Estudiante;
import com.bucares.barcode.model.Seccion;
import com.bucares.barcode.service.EstudianteService;
import com.bucares.barcode.utilities.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estudiante")
public class EstudianteController {
     @Autowired
     EstudianteService estudianteService;

    private static final Logger logger = LoggerFactory.getLogger(EstudianteController.class);

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Estudiante>> getAllEstudiantes(){
        try{
            List<Estudiante> estudiantes = new ArrayList<Estudiante>();
            estudianteService.getAllEstudiantes().forEach(estudiantes::add);
            if(estudiantes.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(estudiantes, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(value = "/{idEstudiante}", method = RequestMethod.GET)
    public ResponseEntity<Estudiante> getEstudiante(@PathVariable("idEstudiante") Long idE){
        Optional<Estudiante> estudianteData = estudianteService.getEstudianteById(idE);
        if(estudianteData.isPresent()){
            return new ResponseEntity<>(estudianteData.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Estudiante> createEstudiante(@Valid @RequestBody Estudiante estudiante){
        try{
            Optional<Estudiante> oldEstudiante = estudianteService.getEstudianteById(estudiante.getId());
            if (oldEstudiante.isPresent()) {
                oldEstudiante.get().setName(estudiante.getName());
                oldEstudiante.get().setSeccion(estudiante.getSeccion());
                oldEstudiante.get().setCedula(estudiante.getCedula());
                return new ResponseEntity<>(estudianteService.storeEstudiante(oldEstudiante.get()), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(estudianteService.storeEstudiante(estudiante), HttpStatus.OK);
            }
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(value = "/{idEstudiante}", method = RequestMethod.PUT)
    public ResponseEntity<Estudiante> updateEstudiante(@PathVariable("idEstudiante") Long idE, @RequestBody Estudiante estudiante){
        Optional<Estudiante> estudianteData = estudianteService.getEstudianteById(idE);
        if(estudianteData.isPresent()){
            Estudiante estudianteAux = estudianteData.get();
            estudianteAux.setCedula(estudiante.getCedula());
            estudianteAux.setSeccion(estudiante.getSeccion());
            estudianteAux.setName(estudiante.getName());
            return new ResponseEntity<>(estudianteAux, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(value = "/{idEstudiante}", method = RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> deleteEstudiante(@PathVariable("idEstudiante") Long id){
        try{
            estudianteService.deleteEstudianteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> deleteAllSeccion(){
        try{
            estudianteService.deleteAllSeccion();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
