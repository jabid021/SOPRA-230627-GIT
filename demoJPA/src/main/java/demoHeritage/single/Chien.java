package demoHeritage.single;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("dog")
public class Chien extends Animal{

	public Chien() {}

	public Chien(String nom) {
		super(nom);
	}

	@Override
	public String toString() {
		return "Chien [id=" + id + ", nom=" + nom + "]";
	}

	
	
}
