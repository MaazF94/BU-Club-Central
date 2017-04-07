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
 * Servlet implementation class EditPasswordServlet
 */
@WebServlet("/EditPasswordServlet")
public class EditPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/jsp/UserDashboard.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int user_id = (((User) request.getSession().getAttribute("user")).getUser_id());
			
		if (callEditPassword(user_id, request.getParameter("editPassword"))) {
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
					"You successfully changed your password.\r\n" +
					"\t\t</div>\r\n" +
					"</body>\r\n" +
					"</html>";
request.setAttribute("message", message);
response.sendRedirect("UserServlet");
} else {
			throw new Exception();
		}
		} catch (Exception e) {
			String message = 	"<!DOCTYPE html>\r\n" + 
								"<html>\r\n" +
								"<head>\r\n" +
								"<title>Mileage</title>\r\n" +
								"<style> \r\n" +
								".isa_error {\r\n" +
								"color: #D8000C;\r\n" +
								"background-color: #FFBABA;\r\n" +
								"}\r\n" +
								"</style>\r\n" +
								"</head>\r\n<body>\r\n" +
								"<div class=isa_error>\r\n" +
								"<i class=fa fa-times-circle></i>\r\n" +
								"An error occurred with trying to change your password.\r\n" +
								"\t\t</div>\r\n" +
								"</body>\r\n" +
								"</html>";
					request.setAttribute("message", message);
					response.sendRedirect("UserServlet");
					}
	}
	
	public static boolean callEditPassword(int user_id, String password) {
		UserDao uDao = new UserDao();
		if (uDao.editPassword(user_id, password)) {		
			return true;
		}
		
		return false;
	}
}
