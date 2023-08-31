package demo.aspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectBlague {
	
	@Pointcut("execution(public void demo.model.Canard.faireBlague())")
	public void pointcutBlague() {}

	
	@Before("pointcutBlague()")
	public void avantBlague() 
	{
		System.out.println("Tout le monde est pret a ecouter la blague");
	}
	
	
	@Before("execution( * *.*(..))")
	public void partout() 
	{
		System.out.println("Apparait tout le temps");
	}
	
	@After("pointcutBlague()")
	public void apresBlague() 
	{
		System.out.println("AHAHAHAHAHAH");
	}

	@Around("execution(public void demo.model.Canard.faireBlague())")
	public void autoursBlague(ProceedingJoinPoint pj) throws Throwable
	{
		System.out.println("Tout le monde est pret a ecouter la blague");
		pj.proceed();
		System.out.println("AHAHAHAHAHAH");
	}
	
	@AfterReturning(pointcut = "execution(public int demo.model.Canard.fonctionQuiRetourneUnAge()) ",returning = "ageReturn")
	public void seLanceApresAge(int ageReturn) 
	{
		System.out.println("L'aspect a recup le return la value du Canard : On a return "+ageReturn);
	}
	
	
}
