package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ben.bu_club_central.daos.ClubDao;
import edu.ben.bu_club_central.daos.UserDao;
import edu.ben.bu_club_central.models.Club;
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
		updateClub(((User) request.getSession().getAttribute("user")).getId_num(), Integer.parseInt(request.getParameter("club_id_num")));
		request.getSession().invalidate();
		response.sendRedirect("LoginServlet");
	
	}
	
	
	private void updateClub(int user_id, int club_id_num) {
		UserDao uDao = new UserDao();
		uDao.addClubForNewUser(user_id, club_id_num);
	}
	
	

}
