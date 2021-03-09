package com.codesplai.adaptacar.repositories;

import com.codesplai.adaptacar.models.Adaptaciones;
import java.util.HashMap;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdaptacionesRepository extends JpaRepository<Adaptaciones,Integer> {
    public List<Adaptaciones> getData(HashMap<String, Object> conditions);
}