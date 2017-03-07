package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ben.bu_club_central.daos.UserDao;

/**
 * Servlet implementation class ContactUsServlet
 */
@WebServlet("/ForgotUsernameServlet")
public class ForgotUsernameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao uDao = new UserDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ForgotUsernameServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/jsp/ForgotUsername.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
		callUserUsernameChange(request.getParameter("first_name"), request.getParameter("last_name"),
				Integer.parseInt(request.getParameter("id_num")), request.getParameter("email"), request.getParameter("username"));
		
		response.sendRedirect("HomeServlet");
		} catch (Exception e) {
		response.sendRedirect("ForgotUsernameServlet");
		}
	}

	public static void callUserUsernameChange(String first_name, String last_name, int id_num, String email, String username) {
		UserDao uDao = new UserDao();

		uDao.userUsernameChange(first_name, last_name, id_num, email, username);
		System.out.println("Updated User Username");
	}

}
