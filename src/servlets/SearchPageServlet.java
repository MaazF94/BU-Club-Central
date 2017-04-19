package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ben.bu_club_central.daos.DatabaseConnection;
import edu.ben.bu_club_central.daos.EventsDao;
import edu.ben.bu_club_central.models.Events;
import edu.ben.bu_club_central.models.User;

/**
 * Servlet implementation class SearchPageServlet
 */
@WebServlet("/SearchPageServlet")
public class SearchPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public LinkedList<Events> eventList = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchPageServlet() {
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
		// request.getRequestDispatcher("/WEB-INF/jsp/SearchPage.jsp").forward(request,
		// response);
		
		
		
		String name = request.getParameter("val");
		if (name == null || name.trim().equals("")) {
			System.out.print("<p>Please enter name!</p>");
		} else {
			try {

				Connection con = new DatabaseConnection().getConn();

				PreparedStatement ps = con
						.prepareStatement("select * from event where event_name like '%" + name + "%'");
				ResultSet rs = ps.executeQuery();

				if (!rs.isBeforeFirst()) {
//					response.getWriter().println("No Record Found!!!");
//					response.getWriter().println("<br>");
//					response.getWriter().println("<h3>These are all the events to search from</h3>");
//					response.getWriter().println("<br>");
					
					LinkedList<Events> preSearchList = new LinkedList<Events>();
					EventsDao eDao = new EventsDao();
					preSearchList = eDao.getAllEvents();
					int listIndex = 0;
					int listSize = preSearchList.size();
					
					while (listIndex < listSize) {
//						response.getWriter().println("<tr>");
//						response.getWriter().println("<td> </td>");
//						response.getWriter().println("<td> </td>");
						
						response.getWriter().println("<tr>");
						response.getWriter().println("<td> </td>");
						response.getWriter().println("<td> </td>");
						response.getWriter().println("<td>");
						response.getWriter().println(preSearchList.get(listIndex).getEvent_name());
						response.getWriter().println("<td>");
						response.getWriter().println(preSearchList.get(listIndex).getLocation());
						response.getWriter().println("</td>");
						response.getWriter().println("</tr>");
						
//						response.getWriter().print("<br>");
						listIndex++;
						}
					
					
					
				} else {
					eventList = new LinkedList<Events>();
					Events event = null;
					
					
					
					while (rs.next()) {
						event = new Events(rs.getString("event_name"), rs.getString("description"), rs.getString("location"), rs.getInt("club_id_num"), rs.getString("category"));
						event.setRsvp_count(rs.getInt("rsvp_count"));
						event.setEventId(Integer.parseInt(rs.getString("idevent")));
						eventList.add(event);
						
						String eventidnum = Integer.toString(event.getEventId()) ;
						
						response.getWriter().println("<tr>");
						response.getWriter().println("<td> </td>");
						response.getWriter().println("<td> </td>");
					
						response.getWriter().println("<td>");
						response.getWriter().println(event.getEvent_name());
						response.getWriter().println("</td>");
						
						response.getWriter().println("<td>");
						response.getWriter().println(event.getLocation());
						response.getWriter().println("</td>");
						
						response.getWriter().println("<td>");
						response.getWriter().println("<a href=\"EventDetailsServlet?eventId=" + event.getEventId() + "\">More Info</a>");
						
						response.getWriter().println("</td>");
						
						response.getWriter().println("</tr>");
						
					}
					
				} // end of else for rs.isBeforeFirst
				con.close();
			} catch (Exception e) {
				System.out.print(e);
			}
		} // end of else

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
