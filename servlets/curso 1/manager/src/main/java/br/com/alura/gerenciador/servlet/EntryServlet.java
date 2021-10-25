package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.action.DeleteCompanyAction;
import br.com.alura.gerenciador.action.ListCompaniesAction;
import br.com.alura.gerenciador.action.NewCompanyAction;
import br.com.alura.gerenciador.action.ShowCompanyAction;
import br.com.alura.gerenciador.action.UpdateCompanyAction;

@WebServlet("/entry")
public class EntryServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Servlet de entrada");
		
		String actionParam = request.getParameter("action");
		
		switch (actionParam) {
		
			case "NewCompany":
				
				NewCompanyAction newCompanyAction = new NewCompanyAction();
				newCompanyAction.exec(request, response);
				break;
		
			case "ListCompanies":
				
				ListCompaniesAction listCompaniesAction = new ListCompaniesAction();
				listCompaniesAction.exec(request, response);
				break;
		
			case "DeleteCompany":
				
				DeleteCompanyAction deleteCompanyAction = new DeleteCompanyAction();
				deleteCompanyAction.exec(request, response);
				break;
		
			case "ShowCompany":
				
				ShowCompanyAction showCompanyAction = new ShowCompanyAction();
				showCompanyAction.exec(request, response);
				break;
		
			case "UpdateCompany":
				
				UpdateCompanyAction updateCompanyAction = new UpdateCompanyAction();
				updateCompanyAction.exec(request, response);
				break;
	
			default:
				break;
		}
	}
}
