package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ben.bu_club_central.daos.EventsDao;

/**
 * Servlet implementation class RSVPServlet
 */
@WebServlet("/RSVPServlet")
public class RSVPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RSVPServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		addRSVP(Integer.parseInt(request.getParameter("eventId")));
		response.sendRedirect("EventServlet");
	}

	private void addRSVP(int eventId) {
		EventsDao eDao = new EventsDao();
		eDao.increaseRSVPCount(eventId);
	}
	
	
	
	
	
	
}
