package demo.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import demo.model.Canard;

public class Test {

	public static void main(String[] args) {
		
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:application-context.xml");
		
		Canard c1 =  (Canard) ctx.getBean("canard");
		System.out.println(c1);

		System.out.println(c1.getArme());

	}

}
