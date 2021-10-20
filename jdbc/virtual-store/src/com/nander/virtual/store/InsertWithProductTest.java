package com.nander.virtual.store;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.nander.virtual.store.dao.ProductDAO;
import com.nander.virtual.store.factory.ConnectionFactory;
import com.nander.virtual.store.repository.ProductRepository;

public class InsertWithProductTest {
	
	public static void main(String[] args) throws SQLException {
		
		ProductDAO product = new ProductDAO("CÔMODA", "CÔMODA DE MADEIRA");

		try (Connection connection = new ConnectionFactory().getConnection()) {
			
			ProductRepository productRepository = new ProductRepository(connection);
			productRepository.save(product);
			System.out.println();
			List<ProductDAO> productList = productRepository.list();
		}
	}
}
