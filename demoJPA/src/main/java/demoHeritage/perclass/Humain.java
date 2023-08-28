package demoHeritage.perclass;

import javax.persistence.Entity;

@Entity
public class Humain extends Race {

	private String metier;
	
	public Humain() {}

	public Humain(String description, String metier) {
		super(description);
		this.metier = metier;
	}

	public String getMetier() {
		return metier;
	}

	public void setMetier(String metier) {
		this.metier = metier;
	}

	@Override
	public String toString() {
		return "Humain [id=" + id + ", description=" + description + ", metier=" + metier + "]";
	}
	
	
}
