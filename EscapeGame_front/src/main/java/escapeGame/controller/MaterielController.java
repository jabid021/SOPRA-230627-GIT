package escapeGame.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import escapeGame.context.Singleton;
import escapeGame.model.Cadenas;
import escapeGame.model.Coffre;
import escapeGame.model.Etat;
import escapeGame.model.Materiel;
import escapeGame.model.Mecanisme;
import escapeGame.model.Salle;
import escapeGame.service.MaterielService;
import escapeGame.service.SalleService;




@WebServlet("/materiel")
public class MaterielController extends HttpServlet {
	private MaterielService materielService= Singleton.getInstance().getMaterielService();
	private SalleService salleService= Singleton.getInstance().getSalleService();

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("id")==null) {
			List<Materiel> materiels = materielService.getAll();
			List<Salle> salles = salleService.getAll();
			request.setAttribute("materiels", materiels);
			request.setAttribute("salles", salles);
			this.getServletContext().getRequestDispatcher("/WEB-INF/materiels.jsp").forward(request, response);
		}
		else {
			if(request.getParameter("delete")==null) 
			{
				Integer id = Integer.parseInt(request.getParameter("id"));
				Materiel materiel = materielService.getById(id);
				List<Salle> salles = salleService.getAll();
				request.setAttribute("materiel", materiel);
				request.setAttribute("salles", salles);
				this.getServletContext().getRequestDispatcher("/WEB-INF/updateMateriel.jsp").forward(request, response);
			}
			else 
			{
				Integer id = Integer.parseInt(request.getParameter("id"));
				materielService.delete(id);
				response.sendRedirect("materiel");
			}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("id")==null) {
			String libelle = request.getParameter("libelle");
			Integer idSalle = Integer.parseInt(request.getParameter("salle"));
			Salle salle = salleService.getById(idSalle);
			Etat etat = Etat.valueOf(request.getParameter("etat"));
			if (request.getParameter("type_materiel").equals("Cadenas"))
			{
				String code= request.getParameter("code");
				
				Cadenas materiel = new Cadenas(libelle, salle, etat, code);
				materielService.create(materiel);
			}
			else if (request.getParameter("type_materiel").equals("Mecanisme"))
			{
				Boolean electrique = Boolean.valueOf(request.getParameter("electrique"));
				Mecanisme materiel = new Mecanisme (libelle, salle, etat, electrique);
				materielService.create(materiel);
			}
			else if(request.getParameter("type_materiel").equals("Coffre"))
			{
				String code= request.getParameter("code");
				int attente = Integer.parseInt(request.getParameter("attente"));
				Coffre materiel = new Coffre (libelle, salle, etat, code, attente);
				materielService.create(materiel);
			}
			
			response.sendRedirect("materiel");
		}
		else {
			Integer id = Integer.parseInt(request.getParameter("id"));
			String libelle = request.getParameter("libelle");
			Integer idSalle = Integer.parseInt(request.getParameter("salle"));
			Salle salle = salleService.getById(idSalle);
			Etat etat = Etat.valueOf(request.getParameter("etat"));
			if (("type_materiel").equals("Cadenas"))
			{
				String code= request.getParameter("code");
				
				Cadenas materiel = new Cadenas(id, libelle, salle, etat, code);
				materielService.update(materiel);
			}
			else if (("type_materiel").equals("Mecanisme"))
			{
				Boolean electrique = Boolean.valueOf(request.getParameter("electrique"));
				Mecanisme materiel = new Mecanisme (id, libelle, salle, etat, electrique);
				materielService.update(materiel);
			}
			else if(("type_materiel").equals("Coffre"))
			{
				String code= request.getParameter("code");
				int attente = Integer.parseInt(request.getParameter("attente"));
				Coffre materiel = new Coffre (id, libelle, salle, etat, code, attente);
				materielService.update(materiel);
			}
			
			response.sendRedirect("materiel");
		}
		}
	}



