package br.com.alura.gerenciador.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.User;
import br.com.alura.gerenciador.service.DatabaseService;

public class Login implements IAction {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Fazendo login");
		
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		System.out.println("Login: " + login + ", Senha: " + password);
		
		DatabaseService database = new DatabaseService();
		User user = database.searchUser(login, password);
		
		if(user != null) {
			
			System.out.println("Usuário existe");
			return "redirect:ListCompanies";
		
		} else {
			
			System.out.println("Usuário não existe");
			return "redirect:LoginForm";
		}
	}
}
