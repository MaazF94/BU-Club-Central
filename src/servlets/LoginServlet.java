package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.ben.bu_club_central.daos.UserDao;
import edu.ben.bu_club_central.models.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// public static HttpSession session;
	private UserDao uDao = new UserDao();
	HttpSession session;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
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
		HttpSession session = request.getSession(false);
		request.getRequestDispatcher("/WEB-INF/jsp/Login.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user;
		PrintWriter out = response.getWriter();

		if (!request.getParameter("username").equals(null) || !request.getParameter("password").equals(null)) {
			if (!(loginUser(request.getParameter("username")) == null)) {
				user = uDao.getUserByUsername(request.getParameter("username"));
				request.getSession().setAttribute("user", user);
				request.getSession().setAttribute("loggedIn", 0);
				if (user.getRole_id() == 1) {
					response.sendRedirect("UserServlet");
				} else if (user.getRole_id() == 2) {

					
					
					response.sendRedirect("BoardMemberDashBoard");
					
					out.println("logIn();");
					
				} else {
					response.sendRedirect("AdminHome");
				}
			} else {
				response.sendRedirect("errorLogin");
			
			}
		} else {
			response.sendRedirect("errorLogin");
		}

	
	}// Need to add if checks for where to long into when there are different
		// roles. ie: user, admin, president


	private User loginUser(String username) {
		uDao = new UserDao();
		return uDao.getUserByUsername(username);
	}

}
