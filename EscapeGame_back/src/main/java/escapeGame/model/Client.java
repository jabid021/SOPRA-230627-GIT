package escapeGame.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Client")
public class Client extends Compte {
	
	@Column (length = 15 , nullable=true)
	private String tel;
	
	@Column (length = 50, nullable=true)
	private String mail;
	@Embedded 
	@Column(nullable = true)
	private Adresse adresse;
	
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



	@Override
	public String toString() {
		return "Client [id=" + id + ", login=" + login + ", password=" + password + ", nom=" + nom + ", prenom="
				+ prenom + ", tel=" + tel + ", mail=" + mail + ", adresse=" + adresse + "]";
	}



	
	
}
