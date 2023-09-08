package eshop.formation.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import eshop.formation.model.Utilisateur;

public interface IUtilisateurRepository extends JpaRepository<Utilisateur, Long> {
	public Optional<Utilisateur> findByUsername(String username);

	public boolean existsByUsername(String username);
}
