package eshop.test;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import eshop.dao.IDAOPersonne;
import eshop.dao.IDAOProduit;
import eshop.model.Adresse;
import eshop.model.Client;

public class Test {

	@Autowired
	IDAOPersonne daoPersonne;
	
	@Autowired
	IDAOProduit daoProduit;
	
	public void run(String ...args) {
		
		Adresse a2 = new Adresse("1","rue rougemont","Paris","75009");
		
		Client c1 = new Client("Abid","Jordan",a2,LocalDate.parse("1993-05-01"),30);
		
		c1=(Client) daoPersonne.save(c1);
		
		System.out.println(daoPersonne.findById(c1.getId()));
		
		
		System.out.println(daoProduit.findAll());
	
		
	}
}
