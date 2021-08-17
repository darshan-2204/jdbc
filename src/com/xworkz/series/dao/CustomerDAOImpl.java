package com.xworkz.series.dao;

import static com.xworkz.series.constants.JdbcConstant.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

import com.xworkz.series.constants.Education;
import com.xworkz.series.dto.CustomerDTO;

public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public int save(CustomerDTO dto) {
		System.out.println(dto);
		Connection tempConnection = null;
		int temp = 0;
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			tempConnection = connection;
			connection.setAutoCommit(false);
			String query = "insert into transformers.customer_table(c_name,c_from,c_to,c_address,c_married,c_passportNo,c_education)values(?,?,?,?,?,?,?)";
			PreparedStatement pre = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			createFromPrepareStatement(dto,pre);
			ResultSet res=pre.getGeneratedKeys();
			if (res.next()) {
				temp = res.getInt(1);
			}
			System.out.println(temp);
			dto.setId(temp);
			pre.execute();
			connection.commit();
			System.out.println(dto);
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				tempConnection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return temp;
	}

	@Override
	public void saveAll(Collection<CustomerDTO> collection) {
		/*Connection tempConnection = null;
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			tempConnection = connection;
			connection.setAutoCommit(false);
			String query = "insert into transformers.customer_table(c_name,c_from,c_to,c_address,c_married,c_passportNo,c_education)values(?,?,?,?,?,?,?)";
			PreparedStatement pre = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			collection.forEach(dto -> {
				try {
					pre.setString(1, dto.getName());
					pre.setString(2, dto.getFrom());
					pre.setString(3, dto.getTo());
					pre.setString(4, dto.getAddress());
					pre.setBoolean(5, dto.isMarried());
					pre.setInt(6, dto.getPassportNo());
					pre.setString(7, dto.getEducation().toString());
					pre.execute();
					System.out.println(dto);
				} catch (Exception e) {
				}
			});
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				tempConnection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}*/
		
		collection.stream().forEach(dto-> save(dto));
	}
	
	private void createFromPrepareStatement(CustomerDTO dto, PreparedStatement pre) throws SQLException {
		pre.setString(1, dto.getName());
		pre.setString(2, dto.getFrom());
		pre.setString(3, dto.getTo());
		pre.setString(4, dto.getAddress());
		pre.setBoolean(5, dto.isMarried());
		pre.setInt(6, dto.getPassportNo());
		pre.setString(7, dto.getEducation().toString());
		pre.execute();
	}

	@Override
	public Optional<CustomerDTO> findOne(Predicate<CustomerDTO> predicate) {
		Optional<CustomerDTO> optional = Optional.empty();
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			String query = "select * from transformers.customer_table";
			PreparedStatement prepare = connection.prepareStatement(query);
			ResultSet result = prepare.executeQuery();

			while (result.next()) {
				CustomerDTO dto = createValuesFromResultSet(result);
				if (predicate.test(dto)) {
					optional = Optional.of(dto);
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return optional;
	}

	private CustomerDTO createValuesFromResultSet(ResultSet result) throws SQLException {

		int id = result.getInt("c_id");
		String name = result.getString("c_name");
		String from = result.getString("c_from");
		String to = result.getString("c_to");
		String address = result.getString("c_address");
		Boolean married = result.getBoolean("c_married");
		int passportNo = result.getInt("c_passportNo");
		String education = result.getString("c_education");
		CustomerDTO dto = new CustomerDTO(name, from, to, address, married, passportNo, Education.valueOf(education));
		dto.setId(id);
		return dto;
	}

	@Override
	public Collection<CustomerDTO> findAll() {
		Collection<CustomerDTO> collection = new ArrayList<CustomerDTO>();

		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			String query = "select * from transformers.customer_table";
			PreparedStatement prepare = connection.prepareStatement(query);
			ResultSet result = prepare.executeQuery();

			while (result.next()) {
				int id = result.getInt("c_id");
				CustomerDTO dto = createValuesFromResultSet(result);
				collection.add(dto);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return collection;
	}

	@Override
	public Collection<CustomerDTO> findAll(Predicate<CustomerDTO> predicate) {
		Collection<CustomerDTO> collection = new ArrayList<CustomerDTO>();

		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			String query = "select  * from transformers.customer_table";
			PreparedStatement prepare = connection.prepareStatement(query);
			ResultSet result = prepare.executeQuery();

			while (result.next()) {
				CustomerDTO dto = createValuesFromResultSet(result);
				if(predicate.test(dto)) {
								collection.add(dto);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return collection;
	}

	@Override
	public Collection<CustomerDTO> findAllSortNameDesc() {
		Collection<CustomerDTO> collection = new ArrayList<CustomerDTO>();
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

			String query = "select * from transformers.customer_table order by c_name desc";
			PreparedStatement prepare = connection.prepareStatement(query);
			ResultSet result = prepare.executeQuery();
			while (result.next()) {
				CustomerDTO dto = createValuesFromResultSet(result);
				collection.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return collection;
	}

	@Override
	public int total() {
		int total = 0;
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			String query = "select count(c_name) from transformers.customer_table";
			PreparedStatement prepare = connection.prepareStatement(query);
			prepare.execute();
			ResultSet result = prepare.executeQuery();
			if (result.next()) {
				total = result.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return total;
	}
}
