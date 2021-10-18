package com.nander.virtual.store;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {
	
	private final static String databseName = "virtual_store";
	private final static String user = "root";
	private final static String password = "root";
	private final static String url = "jdbc:mysql://localhost:3306/" + TestConnection.databseName + "?useTimezone=true&serverTimezone=UTC";

	public static void main(String[] args) throws SQLException {
		
		System.out.println("Abrindo conexão com o banco: " + TestConnection.databseName);
		Connection connection = DriverManager.getConnection(url, user, password);
		System.out.println("Conexão aberta!");

		

		System.out.println("Fechando conexão com o banco: " + TestConnection.databseName);
		connection.close();
	}
}
