package com.codesplai.adaptacar.models;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "puntuacion")
public class Puntuacion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpuntuacion")
    private int id;
    @Column(name = "puntuacion_emisor")
    private String puntuacion_emisor;
    @Column(name = "puntuacion_receptor")
    private String puntuacion_receptor;
    @Column(name = "comentario")
    private String comentario;
    @Column(name = "usuario_idusuario")
    private String usuario_idusuario;

    public Puntuacion (){}
    
    public Puntuacion(int id, String puntuacion_emisor, String puntuacion_receptor, String comentario,
            String usuario_idusuario) {
        this.id = id;
        this.puntuacion_emisor = puntuacion_emisor;
        this.puntuacion_receptor = puntuacion_receptor;
        this.comentario = comentario;
        this.usuario_idusuario = usuario_idusuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPuntuacion_emisor() {
        return puntuacion_emisor;
    }

    public void setPuntuacion_emisor(String puntuacion_emisor) {
        this.puntuacion_emisor = puntuacion_emisor;
    }

    public String getPuntuacion_receptor() {
        return puntuacion_receptor;
    }

    public void setPuntuacion_receptor(String puntuacion_receptor) {
        this.puntuacion_receptor = puntuacion_receptor;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getUsuario_idusuario() {
        return usuario_idusuario;
    }

    public void setUsuario_idusuario(String usuario_idusuario) {
        this.usuario_idusuario = usuario_idusuario;
    }
}