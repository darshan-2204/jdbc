package com.darshantechnologies.mysqlconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdatescamAmountByNameTester {

	public static void main(String[] args) {
		String username = "root";
		String password = "7892441472hp";
		String url = "jdbc:mysql://localhost:3306/transformers";
		String fqnOfDriverImpl = "com.mysql.cj.jdbc.Driver";

		try (Connection connect = DriverManager.getConnection(url, username, password)) {

			String updateAmountByName = "update scam set s_amount=2648 where s_name='Cobbler Scam'";
			Statement st = connect.createStatement();
			st.execute(updateAmountByName);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
