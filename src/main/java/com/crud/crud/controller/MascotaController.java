package com.crud.crud.controller;

import com.crud.crud.model.Mascota;
import com.crud.crud.service.IMascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MascotaController {

    @Autowired
    private IMascotaService mascoSer;

    @PostMapping("/mascotas/crear")
    public String savePersona(@RequestBody Mascota masco){
        mascoSer.saveMascota(masco);
        return "La mascota ha sido creada";
    }
}
