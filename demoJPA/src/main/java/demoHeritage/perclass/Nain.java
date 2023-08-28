package demoHeritage.perclass;

import javax.persistence.Entity;

@Entity
public class Nain extends Race {

	private int pieces;
	
	public Nain() {}

	public Nain(String description, int pieces) {
		super(description);
		this.pieces = pieces;
	}

	public int getPieces() {
		return pieces;
	}

	public void setPieces(int pieces) {
		this.pieces = pieces;
	}

	@Override
	public String toString() {
		return "Nain [id=" + id + ", description=" + description + ", pieces=" + pieces + "]";
	}
	
	
}
