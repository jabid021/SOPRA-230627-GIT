package eshop.formation.model;

public class CommandeDetail {
	private Long id;
	private int quantite;
	private Double prix;
	private Commande commande;
	private Produit produit;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public CommandeDetail() {
		// Rien de sp�cial ici
	}

	public CommandeDetail(Double prix, int quantite, Produit produit, Commande commande) {
		this.prix = prix;
		this.quantite = quantite;
		this.produit = produit;
		this.commande = commande;
	}

	@Override
	public String toString() {
		return this.prix + " euros, " + this.quantite + " produit(s) : " + this.produit;
	}
}
