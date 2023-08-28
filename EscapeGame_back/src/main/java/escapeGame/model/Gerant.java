package escapeGame.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Gerant")
public class Gerant extends Compte {

	public Gerant() {}
	
	public Gerant(Integer id,String login, String password, String nom, String prenom) {
		super(id,login, password, nom, prenom);
	}

	
	public Gerant(String login, String password, String nom, String prenom) {
		super(login, password, nom, prenom);
	}


	@Override
	public String toString() {
		return "Gerant [id=" + id + ", login=" + login + ", password=" + password + ", nom=" + nom + ", prenom="
				+ prenom + "]";
	}


}
