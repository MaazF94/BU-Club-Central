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
 * Servlet implementation class UserLeavesClubServlet
 */
@WebServlet("/UserLeavesClubServlet")
public class UserLeavesClubServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserLeavesClubServlet() {
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

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		ClubMembershipDao cmDao = new ClubMembershipDao();
		String ID = request.getParameter("clubID");
		int club_ID = Integer.parseInt(ID);
		cmDao.userLeavesClub(((User) request.getSession().getAttribute("user")).getUser_id(), club_ID);
		if (((User) request.getSession().getAttribute("user")).getRole_id() == 1) {
			response.sendRedirect("UserServlet");
		} else {
			response.sendRedirect("BoardMemberDashBoard");
		}	}

}
