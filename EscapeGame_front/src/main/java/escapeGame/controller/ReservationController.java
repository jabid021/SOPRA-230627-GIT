package escapeGame.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import escapeGame.context.Singleton;
import escapeGame.dao.IDAOCompte;
import escapeGame.dao.IDAOReservation;
import escapeGame.model.GameMaster;
import escapeGame.model.Reservation;

@WebServlet("/reservation")
public class ReservationController extends HttpServlet {

	private IDAOReservation daoReservation = Singleton.getInstance().getDaoReservation();
	private IDAOCompte daoCompte = Singleton.getInstance().getDaoCompte();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("id") == null) {
			List<Reservation> reservations = daoReservation.findAll();
			List<GameMaster> gameMasters = daoCompte.findAllGameMaster();
			request.setAttribute("reservations", reservations);
			request.setAttribute("gameMasters", gameMasters);
			request.setAttribute("today", LocalDate.now());
			this.getServletContext().getRequestDispatcher("/WEB-INF/reservations.jsp").forward(request, response);
		} else {
			Integer id = Integer.parseInt(request.getParameter("id"));
			daoReservation.delete(id);
			response.sendRedirect("reservation");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
