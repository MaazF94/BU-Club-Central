package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.ben.bu_club_central.daos.UserDao;
import edu.ben.bu_club_central.models.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	public static HttpSession session;
	private UserDao uDao = new UserDao();
	HttpSession session; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		request.getRequestDispatcher("/WEB-INF/jsp/Login.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user;
		
		if(!request.getParameter("username").equals(null) || !request.getParameter("password").equals(null)) {
			if(!loginUser(request.getParameter("username")).equals(null)) {
				user = uDao.getUserByUsername(request.getParameter("username"));
				request.getSession().setAttribute("user", user);
//				request.getSession().setAttribute("signIn", user.getFirst_name());
		        request.getRequestDispatcher("HomeServlet").forward(request, response);
			}else {
				response.sendRedirect("LoginServlet");
			}
		}else {
			response.sendRedirect("LoginServlet");
		}
		
		//Need to add if checks for where to long into when there are different roles. ie: user, admin, president

	}
	
	
	private User loginUser(String username) {
		uDao = new UserDao();
		return uDao.getUserByUsername(username);
	}
	
	

}
