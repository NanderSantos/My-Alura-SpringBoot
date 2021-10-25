package br.com.alura.gerenciador.action;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Company;
import br.com.alura.gerenciador.service.DatabaseService;

public class NewCompany implements IAction {

	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Cadastrando nova empresa");

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;

		try {

			date = format.parse(request.getParameter("date"));

		} catch (ParseException e) {

			throw new ServletException(e);
		}

		Company company = new Company();
		company.setName(request.getParameter("name"));
		company.setCreationDate(date);

		DatabaseService database = new DatabaseService();
		database.addCompany(company);

		request.setAttribute("company", company.getName());
		request.setAttribute("date", company.getCreationDate());

		// RequestDispatcher requestDispatcher =
		// req.getRequestDispatcher("/listCompanies");
		// requestDispatcher.forward(req, resp);

		return "redirect:entry?action=ListCompanies";
	}
}
