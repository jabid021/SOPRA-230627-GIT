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
import escapeGame.model.GameMaster;
import escapeGame.model.Reservation;
import escapeGame.service.CompteService;
import escapeGame.service.ReservationService;

@WebServlet("/reservation")
public class ReservationController extends HttpServlet {

	private ReservationService reservationService = Singleton.getInstance().getReservationService();
	private CompteService compteService = Singleton.getInstance().getCompteService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("id") == null) {
			List<Reservation> reservations = reservationService.getAll();
			List<GameMaster> gameMasters = compteService.getAllGameMaster();
			request.setAttribute("reservations", reservations);
			request.setAttribute("gameMasters", gameMasters);
			request.setAttribute("today", LocalDate.now());
			this.getServletContext().getRequestDispatcher("/WEB-INF/reservations.jsp").forward(request, response);
		} else {
			Integer id = Integer.parseInt(request.getParameter("id"));
			reservationService.delete(id);
			response.sendRedirect("reservation");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Integer idGameMaster = Integer.parseInt(request.getParameter("idGameMaster"));
		Integer idReservation = Integer.parseInt(request.getParameter("idReservation"));
		if (idGameMaster != null && idReservation != null) {
			GameMaster gm = null;
			if(idGameMaster!=0) 
			{
				gm = (GameMaster) compteService.getById(idGameMaster);
			}
			Reservation reservation = reservationService.getById(idReservation);
			reservation.setGameMaster(gm);
			reservationService.update(reservation);
		}
	}
}
