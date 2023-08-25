package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Centre {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private Integer id;
	private String nom;
	
	@OneToMany
	private List<Session> sessions=new ArrayList();
	
	public Centre() {
	}


	public Centre(String nom) {
		this.nom = nom;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public List<Session> getSessions() {
		return sessions;
	}


	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}


	@Override
	public String toString() {
		return "Centre [id=" + id + ", nom=" + nom + "]";
	}
	
	
}
