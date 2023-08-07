package escapeGame.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import escapeGame.model.Caracteristique;
import escapeGame.model.Difficulte;
import escapeGame.model.Salle;

public class DAOSalle implements IDAOSalle{

	@Override
	public Salle findById(Integer id) {
		Salle salle = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);

			PreparedStatement ps = conn.prepareStatement("SELECT * from salle where id = ?");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();


			while (rs.next()) {
				List<Caracteristique> caracteristiques = new ArrayList();

				PreparedStatement ps2 = conn.prepareStatement("SELECT * from caracteristique where salle=?");
				ps2.setInt(1, id);

				ResultSet rs2 =ps2.executeQuery();
				while(rs2.next()) 
				{
					caracteristiques.add(Caracteristique.valueOf(rs2.getString("label")));
				}

				salle = new Salle(rs.getInt("id"), rs.getInt("min"), rs.getInt("max"), rs.getString("titre"),
						rs.getString("description"), rs.getInt("duree"), rs.getDouble("prix"),
						rs.getBoolean("accessibilite"), Difficulte.valueOf(rs.getString("difficulte")));
				salle.setCaracteristiques(caracteristiques);
			}
			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return salle;
	}

	@Override
	public List<Salle> findAll() {
		List<Salle> salles = new ArrayList();
		Salle salle = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);




			PreparedStatement ps = conn.prepareStatement("SELECT * from salle ");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				List<Caracteristique> caracteristiques = new ArrayList();

				PreparedStatement ps2 = conn.prepareStatement("SELECT * from caracteristique where salle=?");
				ps2.setInt(1, rs.getInt("id"));

				ResultSet rs2 =ps2.executeQuery();
				while(rs2.next()) 
				{
					caracteristiques.add(Caracteristique.valueOf(rs2.getString("label")));
				}

				salle = new Salle(rs.getInt("id"), rs.getInt("min"), rs.getInt("max"), rs.getString("titre"),
						rs.getString("description"), rs.getInt("duree"), rs.getDouble("prix"),
						rs.getBoolean("accessibilite"), Difficulte.valueOf(rs.getString("difficulte")));
				salle.setCaracteristiques(caracteristiques);
				salles.add(salle);
				rs2.close();
				ps2.close();
			}
			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return salles;
	}

	@Override
	public Salle insert(Salle salle) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);

			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO salle (min,max,titre,description,duree,prix,accessibilite,difficulte) VALUES (?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, salle.getMin());
			ps.setInt(2, salle.getMax());
			ps.setString(3, salle.getTitre());
			ps.setString(4, salle.getDescription());
			ps.setInt(5, salle.getDuree());
			ps.setDouble(6, salle.getPrix());
			ps.setBoolean(7, salle.isAccessibilite());
			ps.setString(8, salle.getDifficulte().toString());

			ps.executeUpdate();

			ResultSet rs= ps.getGeneratedKeys();

			if(rs.next()) 
			{
				salle.setId(rs.getInt(1));
			}

	
			ps.close();
			for(Caracteristique caracteristique : salle.getCaracteristiques()) 
			{
				ps=conn.prepareStatement("INSERT INTO caracteristique (salle,label) VALUES (?,?)");
				ps.setInt(1,salle.getId());
				ps.setString(2, caracteristique.toString());
				ps.executeUpdate();
				ps.close();
			}
			
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void update(Salle salle) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);

			PreparedStatement ps = conn.prepareStatement(
					"UPDATE salle set min=?,max=?,titre=?,description=?,duree=?,prix=?,accessibilite=?,difficulte=? where id=?");
			ps.setInt(1, salle.getMin());
			ps.setInt(2, salle.getMax());
			ps.setString(3, salle.getTitre());
			ps.setString(4, salle.getDescription());
			ps.setInt(5, salle.getDuree());
			ps.setDouble(6, salle.getPrix());
			ps.setBoolean(7, salle.isAccessibilite());
			ps.setString(8, salle.getDifficulte().toString());
			ps.setInt(9, salle.getId());
			ps.executeUpdate();

			
			
			
			ps.close();
			ps=conn.prepareStatement("DELETE FROM caracteristique where salle=?");
			ps.setInt(1, salle.getId());
			ps.executeUpdate();
			ps.close();
			
			for(Caracteristique caracteristique : salle.getCaracteristiques()) 
			{
				ps=conn.prepareStatement("INSERT INTO caracteristique (salle,label) VALUES (?,?)");
				ps.setInt(1,salle.getId());
				ps.setString(2, caracteristique.toString());
				ps.close();
			}
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
					"DELETE from salle where id=?");

			ps.setInt(1, id);
			ps.executeUpdate();

			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
