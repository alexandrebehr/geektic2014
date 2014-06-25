package com.ninja_squad.geektic.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ninja_squad.geektic.dao.GeekDao;
import com.ninja_squad.geektic.metier.CriteresRechercheGeek;
import com.ninja_squad.geektic.metier.Geek;

@RestController
@Transactional
@RequestMapping("/geek")
public class GeekService {
	@Autowired
	private GeekDao geekDao;

	@RequestMapping(method = RequestMethod.GET, value = "/{sexe}/{interets}")
	public List<Geek> getGeeksFromCriteria(@PathVariable("sexe") String sexe,
			@PathVariable("interets") String interets) {
		CriteresRechercheGeek criteres = new CriteresRechercheGeek();
		criteres.setSexe(sexe);
		criteres.setCentresInterets(interets);
		List<Geek> geeks = geekDao.getAllGeeks();
		return findGeeksByCriterias(criteres, geeks);
	}
	
	private List<Geek> findGeeksByCriterias(CriteresRechercheGeek criteres, List<Geek> geeks) {
		List<Geek> geeksToReturn = new ArrayList<>();
		for (Geek geek : geeks) {
			if(geek.getSexe().equals(criteres.getSexe())
					&& geek.getInterets().toLowerCase().contains(criteres.getCentresInterets().toLowerCase())) 
			{
				geeksToReturn.add(geek);
			}
		}
		return geeksToReturn;
	}
}
