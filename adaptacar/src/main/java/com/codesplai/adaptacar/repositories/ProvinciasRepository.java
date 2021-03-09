package com.codesplai.adaptacar.repositories;

import java.util.HashMap;
import java.util.List;

import com.codesplai.adaptacar.models.Provincias;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinciasRepository extends JpaRepository<Provincias,Integer> {
    public List<Provincias> getData(HashMap<String, Object> conditions);
}
