package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ben.bu_club_central.daos.ClubDao;
import edu.ben.bu_club_central.models.Club;
import mailDispatcher.SendMail;

/**
 * Servlet implementation class AdminEnableClubServlet
 */
@WebServlet("/AdminEnableClubServlet")
public class AdminEnableClubServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminEnableClubServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("AccessDeniedServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		enableClub(Integer.parseInt(request.getParameter("enableClubId")));
		response.sendRedirect("AdminHome");
	}
	
	/**
	 * calls the enable club method in the dao
	 * @param club_id_num Integer
	 */
	private void enableClub(int club_id_num) {
		ClubDao clubDao = new ClubDao();
		
		clubDao.enableClub(club_id_num);
		sendAcceptanceEmail(club_id_num);
	}
	
	/**
	 * sends an email to the admin to accept a club
	 * @param club_id_num Integer
	 */
	private static void sendAcceptanceEmail(int club_id_num){
		ClubDao cD = new ClubDao();
		Club newClub = null;
		newClub = cD.getClubById(club_id_num);
		String subject = "Congratulations " + newClub.getPet_name() + ", your petition for a new club has been accepted!";
		String content = "<!doctype html>\r\n" + 
				"<html>\r\n" + 
				"  <head>\r\n" + 
				"    <meta name=\"viewport\" content=\"width=device-width\" />\r\n" + 
				"    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n" + 
				"    <title>Simple Transactional Email</title>\r\n" + 
				"    <style>\r\n" + 
				"      /* -------------------------------------\r\n" + 
				"          GLOBAL RESETS\r\n" + 
				"      ------------------------------------- */\r\n" + 
				"      img {\r\n" + 
				"        border: none;\r\n" + 
				"        -ms-interpolation-mode: bicubic;\r\n" + 
				"        max-width: 100%; }\r\n" + 
				"      body {\r\n" + 
				"        background-color: #f6f6f6;\r\n" + 
				"        font-family: sans-serif;\r\n" + 
				"        -webkit-font-smoothing: antialiased;\r\n" + 
				"        font-size: 14px;\r\n" + 
				"        line-height: 1.4;\r\n" + 
				"        margin: 0;\r\n" + 
				"        padding: 0; \r\n" + 
				"        -ms-text-size-adjust: 100%;\r\n" + 
				"        -webkit-text-size-adjust: 100%; }\r\n" + 
				"      table {\r\n" + 
				"        border-collapse: separate;\r\n" + 
				"        mso-table-lspace: 0pt;\r\n" + 
				"        mso-table-rspace: 0pt;\r\n" + 
				"        width: 100%; }\r\n" + 
				"        table td {\r\n" + 
				"          font-family: sans-serif;\r\n" + 
				"          font-size: 14px;\r\n" + 
				"          vertical-align: top; }\r\n" + 
				"      /* -------------------------------------\r\n" + 
				"          BODY & CONTAINER\r\n" + 
				"      ------------------------------------- */\r\n" + 
				"      .body {\r\n" + 
				"        background-color: #000000;\r\n" + 
				"        width: 100%; }\r\n" + 
				"      /* Set a max-width, and make it display as block so it will automatically stretch to that width, but will also shrink down on a phone or something */\r\n" + 
				"      .container {\r\n" + 
				"        display: block;\r\n" + 
				"        Margin: 0 auto !important;\r\n" + 
				"        /* makes it centered */\r\n" + 
				"        max-width: 580px;\r\n" + 
				"        padding: 10px;\r\n" + 
				"        width: 580px; }\r\n" + 
				"      /* This should also be a block element, so that it will fill 100% of the .container */\r\n" + 
				"      .content {\r\n" + 
				"        box-sizing: border-box;\r\n" + 
				"        display: block;\r\n" + 
				"        Margin: 0 auto;\r\n" + 
				"        max-width: 580px;\r\n" + 
				"        padding: 10px; }\r\n" + 
				"      /* -------------------------------------\r\n" + 
				"          HEADER, FOOTER, MAIN\r\n" + 
				"      ------------------------------------- */\r\n" + 
				"      .main {\r\n" + 
				"        background: #fff;\r\n" + 
				"        border-radius: 3px;\r\n" + 
				"        width: 100%; }\r\n" + 
				"      .wrapper {\r\n" + 
				"        box-sizing: border-box;\r\n" + 
				"        padding: 20px; }\r\n" + 
				"      .footer {\r\n" + 
				"        clear: both;\r\n" + 
				"        padding-top: 10px;\r\n" + 
				"        text-align: center;\r\n" + 
				"        width: 100%; }\r\n" + 
				"        .footer td,\r\n" + 
				"        .footer p,\r\n" + 
				"        .footer span,\r\n" + 
				"        .footer a {\r\n" + 
				"          color: #999999;\r\n" + 
				"          font-size: 12px;\r\n" + 
				"          text-align: center; }\r\n" + 
				"      /* -------------------------------------\r\n" + 
				"          TYPOGRAPHY\r\n" + 
				"      ------------------------------------- */\r\n" + 
				"      h1,\r\n" + 
				"      h2,\r\n" + 
				"      h3,\r\n" + 
				"      h4 {\r\n" + 
				"        color: #000000;\r\n" + 
				"        font-family: sans-serif;\r\n" + 
				"        font-weight: 400;\r\n" + 
				"        line-height: 1.4;\r\n" + 
				"        margin: 0;\r\n" + 
				"        Margin-bottom: 30px; }\r\n" + 
				"      h1 {\r\n" + 
				"        font-size: 35px;\r\n" + 
				"        font-weight: 300;\r\n" + 
				"        text-align: center;\r\n" + 
				"        text-transform: capitalize; }\r\n" + 
				"      p,\r\n" + 
				"      ul,\r\n" + 
				"      ol {\r\n" + 
				"        font-family: sans-serif;\r\n" + 
				"        font-size: 14px;\r\n" + 
				"        font-weight: normal;\r\n" + 
				"        margin: 0;\r\n" + 
				"        Margin-bottom: 15px; }\r\n" + 
				"        p li,\r\n" + 
				"        ul li,\r\n" + 
				"        ol li {\r\n" + 
				"          list-style-position: inside;\r\n" + 
				"          margin-left: 5px; }\r\n" + 
				"      a {\r\n" + 
				"        color: #3498db;\r\n" + 
				"        text-decoration: underline; }\r\n" + 
				"      /* -------------------------------------\r\n" + 
				"          BUTTONS\r\n" + 
				"      ------------------------------------- */\r\n" + 
				"      .btn {\r\n" + 
				"        box-sizing: border-box;\r\n" + 
				"        width: 100%; }\r\n" + 
				"        .btn > tbody > tr > td {\r\n" + 
				"          padding-bottom: 15px; }\r\n" + 
				"        .btn table {\r\n" + 
				"          width: auto; }\r\n" + 
				"        .btn table td {\r\n" + 
				"          background-color: #ffffff;\r\n" + 
				"          border-radius: 5px;\r\n" + 
				"          text-align: center; }\r\n" + 
				"        .btn a {\r\n" + 
				"          background-color: #ffffff;\r\n" + 
				"          border: solid 1px #3498db;\r\n" + 
				"          border-radius: 5px;\r\n" + 
				"          box-sizing: border-box;\r\n" + 
				"          color: #3498db;\r\n" + 
				"          cursor: pointer;\r\n" + 
				"          display: inline-block;\r\n" + 
				"          font-size: 14px;\r\n" + 
				"          font-weight: bold;\r\n" + 
				"          margin: 0;\r\n" + 
				"          padding: 12px 25px;\r\n" + 
				"          text-decoration: none;\r\n" + 
				"          text-transform: capitalize; }\r\n" + 
				"      .btn-primary table td {\r\n" + 
				"        background-color: #3498db; }\r\n" + 
				"      .btn-primary a {\r\n" + 
				"        background-color: #c61003;\r\n" + 
				"        border-color: #3498db;\r\n" + 
				"        color: #ffffff; }\r\n" + 
				"      /* -------------------------------------\r\n" + 
				"          OTHER STYLES THAT MIGHT BE USEFUL\r\n" + 
				"      ------------------------------------- */\r\n" + 
				"      .last {\r\n" + 
				"        margin-bottom: 0; }\r\n" + 
				"      .first {\r\n" + 
				"        margin-top: 0; }\r\n" + 
				"      .align-center {\r\n" + 
				"        text-align: center; }\r\n" + 
				"      .align-right {\r\n" + 
				"        text-align: right; }\r\n" + 
				"      .align-left {\r\n" + 
				"        text-align: left; }\r\n" + 
				"      .clear {\r\n" + 
				"        clear: both; }\r\n" + 
				"      .mt0 {\r\n" + 
				"        margin-top: 0; }\r\n" + 
				"      .mb0 {\r\n" + 
				"        margin-bottom: 0; }\r\n" + 
				"      .preheader {\r\n" + 
				"        color: transparent;\r\n" + 
				"        display: none;\r\n" + 
				"        height: 0;\r\n" + 
				"        max-height: 0;\r\n" + 
				"        max-width: 0;\r\n" + 
				"        opacity: 0;\r\n" + 
				"        overflow: hidden;\r\n" + 
				"        mso-hide: all;\r\n" + 
				"        visibility: hidden;\r\n" + 
				"        width: 0; }\r\n" + 
				"      .powered-by a {\r\n" + 
				"        text-decoration: none; }\r\n" + 
				"      hr {\r\n" + 
				"        border: 0;\r\n" + 
				"        border-bottom: 1px solid #f6f6f6;\r\n" + 
				"        Margin: 20px 0; }\r\n" + 
				"      /* -------------------------------------\r\n" + 
				"          RESPONSIVE AND MOBILE FRIENDLY STYLES\r\n" + 
				"      ------------------------------------- */\r\n" + 
				"      @media only screen and (max-width: 620px) {\r\n" + 
				"        table[class=body] h1 {\r\n" + 
				"          font-size: 28px !important;\r\n" + 
				"          margin-bottom: 10px !important; }\r\n" + 
				"        table[class=body] p,\r\n" + 
				"        table[class=body] ul,\r\n" + 
				"        table[class=body] ol,\r\n" + 
				"        table[class=body] td,\r\n" + 
				"        table[class=body] span,\r\n" + 
				"        table[class=body] a {\r\n" + 
				"          font-size: 16px !important; }\r\n" + 
				"        table[class=body] .wrapper,\r\n" + 
				"        table[class=body] .article {\r\n" + 
				"          padding: 10px !important; }\r\n" + 
				"        table[class=body] .content {\r\n" + 
				"          padding: 0 !important; }\r\n" + 
				"        table[class=body] .container {\r\n" + 
				"          padding: 0 !important;\r\n" + 
				"          width: 100% !important; }\r\n" + 
				"        table[class=body] .main {\r\n" + 
				"          border-left-width: 0 !important;\r\n" + 
				"          border-radius: 0 !important;\r\n" + 
				"          border-right-width: 0 !important; }\r\n" + 
				"        table[class=body] .btn table {\r\n" + 
				"          width: 100% !important; }\r\n" + 
				"        table[class=body] .btn a {\r\n" + 
				"          width: 100% !important; }\r\n" + 
				"        table[class=body] .img-responsive {\r\n" + 
				"          height: auto !important;\r\n" + 
				"          max-width: 100% !important;\r\n" + 
				"          width: auto !important; }}\r\n" + 
				"      /* -------------------------------------\r\n" + 
				"          PRESERVE THESE STYLES IN THE HEAD\r\n" + 
				"      ------------------------------------- */\r\n" + 
				"      @media all {\r\n" + 
				"        .ExternalClass {\r\n" + 
				"          width: 100%; }\r\n" + 
				"        .ExternalClass,\r\n" + 
				"        .ExternalClass p,\r\n" + 
				"        .ExternalClass span,\r\n" + 
				"        .ExternalClass font,\r\n" + 
				"        .ExternalClass td,\r\n" + 
				"        .ExternalClass div {\r\n" + 
				"          line-height: 100%; }\r\n" + 
				"        .apple-link a {\r\n" + 
				"          color: inherit !important;\r\n" + 
				"          font-family: inherit !important;\r\n" + 
				"          font-size: inherit !important;\r\n" + 
				"          font-weight: inherit !important;\r\n" + 
				"          line-height: inherit !important;\r\n" + 
				"          text-decoration: none !important; } \r\n" + 
				"        .btn-primary table td:hover {\r\n" + 
				"          background-color: #34495e !important; }\r\n" + 
				"        .btn-primary a:hover {\r\n" + 
				"          background-color: #9b0b01 !important;\r\n" + 
				"          border-color: #34495e !important; } }\r\n" + 
				"    </style>\r\n" + 
				"  </head>\r\n" + 
				"  <body class=\"\">\r\n" + 
				"    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"body\">\r\n" + 
				"      <tr>\r\n" + 
				"        <td>&nbsp;</td>\r\n" + 
				"        <td class=\"container\">\r\n" + 
				"          <div class=\"content\">\r\n" + 
				"\r\n" + 
				"            <!-- START CENTERED WHITE CONTAINER -->\r\n" + 
				"            <span class=\"preheader\">"+ newClub.getPet_name() +", your petition for a new club was accepted!</span>\r\n" + 
				"            <table class=\"main\">\r\n" + 
				"\r\n" + 
				"              <!-- START MAIN CONTENT AREA -->\r\n" + 
				"              <tr>\r\n" + 
				"                <td class=\"wrapper\">\r\n" + 
				"                  <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n" + 
				"                    <tr>\r\n" + 
				"                      <td>\r\n" + 
				"                        <p>Hello <b>"+ newClub.getPet_name() +"</b>,</p>\r\n" + 
				"                          <img src =\"http://i.imgur.com/6FAwUvX.jpg?1\">\r\n" + 
				"                        <p>After careful review and consideration, BU Club Central has ACCEPTED your petition to form your club named, <b>" + newClub.getClub_name() +"</b>.</p>\r\n" + 
				"                        <p> Please follow up with Danny Turano at <a href = \"mailto:dturano@ben.edu\">dturano@ben.edu</a> for more information on what your next steps will be. \r\n" + 
				"                        <p> We're very excited to have a new club join us here at Club Central and we look forward to working with you and helping you grow as both students and leaders! </p>\r\n" + 
				"                        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"btn btn-primary\">\r\n" + 
				"                          <tbody>\r\n" + 
				"                            <tr>\r\n" + 
				"                              <td align=\"left\">\r\n" + 
				"                              </td>\r\n" + 
				"                            </tr>\r\n" + 
				"                          </tbody>\r\n" + 
				"                        </table>\r\n" + 
				"                        <p>Please note in order for the club to be registered Danny Turano must accept the new club and the petioner must have filed all paperwork before hand.</p>\r\n" + 
				"						 <p>Regards,</p>\r\n" + 
				"                        <p><b>BU Club Central</b><br>Benedictine University<br>Krasa 010<br>Lisle, IL 60532</p>\r\n" + 
				"                      </td>\r\n" + 
				"                    </tr>\r\n" + 
				"                  </table>\r\n" + 
				"                </td>\r\n" + 
				"              </tr>\r\n" + 
				"\r\n" + 
				"              <!-- END MAIN CONTENT AREA -->\r\n" + 
				"              </table>\r\n" + 
				"\r\n" + 
				"            <!-- START FOOTER -->\r\n" + 
				"            <div class=\"footer\">\r\n" + 
				"              <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n" + 
				"                <tr>\r\n" + 
				"                  <td>\r\n" + 
				"                    <p> This message was sent from Benedictine University Club Central. Please do not reply to this message.</p>\r\n" + 
				"                    <br>\r\n" + 
				"                    <p> The F.I.R.M.</p>\r\n" + 
				"                  </td>\r\n" + 
				"                  <td>\r\n" + 
				"                      <img src = \"http://i.imgur.com/tklPxvC.png\">\r\n" + 
				"                  </td>\r\n" + 
				"                </tr>\r\n" + 
				"              </table>\r\n" + 
				"            </div>\r\n" + 
				"\r\n" + 
				"            <!-- END FOOTER -->\r\n" + 
				"            \r\n" + 
				"<!-- END CENTERED WHITE CONTAINER --></div>\r\n" + 
				"        </td>\r\n" + 
				"        <td>&nbsp;</td>\r\n" + 
				"      </tr>\r\n" + 
				"    </table>\r\n" + 
				"  </body>\r\n" + 
				"</html>";
		SendMail.email("BUclubcentral@gmail.com", "BUclubcentral@gmail.com" , "thefirm123", newClub.getPet_email(), subject, content);
		System.out.println("Sent email");
		
	}
	

}