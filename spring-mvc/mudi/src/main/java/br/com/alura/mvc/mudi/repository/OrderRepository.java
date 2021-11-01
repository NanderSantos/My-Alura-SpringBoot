package br.com.alura.mvc.mudi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.mvc.mudi.model.Order;
import br.com.alura.mvc.mudi.model.OrderStatus;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>  {

	List<Order> findByStatus(OrderStatus status);
}
