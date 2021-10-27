package br.com.alura;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class ProductTest {
	
	@Test
	public void teste() {

		Product product = new Product("teste", BigDecimal.TEN);

		Assert.assertEquals("teste", product.getName());
		Assert.assertEquals(BigDecimal.TEN, product.getPrice());
	}
}
