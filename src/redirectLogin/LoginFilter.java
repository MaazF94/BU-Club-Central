/**
 * 
 */
package redirectLogin;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Raza Mohammed
 * 
 * This class redirects to the login page if a user tries to access a webpage that requires a login
 * as of now it does not differentiate if you have the proper role id this will be added later. It may possibly
 * have to be done on the individual pages
 *
 */
@WebFilter("/user/*")
public class LoginFilter implements Filter {
	
	/**
	 * nothing here as of now, destroy items that are expensive resources here to close them
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	/**
	 * redirects to login page if not logged in
	 */
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		HttpSession session = request.getSession(false);
		
		if (session == null || session.getAttribute("user") == null){
			//redirect to login servlet if 
			response.sendRedirect(request.getContextPath() + "/LoginServlet");
		} else {
			
			chain.doFilter(req, res);
		}
		
	}
	/**
	 * init params from web.xml of webapp go here.
	 */
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
