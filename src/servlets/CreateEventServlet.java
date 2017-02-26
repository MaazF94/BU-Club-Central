package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		createEvent(request.getParameter("event_name"), request.getParameter("description"),
				request.getParameter("location"), ((User) request.getSession().getAttribute("user")).getClub_id_num());
		response.sendRedirect("BoardMemberDashBoard");

	}

	public void createEvent(String event_name, String description, String location, int club_id_num) {
		EventsDao eDao = new EventsDao();
		eDao.addEvent(event_name, description, location, club_id_num);
	}

}