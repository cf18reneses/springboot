package com.codesplai.adaptacar.controllers;

import java.util.ArrayList;
import java.util.Optional;
import com.codesplai.adaptacar.models.Login;
import com.codesplai.adaptacar.repositories.LoginRepository;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/logins")
public class LoginController {
    private final LoginRepository loginRepository;

    LoginController(LoginRepository repository) {
        this.loginRepository = repository;
    }

    @GetMapping()
    public ArrayList<Login> obtenerLogins() {
        return (ArrayList<Login>) loginRepository.findAll();
    }

    @GetMapping("/{id}")
    public Login one(@PathVariable Integer id) {
        return loginRepository.findById(id).get();
    }

    @PostMapping
    public Login guardarLogin(@RequestBody Login login) {
        return loginRepository.save(login);
    }

    @DeleteMapping(value = "/{id}")
    public String eliminarPorId(@PathVariable("id") Integer id) {
        try {
            loginRepository.deleteById(id);
            return "El Login con id: " + id + " ha sido eliminado";
        } catch (Exception e) {
            return "No se pudo eliminar el Login";
        }
    }

    @PutMapping("/{id}")
    Optional<Object> modificarLogin(@RequestBody Login nuevoLogin, @PathVariable Integer id) {
  
      return loginRepository.findById(id)
        .map(login -> {
          login.setUsuario(nuevoLogin.getUsuario());
          login.setContrasenya(nuevoLogin.getContrasenya());
          login.setUsuario_idusuario(nuevoLogin.getUsuario_idusuario());
          return loginRepository.save(login);
        });
    }
}
