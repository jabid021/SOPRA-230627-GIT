package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import context.Singleton;
import dao.IDAOFiliere;
import model.Filiere;


	@WebServlet("/filiere")
	public class FiliereController extends HttpServlet {
		
			private IDAOFiliere daoFiliere = Singleton.getInstance().getDaoFiliere();
		

			protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


				if(request.getParameter("id")==null) {
					List<Filiere> Filieres = daoFiliere.findAll();
					request.setAttribute("filieres", Filieres);
					this.getServletContext().getRequestDispatcher("/WEB-INF/filieres.jsp").forward(request, response);
				}
				else 
				{
					if(request.getParameter("delete")==null) 
					{
						Integer id = Integer.parseInt(request.getParameter("id"));
						Filiere Filiere = daoFiliere.findById(id);
						request.setAttribute("filiere", Filiere);
						this.getServletContext().getRequestDispatcher("/WEB-INF/updateFiliere.jsp").forward(request, response);
					}
					else 
					{
						Integer id = Integer.parseInt(request.getParameter("id"));
						daoFiliere.delete(id);
						response.sendRedirect("filiere");
					}
				}

			}


			protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				if(request.getParameter("id")==null) 
				{
					
					String libelle = request.getParameter("libelle");
					LocalDate debut = LocalDate.parse(request.getParameter("debut"));
					LocalDate fin = LocalDate.parse(request.getParameter("fin"));
					
					Filiere filiere = new Filiere(libelle, debut, fin);
					
					daoFiliere.insert(filiere);
					response.sendRedirect("filiere");
				}
				else 
				{
					Integer id = Integer.parseInt(request.getParameter("id"));
					String libelle = request.getParameter("libelle");
					LocalDate debut = LocalDate.parse(request.getParameter("debut"));
					LocalDate fin = LocalDate.parse(request.getParameter("fin"));
					
					Filiere filiere = new Filiere(id, libelle, debut, fin);
					
					
					
					daoFiliere.update(filiere);
					response.sendRedirect("filiere");
				}
			}

		}





