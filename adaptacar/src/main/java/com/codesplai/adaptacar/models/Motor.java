package com.codesplai.adaptacar.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "motor")
public class Motor implements Serializable {
 
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  
    @Column(name = "idmotor")
    private Integer id;
    @Column(name = "cilindrada")
    private String cilindrada;
    @JsonIgnore
    @OneToMany(cascade=CascadeType.ALL, mappedBy = "motor")
    private List<Post> posts = new ArrayList<>();

    public Motor(){}

    public Motor(Integer id, String cilindrada) {
        this.id = id;
        this.cilindrada = cilindrada;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(String cilindrada) {
        this.cilindrada = cilindrada;
    }
}