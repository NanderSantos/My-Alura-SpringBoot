package com.nander.virtual.store;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertWithParamTest {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		
		/*
		O try-with-resources garante que os recursos serão fechados corretamente após a
		utilização não sendo necessário explicitar o método close() desses recuros, uma
		vez que estes herdam da classe java.lang.AutoCloseable
		*/
		
		try(Connection connection = connectionFactory.createConnection()){

			connection.setAutoCommit(false);
			
			String query = "INSERT INTO PRODUCT (name, description) VALUES (?, ?)";
			System.out.println(query);
			
			try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
				
				addToDatabase("SMART TV", "45 POLEGADAS", statement);
				addToDatabase("RÁDIO", "RÁDIO DE BATERIA", statement);
				
				connection.commit(); // Comita as alterações
				
			} catch (RuntimeException e) {
				
				System.out.println();
				e.printStackTrace();
				
				connection.rollback(); // Descarta as alterações não comitadas
			}
		}		
	}

	private static void addToDatabase(String name, String description, PreparedStatement statement) throws SQLException {
		
		statement.setString(1, name);
		statement.setString(2, description);

		if(name.equals("RÁDIO")) {

			throw new RuntimeException("\nErro: Não foi possível adicionar o produto!");
		}

		statement.execute();
		
		try(ResultSet resultSet = statement.getGeneratedKeys()) {

			
			while(resultSet.next()) {
				
				Integer id = resultSet.getInt(1);
				
				System.out.println("Produto criado com id " + id);;
			}
		}
	}
}
