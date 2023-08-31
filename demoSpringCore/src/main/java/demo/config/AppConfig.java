package demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import demo.model.Canard;

@Configuration
@ComponentScan({"demo.model","demo.aspect"}) // check tous les @Component dans le package model pour creer les beans
//@ImportResource("classpath:application-context.xml") //Si on veut avoir de la config xml en plus
@EnableAspectJAutoProxy
public class AppConfig {
	
	@Bean
	public Canard monCanard() 
	{
		return new Canard("Donald");
	}

}
