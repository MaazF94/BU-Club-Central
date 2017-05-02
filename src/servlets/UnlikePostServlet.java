package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ben.bu_club_central.daos.PostDao;
import edu.ben.bu_club_central.daos.PostLikesDao;
import edu.ben.bu_club_central.models.User;

/**
 * Servlet implementation class UnlikePostServlet
 */
@WebServlet("/UnlikePostServlet")
public class UnlikePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UnlikePostServlet() {
        super();
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
		int postID = Integer.parseInt(request.getParameter("postId").substring(0, request.getParameter("postId").indexOf(" ")));
		String club_id = request.getParameter("postId").substring(request.getParameter("postId").indexOf(" "), request.getParameter("postId").length()).trim();
		int club_id_num = Integer.parseInt(club_id);
		unlikePost(postID, ((User)request.getSession().getAttribute("user")).getId_num());
		response.sendRedirect("ClubHomepage?club_id_num=123");
	}
	
	private void unlikePost(int post_id, int user_id_num) {
		PostLikesDao pLikesDao = new PostLikesDao();
		pLikesDao.unLikePost(post_id, user_id_num);
		
		PostDao pDao = new PostDao();
		pDao.decreaseLikeCount(post_id);
	}
	
	

}
