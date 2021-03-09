package com.codesplai.adaptacar.controllers;

import java.util.ArrayList;

import com.codesplai.adaptacar.models.Puertas;
import com.codesplai.adaptacar.repositories.PuertasRepository;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/puertas")
public class PuertasController {
    private final PuertasRepository puertasRepository;

    PuertasController(PuertasRepository repository) {
        this.puertasRepository = repository;
    }

    @GetMapping()
    public ArrayList<Puertas> obtenerPuertas() {
        return (ArrayList<Puertas>) puertasRepository.findAll();
    }

    @GetMapping("/{id}")
    public Puertas one(@PathVariable Integer id) {
        return puertasRepository.findById(id).get();
    }
}