package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ben.bu_club_central.daos.UserDao;

/**
 * Servlet implementation class CreateNewPasswordServlet
 */
@WebServlet("/CreateNewPasswordServlet")
public class CreateNewPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewPasswordServlet() {
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
		String username = request.getParameter("username");
		
		if (email == null || id_num==null || username==null) {
			request.getRequestDispatcher("/WEB-INF/jsp/ErrorCatchAllPage.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/jsp/CreateNewPassword.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (callCreateNewPassword(request.getParameter("password"), Integer.parseInt(request.getParameter("id_num")), 
				request.getParameter("username"))) {
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
					"You have successfully reset your password.\r\n" +
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
	
	public static boolean callCreateNewPassword(String password, int id_num, String username) {
		UserDao uDao = new UserDao();
		if (uDao.userUpdatePassword(username, password, id_num)) {
			return true;
		}
		return false;
	}

}
