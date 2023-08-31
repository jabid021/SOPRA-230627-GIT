package quest.test;

import org.springframework.beans.factory.annotation.Autowired;

import quest.service.MatiereService;

public class Test {

	@Autowired
	MatiereService matiereSrv;
	
	public void run(String ...args) {
		
		
		System.out.println(matiereSrv.getAll());
	}
}
