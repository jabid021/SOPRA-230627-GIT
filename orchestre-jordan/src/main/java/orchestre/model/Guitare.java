package orchestre.model;

public class Guitare implements IInstrument {

	public String son() {
		return "la guitare fait glink glink";
	}

	@Override
	public String toString() {
		return "Guitare []";
	}

	
}
