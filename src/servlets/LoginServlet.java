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
	public static HttpSession session;
	private UserDao uDao = new UserDao();
       
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
		request.getRequestDispatcher("/WEB-INF/jsp/Login.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user;
		
		session = request.getSession(true);
		if(loginUser(request.getParameter("username"), request.getParameter("password"))) {
			user = uDao.getUserObject();
			System.out.println(user.getFirst_name());
			session.setAttribute("first_name", user.getFirst_name());
			session.setAttribute("last_name", user.getLast_name());
			session.setAttribute("username", user.getUsername());
			session.setAttribute("id_num", user.getId_num());
			session.setAttribute("email", user.getEmail());
			session.setAttribute("role_id", user.getRole_id());
			session.setAttribute("club_id_num", user.getClub_id_num());
			System.out.println(user.getFirst_name());
			System.out.println("logged in");
			response.sendRedirect("HomeServlet");
			
		}else {
			
			response.sendRedirect("errorLogin");
		}
		
		//Need to add if checks for where to long into when there are different roles. ie: user, admin, president
		
	}
	
	
	private boolean loginUser(String username, String password) {
		uDao = new UserDao();
		return uDao.userLogin(username, password);
	}
	
	

}
