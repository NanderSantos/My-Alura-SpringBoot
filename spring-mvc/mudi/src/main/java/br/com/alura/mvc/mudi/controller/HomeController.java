package br.com.alura.mvc.mudi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.alura.mvc.mudi.model.Order;
import br.com.alura.mvc.mudi.repository.OrderRepository;

@Controller
public class HomeController {

	@Autowired
	private OrderRepository orderRepository;
	
	@GetMapping("/home")
	public String home(Model model) {

		List<Order> ordersList = orderRepository.findAll();

		model.addAttribute("ordersList", ordersList);
		
		return "home";
	}
}
