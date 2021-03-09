package com.codesplai.adaptacar.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "plazas")
public class Plazas implements Serializable {
 
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "idplazas")
    private Integer id;
    @Column(name = "numero_plazas")
    private String plazas;
    @JsonIgnore
    @OneToMany(mappedBy = "plazas")
    private List<Post> posts = new ArrayList<>();

    public Plazas(){}

    public Plazas(Integer id, String plazas) {
        this.id = id;
        this.plazas = plazas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlazas() {
        return plazas;
    }

    public void setPlazas(String plazas) {
        this.plazas = plazas;
    }
}