package orchestre.model;

import org.springframework.stereotype.Component;

@Component
public class Guitare implements IInstrument {

	public String son() {
		return "la guitare fait glink glink";
	}

	@Override
	public String toString() {
		return "Guitare []";
	}

	
}
