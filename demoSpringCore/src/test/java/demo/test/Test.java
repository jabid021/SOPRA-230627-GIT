package demo.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import demo.config.AppConfig;
import demo.model.Canard;

public class Test {

	public static void main(String[] args) {
		
		//Si la config principale est en xml :
		//ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:application-context.xml");
		
		//Si la config principale est en Java
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

		Canard c1 =  (Canard) ctx.getBean("monCanard");
		//System.out.println(c1);
		//System.out.println(c1);

		//System.out.println(c1.getArme());

		
		c1.faireBlague();
		
		c1.fonctionQuiRetourneUnAge();
	}

}
