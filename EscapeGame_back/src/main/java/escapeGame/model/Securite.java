package escapeGame.model;

import javax.persistence.Entity;

@Entity
public abstract class Securite extends Materiel {
	protected String code;
public Securite() {
	// TODO Auto-generated constructor stub
}
	public Securite(Integer id,String libelle, Salle salle, Etat etat, String code) {
		super(id,libelle,salle,etat);
		this.code = code;
	}

	public Securite(String libelle, Salle salle, Etat etat, String code) {
		super(libelle,salle,etat);
		this.code = code;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}

}
