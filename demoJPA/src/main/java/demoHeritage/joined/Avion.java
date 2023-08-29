package demoHeritage.joined;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="plane")
@PrimaryKeyJoinColumn(name="id_avion")
public class Avion extends Vehicule {

	@Column(name="sieges",nullable = false)
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
