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
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/jsp/Register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// send email to a newly registered user
		//come back later to this and use html in your email to make it look better and expand the message some more.
		String subject = "Thank You for Registering " + request.getParameter("username") + "!";
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
				"                background-color: #34495e !important;\r\n" + 
				"                border-color: #34495e !important; } }\r\n" + 
				"    </style>\r\n" + 
				"  </head>\r\n" + 
				"  <body class=\"\" style=\"background-color:#f6f6f6;font-family:sans-serif;-webkit-font-smoothing:antialiased;font-size:14px;line-height:1.4;margin:0;padding:0;-ms-text-size-adjust:100%;-webkit-text-size-adjust:100%;\">\r\n" + 
				"    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"body\" style=\"border-collapse:separate;mso-table-lspace:0pt;mso-table-rspace:0pt;background-color:#f6f6f6;width:100%;\">\r\n" + 
				"      <tr>\r\n" + 
				"        <td style=\"font-family:sans-serif;font-size:14px;vertical-align:top;\">&nbsp;</td>\r\n" + 
				"        <td class=\"container\" style=\"font-family:sans-serif;font-size:14px;vertical-align:top;display:block;max-width:580px;padding:10px;width:580px;Margin:0 auto !important;\">\r\n" + 
				"          <div class=\"content\" style=\"box-sizing:border-box;display:block;Margin:0 auto;max-width:580px;padding:10px;\">\r\n" + 
				"            <!-- START CENTERED WHITE CONTAINER -->\r\n" + 
				"            <span class=\"preheader\" style=\"color:transparent;display:none;height:0;max-height:0;max-width:0;opacity:0;overflow:hidden;mso-hide:all;visibility:hidden;width:0;\"></span>\r\n" + 
				"            <table class=\"main\" style=\"border-collapse:separate;mso-table-lspace:0pt;mso-table-rspace:0pt;background:#fff;border-radius:3px;width:100%;\">\r\n" + 
				"              <!-- START MAIN CONTENT AREA -->\r\n" + 
				"              <tr>\r\n" + 
				"                <td class=\"wrapper\" style=\"font-family:sans-serif;font-size:14px;vertical-align:top;box-sizing:border-box;padding:20px;\">\r\n" + 
				"                  <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:separate;mso-table-lspace:0pt;mso-table-rspace:0pt;width:100%;\">\r\n" + 
				"                    <tr>\r\n" + 
				"                      <td style=\"font-family:sans-serif;font-size:14px;vertical-align:top;\">\r\n" + 
				"                        <p style=\"font-family:sans-serif;font-size:14px;font-weight:normal;margin:0;Margin-bottom:15px;\">Hi" + request.getParameter("first_name") + ",</p>\r\n" + 
				"                        <p style=\"font-family:sans-serif;font-size:14px;font-weight:normal;margin:0;Margin-bottom:15px;\">Sometimes you just want to send a simple HTML email with a simple design and clear call to action. This is it.</p>\r\n" + 
				"                        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"btn btn-primary\" style=\"border-collapse:separate;mso-table-lspace:0pt;mso-table-rspace:0pt;box-sizing:border-box;width:100%;\">\r\n" + 
				"                          <tbody>\r\n" + 
				"                            <tr>\r\n" + 
				"                              <td align=\"left\" style=\"font-family:sans-serif;font-size:14px;vertical-align:top;padding-bottom:15px;\">\r\n" + 
				"                                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:separate;mso-table-lspace:0pt;mso-table-rspace:0pt;width:100%;width:auto;\">\r\n" + 
				"                                  <tbody>\r\n" + 
				"                                    <tr>\r\n" + 
				"                                      <td style=\"font-family:sans-serif;font-size:14px;vertical-align:top;background-color:#ffffff;border-radius:5px;text-align:center;background-color:#3498db;\"> <a href=\"http://htmlemail.io\" target=\"_blank\" style=\"text-decoration:underline;background-color:#ffffff;border:solid 1px #3498db;border-radius:5px;box-sizing:border-box;color:#3498db;cursor:pointer;display:inline-block;font-size:14px;font-weight:bold;margin:0;padding:12px 25px;text-decoration:none;text-transform:capitalize;background-color:#dd1818;border-color:#3498db;color:#ffffff;\">Call To Action</a> </td>\r\n" + 
				"                                    </tr>\r\n" + 
				"                                  </tbody>\r\n" + 
				"                                </table>\r\n" + 
				"                              </td>\r\n" + 
				"                            </tr>\r\n" + 
				"                          </tbody>\r\n" + 
				"                        </table>\r\n" + 
				"                        <p style=\"font-family:sans-serif;font-size:14px;font-weight:normal;margin:0;Margin-bottom:15px;\">This is a really simple email template. Its sole purpose is to get the recipient to click the button with no distractions.</p>\r\n" + 
				"                        <p style=\"font-family:sans-serif;font-size:14px;font-weight:normal;margin:0;Margin-bottom:15px;\">Good luck! Hope it works.</p>\r\n" + 
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
				"                    <span class=\"apple-link\" style=\"color:#999999;font-size:12px;text-align:center;\">Company Inc, 3 Abbey Road, San Francisco CA 94102</span>\r\n" + 
				"                    <br>\r\n" + 
				"                     Don't like these emails? <a href=\"http://i.imgur.com/CScmqnj.gif\" style=\"color:#3498db;text-decoration:underline;color:#999999;font-size:12px;text-align:center;\">Unsubscribe</a>.\r\n" + 
				"                  </td>\r\n" + 
				"                </tr>\r\n" + 
				"                <tr>\r\n" + 
				"                  <td class=\"content-block powered-by\" style=\"font-family:sans-serif;font-size:14px;vertical-align:top;color:#999999;font-size:12px;text-align:center;\">\r\n" + 
				"                    Powered by <a href=\"http://htmlemail.io\" style=\"color:#3498db;text-decoration:underline;color:#999999;font-size:12px;text-align:center;text-decoration:none;\">HTMLemail</a>.\r\n" + 
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
		SendMail.email("BUclubcentral@gmail.com", "BUclubcentral@gmail.com" , "thefirm123", request.getParameter("email"), subject, content);
		System.out.println("Sent email");
		
		if (userErrorChecking(request.getParameter("first_name"), request.getParameter("last_name"),
				request.getParameter("username"), request.getParameter("passwrd"),
				request.getParameter("repeat-passwrd"), request.getParameter("id_num"), request.getParameter("email"),
				request, response)) {
			callRegisterUser(request.getParameter("first_name"), request.getParameter("last_name"),
					request.getParameter("username"), request.getParameter("passwrd"),
					Integer.parseInt(request.getParameter("id_num")), request.getParameter("email"));
			response.sendRedirect("HomeServlet");
		} else {
			System.out.println("user error checking failed");
			response.sendRedirect("RegisterServlet");
		}

	}

	public static void callRegisterUser(String first_name, String last_name, String username, String passwrd,
			int id_num, String email) {
		UserDao uDao = new UserDao();

		uDao.registerUser(first_name, last_name, username, passwrd, id_num, email);
		System.out.println("Added user");
	}

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
								return false;
							}
						} else {
							request.setAttribute("message", "ID number must only contain numbers");
							return false;
						}
					} else {
						request.setAttribute("message", "Passwords do not match");
						return false;
					}
				} else {
					request.setAttribute("message", "Username already exists");
					return false;
				}
			} else {
				request.setAttribute("message", "Username must only have letters and numbers");
				return false;
			}
		} else {
			request.setAttribute("message", "First or Last name is incorrect");
			return false;
		}
	}

}
