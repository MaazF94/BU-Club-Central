package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ben.bu_club_central.daos.ClubDao;
import edu.ben.bu_club_central.daos.ClubMembershipDao;
import edu.ben.bu_club_central.daos.UserDao;
import edu.ben.bu_club_central.models.Club;
import mailDispatcher.SendMail;

/**
 * Servlet implementation class ClubHomepageServlet
 */
@WebServlet("/ClubHomepageServlet")
public class ClubHomepageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String clubIdNum = "";
	static String clubBoardMemberName = "";
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClubHomepageServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String clubIdNum = (String) request.getParameter("bu_club_id");
		int club_id_num = Integer.parseInt(clubIdNum);

		ClubDao cDao = new ClubDao();
		Club clubObject = cDao.getClubById(club_id_num);
		String clubName = clubObject.getClub_name();
		request.setAttribute("clubName", clubName);

		int clubMemberCount = callClubMemberCount(club_id_num);
		request.setAttribute("clubMembers", clubMemberCount);
		
		String clubDescription = clubObject.getClub_description();
		request.setAttribute("clubDescription", clubDescription);
		request.getRequestDispatcher("/WEB-INF/jsp/ClubHomepage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			UserDao uDao = new UserDao();
			clubIdNum = (String) request.getParameter("bu_club_id");
			int club_id_num = Integer.parseInt(clubIdNum);

			ClubDao cDao = new ClubDao();
			Club clubObject = cDao.getClubById(club_id_num);
			clubBoardMemberName = clubObject.getPet_name();

		try {
			if (!checkName(request.getParameter("name")) || !uDao.checkEmail(request.getParameter("email")) || !checkMessage(request.getParameter("message"))) {
				throw new Exception();
			} else { callEmailClubBoardMember(request.getParameter("name"), request.getParameter("email"), request.getParameter("message"));
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
doGet(request, response);
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
		doGet(request, response);
		}
	}

	/**
	 * call the clubMemberCount method
	 * 
	 * @param club_id
	 * @return the number of members in club
	 */
	public static int callClubMemberCount(int club_id) {
		int memberCount = 0;

		ClubMembershipDao cmDao = new ClubMembershipDao();

		try {
			memberCount = cmDao.countClubMembers(club_id);
			System.out.println("Members counted");
			return memberCount;
		} catch (Exception e) {
			System.out.println("Club doesn't exist");
		}

		return 0;
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
	
	public static void callEmailClubBoardMember(String fullName, String email, String message) {
		String subject = "Message about your club by " + fullName + "!";
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
				"            <span class=\"preheader\" style=\"color:transparent;display:none;height:0;max-height:0;max-width:0;opacity:0;overflow:hidden;mso-hide:all;visibility:hidden;width:0;\">Hello, you have a question in BU Club Central from" + fullName + ".</span>\r\n" + 
				"            <table class=\"main\" style=\"border-collapse:separate;mso-table-lspace:0pt;mso-table-rspace:0pt;background:#fff;border-radius:3px;width:100%;\">\r\n" + 
				"              <!-- START MAIN CONTENT AREA -->\r\n" + 
				"              <tr>\r\n" + 
				"                <td class=\"wrapper\" style=\"font-family:sans-serif;font-size:14px;vertical-align:top;box-sizing:border-box;padding:20px;\">\r\n" + 
				"                  <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:separate;mso-table-lspace:0pt;mso-table-rspace:0pt;width:100%;\">\r\n" + 
				"                    <tr>\r\n" + 
				"                      <td style=\"font-family:sans-serif;font-size:14px;vertical-align:top;\">\r\n" + 
				"                        <p style=\"font-family:sans-serif;font-size:14px;font-weight:normal;margin:0;Margin-bottom:15px;\"><b>Hi, " + clubBoardMemberName + "</b></p>\r\n" +		
				"                        <p style=\"font-family:sans-serif;font-size:14px;font-weight:normal;margin:0;Margin-bottom:15px;\">" + "<b>" +  "Message from " + fullName + ": </b>" + message + "</p>\r\n" + 
				"                        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"btn btn-primary\" style=\"border-collapse:separate;mso-table-lspace:0pt;mso-table-rspace:0pt;box-sizing:border-box;width:100%;\">\r\n" + 
				"                          <tbody>\r\n" + 
				"                            <tr>\r\n" + 
				"                              <td align=\"left\" style=\"font-family:sans-serif;font-size:14px;vertical-align:top;padding-bottom:15px;\">\r\n" + 
				"                              </td>\r\n" + 
				"                            </tr>\r\n" + 
				"                          </tbody>\r\n" + 
				"                        </table>\r\n" + 
				"                        <p style=\"font-family:sans-serif;font-size:14px;font-weight:normal;margin:0;Margin-bottom:15px;\"><b>To reply to this email ,click here --> </b>" + email + "</p>\r\n" + 
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
				"                     Don't like these emails? <a href=\"http://ww.ben.edu\" style=\"color:#3498db;text-decoration:underline;color:#999999;font-size:12px;text-align:center;\">Unsubscribe</a>.\r\n" + 
				"                  </td>\r\n" + 
				"                  <td style=\"font-family:sans-serif;font-size:14px;vertical-align:top;color:#999999;font-size:12px;text-align:center;\">\r\n" + 
				"                    <img src=\"https://upload.wikimedia.org/wikipedia/en/b/b8/Benedictine_University_logo.jpg\" style=\"border:none;-ms-interpolation-mode:bicubic;max-width:100%;\">\r\n" + 
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
		SendMail.email(email, "BUclubcentral@gmail.com" , "thefirm123", "BUclubcentral@gmail.com", subject, content);
		System.out.println("Sent email");
	}

}
