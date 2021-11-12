package br.com.alura.mvc.mudi.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.mvc.mudi.dto.RequestNewOfferDTO;
import br.com.alura.mvc.mudi.model.Offer;
import br.com.alura.mvc.mudi.model.Order;
import br.com.alura.mvc.mudi.repository.OrderRepository;

@RestController
@RequestMapping("/api/offers")
public class OffersRest {
	
	@Autowired
	private OrderRepository orderRepository;

	@PostMapping
	public Offer newOffer(RequestNewOfferDTO requestNewOfferDTO) {

		Optional<Order> optional = orderRepository.findById(requestNewOfferDTO.getOrderId());

		if(!optional.isPresent()) {

			return null;
		}

		Order order = optional.get();
		Offer offer = requestNewOfferDTO.toOffer();
		offer.setOrder(order);

		orderRepository.save(order);

		return offer;
	}
}
