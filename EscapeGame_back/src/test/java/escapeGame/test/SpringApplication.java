package escapeGame.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import escapeGame.config.AppConfig;
import escapeGame.dao.IDAOCompte;

public class SpringApplication {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		ctx.getBeanFactory().createBean(App.class).run();
		ctx.close();
	}

}
