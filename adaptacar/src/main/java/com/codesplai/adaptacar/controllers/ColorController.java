package com.codesplai.adaptacar.controllers;

import java.util.ArrayList;

import com.codesplai.adaptacar.models.Color;
import com.codesplai.adaptacar.repositories.ColorRepository;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ColorController {
    private final ColorRepository colorRepository;

    ColorController(ColorRepository repository) {
        this.colorRepository = repository;
    }

    @GetMapping("/colores")
    public ArrayList<Color> obtenerColor() {
        return (ArrayList<Color>) colorRepository.findAll();
    }

    @GetMapping("color/{id}")
    public Color one(@PathVariable Integer id) {
        return colorRepository.findById(id).get();
    }
}