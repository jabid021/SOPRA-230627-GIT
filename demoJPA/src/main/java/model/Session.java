package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Session {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String libelle;
	
	@OneToMany(mappedBy = "filiere")
	private List<Personne> stagiaires;
	
	public Session() {
	}

	public Session(String libelle) {
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

	@Override
	public String toString() {
		return "Session [id=" + id + ", libelle=" + libelle + "]";
	}
	
	
}
