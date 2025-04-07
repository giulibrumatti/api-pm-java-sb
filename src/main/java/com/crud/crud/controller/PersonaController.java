package com.crud.crud.controller;

import com.crud.crud.model.Persona;
import com.crud.crud.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class PersonaController {

    @Autowired
    private IPersonaService interPersona;

    @GetMapping("/personas/traer")
    public List<Persona> getPersonas(){
        return interPersona.getPersonas();
    }

    @PostMapping("/personas/crear")
    public String createPerson(@RequestBody Persona perso){
        interPersona.savePersona(perso);
        return "La persona fue creada con exito";
    }

    @DeleteMapping("/personas/borrar/{id}")
    public String deletePerson(@PathVariable Long id){
        interPersona.deletePersona(id);
        return "La persona fue eliminada con exito";
    }

    @PutMapping("personas/editar/{idOriginal}")
    public Persona editPersona(@PathVariable("idOriginal") Long idOriginal,
                               @RequestParam(required = false, name = "nombre") String nuevoNombre,
                               @RequestParam(required = false, name = "apellido") String nuevoAp,
                               @RequestParam(required = false, name = "edad") Integer nuevaEdad){

        interPersona.editPersona(idOriginal, nuevoNombre, nuevoAp, nuevaEdad);
        Persona perso = interPersona.findPersona(idOriginal);

        return perso;
    }

    @PutMapping("personas/editar")
    public Persona editPersona(@RequestBody Persona per){
        interPersona.editPersona(per);
        return interPersona.findPersona(per.getId());
    }
}
