package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ben.bu_club_central.daos.EventRSVPListDao;
import edu.ben.bu_club_central.daos.EventsDao;
import edu.ben.bu_club_central.daos.UserDao;
import edu.ben.bu_club_central.models.Events;
import edu.ben.bu_club_central.models.User;
import mailDispatcher.SendMail;

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
		addUserToRsvpList(Integer.parseInt(request.getParameter("eventId")), ((User) request.getSession().getAttribute("user")).getId_num());
		sendEmailNotification(((User)request.getSession().getAttribute("user")), Integer.parseInt(request.getParameter("eventId")));
		response.sendRedirect("EventServlet");
	}

	private void addRSVP(int eventId) {
		EventsDao eDao = new EventsDao();
		eDao.increaseRSVPCount(eventId);
	}
	
	private void addUserToRsvpList(int eventId, int user_id_num) {
		EventRSVPListDao rsvpListDao = new EventRSVPListDao();
		rsvpListDao.rsvpUserForEvent(eventId, user_id_num);
		
	}
	
	private void sendEmailNotification(User u, int eventId) {
		EventsDao eDao = new EventsDao();
		Events event = eDao.getEventByEventId(eventId);
		
		UserDao uDao = new UserDao();
		LinkedList<User> userList = uDao.getAllBoardMembersForEachClub(event.getClub_id_num());
		
		int listSize = userList.size();
		int index = 0;
		String fromEmail = "BUclubcentral@gmail.com"; 
		String username = "BUclubcentral@gmail.com";
		String password = "thefirm123";
		String toEmail; 
		String name = u.getFirst_name() + " " + u.getLast_name();
		String subject = "A new user plans on going to your event!!!";
		String content = name + " has just rsvped for " + event.getEvent_name();
		
		while(index < listSize) {
			SendMail.email("BUclubcentral@gmail.com", "BUclubcentral@gmail.com" , "thefirm123", userList.get(index).getEmail(), subject, content);
			index++;
		}
			
	}
	
	
	
	
	
	
}
