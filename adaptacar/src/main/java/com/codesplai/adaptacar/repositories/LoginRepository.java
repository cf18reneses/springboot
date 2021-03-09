package com.codesplai.adaptacar.repositories;

import com.codesplai.adaptacar.models.Login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login,Integer> {
}
