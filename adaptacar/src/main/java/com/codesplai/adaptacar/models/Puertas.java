package com.codesplai.adaptacar.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "puertas")
public class Puertas implements Serializable {
 
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "idpuertas")
    private Integer id;
    @Column(name = "numero_puertas")
    private String puertas;
    @JsonIgnore
    @OneToMany(mappedBy = "puertas")
    private List<Post> posts = new ArrayList<>();

    public Puertas(){}

    public Puertas(Integer id, String puertas) {
        this.id = id;
        this.puertas = puertas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPuertas() {
        return puertas;
    }

    public void setPuertas(String puertas) {
        this.puertas = puertas;
    }
}