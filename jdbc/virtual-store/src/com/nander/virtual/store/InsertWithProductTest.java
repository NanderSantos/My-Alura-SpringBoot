package com.nander.virtual.store;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.nander.virtual.store.dao.ProductDAO;
import com.nander.virtual.store.persistence.ProductPersistence;

public class InsertWithProductTest {
	
	public static void main(String[] args) throws SQLException {
		
		ProductDAO product = new ProductDAO("CÔMODA", "CÔMODA DE MADEIRA");

		try (Connection connection = new ConnectionFactory().getConnection()) {
			
			ProductPersistence productPersistence = new ProductPersistence(connection);
			productPersistence.save(product);
			System.out.println();
			List<ProductDAO> listProducts = productPersistence.list();
		}
	}
}
