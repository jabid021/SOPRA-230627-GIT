package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hopital.context.Singleton;
import hopital.model.Patient;

@WebServlet("/patient")
public class PatientController extends HttpServlet {
	
	//Pour gerer le crud :
	
	//findAll() => get
	//findByid() => get
	//delete => get
	
	//update => post
	//insert => post
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		//Verifier s'il y a un id dans l'url (en param)
		//Si oui => findById ou delete 
		//Si non => findAll
		
		if(request.getParameter("id")==null) 
		{
			//findAll
			List<Patient> patients = Singleton.getInstance().getDaoPatient().findAll();
			request.setAttribute("patients", patients);
			this.getServletContext().getRequestDispatcher("/WEB-INF/patients.jsp").forward(request, response);
		}
		else 
		{
			if(request.getParameter("delete")==null) 
			{
				//findById
				Integer id = Integer.parseInt(request.getParameter("id"));	
				Patient  p = Singleton.getInstance().getDaoPatient().findById(id);
				request.setAttribute("patient", p);
				System.out.println(p);
				this.getServletContext().getRequestDispatcher("/WEB-INF/updatePatient.jsp").forward(request, response);
			}
			else 
			{
				//delete
				Integer id = Integer.parseInt(request.getParameter("id"));	
				Singleton.getInstance().getDaoPatient().delete(id);
			
				response.sendRedirect("patient");
			}
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//recup le param tache
		String tache = request.getParameter("tache");
		
		//Si tache=="insert" =>
		if(tache.equals("insert")) 
		{
			Integer id = Integer.parseInt(request.getParameter("id"));	
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			Patient p = new Patient(id,prenom,nom);
			Singleton.getInstance().getDaoPatient().insert(p);
		}
		
		//Si tache == "update" => 
		else if(tache.equals("update")) 
		{
			Integer id = Integer.parseInt(request.getParameter("id"));	
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			Patient p = new Patient(id,prenom,nom);
			Singleton.getInstance().getDaoPatient().update(p);
		}
		
		
		response.sendRedirect("patient");
	
	}

}
