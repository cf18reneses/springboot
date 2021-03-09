package com.codesplai.adaptacar.controllers;

import java.util.ArrayList;

import com.codesplai.adaptacar.models.Motor;
import com.codesplai.adaptacar.repositories.MotorRepository;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/motores")
public class MotorController {
    private final MotorRepository motorRepository;

    MotorController(MotorRepository repository) {
        this.motorRepository = repository;
    }

    @GetMapping()
    public ArrayList<Motor> obtenerMotor() {
        return (ArrayList<Motor>) motorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Motor one(@PathVariable Integer id) {
        return motorRepository.findById(id).get();
    }
}