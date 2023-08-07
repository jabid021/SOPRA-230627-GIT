package escapeGame.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import escapeGame.context.Singleton;
import escapeGame.dao.IDAOCompte;
import escapeGame.model.Client;
import escapeGame.model.Compte;
import escapeGame.model.GameMaster;
import escapeGame.model.Gerant;


@WebServlet("/home")
public class HomeController extends HttpServlet {
	
	private IDAOCompte daoCompte = Singleton.getInstance().getDaoCompte(); 
	
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
			Compte connected = daoCompte.findByLoginAndPassword(login, password);
			
			if(connected!=null) 
			{
				request.getSession().setAttribute("compte", connected);
			}
			else 
			{
				request.getSession().setAttribute("error", "Identifiants invalides");
			}
			response.sendRedirect("home");
		}
		else 
		{
			
		}
		
	
	
	}

}
