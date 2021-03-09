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

import com.codesplai.adaptacar.models.Coche;

public class CocheRepositoryImpl{

	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Coche> getData(HashMap<String, Object> conditions)
	{
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Coche> query= cb.createQuery(Coche.class);
		Root<Coche> root = query.from(Coche.class);
		
		List<Predicate> predicates = new ArrayList<>();
		conditions.forEach((field,value) ->
		{
			switch (field)
			{
				case "idcoche":
					predicates.add(cb.equal(root.get(field), (Integer)value));
					break;
				case "marca":
					predicates.add(cb.like(root.get(field),"%"+(String)value+"%"));
					break;
				case "modelo":
					predicates.add(cb.like(root.get(field),"%"+(String)value+"%"));
					break;
			}
			
		});
		query.select(root).where(predicates.toArray(new Predicate[predicates.size()]));
		return entityManager.createQuery(query).getResultList(); 		
	}
}