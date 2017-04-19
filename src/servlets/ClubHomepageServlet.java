package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ben.bu_club_central.daos.ClubDao;
import edu.ben.bu_club_central.daos.ClubMembershipDao;
import edu.ben.bu_club_central.daos.PostCommentDao;
import edu.ben.bu_club_central.daos.PostDao;
import edu.ben.bu_club_central.daos.UserDao;
import edu.ben.bu_club_central.models.Club;
import edu.ben.bu_club_central.models.Post;
import edu.ben.bu_club_central.models.PostComments;
import edu.ben.bu_club_central.models.User;
import mailDispatcher.SendMail;

/**
 * Servlet implementation class ClubHomepageServlet
 */
@WebServlet("/ClubHomepage")
public class ClubHomepageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String clubIdNum = "";
	static String clubBoardMemberName = "";
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
		ClubDao cDao = new ClubDao();
		Club clubObject = cDao.getClubById(Integer.parseInt(request.getParameter("club_id_num")));
		String clubName = clubObject.getClub_name();
		request.setAttribute("clubName", clubName);

		int clubMemberCount = callClubMemberCount(clubObject.getClub_id_num());
		request.setAttribute("clubMembers", clubMemberCount);
		
		String clubDescription = clubObject.getClub_description();
		request.setAttribute("clubDescription", clubDescription);
		
		String advisor = clubObject.getAdvisor_name();
		request.setAttribute("advisorName", advisor);
		
		int club_id_num = Integer.parseInt(request.getParameter("club_id_num"));
		request.setAttribute("club_id_num", club_id_num);
		
		String broadcast = clubObject.getBroadcast_Update();
		request.setAttribute("broadcast", broadcast);
		
		PostDao pDao = new PostDao();
		LinkedList<Post> postList = new LinkedList<Post>();
		postList = pDao.getAllPostsByClubId(Integer.parseInt(request.getParameter("club_id_num")));
		request.setAttribute("postList", postList);
		
		
		
		request.getRequestDispatcher("/WEB-INF/jsp/ClubHomepage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			clubIdNum = (String) request.getParameter("bu_club_id");
			int club_id_num = Integer.parseInt(clubIdNum);

			ClubDao cDao = new ClubDao();
			Club clubObject = cDao.getClubById(club_id_num);
			clubBoardMemberName = clubObject.getPet_name();
			response.sendRedirect("ClubHomepageServlet");
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
