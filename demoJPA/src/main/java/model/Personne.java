package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "personne",uniqueConstraints = @UniqueConstraint(columnNames = {"firstname","naissance"}))
public class Personne {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="lastname",columnDefinition = "VARCHAR(35)",nullable = false,unique=true)
	private String nom;
	
	@Column(name="firstname",length = 35 )
	private String prenom;
	
	private LocalDate naissance;
	
	private int taille;
	
	public Personne() {}
	
	public Personne(Integer id, String nom, String prenom, LocalDate naissance,int taille) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.naissance = naissance;
		this.taille=taille;
	}
	
	public Personne( String nom, String prenom, LocalDate naissance,int taille) {
		this.nom = nom;
		this.prenom = prenom;
		this.naissance = naissance;
		this.taille=taille;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getNaissance() {
		return naissance;
	}

	public void setNaissance(LocalDate naissance) {
		this.naissance = naissance;
	}

	
	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	@Override
	public String toString() {
		return "Personne [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", naissance=" + naissance + ", taille="
				+ taille + "]";
	}

	
	
	
	
}
