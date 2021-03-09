package com.codesplai.adaptacar.repositories;

import java.util.HashMap;
import java.util.List;

import com.codesplai.adaptacar.models.Post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {
    public List<Post> getData(HashMap<String, Object> conditions);

    @Query(value = "SELECT * FROM post JOIN post_has_adaptaciones ON post.idpost = post_has_adaptaciones.post_idpost WHERE adaptaciones_idadaptacion = :idadaptacion", nativeQuery = true)
    public List<Post> findPostsByIdAdaptacion(@Param("idadaptacion") Integer id);

    public List<Post> findByAllAdaptaciones(@Param("ids") Integer[] ids);

    @Query(value = "SELECT * FROM post JOIN coche ON post.coche_idcoche = coche.idcoche WHERE coche.marca =:keyword OR coche.modelo=:keyword", nativeQuery = true)
    public List<Post> findPostsByKeyword(@Param("keyword") String keyword);

    @Query(value = "SELECT * FROM post JOIN coche ON post.coche_idcoche = coche.idcoche WHERE modelo =:modelo", nativeQuery = true)
    public List<Post> findPostsByModelo(@Param("modelo") String modelo);
    
}
