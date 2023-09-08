package eshop.formation.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import eshop.formation.model.Adresse;

public interface IAdresseRepository extends JpaRepository<Adresse, Long> {
	// recherche une liste d'adresse par ville => par convention de nommage
	List<Adresse> findByVille(String ville);
}
