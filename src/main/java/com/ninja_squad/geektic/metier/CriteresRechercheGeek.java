package com.ninja_squad.geektic.metier;

/**
 * Initialise les crit�res de recherche de geek
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
		if(sexe.trim() != "")
			this.sexe = sexe;
		else
			sexe = null;
	}
	public String getCentresInterets() {
		return centresInterets;
	}
	public void setCentresInterets(String centresInterets) {
		if(centresInterets.trim() != "")
			this.centresInterets = centresInterets;
		else
			centresInterets = null;
	}
	
	

}
