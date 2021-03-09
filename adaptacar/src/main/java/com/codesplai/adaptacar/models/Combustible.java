package com.codesplai.adaptacar.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "combustible")
public class Combustible implements Serializable {
 
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "idcombustible")
    private Integer id;
    @Column(name = "tipo_combustible")
    private String tipo_combustible;
    @JsonIgnore
    @OneToMany(mappedBy = "combustible")
    private List<Post> posts = new ArrayList<>();

    public Combustible(){}

    public Combustible(Integer id, String tipo_combustible) {
        this.id = id;
        this.tipo_combustible = tipo_combustible;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoCombustible() {
        return tipo_combustible;
    }

    public void setTipoCombustible(String tipo_combustible) {
        this.tipo_combustible = tipo_combustible;
    }
}