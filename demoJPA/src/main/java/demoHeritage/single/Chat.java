package demoHeritage.single;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("cat")
public class Chat extends Animal{

	public Chat() {}
	
	public Chat(String nom) {
		super(nom);
	}

	@Override
	public String toString() {
		return "Chat [id=" + id + ", nom=" + nom + "]";
	}

	
	
}
