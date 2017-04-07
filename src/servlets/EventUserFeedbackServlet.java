package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ben.bu_club_central.daos.EventUserFeedbackDao;
import edu.ben.bu_club_central.models.User;

/**
 * Servlet implementation class EventUserFeedbackServlet
 */
@WebServlet("/EventUserFeedbackServlet")
public class EventUserFeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventUserFeedbackServlet() {
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
		eventUserFeedback(Integer.parseInt(request.getParameter("eventIdFeedback")), ((User) request.getSession().getAttribute("user")).getId_num(), request.getParameter("eventFeedbackMessage"));
		response.sendRedirect("UserServlet");
	}
	
	private void eventUserFeedback(int eventId, int userId, String feedback) {
		EventUserFeedbackDao eDao = new EventUserFeedbackDao();
		eDao.insertFeedback(eventId, userId, feedback);
	}

}
