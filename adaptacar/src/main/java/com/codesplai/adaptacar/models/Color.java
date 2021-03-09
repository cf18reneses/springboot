package com.codesplai.adaptacar.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "color")
public class Color implements Serializable {
 
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  
    @Column(name = "idcolor")
    private Integer id;
    @Column(name = "nombre")
    private String nombre;
    @JsonIgnore
    @OneToMany(mappedBy = "color")
    private List<Post> posts = new ArrayList<>();

    public Color(){}

    public Color(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // public List<Post> getPosts() {
    //     return posts;
    // }

    // public void setPosts(List<Post> posts) {
    //     this.posts = posts;
    // }
}
