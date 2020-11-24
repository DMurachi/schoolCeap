package com.bucares.barcode.controller;

import com.bucares.barcode.model.PlanEstudio;
import com.bucares.barcode.model.Seccion;
import com.bucares.barcode.service.PlanEstudioService;
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
@RequestMapping("/planestudio")
public class PlanEstudioController {
    @Autowired
    PlanEstudioService planEstudioService;

    private static final Logger logger = LoggerFactory.getLogger(PlanEstudioController.class);
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<PlanEstudio>> getAllPlanEstudio(){
        try{
            List<PlanEstudio> planes = new ArrayList<PlanEstudio>();
            planEstudioService.getAllPlanEstudio().forEach(planes::add);
            if(planes.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(planes, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/{idPlanEstudio}", method = RequestMethod.GET)
    public ResponseEntity<PlanEstudio> getPlanEstudio(@PathVariable("idPlanEstudio") Long idP){
        Optional<PlanEstudio> planData = planEstudioService.getPlanEstudioById(idP);
        if(planData.isPresent()){
            return new ResponseEntity<>(planData.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<PlanEstudio> createPlanEstudio(@Valid @RequestBody PlanEstudio planEstudio){
        try{
            Optional<PlanEstudio> oldPlan = planEstudioService.getPlanEstudioById(planEstudio.getId());
            if (oldPlan.isPresent()) {
                oldPlan.get().setMaterias(planEstudio.getMaterias());
                return new ResponseEntity<>(planEstudioService.storePlanEstudio(oldPlan.get()), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(planEstudioService.storePlanEstudio(planEstudio), HttpStatus.OK);
            }
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(value = "/{idPlanEstudio}", method = RequestMethod.PUT)
    public ResponseEntity<PlanEstudio> updatePlanEstudio(@PathVariable("idPlanEstudio") Long idP, @RequestBody PlanEstudio planEstudio){
        Optional<PlanEstudio> planData = planEstudioService.getPlanEstudioById(idP);
        if(planData.isPresent()){
            PlanEstudio planAux = planData.get();
            planAux.setMaterias(planEstudio.getMaterias());
            return new ResponseEntity<>(planAux, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(value = "/{idPlanEstudio}", method = RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> deletePlanEstudio(@PathVariable("idPlanEstudio") Long id){
        try{
            planEstudioService.deletePlanEstudioById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> deleteAllSeccion(){
        try{
            planEstudioService.deleteAllPlanEstudio();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
