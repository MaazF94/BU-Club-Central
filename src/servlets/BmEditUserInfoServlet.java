package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ben.bu_club_central.daos.UserDao;

/**
 * Servlet implementation class BmEditUserInfoServlet
 */
@WebServlet("/BmEditUserInfoServlet")
public class BmEditUserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BmEditUserInfoServlet() {
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
		UserDao uDao = new UserDao();
		
		if(uDao.checkEmail(request.getParameter("newEmail"))) {
			if(!uDao.checkId_num(request.getParameter("id_num"))) {
				if(editUserInfo(request.getParameter("oldEmail"), request.getParameter("newEmail"), request.getParameter("id_num"))) {
					response.sendRedirect("BoardMemberDashBoard");
				}else {
					response.sendRedirect("BoardMemberDashBoard");
				}
			}else {
				response.sendRedirect("BoardMemberDashBoard");
			}
			
		}else {
			response.sendRedirect("BoardMemberDashBoard");
		}
		
		
	}

	/**
	 * This method edits users email
	 * @param oldEmail for user String
	 * @param newEmail for user String
	 * @param id_num for user String
	 * @return true if email is changed or false if not
	 */
	public boolean editUserInfo(String oldEmail, String newEmail, String id_num) {
		UserDao uDao = new UserDao();
		if(uDao.editUserEmail(oldEmail, newEmail, id_num)) {
			return true;
		}else {
			return false;
		}
		
	}
	
	
}
