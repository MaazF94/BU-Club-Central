package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ben.bu_club_central.daos.UserDao;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
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
		request.getRequestDispatcher("/WEB-INF/jsp/Register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (userErrorChecking(request.getParameter("first_name"), request.getParameter("last_name"),
				request.getParameter("username"), request.getParameter("passwrd"),
				request.getParameter("repeat-passwrd"), request.getParameter("id_num"), request.getParameter("email"),
				request, response)) {
			callRegisterUser(request.getParameter("first_name"), request.getParameter("last_name"),
					request.getParameter("username"), request.getParameter("passwrd"),
					Integer.parseInt(request.getParameter("id_num")), request.getParameter("email"));
			response.sendRedirect("HomeServlet");
		} else {
			response.sendRedirect("RegisterServlet");
		}

	}

	public static void callRegisterUser(String first_name, String last_name, String username, String passwrd,
			int id_num, String email) {
		UserDao uDao = new UserDao();

		uDao.registerUser(first_name, last_name, username, passwrd, id_num, email);
		System.out.println("Added user");
	}

	private static boolean userErrorChecking(String first_name, String last_name, String username, String passwrd,
			String passwrd2, String id_num, String email, HttpServletRequest request, HttpServletResponse response) {
		UserDao uDao = new UserDao();
		
//		if(uDao.checkName(first_name, last_name) && uDao.checkUsernameChars(username) && !uDao.checkUsernameExist(username) &&
//				uDao.checkPasswordMatch(passwrd, passwrd2) && uDao.checkId_num(id_num) && uDao.checkEmail(email)) {
//			return true;
//		}else {
//			return false;
//		}
		
		
		if (uDao.checkName(first_name, last_name)) {
			if (uDao.checkUsernameChars(username)) {
				if (!uDao.checkUsernameExist(username)) {
					if (uDao.checkPasswordMatch(passwrd, passwrd2)) {
						if (uDao.checkId_num(id_num)) {
							if (uDao.checkEmail(email)) {
								return true;
							} else {
								request.setAttribute("message", "Email is not in the correct format");
								return false;
							}
						} else {
							request.setAttribute("message", "ID number must only contain numbers");
							return false;
						}
					} else {
						request.setAttribute("message", "Passwords do not match");
						return false;
					}
				} else {
					request.setAttribute("message", "Username already exists");
					return false;
				}
			} else {
				request.setAttribute("message", "Username must only have letters and numbers");
				return false;
			}
		} else {
			request.setAttribute("message", "First or Last name is incorrect");
			return false;
		}
	}

}
