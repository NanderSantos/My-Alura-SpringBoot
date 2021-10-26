package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.alura.gerenciador.model.Company;
import br.com.alura.gerenciador.service.DatabaseService;

@WebServlet("/companies")
public class CompaniesWebService extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Company> companies = new DatabaseService().getCompanies();
		
		String contentType = request.getHeader("Accept");
		
		if(contentType.contains("xml")) {
			
			// Para devolver um XML
			XStream xstream = new XStream();
			xstream.alias("company", Company.class);
			String json = xstream.toXML(companies);

			response.setContentType("application/xml");
			response.getWriter().print(json);
			
		} else if(contentType.contains("json")) {
			
			// Para devolver um JSON
			Gson gson = new Gson();
			String json = gson.toJson(companies);

			response.setContentType("application/json");
			response.getWriter().print(json);
			
		} else {
			
			response.setContentType("text/plain");
			response.getWriter().print("Content-type não aceito!");
		}
	}
}
