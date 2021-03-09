package com.codesplai.adaptacar.controllers;

import java.util.*;

import com.codesplai.adaptacar.models.Usuario;
import com.codesplai.adaptacar.repositories.UsuarioRepository;

import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class UsuarioController {
    private final UsuarioRepository usuarioRepository;
    EntityManager em;

    public static final String GREATER_THAN="greater";
	public static final String LESS_THAN="less";
	public static final String EQUAL="equal";

    UsuarioController(UsuarioRepository repository) {
        this.usuarioRepository = repository;
    }

    @GetMapping("/usuarios")
    public ArrayList<Usuario> obtenerUsers() {
        return (ArrayList<Usuario>) usuarioRepository.findAll();
    }

    @GetMapping("/usuario/{id}")
    public Usuario one(@PathVariable Integer id) {
        return usuarioRepository.findById(id).get();
    }

    @PostMapping("/usuarios")
    public Usuario guardarUsuario(@RequestBody Usuario user) {
        return usuarioRepository.save(user);
    }

    @DeleteMapping(value = "usuario/{id}")
    public String eliminarPorId(@PathVariable("id") Integer id) {
        try {
            usuarioRepository.deleteById(id);
            return "El usuario con id: " + id + " ha sido eliminado";
        } catch (Exception e) {
            return "No se pudo eliminar el usuario";
        }
    }

    @PutMapping("usuario/{id}")
    Optional<Object> modificarUsuario(@RequestBody Usuario nuevoUsuario, @PathVariable Integer id) {
  
      return usuarioRepository.findById(id)
        .map(usuario -> {
          usuario.setNombre(nuevoUsuario.getNombre());
          usuario.setApellido(nuevoUsuario.getApellido());
          usuario.setEmail(nuevoUsuario.getEmail());
          usuario.setTelefono(nuevoUsuario.getTelefono());
          return usuarioRepository.save(usuario);
        });
    }

    @GetMapping("usuarios/get")
	public List<Usuario> getData(
            @RequestParam(required=false,name="idusuario") Integer idusuario,
			@RequestParam(value="nombre",required=false) String nombre,
            @RequestParam(required=false) String apellido,
            @RequestParam(required=false) String telefono,
            @RequestParam(required=false) String email		)
	{		
		HashMap<String, Object> data=new HashMap<>();
		
		if (idusuario!=null)
			data.put("idusuario",idusuario);
		if (nombre!=null)
			data.put("nombre",nombre);
		if (apellido!=null)
            data.put("apellido",apellido);
        if (telefono!=null)
            data.put("telefono",telefono);
        if (email!=null)
			data.put("email",email);	
        return usuarioRepository.getData(data);	
    }	
		
    @GetMapping("usuarios/getQuery")
	public List<Usuario> getDataQuery(
			@RequestParam(required=false,name="idusuario") Integer idusuario,
			@RequestParam(value="nombre",required=false) String nombre,
            @RequestParam(required=false) String apellido,
            @RequestParam(required=false) String telefono,
            @RequestParam(required=false) String email			)
	{		
        String sql="select e from Usuario e where 1=1";
        //String sql = "SELECT p.idpost FROM post p INNER JOIN post_has_adaptaciones pha ON pha.post_idpost = p.idpost INNER JOIN adaptaciones a ON a.idadaptacion = pha.adaptaciones_idadaptacion where pha.adaptaciones_idadaptacion = 359";
        
		//Esto devuelve solo el id de los posts que tienen una adaptacion cuyo id = 359. A partir de aqui se podria hacer un select del post por su id para tener la info completa
        if (idusuario!=null)
			sql+=" and e.idusuario = :idusuario";
		if (nombre!=null)
			sql+=" and e.nombre = :nombre";
		if (apellido!=null)
            sql+=" and e.apellido = :apellido";
		if (telefono!=null)
            sql+=" and e.telefono = :telefono";
		if (email!=null)
            sql+=" and e.email = :email";
		
		TypedQuery<Usuario> query= em.createQuery(sql,Usuario.class);
		if (idusuario!=null)
			query.setParameter("idusuario", idusuario);
		if (nombre!=null)
			query.setParameter("nombre", nombre);
		if (apellido!=null)
			query.setParameter("apellido", apellido);
		if (telefono!=null)
			query.setParameter("telefono", telefono);
        if (email!=null)
            query.setParameter("email", email);
		return query.getResultList();			
	}
}