package escapeGame.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="reservation")
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="date_reservation", nullable=false)
	private LocalDate dateReservation;
	@Column(name="heure_reservation", nullable=false)
	private LocalTime heureReservation;
	private Integer timer;
	@Column(nullable=false)
	private String equipe;
	
	@ManyToOne
	@JoinColumn(name="client", nullable=false)
	private Client client;
	
	@ManyToOne
	@JoinColumn(name="salle",nullable=false)
	private Salle salle;

	@Column(columnDefinition="decimal(5,2)")
	private double prix;
	
	@ManyToOne
	@JoinColumn(name="gm")
	private GameMaster gameMaster;
	
	@ManyToMany
	@JoinTable(name="inscription",joinColumns = @JoinColumn(name="reservation"),inverseJoinColumns = @JoinColumn(name="participant"))
	private List<Participant> participants=new ArrayList();

	public Reservation() {}
	
	public Reservation(Integer id,LocalDate dateReservation, LocalTime heureReservation, Integer timer, String equipe,
			double prix,Client client, Salle salle,GameMaster gameMaster) {
		this.id=id;
		this.dateReservation = dateReservation;
		this.heureReservation = heureReservation;
		this.timer = timer;
		this.prix=prix;
		this.equipe = equipe;
		this.client = client;
		this.salle = salle;
		this.gameMaster = gameMaster;
	}
	
	public Reservation(LocalDate dateReservation, LocalTime heureReservation, Integer timer, String equipe,
			double prix,Client client, Salle salle,GameMaster gameMaster) {
		this.dateReservation = dateReservation;
		this.heureReservation = heureReservation;
		this.timer = timer;
		this.prix=prix;
		this.equipe = equipe;
		this.client = client;
		this.salle = salle;
		this.gameMaster=gameMaster;
	}

	public LocalDate getDateReservation() {
		return dateReservation;
	}

	public LocalTime getHeureReservation() {
		return heureReservation;
	}

	public Integer getTimer() {
		return timer;
	}

	public String getEquipe() {
		return equipe;
	}

	public Client getClient() {
		return client;
	}

	public Salle getSalle() {
		return salle;
	}

	
	public void setEquipe(String equipe) {
		this.equipe = equipe;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	

	public void setDateReservation(LocalDate dateReservation) {
		this.dateReservation = dateReservation;
	}

	public void setHeureReservation(LocalTime heureReservation) {
		this.heureReservation = heureReservation;
	}

	public void setTimer(Integer timer) {
		this.timer = timer;
	}
	

	public List<Participant> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Participant> participants) {
		this.participants = participants;
	}

	
	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public GameMaster getGameMaster() {
		return gameMaster;
	}

	public void setGameMaster(GameMaster gameMaster) {
		this.gameMaster = gameMaster;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", dateReservation=" + dateReservation + ", heureReservation="
				+ heureReservation + ", timer=" + timer + ", equipe=" + equipe + ", client=" + client + ", salle="
				+ salle + ", prix=" + prix + ", gameMaster=" + gameMaster + "]";
	}

	


	
	
	
}
