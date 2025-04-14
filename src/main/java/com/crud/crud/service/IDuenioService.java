package com.crud.crud.service;

import com.crud.crud.model.Duenio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IDuenioService {

    public List<Duenio> getDuenios();

    public void saveDuenio(Duenio due);

    public void deleteDuenio(Long id);

    public Duenio findDuenio(Long id);

    public void editDuenio(Long idOriginal, String dniNuevo, String nuevoNombre, String nuevoApellido, String celNuevo);

    public void editDuenio(Duenio due);

}
