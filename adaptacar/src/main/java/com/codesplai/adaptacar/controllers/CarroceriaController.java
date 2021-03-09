package com.codesplai.adaptacar.controllers;

import java.util.ArrayList;

import com.codesplai.adaptacar.models.Carroceria;
import com.codesplai.adaptacar.repositories.CarroceriaRepository;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/carrocerias")
public class CarroceriaController {
    private final CarroceriaRepository carroceriaRepository;

    CarroceriaController(CarroceriaRepository repository) {
        this.carroceriaRepository = repository;
    }

    @GetMapping()
    public ArrayList<Carroceria> obtenerCoche() {
        return (ArrayList<Carroceria>) carroceriaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Carroceria one(@PathVariable Integer id) {
        return carroceriaRepository.findById(id).get();
    }
}