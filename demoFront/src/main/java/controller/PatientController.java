package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hopital.context.Singleton;
import hopital.model.Patient;

@WebServlet("/fichePatient")
public class PatientController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Integer id = Integer.parseInt(request.getParameter("id"));	

		Patient  p = Singleton.getInstance().getDaoPatient().findById(id);
		
		//Envoyer p au travers de request
		request.setAttribute("patient", p);
	
		//afficher la page updatePatient.jsp
		this.getServletContext().getRequestDispatcher("/updatePatient.jsp").forward(request, response);
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	}

}
