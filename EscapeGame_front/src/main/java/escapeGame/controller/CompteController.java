package escapeGame.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import escapeGame.context.Singleton;
import escapeGame.dao.IDAOCompte;
import escapeGame.model.Adresse;
import escapeGame.model.Client;
import escapeGame.model.Compte;
import escapeGame.model.GameMaster;
import escapeGame.model.Gerant;


@WebServlet("/compte")
public class CompteController extends HttpServlet {
	
	
	private IDAOCompte daoCompte = Singleton.getInstance().getDaoCompte();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("id")==null) 
		{
			List<Compte> comptes = daoCompte.findAll();
			request.setAttribute("comptes", comptes);
			this.getServletContext().getRequestDispatcher("/WEB-INF/comptes.jsp").forward(request, response);
		}
		else {
			if(request.getParameter("delete")==null) 
			{
				Integer id = Integer.parseInt(request.getParameter("id"));
				Compte compte = daoCompte.findById(id);
				request.setAttribute("compte", compte);
				this.getServletContext().getRequestDispatcher("/WEB-INF/updateCompte.jsp").forward(request, response);
			}
			else 
			{
				Integer id = Integer.parseInt(request.getParameter("id"));
				daoCompte.delete(id);
				response.sendRedirect("compte");
			}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("id")==null) 
		{
			String login = request.getParameter("login");
			String password = request.getParameter("password");
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			
			Compte ajout;
			if(request.getParameter("type").equals("GameMaster")) 
			{
				ajout= new GameMaster(login,password,nom,prenom);
			}
			else if(request.getParameter("type").equals("Gerant")) 
			{
				ajout= new Gerant(login,password,nom,prenom);
			}
			else 
			{
				
				String tel = request.getParameter("tel");
				String mail = request.getParameter("mail");
				String numero = request.getParameter("numero");
				String voie = request.getParameter("voie");
				String ville = request.getParameter("ville");
				String cp = request.getParameter("cp");
				
				Adresse adresse = new Adresse(numero,voie,ville,cp);
				
				ajout= new Client(login,password,nom,prenom,tel,mail,adresse);
			}
			
			daoCompte.insert(ajout);
		}
		else 
		{
			Integer id = Integer.parseInt(request.getParameter("id"));
			String login = request.getParameter("login");
			String password = request.getParameter("password");
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			
			Compte ajout;
			if(request.getParameter("type").equals("Gerant")) 
			{
				ajout= new GameMaster(id,login,password,nom,prenom);
			}
			else if(request.getParameter("type").equals("Gerant")) 
			{
				ajout= new Gerant(id,login,password,nom,prenom);
			}
			else 
			{
				
				String tel = request.getParameter("tel");
				String mail = request.getParameter("mail");
				String numero = request.getParameter("numero");
				String voie = request.getParameter("voie");
				String ville = request.getParameter("ville");
				String cp = request.getParameter("cp");
				
				Adresse adresse = new Adresse(numero,voie,ville,cp);
				
				ajout= new Client(id,login,password,nom,prenom,tel,mail,adresse);
			}
			
			daoCompte.insert(ajout);
		}
		response.sendRedirect("compte");
	}

}
