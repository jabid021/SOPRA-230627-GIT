package servletV1;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hopital.context.Singleton;
import hopital.model.Patient;

@WebServlet("/fichePatientV1Naze")
public class DemoServlet1 extends HttpServlet {



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//System.out.println(Arrays.toString(request.getParameterValues("param")));
		//System.out.println(demo);
		Integer id = Integer.parseInt(request.getParameter("id"));	

		Patient  p = Singleton.getInstance().getDaoPatient().findById(id);


		response.getWriter().println("<html>");
		response.getWriter().println("<body>");
		response.getWriter().println("<h1>Fiche du patient "+id+"</h1>");
		response.getWriter().println("<table border><tr><th>Nom</th><th>Prenom</th></tr>");
		if(p==null) 
		{
			response.getWriter().println("<tr><td colspan='2'>CE PATIENT N'EXISTE PAS</td>");
		}
		else 
		{
			response.getWriter().println("<tr><td>"+p.getNom()+"</td><td>"+p.getPrenom()+"</td></tr>");
		}
		response.getWriter().println("</table>");

		if(p!=null) 
		{
			response.getWriter().println("<form action='fichePatient' method='post'>");
			response.getWriter().println("<input type='hidden' name='id' value='"+p.getId()+"'>");
			response.getWriter().println("<input type='text' name='prenom' placeholder='Saisir prenom' value='"+p.getPrenom()+"'>");
			response.getWriter().println("<input type='text' name='nom' placeholder='Saisir nom' value='"+p.getNom()+"'>");
			response.getWriter().println("<input type='submit' value='Modifier Patient'>");
			response.getWriter().println("</form>");
		}
			response.getWriter().println("<html>");
			response.getWriter().println("</body>");
			response.getWriter().println("</html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer id = Integer.parseInt(request.getParameter("id"));	
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		Patient p = new Patient(id,prenom,nom);
		Singleton.getInstance().getDaoPatient().update(p);
		
		response.sendRedirect("fichePatient?id="+id);
	}


}
