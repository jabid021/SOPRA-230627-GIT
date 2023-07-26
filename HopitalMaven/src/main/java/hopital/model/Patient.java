package hopital.model;

import java.io.Serializable;

public class Patient implements Serializable {

	private Integer id;
	private String prenom;
	private String nom;
	
	public Patient(Integer id, String prenom, String nom) {
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
	}
	

	public Integer getId() {
		return id;
	}


	public String getPrenom() {
		return prenom;
	}


	public String getNom() {
		return nom;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	@Override
	public String toString() {
		return "Patient [id=" + id + ", prenom=" + prenom + ", nom=" + nom + "]";
	}
	
	
}
