package com.nander.virtual.store;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteTest {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.createConnection();

		String query = "DELETE FROM PRODUCT WHERE id > 2";
		Statement statement = connection.createStatement();
		statement.execute(query);

		System.out.println(query);

		int updatedRows = statement.getUpdateCount();

		System.out.println("Linhas deletadas: " + updatedRows);

		System.out.println("\nFechando conexão com o banco: " + ConnectionFactory.getDatabaseName() + "\n");
		connection.close();
	}
}
