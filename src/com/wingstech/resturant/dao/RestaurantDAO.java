package com.wingstech.resturant.dao;

//import static com.wingstech.resturant.constant.JdbcConnection.PASSWORD;


//import static com.wingstech.resturant.constant.JdbcConnection.URL;
//import static com.wingstech.resturant.constant.JdbcConnection.USERNAME;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

import com.wingstech.resturant.constant.RestaurantType;
import com.wingstech.resturant.dto.RestaurantDTO;


public interface RestaurantDAO {

	 String username = "root";
	 String password = "7892441472hp";
	 String url = "jdbc:mysql://localhost:3306/transformers";


	int save(RestaurantDTO dto);

	RestaurantDTO findByName(String name);

	Collection<RestaurantDTO> findByType(RestaurantType type);

	default boolean updateTypeByName(RestaurantType newtype, String name) {
		
		Connection connect = null;
		
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			connect=conn;
			conn.setAutoCommit(false);
			String updatequery = "update resturant_table set type='"+newtype+"'"+ "where name='" + name + "'";
			Statement st = conn.createStatement();
			st.execute(updatequery);
			conn.commit();
			return true;
		}
		 catch (SQLException e) {
			e.printStackTrace();
			try {
				connect.rollback();
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
					
		}
	
		return false;
	}
	
	default boolean deleteByTypeAndName(RestaurantType type,String name) {
		try(Connection connect = DriverManager.getConnection(url, username, password)){
			connect.setAutoCommit(false);
			String query = "delete from resturant_table where type='"+type+"' and name='"+name+"'";
			Statement ste = connect.createStatement();
			ste.execute(query);
			connect.commit();
			return true;
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
	
