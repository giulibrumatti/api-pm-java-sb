package com.crud.crud.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idMascota;
    private String nombre;
    private String especie;
    private String raza;
    private String color;
    @OneToOne
    @JoinColumn(name = "id_duenio", referencedColumnName = "idDue")
    private Duenio duenio;

    public Mascota(){
    }

    public Mascota(Long idMascota, String nombre, String especie, String raza, String color) {
        this.idMascota = idMascota;
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.color = color;
    }
}