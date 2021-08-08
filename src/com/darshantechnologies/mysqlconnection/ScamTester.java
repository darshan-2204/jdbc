package com.darshantechnologies.mysqlconnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.darshantechnologies.mysqlconnection.JdbcConnection;
import com.darshantechnologies.mysqlconnection.dto.ScamDTO;

public class ScamTester {

	public static void main(String[] args) {
		try (Connection connection = DriverManager.getConnection(JdbcConnection.url, JdbcConnection.username,
				JdbcConnection.password)) {

			String query = "select * from scam where s_id>15";
			Statement statement = connection.createStatement();
			statement.execute(query);
			ResultSet result = statement.getResultSet();
			ScamDTO dto = null;
			Collection<ScamDTO> collect = new ArrayList<ScamDTO>();
			while (result.next()) {
				int id = result.getInt("s_id");
				String name = result.getString("s_name");
				String type = result.getString("s_type");
				int year = result.getInt("s_year");
				String by = result.getString("s_by");
				String amount = result.getString("s_amount");
				String location = result.getString("s_location");
				String descript = result.getString("s_description");
				dto = new ScamDTO(id, name, type, year, by, amount, location, descript);
				System.out.println(dto);
				collect.add(dto);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
