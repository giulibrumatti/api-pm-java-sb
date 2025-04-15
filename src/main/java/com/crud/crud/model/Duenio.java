package com.crud.crud.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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


    public Duenio(Long idDue, String dni, String nombre, String apellido, String celular) {
        this.idDue = idDue;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
    }

    public Duenio() {

    }
}
