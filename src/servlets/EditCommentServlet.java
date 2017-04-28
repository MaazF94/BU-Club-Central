package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ben.bu_club_central.daos.CommentDao;
import edu.ben.bu_club_central.daos.EventsDao;
import edu.ben.bu_club_central.models.Comment;
import edu.ben.bu_club_central.models.Events;

/**
 * Servlet implementation class EditCommentServlet
 */
@WebServlet("/user/EditCommentServlet")
public class EditCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCommentServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CommentDao cDao = new CommentDao();
      	Comment comment;
      	comment = cDao.getCommentByCommentId(Integer.parseInt(request.getParameter("editCommentId")));
      	EventsDao eDao = new EventsDao();
      	Events event = eDao.getEventByEventId(comment.getEventId());
      	
      	request.setAttribute("comment", comment);
      	request.setAttribute("event", event);
		
		
		request.getRequestDispatcher("/WEB-INF/jsp/EditComment.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		editComment(Integer.parseInt(request.getParameter("commentid")), request.getParameter("comment"));
		response.sendRedirect("BoardMemberDashBoard");
	}

	/**
	 * call edit comment method in dao
	 * @param commentID Integer
	 * @param comment String
	 */
	private void editComment(int commentID, String comment) {
		CommentDao cDao = new CommentDao();
		cDao.editComment(commentID, comment);
	}
	
	
	
	
	
	
}
