package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.action.DeleteCompany;
import br.com.alura.gerenciador.action.IAction;
import br.com.alura.gerenciador.action.ListCompanies;
import br.com.alura.gerenciador.action.NewCompany;
import br.com.alura.gerenciador.action.NewCompanyForm;
import br.com.alura.gerenciador.action.ShowCompany;
import br.com.alura.gerenciador.action.UpdateCompany;

@WebServlet("/entry")
public class EntryServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Servlet de entrada");
		
		String actionName = request.getParameter("action");
		
		HttpSession session = request.getSession();
		boolean isUserLoggedIn = !(session.getAttribute("loggedUser") == null);
		boolean isAProtectedAction = !(actionName.equals("Login") || actionName.equals("LoginForm"));
		
		if(isAProtectedAction && !isUserLoggedIn) {
			
			response.sendRedirect("entry?action=LoginForm");
			return ;
		}
		
		try {
			
			Class myClass = Class.forName("br.com.alura.gerenciador.action." + actionName);
			IAction action = (IAction) myClass.newInstance();
			
			String actionReturn = action.exec(request, response);
			
			String[] nextPage = actionReturn.split(":");
			
			if(nextPage[0].equals("redirect")) {
				
				response.sendRedirect("entry?action=" + nextPage[1]);
			
			} else if(nextPage[0].equals("forward")) {
							
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/view/" + nextPage[1]);
				requestDispatcher.forward(request, response);
			}
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			
			throw new ServletException(e);
		}
	}
}
