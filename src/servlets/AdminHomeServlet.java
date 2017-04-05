package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ben.bu_club_central.daos.UserDao;
import edu.ben.bu_club_central.models.Club;
import edu.ben.bu_club_central.models.User;


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
		if (((User) request.getSession().getAttribute("user")).getRole_id() == 3) {
			request.getRequestDispatcher("/WEB-INF/jsp/AdminHome.jsp").forward(request, response);
		}else {
			response.sendRedirect("AccessDeniedServlet");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String value = request.getParameter("role_id").trim();
			String role_id = value.substring(0, 1);
			String user_id = value.substring(2).trim();
			int iduser = Integer.parseInt(user_id);
			int roleid = Integer.parseInt(role_id);
		if (callSetUserRoleID(iduser, roleid)) {
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
					"You successfully changed the user's role.\r\n" +
					"\t\t</div>\r\n" +
					"</body>\r\n" +
					"</html>";
request.setAttribute("message", message);
doGet(request, response);
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
								"An error occurred, please try again.\r\n" +
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
	
	public static boolean callSetUserRoleID(int user_id, int role_id) {
		UserDao uDao = new UserDao();
		
		if (uDao.userRoleChanges(user_id, role_id)) {
			return true;
		}
		
		return false;
	}

}
