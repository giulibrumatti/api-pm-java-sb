package com.crud.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.crud.crud.model.Duenio;
import org.springframework.stereotype.Repository;

@Repository
public interface IDuenioRepository extends JpaRepository<Duenio, Long> {

}
