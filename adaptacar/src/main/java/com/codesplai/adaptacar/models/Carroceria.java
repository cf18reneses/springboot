package com.codesplai.adaptacar.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "carroceria")
public class Carroceria implements Serializable {
 
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "idcarroceria")
    private Integer id;
    @Column(name = "tipo_carroceria")
    private String tipo_carroceria;
    @JsonIgnore
    @OneToMany(cascade=CascadeType.ALL, mappedBy = "traccion")
    private List<Post> posts = new ArrayList<>();


    public Carroceria(){}

    public Carroceria(Integer id, String tipo_carroceria) {
        this.id = id;
        this.tipo_carroceria = tipo_carroceria;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoCarroceria() {
        return tipo_carroceria;
    }

    public void setTipoCarroceria(String tipo_carroceria) {
        this.tipo_carroceria = tipo_carroceria;
    }
}