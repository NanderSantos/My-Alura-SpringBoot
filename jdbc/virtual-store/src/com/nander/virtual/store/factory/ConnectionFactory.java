package com.nander.virtual.store.factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	
	private final String databaseName = "virtual_store";
	private final String user = "root";
	private final String password = "root";
	private final String url = "jdbc:mysql://localhost:3306/" + this.databaseName + "?useTimezone=true&serverTimezone=UTC";

	private DataSource dataSource;
	
	public ConnectionFactory() {

		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl(this.url);
		comboPooledDataSource.setUser(this.user);
		comboPooledDataSource.setPassword(this.password);
		comboPooledDataSource.setMaxPoolSize(10);

		this.dataSource = comboPooledDataSource;
	}
	
	public Connection getConnection() throws SQLException {

		System.out.println("\nAbrindo conexão com o banco: " + this.databaseName + "\n");
		Connection connection = this.dataSource.getConnection();
		System.out.println("\nConexão aberta!\n");

		return connection;
	}

	public String getDatabaseName() {

		return this.databaseName;
	}
}
