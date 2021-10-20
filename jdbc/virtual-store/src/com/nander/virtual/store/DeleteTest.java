package com.nander.virtual.store;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteTest {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.getConnection();

		Integer rowsToDelete = 13;

		String query = "DELETE FROM PRODUCT WHERE id > ?";
		System.out.println(query);

		PreparedStatement statement = connection.prepareStatement(query);
		statement.setInt(1, rowsToDelete);
		statement.execute();

		int updatedRows = statement.getUpdateCount();

		System.out.println("Linhas deletadas: " + updatedRows);

		System.out.println("\nFechando conexão com o banco: " + connectionFactory.getDatabaseName() + "\n");
		connection.close();
	}
}
