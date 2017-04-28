package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ben.bu_club_central.daos.EventNotificationDao;
import edu.ben.bu_club_central.daos.EventsDao;
import edu.ben.bu_club_central.models.User;

/**
 * Servlet implementation class CreateEventServlet
 */
@WebServlet("/CreateEventServlet")
public class CreateEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateEventServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("AccessDeniedServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		createEvent(request.getParameter("event_name"), request.getParameter("description"), request.getParameter("location"), 
				((User) request.getSession().getAttribute("user")).getClub_id_num(), request.getParameter("startyear"), request.getParameter("startmonth"), request.getParameter("startday"),
				request.getParameter("endyear"), request.getParameter("endmonth"), request.getParameter("endday"),request.getParameter("category"));
		
		eventNotifications();
		
		response.sendRedirect("BoardMemberDashBoard");

	}

	/**
	 * this method calls the create event method in the dao
	 * @param event_name String 
	 * @param description String
	 * @param location String
	 * @param club_id_num Integer
	 * @param startyear String
	 * @param startmonth String
	 * @param startday String
	 * @param endyear String
	 * @param endmonth String
	 * @param endday String
	 * @param category String
	 */
	public void createEvent(String event_name, String description, String location, int club_id_num, String startyear, String startmonth, String startday,
			String endyear, String endmonth, String endday,String category) {
		EventsDao eDao = new EventsDao();
		eDao.addEvent(event_name, description, location, club_id_num, startyear, startmonth, startday, endyear, endmonth, endday, category);
	}
	
	/**
	 * this method adds that event to the event notifications table in the database
	 */
	public void eventNotifications() {
		EventNotificationDao eDao = new EventNotificationDao();
		EventsDao eventDao = new EventsDao();
		int eventId = eventDao.getLatestEventId();
		eDao.addEventsAndUsers(eventId);
	}

}
