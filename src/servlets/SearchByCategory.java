package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.ben.bu_club_central.daos.EventsDao;

/**
 * Servlet implementation class SearchByCategory
 */
@WebServlet("/SearchByCategory")
public class SearchByCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static HttpSession session;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchByCategory() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/byCategory.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
session = request.getSession();
		
		EventsDao eventDao = new EventsDao();		
		String category = request.getParameter("category");
		session.setAttribute("category",category );
		System.out.println("it gets to the category post the category is "+category);
		doGet(request, response);
	}

}
