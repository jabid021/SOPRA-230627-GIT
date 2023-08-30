package demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import demo.model.Canard;

@Configuration
@ComponentScan("demo.model")
@ImportResource("classpath:application-context.xml")
public class AppConfig {
	
	@Bean
	public Canard monCanard() 
	{
		return new Canard("Donald");
	}

}
