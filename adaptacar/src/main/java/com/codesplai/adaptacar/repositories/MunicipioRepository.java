package com.codesplai.adaptacar.repositories;

import com.codesplai.adaptacar.models.Municipio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MunicipioRepository extends JpaRepository<Municipio,Integer> {
}
