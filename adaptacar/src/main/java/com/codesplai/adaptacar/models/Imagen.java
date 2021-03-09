package com.codesplai.adaptacar.models;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name="fotos")
public class Imagen implements Serializable {

    private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idfotos")
	private Integer id;
	
	@Column(name = "url_foto")
	private String urlFoto;

	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
	@NotFound(action=NotFoundAction.IGNORE)
	@JsonIgnore
    @JoinColumn(name = "post_idpost")
	private Post post;

	public Imagen(){}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUrlFoto() {
		return urlFoto;
	}

	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	@Override
	public String toString() {
		return "Imagen [id=" + id + ", post=" + post + ", urlFoto=" + urlFoto + "]";
	}

	



}