package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ben.bu_club_central.daos.UserDao;
import mailDispatcher.SendMail;

/**
 * Servlet implementation class ContactUsServlet
 */
@WebServlet("/ContactUsServlet")
public class ContactUsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactUsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/jsp/ContactUs.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao uDao = new UserDao();
		
		try {
			if (!checkName(request.getParameter("name")) || !uDao.checkEmail(request.getParameter("email")) || !checkMessage(request.getParameter("message"))) {
				throw new Exception();
			} else { callContactUsForEmail(request.getParameter("name"), request.getParameter("email"), request.getParameter("message"));
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
					"We will get back to you shortly. Thanks for your message!\r\n" +
					"\t\t</div>\r\n" +
					"</body>\r\n" +
					"</html>";
request.setAttribute("message", message);
request.getRequestDispatcher("/WEB-INF/jsp/ContactUs.jsp").forward(request, response);
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
					"You entered some information incorrectly, please try again.\r\n" +
					"\t\t</div>\r\n" +
					"</body>\r\n" +
					"</html>";
		request.setAttribute("message", message);
		request.getRequestDispatcher("/WEB-INF/jsp/ContactUs.jsp").forward(request, response);
		}

	}
	
	public static boolean checkMessage(String message) {
		if (message.equals(null)) {
			return false;
		}
		
		if (message.equals("")) {
			return false;
		}
		
		return true;
	}
	
	public static boolean checkName(String fullName) {
		char fullNameArray[] = fullName.toCharArray();

		if (fullName.equals(null)) {
			return false;
		}
		
		if (fullName.equals("")) {
			return false;
		}
		
		for (int i = 0; i < fullNameArray.length; i++) {
			if (!Character.isLetter(fullNameArray[i])) {
				if (Character.isSpace(fullNameArray[i])) {
					//do nothing
				}else {
					return false;
				}
			}
		}
		return true;
	}

	public static void callContactUsForEmail(String fullName, String email, String message) {
		String subject = "Question for BU Club Central by " + fullName + "!";
		String content = message;
		SendMail.email(email, "BUclubcentral@gmail.com" , "thefirm123", "BUclubcentral@gmail.com", subject, content);
		System.out.println("Sent email");
	}
}
