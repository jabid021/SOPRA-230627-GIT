package orchestre.aspect;

public class PublicAspect {
	
	public void afterToStringGuitariste(String toString) 
	{
		System.out.println(toString);
		System.out.println("Le guitariste vient de se presenter");
	}

}
