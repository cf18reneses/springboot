package com.codesplai.adaptacar.models;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "mensajeria")
public class Mensajeria implements Serializable {
 
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmensajeria")
    private Integer id;
    @Column(name = "mensaje_emisor")
    private String mensaje_emisor;
    @Column(name = "mensaje_receptor")
    private String mensaje_receptor;
    @Column(name = "fecha_envio")
    private String fecha_envio;

    public Mensajeria(){}

    public Mensajeria(Integer id, String mensaje_emisor, String mensaje_receptor, String fecha_envio) {
        this.id = id;
        this.mensaje_emisor = mensaje_emisor;
        this.mensaje_receptor = mensaje_receptor;
        this.fecha_envio = fecha_envio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMensaje_emisor() {
        return mensaje_emisor;
    }

    public void setMensaje_emisor(String mensaje_emisor) {
        this.mensaje_emisor = mensaje_emisor;
    }

    public String getMensaje_receptor() {
        return mensaje_receptor;
    }

    public void setMensaje_receptor(String mensaje_receptor) {
        this.mensaje_receptor = mensaje_receptor;
    }

    public String getFecha_envio() {
        return fecha_envio;
    }

    public void setFecha_envio(String fecha_envio) {
        this.fecha_envio = fecha_envio;
    }
}
