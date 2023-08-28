package escapeGame.model;

import javax.persistence.Entity;

@Entity
public class Mecanisme extends Materiel {
    private boolean electrique;

    public Mecanisme() {
		// TODO Auto-generated constructor stub
	}
    public Mecanisme(Integer id,String libelle, Salle salle, Etat etat, boolean electrique) {
        super(id,libelle,salle,etat);
        this.electrique = electrique;
    }
    
    public Mecanisme(String libelle, Salle salle, Etat etat, boolean electrique) {
        super(libelle,salle,etat);
        this.electrique = electrique;
    }

    public boolean isElectrique() {
        return electrique;
    }


    public void setEletrique(boolean electrique) {
        this.electrique = electrique;
    }

	@Override
	public String toString() {
		return "Mecanisme [id=" + id + ", libelle=" + libelle + ", salle=" + salle + ", etat=" + etat + ", electrique="
				+ electrique + "]";
	}

	



}