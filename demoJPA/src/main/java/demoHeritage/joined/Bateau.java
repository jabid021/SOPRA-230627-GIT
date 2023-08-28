
package demoHeritage.joined;

import javax.persistence.Entity;

@Entity
public class Bateau extends Vehicule {

	
	
	public Bateau() {}

	public Bateau(int nbRoues) {
		super(nbRoues);
	}

	@Override
	public String toString() {
		return "Bateau [id=" + id + ", nbRoues=" + nbRoues + "]";
	}

	
	
	
}
