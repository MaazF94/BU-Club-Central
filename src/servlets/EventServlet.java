package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import edu.ben.bu_club_central.daos.ClubDao;
import edu.ben.bu_club_central.daos.EventsDao;
import edu.ben.bu_club_central.models.Club;
import edu.ben.bu_club_central.models.Events;

import edu.ben.bu_club_central.models.User;


/**
 * Servlet implementation class EventServlet
 */
@WebServlet("/EventServlet")
public class EventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EventsDao eventDao = new EventsDao();
		LinkedList<Events> eventList = new LinkedList<Events>();
		eventList = eventDao.getAllEvents();
		
		request.setAttribute("eventList", eventList);
		
		ClubDao cDao2 = new ClubDao();
		LinkedList<Club> clubList = new LinkedList<Club>();
		clubList = cDao2.displayClub();
		
		request.setAttribute("clubList", clubList);
		
		
		request.getRequestDispatcher("/WEB-INF/jsp/EventPage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
