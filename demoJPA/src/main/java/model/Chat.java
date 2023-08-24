package model;

import javax.persistence.Entity;

@Entity
public class Chat extends Animal{

	public Chat() {
		super();
	}
	public Chat(String nom) {
		super(nom);
	}

	@Override
	public String toString() {
		return "Chat [id=" + id + ", nom=" + nom + "]";
	}

	
	
}
