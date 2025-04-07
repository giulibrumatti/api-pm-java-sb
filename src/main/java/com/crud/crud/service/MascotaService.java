package com.crud.crud.service;

import com.crud.crud.model.Mascota;
import com.crud.crud.repository.IMascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MascotaService implements IMascotaService{
    @Autowired
    private IMascotaRepository repoMasco;


    @Override
    public List<Mascota> getMascotas() {
        List<Mascota> listaMasco = repoMasco.findAll();
        return listaMasco;
    }

    @Override
    public void saveMascota(Mascota masco) {
        repoMasco.save(masco);
    }

    @Override
    public void deleteMascota(Long id) {
        repoMasco.deleteById(id);
    }

    @Override
    public Mascota findMascota(Long id) {
        return repoMasco.findById(id).orElse(null);
    }

    @Override
    public void editMascota(Long idOr, Long idMasco, String nuevoNombre, String nuevaEspecie, String nuevaRaza, String nuevoColor) {
        Mascota masco = this.findMascota(idOr);

        masco.setIdMascota(idMasco);
        masco.setNombre(nuevoNombre);
        masco.setRaza(nuevaRaza);
        masco.setEspecie(nuevaEspecie);
        masco.setColor(nuevoColor);

        this.saveMascota(masco);
    }
}
