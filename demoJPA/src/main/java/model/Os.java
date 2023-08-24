package model;

public enum Os {

	Linux("1985"),MacOs("2001"),Windows("1991",80);
	
	private String annee;
	private double prix;
	
	
	
	

	
	private Os(String annee) {
		this.annee = annee;
	}
	private Os(String annee,double prix) {
		this.annee = annee;
		this.prix=prix;
	}

	public String getAnnee() {
		return annee;
	}

	public void setAnnee(String annee) {
		this.annee = annee;
	}
	
	
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	
	
	

}
