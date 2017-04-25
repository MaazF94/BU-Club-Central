package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ben.bu_club_central.daos.PostCommentDao;
import edu.ben.bu_club_central.models.User;

/**
 * Servlet implementation class PostCommentServlet
 */
@WebServlet("/PostCommentServlet")
public class PostCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		int postID = Integer.parseInt(request.getParameter("postIdForComment").substring(0, request.getParameter("postIdForComment").indexOf(" ")));
		String club_id = request.getParameter("postIdForComment").substring(request.getParameter("postIdForComment").indexOf(" "), request.getParameter("postIdForComment").length()).trim();
		int club_id_num = Integer.parseInt(club_id);
		commentOnPost(postID, ((User) request.getSession().getAttribute("user")).getId_num(), request.getParameter("comment"));
		response.sendRedirect("ClubHomepage?club_id_num=" + club_id_num);
	}
	
	
	private void commentOnPost(int postId, int user_id, String comment) {
		PostCommentDao pDao = new PostCommentDao();
		pDao.addPostComment(postId, user_id, comment);
	}
}
