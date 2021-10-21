package com.jdbc.dao;

import java.sql.SQLException;

import com.jdbc.model.Vehiculo;

public class MainApp {

	public static void main(String[] args) {

		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setId(6);
		vehiculo.setPlaca("ASF-234");
		vehiculo.setMarca("NISSAN");
		vehiculo.setModelo("SENTRA");
		vehiculo.setAnio("2018");
		vehiculo.setCilindraje("3000");
		vehiculo.setConsumo("30");

		VehiculoDAO vehiculoDAO = new VehiculoDAO();
		
		

		/*try {
			if (vehiculoDAO.save(vehiculo)) {
				System.out.println("Vehículo guardado correctamente");
			} else {
				System.out.println("Error al guardar el vehículo");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		for (Vehiculo v : vehiculoDAO.getAll()) {
			System.out.println(v);
		}*/
		
		
		
		//System.out.println(vehiculoDAO.getVehiculo(5));
		
		
		
		/*try {
			if (vehiculoDAO.delete(3)) {
				System.out.println("Registro eliminado correctamente....");
			}else {
				System.out.println("Registro no fue eliminado");
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}*/
		
		
		
		try {
			if (vehiculoDAO.update(vehiculo)) {
				System.out.println("Vehículo actualizado correctamente...");
			} else {
				System.out.println("Vehículo no actualizado.");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		

	}

}
