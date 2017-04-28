package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ben.bu_club_central.daos.EventsDao;
import edu.ben.bu_club_central.models.Events;

/**
 * Servlet implementation class EditEventServlet
 */
@WebServlet("/user/EditEventServlet")
public class EditEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditEventServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Events event;
		EventsDao eDao = new EventsDao();
		event = eDao.getEventByEventId(Integer.parseInt(request.getParameter("editEventId")));
		request.setAttribute("event", event);
		
		
		request.getRequestDispatcher("/WEB-INF/jsp/EditEvent.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		editEvent(Integer.parseInt(request.getParameter("eventID")), request.getParameter("eventName"), request.getParameter("description"), request.getParameter("location"), Integer.parseInt(request.getParameter("rsvp_count")));
		response.sendRedirect("BoardMemberDashBoard");
		
	}

	/**
	 * calls the edit event emthod in the dao
	 * @param idevent Integer
	 * @param event_name String
	 * @param description String
	 * @param location String
	 * @param rsvp_count Integer
	 */
	private void editEvent(int idevent, String event_name, String description, String location, int rsvp_count) {
		EventsDao eDao = new EventsDao();
		eDao.editEvent(idevent, event_name, description, location, rsvp_count);
		
		
	}
	
	
}
