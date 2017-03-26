package servlets;

import java.io.IOException;
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
 * Servlet implementation class ClubHomepageServlet
 */
@WebServlet("/ClubHomepageServlet")
public class ClubHomepageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClubHomepageServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		

		request.getRequestDispatcher("/WEB-INF/jsp/ClubHomepage.jsp").forward(request, response);
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

	/**
	 * call the clubMemberCount method
	 * 
	 * @param club_id
	 * @return the number of members in club
	 */
	public static int callClubMemberCount(int club_id) {
		int memberCount = 0;

		ClubMembershipDao cmDao = new ClubMembershipDao();

		try {
			memberCount = cmDao.countClubMembers(club_id);
			System.out.println("Members counted");
			return memberCount;
		} catch (Exception e) {
			System.out.println("Club doesn't exist");
		}

		return 0;
	}

}
