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

public class NewCompanyForm implements IAction {

	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Formulário nova empresa");

		return "forward:formNewCompany.jsp";
	}
}
