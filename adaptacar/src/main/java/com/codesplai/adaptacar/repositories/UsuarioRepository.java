package com.codesplai.adaptacar.repositories;

import com.codesplai.adaptacar.models.Usuario;
import java.util.HashMap;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
    public List<Usuario> getData(HashMap<String, Object> conditions);
}
