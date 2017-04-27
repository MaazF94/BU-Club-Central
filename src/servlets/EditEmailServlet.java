package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ben.bu_club_central.daos.UserDao;
import edu.ben.bu_club_central.models.User;

/**
 * Servlet implementation class EditEmailServlet
 */
@WebServlet("/EditEmailServlet")
public class EditEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditEmailServlet() {
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
		request.getRequestDispatcher("/WEB-INF/jsp/UserDashboard.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			int user_id = (((User) request.getSession().getAttribute("user")).getUser_id());
			boolean result = true;

			if (request.getParameter("email") != null) {
				if (callEditEmail(user_id, request.getParameter("email"))) {
					
				} else {
					result = false;
				}
			}

			if (request.getParameter("first_name") != null) {
				if (callEditFirstName(user_id, request.getParameter("first_name"))) {

				} else {
					result = false;
				}
			}

			if (request.getParameter("last_name") != null) {
				if (callEditLastName(user_id, request.getParameter("last_name"))) {

				} else {
					result = false;
				}
			}

			if (result == true) {
			String message = "<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" + "<title>Mileage</title>\r\n"
					+ "<style> \r\n" + ".isa_success {\r\n" + "color: #4F8A10;\r\n" + "background-color: #DFF2BF;\r\n"
					+ "}\r\n" + "</style>\r\n" + "</head>\r\n<body>\r\n" + "<div class=isa_success>\r\n"
					+ "<i class=fa fa-check></i>\r\n" + "You successfully changed your information.\r\n" + "\t\t</div>\r\n"
					+ "</body>\r\n" + "</html>";
			request.setAttribute("message", message);
			response.sendRedirect("UserServlet");
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			String message = "<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" + "<title>Mileage</title>\r\n"
					+ "<style> \r\n" + ".isa_error {\r\n" + "color: #D8000C;\r\n" + "background-color: #FFBABA;\r\n"
					+ "}\r\n" + "</style>\r\n" + "</head>\r\n<body>\r\n" + "<div class=isa_error>\r\n"
					+ "<i class=fa fa-times-circle></i>\r\n" + "An error occurred with trying to change your info.\r\n"
					+ "\t\t</div>\r\n" + "</body>\r\n" + "</html>";
			request.setAttribute("message", message);
			response.sendRedirect("UserServlet");
		}
	}

	public static boolean callEditEmail(int user_id, String email) {
		UserDao uDao = new UserDao();
		if (uDao.editEmail(user_id, email)) {
			return true;
		}

		return false;
	}
	
	public static boolean callEditFirstName(int user_id, String firstName) {
		UserDao uDao = new UserDao();
		if (uDao.editFirstName(user_id, firstName)) {
			return true;
		}

		return false;
	}
	
	public static boolean callEditLastName(int user_id, String lastName) {
		UserDao uDao = new UserDao();
		if (uDao.editLastName(user_id, lastName)) {
			return true;
		}

		return false;
	}

}
