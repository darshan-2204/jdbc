package com.darshantechnologies.mysqlconnection.tester;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Jdbc {
	public static void main(String[] args) {

		String username = "root";
		String password = "7892441472hp";
		String url = "jdbc:mysql://localhost:3306/transformers";
		String fqnOfDriverImpl = "com.mysql.cj.jdbc.Driver";

		try {
			Class.forName(fqnOfDriverImpl);
			Connection connection = DriverManager.getConnection(url, username, password);
			System.out.println(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}

