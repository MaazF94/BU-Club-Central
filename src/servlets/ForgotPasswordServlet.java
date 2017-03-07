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
@WebServlet("/ForgotPasswordServlet")
public class ForgotPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ForgotPasswordServlet() {
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
		request.getRequestDispatcher("/WEB-INF/jsp/ForgotPassword.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
		callUserPasswordChange(request.getParameter("username"), request.getParameter("passwrd"),
				Integer.parseInt(request.getParameter("id_num")), request.getParameter("email"));
		
		response.sendRedirect("HomeServlet");
		} catch (Exception e) {
		response.sendRedirect("ForgotPasswordServlet");
		}
	}

	public static void callUserPasswordChange(String username, String passwrd, int id_num, String email) {
		UserDao uDao = new UserDao();

		uDao.userPasswordChange(username, passwrd, id_num, email);
		System.out.println("Updated User Password");
	}

}
