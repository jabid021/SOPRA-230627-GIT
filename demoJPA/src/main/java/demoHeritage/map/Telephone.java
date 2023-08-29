package demoHeritage.map;

import javax.persistence.Entity;

@Entity
public class Telephone extends Materiel {

	private String model;
	
	public Telephone() {}

	public Telephone(String marque, String model) {
		super(marque);
		this.model = model;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "Telephone [id=" + id + ", marque=" + marque + ", model=" + model + "]";
	}
	
	
}
