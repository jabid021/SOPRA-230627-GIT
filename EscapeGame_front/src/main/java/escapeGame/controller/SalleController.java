package escapeGame.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import escapeGame.model.Difficulte;
import escapeGame.model.Salle;
import escapeGame.service.SalleService;



@WebServlet("/salle")
public class SalleController extends HttpServlet {
	@Autowired
	private SalleService salleService;
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("id")==null) {
			List<Salle> salles = salleService.getAll();
			request.setAttribute("difficultes",Difficulte.values());
			request.setAttribute("salles", salles);
			this.getServletContext().getRequestDispatcher("/WEB-INF/salles.jsp").forward(request, response);
			
		}
		else {
			if(request.getParameter("delete")==null) 
			{
				Integer id = Integer.parseInt(request.getParameter("id"));

				Salle salle = salleService.getById(id);
				//Envoyer dan sla request la liste des values de l'enum Difficulte
				request.setAttribute("difficultes",Difficulte.values());
				request.setAttribute("salle", salle);
				this.getServletContext().getRequestDispatcher("/WEB-INF/updateSalle.jsp").forward(request, response);
				
			}
			else {
				Integer id = Integer.parseInt(request.getParameter("id"));
				salleService.delete(id);
				response.sendRedirect("salle");
			}
			}
		}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("id")==null) {

			int min = Integer.parseInt(request.getParameter("min"));
			int max = Integer.parseInt(request.getParameter("max"));
			String titre = request.getParameter("titre");
			String description = request.getParameter("description");
			int duree = Integer.parseInt(request.getParameter("duree"));
			double prix=Double.parseDouble(request.getParameter("prix"));
			boolean accessibilite=Boolean.parseBoolean(request.getParameter("accessibilite"));
			

			Difficulte difficulte=Difficulte.valueOf(request.getParameter("difficulte"));

			Salle salle = new Salle(min,max,titre,description,duree,prix,accessibilite,difficulte);
			
			salleService.create(salle);
			response.sendRedirect("salle");
		}
		else {
			Integer id = Integer.parseInt(request.getParameter("id"));
			int min = Integer.parseInt(request.getParameter("min"));
			int max = Integer.parseInt(request.getParameter("max"));
			String titre = request.getParameter("titre");
			String description = request.getParameter("description");
			int duree = Integer.parseInt(request.getParameter("duree"));
			double prix=Double.parseDouble(request.getParameter("prix"));
			boolean accessibilite=Boolean.parseBoolean(request.getParameter("accessibilite"));
			Difficulte difficulte=Difficulte.valueOf(request.getParameter("difficulte"));
			
			Salle salle = new Salle(id,min,max,titre,description,duree,prix,accessibilite,difficulte);
			
			salleService.update(salle);
			response.sendRedirect("salle");
		}
	}
}
