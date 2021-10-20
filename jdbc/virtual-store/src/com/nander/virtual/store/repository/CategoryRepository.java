package com.nander.virtual.store.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.nander.virtual.store.dao.CategoryDAO;
import com.nander.virtual.store.dao.ProductDAO;

public class CategoryRepository {

	private Connection connection;

	public CategoryRepository(Connection connection) {

		this.connection = connection;
	}

	public void save(CategoryDAO category) throws SQLException {

		String query = "INSERT INTO CATEGORY (name) VALUES (?)";
		System.out.println(query);

		try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

			statement.setString(1, category.getName());

			statement.execute();

			try (ResultSet generatedKeys = statement.getGeneratedKeys()) {

				while (generatedKeys.next()) {

					category.setId(generatedKeys.getInt(1));
				}
			}

			System.out.println(category);
		}
	}

	public List<CategoryDAO> list() throws SQLException {
		
		List<CategoryDAO> listCategories = new ArrayList<>();
		
		String query = "SELECT id, name FROM CATEGORY";
		System.out.println(query);

		try(PreparedStatement statement = connection.prepareStatement(query)) {

			statement.execute();
			ResultSet resultSet = statement.getResultSet();
			
			while(resultSet.next()) {
				
				Integer id = resultSet.getInt("id");
				String name = resultSet.getString("name");
			
				CategoryDAO category = new CategoryDAO(id, name);

				listCategories.add(category);
			}
 
			listCategories.forEach(category -> {

				try {
					
					System.out.println(category + "\n");
					List<ProductDAO> productList = new ProductRepository(this.connection).findByCategory(category);
					productList.forEach(System.out::println);
					System.out.println();

				} catch (SQLException e) {

					e.printStackTrace();
				}
			});
		}
		
		return listCategories;
	}

	public List<CategoryDAO> listWithProducts() throws SQLException {
		
		List<CategoryDAO> listCategories = new ArrayList<>();
		
		String query = "SELECT c.id, c.name, p.id, p.name, p.description FROM CATEGORY c INNER JOIN PRODUCT p ON p.CATEGORY_ID = c.id";
		System.out.println(query);

		try(PreparedStatement statement = connection.prepareStatement(query)) {

			statement.execute();
			ResultSet resultSet = statement.getResultSet();
			
			while(resultSet.next()) {
				
				Integer categoryId = resultSet.getInt(1);
				String categoryName = resultSet.getString(2);
				
				Integer productId = resultSet.getInt(3);
				String productName = resultSet.getString(4);
				String productDescription = resultSet.getString(5);

				
			
				CategoryDAO category = new CategoryDAO(categoryId, categoryName);
				Optional<CategoryDAO> optional = listCategories
					.stream()
					.filter(c -> c.getId() == category.getId())
					.findFirst();

				if(optional.isPresent()) {

					optional.get().addProduct(new ProductDAO(productId, productName, productDescription));;

				} else {

					category.addProduct(new ProductDAO(productId, productName, productDescription));
					listCategories.add(category);
				}
			}
 
			listCategories.forEach(System.out::println);
		}
		
		return listCategories;
	}
}
