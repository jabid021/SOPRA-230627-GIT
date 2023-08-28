package escapeGame.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_materiel", columnDefinition = "ENUM('Coffre','Cadenas','Mecanisme')")
@Table(name="materiel")
public abstract class Materiel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	
	
	@Column(length = 30,nullable = false)
	protected String libelle;
	
	@ManyToOne
	@JoinColumn(name="salle")
	protected Salle salle;
	
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('Neuf','Standard','Abime','KO')")
	protected Etat etat;

	public Materiel() {
		// TODO Auto-generated constructor stub
	}
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
