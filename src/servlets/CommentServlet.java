package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ben.bu_club_central.daos.CommentDao;
import edu.ben.bu_club_central.daos.EventsDao;
import edu.ben.bu_club_central.daos.UserDao;
import edu.ben.bu_club_central.models.Events;
import edu.ben.bu_club_central.models.User;
import mailDispatcher.SendMail;

/**
 * Servlet implementation class CommentServlet
 */
@WebServlet("/CommentServlet")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentServlet() {
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
		addComment(request.getParameter("comment"), Integer.parseInt(request.getParameter("commentId_eventId")), ((User) request.getSession().getAttribute("user")).getId_num());
		sendEmailNotificationComment(((User)request.getSession().getAttribute("user")), request.getParameter("comment"), Integer.parseInt(request.getParameter("commentId_eventId")));
		response.sendRedirect("ClubHomepageServlet");
	
	}
	
	
	private void addComment(String comment, int eventId, int userId) {
		CommentDao cDao = new CommentDao();
		cDao.addComent(comment, eventId, userId);
	}
	
	
	
	private void sendEmailNotificationComment(User u, String comment, int commentId_eventId) {
		EventsDao eDao = new EventsDao();
		Events event = eDao.getEventByEventId(commentId_eventId);
		UserDao uDao = new UserDao();
		LinkedList<User> userList = uDao.getAllBoardMembersForEachClub(event.getClub_id_num());
		
		int listSize = userList.size();
		int index = 0;
		String fromEmail = "BUclubcentral@gmail.com"; 
		String username = "BUclubcentral@gmail.com";
		String password = "thefirm123";
		String toEmail; 
		String name = u.getFirst_name() + " " + u.getLast_name();
		String subject = "A new comment has been posted on an event!!!";
		String content = name + " has just left a comment on an event\n"
				+ "Comment: " + comment;
		
		while(index < listSize) {
			SendMail.email("BUclubcentral@gmail.com", "BUclubcentral@gmail.com" , "thefirm123", userList.get(index).getEmail(), subject, content);
			index++;
		}
			
	}
	
	
	
	
	

}
