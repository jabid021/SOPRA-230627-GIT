package orchestre.test;

import org.springframework.beans.factory.annotation.Autowired;

import orchestre.model.IMusicien;

public class Test {

	@Autowired
	IMusicien guitariste;
	@Autowired
	IMusicien flutiste;
	@Autowired
	IMusicien musicien;
	@Autowired
	IMusicien pianiste;
	
	public void run(String ...args) {

		guitariste.jouerStyle("Rock");
		//pianiste.jouer();
		//flutiste.jouer();
		//musicien.jouer();
		
		
	//	guitariste.toString();
		

	}

}
