package eshop.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
@DiscriminatorValue("customer")
public class Client extends Personne{
	
	@Column(name="birthdate")
	private LocalDate dateNaissance;
	
	@Column(columnDefinition = "int(3)")
	private int age;
	
	
	@ManyToMany
	private List<Produit> produits = new ArrayList();
	
	public Client() {
	}


	public Client(String nom, String prenom, Adresse adresse, LocalDate dateNaissance, int age) {
		super(nom, prenom, adresse);
		this.dateNaissance = dateNaissance;
		this.age = age;
	}


	public LocalDate getDateNaissance() {
		return dateNaissance;
	}


	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}
	


	public List<Produit> getProduits() {
		return produits;
	}


	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}


	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", dateNaissance="
				+ dateNaissance + ", age=" + age + "]";
	}
	
	
}
