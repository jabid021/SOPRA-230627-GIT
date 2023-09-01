package eshop.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

public class SuperMathsTest {

	@BeforeClass
	public static void debutTest() 
	{
		System.out.println("Debut des test SuperMaths");
	}

	@Test
	public void initSuperMaths() 
	{
		//Arrange
		SuperMaths sm = null;

		//Act
		sm = new SuperMaths();

		//Assert
		assertNotNull(sm);
	}

	@Test
	public void additionTest() 
	{
		//Arrange
		SuperMaths sm = new SuperMaths();
		int a = 1;
		int b=5;
		int resultat;
		//Act
		resultat = sm.additionner(a, b);

		//Assert
		assertTrue(6==resultat);
		//assertEquals(6,resultat);
	}

	@Test
	public void soustraireTest() 
	{
		//Arrange
		SuperMaths sm = new SuperMaths();
		int a = 6;
		int b=5;
		int resultat;
		//Act
		resultat = sm.soustraire(a, b);

		//Assert
		assertFalse(0==resultat);
		//assertEquals(6,resultat);
	}

}
