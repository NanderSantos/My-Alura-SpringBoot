package br.com.alura.mvc.mudi.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private BigDecimal orderValue;
	private LocalDate deliveryDate;
	private String orderUrl;
	private String imageUrl;
	private String orderDescription;

	public Order() {}

	public Order(String name, String orderUrl, String imageUrl, String orderDescription) {
		this.name = name;
		this.orderUrl = orderUrl;
		this.imageUrl = imageUrl;
		this.orderDescription = orderDescription;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getOrderValue() {
		return orderValue;
	}

	public void setOrderValue(BigDecimal orderValue) {
		this.orderValue = orderValue;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getOrderUrl() {
		return orderUrl;
	}

	public void setOrderUrl(String orderUrl) {
		this.orderUrl = orderUrl;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getOrderDescription() {
		return orderDescription;
	}

	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}
}
