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
		String jpql = "select g from Geek g";
		jpql = addParameters(jpql, criteres);
		TypedQuery<Geek> query = entityManager.createQuery(jpql, Geek.class);
		return query.getResultList();
	}
	
	private String addParameters(String jpql, CriteresRechercheGeek criteres) {
		boolean criteriaFound = false;
		String sexe = criteres.getSexe();
		String interets = criteres.getCentresInterets();
		if(sexe != null)
		{
			criteriaFound = true;
			jpql += " where sexe = '"+ sexe + "'";
		}
		if(interets != null) {
			if(criteriaFound) {
				jpql += " and interets LIKE '%" + interets + "%'";
			} else {
				jpql += " where interets LIKE '%" + interets + "%'";
			}
		}
		
		return jpql;
	}

}
