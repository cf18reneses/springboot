package com.codesplai.adaptacar.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.codesplai.adaptacar.dto.PostDto;
import com.codesplai.adaptacar.models.Post;
import com.codesplai.adaptacar.repositories.PostRepository;
import com.codesplai.adaptacar.service.PostService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class PostController {
    EntityManager em;

    public static final String GREATER_THAN = "greater";
    public static final String LESS_THAN = "less";
    public static final String EQUAL = "equal";

    private static final Logger LOGGER = LoggerFactory.getLogger(PostController.class);

    private final PostService postService;
    private final PostRepository postRepository;

    PostController(PostRepository repository, PostService postService) {
        this.postRepository = repository;
        this.postService = postService;
    }

    @GetMapping("/posts")
    public ArrayList<Post> obtenerPosts() {
        return (ArrayList<Post>) postRepository.findAll();
    }

    @GetMapping("post/{id}")
    public Post one(@PathVariable Integer id) {
        return postRepository.findById(id).get();
    }

    @GetMapping("/postsporadaptaciones/{ids}")
    public List<Post> filtrarPostPorAdaptaciones(@PathVariable Integer[] ids) {
        return postRepository.findByAllAdaptaciones(ids);
    }

    @GetMapping("/postsporkeyword/{keyword}")
    public List<Post> filtrarPostsBykeyword(@PathVariable String keyword) {
        return postRepository.findPostsByKeyword(keyword);
    }

    @GetMapping("/postspormodelo/{modelo}")
    public List<Post> filtrarPostsByModelo(@PathVariable String modelo) {
        return postRepository.findPostsByModelo(modelo);
    }

    @PostMapping("/posts")
    public String guardarPost(PostDto postDto) {
        LOGGER.info(">> guardarPost() postDto {}", postDto);

        String status = postService.guardar(postDto);

        LOGGER.info("<< guardarPost() status {}", status);
        return status;
    }

    @DeleteMapping(value = "post/{id}")
    public String eliminarPorId(@PathVariable("id") Integer id) {
        try {
            postRepository.deleteById(id);
            return "El post con id: " + id + " ha sido eliminado";
        } catch (Exception e) {
            return "No se pudo eliminar el post";
        }
    }

    @PutMapping("post/{id}")
    Optional<Object> modificarPost(@RequestBody PostDto nuevoPost, @PathVariable Integer id) {

        return postRepository.findById(id).map(post -> {
            post.setPrecio(nuevoPost.getPrecio());
            post.setDescripcion(nuevoPost.getDescripcion());
            post.setFecha_publi(nuevoPost.getFecha_publi());
            post.setAnyo(nuevoPost.getAnyo());
            post.setMunicipio(nuevoPost.getMunicipio());
            post.setKms(nuevoPost.getKms());
            post.setEmbrague(nuevoPost.getEmbrague());
            post.setMotor(nuevoPost.getMotorCC());
            post.setCv(nuevoPost.getCv());
            post.setCombustible(nuevoPost.getCombustible());
            post.setTraccion(nuevoPost.getTraccion());
            post.setCarroceria(nuevoPost.getCarroceria());
            post.setColor(nuevoPost.getColor());
            post.setPuertas(nuevoPost.getPuertas());
            post.setPlazas(nuevoPost.getPlazas());
            post.setCoche(nuevoPost.getIdcoche());
            return postRepository.save(post);
        });
    }

    @GetMapping("posts/get")
    public List<Post> getData(@RequestParam(required = false, name = "id") Integer id,
            @RequestParam(required = false, name = "kms") Integer kms, @RequestParam(required = false) String kmsCondition,
            @RequestParam(required = false, name = "embrague") Integer embrague,
            @RequestParam(required = false, name = "coche") Integer coche,
            @RequestParam(required = false, name = "combustible") Integer combustible,
            @RequestParam(required = false, name = "precio") Integer precio, @RequestParam(required =false) String precioCondition,
            @RequestParam(required = false, name = "anyo") Integer anyo, @RequestParam(required = false) String anyoCondition,
            @RequestParam(required = false, name = "traccion") Integer traccion,
            @RequestParam(required = false, name = "carroceria") Integer carroceria,
            @RequestParam(required = false, name = "motor") Integer motor,
            @RequestParam(required = false, name = "cv") Integer cv,@RequestParam(required = false) String cvCondition,
            @RequestParam(required = false, name = "puertas") Integer puertas,
            @RequestParam(required = false, name = "plazas") Integer plazas,
            @RequestParam(required = false, name = "fecha_publi") String fecha_publi, @RequestParam(required= false) String fecha_publiCondition,
            @RequestParam(value = "color", required = false) Integer color) {
        HashMap<String, Object> data = new HashMap<>();

        if (id != null)
            data.put("id", id);
        if (coche != null)
            data.put("coche", coche);

        if (kmsCondition == null)
            kmsCondition = GREATER_THAN;
        if (!kmsCondition.equals(GREATER_THAN) && !kmsCondition.equals(LESS_THAN) && !kmsCondition.equals(EQUAL))
            kmsCondition = GREATER_THAN;
        if (kms != null)
            data.put("kms", kms);
            data.put("kmsCondition", kmsCondition);
    
        if (embrague != null)
            data.put("embrague", embrague);

        if (color != null)
            data.put("color", color);

        if (combustible != null)
            data.put("combustible", combustible);

        if (anyoCondition == null)
            anyoCondition = GREATER_THAN;
        if (!anyoCondition.equals(GREATER_THAN) && !anyoCondition.equals(LESS_THAN) && !anyoCondition.equals(EQUAL))
            anyoCondition = GREATER_THAN;
        if (anyo!=null)
            data.put("anyo", anyo);
            data.put("anyoCondition", anyoCondition);

        if (traccion != null)
            data.put("traccion", traccion);

        if (carroceria != null)
            data.put("carroceria", carroceria);

        if (motor != null)
            data.put("motor", motor);
           
        if (puertas!=null)
            data.put("puertas", puertas);

        if (plazas!=null)
            data.put("plazas", plazas);
        
        if (fecha_publiCondition == null)
            fecha_publiCondition = GREATER_THAN;
        if (!fecha_publiCondition.equals(GREATER_THAN) && !fecha_publiCondition.equals(LESS_THAN) && !fecha_publiCondition.equals(EQUAL))
            fecha_publiCondition = GREATER_THAN;
        if (fecha_publi!=null)
            data.put("fecha_publi", fecha_publi);
            data.put("fecha_publiCondition", fecha_publiCondition);

        if (precioCondition == null)
            precioCondition = GREATER_THAN;
        if (!precioCondition.equals(GREATER_THAN) && !precioCondition.equals(LESS_THAN) && !precioCondition.equals(EQUAL))
            precioCondition = GREATER_THAN;
        if (precio!=null)
            data.put("precio", precio);
            data.put("precioCondition", precioCondition);

        if (cvCondition == null)
            cvCondition = GREATER_THAN;
        if (!cvCondition.equals(GREATER_THAN) && !cvCondition.equals(LESS_THAN) && !cvCondition.equals(EQUAL))
            cvCondition = GREATER_THAN;
        if (cv!=null)
            data.put("cv", cv);
            data.put("cvCondition", cvCondition);

        return postRepository.getData(data);
    }

    @GetMapping("posts/getQuery")
    public List<Post> getDataQuery(@RequestParam(required = false, name = "id") Integer id,
            @RequestParam(required = false) Integer kms, @RequestParam(required = false) String kmsCondition,
            @RequestParam(required = false, name = "embrague") Integer embrague,
            @RequestParam(required = false, name = "coche") Integer coche,
            @RequestParam(required = false, name = "precio") Integer precio, @RequestParam(required = false) String precioCondition,
            @RequestParam(required = false, name = "combustible") Integer combustible,
            @RequestParam(required = false, name = "traccion") Integer traccion,
            @RequestParam(required = false, name = "carroceria") Integer carroceria,
            @RequestParam(required = false, name = "motor") Integer motor,
            @RequestParam(required = false, name = "anyo") Integer anyo,@RequestParam(required = false) String anyoCondition,
            @RequestParam(required = false, name = "plazas") Integer plazas,
            @RequestParam(required = false, name = "puertas") Integer puertas,
            @RequestParam(required = false, name = "fecha_publi") Integer fecha_publi,@RequestParam(required = false) String fecha_publiCondition,
            @RequestParam(value = "color", required = false) Integer color)

    {
        String sql = "select e from post e where 1=1";
        if (id != null)
            sql += " and e.idpost = :id";
        if (coche != null)
            sql = " and e.coche_idcoche =:coche";
        if (embrague != null)
            sql += " and e.embrague = :embrague";
        if (combustible != null)
            sql += " and e.combustible = :combustible";
        if (traccion != null)
            sql += " and e.traccion = :traccion";
        if (color != null)
            sql += " and e.color_idcolor = :color";
        if (carroceria != null)
            sql += " and e.carroceria_idcarroceria = :carroceria";
        if (plazas != null)
            sql += " and e.plazas_idplazas = :plazas";
        if (puertas != null)
            sql += " and e.puertas_idpuertas = :puertas";
        if (kms != null)
            sql += " and e.kilometros = :kms";
        String kmsCond = "";
        if (kms != null)
            sql += " and e.kms " + kmsCond + " :kms";
        if (kmsCondition == null) {
            kmsCondition = GREATER_THAN;
            switch (kmsCondition) {
                case GREATER_THAN:
                    kmsCond = ">";
                    break;
                case LESS_THAN:
                    kmsCond = "<";
                    break;
                default:
                    kmsCond = "=";
            }
        }

        if (precio != null)
            sql += " and e.precio = :precio";

        String precioCond = "";
        if (precio != null)
            sql += " and e.precio " + precioCond + " :precio";
        if (precioCondition == null) {
            precioCondition = GREATER_THAN;
            switch (precioCondition) {
                case GREATER_THAN:
                    precioCond = ">";
                    break;
                case LESS_THAN:
                    precioCond = "<";
                    break;
                default:
                    precioCond = "=";
            }
        }

        if (motor != null)
        sql += " and e.motor_idmotor = :motor";

        if (anyo != null)
        sql += " and e.anyo = :anyo";

        String anyoCond = "";
        if (anyo != null)
            sql += " and e.anyo " + anyoCond + " :anyo";
        if (anyoCondition == null) {
            anyoCondition = GREATER_THAN;
            switch (anyoCondition) {
                case GREATER_THAN:
                    anyoCond = ">";
                    break;
                case LESS_THAN:
                    anyoCond = "<";
                    break;
                default:
                    anyoCond = "=";
            }
        }

        if (plazas != null)
            sql += " and e.plazas_idplazas = :plazas";

        if (puertas != null)
        sql += " and e.puertas_idpuertas = :puertas";
         
        if (fecha_publi != null)
            sql += " and e.fecha_publicacion = :fecha_publi";

        String fecha_publiCond = "";
        if (fecha_publi != null)
            sql += " and e.fecha_publi " + fecha_publiCond + " :fecha_publi";
        if (fecha_publiCondition == null) {
            fecha_publiCondition = GREATER_THAN;
            switch (fecha_publiCondition) {
                case GREATER_THAN:
                    fecha_publiCond = ">";
                    break;
                case LESS_THAN:
                    fecha_publiCond = "<";
                    break;
                default:
                    fecha_publiCond = "=";
            }
        }
        
        TypedQuery<Post> query = em.createQuery(sql, Post.class);
        if (id != null)
            query.setParameter("id", id);
        if (coche != null)
            query.setParameter("coche", coche);
        if (kms != null)
            query.setParameter("kms", kms);
        if (embrague != null)
            query.setParameter("embrague", embrague);
        if (embrague != null)
            query.setParameter("combustible", combustible);
        if (traccion != null)
            query.setParameter("traccion", traccion);
        if (color != null)
            query.setParameter("color", color);
        if (carroceria != null)
            query.setParameter("carroceria", carroceria);
        if (motor != null)
            query.setParameter("motor", motor);
        if (plazas != null)
            query.setParameter("plazas", plazas);
        if (puertas != null)
            query.setParameter("puertas", puertas);
        if (anyo != null)
            query.setParameter("anyo", anyo);
        if (fecha_publi != null)
            query.setParameter("fecha_publi", fecha_publi);
        if (precio != null)
            query.setParameter("precio", precio);
        return query.getResultList();
    }
}
