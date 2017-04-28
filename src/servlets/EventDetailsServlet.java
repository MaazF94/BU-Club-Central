package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ben.bu_club_central.daos.EventNotificationDao;
import edu.ben.bu_club_central.models.User;

/**
 * Servlet implementation class EventDetailsServlet
 */
@WebServlet("/EventDetailsServlet")
public class EventDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventDetailsServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("user") != null) {
		EventNotificationDao eNotDao = new EventNotificationDao();
		eNotDao.checkedNotification(Integer.parseInt(request.getParameter("eventId")), ((User) request.getSession().getAttribute("user")).getId_num());
		}
		request.getRequestDispatcher("/WEB-INF/jsp/EventDetails.jsp").forward(request, response);		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
