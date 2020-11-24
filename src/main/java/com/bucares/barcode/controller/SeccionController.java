package com.bucares.barcode.controller;

import com.bucares.barcode.model.PlanEstudio;
import com.bucares.barcode.model.Seccion;
import com.bucares.barcode.service.SeccionService;
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
@RequestMapping("/seccion")
public class SeccionController {
    @Autowired
    private SeccionService seccionService;

    private static final Logger logger = LoggerFactory.getLogger(SeccionController.class);

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Seccion>> getAllSeccion(){
        try{
            List<Seccion> seccions = new ArrayList<Seccion>();
            seccionService.getAllSeccion().forEach(seccions::add);
            if(seccions.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(seccions, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/{idSeccion}", method = RequestMethod.GET)
    public ResponseEntity<Seccion> getSeccion(@PathVariable("idSeccion") Long idS){
        Optional<Seccion> seccionData = seccionService.getSeccionById(idS);
        if(seccionData.isPresent()){
            return new ResponseEntity<>(seccionData.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Seccion> createSeccion(@Valid @RequestBody Seccion seccion){
        try{
            Optional<Seccion> oldSeccion = seccionService.getSeccionById(seccion.getId());
            if (oldSeccion.isPresent()) {
                oldSeccion.get().setEstudiantes(seccion.getEstudiantes());
                oldSeccion.get().setPlanEstudio(seccion.getPlanEstudio());
                return new ResponseEntity<>(seccionService.storeSeccion(oldSeccion.get()), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(seccionService.storeSeccion(seccion), HttpStatus.OK);
            }
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(value = "/{idSeccion}", method = RequestMethod.PUT)
    public ResponseEntity<Seccion> updateSeccion(@PathVariable("idSeccion") Long idS, @RequestBody Seccion seccion){
        Optional<Seccion> seccionData = seccionService.getSeccionById(idS);
        if(seccionData.isPresent()){
            Seccion seccionAux = seccionData.get();
            seccionAux.setPlanEstudio(seccion.getPlanEstudio());
            seccionAux.setEstudiantes(seccion.getEstudiantes());
            return new ResponseEntity<>(seccionAux, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(value = "/{idSeccion}", method = RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> deleteSeccion(@PathVariable("idSeccion") Long id){
        try{
            seccionService.deleteSeccionById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> deleteAllSeccion(){
        try{
            seccionService.deleteAllSeccion();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
   /* @RequestMapping(value = "/PlanEstudio", method = RequestMethod.GET)
    public ResponseEntity<PlanEstudio> getPlanFromSeccion(){
        try{

        }
    }*/

}
