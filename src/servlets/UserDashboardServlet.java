package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ben.bu_club_central.daos.ClubDao;
import edu.ben.bu_club_central.daos.EventNotificationDao;
import edu.ben.bu_club_central.daos.EventRSVPListDao;
import edu.ben.bu_club_central.daos.EventsDao;
import edu.ben.bu_club_central.daos.PostDao;
import edu.ben.bu_club_central.daos.UserDao;
import edu.ben.bu_club_central.models.Club;
import edu.ben.bu_club_central.models.Events;
import edu.ben.bu_club_central.models.Post;
import edu.ben.bu_club_central.models.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserDashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDashboardServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (((User) request.getSession().getAttribute("user")).getRole_id() == 1) {
			
			LinkedList<Events> eventList = new LinkedList<Events>();
			EventRSVPListDao eDao = new EventRSVPListDao();
			eventList = eDao.getAllEventsThatuserRSVP(((User)request.getSession().getAttribute("user")).getId_num());
			request.setAttribute("eventList", eventList);
			
			LinkedList<Events> eventList2 = new LinkedList<Events>();
			EventsDao eDao2 = new EventsDao();
			eventList2 = eDao2.getAllEventsByClubId(((User) request.getSession().getAttribute("user")).getClub_id_num());
			request.setAttribute("eventList2", eventList2);
			
			PostDao pDao = new PostDao();
			LinkedList<Post> postList = new LinkedList<Post>();
			postList = pDao.getAllPostsByClubId(((User) request.getSession().getAttribute("user")).getClub_id_num());
			request.setAttribute("postList", postList);
			
			EventNotificationDao eventNotDao = new EventNotificationDao();
			LinkedList<Events> eventList3 = eventNotDao
					.getEventNotifications(((User) request.getSession().getAttribute("user")).getClub_id_num());
			request.setAttribute("eventList3", eventList3);
			
			UserDao uDao = new UserDao();
			LinkedList<User> userList2 = uDao.displayUsersInfo(((User) request.getSession().getAttribute("user")).getUser_id());
			request.setAttribute("userList2", userList2);
			
			ClubDao cDao = new ClubDao();
			LinkedList<Club> clubList = cDao.getAllClubs();
			request.setAttribute("clubList", clubList);
			
			request.getRequestDispatcher("/WEB-INF/jsp/UserDashboard.jsp").forward(request, response);
		}else {
			response.sendRedirect("AccessDeniedServlet");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
