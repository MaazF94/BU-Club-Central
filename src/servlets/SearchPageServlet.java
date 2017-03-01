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
import edu.ben.bu_club_central.models.Events;

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
					System.out.println("<p>No Record Found!</p>");
				} else {
					eventList = new LinkedList<Events>();
					Events event;
					while (rs.next()) {
						event = new Events(rs.getString("event_name"), rs.getString("description"), rs.getString("location"), rs.getInt("club_id_num"));
						event.setRsvp_count(rs.getInt("rsvp_count"));
						eventList.add(event);
						response.getWriter().println(event.getEvent_name() + " " + event.getLocation());
						response.getWriter().print("<br>");
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
