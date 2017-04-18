package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ben.bu_club_central.daos.ClubMembershipDao;
import edu.ben.bu_club_central.daos.UserDao;
import edu.ben.bu_club_central.models.ClubMembership;
import edu.ben.bu_club_central.models.User;


/**
 * Servlet implementation class AdminChangeRoleIDServlet
 */
@WebServlet("/AdminChangeRoleID")
public class AdminChangeRoleIDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminChangeRoleIDServlet() {
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
			String[] userRoleList = new String[100];
			userRoleList = request.getParameterValues("role_id");
			
		if (callSetUserRoleID(userRoleList)) {
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
response.sendRedirect("AdminHome");
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
					response.sendRedirect("AdminHome");
		}
	}
	
	public static boolean callSetUserRoleID(String[] userRoleList) {
		UserDao uDao = new UserDao();
		
		List<User> roleChanges = new ArrayList<User>();
		int[] userIDs = new int[100];
		int[] roleIDs = new int[100];
		int[] userIdNums = new int[100];
		int[] roleIdNums = new int[100];
		
		for (int i = 0; i < userRoleList.length; i++) {
			userRoleList[i].replace("[", "");
			userRoleList[i].replace("]", "");
			roleIDs[i] = Integer.parseInt(userRoleList[i].substring(0, 1));
			userIDs[i] = Integer.parseInt(userRoleList[i].substring(2));
		}
		
		if (uDao.userRoleChanges(roleIDs, userIDs)) {
			return true;
		}
		
		return false;
	}

}
