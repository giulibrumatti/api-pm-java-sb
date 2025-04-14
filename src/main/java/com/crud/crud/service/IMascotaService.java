package com.crud.crud.service;

import com.crud.crud.dto.MascotaDuenioDTO;
import com.crud.crud.model.Mascota;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IMascotaService {
    public List<Mascota> getMascotas();

    public void saveMascota(Mascota masco);

    public void deleteMascota(Long id);

    public Mascota findMascota(Long id);

    public void editMascota(Long idOr, String nuevoNombre, String nuevaEspecie,
                            String nuevaRaza, String nuevoColor);

    public void editMascota(Mascota masc);

    public List<Mascota> listarPerroCaniches();

    public MascotaDuenioDTO traerDatosCombinados(Long id);
}
