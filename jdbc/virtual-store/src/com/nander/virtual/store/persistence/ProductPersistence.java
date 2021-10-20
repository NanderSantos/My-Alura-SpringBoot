package com.nander.virtual.store.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.nander.virtual.store.dao.ProductDAO;

public class ProductPersistence {

	private Connection connection;

	public ProductPersistence(Connection connection) {

		this.connection = connection;
	}

	public void save(ProductDAO product) throws SQLException {

		String query = "INSERT INTO PRODUCT (name, description) VALUES (?, ?)";
		System.out.println(query);

		try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

			statement.setString(1, product.getName());
			statement.setString(2, product.getDescription());

			statement.execute();

			try (ResultSet generatedKeys = statement.getGeneratedKeys()) {

				while (generatedKeys.next()) {

					product.setId(generatedKeys.getInt(1));
				}
			}

			System.out.println(product);
		}
	}

	public List<ProductDAO> list() throws SQLException {
		
		List<ProductDAO> listProducts = new ArrayList<>();
		
		String query = "SELECT id, name, description FROM PRODUCT";
		System.out.println(query);

		try(PreparedStatement statement = connection.prepareStatement(query)) {

			statement.execute();
			ResultSet resultSet = statement.getResultSet();
			
			while(resultSet.next()) {
				
				Integer id = resultSet.getInt("id");
				String description = resultSet.getString("description");
				String name = resultSet.getString("name");
			
				ProductDAO product = new ProductDAO(id, name, description);

				listProducts.add(product);
			}

			listProducts.forEach(System.out::println);
		}
		
		return listProducts;
	}
}
