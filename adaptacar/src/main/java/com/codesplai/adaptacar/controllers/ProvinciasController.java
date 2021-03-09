package com.codesplai.adaptacar.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.codesplai.adaptacar.models.Provincias;
import com.codesplai.adaptacar.repositories.ProvinciasRepository;

import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ProvinciasController {

    private final ProvinciasRepository provinciasRepository;
    EntityManager em;

    ProvinciasController(ProvinciasRepository provinciasRepository) {
        this.provinciasRepository = provinciasRepository;
    }

    @GetMapping("/provincias")
    public ArrayList<Provincias> obtenerProvincias() {
        return (ArrayList<Provincias>) provinciasRepository.findAll();
    }

    @GetMapping("provincia/{id}")
    public Provincias one(@PathVariable Integer id) {
        return provinciasRepository.findById(id).get();
    }

    @GetMapping("provincias/get")
	public List<Provincias> getData(
            @RequestParam(required=false,name="id") Integer id,
			@RequestParam(value="provincia",required=false) String provincia,
            @RequestParam(required=false) String slug,
            @RequestParam(required=false) Integer comunidad_id,
            @RequestParam(required=false) Integer capital_id
            )
	{		
		HashMap<String, Object> data=new HashMap<>();
		
		if (id!=null)
			data.put("id",id);
		if (provincia!=null)
			data.put("provincia",provincia);
		if (slug!=null)
            data.put("slug",slug);
        if (capital_id!=null)
            data.put("capital_id",capital_id);
        if (comunidad_id!=null)
            data.put("comunidad_id",comunidad_id);	
        return provinciasRepository.getData(data);	
    }	
		
    @GetMapping("provincias/getQuery")
	public List<Provincias> getDataQuery(
        @RequestParam(required=false,name="id") Integer id,
        @RequestParam(value="provincia",required=false) String provincia,
        @RequestParam(required=false) String slug,
        @RequestParam(required=false) Integer comunidad_id,
        @RequestParam(required=false) Integer capital_id
        	)
	{		
        String sql="select e from provincias e where 1=1";
        if (id!=null)
			sql+=" and e.id = :id";
        if (provincia!=null)
			sql+=" and e.provincia = :provincia";
		if (slug!=null)
            sql+=" and e.slug = :slug";
        if (capital_id!=null)
            sql+=" and e.capital_id = :capital_id";
        if (comunidad_id!=null)
            sql+=" and e.provincia_id = :provincia_id";

		TypedQuery<Provincias> query= em.createQuery(sql,Provincias.class);
		if (id!=null)
			query.setParameter("id", id);
		if (provincia!=null)
			query.setParameter("provincia", provincia);
		if (slug!=null)
			query.setParameter("slug", slug);
        if (slug!=null)
			query.setParameter("capital_id", capital_id);
        if (comunidad_id!=null)
			query.setParameter("comunidad_id", comunidad_id);
        return query.getResultList();			
	}
}
