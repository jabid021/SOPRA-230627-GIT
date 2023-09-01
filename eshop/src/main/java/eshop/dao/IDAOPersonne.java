package eshop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import eshop.model.Personne;

public interface IDAOPersonne extends JpaRepository<Personne,Integer> {

	
}
