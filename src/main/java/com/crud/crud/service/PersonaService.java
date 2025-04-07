package com.crud.crud.service;

import com.crud.crud.model.Persona;
import com.crud.crud.repository.IPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class PersonaService implements IPersonaService{

    @Autowired
    private IPersonaRepository pRepository;

    @Override
    public List<Persona> getPersonas() {
        List<Persona> listaPersonas = pRepository.findAll();
        return listaPersonas;
    }

    @Override
    public void savePersona(Persona perso) {
        pRepository.save(perso);
    }

    @Override
    public void deletePersona(Long id) {
        pRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        Persona perso = pRepository.findById(id).orElse(null);
        return perso;
    }

    @Override
    public void editPersona(Long idOriginal, String nuevoNombre, String nuevoApellido, Integer nuevaEdad) {
        Persona perso = this.findPersona(idOriginal);
        perso.setEdad(nuevaEdad);
        perso.setNombre(nuevoNombre);
        perso.setApellido(nuevoApellido);
        this.savePersona(perso);
    }

    @Override
    public void editPersona(Persona perso){
        this.savePersona(perso);
    }
}