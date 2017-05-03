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
 * Servlet implementation class EditBoardServlet
 */
@WebServlet("/EditBoardServlet")
public class EditBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String President = request.getParameter("president");
		String vicePresident = request.getParameter("vicePresident");
		String treasurer = request.getParameter("treasurer");
		String secretary = request.getParameter("secretary");
		ClubDao cDao = new ClubDao();
		int club_id_num = Integer.parseInt(request.getParameter("clubId"));
		
		if(cDao.addPresident(club_id_num, President)){
			if(cDao.addVicePresident(club_id_num, vicePresident)){
				if(cDao.addTreasurer(club_id_num, treasurer)){
					if(cDao.addSecretary(club_id_num, secretary)){
						response.sendRedirect("AdminHome");
					}
				}
			}
		}
	}

}
