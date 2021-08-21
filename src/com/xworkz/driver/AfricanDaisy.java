package com.xworkz.driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AfricanDaisy {

	public static void main(String[] args) {
		String username = "root";
		String password = "7892441472hp";
		String url = "jdbc:mysql://localhost:3306/transformers";
		String fqnOfDriverImpl = "com.mysql.cj.jdbc.Driver";

		Connection connection = null;
		try {
			Class.forName(fqnOfDriverImpl);
			connection = DriverManager.getConnection(url, username, password);
			System.out.println(connection);

			String query = "insert into flower_table values (9,'AfricanDaisy','Blue',false,1,false,'petals','decoration',true,30)";

			Statement statement = connection.createStatement();

			statement.execute(query);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}