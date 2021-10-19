package com.nander.virtual.store;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private final static String databaseName = "virtual_store";
	private final static String user = "root";
	private final static String password = "root";
	private final static String url = "jdbc:mysql://localhost:3306/" + ConnectionFactory.databaseName + "?useTimezone=true&serverTimezone=UTC";
	
	public Connection createConnection() throws SQLException {

		System.out.println("\nAbrindo conexão com o banco: " + ConnectionFactory.databaseName);
		Connection connection = DriverManager.getConnection(url, user, password);
		System.out.println("Conexão aberta!\n");

		return connection;
	}

	public static String getDatabaseName() {

		return ConnectionFactory.databaseName;
	}
}
