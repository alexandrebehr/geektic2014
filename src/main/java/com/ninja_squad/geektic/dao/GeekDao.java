package com.ninja_squad.geektic.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.ninja_squad.geektic.metier.CriteresRechercheGeek;
import com.ninja_squad.geektic.metier.Geek;

public abstract class GeekDao {
	protected EntityManager entityManager;
	
	public GeekDao(EntityManager em)
	{
		entityManager = em;
	}
	
	public GeekDao(){}
	
	public abstract List<Geek> searchByCriteria(CriteresRechercheGeek criteres);
}
