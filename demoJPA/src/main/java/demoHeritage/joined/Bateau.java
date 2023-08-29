
package demoHeritage.joined;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="ship")
@PrimaryKeyJoinColumn(name="id_bateau")
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
