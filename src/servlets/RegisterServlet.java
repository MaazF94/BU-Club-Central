package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ben.bu_club_central.daos.UserDao;
import jbcrypt.BCrypt;
import mailDispatcher.SendMail;
//import org.mindrot.jbcrypt.BCrypt;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/Register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{		
		if (userErrorChecking(request.getParameter("first_name"), request.getParameter("last_name"),
				request.getParameter("username"), request.getParameter("passwrd"),
				request.getParameter("repeat-passwrd"), request.getParameter("id_num"), request.getParameter("email"),
				request, response)) {
			callRegisterUser(request.getParameter("first_name"), request.getParameter("last_name"),
					request.getParameter("username"), request.getParameter("passwrd"),
					Integer.parseInt(request.getParameter("id_num")), request.getParameter("email"));
			
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
					"You successfully registered. Please login below.\r\n" +
					"\t\t</div>\r\n" +
					"</body>\r\n" +
					"</html>";
request.setAttribute("message", message);
response.sendRedirect("LoginServlet");

		} else {
			System.out.println("user error checking failed");
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
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/WEB-INF/jsp/Register.jsp");
		dispatcher.forward(request, response);		}

	}

	/**
	 * 
	 * @param first_name String 
	 * @param last_name String
	 * @param username String
	 * @param passwrd String
	 * @param id_num Integer
	 * @param email String
	 */
	public static void callRegisterUser(String first_name, String last_name, String username, String passwrd,
			int id_num, String email) {
		UserDao uDao = new UserDao();
		
		String hashedPw = BCrypt.hashpw(passwrd, BCrypt.gensalt());

		if (uDao.registerUser(first_name, last_name, username, hashedPw, id_num, email)) {
		
		// send email to a newly registered user after they've been put into database
		String subject = "Thank You for Registering " + first_name + "!";
		String content = "<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"  <head>\r\n" + 
				"    <meta name=\"viewport\" content=\"width=device-width\">\r\n" + 
				"    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n" + 
				"    <title>Simple Transactional Email</title>\r\n" + 
				"    <style type=\"text/css\">\r\n" + 
				"            @media only screen and (max-width: 620px) {\r\n" + 
				"              table[class=body] h1 {\r\n" + 
				"                font-size: 28px !important;\r\n" + 
				"                margin-bottom: 10px !important; }\r\n" + 
				"              table[class=body] p,\r\n" + 
				"              table[class=body] ul,\r\n" + 
				"              table[class=body] ol,\r\n" + 
				"              table[class=body] td,\r\n" + 
				"              table[class=body] span,\r\n" + 
				"              table[class=body] a {\r\n" + 
				"                font-size: 16px !important; }\r\n" + 
				"              table[class=body] .wrapper,\r\n" + 
				"              table[class=body] .article {\r\n" + 
				"                padding: 10px !important; }\r\n" + 
				"              table[class=body] .content {\r\n" + 
				"                padding: 0 !important; }\r\n" + 
				"              table[class=body] .container {\r\n" + 
				"                padding: 0 !important;\r\n" + 
				"                width: 100% !important; }\r\n" + 
				"              table[class=body] .main {\r\n" + 
				"                border-left-width: 0 !important;\r\n" + 
				"                border-radius: 0 !important;\r\n" + 
				"                border-right-width: 0 !important; }\r\n" + 
				"              table[class=body] .btn table {\r\n" + 
				"                width: 100% !important; }\r\n" + 
				"              table[class=body] .btn a {\r\n" + 
				"                width: 100% !important; }\r\n" + 
				"              table[class=body] .img-responsive {\r\n" + 
				"                height: auto !important;\r\n" + 
				"                max-width: 100% !important;\r\n" + 
				"                width: auto !important; }}\r\n" + 
				"            /* -------------------------------------\r\n" + 
				"                PRESERVE THESE STYLES IN THE HEAD\r\n" + 
				"            ------------------------------------- */\r\n" + 
				"            @media all {\r\n" + 
				"              .ExternalClass {\r\n" + 
				"                width: 100%; }\r\n" + 
				"              .ExternalClass,\r\n" + 
				"              .ExternalClass p,\r\n" + 
				"              .ExternalClass span,\r\n" + 
				"              .ExternalClass font,\r\n" + 
				"              .ExternalClass td,\r\n" + 
				"              .ExternalClass div {\r\n" + 
				"                line-height: 100%; }\r\n" + 
				"              .apple-link a {\r\n" + 
				"                color: inherit !important;\r\n" + 
				"                font-family: inherit !important;\r\n" + 
				"                font-size: inherit !important;\r\n" + 
				"                font-weight: inherit !important;\r\n" + 
				"                line-height: inherit !important;\r\n" + 
				"                text-decoration: none !important; }\r\n" + 
				"              .btn-primary table td:hover {\r\n" + 
				"                background-color: #34495e !important; }\r\n" + 
				"              .btn-primary a:hover {\r\n" + 
				"                background-color: #9b0b01 !important;\r\n" + 
				"                border-color: #34495e !important; } }\r\n" + 
				"    </style>\r\n" + 
				"  </head>\r\n" + 
				"  <body class=\"\" style=\"background-color:#f6f6f6;font-family:sans-serif;-webkit-font-smoothing:antialiased;font-size:14px;line-height:1.4;margin:0;padding:0;-ms-text-size-adjust:100%;-webkit-text-size-adjust:100%;\">\r\n" + 
				"    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"body\" style=\"border-collapse:separate;mso-table-lspace:0pt;mso-table-rspace:0pt;background-color:#000000;width:100%;\">\r\n" + 
				"      <tr>\r\n" + 
				"        <td style=\"font-family:sans-serif;font-size:14px;vertical-align:top;\">&nbsp;</td>\r\n" + 
				"        <td class=\"container\" style=\"font-family:sans-serif;font-size:14px;vertical-align:top;display:block;max-width:580px;padding:10px;width:580px;Margin:0 auto !important;\">\r\n" + 
				"          <div class=\"content\" style=\"box-sizing:border-box;display:block;Margin:0 auto;max-width:580px;padding:10px;\">\r\n" + 
				"            <!-- START CENTERED WHITE CONTAINER -->\r\n" + 
				"            <span class=\"preheader\" style=\"color:transparent;display:none;height:0;max-height:0;max-width:0;opacity:0;overflow:hidden;mso-hide:all;visibility:hidden;width:0;\">Hello, " + first_name + ". This is your welcome message to Club Central. The best place to stay up to date with your clubs.</span>\r\n" + 
				"            <table class=\"main\" style=\"border-collapse:separate;mso-table-lspace:0pt;mso-table-rspace:0pt;background:#fff;border-radius:3px;width:100%;\">\r\n" + 
				"              <!-- START MAIN CONTENT AREA -->\r\n" + 
				"              <tr>\r\n" + 
				"                <td class=\"wrapper\" style=\"font-family:sans-serif;font-size:14px;vertical-align:top;box-sizing:border-box;padding:20px;\">\r\n" + 
				"                  <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:separate;mso-table-lspace:0pt;mso-table-rspace:0pt;width:100%;\">\r\n" + 
				"                    <tr>\r\n" + 
				"                      <td style=\"font-family:sans-serif;font-size:14px;vertical-align:top;\">\r\n" + 
				"                        <p style=\"font-family:sans-serif;font-size:14px;font-weight:normal;margin:0;Margin-bottom:15px;\">Hi " + username +",</p>\r\n" + 
				"						 <p align = 'center'> <img src = \"http://i.imgur.com/bSjfwaY.jpg?2\" width = '50%'> </p>\r\n" +		
				"                        <p style=\"font-family:sans-serif;font-size:14px;font-weight:normal;margin:0;Margin-bottom:15px;\">Welcome to Club Central! We're glad you decided to to join us! There are a bunch of things you can do here including, RSVPing for an event, joiing a club, making a club and much, much more!</p>\r\n" + 
				"                        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"btn btn-primary\" style=\"border-collapse:separate;mso-table-lspace:0pt;mso-table-rspace:0pt;box-sizing:border-box;width:100%;\">\r\n" + 
				"                          <tbody>\r\n" + 
				"                            <tr>\r\n" + 
				"                              <td align=\"left\" style=\"font-family:sans-serif;font-size:14px;vertical-align:top;padding-bottom:15px;\">\r\n" + 
				"                                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:separate;mso-table-lspace:0pt;mso-table-rspace:0pt;width:100%;width:auto;\">\r\n" + 
				"                                  <tbody>\r\n" + 
				"                                    <tr>\r\n" + 
				"                                      <td style=\"font-family:sans-serif;font-size:14px;vertical-align:top;background-color:#ffffff;border-radius:5px;text-align:center;background-color:#3498db;\"> <a href=\"http://cs.ben.edu/bu_club_central\" target=\"_blank\" style=\"text-decoration:underline;background-color:#ffffff;border:solid 1px #3498db;border-radius:5px;box-sizing:border-box;color:#3498db;cursor:pointer;display:inline-block;font-size:14px;font-weight:bold;margin:0;padding:12px 25px;text-decoration:none;text-transform:capitalize;background-color:#c61003;border-color:#3498db;color:#ffffff;\">Benedictine</a> </td>\r\n" + 
				"                                    </tr>\r\n" + 
				"                                  </tbody>\r\n" + 
				"                                </table>\r\n" + 
				"                              </td>\r\n" + 
				"                            </tr>\r\n" + 
				"                          </tbody>\r\n" + 
				"                        </table>\r\n" + 
				"                        <p style=\"font-family:sans-serif;font-size:14px;font-weight:normal;margin:0;Margin-bottom:15px;\">Go ahead and click the button to go back to the benedictine website.</p>\r\n" + 
				"                        <p style=\"font-family:sans-serif;font-size:14px;font-weight:normal;margin:0;Margin-bottom:15px;\">We hope you have fun during your time here!</p>\r\n" + 
				"                      </td>\r\n" + 
				"                    </tr>\r\n" + 
				"                  </table>\r\n" + 
				"                </td>\r\n" + 
				"              </tr>\r\n" + 
				"              <!-- END MAIN CONTENT AREA -->\r\n" + 
				"            </table>\r\n" + 
				"            <!-- START FOOTER -->\r\n" + 
				"            <div class=\"footer\" style=\"clear:both;padding-top:10px;text-align:center;width:100%;\">\r\n" + 
				"              <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:separate;mso-table-lspace:0pt;mso-table-rspace:0pt;width:100%;\">\r\n" + 
				"                <tr>\r\n" + 
				"                  <td class=\"content-block\" style=\"font-family:sans-serif;font-size:14px;vertical-align:top;color:#999999;font-size:12px;text-align:center;\">\r\n" + 
				"                    <span class=\"apple-link\" style=\"color:#999999;font-size:12px;text-align:center;\">The F.I.R.M</span>\r\n" + 
				"                    <br>\r\n" + 
				"						\r\n" + 
				"							This message was sent from Benedictine University Club Central. Please do not reply to this message.\r\n" + 
				"\r\n" + 						
				"                     Don't like these emails? <a href=\"http://ww.ben.edu\" style=\"color:#3498db;text-decoration:underline;color:#999999;font-size:12px;text-align:center;\">Unsubscribe</a>.\r\n" + 
				"                  </td>\r\n" + 
				"                  <td style=\"font-family:sans-serif;font-size:14px;vertical-align:top;color:#999999;font-size:12px;text-align:center;\">\r\n" + 
				"                    <img src=\"http://i.imgur.com/tklPxvC.png\" style=\"border:none;-ms-interpolation-mode:bicubic;max-width:100%;\">\r\n" + 
				"                  </td>\r\n" + 
				"                </tr>\r\n" + 
				"              </table>\r\n" + 
				"            </div>\r\n" + 
				"            <!-- END FOOTER -->\r\n" + 
				"            <!-- END CENTERED WHITE CONTAINER -->\r\n" + 
				"          </div>\r\n" + 
				"        </td>\r\n" + 
				"        <td style=\"font-family:sans-serif;font-size:14px;vertical-align:top;\">&nbsp;</td>\r\n" + 
				"      </tr>\r\n" + 
				"    </table>\r\n" + 
				"  </body>\r\n" + 
				"</html>";
		SendMail.email("BUclubcentral@gmail.com", "BUclubcentral@gmail.com" , "thefirm123", email, subject, content);
		}
		
	}

	/**
	 * 
	 * @param first_name String
	 * @param last_name String
	 * @param username String
	 * @param passwrd String
	 * @param passwrd2 Sting
	 * @param id_num String
	 * @param email String
	 * @param request httpservletrequest
	 * @param response httpservletrequest
	 * @return true or false
	 */
	private static boolean userErrorChecking(String first_name, String last_name, String username, String passwrd,
			String passwrd2, String id_num, String email, HttpServletRequest request, HttpServletResponse response) {
		UserDao uDao = new UserDao();
		
		if (uDao.checkName(first_name, last_name)) {
			if (uDao.checkUsernameChars(username)) {
				if (!uDao.checkUsernameExist(username)) {
					if (uDao.checkPasswordMatch(passwrd, passwrd2)) {
						if (uDao.checkId_num(id_num)) {
							if (uDao.checkEmail(email)) {
								return true;
							} else {
								request.setAttribute("message", "Email is not in the correct format");
								System.out.println("email failed");
								return false;
							}
						} else {
							request.setAttribute("message", "ID number must only contain numbers");
							System.out.println("id num failed");
							return false;
						}
					} else {
						request.setAttribute("message", "Passwords do not match");
						System.out.println("passwords failed");
						return false;
					}
				} else {
					request.setAttribute("message", "Username already exists");
					System.out.println("username failed");
					return false;
				}
			} else {
				request.setAttribute("message", "Username must only have letters and numbers");
				System.out.println("username 2 failed");
				return false;
			}
		} else {
			request.setAttribute("message", "First or Last name is incorrect");
			System.out.println("first/last name failed");
			return false;
		}
	}

}