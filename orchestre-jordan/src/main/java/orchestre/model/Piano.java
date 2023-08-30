package orchestre.model;

public class Piano implements IInstrument {

	public String son() {
		return "le piano fait plink plink";
	}

	@Override
	public String toString() {
		return "Piano []";
	}

	
}
