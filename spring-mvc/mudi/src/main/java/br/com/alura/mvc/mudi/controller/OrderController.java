package br.com.alura.mvc.mudi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
	public String form(RequestNewOrderDTO requestNewOrderDTO) {

		return "order/form";
	}

	@PostMapping("new")
	public String newOrder(@Valid RequestNewOrderDTO requestNewOrderDTO, BindingResult result) {

		System.out.println("newOrder");
		
		if(result.hasErrors()) {

			System.out.println("Validation error");
			return "order/form";
		}

		System.out.println("Validation ok");

		Order order = requestNewOrderDTO.toOrder();
		this.orderRepository.save(order);

		return "redirect:/home";
	}
}
