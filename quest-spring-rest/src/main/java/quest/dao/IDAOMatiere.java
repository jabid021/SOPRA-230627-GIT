package quest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import quest.model.Matiere;

public interface IDAOMatiere extends JpaRepository<Matiere,Integer> {

	
	public List<Matiere> findByLibelleContaining(String chaine);
	
	@Query("SELECT m FROM Matiere m WHERE m.libelle like %:chaine%")
	public List<Matiere> matiereTitreLike(@Param("chaine") String chaine);
	
	/*@Query("SELECT m FROM Matiere m WHERE m.libelle =:chaine")
	public List<Matiere> matiereTitreEgal(String chaine);*/
	
	public Matiere findByLibelleAndQuest(String chaine,int quest);
}
