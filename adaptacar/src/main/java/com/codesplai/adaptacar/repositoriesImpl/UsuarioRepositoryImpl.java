package com.codesplai.adaptacar.repositoriesImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.codesplai.adaptacar.models.Usuario;

public class UsuarioRepositoryImpl{

	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Usuario> getData(HashMap<String, Object> conditions)
	{
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Usuario> query= cb.createQuery(Usuario.class);
		Root<Usuario> root = query.from(Usuario.class);
		
		List<Predicate> predicates = new ArrayList<>();
		conditions.forEach((field,value) ->
		{
			switch (field)
			{
				case "idusuario":
					predicates.add(cb.equal(root.get(field), (Integer)value));
					break;
				case "nombre":
					predicates.add(cb.like(root.get(field),"%"+(String)value+"%"));
					break;
				case "apellido":
					predicates.add(cb.like(root.get(field),"%"+(String)value+"%"));
					break;
				case "telefono":
					predicates.add(cb.like(root.get(field),"%"+(String)value+"%"));
					break;
				case "email":
					predicates.add(cb.like(root.get(field),"%"+(String)value+"%"));
					break;
			}
			
		});
		query.select(root).where(predicates.toArray(new Predicate[predicates.size()]));
		return entityManager.createQuery(query).getResultList(); 		
	}
}

