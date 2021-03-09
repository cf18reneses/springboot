package com.codesplai.adaptacar.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "provincias")
public class Provincias implements Serializable {
 
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "provincia")
    private String provincia;
    @Column(name = "comunidad_id")
    private Integer comunidad_id;
    @Column(name = "slug")
    private String slug;
    @Column(name = "capital_id")
    private Integer capital_id;
    @JsonIgnore
    @OneToMany(cascade=CascadeType.ALL, mappedBy = "provincia")
    private List<Municipio> posts = new ArrayList<>();


    public Provincias(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public Integer getComunidad_id() {
        return comunidad_id;
    }

    public void setComunidad_id(Integer comunidad_id) {
        this.comunidad_id = comunidad_id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Integer getCapital_id() {
        return capital_id;
    }

    public void setCapital_id(Integer capital_id) {
        this.capital_id = capital_id;
    }
}
