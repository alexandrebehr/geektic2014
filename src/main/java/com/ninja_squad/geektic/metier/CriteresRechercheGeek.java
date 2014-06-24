package com.ninja_squad.geektic.metier;

/**
 * Initialise les critères de recherche de geek
 * 
 * @author p1312005
 *
 */
public class CriteresRechercheGeek {
	
	private String sexe;
	private String centresInterets;
	
	public CriteresRechercheGeek() {}
	
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getCentresInterets() {
		return centresInterets;
	}
	public void setCentresInterets(String centresInterets) {
		this.centresInterets = centresInterets;
	}
	
	

}
