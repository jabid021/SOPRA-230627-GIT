package escapeGame.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import escapeGame.model.Materiel;

public interface IDAOMateriel extends JpaRepository	<Materiel,Integer>{

}
