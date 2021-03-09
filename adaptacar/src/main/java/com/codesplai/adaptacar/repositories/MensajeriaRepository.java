package com.codesplai.adaptacar.repositories;

import com.codesplai.adaptacar.models.Mensajeria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MensajeriaRepository extends JpaRepository<Mensajeria,Integer> {
}
