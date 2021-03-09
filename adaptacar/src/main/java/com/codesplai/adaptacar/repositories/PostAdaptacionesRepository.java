package com.codesplai.adaptacar.repositories;

import com.codesplai.adaptacar.models.PostAdaptaciones;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostAdaptacionesRepository extends JpaRepository<PostAdaptaciones, Integer> {
    
}
