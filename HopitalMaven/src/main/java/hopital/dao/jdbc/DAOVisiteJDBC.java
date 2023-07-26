package hopital.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import hopital.context.Singleton;
import hopital.dao.IDAOCompte;
import hopital.dao.IDAOPatient;
import hopital.dao.IDAOVisite;
import hopital.model.Medecin;
import hopital.model.Patient;
import hopital.model.Visite;

public class DAOVisiteJDBC implements IDAOVisite {

	@Override
	public Visite findById(Integer id) {
		IDAOCompte daoCompte= Singleton.getInstance().getDaoCompte();
		IDAOPatient daoPatient = Singleton.getInstance().getDaoPatient();


		Visite visite = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);

			PreparedStatement ps = conn.prepareStatement("SELECT * from visite where numero = ?");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Patient patient = daoPatient.findById(rs.getInt("id_patient"));
				Medecin medecin = (Medecin) daoCompte.findById(rs.getInt("id_medecin"));
				visite = new Visite(id,rs.getDouble("prix"),rs.getInt("salle"),LocalDate.parse(rs.getString("date_visite")),medecin,patient);
			}
			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return visite;
	}

	@Override
	public List<Visite> findAll() {

		IDAOCompte daoCompte= Singleton.getInstance().getDaoCompte();
		IDAOPatient daoPatient = Singleton.getInstance().getDaoPatient();


		List<Visite> visites = new ArrayList();
		Visite visite = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);

			PreparedStatement ps = conn.prepareStatement("SELECT * from visite");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Patient patient = daoPatient.findById(rs.getInt("id_patient"));
				Medecin medecin = (Medecin) daoCompte.findById(rs.getInt("id_medecin"));
				visite = new Visite(rs.getInt("numero"),rs.getDouble("prix"),rs.getInt("salle"),LocalDate.parse(rs.getString("date_visite")),medecin,patient);
				visites.add(visite);
			}
			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return visites;
	}

	@Override
	public Visite insert(Visite visite) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);

			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO visite (prix,salle,date_visite,id_patient,id_medecin) VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			ps.setDouble(1, visite.getPrix());
			ps.setInt(2, visite.getSalle());
			ps.setString(3, visite.getDateVisite().toString());
			ps.setInt(4, visite.getPatient().getId());
			ps.setInt(5, visite.getMedecin().getId());

			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();

			if(rs.next()) 
			{
				visite.setNumero(rs.getInt(1));
			}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void update(Visite visite) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);

			PreparedStatement ps = conn.prepareStatement(
					"UPDATE visite set prix=?,salle=?, date_visite=?,id_patient=?, id_medecin=? where numero=?");

			ps.setDouble(1, visite.getPrix());
			ps.setInt(2, visite.getSalle());
			ps.setString(3, visite.getDateVisite().toString());
			ps.setInt(4, visite.getPatient().getId());
			ps.setInt(5, visite.getMedecin().getId());
			ps.setInt(6, visite.getNumero());

			ps.executeUpdate();

			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Integer id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);

			PreparedStatement ps = conn.prepareStatement(
					"DELETE FROM visite where numero=?");

			ps.setInt(1, id);
			ps.executeUpdate();

			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public List<Visite> findAllByPatient(Patient patient) {

		IDAOCompte daoCompte= Singleton.getInstance().getDaoCompte();


		List<Visite> visites = new ArrayList();
		Visite visite = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);

			PreparedStatement ps = conn.prepareStatement("SELECT * from visite where id_patient=?");
			ps.setInt(1,patient.getId());

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Medecin medecin = (Medecin) daoCompte.findById(rs.getInt("id_medecin"));
				visite = new Visite(rs.getInt("numero"),rs.getDouble("prix"),rs.getInt("salle"),LocalDate.parse(rs.getString("date_visite")),medecin,patient);
				visites.add(visite);
			}
			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return visites;
	}
}
