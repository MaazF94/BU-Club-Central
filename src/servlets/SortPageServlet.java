package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ben.bu_club_central.daos.DatabaseConnection;
import edu.ben.bu_club_central.models.User;

/**
 * Servlet implementation class SortPageServlet
 */
@WebServlet("/SortPageServlet")
public class SortPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SortPageServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("val");
		int club_idNum = ((User) request.getSession().getAttribute("user")).getClub_id_num();

		if (name == null || name.trim().equals("")) {
			System.out.print("<p>Please enter name!</p>");
		} else {

			DatabaseConnection dbc = new DatabaseConnection();
			Connection conn = dbc.getConn();
			String sql = null;

			if (name.equals("rsvpIncreasing")) {
				sql = "SELECT * FROM bu_club_central.event WHERE club_id_num=" + club_idNum + " ORDER BY rsvp_count ASC";
			} else if (name.equals("rsvpDecreasing")) {
				sql = "SELECT * FROM bu_club_central.event WHERE club_id_num=" + club_idNum
						+ " ORDER BY rsvp_count DESC";
			}

			PreparedStatement ps;
			ResultSet rs = null;
			try {
//				System.out.println(sql);
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {

				while (rs.next()) {
					
					response.getWriter().println("<tr>");
					response.getWriter().println("<td> </td>");
					response.getWriter().println("<td> </td>");
					response.getWriter().println("<td>");
					response.getWriter().println(rs.getString("event_name"));
					response.getWriter().println("<td>");
					response.getWriter().println(rs.getInt("rsvp_count"));
					response.getWriter().println("</td>");
					
					response.getWriter().println("<td>");
					response.getWriter().println("<a href=\"EventDetailsServlet?eventId=" + rs.getInt("idevent") + "\">More Info</a>");
					
					response.getWriter().println("</td>");
					
					response.getWriter().println("</tr>");

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
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
