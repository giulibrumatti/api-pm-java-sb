package com.crud.crud.service;

import com.crud.crud.model.Mascota;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IMascotaService {
    public List<Mascota> getMascotas();

    public void saveMascota(Mascota masco);

    public void deleteMascota(Long id);

    public Mascota findMascota(Long id);

    public void editMascota(Long idOr, Long idMasco, String nuevoNombre, String nuevaEspecie,
                            String nuevaRaza, String nuevoColor);


}
