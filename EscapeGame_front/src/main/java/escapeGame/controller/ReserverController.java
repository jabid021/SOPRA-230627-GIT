package escapeGame.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import escapeGame.model.Client;
import escapeGame.model.Participant;
import escapeGame.model.Reservation;
import escapeGame.model.Salle;
import escapeGame.service.ParticipantService;
import escapeGame.service.ReservationService;
import escapeGame.service.SalleService;


@WebServlet("/reserver")
public class ReserverController extends HttpServlet {
	@Autowired
	private SalleService salleService;
	@Autowired
	private ParticipantService participantService;
	@Autowired
	private ReservationService reservationService;
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Client client = (Client) request.getSession().getAttribute("compte");
		List<Salle> salles = salleService.getAll();
		List<Participant> participants = participantService.getAllByClient(client);
		request.setAttribute("salles", salles);
		request.setAttribute("participants", participants);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/reserver.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Client client = (Client) request.getSession().getAttribute("compte");
		Integer idSalle = Integer.parseInt(request.getParameter("salle"));
		Salle salle = salleService.getById(idSalle);
		String nomEquipe = request.getParameter("equipe");
		Integer nbParticipants = Integer.parseInt(request.getParameter("nbParticipants"));
		double prix = salle.getPrix()*nbParticipants;
		
		List<Participant> participants = new ArrayList();
		
		for(int i=1;i<=nbParticipants;i++) 
		{
			String nom = request.getParameter("nom-"+i);
			String prenom = request.getParameter("prenom-"+i);
			Integer idParticipant = Integer.parseInt(request.getParameter("id-"+i));
			System.out.println(new Participant(idParticipant,nom,prenom,client));
			participants.add(new Participant(idParticipant,nom,prenom,client));
		}
		
		
		Reservation reservation = new Reservation(LocalDate.now(),LocalTime.now(),null,nomEquipe,prix,client,salle,null);
		reservation.setParticipants(participants);
		reservationService.create(reservation);
		response.sendRedirect("home");
	}

}
