package com.codesplai.adaptacar.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "traccion")
public class Traccion implements Serializable {
 
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "idtraccion")
    private Integer id;
    @Column(name = "tipo_traccion")
    private String tipo_traccion;
    @JsonIgnore
    @OneToMany(mappedBy = "traccion")
    private List<Post> posts = new ArrayList<>();

    public Traccion(){}

    public Traccion(Integer id, String tipo_traccion) {
        this.id = id;
        this.tipo_traccion = tipo_traccion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoTraccion() {
        return tipo_traccion;
    }

    public void setTipoTraccion(String tipo_craccion) {
        this.tipo_traccion = tipo_craccion;
    }
}