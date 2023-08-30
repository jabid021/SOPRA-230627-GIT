package demo.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import demo.config.AppConfig;
import demo.model.Canard;

public class Test {

	public static void main(String[] args) {
		
		
		//ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:application-context.xml");
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

		Canard c1 =  (Canard) ctx.getBean("monCanard");
		System.out.println(c1);

		System.out.println(c1.getArme());

	}

}
