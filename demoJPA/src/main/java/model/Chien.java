package model;

import javax.persistence.Entity;

@Entity
public class Chien extends Animal{

	
	public Chien() {
		super();
	}

	public Chien(String nom) {
		super(nom);
	}

	@Override
	public String toString() {
		return "Chien [id=" + id + ", nom=" + nom + "]";
	}

	
	
}
