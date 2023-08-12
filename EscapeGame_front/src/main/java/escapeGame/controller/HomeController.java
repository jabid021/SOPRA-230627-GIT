package escapeGame.controller;

import java.io.IOException;

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
import escapeGame.service.CompteService;


@WebServlet("/home")
public class HomeController extends HttpServlet {
	
	private CompteService compteService = Singleton.getInstance().getCompteService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		if(request.getParameter("disconnect")!=null) 
		{
			
		request.getSession().invalidate();
		}
		
		Compte connected = (Compte) request.getSession().getAttribute("compte");
		
		if(connected==null) 
		{
			this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		}
		
		else 
		{
			if(connected instanceof Gerant) 
			{
				this.getServletContext().getRequestDispatcher("/WEB-INF/gerant.jsp").forward(request, response);
			}
			else if(connected instanceof GameMaster) 
			{
				this.getServletContext().getRequestDispatcher("/WEB-INF/gameMaster.jsp").forward(request, response);
			}
			else if(connected instanceof Client) 
			{
				this.getServletContext().getRequestDispatcher("/WEB-INF/client.jsp").forward(request, response);
			}
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		if(request.getParameter("inscription")==null) 
		{
			String login = request.getParameter("login");
			String password = request.getParameter("password");
			Compte connected = compteService.getByLoginAndPassword(login, password);
			
			if(connected!=null) 
			{
				request.getSession().setAttribute("compte", connected);
				request.getSession().removeAttribute("error");
			}
			else 
			{
				request.getSession().setAttribute("error", "Identifiants invalides");
			}
			
		}
		else 
		{
			String login = request.getParameter("login");
			String password = request.getParameter("password");
			String prenom = request.getParameter("prenom");
			String nom = request.getParameter("nom");
			String mail = request.getParameter("mail");
			String tel = request.getParameter("tel");
			String numero = request.getParameter("numero");
			String voie = request.getParameter("voie");
			String ville = request.getParameter("ville");
			String cp = request.getParameter("cp");
			
			Adresse adresse = new Adresse(numero,voie,ville,cp);
			Client client = new Client(login,password,nom,prenom,tel,mail,adresse);
			compteService.create(client);
		}
		
		response.sendRedirect("home");
	
	}

}
