package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ben.bu_club_central.daos.ClubDao;
import edu.ben.bu_club_central.daos.ClubMembershipDao;
import edu.ben.bu_club_central.daos.UserDao;
import edu.ben.bu_club_central.models.Club;
import edu.ben.bu_club_central.models.ClubMembership;
import edu.ben.bu_club_central.models.User;

/**
 * Servlet implementation class NewUserHomePageServlet
 */
@WebServlet("/NewUserHomePageServlet")
public class NewUserHomePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewUserHomePageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LinkedList<Club> clubList = new LinkedList<Club>();
		ClubDao cDao = new ClubDao();
		clubList = cDao.displayClub();
		request.setAttribute("clubList", clubList);
		
		request.getRequestDispatcher("/WEB-INF/jsp/NewUserHomePage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] clubIdList = new String[100];
		clubIdList = request.getParameterValues("club_id_num");
		
		int user_id = (((User) request.getSession().getAttribute("user")).getUser_id());
		callUserJoinClub(user_id, clubIdList);
		response.sendRedirect("UserServlet");
	
	}
	
	private void callUserJoinClub(int userID,
			String[] clubIdList) {
		ClubMembershipDao cmDao = new ClubMembershipDao();

		List<ClubMembership> memberships = new ArrayList<ClubMembership>();

		for (int i = 0; i < clubIdList.length; i++) {
			ClubMembership m = new ClubMembership(Integer.parseInt(clubIdList[i]), userID, 1, true, "");
			if (m != null) {
				memberships.add(m);
			}
		}

		if (cmDao.addUserToClubs(memberships)) {
			System.out.println("User Joined Club");
		} else {
			System.out.println("User did not join club");
		}
	}
	
	

}
