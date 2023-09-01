package eshop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import eshop.model.Produit;

public interface IDAOProduit extends JpaRepository<Produit,Integer> {

	@Query("SELECT p from Produit p where p.libelle=:libelle")
	public List<Produit> findParLib(@Param("libelle") String chaine);
	
	public List<Produit> findByLibelle(String libelle);
	
	public List<Produit> findByPrixBetween(double a,double b);
	
}
