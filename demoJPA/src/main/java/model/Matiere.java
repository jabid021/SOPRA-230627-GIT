package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Matiere {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String libelle; 
	
	@ManyToMany(mappedBy = "formations")
	private List<Personne> stagiaires = new ArrayList();
	
	public Matiere() {
	}

	public Matiere(String libelle) {
		this.libelle = libelle;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	
	public List<Personne> getStagiaires() {
		return stagiaires;
	}

	public void setStagiaires(List<Personne> stagiaires) {
		this.stagiaires = stagiaires;
	}

	@Override
	public String toString() {
		return "Matiere [id=" + id + ", libelle=" + libelle + "]";
	}
	
}
