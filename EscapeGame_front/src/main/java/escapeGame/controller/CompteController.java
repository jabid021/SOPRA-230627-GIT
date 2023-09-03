package escapeGame.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import escapeGame.model.Adresse;
import escapeGame.model.Client;
import escapeGame.model.Compte;
import escapeGame.model.GameMaster;
import escapeGame.model.Gerant;
import escapeGame.service.CompteService;


@WebServlet("/compte")
public class CompteController extends HttpServlet {

	@Autowired
	private CompteService compteService;	
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("id")==null) 
		{
			List<Compte> comptes = compteService.getAll();
			request.setAttribute("comptes", comptes);
			this.getServletContext().getRequestDispatcher("/WEB-INF/comptes.jsp").forward(request, response);
		}
		else {
			if(request.getParameter("delete")==null) 
			{
				Integer id = Integer.parseInt(request.getParameter("id"));
				Compte compte = compteService.getById(id);
				List<String> typesCompte = new ArrayList();
				Collections.addAll(typesCompte, "Gerant","GameMaster","Client");
			
				request.setAttribute("compte", compte);
				request.setAttribute("types", typesCompte);
				request.setAttribute("typeAccount", compte.getClass().getSimpleName());
				this.getServletContext().getRequestDispatcher("/WEB-INF/updateCompte.jsp").forward(request, response);
			}
			else 
			{
				Integer id = Integer.parseInt(request.getParameter("id"));
				compteService.delete(id);
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

			compteService.create(ajout);
		}
		else 
		{
			Integer id = Integer.parseInt(request.getParameter("id"));
			String login = request.getParameter("login");
			String password = request.getParameter("password");
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");

			Compte compte;
			if(request.getParameter("type").equals("GameMaster")) 
			{
				compte= new GameMaster(id,login,password,nom,prenom);
			}
			else if(request.getParameter("type").equals("Gerant")) 
			{
				compte= new Gerant(id,login,password,nom,prenom);
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

				compte= new Client(id,login,password,nom,prenom,tel,mail,adresse);
			}

			compteService.update(compte);
		}
		response.sendRedirect("compte");
	}

}
