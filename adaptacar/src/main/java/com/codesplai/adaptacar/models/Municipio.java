package com.codesplai.adaptacar.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name="municipios")
public class Municipio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "municipio")
    private String municipio;
    @Column(name = "latitud")
    private String latitud;
    @Column(name = "longitud")
    private String longitud;

    @ManyToOne(fetch = FetchType.EAGER)
    @NotFound(action=NotFoundAction.IGNORE)
    @JoinColumn(name = "provincia_id")
    private Provincias provincia;

    @JsonIgnore
    @OneToMany(cascade=CascadeType.ALL, mappedBy = "municipio")
    private List<Post> posts = new ArrayList<>();

    public Municipio(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public Provincias getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincias provincia) {
        this.provincia = provincia;
    }

    
}
