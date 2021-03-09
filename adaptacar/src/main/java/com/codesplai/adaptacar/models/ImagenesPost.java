package com.codesplai.adaptacar.models;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="fotos")
public class ImagenesPost implements Serializable {

    private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idfotos")
	private Integer id;
	
	@Column(name = "url_foto")
    private String urlFoto;
    
    @Column(name = "post_idpost")
	private String idpost;

	public ImagenesPost(){}

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

    public String getIdpost() {
        return idpost;
    }

    public void setIdpost(String idpost) {
        this.idpost = idpost;
    }
    
    
}