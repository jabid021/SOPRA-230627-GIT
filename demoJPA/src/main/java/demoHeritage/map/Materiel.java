package demoHeritage.map;

public class Materiel {

	protected Integer id;
	protected String marque;
	
	
	public Materiel() {}


	public Materiel(String marque) {
		this.marque = marque;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getMarque() {
		return marque;
	}


	public void setMarque(String marque) {
		this.marque = marque;
	}
	
}
