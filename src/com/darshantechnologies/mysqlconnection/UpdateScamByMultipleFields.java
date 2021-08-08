package com.darshantechnologies.mysqlconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateScamByMultipleFields {

	public static void main(String[] args) {
		String username = "root";
		String password = "7892441472hp";
		String url = "jdbc:mysql://localhost:3306/transformers";
		String fqnOfDriverImpl = "com.mysql.cj.jdbc.Driver";
		
		try (Connection cn = DriverManager.getConnection(url, username, password)) {
			String updateScamByMultipleFields = "update scam set CommonWealth Games Scam', 'Cheating and forgery', 2010, 'Suresh Kalmadi', '70,000crore', 'India', 'He was accused of corruption and malpractices in the common wealth games'";
			Statement st = cn.createStatement();
			st.execute(updateScamByMultipleFields);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
