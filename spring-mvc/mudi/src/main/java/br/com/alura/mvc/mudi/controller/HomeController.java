package br.com.alura.mvc.mudi.controller;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.alura.mvc.mudi.model.Order;

@Controller
public class HomeController {
	
	@GetMapping("/home")
	public String home(Model model) {

		Order order = new Order();
		order.setName("Kindle 10a. Geração");
		order.setOrderUrl("https://www.amazon.com.br/Kindle-10a-gera%C3%A7%C3%A3o-ilumina%C3%A7%C3%A3o-embutida/dp/B07FQK1TS9");
		order.setImageUrl("https://m.media-amazon.com/images/I/61X0ISBpD-L._AC_SL1000_.jpg");
		order.setDescription("Com bateria de longa duração - Cor Preta");
		
		List<Order> ordersList = Arrays.asList(order);

		model.addAttribute("ordersList", ordersList);
		
		return "home";
	}
}
