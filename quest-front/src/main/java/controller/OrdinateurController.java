package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import context.Singleton;
import dao.IDAOStagiaire;
import dao.IDAOOrdinateur;
import model.Stagiaire;
import model.Ordinateur;

@WebServlet("/ordinateur")
public class OrdinateurController extends HttpServlet {

	private IDAOOrdinateur daoOrdinateur = Singleton.getInstance().getDaoOrdinateur();
	private IDAOStagiaire daoStagiaire = Singleton.getInstance().getDaoStagiaire();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		if(request.getParameter("id")==null) {
			List<Ordinateur> ordinateurs = daoOrdinateur.findAll();
			List<Stagiaire> stagiaires = daoStagiaire.findAll();
			request.setAttribute("ordinateurs", ordinateurs);
			request.setAttribute("stagiaires", stagiaires);
			this.getServletContext().getRequestDispatcher("/WEB-INF/ordinateurs.jsp").forward(request, response);
		}
		else 
		{
			if(request.getParameter("delete")==null) 
			{
				Integer id = Integer.parseInt(request.getParameter("id"));
				Ordinateur ordinateur = daoOrdinateur.findById(id);
				List<Stagiaire> stagiaires = daoStagiaire.findAll();
				request.setAttribute("ordinateur", ordinateur);
				request.setAttribute("stagiaires", stagiaires);
				this.getServletContext().getRequestDispatcher("/WEB-INF/updateOrdinateur.jsp").forward(request, response);
			}
			else 
			{
				Integer id = Integer.parseInt(request.getParameter("id"));
				daoOrdinateur.delete(id);
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
			Stagiaire stagiaire = daoStagiaire.findById(idStagiaire);
			
			Ordinateur ordinateur = new Ordinateur(marque, ram, stagiaire);
			
			
			daoOrdinateur.insert(ordinateur);
			response.sendRedirect("ordinateur");
		}
		else 
		{
			Integer id = Integer.parseInt(request.getParameter("id"));
			String marque = request.getParameter("marque");
			Integer ram = Integer.parseInt(request.getParameter("ram"));
			Integer idStagiaire = Integer.parseInt(request.getParameter("stagiaire"));
			Stagiaire stagiaire = daoStagiaire.findById(idStagiaire);
			
			Ordinateur ordinateur = new Ordinateur(id,marque,ram, stagiaire);
			
			daoOrdinateur.update(ordinateur);
			response.sendRedirect("ordinateur");
		}
	}

}
