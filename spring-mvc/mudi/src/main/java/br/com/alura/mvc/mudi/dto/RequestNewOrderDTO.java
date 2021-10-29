package br.com.alura.mvc.mudi.dto;

import javax.validation.constraints.NotBlank;

import br.com.alura.mvc.mudi.model.Order;

public class RequestNewOrderDTO {

	// Mesmos nomes que no input
	
	@NotBlank(message = "Esse campo é obrigatório!") //NotBlank.requestNewOrderDTO.productName
	private String productName;
	
	@NotBlank(message = "Esse campo é obrigatório!") //NotBlank.requestNewOrderDTO.productUrl
	private String productUrl;
	
	@NotBlank(message = "Esse campo é obrigatório!") //NotBlank.requestNewOrderDTO.imageUrl
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
