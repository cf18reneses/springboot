package com.codesplai.adaptacar.models;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "post_has_adaptaciones")
@IdClass(PostAdaptaciones.class)
public class PostAdaptaciones implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @JoinColumn(name = "post_idpost", referencedColumnName = "idpost")
    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;
    
    @JoinColumn(name = "adaptaciones_idadaptacion", referencedColumnName = "idadaptacion")
    @ManyToOne(fetch = FetchType.LAZY)
    private Adaptaciones adaptaciones;

    public PostAdaptaciones(){}

    public PostAdaptaciones(Post post, Adaptaciones adaptaciones) {
        this.post = post;
        this.adaptaciones = adaptaciones;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Adaptaciones getAdaptaciones() {
        return adaptaciones;
    }

    public void setAdaptaciones(Adaptaciones adaptaciones) {
        this.adaptaciones = adaptaciones;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PostAdaptaciones [adaptaciones=" + adaptaciones + ", id=" + id + ", post=" + post + "]";
    }
}
