package quest.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import quest.context.Singleton;
import quest.model.Ordinateur;
import quest.model.Stagiaire;
import quest.service.OrdinateurService;
import quest.service.StagiaireService;

@WebServlet("/ordinateur")
public class OrdinateurController extends HttpServlet {

	private OrdinateurService ordinateurService = Singleton.getInstance().getOrdinateurService();
	private StagiaireService stagiaireService = Singleton.getInstance().getStagiaireService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		if(request.getParameter("id")==null) {
			List<Ordinateur> ordinateurs = ordinateurService.getAll();
			List<Stagiaire> stagiaires = stagiaireService.getAll();
			request.setAttribute("ordinateurs", ordinateurs);
			request.setAttribute("stagiaires", stagiaires);
			this.getServletContext().getRequestDispatcher("/WEB-INF/ordinateurs.jsp").forward(request, response);
		}
		else 
		{
			if(request.getParameter("delete")==null) 
			{
				Integer id = Integer.parseInt(request.getParameter("id"));
				Ordinateur ordinateur = ordinateurService.getById(id);
				List<Stagiaire> stagiaires = stagiaireService.getAll();
				request.setAttribute("ordinateur", ordinateur);
				request.setAttribute("stagiaires", stagiaires);
				this.getServletContext().getRequestDispatcher("/WEB-INF/updateOrdinateur.jsp").forward(request, response);
			}
			else 
			{
				Integer id = Integer.parseInt(request.getParameter("id"));
				ordinateurService.delete(id);
				response.sendRedirect("ordinateur");
			}
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("id")==null) 
		{
			String marque = request.getParameter("marque");
			Integer ram = Integer.parseInt(request.getParameter("ram"));
			Integer idStagiaire = Integer.parseInt(request.getParameter("stagiaire"));
			Stagiaire stagiaire = stagiaireService.getById(idStagiaire);
			
			Ordinateur ordinateur = new Ordinateur(marque, ram, stagiaire);
			
			
			ordinateurService.create(ordinateur);
			response.sendRedirect("ordinateur");
		}
		else 
		{
			Integer id = Integer.parseInt(request.getParameter("id"));
			String marque = request.getParameter("marque");
			Integer ram = Integer.parseInt(request.getParameter("ram"));
			Integer idStagiaire = Integer.parseInt(request.getParameter("stagiaire"));
			Stagiaire stagiaire = stagiaireService.getById(idStagiaire);
			
			Ordinateur ordinateur = new Ordinateur(id,marque,ram, stagiaire);
			
			ordinateurService.update(ordinateur);
			response.sendRedirect("ordinateur");
		}
	}

}
