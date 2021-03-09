package com.codesplai.adaptacar.dto;

import java.util.List;

import com.codesplai.adaptacar.models.Carroceria;
import com.codesplai.adaptacar.models.Coche;
import com.codesplai.adaptacar.models.Color;
import com.codesplai.adaptacar.models.Combustible;
import com.codesplai.adaptacar.models.Motor;
import com.codesplai.adaptacar.models.Municipio;
import com.codesplai.adaptacar.models.Plazas;
import com.codesplai.adaptacar.models.Puertas;
import com.codesplai.adaptacar.models.Traccion;

import org.springframework.web.multipart.MultipartFile;

public class PostDto {
    
    //TABLA POST
    private int idPost;
    private int precio;
    private String descripcion;
    private String fecha_publi;
    private String anyo;
    private Municipio municipio;
    private int kms;
    private int cv;
    private Motor motorCC;
    private Boolean embrague;
    private Combustible combustible;
    private Traccion traccion;
    private Carroceria carroceria;
    private Color color;
    private Puertas puertas;
    private Plazas plazas;
    private Coche idcoche;

    //TABLA FOTOS
    private Integer idFoto;
    private String urlFoto;
    //KEY postman = imagen
    List<MultipartFile> imagenes;

    //TABLA ADAPTACIONES
    private List<Integer> adaptaciones;

    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha_publi() {
        return fecha_publi;
    }

    public void setFecha_publi(String fecha_publi) {
        this.fecha_publi = fecha_publi;
    }

    public String getAnyo() {
        return anyo;
    }

    public void setAnyo(String anyo) {
        this.anyo = anyo;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public int getKms() {
        return kms;
    }

    public void setKms(int kms) {
        this.kms = kms;
    }

    public int getCv() {
        return cv;
    }

    public void setCv(int cv) {
        this.cv = cv;
    }

    public Motor getMotorCC() {
        return motorCC;
    }

    public void setMotorCC(Motor motorCC) {
        this.motorCC = motorCC;
    }

    public Boolean getEmbrague() {
        return embrague;
    }

    public void setEmbrague(Boolean embrague) {
        this.embrague = embrague;
    }

    public Combustible getCombustible() {
        return combustible;
    }

    public void setCombustible(Combustible combustible) {
        this.combustible = combustible;
    }

    public Traccion getTraccion() {
        return traccion;
    }

    public void setTraccion(Traccion traccion) {
        this.traccion = traccion;
    }

    public Carroceria getCarroceria() {
        return carroceria;
    }

    public void setCarroceria(Carroceria carroceria) {
        this.carroceria = carroceria;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Puertas getPuertas() {
        return puertas;
    }

    public void setPuertas(Puertas puertas) {
        this.puertas = puertas;
    }

    public Plazas getPlazas() {
        return plazas;
    }

    public void setPlazas(Plazas plazas) {
        this.plazas = plazas;
    }

    public Coche getIdcoche() {
        return idcoche;
    }

    public void setIdcoche(Coche idcoche) {
        this.idcoche = idcoche;
    }

    public Integer getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(Integer idFoto) {
        this.idFoto = idFoto;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public List<MultipartFile> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<MultipartFile> imagenes) {
        this.imagenes = imagenes;
    }

    public List<Integer> getAdaptaciones() {
        return adaptaciones;
    }

    public void setAdaptaciones(List<Integer> adaptaciones) {
        this.adaptaciones = adaptaciones;
    }

    @Override
    public String toString() {
        return "PostDto [adaptaciones=" + adaptaciones + ", anyo=" + anyo + ", carroceria=" + carroceria + ", color="
                + color + ", combustible=" + combustible + ", cv=" + cv + ", descripcion=" + descripcion + ", embrague="
                + embrague + ", fecha_publi=" + fecha_publi + ", idFoto=" + idFoto + ", idPost=" + idPost + ", idcoche="
                + idcoche + ", imagenes=" + imagenes + ", kms=" + kms + ", motorCC=" + motorCC + ", municipio="
                + municipio + ", plazas=" + plazas + ", precio=" + precio + ", puertas=" + puertas + ", traccion="
                + traccion + ", urlFoto=" + urlFoto + "]";
    }
}
