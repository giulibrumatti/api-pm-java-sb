package com.crud.crud.service;

import com.crud.crud.model.Duenio;
import com.crud.crud.repository.IDuenioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class DuenioService implements IDuenioService {

    @Autowired
    private IDuenioRepository dueRep;

    @Override
    public List<Duenio> getDuenios() {
        List<Duenio> listaDuenios = dueRep.findAll();
        return listaDuenios;
    }

    @Override
    public void saveDuenio(Duenio due) {
        dueRep.save(due);
    }

    @Override
    public void deleteDuenio(Long id) {
        dueRep.deleteById(id);
    }

    @Override
    public Duenio findDuenio(Long id) {
        Duenio due = dueRep.findById(id).orElse(null);
        return due;
    }

    @Override
    public void editDuenio(Long idOriginal, String dniNuevo, String nuevoNombre, String nuevoApellido, String celNuevo) {
        Duenio due = this.findDuenio(idOriginal);
        due.setDni(dniNuevo);
        due.setCelular(celNuevo);
        due.setNombre(nuevoNombre);
        due.setApellido(nuevoApellido);
        this.saveDuenio(due);
    }

    @Override
    public void editDuenio(Duenio due){
        this.saveDuenio(due);
    }

}