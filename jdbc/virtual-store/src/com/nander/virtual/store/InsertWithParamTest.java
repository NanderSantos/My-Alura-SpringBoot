package com.nander.virtual.store;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertWithParamTest {

	public static void main(String[] args) throws SQLException {

		String name = "Mouse'";
		String description = "Mouse sem fio); delete from PRODUCT;";

		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.createConnection();

		String query = "INSERT INTO PRODUCT (name, description) VALUES (?, ?)";
		System.out.println(query);

		PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, name);
		statement.setString(2, description);
		statement.execute();
		ResultSet resultSet = statement.getGeneratedKeys();

		while(resultSet.next()) {

			Integer id = resultSet.getInt(1);

			System.out.println("Produto criado com id " + id);;
		}

		System.out.println("\nFechando conexão com o banco: " + ConnectionFactory.getDatabaseName() + "\n");
		connection.close();
	}
}
