package com.crud.crud.controller;

import com.crud.crud.model.Duenio;
import com.crud.crud.service.IDuenioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DuenioController {

    @Autowired
    private IDuenioService dueServ;

    @PostMapping("/duenios/crear")
    public String crearDuenio(Duenio due){
        dueServ.saveDuenio(due);
        return "El dueño ingresado se creo correctamente";
    }

    @GetMapping("/dueños/listar")
    public List<Duenio> listarDuenios(){
        List<Duenio> listaSalida = dueServ.getDuenios();
        return listaSalida;
    }

    @DeleteMapping("/dueños/eliminar/{id}")
    public String eliminarDuenio(Long id){
        dueServ.deleteDuenio(id);
        return "El dueño fue eliminado con exito";
    }

    @PutMapping("/dueños/editar")
    public Duenio editarDuenio(Duenio due){
        dueServ.saveDuenio(due);
        return dueServ.findDuenio(due.getIdDue());
    }

    @PutMapping("/dueños/editar/{id}")
    public Duenio editarDuenio(@PathVariable("id") Long id,
                               @RequestParam(required = false, name = "dni") String nuevoDni,
                               @RequestParam(required = false, name = "nombre") String nuevoNombre,
                               @RequestParam(required = false, name = "apellido") String nuevoApellido,
                               @RequestParam(required = false, name = "celular") String nuevoCelular){

        dueServ.editDuenio(id, nuevoDni, nuevoNombre, nuevoApellido, nuevoCelular);
        Duenio dueSalida = dueServ.findDuenio(id);
        return dueSalida;
    }


}
