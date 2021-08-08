package com.darshantechnologies.mysqlconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateScamYearByName {

	public static void main(String[] args) {
		String username = "root";
		String password = "7892441472hp";
		String url = "jdbc:mysql://localhost:3306/transformers";
		String fqnOfDriverImpl = "com.mysql.cj.jdbc.Driver";
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			String updateYearByName = "update scam set s_year=2014 where s_name='2G Spectrum Scam'";
			Statement st = conn.createStatement();
			st.execute(updateYearByName);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
