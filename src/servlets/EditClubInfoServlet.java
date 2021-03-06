package servlets;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import edu.ben.bu_club_central.daos.ClubDao;
import edu.ben.bu_club_central.models.Club;
import edu.ben.bu_club_central.models.User;

/**
 * Servlet implementation class EditClubInfoServlet
 */
@WebServlet("/EditClubInfoServlet")
public class EditClubInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditClubInfoServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/BoardMemberDashboard.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			boolean result = false;
			ClubDao cDao = new ClubDao();
			Club clubObject = cDao.getClubById(((User) request.getSession().getAttribute("user")).getClub_id_num());
			int club_id_num = clubObject.getClub_id_num();
			String message = "";
			
			if (request.getParameter("editMeetingTime") != null) {
				if (callEditMeetingTime(request.getParameter("editMeetingTime"), club_id_num)) {
					result = true;
				} else {
					result = false;
				}
			}

			if (request.getParameter("editMeetingLoc") != null) {
				if (callEditMeetingLoc(request.getParameter("editMeetingLoc"), club_id_num)) {
					result = true;
				} else {
					result = false;
				}
			}

			if (request.getParameter("editMeetingFreq") != null) {
				if (callEditMeetingFreq(request.getParameter("editMeetingFreq"), club_id_num)) {
					result = true;
				} else {
					result = false;
				}
			}

			if (request.getParameter("broadcast") != null) {
				if (callEditBroadcast(request.getParameter("broadcast"), club_id_num)) {
					result = true;
				} else {
					result = false;
				}
			}

			if (request.getParameter("editDescription") != null) {
				if (callEditClubDescription(request.getParameter("editDescription"), club_id_num)) {
					result = true;
				} else {
					result = false;
				}
			}
			if (result == true) {
				message = "<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" + "<title>Mileage</title>\r\n"
						+ "<style> \r\n" + ".isa_success {\r\n" + "color: #4F8A10;\r\n"
						+ "background-color: #DFF2BF;\r\n" + "}\r\n" + "</style>\r\n" + "</head>\r\n<body>\r\n"
						+ "<div class=isa_success>\r\n" + "<i class=fa fa-check></i>\r\n"
						+ "You successfully changed your club's information.\r\n" + "\t\t</div>\r\n" + "</body>\r\n"
						+ "</html>";
				request.setAttribute("message", message);
				response.sendRedirect("BoardMemberDashBoard");
			} else {
				message = "<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" + "<title>Mileage</title>\r\n"
						+ "<style> \r\n" + ".isa_error {\r\n" + "color: #D8000C;\r\n" + "background-color: #FFBABA;\r\n"
						+ "}\r\n" + "</style>\r\n" + "</head>\r\n<body>\r\n" + "<div class=isa_error>\r\n"
						+ "<i class=fa fa-times-circle></i>\r\n"
						+ "An error occurred with trying to edit some of your club info.\r\n" + "\t\t</div>\r\n" + "</body>\r\n"
						+ "</html>";
				request.setAttribute("message", message);
				response.sendRedirect("BoardMemberDashBoard");
			}

		} catch (Exception e) {
			String message = "<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" + "<title>Mileage</title>\r\n"
					+ "<style> \r\n" + ".isa_error {\r\n" + "color: #D8000C;\r\n" + "background-color: #FFBABA;\r\n"
					+ "}\r\n" + "</style>\r\n" + "</head>\r\n<body>\r\n" + "<div class=isa_error>\r\n"
					+ "<i class=fa fa-times-circle></i>\r\n"
					+ "An error occurred with trying to edit your club info.\r\n" + "\t\t</div>\r\n" + "</body>\r\n"
					+ "</html>";
			request.setAttribute("message", message);
			response.sendRedirect("BoardMemberDashBoard");
		}
	}

	/**
	 * 
	 * @param meeting_time String
	 * @param club_id_num Integer
	 * @return true or false
	 */
	public static boolean callEditMeetingTime(String meeting_time, int club_id_num) {
		ClubDao cDao = new ClubDao();
		if (cDao.editClubMeetingTime(meeting_time, club_id_num)) {
			return true;
		}

		return false;
	}

	/**
	 * 
	 * @param meeting_loc String
	 * @param club_id_num Integer
	 * @return true or false
	 */
	public static boolean callEditMeetingLoc(String meeting_loc, int club_id_num) {
		ClubDao cDao = new ClubDao();
		if (cDao.editClubMeetingLoc(meeting_loc, club_id_num)) {
			return true;
		}

		return false;
	}
	
	/**
	 * 
	 * @param meeting_freq String
	 * @param club_id_num Integer
	 * @return true or false
	 */
	public static boolean callEditMeetingFreq(String meeting_freq, int club_id_num) {
		ClubDao cDao = new ClubDao();
		if (cDao.editClubMeetingFreq(meeting_freq, club_id_num)) {
			return true;
		}

		return false;
	}

	/**
	 * 
	 * @param broadcast String
	 * @param club_id_num Integer
	 * @return true or false
	 */
	public static boolean callEditBroadcast(String broadcast, int club_id_num) {
		ClubDao cDao = new ClubDao();
		if (cDao.editClubBroadcast(broadcast, club_id_num)) {
			return true;
		}

		return false;
	}

	/**
	 * 
	 * @param club_description String
	 * @param club_id_num Integer
	 * @return true or false
	 */
	public static boolean callEditClubDescription(String club_description, int club_id_num) {
		ClubDao cDao = new ClubDao();
		if (cDao.editClubDescription(club_description, club_id_num)) {
			return true;
		}

		return false;
	}

}
