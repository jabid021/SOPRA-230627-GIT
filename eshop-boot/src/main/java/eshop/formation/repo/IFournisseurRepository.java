package eshop.formation.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import eshop.formation.model.Fournisseur;

public interface IFournisseurRepository extends JpaRepository<Fournisseur, Long> {
	@Query("select distinct f from Fournisseur f left join fetch f.produits where f.id = ?1")
	Optional<Fournisseur> findByIdWithProduits(Long id);
}
