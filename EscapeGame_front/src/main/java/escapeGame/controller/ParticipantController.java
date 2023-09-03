package escapeGame.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import escapeGame.model.Participant;
import escapeGame.service.ParticipantService;


@WebServlet("/participant")
public class ParticipantController extends HttpServlet {
	@Autowired
	private ParticipantService participantService;
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("id") == null) {
			List<Participant> participants = participantService.getAll();
			request.setAttribute("participants", participants);
			this.getServletContext().getRequestDispatcher("/WEB-INF/participants.jsp").forward(request, response);
		} else {
			Integer id = Integer.parseInt(request.getParameter("id"));
			participantService.delete(id);
			response.sendRedirect("participant");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
