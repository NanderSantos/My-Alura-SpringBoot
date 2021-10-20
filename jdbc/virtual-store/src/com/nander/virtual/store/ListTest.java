package com.nander.virtual.store;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ListTest {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.getConnection();

		String query = "SELECT id, name, description FROM PRODUCT";
		System.out.println(query);

		PreparedStatement statement = connection.prepareStatement(query);
		statement.execute();
		ResultSet resultSet = statement.getResultSet();

		while(resultSet.next()) {

			Integer id = resultSet.getInt("id");
			String description = resultSet.getString("description");
			String name = resultSet.getString("name");
			System.out.println("Produto: { id: " + id + ", name: \"" + name + "\", description: \"" + description + "\" }");
		}

		System.out.println("\nFechando conexão com o banco: " + connectionFactory.getDatabaseName() + "\n");
		connection.close();
	}
}
