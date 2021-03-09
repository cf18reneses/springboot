package com.codesplai.adaptacar.repositories;

import com.codesplai.adaptacar.models.Motor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotorRepository extends JpaRepository<Motor,Integer> {
}
