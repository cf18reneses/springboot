package com.codesplai.adaptacar.controllers;

import java.util.ArrayList;

import com.codesplai.adaptacar.models.Coche;
import com.codesplai.adaptacar.repositories.CocheRepository;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CocheController {
    private final CocheRepository cocheRepository;
    EntityManager em;

    CocheController(CocheRepository repository) {
        this.cocheRepository = repository;
    }

    @GetMapping("/coches")
    public ArrayList<Coche> obtenerCoche() {
        return (ArrayList<Coche>) cocheRepository.findAll();
    }

    @GetMapping("coche/{id}")
    public Coche one(@PathVariable Integer id) {
        return cocheRepository.findById(id).get();
    }

    @GetMapping("coches/get")
	public List<Coche> getData(
            @RequestParam(required=false,name="idcoche") Integer idcoche,
			@RequestParam(value="marca",required=false) String marca,
            @RequestParam(required=false) String modelo	
            )
	{		
		HashMap<String, Object> data=new HashMap<>();
		
		if (idcoche!=null)
			data.put("idcoche",idcoche);
		if (marca!=null)
			data.put("marca",marca);
		if (modelo!=null)
            data.put("modelo",modelo);	
        return cocheRepository.getData(data);	
    }	
		
    @GetMapping("coches/getQuery")
	public List<Coche> getDataQuery(
			@RequestParam(required=false,name="idcoche") Integer idcoche,
			@RequestParam(value="marca",required=false) String marca,
            @RequestParam(required=false) String modelo
        	)
	{		
        String sql="select e from coche e where 1=1";
        //SELECT p.idpost FROM post p INNER JOIN post_has_adaptaciones pha ON pha.post_idpost = p.idpost INNER JOIN adaptaciones a ON a.idadaptacion = pha.adaptaciones_idadaptacion where pha.adaptaciones_idadaptacion = 359;
		//Esto devuelve solo el id de los posts que tienen una adaptacion cuyo id = 359. A partir de aqui se podria hacer un select del post por su id para tener la info completa
        if (idcoche!=null)
			sql+=" and e.idcoche = :idcoche";
		if (marca!=null)
			sql+=" and e.marca = :marca";
		if (modelo!=null)
            sql+=" and e.modelo = :modelo";
		
		TypedQuery<Coche> query= em.createQuery(sql,Coche.class);
		if (idcoche!=null)
			query.setParameter("idcoche", idcoche);
		if (marca!=null)
			query.setParameter("marca", marca);
		if (modelo!=null)
			query.setParameter("modelo", modelo);
		return query.getResultList();			
	}
}