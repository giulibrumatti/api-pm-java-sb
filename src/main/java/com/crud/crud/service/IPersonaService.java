package com.crud.crud.service;

import com.crud.crud.model.Persona;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPersonaService {

    public List<Persona> getPersonas();

    public void savePersona(Persona perso);

    public void deletePersona(Long id);

    public Persona findPersona(Long id);

    public void editPersona(Long idOriginal, String nuevoNombre,
                            String nuevoApellido, Integer nuevaEdad);

    public void editPersona(Persona perso);

}
