package quest.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "matiere")
public class Matiere {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Version
	private int version;

	@Column(length = 25, nullable = false)

	@NotBlank(message = "Le libellé est obligatoire")
	private String libelle;

	@Column(columnDefinition = "INTEGER(4)")

	@NotNull(message = "Code Quest manquant")
	@Max(value = 9999, message = "Code Quest sur 4 chiffres max")
	private int quest;

	@ManyToOne
	@JoinColumn(name = "filiere_id")
	private Filiere filiere;

	public Matiere() {
	}

	public Matiere(Integer id, String libelle, int quest) {
		this.id = id;
		this.libelle = libelle;
		this.quest = quest;
	}

	public Matiere(String libelle, int quest) {
		this.libelle = libelle;
		this.quest = quest;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public int getQuest() {
		return quest;
	}

	public void setQuest(int quest) {
		this.quest = quest;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Filiere getFiliere() {
		return filiere;
	}

	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}

	@Override
	public String toString() {
		return "Matiere [id=" + id + ", libelle=" + libelle + ", quest=" + quest + "]";
	}

}
