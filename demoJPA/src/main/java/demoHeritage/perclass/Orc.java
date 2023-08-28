package demoHeritage.perclass;

import javax.persistence.Entity;

@Entity
public class Orc extends Race {

	public Orc() {}

	@Override
	public String toString() {
		return "Orc [id=" + id + ", description=" + description + "]";
	}


	
	
	
}
