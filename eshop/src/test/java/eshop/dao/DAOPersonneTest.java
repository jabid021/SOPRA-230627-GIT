package eshop.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
import eshop.model.Personne;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(classes={ AppConfig.class })
@Transactional
@Rollback(true)
public class DAOPersonneTest {
	
	
	@Autowired
	IDAOPersonne daoPersonne;
	
	
	@Test
	public void initDAOPersonne() 
	{
		assertNotNull(daoPersonne);
	}
	
	
	
	@Test
	public void insertDAOPersonne() 
	{
		Adresse a = new Adresse("1","rue de paris","Paris","75001");
		Personne f = new Fournisseur("nom", "prenom",a , "societe");
		
		f = daoPersonne.save(f);
		
		assertNotNull(f);
		assertNotNull(f.getId());
		assertNotNull(f.getAdresse());
		assertEquals("1",f.getAdresse().getNumero());
		assertEquals("rue de paris",f.getAdresse().getVoie());
		assertEquals("Paris",f.getAdresse().getVille());
		assertEquals("75001",f.getAdresse().getCp());
		assertEquals("nom",f.getNom());
		assertEquals("prenom",f.getPrenom());
		assertEquals("societe",((Fournisseur) f).getSociete());	
	}
	
	

}
