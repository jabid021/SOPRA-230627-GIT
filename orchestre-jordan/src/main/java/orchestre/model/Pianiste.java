package orchestre.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Pianiste implements IMusicien{

	private String prenom;
	
	@Autowired
	private Piano instrument;
	
	public Pianiste() {
		this.prenom = "Eric"; 
		//System.out.println("Eric utilise un "+instrument.getClass().getSimpleName()); ne marche que si on ajoute "Piano instrument" en parametre
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Piano getInstrument() {
		return instrument;
	}

	public void setInstrument(Piano instrument) {
		this.instrument = instrument;
	}

	public void jouer() {
		System.out.println("Le pianiste "+prenom+" joue "+instrument.son());
	}

	@Override
	public String toString() {
		return "Piano [prenom=" + prenom + ", instrument=" + instrument + "]";
	}
	
	
	
}
