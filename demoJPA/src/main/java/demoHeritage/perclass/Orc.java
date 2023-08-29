package demoHeritage.perclass;

import javax.persistence.Entity;

@Entity
public class Orc extends Race {

	public Orc() {}

	
	public Orc(String description) {
		super(description);
	}


	@Override
	public String toString() {
		return "Orc [id=" + id + ", description=" + description + "]";
	}


	
	
	
}
