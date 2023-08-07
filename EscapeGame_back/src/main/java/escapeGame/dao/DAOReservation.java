package escapeGame.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import escapeGame.model.Client;
import escapeGame.model.GameMaster;
import escapeGame.model.Participant;
import escapeGame.model.Reservation;
import escapeGame.model.Salle;

public class DAOReservation implements IDAOReservation {

	@Override
	public Reservation findById(Integer id) {
		DAOCompte daoCompte = new DAOCompte();
		DAOSalle daoSalle = new DAOSalle();
		
		Reservation reservation = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);

			PreparedStatement ps = conn.prepareStatement("SELECT * from reservation where id=?");

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Client client = (Client) daoCompte.findById(rs.getInt("client"));
				Salle salle = daoSalle.findById(rs.getInt("salle"));
				GameMaster gameMaster = (GameMaster) daoCompte.findById(rs.getInt("gm"));
				reservation = new Reservation(rs.getInt("id"), LocalDate.parse(rs.getString("date_reservation")),
						LocalTime.parse(rs.getString("heure_reservation")), rs.getInt("timer"), rs.getString("equipe"),
						rs.getDouble("prix"), client, salle, gameMaster);
			}
			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return reservation;
	}

	@Override
	public List<Reservation> findAll() {
		DAOCompte daoCompte = new DAOCompte();
		DAOSalle daoSalle = new DAOSalle();
		
		List<Reservation> reservations = new ArrayList();
		Reservation reservation = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);

			PreparedStatement ps = conn.prepareStatement("SELECT * from reservation");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Client client = (Client) daoCompte.findById(rs.getInt("client"));
				Salle salle = daoSalle.findById(rs.getInt("salle"));
				GameMaster gameMaster = (GameMaster) daoCompte.findById(rs.getInt("gm"));
				reservation = new Reservation(rs.getInt("id"), LocalDate.parse(rs.getString("date_reservation")),
						LocalTime.parse(rs.getString("heure_reservation")), rs.getInt("timer"), rs.getString("equipe"),
						rs.getDouble("prix"), client, salle, gameMaster);
				reservations.add(reservation);
			}
			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return reservations;
	}

	@Override
	public Reservation insert(Reservation reservation) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);

			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO reservation (date_reservation,heure_reservation,timer,prix,equipe,client,salle,gm) VALUES (?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, reservation.getDateReservation().toString());
			ps.setString(2, reservation.getHeureReservation().toString());
			ps.setObject(3, reservation.getTimer());
			ps.setDouble(4, reservation.getPrix());
			ps.setString(5, reservation.getEquipe());
			ps.setInt(6, reservation.getClient().getId());
			ps.setInt(7, reservation.getSalle().getId());
			ps.setObject(8, null);

			ps.executeUpdate();
			
			Integer idAuto;
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) 
			{
				idAuto=rs.getInt(1);
				for(Participant participant : reservation.getParticipants()) 
				{
					PreparedStatement ps2 = conn.prepareStatement("INSERT INTO inscription (participant,reservation) VALUES (?,?)");
					ps2.setInt(1, participant.getId());
					ps2.setInt(2, idAuto);
					ps2.executeUpdate();
					ps2.close();
				}
			}
			

			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void update(Reservation reservation) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);

			PreparedStatement ps = conn.prepareStatement(
					"UPDATE reservation set date_reservation=?,heure_reservation=?,timer=?,prix=?,equipe=?,client=?,salle=?,gm=? where id=?");

			ps.setString(1, reservation.getDateReservation().toString());
			ps.setString(2, reservation.getHeureReservation().toString());
			ps.setObject(3, reservation.getTimer());
			ps.setDouble(4, reservation.getPrix());
			ps.setString(5, reservation.getEquipe());
			ps.setInt(6, reservation.getClient().getId());
			ps.setInt(7, reservation.getSalle().getId());

			if (reservation.getGameMaster() != null) {
				ps.setInt(8, reservation.getGameMaster().getId());
			} else {
				ps.setObject(8, null);
			}
			ps.setInt(9, reservation.getId());

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

			PreparedStatement ps = conn.prepareStatement("DELETE from inscription where reservation=?");
			ps.setInt(1, id);
			ps.executeUpdate();
			
			ps.close();
			
			ps = conn.prepareStatement(
					"DELETE from reservation where id=?");

			ps.setInt(1, id);

			ps.executeUpdate();

			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Reservation> findByGameMasterAndDateReservationGreaterThan(GameMaster gameMaster,
			LocalDate date) {
		
		DAOCompte daoCompte = new DAOCompte();
		DAOSalle daoSalle = new DAOSalle();
		
		List<Reservation> reservations = new ArrayList();
		Reservation reservation = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);

			PreparedStatement ps = conn
					.prepareStatement("SELECT * from reservation where gm=? and date_reservation > ?");

			ps.setInt(1, gameMaster.getId());
			ps.setString(2, date.toString());

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Client client = (Client) daoCompte.findById(rs.getInt("client"));
				Salle salle = daoSalle.findById(rs.getInt("salle"));
				reservation = new Reservation(rs.getInt("id"), LocalDate.parse(rs.getString("date_reservation")),
						LocalTime.parse(rs.getString("heure_reservation")), rs.getInt("timer"), rs.getString("equipe"),
						rs.getDouble("prix"), client, salle, gameMaster);
				reservations.add(reservation);
			}
			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return reservations;
	}

}
