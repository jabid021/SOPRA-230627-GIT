package demo.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import demo.model.Canard;

public class Test {

	public static void main(String[] args) {
		
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:application-context.xml");
		
		
		Canard c1 =  (Canard) ctx.getBean("toto");
		//Canard c2 =  (Canard) ctx.getBean(Canard.class);
		Canard c3 =  (Canard) ctx.getBean("titi",Canard.class);
		System.out.println(c3);


	}

}
