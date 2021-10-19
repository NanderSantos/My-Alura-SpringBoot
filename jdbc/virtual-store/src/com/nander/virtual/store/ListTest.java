package com.nander.virtual.store;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ListTest {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.createConnection();

		String query = "SELECT id, name, description FROM PRODUCT";
		Statement statement = connection.createStatement();
		statement.execute(query);
		ResultSet resultSet = statement.getResultSet();

		System.out.println(query);

		while(resultSet.next()) {

			Integer id = resultSet.getInt("id");
			String description = resultSet.getString("description");
			String name = resultSet.getString("name");
			System.out.println("Produto: { id: " + id + ", name: \"" + name + "\", description: \"" + description + "\" }");
		}

		System.out.println("\nFechando conexão com o banco: " + ConnectionFactory.getDatabaseName() + "\n");
		connection.close();
	}
}
