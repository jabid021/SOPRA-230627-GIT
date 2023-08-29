package escapeGame.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("Client")
public class Client extends Compte {
	
	@Column (length = 15)
	private String tel;
	
	@Column (length = 50)
	private String mail;
	@Embedded 
	private Adresse adresse;
	
	@OneToMany(mappedBy = "client")
	private List<Participant> participants;
	@OneToMany(mappedBy = "client")
	private List<Reservation> reservations;
	
	public Client() {}
	
	public Client(Integer id,String login, String password, String nom, String prenom,String tel,String mail,Adresse adresse) {
		super(id,login, password, nom, prenom);
		this.tel=tel;
		this.mail=mail;
		this.adresse=adresse;
	}
	
	public Client(String login, String password, String nom, String prenom,String tel,String mail,Adresse adresse) {
		super(login, password, nom, prenom);
		this.tel=tel;
		this.mail=mail;
		this.adresse=adresse;
	}

	
	
	public String getTel() {
		return tel;
	}



	public void setTel(String tel) {
		this.tel = tel;
	}



	public String getMail() {
		return mail;
	}



	public void setMail(String mail) {
		this.mail = mail;
	}



	public Adresse getAdresse() {
		return adresse;
	}



	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}



	public List<Participant> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Participant> participants) {
		this.participants = participants;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", login=" + login + ", password=" + password + ", nom=" + nom + ", prenom="
				+ prenom + ", tel=" + tel + ", mail=" + mail + ", adresse=" + adresse + "]";
	}



	
	
}
