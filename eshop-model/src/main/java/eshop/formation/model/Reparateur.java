package eshop.formation.model;

import java.util.ArrayList;
import java.util.List;

public class Reparateur {
	private Long id;
	private String nom;
	private String telephone;
	private String description;
	private List<Produit> produitsReparables = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Produit> getProduitsReparables() {
		return produitsReparables;
	}

	public void setProduitsReparables(List<Produit> produitsReparables) {
		this.produitsReparables = produitsReparables;
	}
}
