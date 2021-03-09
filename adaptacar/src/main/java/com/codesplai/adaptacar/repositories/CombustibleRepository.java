package com.codesplai.adaptacar.repositories;

import com.codesplai.adaptacar.models.Combustible;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CombustibleRepository extends JpaRepository<Combustible,Integer> {
}