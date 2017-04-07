package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ben.bu_club_central.daos.ClubDao;
import edu.ben.bu_club_central.daos.ClubMembershipDao;
import edu.ben.bu_club_central.daos.CommentDao;
import edu.ben.bu_club_central.daos.DocumentDao;
import edu.ben.bu_club_central.daos.EventsDao;
import edu.ben.bu_club_central.daos.PostDao;
import edu.ben.bu_club_central.daos.UserDao;
import edu.ben.bu_club_central.models.Club;
import edu.ben.bu_club_central.models.ClubMembership;
import edu.ben.bu_club_central.models.Comment;
import edu.ben.bu_club_central.models.Document;
import edu.ben.bu_club_central.models.Events;
import edu.ben.bu_club_central.models.Post;
import edu.ben.bu_club_central.models.User;

/**
 * Servlet implementation class BoardMemberDashBoardServlet
 */
@WebServlet("/BoardMemberDashBoard")
public class BoardMemberDashBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardMemberDashBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (((User) request.getSession().getAttribute("user")).getRole_id() == 2) {
			ClubDao clDao = new ClubDao();
			Club clubObject = clDao.getClubById(((User) request.getSession().getAttribute("user")).getClub_id_num());
			request.setAttribute("clubObject", clubObject);
			
			LinkedList<Events> eventList = new LinkedList<Events>();
			EventsDao eDao = new EventsDao();
			eventList = eDao.getAllEventsByClubId(((User) request.getSession().getAttribute("user")).getClub_id_num());
			request.setAttribute("eventList", eventList);
			
			LinkedList<Events> eventList2 = new LinkedList<Events>();
			EventsDao eDao2 = new EventsDao();
			eventList2 = eDao.getAllEventsByClubId(((User) request.getSession().getAttribute("user")).getClub_id_num());
			request.setAttribute("eventList2", eventList2);
			
			PostDao pDao = new PostDao();
			LinkedList<Post> postList = new LinkedList<Post>();
			postList = pDao.getAllPostsByClubId(((User) request.getSession().getAttribute("user")).getClub_id_num());
			request.setAttribute("postList", postList);
			
			UserDao uDao = new UserDao();
			LinkedList<User> userList = new LinkedList<User>();
			userList = uDao.getAllUsersForClub(((User) request.getSession().getAttribute("user")).getClub_id_num());
			request.setAttribute("userList", userList);
			
			ClubMembershipDao cmDao = new ClubMembershipDao();
			LinkedList<ClubMembership> clubMembershipList = new LinkedList<ClubMembership>();
			clubMembershipList = cmDao.displayUserClubInfo(((User) request.getSession().getAttribute("user")).getUser_id());
			request.setAttribute("clubMembershipList", clubMembershipList);
			
			ClubMembershipDao cmDao2 = new ClubMembershipDao();
			LinkedList<ClubMembership> clubMembershipList2 = new LinkedList<ClubMembership>();
			clubMembershipList2 = cmDao2.displayUserPastClubInfo(((User) request.getSession().getAttribute("user")).getUser_id());
			request.setAttribute("clubMembershipList2", clubMembershipList2);
			
			DocumentDao dDao = new DocumentDao();
			LinkedList<Document> documentList = new LinkedList<Document>();
			documentList = dDao.displayDocumentInfo();
			request.setAttribute("documentList", documentList);
				
			LinkedList<Events> eventList3 = new LinkedList<Events>();
			EventsDao eDao3 = new EventsDao();
			eventList3 = eDao3.getAllEventsByClubId(((User) request.getSession().getAttribute("user")).getClub_id_num());
			request.setAttribute("eventList3", eventList3);
			
			
			LinkedList<Events> eventListFeedback = new LinkedList<Events>();
			EventsDao eventListFeedbackDao = new EventsDao();
			eventListFeedback = eventListFeedbackDao.getAllEventsByClubId(((User) request.getSession().getAttribute("user")).getClub_id_num());
			request.setAttribute("eventListFeedback", eventListFeedback);
			
			
			request.getRequestDispatcher("/WEB-INF/jsp/BoardMemberDashboard.jsp").forward(request, response);
			
		} else {
			response.sendRedirect("AccessDeniedServlet");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao uDao = new UserDao();
		if(uDao.checkNumericOnly(request.getParameter("id_num"))) {
			if(add_removeUserFromClub(request.getParameter("add_removeButton"), request.getParameter("id_num"))) {
				response.sendRedirect("BoardMemberDashBoard");
			}
		}else {
			response.sendRedirect("BoardMemberDashBoard");
		}
		
	}
	
	/**
	 * This method calls the add_remove from club method in user dao
	 * @param add_remove String parameter for add or remove: either add or remove for values
	 * @param id_num the id of the user you are adding or removing
	 * @return true if they add/remove user false otherwise
	 */
	public boolean add_removeUserFromClub(String add_remove, String id_num) {
		UserDao uDao = new UserDao();
		if(uDao.add_removeFromClub(add_remove, id_num, 1)) {
			return true;
		} else {
			return false;
		}
		
	}
	
	
	
	

}
