package br.recife.edu.ifpe.padaria.model.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	private static final String URL = "jdbc:mysql://localhost:3306/padaria";
	private static final String USER = "root"; // Usuario do banco
	private static final String PASSWORD = ""; // Senha do banco

	private static Connection conn = null;

	static Connection getCurrentConnection() throws SQLException {

		if (conn == null)
			conn = DriverManager.getConnection(URL, USER, PASSWORD);

		return conn;

	}

	static Connection getNewConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}

}
