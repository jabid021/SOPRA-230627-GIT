package escapeGame.model;

public class Coffre extends Securite {

	private int attente;

	public Coffre(Integer id,String libelle, Salle salle, Etat etat, String code, int attente) {
		super(libelle,salle,etat,code);
		this.attente = attente;
	}
	
	public Coffre(String libelle, Salle salle, Etat etat, String code, int attente) {
		super(libelle,salle,etat,code);
		this.attente = attente;
	}

	public int getAttente() {
		return attente;
	}

	public void setAttente(int attente) {
		this.attente = attente;
	}

	@Override
	public String toString() {
		return "Coffre [code=" + code + ", id=" + id + ", libelle=" + libelle + ", salle=" + salle + ", etat=" + etat
				+ ", attente=" + attente + "]";
	}

	

	
	

}
