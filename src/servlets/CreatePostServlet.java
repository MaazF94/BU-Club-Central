package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ben.bu_club_central.daos.PostDao;
import edu.ben.bu_club_central.models.User;

/**
 * Servlet implementation class CreatePostServlet
 */
@WebServlet("/CreatePostServlet")
public class CreatePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreatePostServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		createPost(request.getParameter("postTitle"), request.getParameter("postDescription"),
				((User) request.getSession().getAttribute("user")).getClub_id_num(),
				((User) request.getSession().getAttribute("user")).getId_num());
		response.sendRedirect("BoardMemberDashBoard");

	}

	private void createPost(String title, String contents, int club_id_num, int id_num_of_user) {
		PostDao postDao = new PostDao();
		postDao.addPost(title, contents, club_id_num, id_num_of_user);

	}

}
