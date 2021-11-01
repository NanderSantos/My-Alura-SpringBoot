package br.com.alura.mvc.mudi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mvc.mudi.model.Order;
import br.com.alura.mvc.mudi.model.OrderStatus;
import br.com.alura.mvc.mudi.repository.OrderRepository;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private OrderRepository orderRepository;
	
	@GetMapping
	public String home(Model model) {

		List<Order> ordersList = orderRepository.findAll();

		model.addAttribute("ordersList", ordersList);
		
		return "home";
	}
	
	@GetMapping("/{status}")
	public String status(@PathVariable("status") String status, Model model) {

		List<Order> ordersList = orderRepository.findByStatus(OrderStatus.valueOf(status.toUpperCase()));

		model.addAttribute("ordersList", ordersList);
		model.addAttribute("status", status.toUpperCase());
		
		return "home";
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {

		return "redirect:/home";
	}
}
