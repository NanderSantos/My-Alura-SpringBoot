package com.nander.virtual.store;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.createConnection();
		
		System.out.println("Fechando conexão com o banco: " + ConnectionFactory.getDatabaseName() + "\n");
		connection.close(); 
	}
}
