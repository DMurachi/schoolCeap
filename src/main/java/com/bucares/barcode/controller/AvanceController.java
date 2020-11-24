package com.bucares.barcode.controller;

import com.bucares.barcode.model.Avance;
import com.bucares.barcode.model.Seccion;
import com.bucares.barcode.service.AvanceService;
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
@RequestMapping("/avance")
public class AvanceController {
    @Autowired
    AvanceService avanceService;

    private static final Logger logger = LoggerFactory.getLogger(AvanceController.class);
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Avance>> getAllAvance(){
        try{
            List<Avance> avances = new ArrayList<Avance>();
            avanceService.getAllAvances().forEach(avances::add);
            if(avances.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(avances, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/{idAvance}", method = RequestMethod.GET)
    public ResponseEntity<Avance> getAvance(@PathVariable("idAvance") Long idA){
        Optional<Avance> avanceData = avanceService.getAvanceById(idA);
        if(avanceData.isPresent()){
            return new ResponseEntity<>(avanceData.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Avance> createSeccion(@Valid @RequestBody Avance avance){
        try{
            Optional<Avance> oldAvance = avanceService.getAvanceById(avance.getId());
            if (oldAvance.isPresent()) {
                oldAvance.get().setNotaAvance(avance.getNotaAvance());
                return new ResponseEntity<>(avanceService.storeAvance(oldAvance.get()), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(avanceService.storeAvance(avance), HttpStatus.OK);
            }
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(value = "/{idAvance}", method = RequestMethod.PUT)
    public ResponseEntity<Avance> updateAvance(@PathVariable("idAvance") Long idA, @RequestBody Avance avance){
        Optional<Avance> avanceData = avanceService.getAvanceById(idA);
        if(avanceData.isPresent()){
            Avance avanceAux = avanceData.get();
            avanceAux.setNotaAvance(avance.getNotaAvance());
            return new ResponseEntity<>(avanceAux, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(value = "/{idAvance}", method = RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> deleteAvance(@PathVariable("idAvance") Long idA){
        try{
            avanceService.deleteAvanceById(idA);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> deleteAllAvance(){
        try{
            avanceService.deleteAllAvance();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
