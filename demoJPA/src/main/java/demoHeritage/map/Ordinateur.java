package demoHeritage.map;

public class Ordinateur extends Materiel {

	private boolean pave;
	public Ordinateur() {}
	public Ordinateur(String marque, boolean pave) {
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
