package com.codesplai.adaptacar.controllers;

import java.util.ArrayList;

import com.codesplai.adaptacar.models.Traccion;
import com.codesplai.adaptacar.repositories.TraccionRepository;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/tracciones")
public class TraccionController {
    private final TraccionRepository traccionRepository;

    TraccionController(TraccionRepository repository) {
        this.traccionRepository = repository;
    }

    @GetMapping()
    public ArrayList<Traccion> obtenerTraccion() {
        return (ArrayList<Traccion>) traccionRepository.findAll();
    }

    @GetMapping("/{id}")
    public Traccion one(@PathVariable Integer id) {
        return traccionRepository.findById(id).get();
    }
}