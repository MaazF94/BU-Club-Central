package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ben.bu_club_central.daos.EventRSVPListDao;
import edu.ben.bu_club_central.daos.EventsDao;
import edu.ben.bu_club_central.models.User;

/**
 * Servlet implementation class UNRSVPServlet
 */
@WebServlet("/UNRSVPServlet")
public class UNRSVPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UNRSVPServlet() {
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
		unrsvp(Integer.parseInt(request.getParameter("eventId")), ((User) request.getSession().getAttribute("user")).getId_num());
		response.sendRedirect("EventServlet");
	}

	
	
	/**
	 * 
	 * @param eventId Integer
	 * @param userId Integer
	 */
	private void unrsvp(int eventId, int userId) {
		EventRSVPListDao eDao = new EventRSVPListDao();
		eDao.unRSVPForEvent(eventId, userId);
		
		EventsDao eventDao = new EventsDao();
		eventDao.decreaseAttendanceCount(eventId);
	}
	
	
	
}
