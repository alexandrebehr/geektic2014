package com.ninja_squad.geektic.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ninja_squad.geektic.dao.GeekDao;
import com.ninja_squad.geektic.dao.GeekDaoImpl;
import com.ninja_squad.geektic.metier.CriteresRechercheGeek;
import com.ninja_squad.geektic.metier.Geek;

@RestController
@Transactional
@RequestMapping("/geek")
public class GeekService {
	private EntityManager em;
	private GeekDao geekDao;
	
	public GeekService() {
		em = Persistence.createEntityManagerFactory("GEEKTIC").createEntityManager();
		geekDao = new GeekDaoImpl(em);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{sexe}/{interets}")
	public List<Geek> getGeeksFromCriteria(@PathVariable("sexe") String sexe,
			@PathVariable("interets") String interets) {
		CriteresRechercheGeek criteres = new CriteresRechercheGeek();
		criteres.setSexe(sexe);
		criteres.setCentresInterets(interets);
		return geekDao.searchByCriteria(criteres);
	}
}
