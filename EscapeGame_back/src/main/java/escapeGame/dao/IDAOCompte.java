package escapeGame.dao;

import java.util.List;

import escapeGame.model.Compte;
import escapeGame.model.GameMaster;

public interface IDAOCompte extends IDAO<Compte,Integer>{

	public Compte findByLoginAndPassword(String login, String password);
	public List<GameMaster> findAllGameMaster();
}
