package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ben.bu_club_central.daos.ClubMembershipDao;
import edu.ben.bu_club_central.daos.UserDao;
import edu.ben.bu_club_central.models.User;

/**
 * Servlet implementation class DeleteUserServlet
 */
@WebServlet("/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteUserServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/BoardMemberDashboard.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ClubMembershipDao cmDao = new ClubMembershipDao();
		System.out.println(request.getParameter("UserID"));
		if (request.getParameterValues("UserID") == null) {
			response.sendRedirect("BoardMemberDashBoard");
		} else {
			String[] IDs = request.getParameterValues("UserID");
			int[] userIDs = new int[100];
			for (int i = 0; i < IDs.length; i++) {
				IDs[i].replace("[", "");
				IDs[i].replace("]", "");
				userIDs[i] = Integer.parseInt(IDs[i]);
			}
			cmDao.removeUserFromClub(((User) request.getSession().getAttribute("user")).getClub_id_num(), userIDs);
			response.sendRedirect("BoardMemberDashBoard");
		}
	}

}
