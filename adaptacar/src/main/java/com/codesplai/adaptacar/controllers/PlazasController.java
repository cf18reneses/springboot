package com.codesplai.adaptacar.controllers;

import java.util.ArrayList;

import com.codesplai.adaptacar.models.Plazas;
import com.codesplai.adaptacar.repositories.PlazasRepository;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/plazas")
public class PlazasController {
    private final PlazasRepository plazasRepository;

    PlazasController(PlazasRepository repository) {
        this.plazasRepository = repository;
    }

    @GetMapping()
    public ArrayList<Plazas> obtenerPlazas() {
        return (ArrayList<Plazas>) plazasRepository.findAll();
    }

    @GetMapping("/{id}")
    public Plazas one(@PathVariable Integer id) {
        return plazasRepository.findById(id).get();
    }
}