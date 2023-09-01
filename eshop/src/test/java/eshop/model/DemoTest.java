package eshop.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DemoTest {
	
	
	@BeforeClass
	public static void premierTest()
	{
		System.out.println("Premier Test");
	}
	
	@Before
	public void avantChaqueTest() 
	{
		System.out.println("Se lance avant chaque test");
	}

	
	@Test
	public void testAffectationDemo() 
	{
		//Arrange
			String demo;
		//Act
			demo="test";
		//Assert
		assertEquals("test", demo);
	}
	
	@Test
	public void testInitProduit() 
	{
		//Arrange
			Produit p=null;
			Adresse a = new Adresse("1","rue de paris","Paris","75001");
			Fournisseur f = new Fournisseur("nom", "prenom",a , "societe");
		//Act
			p = new Produit("libelle", 10, f);
		//Assert
		//assertNotNull(p);
		//if(p==null) {fail();}
		assertEquals("libelle", p.getLibelle());
		assertTrue(10==p.getPrix());
		assertNotNull(p.getFournisseur());
	}
	
	
	
	@AfterClass
	public static void dernierTest()
	{
		System.out.println("dernier Test");
	}
	
}
