package service;

import java.util.List;

import dao.IDAOMatiere;
import model.Matiere;
import model.Matiere;

	public class MatiereService {

		private IDAOMatiere daoMatiere;


		public MatiereService(IDAOMatiere daoMatiere) {
			this.daoMatiere = daoMatiere;
		}

		public void checkMatiere(Matiere matiere) 
		{
			if (matiere==null) 
			{
				throw new RuntimeException("le matiere ne peut pas etre null lors d'un insert / update ");
			}
			
			if (matiere.getLibelle() == null || matiere.getLibelle().isEmpty()) {
				throw new RuntimeException("libelle obligatoire");
			}
			if (matiere.getQuest() == 0) {
				throw new RuntimeException("code quest obligatoire");
			}
		}
		

		public Matiere create(Matiere matiere) {
			checkMatiere(matiere);
			return daoMatiere.insert(matiere);
		}

		public Matiere update(Matiere matiere) {
			checkMatiere(matiere);
			return daoMatiere.update(matiere);
		}


		public Matiere getById(Integer id) {
			if (id == null) {
				throw new RuntimeException("id obligatoire");
			}
			Matiere matiere = daoMatiere.findById(id);
			if(matiere==null) 
			{
				throw new RuntimeException("id inconnu");
			}
			return matiere;
		}


		public List<Matiere> getAll() {
			return daoMatiere.findAll();
		}


		public void delete(Integer id) {
			if (id == null) {
				throw new RuntimeException("id obligatoire");
			}
			daoMatiere.delete(id);
		}	
	}



