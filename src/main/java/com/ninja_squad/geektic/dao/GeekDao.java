package com.ninja_squad.geektic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.ninja_squad.geektic.metier.Geek;

@Repository
public class GeekDao {
	@PersistenceContext
	protected EntityManager entityManager;

	public List<Geek> getAllGeeks() {
		String jpql = "select g from Geek g";
		TypedQuery<Geek> query = entityManager.createQuery(jpql, Geek.class);
		return query.getResultList();
	}
	
	public Geek findById(Long id) {
		return entityManager.find(Geek.class, id);
	}
}
