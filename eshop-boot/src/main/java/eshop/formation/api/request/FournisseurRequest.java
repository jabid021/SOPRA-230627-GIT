package eshop.formation.api.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class FournisseurRequest {
	@NotBlank
	private String nom;

	@NotBlank
	@Email
	private String adresse;

	private String responsable;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
}
