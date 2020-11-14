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

@Controller
public class AdminController {
    @Autowired
    private EstudianteService estudianteService;
    @Autowired
    private MateriaService materiaService;
    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
    //NOTA: posiblemente me toque usar los servicios de materia y nota para llenar el userdto completo,
    //de manera que haga una transferencia completa de los datos desde la entity hasta el dto.
    /*NOTA: eliminar la entidad Nota, agregar lista de materia en estudiante
    * Diseñar el controlador del profesor. RECUERDA: PENSAR EN LO QUE VERA EL PROFE QUE LE INTERESA
    * CAMBIAR O MODIFICAR
    * Cambia el nombre del userDTO controller, este deberia ser el del admin
    * Validar la seccion del profesor con la seccion del estudiante para que ingrese a secciones
    * y estudiantes validos. NO se puede entrar en cualquiera tiene que tener la validacion.
    * LUego fase de testing. POSTMAN y crear la DB en mysql*/
    @GetMapping
    @ResponseBody
    public ResponseEntity<Response<List<Estudiante>>> getAllStudent(){
        List<Estudiante> estudiante = estudianteService.getAllEstudiantes();
        Response<List<Estudiante>> response = new Response<>("0000",estudiante,null);
        logger.info("Called resource: getAllStudent");
        logger.info("Consulted: every studentDTO in database");
        return new ResponseEntity<>(response, HttpStatus.OK);
        //ARREGLA ESTO NECESITAS DECLARAR LA LISTA PARA PODER MANEJARLA COMPARADA CON EL STUDENT
        //UNA VEZ QUE ESTO FUNCIONE NECESITAS TODO EL CRUD DEL CONTROLADOR Y LUEGO LA BASE DE DATOS PARA PROBAR CON EL POSTMAN TODO LO QUE HAS HECHO
        // CON EL POSTMAN TE VAS A DAR CUENTA SI LO UQE HICISTE FUNCIONA. EN CASO DE QUE SI. PASAS AL TESTING.
        //NOTE : SI VES QUE ES DIFICIL CON LISTA GENERICA COMO AHORA, CREAR DTOS PARA CADA ENTITY Y LOS MERGEAS TODOS EN ESTE CONTROLADOR...(LAST OPTION)
       /* for(int i = 0; i<estudiante.size()-1; i++){
            DTOUtils.copyProperties(estudiante,userdto);
        }*/
        //return userdto;
    }
/*    @PostMapping(value = "/estudiante")
    public ResponseEntity<Response<Estudiante>> createEstudiante(@Valid @RequestBody Estudiante estudiante) {
        logger.info("Called resource: createEstudiante");
        Estudiante oldEstudiante = estudianteService.getEstudianteByNombreIdSeccion(estudiante.getName(),estudiante.getId(),
                estudiante.getSeccion());
        if (oldEstudiante != null) {
            oldEstudiante.setId(estudiante.getId());
            oldEstudiante.setName(estudiante.getName());
            oldEstudiante.setPlanEstudio(estudiante.getPlanEstudio());
            oldEstudiante.setCedula(estudiante.getCedula());
            estudianteService.storeEstudiante(oldEstudiante);
        } else {
            estudianteService.storeEstudiante(estudiante);
        }
        Response<Estudiante> response = new Response<>("0000", estudiante, null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }*/
    /*@DeleteMapping(value = "/cisterna/{placa}")
    public void deleteCisterna(@PathVariable("placa") String placa) {
        logger.info("Called resource: deleteCisterna");
        cisternaService.deleteCisterna(placa);
        logger.info("succesfull");
    }*/
  /*  @GetMapping(value = "/estudiante/notas")
    public ResponseEntity<Response<userDTO>> getEstudianteNotas
    (@PathVariable("notas") Estudiante estudiante) {
        logger.info("Called resource: getEstudianteNotas");
        userDTO userdto = null;
        if(estudiante != null) {
            List<Materia> materiaAux = estudiante.getMaterias();
            for (int i = 0; i < materiaAux.size() - 1; i++) {
                DTOUtils.copyProperties(materiaAux.get(i), userdto.getMateria());
            }
        }
        Response<userDTO> response = new Response<>("0000",userdto,null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }*/
   /* private userDTO convertToDto(Estudiante estudiante, Nota nota, Materia materia) {
        userDTO userdto = modelMapper.map(estudiante, userDTO.class);
        modelMapper.map(nota, userDTO.class);
        modelMapper.map(materia, userDTO.class);
        userdto.setStudentName(estudiante.getName());
        userdto.setStudentId(estudiante.getId());
        userdto.setMateriaId(materia.getId());
        userdto.setNotas(estudiante.getNotas());
        userdto.setPromStudent(estudiante.getPromEstudiante());
        return userdto;
    }*///RECUERDA: hacer los DTOS de las otras entidades que necesites, luego usas este controlador para manipularlas. necesitas
    //LA FORMA DE PONER EL CONVERT COMO STATIC O UTILITY


}
