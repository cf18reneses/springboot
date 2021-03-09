package com.codesplai.adaptacar.repositories;

import com.codesplai.adaptacar.models.Puntuacion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PuntuacionRepository extends JpaRepository<Puntuacion,Integer> {
}
