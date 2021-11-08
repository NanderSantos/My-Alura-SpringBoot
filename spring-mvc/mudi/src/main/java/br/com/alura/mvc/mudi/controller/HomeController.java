package br.com.alura.mvc.mudi.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	public String home(Model model, Principal principal) {

		List<Order> ordersList = orderRepository.findByStatus(
			OrderStatus.ENTREGUE,
			PageRequest.of(0, 10, Sort.by("deliveryDate").descending())
		);

		model.addAttribute("ordersList", ordersList);
		
		return "home";
	}
}
