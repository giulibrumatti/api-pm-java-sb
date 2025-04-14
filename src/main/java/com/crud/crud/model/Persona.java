package com.crud.crud.model;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
/**
 @OneToOne
 @JoinColumn(name="una_mascota_id_mascota", referencedColumnName = "idMascota")
 private Mascota unaMascota;
 (Cuando tenemos una relacion OneToOne)
 */
@Getter
@Setter
public class Persona {
    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String apellido;
    private Integer edad;
    /*Cuando tenemos una relacion 1 a n (muchos). La FK en la base de datos va a estar de lado de la N pero en la logica,
    la lista de N esta del lado del 1.**/
   /* @OneToMany
    private List<Mascota> listaMascotas;*/

    public Persona(Long id, String nombre, String apellido, Integer edad, List<Mascota> listaMascotas) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        //this.listaMascotas = listaMascotas;
    }

    public Persona(){
    }
}
