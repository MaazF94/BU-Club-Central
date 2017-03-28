package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.ben.bu_club_central.daos.ClubDao;
import edu.ben.bu_club_central.models.Club;
import edu.ben.bu_club_central.models.User;

/**
 * Servlet implementation class EditClubDescriptionServlet
 */
@WebServlet("/EditClubDescriptionServlet")
public class EditClubDescriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditClubDescriptionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.getRequestDispatcher("/WEB-INF/jsp/BoardMemberDashboard.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ClubDao cDao = new ClubDao();
		Club clubObject = cDao.getClubById(((User) request.getSession().getAttribute("user")).getClub_id_num());
		int club_id_num = clubObject.getClub_id_num();
		
		callEditClubDescription(request.getParameter("editDescription"), club_id_num);
		doGet(request, response);
	}
	
	public static void callEditClubDescription(String club_description, int club_id_num) {
		ClubDao cDao = new ClubDao();
		cDao.editClubDescription(club_description, club_id_num);
		
	}

}
