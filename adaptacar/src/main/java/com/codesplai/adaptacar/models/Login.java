package com.codesplai.adaptacar.models;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "login")
public class Login implements Serializable {
 
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idlogin")
    private Integer id;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "contrasenya")
    private String contrasenya;
    @Column(name = "usuario_idusuario")
    private Integer usuario_idusuario;

    public Login(){}
    
    public Login(Integer id, String usuario, String contrasenya, Integer usuario_idusuario) {
        this.id = id;
        this.usuario = usuario;
        this.contrasenya = contrasenya;
        this.usuario_idusuario = usuario_idusuario;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenya() {
		return contrasenya;
	}

	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}

	public Integer getUsuario_idusuario() {
		return usuario_idusuario;
	}

	public void setUsuario_idusuario(Integer usuario_idusuario) {
		this.usuario_idusuario = usuario_idusuario;
    }
}