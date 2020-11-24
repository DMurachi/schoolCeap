package com.bucares.barcode.controller;

import com.bucares.barcode.model.Estudiante;
import com.bucares.barcode.model.Materia;
import com.bucares.barcode.model.Seccion;
import com.bucares.barcode.service.MateriaService;
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
@RequestMapping("/materia")
public class MateriaController {
    @Autowired
    MateriaService materiaService;

    private static final Logger logger = LoggerFactory.getLogger(MateriaController.class);

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Materia>> getAllMateria(){
        try{
            List<Materia> materias = new ArrayList<Materia>();
            materiaService.getAllMaterias().forEach(materias::add);
            if(materias.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(materias, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/{idMateria}", method = RequestMethod.GET)
    public ResponseEntity<Materia> getMateria(@PathVariable("idMateria") Long idM){
        Optional<Materia> materiaData = materiaService.getMateriaById(idM);
        if(materiaData.isPresent()){
            return new ResponseEntity<>(materiaData.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Materia> createMateria(@Valid @RequestBody Materia materia){
        try{
            Optional<Materia> oldMateria = materiaService.getMateriaById(materia.getId());
            if (oldMateria.isPresent()) {
                oldMateria.get().setAvances(materia.getAvances());
                oldMateria.get().setNombre(materia.getNombre());
                return new ResponseEntity<>(materiaService.storeMateria(oldMateria.get()), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(materiaService.storeMateria(materia), HttpStatus.OK);
            }
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(value = "/{idMateria}", method = RequestMethod.PUT)
    public ResponseEntity<Materia> updateMateria(@PathVariable("idMateria") Long idM, @RequestBody Materia materia){
        Optional<Materia> materiaData = materiaService.getMateriaById(idM);
        if(materiaData.isPresent()){
            Materia materiaAux = materiaData.get();
            materiaAux.setNombre(materia.getNombre());
            materiaAux.setAvances(materia.getAvances());
            return new ResponseEntity<>(materiaAux, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(value = "/{idMateria}", method = RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> deleteSeccion(@PathVariable("idMateria") Long id){
        try{
            materiaService.deleteMateriaById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> deleteAllMateria(){
        try{
            materiaService.deleteAllSeccion();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
