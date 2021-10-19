package com.nander.virtual.store;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTest {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.createConnection();

		String query = "INSERT INTO PRODUCT (name, description) VALUES ('Mouse', 'Mouse sem fio')";
		Statement statement = connection.createStatement();
		statement.execute(query, Statement.RETURN_GENERATED_KEYS);
		ResultSet resultSet = statement.getGeneratedKeys();

		System.out.println(query);

		while(resultSet.next()) {

			Integer id = resultSet.getInt(1);

			System.out.println("Produto criado com id " + id);;
		}

		System.out.println("\nFechando conexão com o banco: " + ConnectionFactory.getDatabaseName() + "\n");
		connection.close();
	}
}
