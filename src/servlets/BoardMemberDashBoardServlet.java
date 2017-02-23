package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ben.bu_club_central.daos.UserDao;
/**
 * Servlet implementation class BoardMemberDashBoardServlet
 */
@WebServlet("/BoardMemberDashBoard")
public class BoardMemberDashBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardMemberDashBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/BoardMemberDashBoard.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao uDao = new UserDao();
		
		if(uDao.checkNumericOnly(request.getParameter("id_num"))) {
			if(add_removeUserFromClub(request.getParameter("add_removeButton"), request.getParameter("id_num"))) {
				response.sendRedirect("BoardMemberDashBoard");
			}
		}else {
			response.sendRedirect("BoardMemberDashBoard");
		}
		
	}
	
	/**
	 * This method calls the add_remove from club method in user dao
	 * @param add_remove String parameter for add or remove: either add or remove for values
	 * @param id_num the id of the user you are adding or removing
	 * @return true if they add/remove user false otherwise
	 */
	public boolean add_removeUserFromClub(String add_remove, String id_num) {
		UserDao uDao = new UserDao();
		if(uDao.add_removeFromClub(add_remove, id_num, 1)) {
			return true;
		} else {
			return false;
		}
		
	}
	
	
	
	

}
