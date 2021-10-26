package br.com.alura.gerenciador.servlet;

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

@WebFilter("/entry")
public class AuthorizationFilter implements Filter {
	
	public void doFilter(ServletRequest serverRequest, ServletResponse serverResponse, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("AuthorizationFilter");
		
		HttpServletRequest request = (HttpServletRequest) serverRequest;
		HttpServletResponse response = (HttpServletResponse) serverResponse;
		
		String actionName = request.getParameter("action");
		
		HttpSession session = request.getSession();
		boolean isUserLoggedIn = !(session.getAttribute("loggedUser") == null);
		boolean isAProtectedAction = !(actionName.equals("Login") || actionName.equals("LoginForm"));
		
		if(isAProtectedAction && !isUserLoggedIn) {
			
			response.sendRedirect("entry?action=LoginForm");
			return ;
		}
		
		chain.doFilter(request, response);
	}
}
