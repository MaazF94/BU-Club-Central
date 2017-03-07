package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.ben.bu_club_central.daos.UserDao;

/**
 * Servlet implementation class JoinAClubServlet
 */
@WebServlet("/JoinAClubServlet")
public class JoinAClubServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinAClubServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		session = request.getSession();
		session.setAttribute("first_name", null);
		request.getRequestDispatcher("/WEB-INF/jsp/JoinAClub.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			callUserJoinClub(request.getParameter("first_name"), request.getParameter("last_name"),
				Integer.parseInt(request.getParameter("id_num")), request.getParameter("email"), Integer.parseInt(request.getParameter("club_id_num")));
		
		response.sendRedirect("HomeServlet");
		} catch (Exception e) {
		response.sendRedirect("JoinAClubServlet");
		}
	}
	public static void callUserJoinClub(String first_name, String last_name, int id_num, String email, int club_id_num) {
		UserDao uDao = new UserDao();

		uDao.userJoinClub(first_name, last_name, id_num, email, club_id_num);
		System.out.println("User Joined Club");
	}

}
