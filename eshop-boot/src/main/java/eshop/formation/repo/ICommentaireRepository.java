package eshop.formation.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import eshop.formation.model.Commentaire;

public interface ICommentaireRepository extends JpaRepository<Commentaire, Long> {

}
