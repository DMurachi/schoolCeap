package com.bucares.barcode.controller;

import com.bucares.barcode.model.*;
import com.bucares.barcode.service.EstudianteService;
import com.bucares.barcode.service.MateriaService;
import com.bucares.barcode.service.SeccionService;
import com.bucares.barcode.service.ProfesorService;
import com.bucares.barcode.utilities.DTOUtils;
import com.bucares.barcode.utilities.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProfesorController {
    @Autowired
    private EstudianteService estudianteService;
    @Autowired
    private MateriaService materiaService;
    @Autowired
    private SeccionService seccionService;
    @Autowired
    private ProfesorService userService;

    private static final Logger logger = LoggerFactory.getLogger(ProfesorController.class);

    @GetMapping(value = "user/seccion")
    @ResponseBody
    public ResponseEntity<Response<List<Seccion>>> getAllSeccionAsignada(String id) {
        logger.info("Called resource: getAllSeccionAsignada");
        Profesor userAux = userService.getById(id);
        userDTO userdto = new userDTO();
        DTOUtils.copyProperties(userAux, userdto);
        List<Seccion> seccionAux = userdto.getSeccionAsignada();
        Response<List<Seccion>> response = new Response<>("0000", seccionAux, null);
        logger.info("Consulted: list of seccion thru userdto in database");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
   /* public Materia validarMateria(String userId){
        logger.info("called resource: validar materia");
        List<Materia> materiaAux = materiaService.getAllMaterias();
        User userAux = userService.getById(userId);
        for(int i=0; i<materiaAux.size()-1;i++){
            if(materiaAux.get(i).getId()==userAux.getMateriaAsignada().get(i).getId()){
                return materiaAux.get(i);
            }
        }
        return
    }*/
 /*   @GetMapping(value = "user/seccion/{id}")
    public ResponseEntity<Response<> getAllMateriaAsignada(@PathVariable("id") String id) {
        User userAux = userService.getById(id);
        userDTO userdto = new userDTO();
        DTOUtils.copyProperties(userAux, userdto);
        List<Materia> materiaAux = userdto.getMateriaAsignada();
        Response<List<Materia>> response = new Response<>("0000", materiaAux, null);
        logger.info("Consulted: list of materia thru userdto in database");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping(value = "user/seccion/{id}/materia")
    public ResponseEntity<Response<List<Materia>>> getAllMateriaAsignada(String id) {
        User userAux = userService.getById(id);
        userDTO userdto = new userDTO();
        DTOUtils.copyProperties(userAux, userdto);
        List<Materia> materiaAux = userdto.getMateriaAsignada();
        Response<List<Materia>> response = new Response<>("0000", materiaAux, null);
        logger.info("Consulted: list of materia thru userdto in database");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "user/seccion/materia/estudiante")
    public ResponseEntity<Response<List<Estudiante>>> getSeccionEstudiante(@Valid @RequestBody
                                                                           String id){
        User userAux = userService.getById(id);
        userDTO userdto = new userDTO();
        DTOUtils.copyProperties(userAux, userdto);
        Seccion seccionAux = seccionService.getSeccionById(userAux.getSeccionAsignada()
                        .get(i).getSeccionId());
        List<Estudiante> estudianteMatch =
                        estudianteService.getEstudianteSeccion(seccionAux);
        Response<List<Estudiante>> response = new Response<>("0000", estudianteMatch, null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping(value = "user/seccion/materia/estudiante")
    public void subirNota(float nota){

    }
  /*  public boolean validarLapso(){

    }*/

}
//RECUERDA ESTO ES LO QUE VERA EL PROFE
/*TERMINAR ESTE CONTROLADOR, VALIDAR TODO, TERMINAR EL OTRO CONTROLADOR, VALIDAR TODO
 *                                     LUEGO CHECK QUE CADA FUNCION HACE LO QUE SE SUPONE
 * ESTO PARA MAÑANA ESTAMOS EN 6. PARA LUNES 9 ESTO TIENE QUE ESTAR LISTO.*/
