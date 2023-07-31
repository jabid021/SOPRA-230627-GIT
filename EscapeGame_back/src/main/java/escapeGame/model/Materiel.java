package escapeGame.model;

public abstract class Materiel {

	protected Integer id;
	protected String libelle;
	protected Salle salle;
	protected Etat etat;

	
	public Materiel(Integer id,String libelle, Salle salle, Etat etat) {
		this.id=id;
		this.libelle = libelle;
		this.salle = salle;
		this.etat = etat;
	}
	
	public Materiel(String libelle, Salle salle, Etat etat) {
		this.libelle = libelle;
		this.salle = salle;
		this.etat = etat;
	}

	public String getlibelle() {
		return libelle;
	}

	public void setlibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getLibelle() {
		return libelle;
	}

	public Salle getSalle() {
		return salle;
	}

	public Etat getEtat() {
		return etat;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}




}
