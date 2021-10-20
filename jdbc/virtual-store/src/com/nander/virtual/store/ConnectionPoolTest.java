package com.nander.virtual.store;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPoolTest {
	
	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();

		for (int i = 0; i < 20; i++) {
			
			Connection connection = connectionFactory.getConnection();
			System.out.println("Conexão de número: " + i);
			// connection.close();
		}
	}
}
