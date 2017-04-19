package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ben.bu_club_central.daos.UserDao;

/**
 * Servlet implementation class CreateNewUsernameServlet
 */
@WebServlet("/CreateNewUsernameServlet")
public class CreateNewUsernameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewUsernameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String id_num = request.getParameter("id_num");
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");

		if (email == null || id_num==null || firstName==null || lastName==null) {
			request.getRequestDispatcher("/WEB-INF/jsp/ErrorCatchAllPage.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/jsp/CreateNewUsername.jsp").forward(request, response);
		}	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (callCreateNewUsername(request.getParameter("first_name"), request.getParameter("last_name"),
				Integer.parseInt(request.getParameter("id_num")), request.getParameter("username"))) {
			String message = 	"<!DOCTYPE html>\r\n" + 
					"<html>\r\n" +
					"<head>\r\n" +
					"<title>Mileage</title>\r\n" +
					"<style> \r\n" +
					".isa_success {\r\n" +
					"color: #4F8A10;\r\n" +
					"background-color: #DFF2BF;\r\n" +
					"}\r\n" +
					"</style>\r\n" +
					"</head>\r\n<body>\r\n" +
					"<div class=isa_success>\r\n" +
					"<i class=fa fa-check></i>\r\n" +
					"You have successfully reset your username.\r\n" +
					"\t\t</div>\r\n" +
					"</body>\r\n" +
					"</html>";		
			request.setAttribute("message", message);
			request.getRequestDispatcher("/WEB-INF/jsp/CreateNewPassword.jsp").forward(request, response);
		} else {
			String message = 	"<!DOCTYPE html>\r\n" + 
					"<html>\r\n" +
					"<head>\r\n" +
					"<title>Mileage</title>\r\n" +
					"<style> \r\n" +
					".isa_success {\r\n" +
					"color: #4F8A10;\r\n" +
					"background-color: #DFF2BF;\r\n" +
					"}\r\n" +
					"</style>\r\n" +
					"</head>\r\n<body>\r\n" +
					"<div class=isa_success>\r\n" +
					"<i class=fa fa-check></i>\r\n" +
					"You entered some information incorrectly.\r\n" +
					"\t\t</div>\r\n" +
					"</body>\r\n" +
					"</html>";		
			request.setAttribute("message", message);
			request.getRequestDispatcher("/WEB-INF/jsp/CreateNewPassword.jsp").forward(request, response);
		}
		
	}
	
	public static boolean callCreateNewUsername(String first_name, String last_name, int id_num, String newUsername) {
		UserDao uDao = new UserDao();
		if (uDao.userForgotUsernameUpdate(first_name, last_name, id_num, newUsername)) {
			return true;
		}
		return false;
	}

}
