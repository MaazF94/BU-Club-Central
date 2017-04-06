package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.ben.bu_club_central.daos.EventsDao;
import edu.ben.bu_club_central.models.Events;

/**
 * Servlet implementation class EventpageByClub
 */
@WebServlet("/EventpageByClub")
public class SearchEventsByClubID extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static HttpSession session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchEventsByClubID() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		System.out.println("IT GETS HERE GET ");
//		String clubID = request.getParameter("clubID");
//		System.out.println(request.getContextPath());
//		System.out.println("IT GETS HERE GET too ");
//		System.out.println(clubID);
		//request.setAttribute(arg0, arg1);
		request.getRequestDispatcher("/WEB-INF/jsp/EventPageByClub.jsp").forward(request, response);
	}

	/**w
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession();
		
		EventsDao eventDao = new EventsDao();		
		int clubid = Integer.parseInt(request.getParameter("clubID"));
		session.setAttribute("clubID",clubid );
		System.out.println(clubid);
		doGet(request, response);
	}

}
