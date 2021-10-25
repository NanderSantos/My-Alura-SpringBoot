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

public class UpdateCompanyAction {
	
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Atualizando empresa");

		String name = request.getParameter("name");
		String dateString = request.getParameter("date");
		String idString = request.getParameter("id");
		Integer id = Integer.valueOf(idString);
		
		DatabaseService database = new DatabaseService();
		Company company = database.findById(id);

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;

		if(!dateString.isBlank()) {
			
			try {

				date = format.parse(dateString);

			} catch (ParseException e) {

				throw new ServletException(e);
			}
		
		} else date = company.getCreationDate();
		
		company.setName(name);
		company.setCreationDate(date);

		// RequestDispatcher requestDispatcher =
		// req.getRequestDispatcher("/listCompanies");
		// requestDispatcher.forward(req, resp);

		response.sendRedirect("entry?action=ListCompanies");
	}
}
