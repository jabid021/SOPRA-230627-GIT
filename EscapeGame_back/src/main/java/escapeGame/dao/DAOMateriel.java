package escapeGame.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import escapeGame.model.Cadenas;
import escapeGame.model.Coffre;
import escapeGame.model.Etat;
import escapeGame.model.Materiel;
import escapeGame.model.Mecanisme;
import escapeGame.model.Salle;

public class DAOMateriel implements IDAOMateriel {

	@Override
	public Materiel findById(Integer id) {
		DAOSalle daoSalle =new DAOSalle();
		Materiel materiel = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);

			PreparedStatement ps = conn.prepareStatement("SELECT * from materiel where id = ?");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Salle salle = null;
				Integer idSalle = rs.getInt("salle");
				if (idSalle != null) {
					salle = daoSalle.findById(idSalle);
				}
				if (rs.getString("type_materiel").equals("Cadenas")) {
					materiel = new Cadenas(rs.getInt("id"), rs.getString("libelle"), salle,
							Etat.valueOf(rs.getString("etat")), rs.getString("code"));

				} else if (rs.getString("type_materiel").equals("Coffre")) {
					materiel = new Coffre(rs.getInt("id"), rs.getString("libelle"), salle,
							Etat.valueOf(rs.getString("etat")), rs.getString("code"), rs.getInt("attente"));

				} else if (rs.getString("type_materiel").equals("Mecanisme")) {
					materiel = new Mecanisme(rs.getInt("id"), rs.getString("libelle"), salle,
							Etat.valueOf(rs.getString("etat")), rs.getBoolean("electrique"));

				}

			}
			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return materiel;
	}

	@Override
	public List<Materiel> findAll() {
		DAOSalle daoSalle =new DAOSalle();
		List<Materiel> materiels = new ArrayList();
		Materiel materiel = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);

			PreparedStatement ps = conn.prepareStatement("SELECT * from materiel");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Salle salle = null;
				Integer idSalle = rs.getInt("salle");
				if (idSalle != null) {
					salle = daoSalle.findById(idSalle);
				}

				if (rs.getString("type_materiel").equals("Cadenas")) {
					materiel = new Cadenas(rs.getInt("id"), rs.getString("libelle"), salle,
							Etat.valueOf(rs.getString("etat")), rs.getString("code"));

				} else if (rs.getString("type_materiel").equals("Coffre")) {
					materiel = new Coffre(rs.getInt("id"), rs.getString("libelle"), salle,
							Etat.valueOf(rs.getString("etat")), rs.getString("code"), rs.getInt("attente"));

				} else if (rs.getString("type_materiel").equals("Mecanisme")) {
					materiel = new Mecanisme(rs.getInt("id"), rs.getString("libelle"), salle,
							Etat.valueOf(rs.getString("etat")), rs.getBoolean("electrique"));

				}
				materiels.add(materiel);
			}
			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return materiels;
	}

	@Override
	public Materiel insert(Materiel materiel) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);

			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO materiel (libelle,etat,code,electrique,attente,salle,type_materiel) VALUES (?,?,?,?,?,?,?)");

			if (materiel instanceof Cadenas) {
				ps.setString(1, materiel.getlibelle());
				ps.setString(2, materiel.getEtat().toString());
				ps.setString(3, ((Cadenas) materiel).getCode());
				ps.setObject(4, null);
				ps.setObject(5, null);
				if (materiel.getSalle() == null) {
					ps.setObject(6, null);
				} else {
					ps.setInt(6, materiel.getSalle().getId());
				}

				ps.setString(7, "Cadenas");

			} else if (materiel instanceof Coffre) {
				ps.setString(1, materiel.getlibelle());
				ps.setString(2, materiel.getEtat().toString());
				ps.setString(3, ((Coffre) materiel).getCode());
				ps.setObject(4, null);
				ps.setInt(5, ((Coffre) materiel).getAttente());
				if (materiel.getSalle() == null) {
					ps.setObject(6, null);
				} else {
					ps.setInt(6, materiel.getSalle().getId());
				}

				ps.setString(7, "Coffre");
			} else if (materiel instanceof Mecanisme) {
				ps.setString(1, materiel.getlibelle());
				ps.setString(2, materiel.getEtat().toString());
				ps.setString(3, null);
				ps.setBoolean(4, ((Mecanisme) materiel).isElectrique());
				ps.setObject(5, null);
				if (materiel.getSalle() == null) {
					ps.setObject(6, null);
				} else {
					ps.setInt(6, materiel.getSalle().getId());
				}

				ps.setString(7, "Mecanisme");
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
	public void update(Materiel materiel) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);

			PreparedStatement ps = conn.prepareStatement(
					"UPDATE materiel set libelle=?,etat=?,code=?,electrique=?,attente=?,salle=?,type_materiel=? where id=?");

			if (materiel instanceof Cadenas) {
				ps.setString(1, materiel.getlibelle());
				ps.setString(2, materiel.getEtat().toString());
				ps.setString(3, ((Cadenas) materiel).getCode());
				ps.setObject(4, null);
				ps.setObject(5, null);
				if (materiel.getSalle() == null) {
					ps.setObject(6, null);
				} else {
					ps.setInt(6, materiel.getSalle().getId());
				}

				ps.setString(7, "Cadenas");
				ps.setInt(8, materiel.getId());

			} else if (materiel instanceof Coffre) {
				ps.setString(1, materiel.getlibelle());
				ps.setString(2, materiel.getEtat().toString());
				ps.setString(3, ((Coffre) materiel).getCode());
				ps.setObject(4, null);
				ps.setInt(5, ((Coffre) materiel).getAttente());
				if (materiel.getSalle() == null) {
					ps.setObject(6, null);
				} else {
					ps.setInt(6, materiel.getSalle().getId());
				}

				ps.setString(7, "Coffre");
				ps.setInt(8, materiel.getId());

			} else if (materiel instanceof Mecanisme) {
				ps.setString(1, materiel.getlibelle());
				ps.setString(2, materiel.getEtat().toString());
				ps.setString(3, null);
				ps.setBoolean(4, ((Mecanisme) materiel).isElectrique());
				ps.setObject(5, null);
				if (materiel.getSalle() == null) {
					ps.setObject(6, null);
				} else {
					ps.setInt(6, materiel.getSalle().getId());
				}

				ps.setString(7, "Mecanisme");
				ps.setInt(8, materiel.getId());
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
					"DELETE from materiel where id=?");


			ps.setInt(8, id);


			ps.executeUpdate();

			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
