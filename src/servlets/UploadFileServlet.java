package servlets;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import edu.ben.bu_club_central.daos.DocumentForAdminDao;
import edu.ben.bu_club_central.models.User;

/**
 * Servlet implementation class UploadFileServlet
 */
@WebServlet("/UploadFileServlet")
@MultipartConfig(maxFileSize = 16177215)
public class UploadFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadFileServlet() {
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
		InputStream inputStream = null;
		String fileName = request.getParameter("name");
		int user_id_num = ((User) request.getSession().getAttribute("user")).getUser_id();
		Part filePart = request.getPart("document");

        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
             
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }
		
        if (callAddDocument(fileName, user_id_num, inputStream, true)) {
			response.sendRedirect("BoardMemberDashBoard");
        } else {
			response.sendRedirect("BoardMemberDashBoard");
        }
	}
	
	public boolean callAddDocument(String name, int user_id, InputStream inputStream, boolean active) throws IOException {

		DocumentForAdminDao dfaDao = new DocumentForAdminDao();
		if (dfaDao.addDocument(name, user_id, inputStream, active)) {
			return true;
		}
		return false;
	}

}
