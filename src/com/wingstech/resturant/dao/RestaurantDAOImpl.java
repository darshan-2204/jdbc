package com.wingstech.resturant.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import com.wingstech.resturant.constant.JdbcConnection;
import com.wingstech.resturant.constant.RestaurantType;
import com.wingstech.resturant.dto.RestaurantDTO;

public class RestaurantDAOImpl  implements RestaurantDAO{

	@Override
	public int save(RestaurantDTO dto) {
		System.out.println("saving dto into DB " + dto);
		Connection tempConnection = null;
		try (Connection connection = DriverManager.getConnection(JdbcConnection.url, JdbcConnection.username,
				JdbcConnection.password)) {
			tempConnection = connection;
			connection.setAutoCommit(false);
			String query = "insert into resturant_table values(1,'" + dto.getName() + "','" + dto.getLocation() + "', '"+ dto.getSpecialFood() + "'," + dto.isBest() + ",'" + dto.getType() + "')";
					
			Statement statement = connection.createStatement();
			statement.execute(query);
			
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				tempConnection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public RestaurantDTO findByName(String name) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			String query = "select * from resturant_table where name='" + name + "'";
			Statement st = conn.createStatement();
			st.execute(query);
			ResultSet set = st.getResultSet();
			if (set.next()) {
				int id = set.getInt("id");
				String rname = set.getString("name");
				String rlocation = set.getString("location");
				String rspcl = set.getString("special food");
				boolean rbest = set.getBoolean("taste");
				String rtype = set.getString("type");

				RestaurantDTO res = new RestaurantDTO( id,rname, rlocation, rspcl, rbest, RestaurantType.valueOf(rtype));
				res.setId(id);
				return res;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Collection<RestaurantDTO> findByType(RestaurantType type) {
		Collection collect = new ArrayList();
		try (Connection con = DriverManager.getConnection(url, username, password)) {
			String str = "select * from resturant_table where type='" + type + "'";
			Statement sta = con.createStatement();
			sta.execute(str);
			ResultSet st = sta.getResultSet();
			if (st.next()) {
				int resid = st.getInt("id");
				String resname = st.getString("name");
				String reslocation = st.getString("location");
				String resspcl = st.getString("special food");
				boolean resbest = st.getBoolean("taste");
				String restype = st.getString("type");

				RestaurantDTO dto = new RestaurantDTO(resid,resname, reslocation, resspcl,resbest,
						RestaurantType.valueOf(restype));
				dto.setId(resid);
				collect.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return collect;
	}
	}

	