package com.codesplai.adaptacar.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name = "post")
public class Post implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpost")
    private int id;

    @JoinTable(name="usuario_has_post",
    joinColumns = @JoinColumn(name = "post_idpost", nullable = false),
    inverseJoinColumns = @JoinColumn(name="usuario_idusuario", nullable = false))
    
    @Column(name = "precio")
    private int precio;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fecha_publicacion")
    private String fecha_publi;
    @Column(name = "anyo")
    private String anyo;
    @Column(name = "kilometros")
    private int kms;
    @Column(name = "cv")
    private int cv;
    @Column(name = "embrague")
    private Boolean embrague;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotFound(action=NotFoundAction.IGNORE)
    @JoinColumn(name = "municipio_idmunicipio")
    private Municipio municipio;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @NotFound(action=NotFoundAction.IGNORE)
    @JoinColumn(name = "motor_idmotor")
    private Motor motor;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotFound(action=NotFoundAction.IGNORE)
    @JoinColumn(name = "combustible_idcombustible")
    private Combustible combustible;
   
    @ManyToOne(fetch = FetchType.LAZY)
    @NotFound(action=NotFoundAction.IGNORE)
    @JoinColumn(name = "traccion_idtraccion")
    private Traccion traccion = new Traccion();
    
    @ManyToOne(fetch = FetchType.LAZY)
    @NotFound(action=NotFoundAction.IGNORE)
    @JoinColumn(name = "carroceria_idcarroceria")
    private Carroceria carroceria = new Carroceria();
    
    @ManyToOne(fetch = FetchType.LAZY)
    @NotFound(action=NotFoundAction.IGNORE)
    @JoinColumn(name = "puertas_idpuertas")
    private Puertas puertas;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @NotFound(action=NotFoundAction.IGNORE)
    @JoinColumn(name = "plazas_idplazas")
    private Plazas plazas;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @NotFound(action=NotFoundAction.IGNORE)
    @JoinColumn(name = "coche_idcoche")
    private Coche coche;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @NotFound(action=NotFoundAction.IGNORE)
    @JoinColumn(name = "color_idcolor")
    private Color color = new Color();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private List <Imagen> imagenes = new ArrayList<Imagen>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "post_has_adaptaciones",
                joinColumns = { @JoinColumn(name = "post_idpost", referencedColumnName = "idpost") }, 
                inverseJoinColumns = { @JoinColumn(name="adaptaciones_idadaptacion", referencedColumnName = "idadaptacion") })
    private List<Adaptaciones> adaptaciones = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "usuario_has_post",
                joinColumns = { @JoinColumn(name = "post_idpost") }, 
                inverseJoinColumns = { @JoinColumn(name="usuario_idusuario") })
    private List<Usuario> usuarios = new ArrayList<>();

    public Post(){}
    
    public Post(Integer id, 
                Integer precio, 
                String descripcion, 
                String fecha_publi, 
                String anyo, 
                Municipio municipio, 
                Integer kms, 
                Boolean embrague,
                Motor motor, 
                Integer cv, 
                Combustible combustible, 
                Traccion traccion, 
                Carroceria carroceria, 
                Color color, 
                Puertas puertas, 
                Plazas plazas, 
                Coche coche) {
        this.id = id;
        this.precio = precio;
        this.descripcion = descripcion;
        this.fecha_publi = fecha_publi;
        this.anyo = anyo;
        this.municipio = municipio;
        this.kms = kms;
        this.cv = cv;
        this.motor = motor;
        this.embrague = embrague;
        this.combustible = combustible;
        this.traccion = traccion;
        this.carroceria = carroceria;
        this.color = color;
        this.puertas = puertas;
        this.plazas = plazas;
        this.coche = coche;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha_publi() {
        return fecha_publi;
    }

    public void setFecha_publi(String fecha_publi) {
        this.fecha_publi = fecha_publi;
    }

    public String getAnyo() {
        return anyo;
    }

    public void setAnyo(String anyo) {
        this.anyo = anyo;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public int getKms() {
        return kms;
    }

    public void setKms(int kms) {
        this.kms = kms;
    }

    public int getCv() {
        return cv;
    }

    public void setCv(int cv) {
        this.cv = cv;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public Boolean getEmbrague() {
        return embrague;
    }

    public void setEmbrague(Boolean embrague) {
        this.embrague = embrague;
    }

    public Combustible getCombustible() {
        return combustible;
    }

    public void setCombustible(Combustible combustible) {
        this.combustible = combustible;
    }

    public Traccion getTraccion() {
        return traccion;
    }

    public void setTraccion(Traccion traccion) {
        this.traccion = traccion;
    }

    public Carroceria getCarroceria() {
        return carroceria;
    }

    public void setCarroceria(Carroceria carroceria) {
        this.carroceria = carroceria;
    }

    public Puertas getPuertas() {
        return puertas;
    }

    public void setPuertas(Puertas puertas) {
        this.puertas = puertas;
    }

    public Plazas getPlazas() {
        return plazas;
    }

    public void setPlazas(Plazas plazas) {
        this.plazas = plazas;
    }

    public Coche getCoche() {
        return coche;
    }

    public void setCoche(Coche coche) {
        this.coche = coche;
    }

    @Override
    public String toString() {
        return "Post [anyo=" + anyo + ", carroceria=" + carroceria + ", coche=" + coche + ", color=" + color
                + ", combustible=" + combustible + ", cv=" + cv + ", descripcion=" + descripcion + ", embrague="
                + embrague + ", fecha_publi=" + fecha_publi + ", id=" + id + ", kms=" + kms + ", motor=" + motor
                + ", municipio=" + municipio + ", plazas=" + plazas + ", precio=" + precio + ", puertas=" + puertas
                + ", traccion=" + traccion + "]";
    }

    public List<Adaptaciones> getAdaptaciones() {
        return adaptaciones;
    }

    public void setAdaptaciones(List<Adaptaciones> adaptaciones) {
        this.adaptaciones = adaptaciones;
    }

    public List<Imagen> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<Imagen> imagenes) {
        this.imagenes = imagenes;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
