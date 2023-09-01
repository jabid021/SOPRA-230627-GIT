package eshop.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import eshop.config.AppConfig;
import eshop.model.Adresse;
import eshop.model.Fournisseur;
import eshop.model.Produit;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(classes={ AppConfig.class })
@Transactional
@Rollback(true)
public class DAOProduitTest {
	
	
	@Autowired
	IDAOProduit daoProduit;
	
	@Autowired
	IDAOPersonne daoPersonne;
	
	
	@Test
	public void initDAOProduit() 
	{
		assertNotNull(daoProduit);
	}
	
	
	@Test
	public void testInsertProduit() 
	{
		Adresse a = new Adresse("1","rue de paris","Paris","75001");
		Fournisseur f = new Fournisseur("nom", "prenom",a , "societe");
		Produit p = new Produit("libelle", 10.50, f);
		
		p=daoProduit.save(p);
		
		assertNotNull(p);
		assertNotNull(p.getFournisseur());
		assertTrue(p.getFournisseur().getId()==f.getId());
		assertEquals("libelle", p.getLibelle());
		assertTrue(10.50==p.getPrix());
		
	}
	
	@Test
	public void testFindProduit() 
	{
		Adresse a = new Adresse("1","rue de paris","Paris","75001");
		Fournisseur f = new Fournisseur("nom", "prenom",a , "societe");
		Produit p = new Produit("libelle", 10.50, f);
		p=daoProduit.save(p);
	
		Produit produitBdd = daoProduit.findById(p.getId());
		
		assertNotNull(produitBdd);
	}
	
	@Test
	public void testDeleteProduit() 
	{
		Adresse a = new Adresse("1","rue de paris","Paris","75001");
		Fournisseur f = new Fournisseur("nom", "prenom",a , "societe");
		Produit p = new Produit("libelle", 10.50, f);
		p=daoProduit.save(p);
		
		
		daoProduit.delete(p);
		
		
		Produit produitBdd = daoProduit.findById(p.getId());
		assertNull(produitBdd);
	
	}
}
