package orchestre.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PublicAspect {


	@AfterReturning(pointcut="execution(public String orchestre.model.Guitariste.toString())",returning="toString")
	public void afterToStringGuitariste(String toString) 
	{
		System.out.println(toString);
		System.out.println("Le guitariste vient de se presenter");
	}

	@Pointcut("execution(public void orchestre.model.Guitariste.jouerStyle(String))")
	public void pointCutJouer(){}



	@Before("pointCutJouer() && args(styleParam)")
	public void installer(String styleParam){
		if(styleParam.equals("Rock")) 
		{
			System.out.println("Le public se leve et danse");
		}
		else 
		{
			System.out.println("Le public s'installe");
		}
	}


	@AfterReturning("pointCutJouer()")
	public void applaudir(){System.out.println("Le public applaudit");}


	@AfterThrowing("pointCutJouer()")
	public void huer(){System.out.println("Le public jette des tomates");}

}
