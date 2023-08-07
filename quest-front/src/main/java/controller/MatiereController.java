package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import context.Singleton;
import dao.IDAOMatiere;
import model.Matiere;

@WebServlet("/matiere")
public class MatiereController extends HttpServlet {
	
		private IDAOMatiere daoMatiere = Singleton.getInstance().getDaoMatiere();
	

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


			if(request.getParameter("id")==null) {
				List<Matiere> Matieres = daoMatiere.findAll();
				request.setAttribute("matieres", Matieres);
				this.getServletContext().getRequestDispatcher("/WEB-INF/matieres.jsp").forward(request, response);
			}
			else 
			{
				if(request.getParameter("delete")==null) 
				{
					Integer id = Integer.parseInt(request.getParameter("id"));
					Matiere Matiere = daoMatiere.findById(id);
					request.setAttribute("matiere", Matiere);
					this.getServletContext().getRequestDispatcher("/WEB-INF/updateMatiere.jsp").forward(request, response);
				}
				else 
				{
					Integer id = Integer.parseInt(request.getParameter("id"));
					daoMatiere.delete(id);
					response.sendRedirect("matiere");
				}
			}

		}


		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			if(request.getParameter("id")==null) 
			{
				
				String libelle = request.getParameter("libelle");
				int quest = Integer.parseInt(request.getParameter("quest"));
				
				
				Matiere matiere = new Matiere(libelle, quest);
				
				daoMatiere.insert(matiere);
				response.sendRedirect("matiere");
			}
			else 
			{
				Integer id = Integer.parseInt(request.getParameter("id"));
				String libelle = request.getParameter("libelle");
				int quest = Integer.parseInt(request.getParameter("quest"));
				
				
				Matiere matiere = new Matiere(id, libelle, quest);
				
				
				
				daoMatiere.update(matiere);
				response.sendRedirect("matiere");
			}
		}

	}


