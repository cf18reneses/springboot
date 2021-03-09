package com.codesplai.adaptacar.controllers;

import java.util.ArrayList;

import com.codesplai.adaptacar.models.Municipio;
import com.codesplai.adaptacar.repositories.MunicipioRepository;

import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class MunicipioController {

    private final MunicipioRepository municipioRepository;

    MunicipioController(MunicipioRepository municipioRepository) {
        this.municipioRepository = municipioRepository;
    }

    @GetMapping("/municipios")
    public ArrayList<Municipio> obtenerMunicipios() {
        return (ArrayList<Municipio>) municipioRepository.findAll();
    }

    @GetMapping("municipio/{id}")
    public Municipio one(@PathVariable Integer id) {
        return municipioRepository.findById(id).get();
    }
}
