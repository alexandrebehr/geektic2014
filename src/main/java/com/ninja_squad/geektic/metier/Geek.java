package com.ninja_squad.geektic.metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;



@Entity
@Table(name = "GEEK")
@SequenceGenerator(name="Geek", sequenceName="seq_geek")
public class Geek {
	
	@Id
	@GenericGenerator(name = "generator", strategy="increment")
	@GeneratedValue
	@Column(name="ID")
	private Long identifiant;
	
	@Column(name = "SEXE")
	private String sexe;
	
	@Column(name = "NOM")
	private String nom;
	
	@Column(name = "PRENOM")
	private String prenom;
	
	@Column(name = "MAIL")
	private String mail;
	
	@Column(name = "INTERETS")
	private String interets;
	
	public Geek() {}
	
	public Geek(Long id, String sexe, String nom, String prenom, String mail, String interets) {
		this.identifiant = id;
		this.sexe = sexe;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.interets = interets;
	}
	
	public Long getId() {
		return identifiant;
	}
	public void setId(Long id) {
		this.identifiant = id;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getInterets() {
		return interets;
	}
	public void setInterets(String interets) {
		this.interets = interets;
	}
	
	

}
