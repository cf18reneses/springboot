package com.codesplai.adaptacar.controllers;

import java.util.ArrayList;

import com.codesplai.adaptacar.models.ImagenesPost;

import com.codesplai.adaptacar.repositories.ImagenesPostRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
@RequestMapping("/api")
public class ImagenesPostController {

    private final ImagenesPostRepository imagenRepository;

    ImagenesPostController(ImagenesPostRepository repository) {
        this.imagenRepository = repository;
    }

    @GetMapping("/imagenesPost")
    public ArrayList<ImagenesPost> obtenerImagenes() {
        return (ArrayList<ImagenesPost>) imagenRepository.findAll();
    }
}