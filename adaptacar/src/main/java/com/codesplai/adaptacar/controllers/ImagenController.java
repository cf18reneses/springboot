package com.codesplai.adaptacar.controllers;

import java.nio.file.*;
import java.util.ArrayList;
import com.codesplai.adaptacar.models.Imagen;
import com.codesplai.adaptacar.repositories.ImagenRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ImagenController {

    private final ImagenRepository imagenRepository;

    ImagenController(ImagenRepository repository) {
        this.imagenRepository = repository;
    }

    @GetMapping("/imagenes")
    public ArrayList<Imagen> obtenerImagen() {
        return (ArrayList<Imagen>) imagenRepository.findAll();
    }

    @PostMapping("/guardar")
    public String guardar(@RequestParam("file") MultipartFile imagen){
        if(!imagen.isEmpty()){
            Path directorioImagenes = Paths.get("src//main//resources//static/images");
            String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();
            try {
                byte[] bytesImg = imagen.getBytes();
                Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + imagen.getOriginalFilename());
                Files.write(rutaCompleta, bytesImg);
                Imagen img = new Imagen();
                img.setUrlFoto(imagen.getOriginalFilename());
                imagenRepository.save(img);
                return "Foto guardada con exito!";
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "Error";
    }
}
