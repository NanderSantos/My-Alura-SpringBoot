package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.action.IAction;

@WebFilter("/entry")
public class ControllerFilter implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	
	@Override
	public void destroy() {}

	public void doFilter(ServletRequest serverRequest, ServletResponse serverResponse, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("ControllerFilter");

		HttpServletRequest request = (HttpServletRequest) serverRequest;
		HttpServletResponse response = (HttpServletResponse) serverResponse;

		String actionName = request.getParameter("action");

		try {

			Class myClass = Class.forName("br.com.alura.gerenciador.action." + actionName);
			IAction action = (IAction) myClass.newInstance();

			String actionReturn = action.exec(request, response);

			String[] nextPage = actionReturn.split(":");

			if (nextPage[0].equals("redirect")) {

				response.sendRedirect("entry?action=" + nextPage[1]);

			} else if (nextPage[0].equals("forward")) {

				RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/view/" + nextPage[1]);
				requestDispatcher.forward(request, response);
			}

		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {

			throw new ServletException(e);
		}
	}
}
