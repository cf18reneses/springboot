package com.codesplai.adaptacar.service.impl;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.codesplai.adaptacar.dto.PostDto;
import com.codesplai.adaptacar.models.Adaptaciones;
import com.codesplai.adaptacar.models.Imagen;
import com.codesplai.adaptacar.models.Post;
import com.codesplai.adaptacar.repositories.ImagenRepository;
import com.codesplai.adaptacar.repositories.PostRepository;
import com.codesplai.adaptacar.service.PostService;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    
    private final PostRepository postRepository;
    private final ImagenRepository imagenRepository;


    PostServiceImpl(PostRepository postRepository, ImagenRepository imagenRepository) {
        this.postRepository = postRepository;
        this.imagenRepository = imagenRepository;
    }
    
    @Override
    public String guardar(PostDto postDto) {
        Post savedPost = guardarPost(postDto);
        guardarPostAdaptaciones(postDto, savedPost);
        guardarImagen(postDto, savedPost);
        return "OK";
    }

    private Post guardarPost(PostDto postDto){
        Post postToSave = new Post();
        postToSave.setPrecio(postDto.getPrecio());
        postToSave.setDescripcion(postDto.getDescripcion());
        postToSave.setFecha_publi(postDto.getFecha_publi());
        postToSave.setAnyo(postDto.getAnyo());
        postToSave.setMunicipio(postDto.getMunicipio());
        postToSave.setKms(postDto.getKms());
        postToSave.setEmbrague(postDto.getEmbrague());
        postToSave.setMotor(postDto.getMotorCC());
        postToSave.setCv(postDto.getCv());
        postToSave.setCombustible(postDto.getCombustible());
        postToSave.setTraccion(postDto.getTraccion());
        postToSave.setCarroceria(postDto.getCarroceria());
        postToSave.setColor(postDto.getColor());
        postToSave.setPuertas(postDto.getPuertas());
        postToSave.setPlazas(postDto.getPlazas());
        postToSave.setCoche(postDto.getIdcoche());
        return postRepository.save(postToSave);
    }

    private void guardarPostAdaptaciones(PostDto postDto, Post post){
        List<Adaptaciones> adaptaciones = new ArrayList<>();
        for (int i = 0; i < postDto.getAdaptaciones().size(); i++) {
            Adaptaciones adaptacion = new Adaptaciones();
            adaptacion.setId(postDto.getAdaptaciones().get(i));
            adaptaciones.add(adaptacion);
        }
        post.setAdaptaciones(adaptaciones);
        postRepository.save(post);
    }

    private void guardarImagen(PostDto postDto, Post savedPost){
        Path directorioImagenes = Paths.get("src//main//resources//static/images");
        String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();
        try {
            for (int i = 0; i < postDto.getImagenes().size(); i++) {
                byte[] bytesImg = postDto.getImagenes().get(i).getBytes();
                Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + postDto.getImagenes().get(i).getOriginalFilename());
                Files.write(rutaCompleta, bytesImg);
                Imagen img = new Imagen();
                img.setUrlFoto(postDto.getImagenes().get(i).getOriginalFilename());
                img.setPost(savedPost);
                imagenRepository.save(img);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

