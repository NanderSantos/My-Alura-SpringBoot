package com.nander.virtual.store;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.nander.virtual.store.dao.CategoryDAO;
import com.nander.virtual.store.factory.ConnectionFactory;
import com.nander.virtual.store.repository.CategoryRepository;

public class CategoryListTest {
	
	public static void main(String[] args) throws SQLException {
		
		try(Connection connection = new ConnectionFactory().getConnection()) {

			CategoryRepository categoryRepository = new CategoryRepository(connection);
			List<CategoryDAO> categoryList = categoryRepository.listWithProducts();
		}
	}
}
