package demoHeritage.joined;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Avion extends Vehicule {

	@Column(nullable = false)
	private Integer nbSiege;
	
	public Avion() {}

	public Avion(int nbRoues, Integer nbSiege) {
		super(nbRoues);
		this.nbSiege = nbSiege;
	}

	public Integer getNbSiege() {
		return nbSiege;
	}

	public void setNbSiege(Integer nbSiege) {
		this.nbSiege = nbSiege;
	}

	@Override
	public String toString() {
		return "Avion [id=" + id + ", nbRoues=" + nbRoues + ", nbSiege=" + nbSiege + "]";
	}
	
	
	
}
