package escapeGame.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import escapeGame.model.Client;
import escapeGame.model.Participant;

public class DAOParticipant implements IDAOParticipant {

	@Override
	public Participant findById(Integer id) {
		DAOCompte daoCompte =new DAOCompte();
		List<Participant> participants = new ArrayList();
		Participant participant = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);

			PreparedStatement ps = conn.prepareStatement("SELECT * from participant WHERE id=?");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				participant = new Participant(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"),
						(Client) daoCompte.findById(rs.getInt("client")));

			}
			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return participant;
	}

	@Override
	public List<Participant> findAll() {
		DAOCompte daoCompte =new DAOCompte();
		List<Participant> participants = new ArrayList();
		Participant participant = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);

			PreparedStatement ps = conn.prepareStatement("SELECT * from participant");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				participant = new Participant(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"),
						(Client) daoCompte.findById(rs.getInt("client")));
				participants.add(participant);
			}
			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return participants;
	}

	@Override
	public Participant insert(Participant participant) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);

			PreparedStatement ps = conn.prepareStatement("INSERT INTO participant (nom,prenom,client) VALUES (?,?,?)",Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, participant.getNom());
			ps.setString(2, participant.getPrenom());
			ps.setInt(3, participant.getClient().getId());

			ps.executeUpdate();

			ResultSet rs= ps.getGeneratedKeys();
			
			if(rs.next()) 
			{
				participant.setId(rs.getInt(1));
			}
			
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void update(Participant participant) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);

			PreparedStatement ps = conn.prepareStatement("DELETE from inscription where participant=?");
			ps.setInt(1, id);
			ps.executeUpdate();
			
			ps.close();
			
			ps = conn.prepareStatement(
					"DELETE FROM participant where id=?");
			ps.setInt(1, id);
			

			ps.executeUpdate();

			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Participant> findAllByClient(Client client) {
		List<Participant> participants = new ArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);

			PreparedStatement ps = conn.prepareStatement("SELECT * from participant where client=?");

			ps.setInt(1, client.getId());

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Participant p = new Participant(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), client);
				participants.add(p);
			}
			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return participants;
	}

}
