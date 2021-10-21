package com.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.model.Vehiculo;
import com.jdbc.util.JdbcDataSource;

public class VehiculoDAO {
	private Connection connection;
	private PreparedStatement statement;
	private ResultSet resultset;

	private String sql;
	private boolean estadoOperacion;

	public boolean save(Vehiculo vehiculo) throws SQLException {
		sql = null;
		estadoOperacion = false;

		connection = JdbcDataSource.getConnection();

		try {
			connection.setAutoCommit(false);
			sql = "INSERT INTO vehiculos (id, placa, marca, modelo, cilindraje, anio, consumo) VALUES (?,?,?,?,?,?,?)";
			statement = connection.prepareStatement(sql);
			statement.setString(1, null);
			statement.setString(2, vehiculo.getPlaca());
			statement.setString(3, vehiculo.getMarca());
			statement.setString(4, vehiculo.getModelo());
			statement.setString(5, vehiculo.getCilindraje());
			statement.setString(6, vehiculo.getAnio());
			statement.setString(7, vehiculo.getConsumo());

			estadoOperacion = statement.executeUpdate() > 0;

			connection.commit();
			statement.close();
			connection.close();

		} catch (SQLException e) {
			connection.rollback();
			statement.close();
			connection.close();
			e.printStackTrace();
		}

		return estadoOperacion;
	}

	public List<Vehiculo> getAll() {
		resultset = null;
		sql = null;
		estadoOperacion = false;

		List<Vehiculo> listaVehiculos = new ArrayList<>();

		connection = JdbcDataSource.getConnection();
		sql = "SELECT * FROM vehiculos";

		try {
			statement = connection.prepareStatement(sql);
			resultset = statement.executeQuery();
			while (resultset.next()) {
				Vehiculo vehiculo = new Vehiculo();
				vehiculo.setId(resultset.getInt(1));
				vehiculo.setPlaca(resultset.getString(2));
				vehiculo.setMarca(resultset.getString(3));
				vehiculo.setModelo(resultset.getString(4));
				vehiculo.setCilindraje(resultset.getString(5));
				vehiculo.setAnio(resultset.getString(6));
				vehiculo.setConsumo(resultset.getString(7));
				listaVehiculos.add(vehiculo);
			}
			statement.close();
			connection.close();

		} catch (Exception e) {

			e.printStackTrace();
		}

		return listaVehiculos;
	}

	public Vehiculo getVehiculo(int id) {
		resultset = null;
		sql = null;

		Vehiculo vehiculo = new Vehiculo();
		connection = JdbcDataSource.getConnection();
		sql = "SELECT * FROM vehiculos WHERE id=?";

		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			resultset = statement.executeQuery();

			while (resultset.next()) {
				vehiculo.setId(resultset.getInt(1));
				vehiculo.setPlaca(resultset.getString(2));
				vehiculo.setMarca(resultset.getString(3));
				vehiculo.setModelo(resultset.getString(4));
				vehiculo.setCilindraje(resultset.getString(5));
				vehiculo.setAnio(resultset.getString(6));
				vehiculo.setConsumo(resultset.getString(7));
			}
			statement.close();
			connection.close();

		} catch (Exception e) {

			e.printStackTrace();
		}

		return vehiculo;
	}

	public boolean delete(int id) throws SQLException {
		sql = null;
		estadoOperacion = false;

		connection = JdbcDataSource.getConnection();
		sql = "DELETE FROM vehiculos WHERE id=?";

		try {
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			estadoOperacion = statement.executeUpdate() > 0;
			connection.commit();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			connection.rollback();
			statement.close();
			connection.close();
			e.printStackTrace();
		}

		return estadoOperacion;
	}

	public boolean update(Vehiculo vehiculo) throws SQLException {
		sql = null;
		estadoOperacion = false;

		connection = JdbcDataSource.getConnection();
		
		try {
			connection.setAutoCommit(false);
			sql = "UPDATE vehiculos SET marca=?, modelo=?, cilindraje=?, anio=?, consumo=? WHERE id =?";
			statement = connection.prepareStatement(sql);

			statement.setString(1, vehiculo.getMarca());
			statement.setString(2, vehiculo.getModelo());
			statement.setString(3, vehiculo.getCilindraje());
			statement.setString(4, vehiculo.getAnio());
			statement.setString(5, vehiculo.getConsumo());
			statement.setInt(6, vehiculo.getId());

			estadoOperacion = statement.executeUpdate() > 0;

			connection.commit();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			connection.rollback();
			statement.close();
			connection.close();
			e.printStackTrace();
		}
		
		return estadoOperacion;
	}

}
