package br.com.alura.mvc.mudi.dto;

import br.com.alura.mvc.mudi.model.Order;

public class RequestNewOrderDTO {

	// Mesmos nomes que no input
	private String productName;
	private String productUrl;
	private String imageUrl;
	private String description;

	public Order toOrder() {
		
		return new Order(
			this.productName,
			this.productUrl,
			this.imageUrl,
			this.description
		);
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductUrl() {
		return productUrl;
	}

	public void setProductUrl(String productUrl) {
		this.productUrl = productUrl;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
