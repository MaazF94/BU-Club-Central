package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ben.bu_club_central.daos.ClubDao;

/**
 * Servlet implementation class AdminEnableClubServlet
 */
@WebServlet("/AdminEnableClubServlet")
public class AdminEnableClubServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminEnableClubServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("AccessDeniedServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		enableClub(Integer.parseInt(request.getParameter("enableClubId")));
		response.sendRedirect("AdminHome");
	}
	
	private void enableClub(int club_id_num) {
		ClubDao clubDao = new ClubDao();
		
		clubDao.enableClub(club_id_num);
	}
	
	
	
	

}