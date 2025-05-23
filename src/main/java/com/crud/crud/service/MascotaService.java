package com.crud.crud.service;

import com.crud.crud.dto.MascotaDuenioDTO;
import com.crud.crud.model.Duenio;
import com.crud.crud.model.Mascota;
import com.crud.crud.repository.IMascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public void editMascota(Long idOr, String nuevoNombre, String nuevaEspecie, String nuevaRaza, String nuevoColor) {
        Mascota masco = this.findMascota(idOr);
        masco.setNombre(nuevoNombre);
        masco.setRaza(nuevaRaza);
        masco.setEspecie(nuevaEspecie);
        masco.setColor(nuevoColor);
        this.saveMascota(masco);
    }

    @Override
    public void editMascota(Mascota masc) {
        this.saveMascota(masc);
    }

    @Override
    public List<Mascota> listarPerroCaniches() {
        List<Mascota> perrosCaniches = new ArrayList<Mascota>();
        List<Mascota> listaMascotas = this.getMascotas();

        for (Mascota masc : listaMascotas){
            if(masc.getEspecie().equalsIgnoreCase("perro") && masc.getRaza().equalsIgnoreCase("caniche")){
                perrosCaniches.add(masc);
            }
        }
        return perrosCaniches;
    }

    @Override
    public List<MascotaDuenioDTO> traerDatosCombinados() {
        List<Mascota> listaMascotas = this.getMascotas();
        List<MascotaDuenioDTO> listaMascoConDue = new ArrayList<MascotaDuenioDTO>();

        for(Mascota masc : listaMascotas){
            MascotaDuenioDTO mascDueDTO = new MascotaDuenioDTO();
            Duenio due = masc.getDuenio();
            mascDueDTO.setRaza(masc.getRaza());
            mascDueDTO.setEspecie(masc.getEspecie());
            mascDueDTO.setNombreMascota(masc.getNombre());
            mascDueDTO.setNombreDuenio(due.getNombre());
            mascDueDTO.setApellidoDuenio(due.getApellido());
            listaMascoConDue.add(mascDueDTO);
        }



        return listaMascoConDue;
    }


}
