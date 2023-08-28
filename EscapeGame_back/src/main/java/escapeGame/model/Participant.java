package escapeGame.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="participant")
public class Participant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 25, nullable = false)
	private String nom;
	
	@Column(length = 25, nullable = false)
	private String prenom;
	
	@ManyToOne
	@JoinColumn(name="client",nullable = false)
	private Client client;
	
	public Participant() {
		// TODO Auto-generated constructor stub
	}
	
	public Participant(Integer id,String nom, String prenom,Client client) {
		this.id=id;
		this.nom = nom;
		this.prenom = prenom;
		this.client=client;
	}

	
	public Participant(String nom, String prenom,Client client) {
		this.nom = nom;
		this.prenom = prenom;
		this.client=client;
	}

	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Participant [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", client=" + client + "]";
	}

	

	
	



}
