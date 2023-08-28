package hopital.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="visite")
public class Visite {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer numero;
	private double prix;
	private int salle;
	@Column(name="date_visite",nullable = false)
	private LocalDate dateVisite;
	@ManyToOne
	@JoinColumn(name="id_medecin", nullable = false)
	private Medecin medecin;
	
	@ManyToOne
	@JoinColumn(name="id_patient" , nullable = false)
	private Patient patient;
	
	
	public Visite(Integer numero, double prix, int salle, LocalDate dateVisite, Medecin medecin, Patient patient) {
		this.numero = numero;
		this.prix = prix;
		this.salle = salle;
		this.dateVisite = dateVisite;
		this.medecin = medecin;
		this.patient = patient;
	}
	

	public Visite(Medecin medecin, Patient patient) {
		this.prix = 20;
		this.salle = medecin.getSalle();
		this.dateVisite = LocalDate.now();
		this.medecin = medecin;
		this.patient = patient;
	}


	public Integer getNumero() {
		return numero;
	}


	public double getPrix() {
		return prix;
	}


	public int getSalle() {
		return salle;
	}


	public LocalDate getDateVisite() {
		return dateVisite;
	}


	public Medecin getMedecin() {
		return medecin;
	}


	public Patient getPatient() {
		return patient;
	}


	public void setNumero(Integer numero) {
		this.numero = numero;
	}


	public void setPrix(double prix) {
		this.prix = prix;
	}


	public void setSalle(int salle) {
		this.salle = salle;
	}


	public void setDateVisite(LocalDate dateVisite) {
		this.dateVisite = dateVisite;
	}


	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}


	public void setPatient(Patient patient) {
		this.patient = patient;
	}


	@Override
	public String toString() {
		return "Visite [numero=" + numero + ", prix=" + prix + ", salle=" + salle + ", dateVisite=" + dateVisite
				+ ", medecin=" + medecin.getId() + ", patient=" + patient + "]";
	}
	
	
	
	
	
	
	
}
