package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ben.bu_club_central.daos.EventsDao;

/**
 * Servlet implementation class EventStatsServlet
 */
@WebServlet("/EventStatsServlet")
public class EventStatsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventStatsServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setActualCount(Integer.parseInt(request.getParameter("eventActualCount")), Integer.parseInt(request.getParameter("eventIdFeedback")));
		response.sendRedirect("BoardMemberDashBoard");
	
	}
	
	/**
	 * increases the count of people going to an event
	 * @param actualCount Integer
	 * @param eventId Integer
	 */
	private void setActualCount(int actualCount, int eventId) {
		EventsDao eDao = new EventsDao();
		eDao.increaseActualCount(actualCount, eventId);
	}
	

}
