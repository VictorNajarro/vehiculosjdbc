package com.jdbc.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainApp {

	public static void main(String[] args) {

		Connection con;
		PreparedStatement pst;
		ResultSet rs;

		con = JdbcDataSource.getConnection();

		try {
			pst = con.prepareStatement("Select version()");
			rs = pst.executeQuery();
			rs.next();
			System.out.println(rs.getString(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
