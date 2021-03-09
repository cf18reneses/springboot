package com.codesplai.adaptacar.repositories;

import com.codesplai.adaptacar.models.Coche;
import java.util.HashMap;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CocheRepository extends JpaRepository<Coche,Integer> {
    public List<Coche> getData(HashMap<String, Object> conditions);
}
