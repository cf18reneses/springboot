package com.codesplai.adaptacar.controllers;

import java.util.ArrayList;

import com.codesplai.adaptacar.models.Combustible;
import com.codesplai.adaptacar.repositories.CombustibleRepository;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/combustibles")
public class CombustibleController {
    private final CombustibleRepository combustibleRepository;

    CombustibleController(CombustibleRepository repository) {
        this.combustibleRepository = repository;
    }

    @GetMapping()
    public ArrayList<Combustible> obtenerCombustible() {
        return (ArrayList<Combustible>) combustibleRepository.findAll();
    }

    @GetMapping("/{id}")
    public Combustible one(@PathVariable Integer id) {
        return combustibleRepository.findById(id).get();
    }
}