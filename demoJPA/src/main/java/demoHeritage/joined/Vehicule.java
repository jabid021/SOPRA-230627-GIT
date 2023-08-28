package demoHeritage.joined;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Vehicule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	protected int nbRoues;
	
	public Vehicule() {}

	public Vehicule(int nbRoues) {
		this.nbRoues = nbRoues;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getNbRoues() {
		return nbRoues;
	}

	public void setNbRoues(int nbRoues) {
		this.nbRoues = nbRoues;
	}
	
	
	
}
