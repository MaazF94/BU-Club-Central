package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ben.bu_club_central.daos.CommentDao;
import edu.ben.bu_club_central.daos.EventsDao;
import edu.ben.bu_club_central.daos.PostDao;

/**
 * Servlet implementation class LikeEventServlet
 */
@WebServlet("/LikeEventServlet")
public class LikeEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LikeEventServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/EventPage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int eventID = 0;
		EventsDao eDao = new EventsDao();
		eventID = Integer.parseInt(request.getParameter("eventID"));
		int currentLikes = eDao.getNumOfLikes(eventID);
		eDao.addLikeToEvent(eventID, currentLikes);;
		doGet(request, response);
	}
	
	

}
