package br.com.alura.mvc.mudi.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.mvc.mudi.model.Order;
import br.com.alura.mvc.mudi.model.OrderStatus;
import br.com.alura.mvc.mudi.repository.OrderRepository;

@RestController
@RequestMapping("/api/orders")
public class OrderRest {
	
	@Autowired
	private OrderRepository orderRepository;

	@GetMapping("aguardando")
	public List<Order> getOrdersWaitingOffer() {

		return orderRepository.findByStatus(
			OrderStatus.AGUARDANDO,
			PageRequest.of(0, 10, Sort.by("id").descending())
		);
	}
}
