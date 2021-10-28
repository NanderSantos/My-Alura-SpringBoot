package br.com.alura.mvc.mudi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mvc.mudi.dto.RequestNewOrderDTO;
import br.com.alura.mvc.mudi.model.Order;
import br.com.alura.mvc.mudi.repository.OrderRepository;

@Controller
@RequestMapping("order")
public class OrderController {

	@Autowired
	private OrderRepository orderRepository;
	
	@GetMapping("form")
	public String form() {

		return "order/form";
	}

	@PostMapping("new")
	public String newOrder(RequestNewOrderDTO request) {

		Order order = request.toOrder();
		this.orderRepository.save(order);

		return "order/form";
	}
}
