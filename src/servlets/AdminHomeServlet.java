package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ben.bu_club_central.daos.BenUnionDao;
import edu.ben.bu_club_central.daos.ClubDao;
import edu.ben.bu_club_central.daos.DocumentForAdminDao;
import edu.ben.bu_club_central.daos.EventsDao;
import edu.ben.bu_club_central.daos.PostDao;
import edu.ben.bu_club_central.daos.UserDao;
import edu.ben.bu_club_central.models.Club;
import edu.ben.bu_club_central.models.DocumentForAdmin;
import edu.ben.bu_club_central.models.Events;
import edu.ben.bu_club_central.models.ItemForCheckout;
import edu.ben.bu_club_central.models.Post;
import edu.ben.bu_club_central.models.User;

/**
 * Servlet implementation class AdminHome
 */
@WebServlet("/AdminHome")
public class AdminHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminHomeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (((User) request.getSession().getAttribute("user")).getRole_id() == 3) {
			
			ClubDao clubDao = new ClubDao();
			LinkedList<Club> clubList = new LinkedList<Club>();
			clubList = clubDao.displayClubForAdmin();
			request.setAttribute("clubList", clubList);
			
			LinkedList<Events> eventList = new LinkedList<Events>();
			EventsDao eDao = new EventsDao();
			eventList = eDao.getAllEvents();
			request.setAttribute("eventList", eventList);
			
			LinkedList<Events> eventList2 = new LinkedList<Events>();
			EventsDao eDao2 = new EventsDao();
			eventList2 = eDao2.getAllEvents();
			request.setAttribute("eventList2", eventList2);
			
			PostDao pDao = new PostDao();
			LinkedList<Post> postList = new LinkedList<Post>();
			postList = pDao.getAllPosts();
			request.setAttribute("postList", postList);
			
			UserDao uDao = new UserDao();
			LinkedList<User> userList = new LinkedList<User>();
			userList = uDao.getAllUsers();
			request.setAttribute("userList", userList);
			
			DocumentForAdminDao dfaDao = new DocumentForAdminDao();
			LinkedList<DocumentForAdmin> documentForAdminList = new LinkedList<DocumentForAdmin>();
			documentForAdminList = dfaDao.displayDocumentForAdminInfo();
			request.setAttribute("documentForAdminList", documentForAdminList);
			
			ClubDao clubDao2 = new ClubDao();
			LinkedList<Club> clubList2 = new LinkedList<Club>();
			clubList2 = clubDao2.displayClubForAdmin();
			request.setAttribute("clubList2", clubList2);
			
			BenUnionDao bud = new BenUnionDao();
			LinkedList<ItemForCheckout> itemList = new LinkedList<ItemForCheckout>();
			itemList = bud.getItemsNotCheckedIn();
			request.setAttribute("itemList", itemList);
			
			request.getRequestDispatcher("/WEB-INF/jsp/AdminHome.jsp").forward(request, response);
		} else {
			response.sendRedirect("AccessDeniedServlet");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
