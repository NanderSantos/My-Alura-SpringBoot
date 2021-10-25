package br.com.alura.gerenciador.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.service.DatabaseService;

public class DeleteCompany implements IAction {
	
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Removendo empresa");

		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		DatabaseService database = new DatabaseService();
		database.deleteCompany(id);
		
		return "redirect:entry?action=ListCompanies";
	}
}
