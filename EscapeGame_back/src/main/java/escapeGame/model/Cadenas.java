package escapeGame.model;

import javax.persistence.Entity;

@Entity
public class Cadenas extends Securite {

	
	public Cadenas() {
		// TODO Auto-generated constructor stub
	}
	public Cadenas(Integer id,String libelle, Salle salle, Etat etat, String code) {
		super(id,libelle,salle,etat, code);
	}
	
	public Cadenas(String libelle, Salle salle, Etat etat, String code) {
		super(libelle,salle,etat, code);
	}

	@Override
	public String toString() {
		return "Cadenas [code=" + code + ", id=" + id + ", libelle=" + libelle + ", salle=" + salle + ", etat=" + etat
				+ "]";
	}

	

}
