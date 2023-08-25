package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
	
	
	//@XToY,  le Y represente l'attribut sur lequel on gere la jointure, si on a une Liste / Tableau => ToMany, sinon ToOne
	
	@OneToOne
	@JoinColumn(name="ordi",nullable = false)
	private Ordinateur ordinateur;
	
	@ManyToOne
	@JoinColumn(name="session")
	private Session filiere;
	
	@ManyToMany
	@JoinTable(
			name="formations",
			joinColumns =  @JoinColumn(name="stagiaire"),
			inverseJoinColumns = @JoinColumn(name="cours")
			// ,uniqueConstraints = @UniqueConstraint(columnNames = {"stagiaire","cours"})
			)
	private List<Matiere> formations = new ArrayList();
	
	@Embedded
	private Adresse adresse;
	
	public Personne() {}
	
	
	public Personne( String nom, String prenom, LocalDate naissance,int taille,Adresse adresse,Ordinateur ordinateur,Session filiere) {
		this.nom = nom;
		this.prenom = prenom;
		this.naissance = naissance;
		this.taille=taille;
		this.adresse=adresse;
		this.ordinateur=ordinateur;
		this.filiere=filiere;
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

	
	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	
	public Ordinateur getOrdinateur() {
		return ordinateur;
	}


	public void setOrdinateur(Ordinateur ordinateur) {
		this.ordinateur = ordinateur;
	}


	public Session getFiliere() {
		return filiere;
	}


	public void setFiliere(Session filiere) {
		this.filiere = filiere;
	}


	public List<Matiere> getFormations() {
		return formations;
	}


	public void setFormations(List<Matiere> formations) {
		this.formations = formations;
	}


	@Override
	public String toString() {
		return "Personne [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", naissance=" + naissance + ", taille="
				+ taille + ", ordinateur=" + ordinateur + ", filiere=" + filiere + ", adresse=" + adresse + "]";
	}


	


	
	
	
	
	
	
}
