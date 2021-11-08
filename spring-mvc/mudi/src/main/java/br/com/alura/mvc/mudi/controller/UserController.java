package br.com.alura.mvc.mudi.controller;

import java.security.Principal;
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
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@GetMapping("order")
	public String home(Model model, Principal principal) {

		List<Order> ordersList = orderRepository.findAllByUser(principal.getName());

		model.addAttribute("ordersList", ordersList);
		
		return "user/home";
	}
	
	@GetMapping("order/{status}")
	public String status(@PathVariable("status") String status, Model model, Principal principal) {

		List<Order> ordersList = orderRepository.findByStatusAndUser(
			OrderStatus.valueOf(status.toUpperCase()),
			principal.getName()
		);

		model.addAttribute("ordersList", ordersList);
		model.addAttribute("status", status.toUpperCase());
		
		return "user/home";
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {

		return "redirect:/user/order";
	}
}
