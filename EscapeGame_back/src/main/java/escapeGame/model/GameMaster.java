package escapeGame.model;

public class GameMaster extends Compte{

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
