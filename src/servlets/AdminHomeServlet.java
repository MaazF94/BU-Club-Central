package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ben.bu_club_central.daos.UserDao;

/**
 * Servlet implementation class AdminHome
 */
@WebServlet("/user/AdminHome")
public class AdminHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminHomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer roleID = Integer.parseInt(request.getParameter("role_id"));
		if (roleID == 3){
			request.getRequestDispatcher("/WEB-INF/jsp/AdminHome.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/WEB-INF/jsp/Home.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
		if (callSetUserRoleID(request.getParameter("first_name"), request.getParameter("last_name"), 
				Integer.parseInt(request.getParameter("id_num")), request.getParameter("email"), 
				Integer.parseInt(request.getParameter("role_id")))) {
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
request.getRequestDispatcher("/WEB-INF/jsp/AdminHome.jsp").forward(request, response);
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
								"You entered some information incorrectly, please try again.\r\n" +
								"\t\t</div>\r\n" +
								"</body>\r\n" +
								"</html>";
					request.setAttribute("message", message);
					request.getRequestDispatcher("AdminHome").forward(request, response);
		}
		
		//ClubDao cDao = new ClubDao();
		//cDao.addClub(request.getParameter("clubName"),Integer.parseInt(request.getParameter("club_id_num")), Integer.parseInt(request.getParameter("memberCount")), 1);
		//request.getRequestDispatcher("/WEB-INF/jsp/AdminHome.jsp").forward(request, response);
	}
	
	public static boolean callSetUserRoleID(String first_name, String last_name, int id_num, String email, int role_id) {
		UserDao uDao = new UserDao();
		
		if (uDao.userRoleChanges(first_name, last_name, id_num, email, role_id)) {
			return true;
		}
		
		return false;
	}

}
