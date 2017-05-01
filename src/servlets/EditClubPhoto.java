package servlets;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import edu.ben.bu_club_central.daos.ClubDao;
import edu.ben.bu_club_central.models.Club;
import edu.ben.bu_club_central.models.User;

/**
 * Servlet implementation class EditClubPhoto
 */
@WebServlet("/EditClubPhoto")
@MultipartConfig(maxFileSize = 16177216)
public class EditClubPhoto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditClubPhoto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		InputStream is = null;
		ClubDao cd = new ClubDao();
		Club clubObject = cd.getClubById(((User) request.getSession().getAttribute("user")).getClub_id_num());
		Part filePart = request.getPart("clubPhoto");
		long size = 0;

		if (filePart != null) {
			size = filePart.getSize();
			is = filePart.getInputStream();
		}else{
			System.out.println("file part is null");
		}
		
		if (uploadPhoto(clubObject.getClub_id_num(), is, size)) {
			System.out.println("send to bmdashboard");
			response.sendRedirect("BoardMemberDashBoard");
		}else{
			System.out.println("error uploading.");
			response.sendRedirect("ErrorCatchAllServelt");
		}
	}

	private boolean uploadPhoto(int club_id_num, InputStream is, long size) {
		// TODO Auto-generated method stub
		ClubDao cd = new ClubDao();
		if (cd.addImage(club_id_num, is, size)) {
			return true;
		} else {
			return false;
		}
	}

}
