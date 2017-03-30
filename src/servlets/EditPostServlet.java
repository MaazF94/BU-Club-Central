package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ben.bu_club_central.daos.PostDao;
import edu.ben.bu_club_central.models.Post;

/**
 * Servlet implementation class EditPostServlet
 */
@WebServlet("/user/EditPostServlet")
public class EditPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/EditPost.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		editPost(Integer.parseInt(request.getParameter("postid")), request.getParameter("postTitle"), request.getParameter("postContents"));
		response.sendRedirect("BoardMemberDashBoard");

	}
	
	
	private void editPost(int idpost, String title, String contents) {
		PostDao pDao = new PostDao();
		pDao.editPost(idpost, title, contents);
		
	}

}
