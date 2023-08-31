package demo.aspect;
import org.aspectj.lang.ProceedingJoinPoint;
public class AspectBlague {
	
	public void avantBlague() 
	{
		System.out.println("Tout le monde est pret a ecouter la blague");
	}
	
	
	
	public void partout() 
	{
		System.out.println("Apparait tout le temps");
	}
	
	public void apresBlague() 
	{
		System.out.println("AHAHAHAHAHAH");
	}

	
	public void autoursBlague(ProceedingJoinPoint pj) throws Throwable
	{
		System.out.println("Tout le monde est pret a ecouter la blague");
		pj.proceed();
		System.out.println("AHAHAHAHAHAH");
	}
	
	
	public void seLanceApresAge(int ageReturn) 
	{
		System.out.println("L'aspect a recup le return la value du Canard : On a return "+ageReturn);
	}
	
	
}
