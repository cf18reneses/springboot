package com.codesplai.adaptacar.repositories;

import com.codesplai.adaptacar.models.Puertas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PuertasRepository extends JpaRepository<Puertas,Integer> {
}
