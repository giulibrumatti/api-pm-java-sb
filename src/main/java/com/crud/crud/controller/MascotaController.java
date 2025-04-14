package com.crud.crud.controller;

import com.crud.crud.dto.MascotaDuenioDTO;
import com.crud.crud.model.Duenio;
import com.crud.crud.model.Mascota;
import com.crud.crud.service.IMascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MascotaController {

    @Autowired
    private IMascotaService mascoSer;

    @PostMapping("/mascotas/crear")
    public String savePersona(@RequestBody Mascota masco){
        mascoSer.saveMascota(masco);
        return "La mascota ha sido creada";
    }

    @GetMapping("/mascotas/traer")
    public List<Mascota> getMascotas(){
        return mascoSer.getMascotas();
    }

    @PutMapping("/mascotas/editar")
    public Mascota editMascota(Mascota masc){
        mascoSer.editMascota(masc);
        return mascoSer.findMascota(masc.getIdMascota());
    }

    @PutMapping("/mascotas/editar/{id}")
    public Mascota editMascota(@PathVariable("id") Long id,
                               @RequestParam(required = false, name = "nombre") String nuevoNombre,
                               @RequestParam(required = false, name = "especie") String nuevaEspecie,
                               @RequestParam(required = false, name = "raza") String nuevaRaza,
                               @RequestParam(required = false, name = "color") String nuevoColor){
        mascoSer.editMascota(id, nuevoNombre, nuevaEspecie, nuevaRaza, nuevoColor);
        Mascota mascotaSalida = mascoSer.findMascota(id);
        return mascotaSalida;
    }

    @DeleteMapping("/mascotas/eliminar/{id}")
    public String deleteMascota(@PathVariable Long id){
        mascoSer.deleteMascota(id);
        return "La mascota fue eliminada correctamente";
    }

    @GetMapping("/mascotas/duenio/{id}")
    public MascotaDuenioDTO traerDatosCombinados(@PathVariable("id") Long id){
        return mascoSer.traerDatosCombinados(id);
    }


}
