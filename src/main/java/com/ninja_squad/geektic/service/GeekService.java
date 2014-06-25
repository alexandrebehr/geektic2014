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

/**
 * Services va appeler le DAO pour récupérer les Geeks
 * 
 * @author p1312005
 *
 */
@RestController
@Transactional
@RequestMapping("/geek")
public class GeekService {
	@Autowired
	private GeekDao geekDao;

	/**
	 * 
	 * @param sexe
	 * 				sexe des geeks à rechercher
	 * @param interets
	 * 				centres d'intérêtes des geeks à rechercher
	 * @return la liste des geeks correspondant
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/{sexe}/{interets}")
	public List<Geek> getGeeksFromCriteria(@PathVariable("sexe") String sexe,
			@PathVariable("interets") String interets) {
		CriteresRechercheGeek criteres = new CriteresRechercheGeek();
		criteres.setSexe(sexe);
		criteres.setCentresInterets(interets);
		List<Geek> geeks = geekDao.getAllGeeks();
		return findGeeksByCriterias(criteres, geeks);
	}
	
	/**
	 * Permet de faire le tri des geeks trouvés en fonction 
	 * des critères de recherche.
	 * Le tri n'est pas fait directement depuis la requête à la base
	 * pour gérer la casse 
	 * 
	 * @param criteres
	 * @param geeks
	 * @return
	 */
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
	
	/**
	 * Permet de trouver un geek avec son identifiant
	 * 
	 * @param id
	 * 			identifiant du geek
	 * @return le geek trouvé
	 */
	@RequestMapping(method = RequestMethod.GET, value= "/{id}")
	private Geek findById(@PathVariable("id") String id) {
		return geekDao.findById(Long.getLong(id));
	}
}
