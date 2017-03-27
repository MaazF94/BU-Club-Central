package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ben.bu_club_central.daos.CommentDao;

/**
 * Servlet implementation class AdminDeleteCommentServlet
 */
@WebServlet("/AdminDeleteCommentServlet")
public class AdminDeleteCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDeleteCommentServlet() {
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
		deleteComment(Integer.parseInt(request.getParameter("deleteCommentId")));
		response.sendRedirect("AdminHome");
	}
	
	private void deleteComment(int commentId) {
		CommentDao cDao = new CommentDao();
		cDao.deleteComment(commentId);
	}
	

}
