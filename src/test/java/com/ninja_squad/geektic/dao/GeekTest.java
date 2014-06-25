package com.ninja_squad.geektic.dao;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.ninja_squad.geektic.metier.Geek;

@SuppressWarnings("deprecation")
public class GeekTest {
	private Geek geek;

	@Before
	public void setup()
	{
		geek = new Geek(Long.getLong("10"), "homme", "Behr", "Alexandre", "alex@yahoo.fr", "Java");
	}
	
	@Test
	public void geekTestChamps() {
		// Test sur les champs
		Assert.assertEquals("Alexandre", geek.getPrenom());
		Assert.assertEquals("Behr", geek.getNom());
		Assert.assertEquals("homme", geek.getSexe());
		Assert.assertEquals("Java", geek.getInterets());
		
	}
	
	
	public void geekTestSetChamps()
	{
		geek.setNom("Adulin");
		geek.setNom("Alizé");
		
		
		Assert.assertEquals("Alizé", geek.getPrenom());
		Assert.assertEquals("Adulin", geek.getNom());
	}
	

}
