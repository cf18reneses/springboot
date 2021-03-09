package com.codesplai.adaptacar.controllers;

import java.util.ArrayList;
import com.codesplai.adaptacar.models.Puntuacion;
import com.codesplai.adaptacar.repositories.PuntuacionRepository;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/puntuaciones")
public class PuntuacionController {
    private final PuntuacionRepository puntuacionRepository;

    PuntuacionController(PuntuacionRepository repository) {
        this.puntuacionRepository = repository;
    }

    @GetMapping()
    public ArrayList<Puntuacion> obtenerPuntuaciones() {
        return (ArrayList<Puntuacion>) puntuacionRepository.findAll();
    }

    @GetMapping("/{id}")
    public Puntuacion one(@PathVariable Integer id) {
        return puntuacionRepository.findById(id).get();
    }

    @PostMapping
    public Puntuacion guardarLensajeria(@RequestBody Puntuacion puntuacion) {
        return puntuacionRepository.save(puntuacion);
    }
}
