package com.xworkz.series.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

import com.xworkz.series.constants.Genre;
import com.xworkz.series.constants.StreamedIn;
import com.xworkz.series.dto.WebseriesDTO;

import static com.xworkz.series.constants.JdbcConstant.*;

public class WebseriesDAOImpl implements WebseriesDAO{

	@Override
	public int save(WebseriesDTO dto) {
		int aiId = 0;
		System.out.println("Saved DTO into DAO: " + dto);
		Connection tempConnection = null;
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			tempConnection = connection;
			connection.setAutoCommit(false);
			String query = "insert into websereis_table(w_name,w_noOfEpisodes,w_totalSeason,w_streamedIn, w_genre,w_yestAgeIndaNodbohudu)VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			ResultSet resultSet = statement.getGeneratedKeys();
			statement.setString(1, dto.getName());
			statement.setInt(2, dto.getNoOfEpisodes());
			statement.setInt(3, dto.getTotalSeason());
			statement.setString(4, dto.getStreamedIn().toString());
			statement.setString(5, dto.getGenre().toString());
			statement.setInt(6, dto.getYestAgeIndaNodbohudu());
			if (resultSet.next()) {
				aiId = resultSet.getInt(1);
				System.out.println(aiId);

			}
			System.out.println(aiId);
			dto.setId(aiId);
			statement.execute();
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
		return aiId;
	}

	@Override
	public Collection<WebseriesDTO> findAll() {
		Collection cl = new ArrayList();
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			String query = "select * from websereis_table";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				WebseriesDTO ws = createValuesFromResultSet(resultSet);
				cl.add(ws);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cl;
	}

	
	private WebseriesDTO createValuesFromResultSet(ResultSet resultSet) throws SQLException {
		int wid = resultSet.getInt("w_id");
		String wname = resultSet.getString("w_name");
		int wepisodes = resultSet.getInt("w_noOfEpisodes");
		int wseason = resultSet.getInt("w_totalSeason");
		String wstreamed = resultSet.getString("w_streamedIn");
		String wgenre = resultSet.getString("w_genre");
		int wage = resultSet.getInt("w_yestAgeIndaNodbohudu");

		WebseriesDTO ws = new WebseriesDTO(wname, wepisodes, wseason, StreamedIn.valueOf(wstreamed),
				Genre.valueOf(wgenre), wage);
		ws.setId(wid);
		return ws;
	}

	@Override
	public int total() {
		int count = 0;
		try (Connection connect = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			String query = "select count(*) from websereis_table";
			ResultSet set = createdFromPreparedStatement(connect, query);
			while (set.next()) {
				count = set.getInt(1);
			}
			System.out.println("Total : " + count);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	private ResultSet createdFromPreparedStatement(Connection connect, String query) throws SQLException {
		PreparedStatement ps = connect.prepareStatement(query);
		ps.execute();
		ResultSet set = ps.getResultSet();
		return set;
	}

	@Override
	public int findMaxSeason() {
		int maxSeason = 0;
		try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			String query = "select max(w_totalSeason) from websereis_table";
			ResultSet rs = createdFromPreparedStatement(con, query);
			while (rs.next()) {
				maxSeason = rs.getInt(1);

			}
			System.out.println("max season : " + maxSeason);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maxSeason;
	}
	@Override
	public int findMinSeason() {
		int minSeason = 0;
		try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			String query = "select min(w_totalSeason) from websereis_table";
			ResultSet rs = createdFromPreparedStatement(con, query);
			while (rs.next()) {
				minSeason = rs.getInt(1);

			}
			System.out.println("min season : " + minSeason);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return minSeason;
	}

	@Override
	public Collection<WebseriesDTO> findAllSortByNameDesc() {
		Collection coll = new ArrayList();
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			String query = "select * from websereis_table order by w_name desc";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				WebseriesDTO ws = createValuesFromResultSet(resultSet);
				coll.add(ws);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return coll;
	}
	@Override
	public Optional<WebseriesDTO> findOne(Predicate<WebseriesDTO> predicate) {
		Optional<WebseriesDTO> optional = Optional.empty();
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			String query = "select * from websereis_table";
			PreparedStatement prepare = connection.prepareStatement(query);
			ResultSet result = prepare.executeQuery();

			while (result.next()) {
				WebseriesDTO dto = createValuesFromResultSet(result);
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


	@Override
	public Collection<WebseriesDTO> findAll(Predicate<WebseriesDTO> predicate) {
		Collection<WebseriesDTO> list = new ArrayList<WebseriesDTO>();

		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			String query = "select * from websereis_table";
			PreparedStatement prepare = connection.prepareStatement(query);
			ResultSet result = prepare.executeQuery();

			while (result.next()) {
				WebseriesDTO dto = createValuesFromResultSet(result);
				if (predicate.test(dto)) {
					list.add(dto);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return list;
	}

	@Override
	public Collection<WebseriesDTO> saveAll(Collection<WebseriesDTO> collection) {
		Collection<WebseriesDTO> list = new ArrayList<WebseriesDTO>();
		Connection temp = null;
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

			temp = connection;

			String query = "insert into websereis_table(w_name,w_noOfEpisodes,w_totalSeason,w_streamedIn,w_gener,w_yestAgeIndaNodbohudu) values (?,,?,?,?,?,?)";
			PreparedStatement stm = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			ResultSet resultSet = stm.executeQuery();
			
			while (resultSet.next()) {
				int id = resultSet.getInt("w_id");
				/*String name = resultSet.getString("w_name");
				int w_noOfEpisodes = resultSet.getInt("w_noOfEpisodes");
				int w_season = resultSet.getInt("w_totalSeason");
				String w_streamedIn = resultSet.getString("w_+streamedIn");
				String w_gener = resultSet.getString("w_genre");
				int  w_yestAgeIndaNodbohudu = resultSet.getInt("w_yestAgeIndaNodbohudu");*/
				WebseriesDTO dto1 = new WebseriesDTO(name, w_noOfEpisodes, w_season, StreamedIn.valueOf(w_streamedIn),
						Genre.valueOf(w_gener), w_yestAgeIndaNodbohudu);
				dto1.setId(id);
				collection.add(dto1);
			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return collection;
	}
	
	
	}
