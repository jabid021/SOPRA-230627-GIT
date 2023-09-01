package eshop.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import eshop.config.AppConfig;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(classes={ AppConfig.class })
public class DAOProduitTest {
	
	
	@Autowired
	IDAOProduit daoProduit;
	
	
	@Test
	public void initDAOProduit() 
	{
		assertNotNull(daoProduit);
	}
	
	
	@Test
	public void testInsertProduit() 
	{
		
	}
	
	@Test
	public void testFindProduit() 
	{
		
	}
	
	@Test
	public void testDeleteProduit() 
	{
		
	}
}
