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

import com.codesplai.adaptacar.models.Provincias;

public class ProvinciasRepositoryImpl{

	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Provincias> getData(HashMap<String, Object> conditions)
	{
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Provincias> query= cb.createQuery(Provincias.class);
		Root<Provincias> root = query.from(Provincias.class);
		
		List<Predicate> predicates = new ArrayList<>();
		conditions.forEach((field,value) ->
		{
			switch (field)
			{
				case "id":
					predicates.add(cb.equal(root.get(field), (Integer)value));
					break;
				case "provincia":
					predicates.add(cb.like(root.get(field),"%"+(String)value+"%"));
					break;
				case "capital_id":
					predicates.add(cb.equal(root.get(field),(Integer)value));
                    break;
                case "comunidad_id":
					predicates.add(cb.equal(root.get(field),(Integer)value));
                    break;
                case "slug":
					predicates.add(cb.like(root.get(field),"%"+(String)value+"%"));
					break;
			}
			
		});
		query.select(root).where(predicates.toArray(new Predicate[predicates.size()]));
		return entityManager.createQuery(query).getResultList(); 		
	}
}