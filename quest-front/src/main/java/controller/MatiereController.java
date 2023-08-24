package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import context.Singleton;
import dao.IDAOFiliere;
import dao.IDAOMatiere;
import model.Filiere;
import model.Matiere;
import service.MatiereService;

@WebServlet("/matiere")
public class MatiereController extends HttpServlet {

	private MatiereService matiereService = Singleton.getInstance().getMatiereService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		if(request.getParameter("id")==null) {
			List<Matiere> matieres = matiereService.getAll();
			request.setAttribute("matieres", matieres);
			this.getServletContext().getRequestDispatcher("/WEB-INF/matieres.jsp").forward(request, response);
		}
		else 
		{
			if(request.getParameter("delete")==null) 
			{
				Integer id = Integer.parseInt(request.getParameter("id"));
				Matiere matiere = matiereService.getById(id);
				request.setAttribute("matiere", matiere);
				this.getServletContext().getRequestDispatcher("/WEB-INF/updateMatiere.jsp").forward(request, response);
			}
			else 
			{
				Integer id = Integer.parseInt(request.getParameter("id"));
				matiereService.delete(id);
				response.sendRedirect("matiere");
			}
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("id")==null) 
		{
			String libelle = request.getParameter("libelle");
			Integer quest = Integer.parseInt(request.getParameter("quest"));
			
			Matiere matiere = new Matiere(libelle,quest);
			
			
			matiereService.create(matiere);
			response.sendRedirect("matiere");
		}
		else 
		{
			Integer id = Integer.parseInt(request.getParameter("id"));
			String libelle = request.getParameter("libelle");
			Integer quest = Integer.parseInt(request.getParameter("quest"));
			
			Matiere matiere = new Matiere(id,libelle,quest);
			
			matiereService.update(matiere);
			response.sendRedirect("matiere");
		}
	}

}
