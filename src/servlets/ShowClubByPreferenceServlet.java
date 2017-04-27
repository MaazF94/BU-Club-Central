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
 * Servlet implementation class ShowClubByPreferenceServlet
 */
@WebServlet("/ShowClubByPreferenceServlet")
public class ShowClubByPreferenceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowClubByPreferenceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao uDao = new UserDao();
		String club_id = request.getParameter("club_id_num");
		String[] preferences = request.getParameterValues("preference");
		uDao.updatePreference(preferences, (((User) request.getSession().getAttribute("user")).getUser_id()));
		response.sendRedirect("UserServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
