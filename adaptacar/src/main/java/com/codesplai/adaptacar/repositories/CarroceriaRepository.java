package com.codesplai.adaptacar.repositories;

import com.codesplai.adaptacar.models.Carroceria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroceriaRepository extends JpaRepository<Carroceria,Integer> {
}
