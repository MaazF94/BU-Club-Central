package servlets;

import java.io.IOException;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.ben.bu_club_central.daos.ClubDao;
import edu.ben.bu_club_central.daos.ClubMembershipDao;
import edu.ben.bu_club_central.models.Club;
import edu.ben.bu_club_central.models.User;

/**
 * Servlet implementation class LeaveClubFromClublistServlet
 */
@WebServlet("/LeaveClubFromClublistServlet")
public class LeaveClubFromClublistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LeaveClubFromClublistServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ClubMembershipDao cmDao = new ClubMembershipDao();
		String[] ID = request.getParameterValues("clubID");
		int[] club_id_nums = new int[100];
		for (int i = 0; i < ID.length; i++) {
			ID[i].replace("[", "");
			ID[i].replace("]", "");
			club_id_nums[i] = Integer.parseInt(ID[i].substring(0, 1));
		}
		cmDao.userLeavesClub(((User) request.getSession().getAttribute("user")).getUser_id(), club_id_nums);
		String message = "<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" + "<title>Mileage</title>\r\n"
				+ "<style> \r\n" + ".isa_success {\r\n" + "color: #4F8A10;\r\n"
				+ "background-color: #DFF2BF;\r\n" + "}\r\n" + "</style>\r\n" + "</head>\r\n<body>\r\n"
				+ "<div class=isa_success>\r\n" + "<i class=fa fa-check></i>\r\n"
				+ "You left the club.\r\n" + "\t\t</div>\r\n" + "</body>\r\n" + "</html>";
		request.setAttribute("message", message);
		request.getRequestDispatcher("/WEB-INF/jsp/ClubList.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/Clublist.jsp").forward(request, response);
	}

}
