package com.crud.crud.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Duenio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idDue;
    private String dni;
    private String nombre;
    private String apellido;
    private String celular;
    @OneToMany
    private List<Mascota> listaMascota;


    public Duenio(Long idDue, String dni, String nombre, String apellido, String celular, List<Mascota> listaMascota) {
        this.idDue = idDue;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.listaMascota = listaMascota;
    }

    public Duenio() {

    }
}
