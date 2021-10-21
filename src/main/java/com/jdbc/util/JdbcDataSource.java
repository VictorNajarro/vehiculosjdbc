package com.jdbc.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class JdbcDataSource {

	private static BasicDataSource dataSource = null;

	private static DataSource getDataSource() {

		if (dataSource == null) {
			dataSource = new BasicDataSource();
			dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
			dataSource.setUsername("root");
			dataSource.setPassword("admin");
			dataSource.setUrl("jdbc:mysql://localhost:3306/vehiculosjdbc");
		}

		return dataSource;

	}

	public static Connection getConnection() {
		Connection connection = null;

		try {
			connection = getDataSource().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;
	}

}
