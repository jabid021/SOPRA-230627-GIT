package eshop.formation.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import eshop.formation.model.CommandeDetail;

public interface ICommandeDetailRepository extends JpaRepository<CommandeDetail, Long> {

}
