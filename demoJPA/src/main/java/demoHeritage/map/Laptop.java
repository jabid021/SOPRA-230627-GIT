package demoHeritage.map;

import javax.persistence.Entity;

@Entity
public class Laptop extends Materiel {

	private boolean pave;
	public Laptop() {}
	public Laptop(String marque, boolean pave) {
		super(marque);
		this.pave = pave;
	}
	public boolean isPave() {
		return pave;
	}
	public void setPave(boolean pave) {
		this.pave = pave;
	}
	@Override
	public String toString() {
		return "Ordinateur [id=" + id + ", marque=" + marque + ", pave=" + pave + "]";
	}
	
	
}
