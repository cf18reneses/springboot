package com.codesplai.adaptacar.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.codesplai.adaptacar.models.Adaptaciones;
import com.codesplai.adaptacar.repositories.AdaptacionesRepository;

import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api")

public class AdaptacionesController {

    private final AdaptacionesRepository adaptacionesRepository;
    EntityManager em;

    AdaptacionesController(AdaptacionesRepository repository) {
        this.adaptacionesRepository = repository;
    }

    @GetMapping("/adaptaciones")
    public ArrayList<Adaptaciones> obtenerUsers() {
        return (ArrayList<Adaptaciones>) adaptacionesRepository.findAll();
    }

    @GetMapping("/adaptacion/{id}")
    public Adaptaciones one(@PathVariable Integer id) {
        return adaptacionesRepository.findById(id).get();
    }

    @GetMapping("adaptaciones/get")
	public List<Adaptaciones> getData(
        @RequestParam(required=false,name="idadaptacion") Integer idadaptacion,
			@RequestParam(value="codigo",required=false) String codigo,
            @RequestParam(required=false) String subcodigo
           	)
	{		
		HashMap<String, Object> data=new HashMap<>();
		
		if (idadaptacion!=null)
			data.put("idadaptacion",idadaptacion);
		if (codigo!=null)
			data.put("codigo",codigo);
		if (subcodigo!=null)
            data.put("subcodigo",subcodigo);
        return adaptacionesRepository.getData(data);	
    }	
		
    @GetMapping("adaptacions/getQuery")
	public List<Adaptaciones> getDataQuery(
			@RequestParam(required=false,name="idadaptacion") Integer idadaptacion,
			@RequestParam(value="codigo",required=false) String codigo,
            @RequestParam(required=false) String subcodigo
           	)
	{		
        String sql="select a from adaptaciones a where 1=1";
        //String sql = "SELECT p.idpost FROM post p INNER JOIN post_has_adaptaciones pha ON pha.post_idpost = p.idpost INNER JOIN adaptaciones a ON a.idadaptacion = pha.adaptaciones_idadaptacion where pha.adaptaciones_idadaptacion = 359";
        
		//Esto devuelve solo el id de los posts que tienen una adaptacion cuyo id = 359. A partir de aqui se podria hacer un select del post por su id para tener la info completa
        if (idadaptacion!=null)
			sql+=" and e.idadaptacion = :idadaptacion";
		if (codigo!=null)
			sql+=" and e.codigo = :codigo";
		if (subcodigo!=null)
            sql+=" and e.subcodigo = :subcodigo";
		
		TypedQuery<Adaptaciones> query= em.createQuery(sql,Adaptaciones.class);
		if (idadaptacion!=null)
			query.setParameter("idadaptacion", idadaptacion);
		if (codigo!=null)
			query.setParameter("codigo", codigo);
		if (subcodigo!=null)
			query.setParameter("subcodigo", subcodigo);
		return query.getResultList();			
	}
}
