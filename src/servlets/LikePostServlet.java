package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ben.bu_club_central.daos.PostDao;

/**
 * Servlet implementation class LikePostServlet
 */
@WebServlet("/LikePostServlet")
public class LikePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LikePostServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int postID = Integer.parseInt(request.getParameter("postId").substring(0, request.getParameter("postId").indexOf(" ")));
		String club_id = request.getParameter("postId").substring(request.getParameter("postId").indexOf(" "), request.getParameter("postId").length()).trim();
		int club_id_num = Integer.parseInt(club_id);
		likePost(postID);
		response.sendRedirect("ClubHomepage?club_id_num=" + club_id_num);
	}

	/**
	 * 
	 * @param postId Integer
	 */
	private void likePost(int postId) {
		PostDao pDao = new PostDao();
		pDao.likePost(postId);
	}
	
	
	
}
