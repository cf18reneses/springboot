package com.codesplai.adaptacar.repositoriesImpl;

import static com.codesplai.adaptacar.controllers.PostController.EQUAL;
import static com.codesplai.adaptacar.controllers.PostController.GREATER_THAN;
import static com.codesplai.adaptacar.controllers.PostController.LESS_THAN;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.codesplai.adaptacar.models.Post;
import com.codesplai.adaptacar.repositories.PostRepository;

import org.springframework.data.repository.query.Param;

public class PostRepositoryImpl {

	@PersistenceContext
	private EntityManager entityManager;
	private PostRepository postRepository;

	public PostRepositoryImpl(EntityManager entityManager, PostRepository postRepository) {
		this.entityManager = entityManager;
		this.postRepository = postRepository;
	}

	public List<Post> getData(HashMap<String, Object> conditions) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Post> query = cb.createQuery(Post.class);
		Root<Post> root = query.from(Post.class);

		List<Predicate> predicates = new ArrayList<>();
		conditions.forEach((field, value) -> {
			switch (field) {
				case "idpost":
					predicates.add(cb.equal(root.get(field), (Integer) value));
					break;
				case "embrague":
					predicates.add(cb.equal(root.get(field), (Integer) value));
					break;
				case "color":
					predicates.add(cb.equal(root.get(field), (Integer) value));
					break;
				case "combustible":
					predicates.add(cb.equal(root.get(field), (Integer) value));
					break;
				case "traccion":
					predicates.add(cb.equal(root.get(field), (Integer) value));
					break;
				case "carroceria":
					predicates.add(cb.equal(root.get(field), (Integer) value));
					break;
				case "coche":
					predicates.add(cb.equal(root.get(field), (Integer) value));
					break;
				case "plazas":
					predicates.add(cb.equal(root.get(field), (Integer) value));
					break;
				case "puertas":
					predicates.add(cb.equal(root.get(field), (Integer) value));
					break;
				case "motor":
					predicates.add(cb.equal(root.get(field), (Integer) value));
					break;
				case "anyo":
					String anyoCondition = (String) conditions.get("anyoCondition");
					switch (anyoCondition) {
						case GREATER_THAN:
							predicates.add(cb.greaterThan(root.<Integer>get(field), (Integer) value));
							break;
						case LESS_THAN:
							predicates.add(cb.lessThan(root.<Integer>get(field), (Integer) value));
							break;
						case EQUAL:
							predicates.add(cb.equal(root.<Integer>get(field), (Integer) value));
							break;
					}
					break;
				case "kms":
					String kmsCondition = (String) conditions.get("kmsCondition");
					switch (kmsCondition) {
						case GREATER_THAN:
							predicates.add(cb.greaterThan(root.<Integer>get(field), (Integer) value));
							break;
						case LESS_THAN:
							predicates.add(cb.lessThan(root.<Integer>get(field), (Integer) value));
							break;
						case EQUAL:
							predicates.add(cb.equal(root.<Integer>get(field), (Integer) value));
							break;
					}
					break;
				case "cv":
					String cvCondition = (String) conditions.get("cvCondition");
					switch (cvCondition) {
						case GREATER_THAN:
							predicates.add(cb.greaterThan(root.<Integer>get(field), (Integer) value));
							break;
						case LESS_THAN:
							predicates.add(cb.lessThan(root.<Integer>get(field), (Integer) value));
							break;
						case EQUAL:
							predicates.add(cb.equal(root.<Integer>get(field), (Integer) value));
							break;
					}
					break;
				case "precio":
					String precioCondition = (String) conditions.get("precioCondition");
					switch (precioCondition) {
						case GREATER_THAN:
							predicates.add(cb.greaterThan(root.<Integer>get(field), (Integer) value));
							break;
						case LESS_THAN:
							predicates.add(cb.lessThan(root.<Integer>get(field), (Integer) value));
							break;
						case EQUAL:
							predicates.add(cb.equal(root.<Integer>get(field), (Integer) value));
							break;
					}
						break;
				case "fecha_publi":
					String fecha_publiCondition = (String) conditions.get("fecha_publiCondition");
					switch (fecha_publiCondition) {
						case GREATER_THAN:
							predicates.add(cb.greaterThan(root.<Integer>get(field), (Integer) value));
							break;
						case LESS_THAN:
							predicates.add(cb.lessThan(root.<Integer>get(field), (Integer) value));
							break;
						case EQUAL:
							predicates.add(cb.equal(root.<Integer>get(field), (Integer) value));
							break;
					}
					break;
			}
		});
		query.select(root).where(predicates.toArray(new Predicate[predicates.size()]));
		return entityManager.createQuery(query).getResultList();
	}

	// Permite filtrar los posts por tantas adaptaciones como se quiera
	public List<Post> findByAllAdaptaciones(@Param("ids") Integer[] ids) {
		List<Post> postsFinales = new ArrayList<Post>();
		List<Post> postsFiltrados = new ArrayList<Post>();
		List<Post> postsFiltrados2 = new ArrayList<Post>();

		postsFiltrados = postRepository.findPostsByIdAdaptacion(ids[0]); // Posts que coinciden con la primera
																			// adaptacion seleccionada
		postsFinales = postsFiltrados;

		for (Integer i = 1; i < ids.length; i++) { // Se van filtrando los posts que coinciden con cada una de las
													// adaptaciones de la lista. Si un post coincide con la actual pero
													// no con las
			// anteriores se borra de la lista de posts finales.
			postsFiltrados2 = postRepository.findPostsByIdAdaptacion(ids[i]);
			for (Integer j = 0; j < postsFiltrados2.size(); j++)
				if (!postsFinales.contains(postsFiltrados2.get(j))) {
					postsFiltrados2.remove(postsFiltrados2.get(j));
				}
			postsFinales = postsFiltrados2;
		}
		return postsFinales;
	}
}