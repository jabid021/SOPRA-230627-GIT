package escapeGame.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

@Entity
@Table(name="salle")
public class Salle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(columnDefinition = "default 2")
	private int min; 
	private int max;
	@Column(length=25, nullable=false)
	private String titre;
	@Column(columnDefinition = "text")
	private String description;
	@Column(columnDefinition = "default 60")
	private int duree;
	@Column(columnDefinition = "decimal(4,2)")
	private double prix;
	@Column(columnDefinition = "tinyint(1)")
	private boolean accessibilite;
	
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('Debutant', 'Intermediaire', 'Expert')", nullable = false)
	private Difficulte difficulte;
	
	@ElementCollection(targetClass = Caracteristique.class,fetch = FetchType.EAGER)
    @JoinTable(name = "caracteristique", joinColumns = @JoinColumn(name = "salle"))
    @Column(name = "label", nullable = false,columnDefinition = "ENUM('Fouille', 'Observation', 'Reflexion', 'Action')")
    @Enumerated(EnumType.STRING)
	private List<Caracteristique> caracteristiques = new ArrayList();
	
	public Salle() {}
	
	public Salle(Integer id,int min, int max, String titre, String description, int duree, double prix, boolean accessible,
			Difficulte difficulte) {
		this.id=id;
		this.min = min;
		this.max = max;
		this.titre = titre;
		this.description = description;
		this.duree = duree;
		this.prix = prix;
		this.accessibilite = accessible;
		this.difficulte = difficulte;
	
		
	}
	
	public Salle(int min, int max, String titre, String description, int duree, double prix, boolean accessible,
			Difficulte difficulte) {
		this.min = min;
		this.max = max;
		this.titre = titre;
		this.description = description;
		this.duree = duree;
		this.prix = prix;
		this.accessibilite = accessible;
		this.difficulte = difficulte;
	}
	public int getMin() {
		return min;
	}
	public int getMax() {
		return max;
	}
	public String getTitre() {
		return titre;
	}
	public String getDescription() {
		return description;
	}
	public int getDuree() {
		return duree;
	}
	public double getPrix() {
		return prix;
	}
	public boolean isAccessibilite() {
		return accessibilite;
	}
	public Difficulte getDifficulte() {
		return difficulte;
	}
	
	public List<Caracteristique> getCaracteristiques() {
		return caracteristiques;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public void setAccessibilite(boolean accessible) {
		this.accessibilite = accessible;
	}
	public void setDifficulte(Difficulte difficulte) {
		this.difficulte = difficulte;
	}
	
	public void setCaracteristiques(List<Caracteristique> caracteristiques) {
		this.caracteristiques = caracteristiques;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Salle [id=" + id + ", min=" + min + ", max=" + max + ", titre=" + titre + ", duree=" + duree + ", prix=" + prix + ", accessibilite=" + accessibilite + ", difficulte="
				+ difficulte + ", caracteristiques=" + caracteristiques + "]";
	}

	
	
	
	
	
	
	

}
