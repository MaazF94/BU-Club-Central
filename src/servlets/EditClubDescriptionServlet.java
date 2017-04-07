package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.ben.bu_club_central.daos.ClubDao;
import edu.ben.bu_club_central.models.Club;
import edu.ben.bu_club_central.models.User;

/**
 * Servlet implementation class EditClubDescriptionServlet
 */
@WebServlet("/EditClubDescriptionServlet")
public class EditClubDescriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditClubDescriptionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.getRequestDispatcher("/WEB-INF/jsp/BoardMemberDashboard.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			ClubDao cDao = new ClubDao();
			Club clubObject = cDao.getClubById(((User) request.getSession().getAttribute("user")).getClub_id_num());
			int club_id_num = clubObject.getClub_id_num();
			
			
		if (callEditClubDescription(request.getParameter("editDescription"), club_id_num)) {
			String message = 	"<!DOCTYPE html>\r\n" + 
					"<html>\r\n" +
					"<head>\r\n" +
					"<title>Mileage</title>\r\n" +
					"<style> \r\n" +
					".isa_success {\r\n" +
					"color: #4F8A10;\r\n" +
					"background-color: #DFF2BF;\r\n" +
					"}\r\n" +
					"</style>\r\n" +
					"</head>\r\n<body>\r\n" +
					"<div class=isa_success>\r\n" +
					"<i class=fa fa-check></i>\r\n" +
					"You successfully changed your club's description.\r\n" +
					"\t\t</div>\r\n" +
					"</body>\r\n" +
					"</html>";
request.setAttribute("message", message);
response.sendRedirect("BoardMemberDashBoard");
		} else {
			throw new Exception();
		}
		} catch (Exception e) {
			String message = 	"<!DOCTYPE html>\r\n" + 
								"<html>\r\n" +
								"<head>\r\n" +
								"<title>Mileage</title>\r\n" +
								"<style> \r\n" +
								".isa_error {\r\n" +
								"color: #D8000C;\r\n" +
								"background-color: #FFBABA;\r\n" +
								"}\r\n" +
								"</style>\r\n" +
								"</head>\r\n<body>\r\n" +
								"<div class=isa_error>\r\n" +
								"<i class=fa fa-times-circle></i>\r\n" +
								"An error occurred with trying to change the description.\r\n" +
								"\t\t</div>\r\n" +
								"</body>\r\n" +
								"</html>";
					request.setAttribute("message", message);
					response.sendRedirect("BoardMemberDashBoard");		}
	}
	
	public static boolean callEditClubDescription(String club_description, int club_id_num) {
		ClubDao cDao = new ClubDao();
		if (cDao.editClubDescription(club_description, club_id_num)) {		
			return true;
		}
		
		return false;
	}

}
