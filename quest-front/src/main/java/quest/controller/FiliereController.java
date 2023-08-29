package quest.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import quest.context.Singleton;
import quest.model.Filiere;
import quest.service.FiliereService;

@WebServlet("/filiere")
public class FiliereController extends HttpServlet {

	private FiliereService filiereService = Singleton.getInstance().getFiliereService();


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		if(request.getParameter("id")==null) {
			List<Filiere> filieres = filiereService.getAll();
			request.setAttribute("filieres", filieres);
			this.getServletContext().getRequestDispatcher("/WEB-INF/filieres.jsp").forward(request, response);
		}
		else 
		{
			if(request.getParameter("delete")==null) 
			{
				Integer id = Integer.parseInt(request.getParameter("id"));
				Filiere filiere = filiereService.getById(id);
				request.setAttribute("filiere", filiere);
				this.getServletContext().getRequestDispatcher("/WEB-INF/updateFiliere.jsp").forward(request, response);
			}
			else 
			{
				Integer id = Integer.parseInt(request.getParameter("id"));
				filiereService.delete(id);
				response.sendRedirect("filiere");
			}
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("id")==null) 
		{
			String libelle = request.getParameter("libelle");
			String debut = request.getParameter("debut");
			String fin = request.getParameter("fin");
			
			Filiere filiere = new Filiere(libelle, LocalDate.parse(debut), LocalDate.parse(fin));
			
			
			filiereService.create(filiere);
			response.sendRedirect("filiere");
		}
		else 
		{
			Integer id = Integer.parseInt(request.getParameter("id"));
			String libelle = request.getParameter("libelle");
			String debut = request.getParameter("debut");
			String fin = request.getParameter("fin");
			
			Filiere filiere = new Filiere(id,libelle, LocalDate.parse(debut), LocalDate.parse(fin));
			
			filiereService.update(filiere);
			response.sendRedirect("filiere");
		}
	}

}
