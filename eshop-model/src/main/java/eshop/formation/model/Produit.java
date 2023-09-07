package eshop.formation.model;

import java.util.ArrayList;
import java.util.List;

public class Produit {
	private Long id;
	private String libelle;
	private Double prixAchat;
	private Double prixVente;
	private String reference;
	private String modele;
	private int stock;
	private Fournisseur fournisseur;
	private List<CommandeDetail> details = new ArrayList<>();
	private List<Commentaire> commentaires = new ArrayList<>();
	private List<Reparateur> reparateurs = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Double getPrixAchat() {
		return prixAchat;
	}

	public void setPrixAchat(Double prixAchat) {
		this.prixAchat = prixAchat;
	}

	public Double getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(Double prixVente) {
		this.prixVente = prixVente;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	public List<CommandeDetail> getDetails() {
		return details;
	}

	public void setDetails(List<CommandeDetail> details) {
		this.details = details;
	}

	public List<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	public List<Reparateur> getReparateurs() {
		return reparateurs;
	}

	public void setReparateurs(List<Reparateur> reparateurs) {
		this.reparateurs = reparateurs;
	}

	public Produit() { // IMPORTANT pour JPA

	}

	public Produit(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return " > " + this.id + ". " + this.libelle + ", " + this.prixVente + " euros";
	}
}
