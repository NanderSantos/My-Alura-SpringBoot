package br.com.alura.gerenciador.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Company;
import br.com.alura.gerenciador.service.DatabaseService;

public class ShowCompany implements IAction {
	
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Mostrando dados da empresa");

		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		DatabaseService database = new DatabaseService();
		Company company = database.findById(id);
		
		if(company != null) {
			
			System.out.println("Mostrando dados da empresa: " + company);
			
			request.setAttribute("company", company);
			
			return "forward:formShowCompany.jsp";
		}
		
		return "";
	}
}
