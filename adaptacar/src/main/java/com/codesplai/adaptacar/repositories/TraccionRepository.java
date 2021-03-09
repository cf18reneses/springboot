package com.codesplai.adaptacar.repositories;

import com.codesplai.adaptacar.models.Traccion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TraccionRepository extends JpaRepository<Traccion,Integer> {
}
