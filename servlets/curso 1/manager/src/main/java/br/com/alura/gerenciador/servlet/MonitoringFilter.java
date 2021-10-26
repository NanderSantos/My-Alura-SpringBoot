package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns = "/entry")
public class MonitoringFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("MonitoringFilter");

		Long before = System.currentTimeMillis();
		
		// executa a ação
		chain.doFilter(request, response);
		
		Long after = System.currentTimeMillis();
		
		String actionName = request.getParameter("action");
		
		System.out.println(actionName + " took " + (after - before) + "ms");
	}	
}
