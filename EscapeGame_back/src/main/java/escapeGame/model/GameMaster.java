package escapeGame.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("GameMaster")
public class GameMaster extends Compte{
	
	public GameMaster() {}
	
	public GameMaster(Integer id,String login, String password, String nom, String prenom) {
		super(id,login, password, nom, prenom);
	}
	
	public GameMaster(String login, String password, String nom, String prenom) {
		super(login, password, nom, prenom);
	}

	@Override
	public String toString() {
		return "GameMaster [id=" + id + ", login=" + login + ", password=" + password + ", nom=" + nom + ", prenom="
				+ prenom + "]";
	}

	
}
