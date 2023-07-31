package escapeGame.model;

public abstract class Securite extends Materiel {
	protected String code;

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
