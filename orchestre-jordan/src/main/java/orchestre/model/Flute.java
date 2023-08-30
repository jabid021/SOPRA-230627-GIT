package orchestre.model;

import org.springframework.stereotype.Component;

@Component
public class Flute implements IInstrument {

	public String son() {
		return "la flute fait flink flink";
	}

	@Override
	public String toString() {
		return "Flute []";
	}

	
}
