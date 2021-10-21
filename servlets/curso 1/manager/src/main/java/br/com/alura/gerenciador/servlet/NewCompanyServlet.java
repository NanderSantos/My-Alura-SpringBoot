package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Company;
import br.com.alura.gerenciador.service.Database;

@WebServlet("/new-company")
public class NewCompanyServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("Cadastrando nova empresa");
		
		Company company = new Company();
		company.setName(req.getParameter("name"));
		
		Database database = new Database();
		database.addCompany(company);
		
		req.setAttribute("company", company.getName());
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/newCompanyCreated.jsp");
		requestDispatcher.forward(req, resp);
	}
}
