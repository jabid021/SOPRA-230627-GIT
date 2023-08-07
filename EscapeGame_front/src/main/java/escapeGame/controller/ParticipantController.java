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
import escapeGame.dao.IDAOParticipant;
import escapeGame.model.GameMaster;
import escapeGame.model.Participant;


@WebServlet("/participant")
public class ParticipantController extends HttpServlet {

	private IDAOParticipant daoParticipant = Singleton.getInstance().getDaoParticipant();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("id") == null) {
			List<Participant> participants = daoParticipant.findAll();
			request.setAttribute("participants", participants);
			this.getServletContext().getRequestDispatcher("/WEB-INF/participants.jsp").forward(request, response);
		} else {
			Integer id = Integer.parseInt(request.getParameter("id"));
			daoParticipant.delete(id);
			response.sendRedirect("participant");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
