package com.bucares.barcode.controller;

import com.bucares.barcode.model.AnioEscolar;
import com.bucares.barcode.model.Seccion;
import com.bucares.barcode.service.AnioEscolarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.AbstractNestablePropertyAccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/anioescolar")
public class AnioEscolarController {
    @Autowired
    AnioEscolarService anioEscolarService;

    private static final Logger logger = LoggerFactory.getLogger(AnioEscolarController.class);

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<AnioEscolar>> getAllAnioEscolar(){
        try{
            List<AnioEscolar> anios = new ArrayList<AnioEscolar>();
            anioEscolarService.getAllAnioEscolar().forEach(anios::add);
            if(anios.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(anios, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/{idAnioEscolar}", method = RequestMethod.GET)
    public ResponseEntity<AnioEscolar> getAnioEscolar(@PathVariable("idAnioEscolar") Long idA){
        Optional<AnioEscolar> anioData = anioEscolarService.getById(idA);
        if(anioData.isPresent()){
            return new ResponseEntity<>(anioData.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<AnioEscolar> createAnioEscolar(@Valid @RequestBody AnioEscolar anioEscolar){
        try{
            Optional<AnioEscolar> oldAnio = anioEscolarService.getById(anioEscolar.getId());
            if (oldAnio.isPresent()) {
                oldAnio.get().setSecciones(anioEscolar.getSecciones());
                return new ResponseEntity<>(anioEscolarService.storeAnioEscolar(oldAnio.get()), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(anioEscolarService.storeAnioEscolar(anioEscolar), HttpStatus.OK);
            }
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(value = "/{idAnioEscolar}", method = RequestMethod.PUT)
    public ResponseEntity<AnioEscolar> updateAnioEscolar(@PathVariable("idAnioEscolar") Long idAe, @RequestBody AnioEscolar anioEscolar){
        Optional<AnioEscolar> anioData = anioEscolarService.getById(idAe);
        if(anioData.isPresent()){
            AnioEscolar anioAux = anioData.get();
            anioAux.setSecciones(anioEscolar.getSecciones());
            return new ResponseEntity<>(anioAux, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(value = "/{idAnioEscolar}", method = RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> deleteAnioEscolar(@PathVariable("idAnioEscolar") Long idAe){
        try{
            anioEscolarService.deleteAnioEscolarById(idAe);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> deleteAllAnioEscolar(){
        try{
            anioEscolarService.deleteAllAnioEscolar();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
