package com.nander.virtual.store;

import java.sql.Connection;
import java.sql.SQLException;

import com.nander.virtual.store.factory.ConnectionFactory;

public class TestConnection {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.getConnection();
		
		System.out.println("Fechando conexão com o banco: " + connectionFactory.getDatabaseName() + "\n");
		connection.close(); 
	}
}
