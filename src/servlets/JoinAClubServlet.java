package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.ben.bu_club_central.daos.ClubMembershipDao;
import edu.ben.bu_club_central.daos.UserDao;
import edu.ben.bu_club_central.models.ClubMembership;

/**
 * Servlet implementation class JoinAClubServlet
 */
@WebServlet("/JoinAClubServlet")
public class JoinAClubServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JoinAClubServlet() {
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
		session = request.getSession();
		session.setAttribute("first_name", null);
		request.getRequestDispatcher("/WEB-INF/jsp/JoinAClub.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			String[] clubIdList = new String[100];
			clubIdList = request.getParameterValues("club_id_num");

			if (callUserJoinClub(request.getParameter("first_name"), request.getParameter("last_name"),
					Integer.parseInt(request.getParameter("id_num")), request.getParameter("email"), clubIdList)) {
				String message = "<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" + "<title>Mileage</title>\r\n"
						+ "<style> \r\n" + ".isa_success {\r\n" + "color: #4F8A10;\r\n"
						+ "background-color: #DFF2BF;\r\n" + "}\r\n" + "</style>\r\n" + "</head>\r\n<body>\r\n"
						+ "<div class=isa_success>\r\n" + "<i class=fa fa-check></i>\r\n"
						+ "You successfully joined.\r\n" + "\t\t</div>\r\n" + "</body>\r\n" + "</html>";
				request.setAttribute("message", message);
				request.getRequestDispatcher("/WEB-INF/jsp/JoinAClub.jsp").forward(request, response);
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			String message = "<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" + "<title>Mileage</title>\r\n"
					+ "<style> \r\n" + ".isa_error {\r\n" + "color: #D8000C;\r\n" + "background-color: #FFBABA;\r\n"
					+ "}\r\n" + "</style>\r\n" + "</head>\r\n<body>\r\n" + "<div class=isa_error>\r\n"
					+ "<i class=fa fa-times-circle></i>\r\n"
					+ "You entered some information incorrectly, please try again.\r\n" + "\t\t</div>\r\n"
					+ "</body>\r\n" + "</html>";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/WEB-INF/jsp/JoinAClub.jsp").forward(request, response);
		}
	}

	/**
	 * Call user to join a club method
	 * 
	 * @param first_name
	 * @param last_name
	 * @param id_num
	 * @param email
	 * @param clubIdList
	 * @return true if worked, otherwise false
	 */
	public static boolean callUserJoinClub(String first_name, String last_name, int id_num, String email,
			String[] clubIdList) {
		ClubMembershipDao cmDao = new ClubMembershipDao();
		UserDao uDao = new UserDao();
		int userID = 0;

		userID = uDao.getIDUser(first_name, last_name, id_num, email);

		List<ClubMembership> memberships = new ArrayList<ClubMembership>();

		for (int i = 0; i < clubIdList.length; i++) {
			ClubMembership m = new ClubMembership(Integer.parseInt(clubIdList[i]), userID, 1, true, "");
			if (m != null) {
				memberships.add(m);
			}
		}

		if (cmDao.addUserToClubs(memberships)) {
			System.out.println("User Joined Club");
			return true;
		} else {
			System.out.println("User did not join club");
		}
		return false;
	}

}
