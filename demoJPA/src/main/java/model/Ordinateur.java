package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //Precise qu'il faut creer une table (OBLIGATOIRE)
@Table(name = "computer")
public class Ordinateur{

	@Id ///Precise que l'attribut Integer numero => primary key  (OBLIGATOIRE)
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Identity pour auto-increment (OBLIGATOIRE*)
	private Integer numero;
	
	@Enumerated(EnumType.STRING) // EnumType.Ordinal => index dans l'enum, EnumType.String => libelle dans l'enum
	@Column(columnDefinition = "ENUM('Asus','Apple','Dell')")
	private Marque marque;
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('Linux','MacOs','Windows')")
	private Os os;
	
	public Ordinateur() {} //(OBLIGATOIRE)
	
	public Ordinateur(Integer numero,Marque marque, Os os) {
		this.numero=numero;
		this.marque = marque;
		this.os = os;
	}
	
	public Ordinateur(Marque marque, Os os) {
		this.marque = marque;
		this.os = os;
	}

	public int getNumero() {
		return numero;
	}

	public Marque getMarque() {
		return marque;
	}

	public Os getOs() {
		return os;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setMarque(Marque marque) {
		this.marque = marque;
	}

	public void setOs(Os os) {
		this.os = os;
	}
	
	

	

	@Override
	public String toString() {
		return "Ordinateur [numero=" + numero + ", marque=" + marque + ", os=" + os + "]";
	}
	
	
	
	
}
