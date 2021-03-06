package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ben.bu_club_central.daos.UserDao;

/**
 * Servlet implementation class AdminEnableUserServlet
 */
@WebServlet("/AdminEnableUserServlet")
public class AdminEnableUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminEnableUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("AccessDeniedServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		enabledUser(Integer.parseInt(request.getParameter("enableUserId")));
		response.sendRedirect("AdminHome");
	
	}
	
	/**
	 * calls the enable user method in the dao
	 * @param userIdNum
	 */
	private void enabledUser(int userIdNum) {
		UserDao uDao = new UserDao();
		uDao.enableUser(userIdNum);
		
	}
	

}
