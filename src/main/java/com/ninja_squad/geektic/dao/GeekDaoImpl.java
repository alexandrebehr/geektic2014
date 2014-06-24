package com.ninja_squad.geektic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.ninja_squad.geektic.metier.CriteresRechercheGeek;
import com.ninja_squad.geektic.metier.Geek;

public class GeekDaoImpl extends GeekDao{

	public GeekDaoImpl(EntityManager em) {
		super(em);
	}
	
	public GeekDaoImpl() {
		
	}

	@Override
	public List<Geek> searchByCriteria(CriteresRechercheGeek criteres) {
		String jpql = "select * from GEEK";
		TypedQuery<Geek> query = entityManager.createQuery(jpql, Geek.class);
		return query.getResultList();
	}

}
