package com.codesplai.adaptacar.controllers;

import java.util.ArrayList;
import com.codesplai.adaptacar.models.Mensajeria;
import com.codesplai.adaptacar.repositories.MensajeriaRepository;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/mensajes")
public class MensajeriaController {
    private final MensajeriaRepository mensajeriaRepository;

    MensajeriaController(MensajeriaRepository repository) {
        this.mensajeriaRepository = repository;
    }

    @GetMapping()
    public ArrayList<Mensajeria> obtenerMensajerias() {
        return (ArrayList<Mensajeria>) mensajeriaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Mensajeria one(@PathVariable Integer id) {
        return mensajeriaRepository.findById(id).get();
    }

    @PostMapping
    public Mensajeria guardarLensajeria(@RequestBody Mensajeria mensajeria) {
        return mensajeriaRepository.save(mensajeria);
    }
}
