package com.nander.virtual.store;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.nander.virtual.store.factory.ConnectionFactory;

public class InsertTest {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.getConnection();

		String query = "INSERT INTO PRODUCT (name, description) VALUES ('Mouse', 'Mouse sem fio')";
		System.out.println(query);

		Statement statement = connection.createStatement();
		statement.execute(query, Statement.RETURN_GENERATED_KEYS);
		ResultSet resultSet = statement.getGeneratedKeys();

		while(resultSet.next()) {

			Integer id = resultSet.getInt(1);

			System.out.println("Produto criado com id " + id);;
		}

		System.out.println("\nFechando conexão com o banco: " + connectionFactory.getDatabaseName() + "\n");
		connection.close();
	}
}
