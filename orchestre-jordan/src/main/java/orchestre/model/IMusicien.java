package orchestre.model;

public interface IMusicien {

	public void jouer();
	
	public default void jouerStyle(String style) {};
}
