package com.codesplai.adaptacar.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "adaptaciones")
public class Adaptaciones implements Serializable{

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idadaptacion")
    private int id;
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "subcodigo")
    private String subcodigo;
    @Column(name = "descripcion")
    private String descripcion;
    
    @ManyToMany(mappedBy = "adaptaciones", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Post> post = new ArrayList<>();

    public Adaptaciones(){}

    public String getCodigo() {
        return codigo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getSubcodigo() {
        return subcodigo;
    }

    public void setSubcodigo(String subcodigo) {
        this.subcodigo = subcodigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Adaptaciones(int id, String codigo, String subcodigo, String descripcion) {
        this.setId(id);
        this.codigo = codigo;
        this.subcodigo = subcodigo;
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Adaptaciones [codigo=" + codigo + ", descripcion=" + descripcion + ", id=" + id + ", subcodigo="
                + subcodigo + "]";
    }

    public List<Post> getPost() {
        return post;
    }

    public void setPost(List<Post> post) {
        this.post = post;
    }

    



}
