package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ben.bu_club_central.daos.PostDao;
import edu.ben.bu_club_central.daos.UserDao;
import edu.ben.bu_club_central.models.Post;
import edu.ben.bu_club_central.models.User;

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
			PostDao pDao = new PostDao();
			Post post = pDao.getPostByPostId(Integer.parseInt(request.getParameter("editPostId")));
			UserDao uDao = new UserDao();
			User user = uDao.getUserByIdNum(post.getUser_id_num());
			
			request.setAttribute("post", post);
			request.setAttribute("user", user);
		
		
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
