package com.crud.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.crud.crud.model.Persona;

public interface IPersonaRepository extends JpaRepository<Persona, Long> {

}
