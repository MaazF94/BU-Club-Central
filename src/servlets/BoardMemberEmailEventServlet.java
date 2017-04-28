package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ben.bu_club_central.daos.EventRSVPListDao;
import edu.ben.bu_club_central.models.User;
import mailDispatcher.SendMail;

/**
 * Servlet implementation class BoardMemberEmailEventServlet
 */
@WebServlet("/BoardMemberEmailEventServlet")
public class BoardMemberEmailEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardMemberEmailEventServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("AccessDeniedServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sendEmailToEvent(Integer.parseInt(request.getParameter("sendEmailId")), request.getParameter("contentEmail"));
		response.sendRedirect("BoardMemberDashBoard");
		
	}
	
	/**
	 * this method sends an email to the board member about an upcoming event 
	 * @param eventId
	 * @param emailContent
	 */
	private void sendEmailToEvent(int eventId, String emailContent) {
		EventRSVPListDao rsvpDao = new EventRSVPListDao();
		LinkedList<User> userList = rsvpDao.getAllUsersForEvent(eventId);
		
		String subject = "An Email about an upcoming event you are going to";
		
		int index = 0;
		int listSize = userList.size();
		
		while(index < listSize) {
			SendMail.email("BUclubcentral@gmail.com", "BUclubcentral@gmail.com" , "thefirm123", userList.get(index).getEmail(), subject, emailContent);
			index++;
		}
		
	}
	
	
	
	

}
