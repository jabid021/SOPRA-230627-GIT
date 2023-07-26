package hopital.model;

import java.time.LocalDate;

public class Visite {

	private Integer numero;
	private double prix;
	private int salle;
	private LocalDate dateVisite;
	private Medecin medecin;
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
