package hopital.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hopital.dao.IDAOPatient;
import hopital.model.Patient;

public class DAOPatientJDBC implements IDAOPatient {

	@Override
	public Patient findById(Integer id) {
		Patient patient = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);

			PreparedStatement ps = conn.prepareStatement("SELECT * from patient where id = ?");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				patient = new Patient(id,rs.getString("prenom"),rs.getString("nom"));
			}
			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return patient;
	}

	@Override
	public List<Patient> findAll() {
		List<Patient> patients = new ArrayList();
		Patient patient = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);

			
			
		
			PreparedStatement ps = conn.prepareStatement("SELECT * from patient ");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				patient = new Patient(rs.getInt("id"),rs.getString("prenom"),rs.getString("nom"));
				patients.add(patient);
			}
			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return patients;
	}

	@Override
	public Patient insert(Patient patient) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);

			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO patient (id,prenom,nom) VALUES (?,?,?)");
			ps.setInt(1, patient.getId());
			ps.setString(2, patient.getPrenom());
			ps.setString(3, patient.getNom());
		
			ps.executeUpdate();

			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void update(Patient patient) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);

			PreparedStatement ps = conn.prepareStatement(
					"UPDATE patient set prenom=?,nom=? where id=?");
		
			ps.setString(1, patient.getPrenom());
			ps.setString(2, patient.getNom());
			ps.setInt(3, patient.getId());
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
					"DELETE FROM patient where id=?");
	
			ps.setInt(1, id);
			ps.executeUpdate();

			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
