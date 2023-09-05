package quest.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "stagiaire")
public class Stagiaire {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 25, nullable = false)
	private String nom;
	@Column(length = 25, nullable = false)
	private String prenom;
	@Column(length = 25, nullable = false)
	private String email;

	@ManyToOne
	@JoinColumn(name = "filiere")
	private Filiere filiere;

	@OneToOne(mappedBy = "stagiaire")
	private Ordinateur ordinateur;

	public Stagiaire() {
	}

	public Stagiaire(Integer id, String nom, String prenom, String email, Filiere filiere) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.filiere = filiere;
	}

	public Stagiaire(String nom, String prenom, String email, Filiere filiere) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.filiere = filiere;
	}

	public Ordinateur getOrdinateur() {
		return ordinateur;
	}

	public void setOrdinateur(Ordinateur ordinateur) {
		this.ordinateur = ordinateur;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Filiere getFiliere() {
		return filiere;
	}

	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}

	@Override
	public String toString() {
		return "Stagiaire [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", filiere="
				+ filiere + "]";
	}

}
