package escapeGame.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import escapeGame.model.Compte;
import escapeGame.model.GameMaster;

public interface IDAOCompte extends JpaRepository<Compte,Integer>{

	public Compte findByLoginAndPassword(String login, String password);
	@Query("from GameMaster")
	public List<GameMaster> findAllGameMaster();
}
