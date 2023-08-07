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
import dao.IDAOStagiaire;
import model.Filiere;
import model.Stagiaire;

@WebServlet("/stagiaire")
public class StagiaireController extends HttpServlet {

	private IDAOStagiaire daoStagiaire = Singleton.getInstance().getDaoStagiaire();
	private IDAOFiliere daoFiliere = Singleton.getInstance().getDaoFiliere();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		if(request.getParameter("id")==null) {
			List<Stagiaire> stagiaires = daoStagiaire.findAll();
			List<Filiere> filieres = daoFiliere.findAll();
			request.setAttribute("stagiaires", stagiaires);
			request.setAttribute("filieres", filieres);
			this.getServletContext().getRequestDispatcher("/WEB-INF/stagiaires.jsp").forward(request, response);
		}
		else 
		{
			if(request.getParameter("delete")==null) 
			{
				Integer id = Integer.parseInt(request.getParameter("id"));
				Stagiaire stagiaire = daoStagiaire.findById(id);
				List<Filiere> filieres = daoFiliere.findAll();
				request.setAttribute("stagiaire", stagiaire);
				request.setAttribute("filieres", filieres);
				this.getServletContext().getRequestDispatcher("/WEB-INF/updateStagiaire.jsp").forward(request, response);
			}
			else 
			{
				Integer id = Integer.parseInt(request.getParameter("id"));
				daoStagiaire.delete(id);
				response.sendRedirect("stagiaire");
			}
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("id")==null) 
		{
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String email = request.getParameter("email");
			Integer idFiliere = Integer.parseInt(request.getParameter("filiere"));
			Filiere filiere = daoFiliere.findById(idFiliere);
			
			Stagiaire stagiaire = new Stagiaire(nom, prenom, email, filiere);
			
			
			daoStagiaire.insert(stagiaire);
			response.sendRedirect("stagiaire");
		}
		else 
		{
			Integer id = Integer.parseInt(request.getParameter("id"));
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String email = request.getParameter("email");
			Integer idFiliere = Integer.parseInt(request.getParameter("filiere"));
			Filiere filiere = daoFiliere.findById(idFiliere);
			
			Stagiaire stagiaire = new Stagiaire(id,nom, prenom, email, filiere);
			
			daoStagiaire.update(stagiaire);
			response.sendRedirect("stagiaire");
		}
	}

}
