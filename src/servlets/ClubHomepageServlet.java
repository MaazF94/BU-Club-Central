package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ben.bu_club_central.daos.ClubDao;
import edu.ben.bu_club_central.models.Club;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String clubIdNum = (String) request.getParameter("bu_club_id");
		int club_id_num = Integer.parseInt(clubIdNum);
		
		ClubDao cDao = new ClubDao();
		Club clubObject = cDao.getClubById(club_id_num);
		String clubName = clubObject.getClub_name();
		request.setAttribute("clubName", clubName);
		
		int clubMembers = clubObject.getMember_count();
		Integer.toString(clubMembers);
		request.setAttribute("clubMembers", clubMembers);
		request.getRequestDispatcher("/WEB-INF/jsp/ClubHomepage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
