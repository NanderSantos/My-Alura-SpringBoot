package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Company;
import br.com.alura.gerenciador.service.Database;

@WebServlet("/newCompany")
public class NewCompanyServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("Cadastrando nova empresa");
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		
		try {			
		
			date = format.parse(req.getParameter("date"));
			
		} catch (ParseException e) {
			
			throw new ServletException(e);
		}
		
		Company company = new Company();
		company.setName(req.getParameter("name"));
		company.setCreationDate(date);
		
		Database database = new Database();
		database.addCompany(company);
		
		req.setAttribute("company", company.getName());
		req.setAttribute("date", company.getCreationDate());
		
		// RequestDispatcher requestDispatcher = req.getRequestDispatcher("/listCompanies");
		// requestDispatcher.forward(req, resp);
		
		resp.sendRedirect("listCompanies");
	}
}
