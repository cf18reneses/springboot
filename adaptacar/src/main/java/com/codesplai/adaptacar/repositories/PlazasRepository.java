package com.codesplai.adaptacar.repositories;

import com.codesplai.adaptacar.models.Plazas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlazasRepository extends JpaRepository<Plazas,Integer> {
}
