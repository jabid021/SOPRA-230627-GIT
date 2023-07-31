package escapeGame.model;

public final class Participant {
	private Integer id;
	private String nom;
	private String prenom;
	private Client client;
	
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
