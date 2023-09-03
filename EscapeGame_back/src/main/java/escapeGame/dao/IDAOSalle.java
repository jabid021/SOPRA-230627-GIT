package escapeGame.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import escapeGame.model.Salle;

public interface IDAOSalle extends JpaRepository<Salle,Integer>{

}
