package com.codesplai.adaptacar.repositories;

import com.codesplai.adaptacar.models.Color;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepository extends JpaRepository<Color,Integer> {
}
