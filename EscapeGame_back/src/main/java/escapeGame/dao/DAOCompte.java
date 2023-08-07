package escapeGame.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import escapeGame.model.Adresse;
import escapeGame.model.Client;
import escapeGame.model.Compte;
import escapeGame.model.GameMaster;
import escapeGame.model.Gerant;

public class DAOCompte implements IDAOCompte {

	@Override
	public Compte findById(Integer id) {
		Compte compte = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);

			PreparedStatement ps = conn.prepareStatement("SELECT * from compte where id=?");

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				if (rs.getString("type_compte").equals("Gerant")) {
					compte = new Gerant(rs.getInt("id"), rs.getString("login"), rs.getString("password"),
							rs.getString("nom"), rs.getString("prenom"));
				} else if (rs.getString("type_compte").equals("GameMaster")) {
					compte = new GameMaster(rs.getInt("id"), rs.getString("login"), rs.getString("password"),
							rs.getString("nom"), rs.getString("prenom"));
				} else if (rs.getString("type_compte").equals("Client")) {
					Adresse adresse = new Adresse(rs.getString("numero"), rs.getString("voie"), rs.getString("ville"),
							rs.getString("cp"));
					compte = new Client(rs.getInt("id"), rs.getString("login"), rs.getString("password"),
							rs.getString("nom"), rs.getString("prenom"), rs.getString("tel"), rs.getString("mail"),
							adresse);
				}
			}
			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return compte;
	}

	@Override
	public List<Compte> findAll() {
		List<Compte> comptes = new ArrayList();
		Compte compte = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);

			PreparedStatement ps = conn.prepareStatement("SELECT * from compte");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				if (rs.getString("type_compte").equals("Gerant")) {
					compte = new Gerant(rs.getInt("id"), rs.getString("login"), rs.getString("password"),
							rs.getString("nom"), rs.getString("prenom"));
				} else if (rs.getString("type_compte").equals("GameMaster")) {
					compte = new GameMaster(rs.getInt("id"), rs.getString("login"), rs.getString("password"),
							rs.getString("nom"), rs.getString("prenom"));
				} else if (rs.getString("type_compte").equals("Client")) {
					Adresse adresse = new Adresse(rs.getString("numero"), rs.getString("voie"), rs.getString("ville"),
							rs.getString("cp"));
					compte = new Client(rs.getInt("id"), rs.getString("login"), rs.getString("password"),
							rs.getString("nom"), rs.getString("prenom"), rs.getString("tel"), rs.getString("mail"),
							adresse);
				}
				comptes.add(compte);
			}
			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return comptes;
	}

	@Override
	public Compte insert(Compte compte) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);

			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO compte (login, password, nom, prenom,tel,mail,numero,voie,ville,cp,type_compte) VALUES (?,?,?,?,?,?,?,?,?,?,?)");

			if (compte instanceof Gerant) {

				ps.setString(1, compte.getLogin());
				ps.setString(2, compte.getPassword());
				ps.setString(3, compte.getNom());
				ps.setString(4, compte.getPrenom());
				ps.setString(5, null);
				ps.setString(6, null);
				ps.setString(7, null);
				ps.setString(8, null);
				ps.setString(9, null);
				ps.setString(10, null);
				ps.setString(11, "Gerant");

			} else if (compte instanceof GameMaster) {

				ps.setString(1, compte.getLogin());
				ps.setString(2, compte.getPassword());
				ps.setString(3, compte.getNom());
				ps.setString(4, compte.getPrenom());
				ps.setString(5, null);
				ps.setString(6, null);
				ps.setString(7, null);
				ps.setString(8, null);
				ps.setString(9, null);
				ps.setString(10, null);
				ps.setString(11, "GameMaster");

			} else if (compte instanceof Client) {
				Client client = (Client) compte;
				ps.setString(1, compte.getLogin());
				ps.setString(2, compte.getPassword());
				ps.setString(3, compte.getNom());
				ps.setString(4, compte.getPrenom());
				ps.setString(5, client.getTel());
				ps.setString(6, client.getMail());
				ps.setString(7, client.getAdresse().getNumero());
				ps.setString(8, client.getAdresse().getVoie());
				ps.setString(9, client.getAdresse().getVille());
				ps.setString(10, client.getAdresse().getCp());
				ps.setString(11, "Client");

			}

			ps.executeUpdate();

			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void update(Compte compte) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);

			PreparedStatement ps = conn.prepareStatement(
					"UPDATE compte set login=?, password=?, nom=?, prenom=?,tel=?,mail=?,numero=?,voie=?,ville=?,cp=?,type_compte=? where id=?");

			if (compte instanceof Gerant) {

				ps.setString(1, compte.getLogin());
				ps.setString(2, compte.getPassword());
				ps.setString(3, compte.getNom());
				ps.setString(4, compte.getPrenom());
				ps.setString(5, null);
				ps.setString(6, null);
				ps.setString(7, null);
				ps.setString(8, null);
				ps.setString(9, null);
				ps.setString(10, null);
				ps.setString(11, "Gerant");
				ps.setInt(12, compte.getId());

			} else if (compte instanceof GameMaster) {

				ps.setString(1, compte.getLogin());
				ps.setString(2, compte.getPassword());
				ps.setString(3, compte.getNom());
				ps.setString(4, compte.getPrenom());
				ps.setString(5, null);
				ps.setString(6, null);
				ps.setString(7, null);
				ps.setString(8, null);
				ps.setString(9, null);
				ps.setString(10, null);
				ps.setString(11, "GameMaster");
				ps.setInt(12, compte.getId());

			} else if (compte instanceof Client) {
				Client client = (Client) compte;
				ps.setString(1, compte.getLogin());
				ps.setString(2, compte.getPassword());
				ps.setString(3, compte.getNom());
				ps.setString(4, compte.getPrenom());
				ps.setString(5, client.getTel());
				ps.setString(6, client.getMail());
				ps.setString(7, client.getAdresse().getNumero());
				ps.setString(8, client.getAdresse().getVoie());
				ps.setString(9, client.getAdresse().getVille());
				ps.setString(10, client.getAdresse().getCp());
				ps.setString(11, "Client");
				ps.setInt(12, compte.getId());

			}

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
					"DELETE FROM compte where id=?");


			ps.setInt(1, id);


			ps.executeUpdate();

			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	public Compte findByLoginAndPassword(String login, String password) {
		Compte compte = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);

			PreparedStatement ps = conn.prepareStatement("SELECT * from compte where login=? and password=?");

			ps.setString(1, login);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				if (rs.getString("type_compte").equals("Gerant")) {
					compte = new Gerant(rs.getInt("id"), login, password, rs.getString("nom"), rs.getString("prenom"));
				} else if (rs.getString("type_compte").equals("GameMaster")) {
					compte = new GameMaster(rs.getInt("id"), login, password, rs.getString("nom"),
							rs.getString("prenom"));
				} else if (rs.getString("type_compte").equals("Client")) {
					Adresse adresse = new Adresse(rs.getString("numero"), rs.getString("voie"), rs.getString("ville"),
							rs.getString("cp"));
					compte = new Client(rs.getInt("id"), login, password, rs.getString("nom"), rs.getString("prenom"),
							rs.getString("tel"), rs.getString("mail"), adresse);
				}
			}
			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return compte;

	}

	public List<GameMaster> findAllGameMaster() {
		List<GameMaster> gameMasters = new ArrayList();
		GameMaster gm = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);

			PreparedStatement ps = conn.prepareStatement("SELECT * from compte where type_compte ='GameMaster'");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				gm = new GameMaster(rs.getInt("id"), rs.getString("login"), rs.getString("password"),
						rs.getString("nom"), rs.getString("prenom"));
				gameMasters.add(gm);
			}
			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return gameMasters;
	}


}
